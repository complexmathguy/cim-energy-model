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
 * Projector for ActivePower as outlined for the CQRS pattern.  All event handling and query handling related to ActivePower are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ActivePowerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("activePower")
@Component("activePower-projector")
public class ActivePowerProjector extends ActivePowerEntityProjector {
		
	// core constructor
	public ActivePowerProjector(ActivePowerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateActivePowerEvent
     */
    @EventHandler( payloadType=CreateActivePowerEvent.class )
    public void handle( CreateActivePowerEvent event) {
	    LOGGER.info("handling CreateActivePowerEvent - " + event );
	    ActivePower entity = new ActivePower();
        entity.setActivePowerId( event.getActivePowerId() );
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
        emitFindAllActivePower( entity );
    }

    /*
     * @param	event UpdateActivePowerEvent
     */
    @EventHandler( payloadType=UpdateActivePowerEvent.class )
    public void handle( UpdateActivePowerEvent event) {
    	LOGGER.info("handling UpdateActivePowerEvent - " + event );
    	
	    ActivePower entity = new ActivePower();
        entity.setActivePowerId( event.getActivePowerId() );
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
        emitFindActivePower( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllActivePower( entity );        
    }
    
    /*
     * @param	event DeleteActivePowerEvent
     */
    @EventHandler( payloadType=DeleteActivePowerEvent.class )
    public void handle( DeleteActivePowerEvent event) {
    	LOGGER.info("handling DeleteActivePowerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ActivePower entity = delete( event.getActivePowerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllActivePower( entity );

    }    




    /**
     * Method to retrieve the ActivePower via an ActivePowerPrimaryKey.
     * @param 	id Long
     * @return 	ActivePower
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ActivePower handle( FindActivePowerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getActivePowerId() );
    }
    
    /**
     * Method to retrieve a collection of all ActivePowers
     *
     * @param	query	FindAllActivePowerQuery 
     * @return 	List<ActivePower> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ActivePower> handle( FindAllActivePowerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindActivePower, 
	 * but only if the id matches
	 * 
	 * @param		entity	ActivePower
	 */
	protected void emitFindActivePower( ActivePower entity ) {
		LOGGER.info("handling emitFindActivePower" );
		
	    queryUpdateEmitter.emit(FindActivePowerQuery.class,
	                            query -> query.getFilter().getActivePowerId().equals(entity.getActivePowerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllActivePower
	 * 
	 * @param		entity	ActivePower
	 */
	protected void emitFindAllActivePower( ActivePower entity ) {
		LOGGER.info("handling emitFindAllActivePower" );
		
	    queryUpdateEmitter.emit(FindAllActivePowerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerProjector.class.getName());

}
