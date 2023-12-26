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
 * Projector for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.  All event handling and query handling related to AsynchronousMachineTimeConstantReactance are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AsynchronousMachineTimeConstantReactanceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("asynchronousMachineTimeConstantReactance")
@Component("asynchronousMachineTimeConstantReactance-projector")
public class AsynchronousMachineTimeConstantReactanceProjector extends AsynchronousMachineTimeConstantReactanceEntityProjector {
		
	// core constructor
	public AsynchronousMachineTimeConstantReactanceProjector(AsynchronousMachineTimeConstantReactanceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAsynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=CreateAsynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( CreateAsynchronousMachineTimeConstantReactanceEvent event) {
	    LOGGER.info("handling CreateAsynchronousMachineTimeConstantReactanceEvent - " + event );
	    AsynchronousMachineTimeConstantReactance entity = new AsynchronousMachineTimeConstantReactance();
        entity.setAsynchronousMachineTimeConstantReactanceId( event.getAsynchronousMachineTimeConstantReactanceId() );
        entity.setTpo( event.getTpo() );
        entity.setTppo( event.getTppo() );
        entity.setXp( event.getXp() );
        entity.setXpp( event.getXpp() );
        entity.setXs( event.getXs() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineTimeConstantReactance( entity );
    }

    /*
     * @param	event UpdateAsynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=UpdateAsynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( UpdateAsynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info("handling UpdateAsynchronousMachineTimeConstantReactanceEvent - " + event );
    	
	    AsynchronousMachineTimeConstantReactance entity = new AsynchronousMachineTimeConstantReactance();
        entity.setAsynchronousMachineTimeConstantReactanceId( event.getAsynchronousMachineTimeConstantReactanceId() );
        entity.setTpo( event.getTpo() );
        entity.setTppo( event.getTppo() );
        entity.setXp( event.getXp() );
        entity.setXpp( event.getXpp() );
        entity.setXs( event.getXs() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAsynchronousMachineTimeConstantReactance( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineTimeConstantReactance( entity );        
    }
    
    /*
     * @param	event DeleteAsynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=DeleteAsynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( DeleteAsynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info("handling DeleteAsynchronousMachineTimeConstantReactanceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AsynchronousMachineTimeConstantReactance entity = delete( event.getAsynchronousMachineTimeConstantReactanceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineTimeConstantReactance( entity );

    }    




    /**
     * Method to retrieve the AsynchronousMachineTimeConstantReactance via an AsynchronousMachineTimeConstantReactancePrimaryKey.
     * @param 	id Long
     * @return 	AsynchronousMachineTimeConstantReactance
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AsynchronousMachineTimeConstantReactance handle( FindAsynchronousMachineTimeConstantReactanceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAsynchronousMachineTimeConstantReactanceId() );
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineTimeConstantReactances
     *
     * @param	query	FindAllAsynchronousMachineTimeConstantReactanceQuery 
     * @return 	List<AsynchronousMachineTimeConstantReactance> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AsynchronousMachineTimeConstantReactance> handle( FindAllAsynchronousMachineTimeConstantReactanceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAsynchronousMachineTimeConstantReactance, 
	 * but only if the id matches
	 * 
	 * @param		entity	AsynchronousMachineTimeConstantReactance
	 */
	protected void emitFindAsynchronousMachineTimeConstantReactance( AsynchronousMachineTimeConstantReactance entity ) {
		LOGGER.info("handling emitFindAsynchronousMachineTimeConstantReactance" );
		
	    queryUpdateEmitter.emit(FindAsynchronousMachineTimeConstantReactanceQuery.class,
	                            query -> query.getFilter().getAsynchronousMachineTimeConstantReactanceId().equals(entity.getAsynchronousMachineTimeConstantReactanceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAsynchronousMachineTimeConstantReactance
	 * 
	 * @param		entity	AsynchronousMachineTimeConstantReactance
	 */
	protected void emitFindAllAsynchronousMachineTimeConstantReactance( AsynchronousMachineTimeConstantReactance entity ) {
		LOGGER.info("handling emitFindAllAsynchronousMachineTimeConstantReactance" );
		
	    queryUpdateEmitter.emit(FindAllAsynchronousMachineTimeConstantReactanceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineTimeConstantReactanceProjector.class.getName());

}
