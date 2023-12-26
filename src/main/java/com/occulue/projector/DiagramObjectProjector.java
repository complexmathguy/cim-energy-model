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
 * Projector for DiagramObject as outlined for the CQRS pattern.  All event handling and query handling related to DiagramObject are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramObjectAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramObject")
@Component("diagramObject-projector")
public class DiagramObjectProjector extends DiagramObjectEntityProjector {
		
	// core constructor
	public DiagramObjectProjector(DiagramObjectRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramObjectEvent
     */
    @EventHandler( payloadType=CreateDiagramObjectEvent.class )
    public void handle( CreateDiagramObjectEvent event) {
	    LOGGER.info("handling CreateDiagramObjectEvent - " + event );
	    DiagramObject entity = new DiagramObject();
        entity.setDiagramObjectId( event.getDiagramObjectId() );
        entity.setDrawingOrder( event.getDrawingOrder() );
        entity.setIsPolygon( event.getIsPolygon() );
        entity.setOffsetX( event.getOffsetX() );
        entity.setOffsetY( event.getOffsetY() );
        entity.setRotation( event.getRotation() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObject( entity );
    }

    /*
     * @param	event UpdateDiagramObjectEvent
     */
    @EventHandler( payloadType=UpdateDiagramObjectEvent.class )
    public void handle( UpdateDiagramObjectEvent event) {
    	LOGGER.info("handling UpdateDiagramObjectEvent - " + event );
    	
	    DiagramObject entity = new DiagramObject();
        entity.setDiagramObjectId( event.getDiagramObjectId() );
        entity.setDrawingOrder( event.getDrawingOrder() );
        entity.setIsPolygon( event.getIsPolygon() );
        entity.setOffsetX( event.getOffsetX() );
        entity.setOffsetY( event.getOffsetY() );
        entity.setRotation( event.getRotation() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagramObject( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObject( entity );        
    }
    
    /*
     * @param	event DeleteDiagramObjectEvent
     */
    @EventHandler( payloadType=DeleteDiagramObjectEvent.class )
    public void handle( DeleteDiagramObjectEvent event) {
    	LOGGER.info("handling DeleteDiagramObjectEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramObject entity = delete( event.getDiagramObjectId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObject( entity );

    }    




    /**
     * Method to retrieve the DiagramObject via an DiagramObjectPrimaryKey.
     * @param 	id Long
     * @return 	DiagramObject
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramObject handle( FindDiagramObjectQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramObjectId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjects
     *
     * @param	query	FindAllDiagramObjectQuery 
     * @return 	List<DiagramObject> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramObject> handle( FindAllDiagramObjectQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramObject, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramObject
	 */
	protected void emitFindDiagramObject( DiagramObject entity ) {
		LOGGER.info("handling emitFindDiagramObject" );
		
	    queryUpdateEmitter.emit(FindDiagramObjectQuery.class,
	                            query -> query.getFilter().getDiagramObjectId().equals(entity.getDiagramObjectId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramObject
	 * 
	 * @param		entity	DiagramObject
	 */
	protected void emitFindAllDiagramObject( DiagramObject entity ) {
		LOGGER.info("handling emitFindAllDiagramObject" );
		
	    queryUpdateEmitter.emit(FindAllDiagramObjectQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectProjector.class.getName());

}
