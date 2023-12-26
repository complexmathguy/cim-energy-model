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
 * Projector for DiagramObjectPoint as outlined for the CQRS pattern.  All event handling and query handling related to DiagramObjectPoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramObjectPointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramObjectPoint")
@Component("diagramObjectPoint-projector")
public class DiagramObjectPointProjector extends DiagramObjectPointEntityProjector {
		
	// core constructor
	public DiagramObjectPointProjector(DiagramObjectPointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramObjectPointEvent
     */
    @EventHandler( payloadType=CreateDiagramObjectPointEvent.class )
    public void handle( CreateDiagramObjectPointEvent event) {
	    LOGGER.info("handling CreateDiagramObjectPointEvent - " + event );
	    DiagramObjectPoint entity = new DiagramObjectPoint();
        entity.setDiagramObjectPointId( event.getDiagramObjectPointId() );
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
        emitFindAllDiagramObjectPoint( entity );
    }

    /*
     * @param	event UpdateDiagramObjectPointEvent
     */
    @EventHandler( payloadType=UpdateDiagramObjectPointEvent.class )
    public void handle( UpdateDiagramObjectPointEvent event) {
    	LOGGER.info("handling UpdateDiagramObjectPointEvent - " + event );
    	
	    DiagramObjectPoint entity = new DiagramObjectPoint();
        entity.setDiagramObjectPointId( event.getDiagramObjectPointId() );
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
        emitFindDiagramObjectPoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectPoint( entity );        
    }
    
    /*
     * @param	event DeleteDiagramObjectPointEvent
     */
    @EventHandler( payloadType=DeleteDiagramObjectPointEvent.class )
    public void handle( DeleteDiagramObjectPointEvent event) {
    	LOGGER.info("handling DeleteDiagramObjectPointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramObjectPoint entity = delete( event.getDiagramObjectPointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectPoint( entity );

    }    




    /**
     * Method to retrieve the DiagramObjectPoint via an DiagramObjectPointPrimaryKey.
     * @param 	id Long
     * @return 	DiagramObjectPoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramObjectPoint handle( FindDiagramObjectPointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramObjectPointId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjectPoints
     *
     * @param	query	FindAllDiagramObjectPointQuery 
     * @return 	List<DiagramObjectPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramObjectPoint> handle( FindAllDiagramObjectPointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramObjectPoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramObjectPoint
	 */
	protected void emitFindDiagramObjectPoint( DiagramObjectPoint entity ) {
		LOGGER.info("handling emitFindDiagramObjectPoint" );
		
	    queryUpdateEmitter.emit(FindDiagramObjectPointQuery.class,
	                            query -> query.getFilter().getDiagramObjectPointId().equals(entity.getDiagramObjectPointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramObjectPoint
	 * 
	 * @param		entity	DiagramObjectPoint
	 */
	protected void emitFindAllDiagramObjectPoint( DiagramObjectPoint entity ) {
		LOGGER.info("handling emitFindAllDiagramObjectPoint" );
		
	    queryUpdateEmitter.emit(FindAllDiagramObjectPointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectPointProjector.class.getName());

}
