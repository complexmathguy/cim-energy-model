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
 * Projector for TopologyVersion as outlined for the CQRS pattern.  All event handling and query handling related to TopologyVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TopologyVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("topologyVersion")
@Component("topologyVersion-projector")
public class TopologyVersionProjector extends TopologyVersionEntityProjector {
		
	// core constructor
	public TopologyVersionProjector(TopologyVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTopologyVersionEvent
     */
    @EventHandler( payloadType=CreateTopologyVersionEvent.class )
    public void handle( CreateTopologyVersionEvent event) {
	    LOGGER.info("handling CreateTopologyVersionEvent - " + event );
	    TopologyVersion entity = new TopologyVersion();
        entity.setTopologyVersionId( event.getTopologyVersionId() );
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
        emitFindAllTopologyVersion( entity );
    }

    /*
     * @param	event UpdateTopologyVersionEvent
     */
    @EventHandler( payloadType=UpdateTopologyVersionEvent.class )
    public void handle( UpdateTopologyVersionEvent event) {
    	LOGGER.info("handling UpdateTopologyVersionEvent - " + event );
    	
	    TopologyVersion entity = new TopologyVersion();
        entity.setTopologyVersionId( event.getTopologyVersionId() );
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
        emitFindTopologyVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologyVersion( entity );        
    }
    
    /*
     * @param	event DeleteTopologyVersionEvent
     */
    @EventHandler( payloadType=DeleteTopologyVersionEvent.class )
    public void handle( DeleteTopologyVersionEvent event) {
    	LOGGER.info("handling DeleteTopologyVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TopologyVersion entity = delete( event.getTopologyVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologyVersion( entity );

    }    




    /**
     * Method to retrieve the TopologyVersion via an TopologyVersionPrimaryKey.
     * @param 	id Long
     * @return 	TopologyVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TopologyVersion handle( FindTopologyVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTopologyVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all TopologyVersions
     *
     * @param	query	FindAllTopologyVersionQuery 
     * @return 	List<TopologyVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TopologyVersion> handle( FindAllTopologyVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTopologyVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	TopologyVersion
	 */
	protected void emitFindTopologyVersion( TopologyVersion entity ) {
		LOGGER.info("handling emitFindTopologyVersion" );
		
	    queryUpdateEmitter.emit(FindTopologyVersionQuery.class,
	                            query -> query.getFilter().getTopologyVersionId().equals(entity.getTopologyVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTopologyVersion
	 * 
	 * @param		entity	TopologyVersion
	 */
	protected void emitFindAllTopologyVersion( TopologyVersion entity ) {
		LOGGER.info("handling emitFindAllTopologyVersion" );
		
	    queryUpdateEmitter.emit(FindAllTopologyVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TopologyVersionProjector.class.getName());

}
