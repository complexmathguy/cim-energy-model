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
 * Projector for Diagram as outlined for the CQRS pattern.  All event handling and query handling related to Diagram are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagram")
@Component("diagram-projector")
public class DiagramProjector extends DiagramEntityProjector {
		
	// core constructor
	public DiagramProjector(DiagramRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramEvent
     */
    @EventHandler( payloadType=CreateDiagramEvent.class )
    public void handle( CreateDiagramEvent event) {
	    LOGGER.info("handling CreateDiagramEvent - " + event );
	    Diagram entity = new Diagram();
        entity.setDiagramId( event.getDiagramId() );
        entity.setOrientation( event.getOrientation() );
        entity.setX1InitialView( event.getX1InitialView() );
        entity.setX2InitialView( event.getX2InitialView() );
        entity.setY1InitialView( event.getY1InitialView() );
        entity.setY2InitialView( event.getY2InitialView() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagram( entity );
    }

    /*
     * @param	event UpdateDiagramEvent
     */
    @EventHandler( payloadType=UpdateDiagramEvent.class )
    public void handle( UpdateDiagramEvent event) {
    	LOGGER.info("handling UpdateDiagramEvent - " + event );
    	
	    Diagram entity = new Diagram();
        entity.setDiagramId( event.getDiagramId() );
        entity.setOrientation( event.getOrientation() );
        entity.setX1InitialView( event.getX1InitialView() );
        entity.setX2InitialView( event.getX2InitialView() );
        entity.setY1InitialView( event.getY1InitialView() );
        entity.setY2InitialView( event.getY2InitialView() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagram( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagram( entity );        
    }
    
    /*
     * @param	event DeleteDiagramEvent
     */
    @EventHandler( payloadType=DeleteDiagramEvent.class )
    public void handle( DeleteDiagramEvent event) {
    	LOGGER.info("handling DeleteDiagramEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Diagram entity = delete( event.getDiagramId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagram( entity );

    }    




    /**
     * Method to retrieve the Diagram via an DiagramPrimaryKey.
     * @param 	id Long
     * @return 	Diagram
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Diagram handle( FindDiagramQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramId() );
    }
    
    /**
     * Method to retrieve a collection of all Diagrams
     *
     * @param	query	FindAllDiagramQuery 
     * @return 	List<Diagram> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Diagram> handle( FindAllDiagramQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagram, 
	 * but only if the id matches
	 * 
	 * @param		entity	Diagram
	 */
	protected void emitFindDiagram( Diagram entity ) {
		LOGGER.info("handling emitFindDiagram" );
		
	    queryUpdateEmitter.emit(FindDiagramQuery.class,
	                            query -> query.getFilter().getDiagramId().equals(entity.getDiagramId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagram
	 * 
	 * @param		entity	Diagram
	 */
	protected void emitFindAllDiagram( Diagram entity ) {
		LOGGER.info("handling emitFindAllDiagram" );
		
	    queryUpdateEmitter.emit(FindAllDiagramQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramProjector.class.getName());

}
