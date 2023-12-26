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
 * Projector for SynchronousMachine as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachine are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachine")
@Component("synchronousMachine-projector")
public class SynchronousMachineProjector extends SynchronousMachineEntityProjector {
		
	// core constructor
	public SynchronousMachineProjector(SynchronousMachineRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineEvent.class )
    public void handle( CreateSynchronousMachineEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineEvent - " + event );
	    SynchronousMachine entity = new SynchronousMachine();
        entity.setSynchronousMachineId( event.getSynchronousMachineId() );
        entity.setEarthing( event.getEarthing() );
        entity.setEarthingStarPointR( event.getEarthingStarPointR() );
        entity.setEarthingStarPointX( event.getEarthingStarPointX() );
        entity.setIkk( event.getIkk() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMinQ( event.getMinQ() );
        entity.setMu( event.getMu() );
        entity.setQPercent( event.getQPercent() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setR2( event.getR2() );
        entity.setSatDirectSubtransX( event.getSatDirectSubtransX() );
        entity.setSatDirectSyncX( event.getSatDirectSyncX() );
        entity.setSatDirectTransX( event.getSatDirectTransX() );
        entity.setShortCircuitRotorType( event.getShortCircuitRotorType() );
        entity.setType( event.getType() );
        entity.setVoltageRegulationRange( event.getVoltageRegulationRange() );
        entity.setX0( event.getX0() );
        entity.setX2( event.getX2() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachine( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineEvent.class )
    public void handle( UpdateSynchronousMachineEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineEvent - " + event );
    	
	    SynchronousMachine entity = new SynchronousMachine();
        entity.setSynchronousMachineId( event.getSynchronousMachineId() );
        entity.setEarthing( event.getEarthing() );
        entity.setEarthingStarPointR( event.getEarthingStarPointR() );
        entity.setEarthingStarPointX( event.getEarthingStarPointX() );
        entity.setIkk( event.getIkk() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMinQ( event.getMinQ() );
        entity.setMu( event.getMu() );
        entity.setQPercent( event.getQPercent() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setR2( event.getR2() );
        entity.setSatDirectSubtransX( event.getSatDirectSubtransX() );
        entity.setSatDirectSyncX( event.getSatDirectSyncX() );
        entity.setSatDirectTransX( event.getSatDirectTransX() );
        entity.setShortCircuitRotorType( event.getShortCircuitRotorType() );
        entity.setType( event.getType() );
        entity.setVoltageRegulationRange( event.getVoltageRegulationRange() );
        entity.setX0( event.getX0() );
        entity.setX2( event.getX2() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachine( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachine( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineEvent.class )
    public void handle( DeleteSynchronousMachineEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachine entity = delete( event.getSynchronousMachineId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachine( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachine via an SynchronousMachinePrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachine
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachine handle( FindSynchronousMachineQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachines
     *
     * @param	query	FindAllSynchronousMachineQuery 
     * @return 	List<SynchronousMachine> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachine> handle( FindAllSynchronousMachineQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachine, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachine
	 */
	protected void emitFindSynchronousMachine( SynchronousMachine entity ) {
		LOGGER.info("handling emitFindSynchronousMachine" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineQuery.class,
	                            query -> query.getFilter().getSynchronousMachineId().equals(entity.getSynchronousMachineId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachine
	 * 
	 * @param		entity	SynchronousMachine
	 */
	protected void emitFindAllSynchronousMachine( SynchronousMachine entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachine" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineProjector.class.getName());

}
