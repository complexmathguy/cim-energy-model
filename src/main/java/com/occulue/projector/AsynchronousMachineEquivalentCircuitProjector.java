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
 * Projector for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.  All event handling and query handling related to AsynchronousMachineEquivalentCircuit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AsynchronousMachineEquivalentCircuitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("asynchronousMachineEquivalentCircuit")
@Component("asynchronousMachineEquivalentCircuit-projector")
public class AsynchronousMachineEquivalentCircuitProjector extends AsynchronousMachineEquivalentCircuitEntityProjector {
		
	// core constructor
	public AsynchronousMachineEquivalentCircuitProjector(AsynchronousMachineEquivalentCircuitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAsynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=CreateAsynchronousMachineEquivalentCircuitEvent.class )
    public void handle( CreateAsynchronousMachineEquivalentCircuitEvent event) {
	    LOGGER.info("handling CreateAsynchronousMachineEquivalentCircuitEvent - " + event );
	    AsynchronousMachineEquivalentCircuit entity = new AsynchronousMachineEquivalentCircuit();
        entity.setAsynchronousMachineEquivalentCircuitId( event.getAsynchronousMachineEquivalentCircuitId() );
        entity.setRr1( event.getRr1() );
        entity.setRr2( event.getRr2() );
        entity.setXlr1( event.getXlr1() );
        entity.setXlr2( event.getXlr2() );
        entity.setXm( event.getXm() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineEquivalentCircuit( entity );
    }

    /*
     * @param	event UpdateAsynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=UpdateAsynchronousMachineEquivalentCircuitEvent.class )
    public void handle( UpdateAsynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info("handling UpdateAsynchronousMachineEquivalentCircuitEvent - " + event );
    	
	    AsynchronousMachineEquivalentCircuit entity = new AsynchronousMachineEquivalentCircuit();
        entity.setAsynchronousMachineEquivalentCircuitId( event.getAsynchronousMachineEquivalentCircuitId() );
        entity.setRr1( event.getRr1() );
        entity.setRr2( event.getRr2() );
        entity.setXlr1( event.getXlr1() );
        entity.setXlr2( event.getXlr2() );
        entity.setXm( event.getXm() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAsynchronousMachineEquivalentCircuit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineEquivalentCircuit( entity );        
    }
    
    /*
     * @param	event DeleteAsynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=DeleteAsynchronousMachineEquivalentCircuitEvent.class )
    public void handle( DeleteAsynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info("handling DeleteAsynchronousMachineEquivalentCircuitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AsynchronousMachineEquivalentCircuit entity = delete( event.getAsynchronousMachineEquivalentCircuitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineEquivalentCircuit( entity );

    }    




    /**
     * Method to retrieve the AsynchronousMachineEquivalentCircuit via an AsynchronousMachineEquivalentCircuitPrimaryKey.
     * @param 	id Long
     * @return 	AsynchronousMachineEquivalentCircuit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AsynchronousMachineEquivalentCircuit handle( FindAsynchronousMachineEquivalentCircuitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAsynchronousMachineEquivalentCircuitId() );
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineEquivalentCircuits
     *
     * @param	query	FindAllAsynchronousMachineEquivalentCircuitQuery 
     * @return 	List<AsynchronousMachineEquivalentCircuit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AsynchronousMachineEquivalentCircuit> handle( FindAllAsynchronousMachineEquivalentCircuitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAsynchronousMachineEquivalentCircuit, 
	 * but only if the id matches
	 * 
	 * @param		entity	AsynchronousMachineEquivalentCircuit
	 */
	protected void emitFindAsynchronousMachineEquivalentCircuit( AsynchronousMachineEquivalentCircuit entity ) {
		LOGGER.info("handling emitFindAsynchronousMachineEquivalentCircuit" );
		
	    queryUpdateEmitter.emit(FindAsynchronousMachineEquivalentCircuitQuery.class,
	                            query -> query.getFilter().getAsynchronousMachineEquivalentCircuitId().equals(entity.getAsynchronousMachineEquivalentCircuitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAsynchronousMachineEquivalentCircuit
	 * 
	 * @param		entity	AsynchronousMachineEquivalentCircuit
	 */
	protected void emitFindAllAsynchronousMachineEquivalentCircuit( AsynchronousMachineEquivalentCircuit entity ) {
		LOGGER.info("handling emitFindAllAsynchronousMachineEquivalentCircuit" );
		
	    queryUpdateEmitter.emit(FindAllAsynchronousMachineEquivalentCircuitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineEquivalentCircuitProjector.class.getName());

}
