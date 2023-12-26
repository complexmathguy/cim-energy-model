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
 * Projector for DiagramStyle as outlined for the CQRS pattern.  All event handling and query handling related to DiagramStyle are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramStyleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramStyle")
@Component("diagramStyle-projector")
public class DiagramStyleProjector extends DiagramStyleEntityProjector {
		
	// core constructor
	public DiagramStyleProjector(DiagramStyleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramStyleEvent
     */
    @EventHandler( payloadType=CreateDiagramStyleEvent.class )
    public void handle( CreateDiagramStyleEvent event) {
	    LOGGER.info("handling CreateDiagramStyleEvent - " + event );
	    DiagramStyle entity = new DiagramStyle();
        entity.setDiagramStyleId( event.getDiagramStyleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramStyle( entity );
    }

    /*
     * @param	event UpdateDiagramStyleEvent
     */
    @EventHandler( payloadType=UpdateDiagramStyleEvent.class )
    public void handle( UpdateDiagramStyleEvent event) {
    	LOGGER.info("handling UpdateDiagramStyleEvent - " + event );
    	
	    DiagramStyle entity = new DiagramStyle();
        entity.setDiagramStyleId( event.getDiagramStyleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagramStyle( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramStyle( entity );        
    }
    
    /*
     * @param	event DeleteDiagramStyleEvent
     */
    @EventHandler( payloadType=DeleteDiagramStyleEvent.class )
    public void handle( DeleteDiagramStyleEvent event) {
    	LOGGER.info("handling DeleteDiagramStyleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramStyle entity = delete( event.getDiagramStyleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramStyle( entity );

    }    




    /**
     * Method to retrieve the DiagramStyle via an DiagramStylePrimaryKey.
     * @param 	id Long
     * @return 	DiagramStyle
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramStyle handle( FindDiagramStyleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramStyleId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramStyles
     *
     * @param	query	FindAllDiagramStyleQuery 
     * @return 	List<DiagramStyle> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramStyle> handle( FindAllDiagramStyleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramStyle, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramStyle
	 */
	protected void emitFindDiagramStyle( DiagramStyle entity ) {
		LOGGER.info("handling emitFindDiagramStyle" );
		
	    queryUpdateEmitter.emit(FindDiagramStyleQuery.class,
	                            query -> query.getFilter().getDiagramStyleId().equals(entity.getDiagramStyleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramStyle
	 * 
	 * @param		entity	DiagramStyle
	 */
	protected void emitFindAllDiagramStyle( DiagramStyle entity ) {
		LOGGER.info("handling emitFindAllDiagramStyle" );
		
	    queryUpdateEmitter.emit(FindAllDiagramStyleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramStyleProjector.class.getName());

}
