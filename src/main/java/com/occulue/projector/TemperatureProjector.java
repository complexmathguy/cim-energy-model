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
 * Projector for Temperature as outlined for the CQRS pattern.  All event handling and query handling related to Temperature are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TemperatureAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("temperature")
@Component("temperature-projector")
public class TemperatureProjector extends TemperatureEntityProjector {
		
	// core constructor
	public TemperatureProjector(TemperatureRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTemperatureEvent
     */
    @EventHandler( payloadType=CreateTemperatureEvent.class )
    public void handle( CreateTemperatureEvent event) {
	    LOGGER.info("handling CreateTemperatureEvent - " + event );
	    Temperature entity = new Temperature();
        entity.setTemperatureId( event.getTemperatureId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTemperature( entity );
    }

    /*
     * @param	event UpdateTemperatureEvent
     */
    @EventHandler( payloadType=UpdateTemperatureEvent.class )
    public void handle( UpdateTemperatureEvent event) {
    	LOGGER.info("handling UpdateTemperatureEvent - " + event );
    	
	    Temperature entity = new Temperature();
        entity.setTemperatureId( event.getTemperatureId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTemperature( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTemperature( entity );        
    }
    
    /*
     * @param	event DeleteTemperatureEvent
     */
    @EventHandler( payloadType=DeleteTemperatureEvent.class )
    public void handle( DeleteTemperatureEvent event) {
    	LOGGER.info("handling DeleteTemperatureEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Temperature entity = delete( event.getTemperatureId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTemperature( entity );

    }    




    /**
     * Method to retrieve the Temperature via an TemperaturePrimaryKey.
     * @param 	id Long
     * @return 	Temperature
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Temperature handle( FindTemperatureQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTemperatureId() );
    }
    
    /**
     * Method to retrieve a collection of all Temperatures
     *
     * @param	query	FindAllTemperatureQuery 
     * @return 	List<Temperature> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Temperature> handle( FindAllTemperatureQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTemperature, 
	 * but only if the id matches
	 * 
	 * @param		entity	Temperature
	 */
	protected void emitFindTemperature( Temperature entity ) {
		LOGGER.info("handling emitFindTemperature" );
		
	    queryUpdateEmitter.emit(FindTemperatureQuery.class,
	                            query -> query.getFilter().getTemperatureId().equals(entity.getTemperatureId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTemperature
	 * 
	 * @param		entity	Temperature
	 */
	protected void emitFindAllTemperature( Temperature entity ) {
		LOGGER.info("handling emitFindAllTemperature" );
		
	    queryUpdateEmitter.emit(FindAllTemperatureQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TemperatureProjector.class.getName());

}
