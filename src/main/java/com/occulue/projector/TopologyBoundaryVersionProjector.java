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
 * Projector for TopologyBoundaryVersion as outlined for the CQRS pattern.  All event handling and query handling related to TopologyBoundaryVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TopologyBoundaryVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("topologyBoundaryVersion")
@Component("topologyBoundaryVersion-projector")
public class TopologyBoundaryVersionProjector extends TopologyBoundaryVersionEntityProjector {
		
	// core constructor
	public TopologyBoundaryVersionProjector(TopologyBoundaryVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTopologyBoundaryVersionEvent
     */
    @EventHandler( payloadType=CreateTopologyBoundaryVersionEvent.class )
    public void handle( CreateTopologyBoundaryVersionEvent event) {
	    LOGGER.info("handling CreateTopologyBoundaryVersionEvent - " + event );
	    TopologyBoundaryVersion entity = new TopologyBoundaryVersion();
        entity.setTopologyBoundaryVersionId( event.getTopologyBoundaryVersionId() );
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
        emitFindAllTopologyBoundaryVersion( entity );
    }

    /*
     * @param	event UpdateTopologyBoundaryVersionEvent
     */
    @EventHandler( payloadType=UpdateTopologyBoundaryVersionEvent.class )
    public void handle( UpdateTopologyBoundaryVersionEvent event) {
    	LOGGER.info("handling UpdateTopologyBoundaryVersionEvent - " + event );
    	
	    TopologyBoundaryVersion entity = new TopologyBoundaryVersion();
        entity.setTopologyBoundaryVersionId( event.getTopologyBoundaryVersionId() );
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
        emitFindTopologyBoundaryVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologyBoundaryVersion( entity );        
    }
    
    /*
     * @param	event DeleteTopologyBoundaryVersionEvent
     */
    @EventHandler( payloadType=DeleteTopologyBoundaryVersionEvent.class )
    public void handle( DeleteTopologyBoundaryVersionEvent event) {
    	LOGGER.info("handling DeleteTopologyBoundaryVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TopologyBoundaryVersion entity = delete( event.getTopologyBoundaryVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologyBoundaryVersion( entity );

    }    




    /**
     * Method to retrieve the TopologyBoundaryVersion via an TopologyBoundaryVersionPrimaryKey.
     * @param 	id Long
     * @return 	TopologyBoundaryVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TopologyBoundaryVersion handle( FindTopologyBoundaryVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTopologyBoundaryVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all TopologyBoundaryVersions
     *
     * @param	query	FindAllTopologyBoundaryVersionQuery 
     * @return 	List<TopologyBoundaryVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TopologyBoundaryVersion> handle( FindAllTopologyBoundaryVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTopologyBoundaryVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	TopologyBoundaryVersion
	 */
	protected void emitFindTopologyBoundaryVersion( TopologyBoundaryVersion entity ) {
		LOGGER.info("handling emitFindTopologyBoundaryVersion" );
		
	    queryUpdateEmitter.emit(FindTopologyBoundaryVersionQuery.class,
	                            query -> query.getFilter().getTopologyBoundaryVersionId().equals(entity.getTopologyBoundaryVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTopologyBoundaryVersion
	 * 
	 * @param		entity	TopologyBoundaryVersion
	 */
	protected void emitFindAllTopologyBoundaryVersion( TopologyBoundaryVersion entity ) {
		LOGGER.info("handling emitFindAllTopologyBoundaryVersion" );
		
	    queryUpdateEmitter.emit(FindAllTopologyBoundaryVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TopologyBoundaryVersionProjector.class.getName());

}
