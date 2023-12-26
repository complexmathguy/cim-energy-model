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
 * Projector for ACLineSegment as outlined for the CQRS pattern.  All event handling and query handling related to ACLineSegment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ACLineSegmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("aCLineSegment")
@Component("aCLineSegment-projector")
public class ACLineSegmentProjector extends ACLineSegmentEntityProjector {
		
	// core constructor
	public ACLineSegmentProjector(ACLineSegmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateACLineSegmentEvent
     */
    @EventHandler( payloadType=CreateACLineSegmentEvent.class )
    public void handle( CreateACLineSegmentEvent event) {
	    LOGGER.info("handling CreateACLineSegmentEvent - " + event );
	    ACLineSegment entity = new ACLineSegment();
        entity.setACLineSegmentId( event.getACLineSegmentId() );
        entity.setB0ch( event.getB0ch() );
        entity.setBch( event.getBch() );
        entity.setG0ch( event.getG0ch() );
        entity.setGch( event.getGch() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setShortCircuitEndTemperature( event.getShortCircuitEndTemperature() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACLineSegment( entity );
    }

    /*
     * @param	event UpdateACLineSegmentEvent
     */
    @EventHandler( payloadType=UpdateACLineSegmentEvent.class )
    public void handle( UpdateACLineSegmentEvent event) {
    	LOGGER.info("handling UpdateACLineSegmentEvent - " + event );
    	
	    ACLineSegment entity = new ACLineSegment();
        entity.setACLineSegmentId( event.getACLineSegmentId() );
        entity.setB0ch( event.getB0ch() );
        entity.setBch( event.getBch() );
        entity.setG0ch( event.getG0ch() );
        entity.setGch( event.getGch() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setShortCircuitEndTemperature( event.getShortCircuitEndTemperature() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindACLineSegment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACLineSegment( entity );        
    }
    
    /*
     * @param	event DeleteACLineSegmentEvent
     */
    @EventHandler( payloadType=DeleteACLineSegmentEvent.class )
    public void handle( DeleteACLineSegmentEvent event) {
    	LOGGER.info("handling DeleteACLineSegmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ACLineSegment entity = delete( event.getACLineSegmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACLineSegment( entity );

    }    




    /**
     * Method to retrieve the ACLineSegment via an ACLineSegmentPrimaryKey.
     * @param 	id Long
     * @return 	ACLineSegment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ACLineSegment handle( FindACLineSegmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getACLineSegmentId() );
    }
    
    /**
     * Method to retrieve a collection of all ACLineSegments
     *
     * @param	query	FindAllACLineSegmentQuery 
     * @return 	List<ACLineSegment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ACLineSegment> handle( FindAllACLineSegmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindACLineSegment, 
	 * but only if the id matches
	 * 
	 * @param		entity	ACLineSegment
	 */
	protected void emitFindACLineSegment( ACLineSegment entity ) {
		LOGGER.info("handling emitFindACLineSegment" );
		
	    queryUpdateEmitter.emit(FindACLineSegmentQuery.class,
	                            query -> query.getFilter().getACLineSegmentId().equals(entity.getACLineSegmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllACLineSegment
	 * 
	 * @param		entity	ACLineSegment
	 */
	protected void emitFindAllACLineSegment( ACLineSegment entity ) {
		LOGGER.info("handling emitFindAllACLineSegment" );
		
	    queryUpdateEmitter.emit(FindAllACLineSegmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ACLineSegmentProjector.class.getName());

}
