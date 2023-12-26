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
 * Projector for TopologicalNode as outlined for the CQRS pattern.  All event handling and query handling related to TopologicalNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TopologicalNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("topologicalNode")
@Component("topologicalNode-projector")
public class TopologicalNodeProjector extends TopologicalNodeEntityProjector {
		
	// core constructor
	public TopologicalNodeProjector(TopologicalNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTopologicalNodeEvent
     */
    @EventHandler( payloadType=CreateTopologicalNodeEvent.class )
    public void handle( CreateTopologicalNodeEvent event) {
	    LOGGER.info("handling CreateTopologicalNodeEvent - " + event );
	    TopologicalNode entity = new TopologicalNode();
        entity.setTopologicalNodeId( event.getTopologicalNodeId() );
        entity.setBoundaryPoint( event.getBoundaryPoint() );
        entity.setFromEndIsoCode( event.getFromEndIsoCode() );
        entity.setFromEndName( event.getFromEndName() );
        entity.setFromEndNameTso( event.getFromEndNameTso() );
        entity.setToEndIsoCode( event.getToEndIsoCode() );
        entity.setToEndName( event.getToEndName() );
        entity.setToEndNameTso( event.getToEndNameTso() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalNode( entity );
    }

    /*
     * @param	event UpdateTopologicalNodeEvent
     */
    @EventHandler( payloadType=UpdateTopologicalNodeEvent.class )
    public void handle( UpdateTopologicalNodeEvent event) {
    	LOGGER.info("handling UpdateTopologicalNodeEvent - " + event );
    	
	    TopologicalNode entity = new TopologicalNode();
        entity.setTopologicalNodeId( event.getTopologicalNodeId() );
        entity.setBoundaryPoint( event.getBoundaryPoint() );
        entity.setFromEndIsoCode( event.getFromEndIsoCode() );
        entity.setFromEndName( event.getFromEndName() );
        entity.setFromEndNameTso( event.getFromEndNameTso() );
        entity.setToEndIsoCode( event.getToEndIsoCode() );
        entity.setToEndName( event.getToEndName() );
        entity.setToEndNameTso( event.getToEndNameTso() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTopologicalNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalNode( entity );        
    }
    
    /*
     * @param	event DeleteTopologicalNodeEvent
     */
    @EventHandler( payloadType=DeleteTopologicalNodeEvent.class )
    public void handle( DeleteTopologicalNodeEvent event) {
    	LOGGER.info("handling DeleteTopologicalNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TopologicalNode entity = delete( event.getTopologicalNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTopologicalNode( entity );

    }    




    /**
     * Method to retrieve the TopologicalNode via an TopologicalNodePrimaryKey.
     * @param 	id Long
     * @return 	TopologicalNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TopologicalNode handle( FindTopologicalNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTopologicalNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all TopologicalNodes
     *
     * @param	query	FindAllTopologicalNodeQuery 
     * @return 	List<TopologicalNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TopologicalNode> handle( FindAllTopologicalNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTopologicalNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	TopologicalNode
	 */
	protected void emitFindTopologicalNode( TopologicalNode entity ) {
		LOGGER.info("handling emitFindTopologicalNode" );
		
	    queryUpdateEmitter.emit(FindTopologicalNodeQuery.class,
	                            query -> query.getFilter().getTopologicalNodeId().equals(entity.getTopologicalNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTopologicalNode
	 * 
	 * @param		entity	TopologicalNode
	 */
	protected void emitFindAllTopologicalNode( TopologicalNode entity ) {
		LOGGER.info("handling emitFindAllTopologicalNode" );
		
	    queryUpdateEmitter.emit(FindAllTopologicalNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TopologicalNodeProjector.class.getName());

}
