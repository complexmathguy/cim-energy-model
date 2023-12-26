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
 * Projector for StringMeasurementValue as outlined for the CQRS pattern.  All event handling and query handling related to StringMeasurementValue are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StringMeasurementValueAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("stringMeasurementValue")
@Component("stringMeasurementValue-projector")
public class StringMeasurementValueProjector extends StringMeasurementValueEntityProjector {
		
	// core constructor
	public StringMeasurementValueProjector(StringMeasurementValueRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStringMeasurementValueEvent
     */
    @EventHandler( payloadType=CreateStringMeasurementValueEvent.class )
    public void handle( CreateStringMeasurementValueEvent event) {
	    LOGGER.info("handling CreateStringMeasurementValueEvent - " + event );
	    StringMeasurementValue entity = new StringMeasurementValue();
        entity.setStringMeasurementValueId( event.getStringMeasurementValueId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurementValue( entity );
    }

    /*
     * @param	event UpdateStringMeasurementValueEvent
     */
    @EventHandler( payloadType=UpdateStringMeasurementValueEvent.class )
    public void handle( UpdateStringMeasurementValueEvent event) {
    	LOGGER.info("handling UpdateStringMeasurementValueEvent - " + event );
    	
	    StringMeasurementValue entity = new StringMeasurementValue();
        entity.setStringMeasurementValueId( event.getStringMeasurementValueId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStringMeasurementValue( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurementValue( entity );        
    }
    
    /*
     * @param	event DeleteStringMeasurementValueEvent
     */
    @EventHandler( payloadType=DeleteStringMeasurementValueEvent.class )
    public void handle( DeleteStringMeasurementValueEvent event) {
    	LOGGER.info("handling DeleteStringMeasurementValueEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StringMeasurementValue entity = delete( event.getStringMeasurementValueId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringMeasurementValue( entity );

    }    




    /**
     * Method to retrieve the StringMeasurementValue via an StringMeasurementValuePrimaryKey.
     * @param 	id Long
     * @return 	StringMeasurementValue
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StringMeasurementValue handle( FindStringMeasurementValueQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStringMeasurementValueId() );
    }
    
    /**
     * Method to retrieve a collection of all StringMeasurementValues
     *
     * @param	query	FindAllStringMeasurementValueQuery 
     * @return 	List<StringMeasurementValue> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StringMeasurementValue> handle( FindAllStringMeasurementValueQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStringMeasurementValue, 
	 * but only if the id matches
	 * 
	 * @param		entity	StringMeasurementValue
	 */
	protected void emitFindStringMeasurementValue( StringMeasurementValue entity ) {
		LOGGER.info("handling emitFindStringMeasurementValue" );
		
	    queryUpdateEmitter.emit(FindStringMeasurementValueQuery.class,
	                            query -> query.getFilter().getStringMeasurementValueId().equals(entity.getStringMeasurementValueId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStringMeasurementValue
	 * 
	 * @param		entity	StringMeasurementValue
	 */
	protected void emitFindAllStringMeasurementValue( StringMeasurementValue entity ) {
		LOGGER.info("handling emitFindAllStringMeasurementValue" );
		
	    queryUpdateEmitter.emit(FindAllStringMeasurementValueQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StringMeasurementValueProjector.class.getName());

}
