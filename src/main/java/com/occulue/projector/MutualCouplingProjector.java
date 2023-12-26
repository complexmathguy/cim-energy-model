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
 * Projector for MutualCoupling as outlined for the CQRS pattern.  All event handling and query handling related to MutualCoupling are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MutualCouplingAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("mutualCoupling")
@Component("mutualCoupling-projector")
public class MutualCouplingProjector extends MutualCouplingEntityProjector {
		
	// core constructor
	public MutualCouplingProjector(MutualCouplingRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMutualCouplingEvent
     */
    @EventHandler( payloadType=CreateMutualCouplingEvent.class )
    public void handle( CreateMutualCouplingEvent event) {
	    LOGGER.info("handling CreateMutualCouplingEvent - " + event );
	    MutualCoupling entity = new MutualCoupling();
        entity.setMutualCouplingId( event.getMutualCouplingId() );
        entity.setB0ch( event.getB0ch() );
        entity.setDistance11( event.getDistance11() );
        entity.setDistance12( event.getDistance12() );
        entity.setDistance21( event.getDistance21() );
        entity.setDistance22( event.getDistance22() );
        entity.setG0ch( event.getG0ch() );
        entity.setR0( event.getR0() );
        entity.setX0( event.getX0() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMutualCoupling( entity );
    }

    /*
     * @param	event UpdateMutualCouplingEvent
     */
    @EventHandler( payloadType=UpdateMutualCouplingEvent.class )
    public void handle( UpdateMutualCouplingEvent event) {
    	LOGGER.info("handling UpdateMutualCouplingEvent - " + event );
    	
	    MutualCoupling entity = new MutualCoupling();
        entity.setMutualCouplingId( event.getMutualCouplingId() );
        entity.setB0ch( event.getB0ch() );
        entity.setDistance11( event.getDistance11() );
        entity.setDistance12( event.getDistance12() );
        entity.setDistance21( event.getDistance21() );
        entity.setDistance22( event.getDistance22() );
        entity.setG0ch( event.getG0ch() );
        entity.setR0( event.getR0() );
        entity.setX0( event.getX0() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMutualCoupling( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMutualCoupling( entity );        
    }
    
    /*
     * @param	event DeleteMutualCouplingEvent
     */
    @EventHandler( payloadType=DeleteMutualCouplingEvent.class )
    public void handle( DeleteMutualCouplingEvent event) {
    	LOGGER.info("handling DeleteMutualCouplingEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MutualCoupling entity = delete( event.getMutualCouplingId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMutualCoupling( entity );

    }    




    /**
     * Method to retrieve the MutualCoupling via an MutualCouplingPrimaryKey.
     * @param 	id Long
     * @return 	MutualCoupling
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MutualCoupling handle( FindMutualCouplingQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMutualCouplingId() );
    }
    
    /**
     * Method to retrieve a collection of all MutualCouplings
     *
     * @param	query	FindAllMutualCouplingQuery 
     * @return 	List<MutualCoupling> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MutualCoupling> handle( FindAllMutualCouplingQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMutualCoupling, 
	 * but only if the id matches
	 * 
	 * @param		entity	MutualCoupling
	 */
	protected void emitFindMutualCoupling( MutualCoupling entity ) {
		LOGGER.info("handling emitFindMutualCoupling" );
		
	    queryUpdateEmitter.emit(FindMutualCouplingQuery.class,
	                            query -> query.getFilter().getMutualCouplingId().equals(entity.getMutualCouplingId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMutualCoupling
	 * 
	 * @param		entity	MutualCoupling
	 */
	protected void emitFindAllMutualCoupling( MutualCoupling entity ) {
		LOGGER.info("handling emitFindAllMutualCoupling" );
		
	    queryUpdateEmitter.emit(FindAllMutualCouplingQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MutualCouplingProjector.class.getName());

}
