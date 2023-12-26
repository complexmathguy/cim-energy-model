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
 * Projector for ENTSOETopologicalNode as outlined for the CQRS pattern.  All event handling and query handling related to ENTSOETopologicalNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ENTSOETopologicalNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("eNTSOETopologicalNode")
@Component("eNTSOETopologicalNode-projector")
public class ENTSOETopologicalNodeProjector extends ENTSOETopologicalNodeEntityProjector {
		
	// core constructor
	public ENTSOETopologicalNodeProjector(ENTSOETopologicalNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateENTSOETopologicalNodeEvent
     */
    @EventHandler( payloadType=CreateENTSOETopologicalNodeEvent.class )
    public void handle( CreateENTSOETopologicalNodeEvent event) {
	    LOGGER.info("handling CreateENTSOETopologicalNodeEvent - " + event );
	    ENTSOETopologicalNode entity = new ENTSOETopologicalNode();
        entity.setENTSOETopologicalNodeId( event.getENTSOETopologicalNodeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOETopologicalNode( entity );
    }

    /*
     * @param	event UpdateENTSOETopologicalNodeEvent
     */
    @EventHandler( payloadType=UpdateENTSOETopologicalNodeEvent.class )
    public void handle( UpdateENTSOETopologicalNodeEvent event) {
    	LOGGER.info("handling UpdateENTSOETopologicalNodeEvent - " + event );
    	
	    ENTSOETopologicalNode entity = new ENTSOETopologicalNode();
        entity.setENTSOETopologicalNodeId( event.getENTSOETopologicalNodeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindENTSOETopologicalNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOETopologicalNode( entity );        
    }
    
    /*
     * @param	event DeleteENTSOETopologicalNodeEvent
     */
    @EventHandler( payloadType=DeleteENTSOETopologicalNodeEvent.class )
    public void handle( DeleteENTSOETopologicalNodeEvent event) {
    	LOGGER.info("handling DeleteENTSOETopologicalNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ENTSOETopologicalNode entity = delete( event.getENTSOETopologicalNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOETopologicalNode( entity );

    }    




    /**
     * Method to retrieve the ENTSOETopologicalNode via an ENTSOETopologicalNodePrimaryKey.
     * @param 	id Long
     * @return 	ENTSOETopologicalNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ENTSOETopologicalNode handle( FindENTSOETopologicalNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getENTSOETopologicalNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all ENTSOETopologicalNodes
     *
     * @param	query	FindAllENTSOETopologicalNodeQuery 
     * @return 	List<ENTSOETopologicalNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ENTSOETopologicalNode> handle( FindAllENTSOETopologicalNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindENTSOETopologicalNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	ENTSOETopologicalNode
	 */
	protected void emitFindENTSOETopologicalNode( ENTSOETopologicalNode entity ) {
		LOGGER.info("handling emitFindENTSOETopologicalNode" );
		
	    queryUpdateEmitter.emit(FindENTSOETopologicalNodeQuery.class,
	                            query -> query.getFilter().getENTSOETopologicalNodeId().equals(entity.getENTSOETopologicalNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllENTSOETopologicalNode
	 * 
	 * @param		entity	ENTSOETopologicalNode
	 */
	protected void emitFindAllENTSOETopologicalNode( ENTSOETopologicalNode entity ) {
		LOGGER.info("handling emitFindAllENTSOETopologicalNode" );
		
	    queryUpdateEmitter.emit(FindAllENTSOETopologicalNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ENTSOETopologicalNodeProjector.class.getName());

}
