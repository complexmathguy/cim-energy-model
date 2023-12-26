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
 * Projector for MeasurementValue as outlined for the CQRS pattern.  All event handling and query handling related to MeasurementValue are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MeasurementValueAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("measurementValue")
@Component("measurementValue-projector")
public class MeasurementValueProjector extends MeasurementValueEntityProjector {
		
	// core constructor
	public MeasurementValueProjector(MeasurementValueRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMeasurementValueEvent
     */
    @EventHandler( payloadType=CreateMeasurementValueEvent.class )
    public void handle( CreateMeasurementValueEvent event) {
	    LOGGER.info("handling CreateMeasurementValueEvent - " + event );
	    MeasurementValue entity = new MeasurementValue();
        entity.setMeasurementValueId( event.getMeasurementValueId() );
        entity.setSensorAccuracy( event.getSensorAccuracy() );
        entity.setTimeStamp( event.getTimeStamp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValue( entity );
    }

    /*
     * @param	event UpdateMeasurementValueEvent
     */
    @EventHandler( payloadType=UpdateMeasurementValueEvent.class )
    public void handle( UpdateMeasurementValueEvent event) {
    	LOGGER.info("handling UpdateMeasurementValueEvent - " + event );
    	
	    MeasurementValue entity = new MeasurementValue();
        entity.setMeasurementValueId( event.getMeasurementValueId() );
        entity.setSensorAccuracy( event.getSensorAccuracy() );
        entity.setTimeStamp( event.getTimeStamp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMeasurementValue( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValue( entity );        
    }
    
    /*
     * @param	event DeleteMeasurementValueEvent
     */
    @EventHandler( payloadType=DeleteMeasurementValueEvent.class )
    public void handle( DeleteMeasurementValueEvent event) {
    	LOGGER.info("handling DeleteMeasurementValueEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MeasurementValue entity = delete( event.getMeasurementValueId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValue( entity );

    }    




    /**
     * Method to retrieve the MeasurementValue via an MeasurementValuePrimaryKey.
     * @param 	id Long
     * @return 	MeasurementValue
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MeasurementValue handle( FindMeasurementValueQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMeasurementValueId() );
    }
    
    /**
     * Method to retrieve a collection of all MeasurementValues
     *
     * @param	query	FindAllMeasurementValueQuery 
     * @return 	List<MeasurementValue> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MeasurementValue> handle( FindAllMeasurementValueQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMeasurementValue, 
	 * but only if the id matches
	 * 
	 * @param		entity	MeasurementValue
	 */
	protected void emitFindMeasurementValue( MeasurementValue entity ) {
		LOGGER.info("handling emitFindMeasurementValue" );
		
	    queryUpdateEmitter.emit(FindMeasurementValueQuery.class,
	                            query -> query.getFilter().getMeasurementValueId().equals(entity.getMeasurementValueId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMeasurementValue
	 * 
	 * @param		entity	MeasurementValue
	 */
	protected void emitFindAllMeasurementValue( MeasurementValue entity ) {
		LOGGER.info("handling emitFindAllMeasurementValue" );
		
	    queryUpdateEmitter.emit(FindAllMeasurementValueQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueProjector.class.getName());

}
