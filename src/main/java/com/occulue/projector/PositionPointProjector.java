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
 * Projector for PositionPoint as outlined for the CQRS pattern.  All event handling and query handling related to PositionPoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PositionPointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("positionPoint")
@Component("positionPoint-projector")
public class PositionPointProjector extends PositionPointEntityProjector {
		
	// core constructor
	public PositionPointProjector(PositionPointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePositionPointEvent
     */
    @EventHandler( payloadType=CreatePositionPointEvent.class )
    public void handle( CreatePositionPointEvent event) {
	    LOGGER.info("handling CreatePositionPointEvent - " + event );
	    PositionPoint entity = new PositionPoint();
        entity.setPositionPointId( event.getPositionPointId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
        entity.setXPosition( event.getXPosition() );
        entity.setYPosition( event.getYPosition() );
        entity.setZPosition( event.getZPosition() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPositionPoint( entity );
    }

    /*
     * @param	event UpdatePositionPointEvent
     */
    @EventHandler( payloadType=UpdatePositionPointEvent.class )
    public void handle( UpdatePositionPointEvent event) {
    	LOGGER.info("handling UpdatePositionPointEvent - " + event );
    	
	    PositionPoint entity = new PositionPoint();
        entity.setPositionPointId( event.getPositionPointId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
        entity.setXPosition( event.getXPosition() );
        entity.setYPosition( event.getYPosition() );
        entity.setZPosition( event.getZPosition() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPositionPoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPositionPoint( entity );        
    }
    
    /*
     * @param	event DeletePositionPointEvent
     */
    @EventHandler( payloadType=DeletePositionPointEvent.class )
    public void handle( DeletePositionPointEvent event) {
    	LOGGER.info("handling DeletePositionPointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PositionPoint entity = delete( event.getPositionPointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPositionPoint( entity );

    }    




    /**
     * Method to retrieve the PositionPoint via an PositionPointPrimaryKey.
     * @param 	id Long
     * @return 	PositionPoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PositionPoint handle( FindPositionPointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPositionPointId() );
    }
    
    /**
     * Method to retrieve a collection of all PositionPoints
     *
     * @param	query	FindAllPositionPointQuery 
     * @return 	List<PositionPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PositionPoint> handle( FindAllPositionPointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPositionPoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	PositionPoint
	 */
	protected void emitFindPositionPoint( PositionPoint entity ) {
		LOGGER.info("handling emitFindPositionPoint" );
		
	    queryUpdateEmitter.emit(FindPositionPointQuery.class,
	                            query -> query.getFilter().getPositionPointId().equals(entity.getPositionPointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPositionPoint
	 * 
	 * @param		entity	PositionPoint
	 */
	protected void emitFindAllPositionPoint( PositionPoint entity ) {
		LOGGER.info("handling emitFindAllPositionPoint" );
		
	    queryUpdateEmitter.emit(FindAllPositionPointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PositionPointProjector.class.getName());

}
