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
 * Projector for RotationSpeed as outlined for the CQRS pattern.  All event handling and query handling related to RotationSpeed are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RotationSpeedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("rotationSpeed")
@Component("rotationSpeed-projector")
public class RotationSpeedProjector extends RotationSpeedEntityProjector {
		
	// core constructor
	public RotationSpeedProjector(RotationSpeedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRotationSpeedEvent
     */
    @EventHandler( payloadType=CreateRotationSpeedEvent.class )
    public void handle( CreateRotationSpeedEvent event) {
	    LOGGER.info("handling CreateRotationSpeedEvent - " + event );
	    RotationSpeed entity = new RotationSpeed();
        entity.setRotationSpeedId( event.getRotationSpeedId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
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
        emitFindAllRotationSpeed( entity );
    }

    /*
     * @param	event UpdateRotationSpeedEvent
     */
    @EventHandler( payloadType=UpdateRotationSpeedEvent.class )
    public void handle( UpdateRotationSpeedEvent event) {
    	LOGGER.info("handling UpdateRotationSpeedEvent - " + event );
    	
	    RotationSpeed entity = new RotationSpeed();
        entity.setRotationSpeedId( event.getRotationSpeedId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
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
        emitFindRotationSpeed( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRotationSpeed( entity );        
    }
    
    /*
     * @param	event DeleteRotationSpeedEvent
     */
    @EventHandler( payloadType=DeleteRotationSpeedEvent.class )
    public void handle( DeleteRotationSpeedEvent event) {
    	LOGGER.info("handling DeleteRotationSpeedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RotationSpeed entity = delete( event.getRotationSpeedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRotationSpeed( entity );

    }    




    /**
     * Method to retrieve the RotationSpeed via an RotationSpeedPrimaryKey.
     * @param 	id Long
     * @return 	RotationSpeed
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RotationSpeed handle( FindRotationSpeedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRotationSpeedId() );
    }
    
    /**
     * Method to retrieve a collection of all RotationSpeeds
     *
     * @param	query	FindAllRotationSpeedQuery 
     * @return 	List<RotationSpeed> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RotationSpeed> handle( FindAllRotationSpeedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRotationSpeed, 
	 * but only if the id matches
	 * 
	 * @param		entity	RotationSpeed
	 */
	protected void emitFindRotationSpeed( RotationSpeed entity ) {
		LOGGER.info("handling emitFindRotationSpeed" );
		
	    queryUpdateEmitter.emit(FindRotationSpeedQuery.class,
	                            query -> query.getFilter().getRotationSpeedId().equals(entity.getRotationSpeedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRotationSpeed
	 * 
	 * @param		entity	RotationSpeed
	 */
	protected void emitFindAllRotationSpeed( RotationSpeed entity ) {
		LOGGER.info("handling emitFindAllRotationSpeed" );
		
	    queryUpdateEmitter.emit(FindAllRotationSpeedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RotationSpeedProjector.class.getName());

}
