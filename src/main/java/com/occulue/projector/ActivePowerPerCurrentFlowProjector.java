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
 * Projector for ActivePowerPerCurrentFlow as outlined for the CQRS pattern.  All event handling and query handling related to ActivePowerPerCurrentFlow are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ActivePowerPerCurrentFlowAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("activePowerPerCurrentFlow")
@Component("activePowerPerCurrentFlow-projector")
public class ActivePowerPerCurrentFlowProjector extends ActivePowerPerCurrentFlowEntityProjector {
		
	// core constructor
	public ActivePowerPerCurrentFlowProjector(ActivePowerPerCurrentFlowRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateActivePowerPerCurrentFlowEvent
     */
    @EventHandler( payloadType=CreateActivePowerPerCurrentFlowEvent.class )
    public void handle( CreateActivePowerPerCurrentFlowEvent event) {
	    LOGGER.info("handling CreateActivePowerPerCurrentFlowEvent - " + event );
	    ActivePowerPerCurrentFlow entity = new ActivePowerPerCurrentFlow();
        entity.setActivePowerPerCurrentFlowId( event.getActivePowerPerCurrentFlowId() );
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
        emitFindAllActivePowerPerCurrentFlow( entity );
    }

    /*
     * @param	event UpdateActivePowerPerCurrentFlowEvent
     */
    @EventHandler( payloadType=UpdateActivePowerPerCurrentFlowEvent.class )
    public void handle( UpdateActivePowerPerCurrentFlowEvent event) {
    	LOGGER.info("handling UpdateActivePowerPerCurrentFlowEvent - " + event );
    	
	    ActivePowerPerCurrentFlow entity = new ActivePowerPerCurrentFlow();
        entity.setActivePowerPerCurrentFlowId( event.getActivePowerPerCurrentFlowId() );
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
        emitFindActivePowerPerCurrentFlow( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllActivePowerPerCurrentFlow( entity );        
    }
    
    /*
     * @param	event DeleteActivePowerPerCurrentFlowEvent
     */
    @EventHandler( payloadType=DeleteActivePowerPerCurrentFlowEvent.class )
    public void handle( DeleteActivePowerPerCurrentFlowEvent event) {
    	LOGGER.info("handling DeleteActivePowerPerCurrentFlowEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ActivePowerPerCurrentFlow entity = delete( event.getActivePowerPerCurrentFlowId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllActivePowerPerCurrentFlow( entity );

    }    




    /**
     * Method to retrieve the ActivePowerPerCurrentFlow via an ActivePowerPerCurrentFlowPrimaryKey.
     * @param 	id Long
     * @return 	ActivePowerPerCurrentFlow
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ActivePowerPerCurrentFlow handle( FindActivePowerPerCurrentFlowQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getActivePowerPerCurrentFlowId() );
    }
    
    /**
     * Method to retrieve a collection of all ActivePowerPerCurrentFlows
     *
     * @param	query	FindAllActivePowerPerCurrentFlowQuery 
     * @return 	List<ActivePowerPerCurrentFlow> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ActivePowerPerCurrentFlow> handle( FindAllActivePowerPerCurrentFlowQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindActivePowerPerCurrentFlow, 
	 * but only if the id matches
	 * 
	 * @param		entity	ActivePowerPerCurrentFlow
	 */
	protected void emitFindActivePowerPerCurrentFlow( ActivePowerPerCurrentFlow entity ) {
		LOGGER.info("handling emitFindActivePowerPerCurrentFlow" );
		
	    queryUpdateEmitter.emit(FindActivePowerPerCurrentFlowQuery.class,
	                            query -> query.getFilter().getActivePowerPerCurrentFlowId().equals(entity.getActivePowerPerCurrentFlowId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllActivePowerPerCurrentFlow
	 * 
	 * @param		entity	ActivePowerPerCurrentFlow
	 */
	protected void emitFindAllActivePowerPerCurrentFlow( ActivePowerPerCurrentFlow entity ) {
		LOGGER.info("handling emitFindAllActivePowerPerCurrentFlow" );
		
	    queryUpdateEmitter.emit(FindAllActivePowerPerCurrentFlowQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerPerCurrentFlowProjector.class.getName());

}
