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
 * Projector for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachineTimeConstantReactance are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineTimeConstantReactanceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachineTimeConstantReactance")
@Component("synchronousMachineTimeConstantReactance-projector")
public class SynchronousMachineTimeConstantReactanceProjector extends SynchronousMachineTimeConstantReactanceEntityProjector {
		
	// core constructor
	public SynchronousMachineTimeConstantReactanceProjector(SynchronousMachineTimeConstantReactanceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( CreateSynchronousMachineTimeConstantReactanceEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineTimeConstantReactanceEvent - " + event );
	    SynchronousMachineTimeConstantReactance entity = new SynchronousMachineTimeConstantReactance();
        entity.setSynchronousMachineTimeConstantReactanceId( event.getSynchronousMachineTimeConstantReactanceId() );
        entity.setKs( event.getKs() );
        entity.setModelType( event.getModelType() );
        entity.setRotorType( event.getRotorType() );
        entity.setTc( event.getTc() );
        entity.setTpdo( event.getTpdo() );
        entity.setTppdo( event.getTppdo() );
        entity.setTppqo( event.getTppqo() );
        entity.setTpqo( event.getTpqo() );
        entity.setXDirectSubtrans( event.getXDirectSubtrans() );
        entity.setXDirectSync( event.getXDirectSync() );
        entity.setXDirectTrans( event.getXDirectTrans() );
        entity.setXQuadSubtrans( event.getXQuadSubtrans() );
        entity.setXQuadSync( event.getXQuadSync() );
        entity.setXQuadTrans( event.getXQuadTrans() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineTimeConstantReactance( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( UpdateSynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineTimeConstantReactanceEvent - " + event );
    	
	    SynchronousMachineTimeConstantReactance entity = new SynchronousMachineTimeConstantReactance();
        entity.setSynchronousMachineTimeConstantReactanceId( event.getSynchronousMachineTimeConstantReactanceId() );
        entity.setKs( event.getKs() );
        entity.setModelType( event.getModelType() );
        entity.setRotorType( event.getRotorType() );
        entity.setTc( event.getTc() );
        entity.setTpdo( event.getTpdo() );
        entity.setTppdo( event.getTppdo() );
        entity.setTppqo( event.getTppqo() );
        entity.setTpqo( event.getTpqo() );
        entity.setXDirectSubtrans( event.getXDirectSubtrans() );
        entity.setXDirectSync( event.getXDirectSync() );
        entity.setXDirectTrans( event.getXDirectTrans() );
        entity.setXQuadSubtrans( event.getXQuadSubtrans() );
        entity.setXQuadSync( event.getXQuadSync() );
        entity.setXQuadTrans( event.getXQuadTrans() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachineTimeConstantReactance( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineTimeConstantReactance( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineTimeConstantReactanceEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineTimeConstantReactanceEvent.class )
    public void handle( DeleteSynchronousMachineTimeConstantReactanceEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineTimeConstantReactanceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachineTimeConstantReactance entity = delete( event.getSynchronousMachineTimeConstantReactanceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineTimeConstantReactance( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachineTimeConstantReactance via an SynchronousMachineTimeConstantReactancePrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachineTimeConstantReactance
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachineTimeConstantReactance handle( FindSynchronousMachineTimeConstantReactanceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineTimeConstantReactanceId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
     *
     * @param	query	FindAllSynchronousMachineTimeConstantReactanceQuery 
     * @return 	List<SynchronousMachineTimeConstantReactance> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachineTimeConstantReactance> handle( FindAllSynchronousMachineTimeConstantReactanceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachineTimeConstantReactance, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachineTimeConstantReactance
	 */
	protected void emitFindSynchronousMachineTimeConstantReactance( SynchronousMachineTimeConstantReactance entity ) {
		LOGGER.info("handling emitFindSynchronousMachineTimeConstantReactance" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineTimeConstantReactanceQuery.class,
	                            query -> query.getFilter().getSynchronousMachineTimeConstantReactanceId().equals(entity.getSynchronousMachineTimeConstantReactanceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachineTimeConstantReactance
	 * 
	 * @param		entity	SynchronousMachineTimeConstantReactance
	 */
	protected void emitFindAllSynchronousMachineTimeConstantReactance( SynchronousMachineTimeConstantReactance entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachineTimeConstantReactance" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineTimeConstantReactanceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineTimeConstantReactanceProjector.class.getName());

}
