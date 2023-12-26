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
 * Projector for DiagramLayoutVersion as outlined for the CQRS pattern.  All event handling and query handling related to DiagramLayoutVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiagramLayoutVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("diagramLayoutVersion")
@Component("diagramLayoutVersion-projector")
public class DiagramLayoutVersionProjector extends DiagramLayoutVersionEntityProjector {
		
	// core constructor
	public DiagramLayoutVersionProjector(DiagramLayoutVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiagramLayoutVersionEvent
     */
    @EventHandler( payloadType=CreateDiagramLayoutVersionEvent.class )
    public void handle( CreateDiagramLayoutVersionEvent event) {
	    LOGGER.info("handling CreateDiagramLayoutVersionEvent - " + event );
	    DiagramLayoutVersion entity = new DiagramLayoutVersion();
        entity.setDiagramLayoutVersionId( event.getDiagramLayoutVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramLayoutVersion( entity );
    }

    /*
     * @param	event UpdateDiagramLayoutVersionEvent
     */
    @EventHandler( payloadType=UpdateDiagramLayoutVersionEvent.class )
    public void handle( UpdateDiagramLayoutVersionEvent event) {
    	LOGGER.info("handling UpdateDiagramLayoutVersionEvent - " + event );
    	
	    DiagramLayoutVersion entity = new DiagramLayoutVersion();
        entity.setDiagramLayoutVersionId( event.getDiagramLayoutVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiagramLayoutVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramLayoutVersion( entity );        
    }
    
    /*
     * @param	event DeleteDiagramLayoutVersionEvent
     */
    @EventHandler( payloadType=DeleteDiagramLayoutVersionEvent.class )
    public void handle( DeleteDiagramLayoutVersionEvent event) {
    	LOGGER.info("handling DeleteDiagramLayoutVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiagramLayoutVersion entity = delete( event.getDiagramLayoutVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiagramLayoutVersion( entity );

    }    




    /**
     * Method to retrieve the DiagramLayoutVersion via an DiagramLayoutVersionPrimaryKey.
     * @param 	id Long
     * @return 	DiagramLayoutVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiagramLayoutVersion handle( FindDiagramLayoutVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiagramLayoutVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all DiagramLayoutVersions
     *
     * @param	query	FindAllDiagramLayoutVersionQuery 
     * @return 	List<DiagramLayoutVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiagramLayoutVersion> handle( FindAllDiagramLayoutVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiagramLayoutVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiagramLayoutVersion
	 */
	protected void emitFindDiagramLayoutVersion( DiagramLayoutVersion entity ) {
		LOGGER.info("handling emitFindDiagramLayoutVersion" );
		
	    queryUpdateEmitter.emit(FindDiagramLayoutVersionQuery.class,
	                            query -> query.getFilter().getDiagramLayoutVersionId().equals(entity.getDiagramLayoutVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiagramLayoutVersion
	 * 
	 * @param		entity	DiagramLayoutVersion
	 */
	protected void emitFindAllDiagramLayoutVersion( DiagramLayoutVersion entity ) {
		LOGGER.info("handling emitFindAllDiagramLayoutVersion" );
		
	    queryUpdateEmitter.emit(FindAllDiagramLayoutVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiagramLayoutVersionProjector.class.getName());

}
