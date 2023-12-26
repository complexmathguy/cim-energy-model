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
 * Projector for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachineEquivalentCircuit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineEquivalentCircuitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachineEquivalentCircuit")
@Component("synchronousMachineEquivalentCircuit-projector")
public class SynchronousMachineEquivalentCircuitProjector extends SynchronousMachineEquivalentCircuitEntityProjector {
		
	// core constructor
	public SynchronousMachineEquivalentCircuitProjector(SynchronousMachineEquivalentCircuitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineEquivalentCircuitEvent.class )
    public void handle( CreateSynchronousMachineEquivalentCircuitEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineEquivalentCircuitEvent - " + event );
	    SynchronousMachineEquivalentCircuit entity = new SynchronousMachineEquivalentCircuit();
        entity.setSynchronousMachineEquivalentCircuitId( event.getSynchronousMachineEquivalentCircuitId() );
        entity.setR1d( event.getR1d() );
        entity.setR1q( event.getR1q() );
        entity.setR2q( event.getR2q() );
        entity.setRfd( event.getRfd() );
        entity.setX1d( event.getX1d() );
        entity.setX1q( event.getX1q() );
        entity.setX2q( event.getX2q() );
        entity.setXad( event.getXad() );
        entity.setXaq( event.getXaq() );
        entity.setXf1d( event.getXf1d() );
        entity.setXfd( event.getXfd() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineEquivalentCircuit( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineEquivalentCircuitEvent.class )
    public void handle( UpdateSynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineEquivalentCircuitEvent - " + event );
    	
	    SynchronousMachineEquivalentCircuit entity = new SynchronousMachineEquivalentCircuit();
        entity.setSynchronousMachineEquivalentCircuitId( event.getSynchronousMachineEquivalentCircuitId() );
        entity.setR1d( event.getR1d() );
        entity.setR1q( event.getR1q() );
        entity.setR2q( event.getR2q() );
        entity.setRfd( event.getRfd() );
        entity.setX1d( event.getX1d() );
        entity.setX1q( event.getX1q() );
        entity.setX2q( event.getX2q() );
        entity.setXad( event.getXad() );
        entity.setXaq( event.getXaq() );
        entity.setXf1d( event.getXf1d() );
        entity.setXfd( event.getXfd() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachineEquivalentCircuit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineEquivalentCircuit( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineEquivalentCircuitEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineEquivalentCircuitEvent.class )
    public void handle( DeleteSynchronousMachineEquivalentCircuitEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineEquivalentCircuitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachineEquivalentCircuit entity = delete( event.getSynchronousMachineEquivalentCircuitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineEquivalentCircuit( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachineEquivalentCircuit via an SynchronousMachineEquivalentCircuitPrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachineEquivalentCircuit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachineEquivalentCircuit handle( FindSynchronousMachineEquivalentCircuitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineEquivalentCircuitId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineEquivalentCircuits
     *
     * @param	query	FindAllSynchronousMachineEquivalentCircuitQuery 
     * @return 	List<SynchronousMachineEquivalentCircuit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachineEquivalentCircuit> handle( FindAllSynchronousMachineEquivalentCircuitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachineEquivalentCircuit, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachineEquivalentCircuit
	 */
	protected void emitFindSynchronousMachineEquivalentCircuit( SynchronousMachineEquivalentCircuit entity ) {
		LOGGER.info("handling emitFindSynchronousMachineEquivalentCircuit" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineEquivalentCircuitQuery.class,
	                            query -> query.getFilter().getSynchronousMachineEquivalentCircuitId().equals(entity.getSynchronousMachineEquivalentCircuitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachineEquivalentCircuit
	 * 
	 * @param		entity	SynchronousMachineEquivalentCircuit
	 */
	protected void emitFindAllSynchronousMachineEquivalentCircuit( SynchronousMachineEquivalentCircuit entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachineEquivalentCircuit" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineEquivalentCircuitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineEquivalentCircuitProjector.class.getName());

}
