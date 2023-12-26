/*******************************************************************************
  Turnstone Biologics Confidential
  
  2018 Turnstone Biologics
  All Rights Reserved.
  
  This file is subject to the terms and conditions defined in
  file 'license.txt', which is part of this source code package.
   
  Contributors :
        Turnstone Biologics - General Release
 ******************************************************************************/
package com.occulue.projector;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for StringMeasurement as outlined for the CQRS pattern.  All event handling and query handling related to StringMeasurement are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StringMeasurementAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("stringMeasurement")
@Component("stringMeasurement-projector")
public class StringMeasurementProjector extends StringMeasurementEntityProjector {
		
	// core constructor
	public StringMeasurementProjector(StringMeasurementRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStringMeasurementEvent
     */
    @EventHandler( payloadType=CreateStringMeasurementEvent.class )
    public void handle( CreateStringMeasurementEvent event) {
	    LOGGER.info("handling CreateStringMeasurementEvent - " + event );
	    StringMeasurement entity = new StringMeasurement();
        entity.setStringMeasurementId( event.getStringMeasurementId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurement( entity );
    }

    /*
     * @param	event UpdateStringMeasurementEvent
     */
    @EventHandler( payloadType=UpdateStringMeasurementEvent.class )
    public void handle( UpdateStringMeasurementEvent event) {
    	LOGGER.info("handling UpdateStringMeasurementEvent - " + event );
    	
	    StringMeasurement entity = new StringMeasurement();
        entity.setStringMeasurementId( event.getStringMeasurementId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStringMeasurement( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurement( entity );        
    }
    
    /*
     * @param	event DeleteStringMeasurementEvent
     */
    @EventHandler( payloadType=DeleteStringMeasurementEvent.class )
    public void handle( DeleteStringMeasurementEvent event) {
    	LOGGER.info("handling DeleteStringMeasurementEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StringMeasurement entity = delete( event.getStringMeasurementId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurement( entity );

    }    




    /**
     * Method to retrieve the StringMeasurement via an StringMeasurementPrimaryKey.
     * @param 	id Long
     * @return 	StringMeasurement
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StringMeasurement handle( FindStringMeasurementQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStringMeasurementId() );
    }
    
    /**
     * Method to retrieve a collection of all StringMeasurements
     *
     * @param	query	FindAllStringMeasurementQuery 
     * @return 	List<StringMeasurement> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StringMeasurement> handle( FindAllStringMeasurementQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStringMeasurement, 
	 * but only if the id matches
	 * 
	 * @param		entity	StringMeasurement
	 */
	protected void emitFindStringMeasurement( StringMeasurement entity ) {
		LOGGER.info("handling emitFindStringMeasurement" );
		
	    queryUpdateEmitter.emit(FindStringMeasurementQuery.class,
	                            query -> query.getFilter().getStringMeasurementId().equals(entity.getStringMeasurementId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStringMeasurement
	 * 
	 * @param		entity	StringMeasurement
	 */
	protected void emitFindAllStringMeasurement( StringMeasurement entity ) {
		LOGGER.info("handling emitFindAllStringMeasurement" );
		
	    queryUpdateEmitter.emit(FindAllStringMeasurementQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StringMeasurementProjector.class.getName());

}
