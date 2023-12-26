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
 * Projector for DiagramObjectStyle as outlined for the CQRS pattern.  All event handling and query handling related to DiagramObjectStyle are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramObjectStyleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramObjectStyle")
@Component("diagramObjectStyle-projector")
public class DiagramObjectStyleProjector extends DiagramObjectStyleEntityProjector {
		
	// core constructor
	public DiagramObjectStyleProjector(DiagramObjectStyleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramObjectStyleEvent
     */
    @EventHandler( payloadType=CreateDiagramObjectStyleEvent.class )
    public void handle( CreateDiagramObjectStyleEvent event) {
	    LOGGER.info("handling CreateDiagramObjectStyleEvent - " + event );
	    DiagramObjectStyle entity = new DiagramObjectStyle();
        entity.setDiagramObjectStyleId( event.getDiagramObjectStyleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectStyle( entity );
    }

    /*
     * @param	event UpdateDiagramObjectStyleEvent
     */
    @EventHandler( payloadType=UpdateDiagramObjectStyleEvent.class )
    public void handle( UpdateDiagramObjectStyleEvent event) {
    	LOGGER.info("handling UpdateDiagramObjectStyleEvent - " + event );
    	
	    DiagramObjectStyle entity = new DiagramObjectStyle();
        entity.setDiagramObjectStyleId( event.getDiagramObjectStyleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagramObjectStyle( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectStyle( entity );        
    }
    
    /*
     * @param	event DeleteDiagramObjectStyleEvent
     */
    @EventHandler( payloadType=DeleteDiagramObjectStyleEvent.class )
    public void handle( DeleteDiagramObjectStyleEvent event) {
    	LOGGER.info("handling DeleteDiagramObjectStyleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramObjectStyle entity = delete( event.getDiagramObjectStyleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramObjectStyle( entity );

    }    




    /**
     * Method to retrieve the DiagramObjectStyle via an DiagramObjectStylePrimaryKey.
     * @param 	id Long
     * @return 	DiagramObjectStyle
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramObjectStyle handle( FindDiagramObjectStyleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramObjectStyleId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjectStyles
     *
     * @param	query	FindAllDiagramObjectStyleQuery 
     * @return 	List<DiagramObjectStyle> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramObjectStyle> handle( FindAllDiagramObjectStyleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramObjectStyle, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramObjectStyle
	 */
	protected void emitFindDiagramObjectStyle( DiagramObjectStyle entity ) {
		LOGGER.info("handling emitFindDiagramObjectStyle" );
		
	    queryUpdateEmitter.emit(FindDiagramObjectStyleQuery.class,
	                            query -> query.getFilter().getDiagramObjectStyleId().equals(entity.getDiagramObjectStyleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramObjectStyle
	 * 
	 * @param		entity	DiagramObjectStyle
	 */
	protected void emitFindAllDiagramObjectStyle( DiagramObjectStyle entity ) {
		LOGGER.info("handling emitFindAllDiagramObjectStyle" );
		
	    queryUpdateEmitter.emit(FindAllDiagramObjectStyleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectStyleProjector.class.getName());

}
