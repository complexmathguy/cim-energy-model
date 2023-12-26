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
 * Projector for AsynchronousMachine as outlined for the CQRS pattern.  All event handling and query handling related to AsynchronousMachine are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AsynchronousMachineAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("asynchronousMachine")
@Component("asynchronousMachine-projector")
public class AsynchronousMachineProjector extends AsynchronousMachineEntityProjector {
		
	// core constructor
	public AsynchronousMachineProjector(AsynchronousMachineRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAsynchronousMachineEvent
     */
    @EventHandler( payloadType=CreateAsynchronousMachineEvent.class )
    public void handle( CreateAsynchronousMachineEvent event) {
	    LOGGER.info("handling CreateAsynchronousMachineEvent - " + event );
	    AsynchronousMachine entity = new AsynchronousMachine();
        entity.setAsynchronousMachineId( event.getAsynchronousMachineId() );
        entity.setConverterFedDrive( event.getConverterFedDrive() );
        entity.setEfficiency( event.getEfficiency() );
        entity.setIaIrRatio( event.getIaIrRatio() );
        entity.setNominalFrequency( event.getNominalFrequency() );
        entity.setNominalSpeed( event.getNominalSpeed() );
        entity.setPolePairNumber( event.getPolePairNumber() );
        entity.setRatedMechanicalPower( event.getRatedMechanicalPower() );
        entity.setReversible( event.getReversible() );
        entity.setRxLockedRotorRatio( event.getRxLockedRotorRatio() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachine( entity );
    }

    /*
     * @param	event UpdateAsynchronousMachineEvent
     */
    @EventHandler( payloadType=UpdateAsynchronousMachineEvent.class )
    public void handle( UpdateAsynchronousMachineEvent event) {
    	LOGGER.info("handling UpdateAsynchronousMachineEvent - " + event );
    	
	    AsynchronousMachine entity = new AsynchronousMachine();
        entity.setAsynchronousMachineId( event.getAsynchronousMachineId() );
        entity.setConverterFedDrive( event.getConverterFedDrive() );
        entity.setEfficiency( event.getEfficiency() );
        entity.setIaIrRatio( event.getIaIrRatio() );
        entity.setNominalFrequency( event.getNominalFrequency() );
        entity.setNominalSpeed( event.getNominalSpeed() );
        entity.setPolePairNumber( event.getPolePairNumber() );
        entity.setRatedMechanicalPower( event.getRatedMechanicalPower() );
        entity.setReversible( event.getReversible() );
        entity.setRxLockedRotorRatio( event.getRxLockedRotorRatio() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAsynchronousMachine( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachine( entity );        
    }
    
    /*
     * @param	event DeleteAsynchronousMachineEvent
     */
    @EventHandler( payloadType=DeleteAsynchronousMachineEvent.class )
    public void handle( DeleteAsynchronousMachineEvent event) {
    	LOGGER.info("handling DeleteAsynchronousMachineEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AsynchronousMachine entity = delete( event.getAsynchronousMachineId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachine( entity );

    }    




    /**
     * Method to retrieve the AsynchronousMachine via an AsynchronousMachinePrimaryKey.
     * @param 	id Long
     * @return 	AsynchronousMachine
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AsynchronousMachine handle( FindAsynchronousMachineQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAsynchronousMachineId() );
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachines
     *
     * @param	query	FindAllAsynchronousMachineQuery 
     * @return 	List<AsynchronousMachine> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AsynchronousMachine> handle( FindAllAsynchronousMachineQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAsynchronousMachine, 
	 * but only if the id matches
	 * 
	 * @param		entity	AsynchronousMachine
	 */
	protected void emitFindAsynchronousMachine( AsynchronousMachine entity ) {
		LOGGER.info("handling emitFindAsynchronousMachine" );
		
	    queryUpdateEmitter.emit(FindAsynchronousMachineQuery.class,
	                            query -> query.getFilter().getAsynchronousMachineId().equals(entity.getAsynchronousMachineId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAsynchronousMachine
	 * 
	 * @param		entity	AsynchronousMachine
	 */
	protected void emitFindAllAsynchronousMachine( AsynchronousMachine entity ) {
		LOGGER.info("handling emitFindAllAsynchronousMachine" );
		
	    queryUpdateEmitter.emit(FindAllAsynchronousMachineQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineProjector.class.getName());

}
