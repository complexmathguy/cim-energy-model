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
 * Projector for DiagramObjectGluePoint as outlined for the CQRS pattern.  All event handling and query handling related to DiagramObjectGluePoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramObjectGluePointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramObjectGluePoint")
@Component("diagramObjectGluePoint-projector")
public class DiagramObjectGluePointProjector extends DiagramObjectGluePointEntityProjector {
		
	// core constructor
	public DiagramObjectGluePointProjector(DiagramObjectGluePointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramObjectGluePointEvent
     */
    @EventHandler( payloadType=CreateDiagramObjectGluePointEvent.class )
    public void handle( CreateDiagramObjectGluePointEvent event) {
	    LOGGER.info("handling CreateDiagramObjectGluePointEvent - " + event );
	    DiagramObjectGluePoint entity = new DiagramObjectGluePoint();
        entity.setDiagramObjectGluePointId( event.getDiagramObjectGluePointId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectGluePoint( entity );
    }

    /*
     * @param	event UpdateDiagramObjectGluePointEvent
     */
    @EventHandler( payloadType=UpdateDiagramObjectGluePointEvent.class )
    public void handle( UpdateDiagramObjectGluePointEvent event) {
    	LOGGER.info("handling UpdateDiagramObjectGluePointEvent - " + event );
    	
	    DiagramObjectGluePoint entity = new DiagramObjectGluePoint();
        entity.setDiagramObjectGluePointId( event.getDiagramObjectGluePointId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagramObjectGluePoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectGluePoint( entity );        
    }
    
    /*
     * @param	event DeleteDiagramObjectGluePointEvent
     */
    @EventHandler( payloadType=DeleteDiagramObjectGluePointEvent.class )
    public void handle( DeleteDiagramObjectGluePointEvent event) {
    	LOGGER.info("handling DeleteDiagramObjectGluePointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramObjectGluePoint entity = delete( event.getDiagramObjectGluePointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectGluePoint( entity );

    }    




    /**
     * Method to retrieve the DiagramObjectGluePoint via an DiagramObjectGluePointPrimaryKey.
     * @param 	id Long
     * @return 	DiagramObjectGluePoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramObjectGluePoint handle( FindDiagramObjectGluePointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramObjectGluePointId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjectGluePoints
     *
     * @param	query	FindAllDiagramObjectGluePointQuery 
     * @return 	List<DiagramObjectGluePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramObjectGluePoint> handle( FindAllDiagramObjectGluePointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramObjectGluePoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramObjectGluePoint
	 */
	protected void emitFindDiagramObjectGluePoint( DiagramObjectGluePoint entity ) {
		LOGGER.info("handling emitFindDiagramObjectGluePoint" );
		
	    queryUpdateEmitter.emit(FindDiagramObjectGluePointQuery.class,
	                            query -> query.getFilter().getDiagramObjectGluePointId().equals(entity.getDiagramObjectGluePointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramObjectGluePoint
	 * 
	 * @param		entity	DiagramObjectGluePoint
	 */
	protected void emitFindAllDiagramObjectGluePoint( DiagramObjectGluePoint entity ) {
		LOGGER.info("handling emitFindAllDiagramObjectGluePoint" );
		
	    queryUpdateEmitter.emit(FindAllDiagramObjectGluePointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectGluePointProjector.class.getName());

}
