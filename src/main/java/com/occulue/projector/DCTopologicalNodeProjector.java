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
 * Projector for DCTopologicalNode as outlined for the CQRS pattern.  All event handling and query handling related to DCTopologicalNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCTopologicalNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCTopologicalNode")
@Component("dCTopologicalNode-projector")
public class DCTopologicalNodeProjector extends DCTopologicalNodeEntityProjector {
		
	// core constructor
	public DCTopologicalNodeProjector(DCTopologicalNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCTopologicalNodeEvent
     */
    @EventHandler( payloadType=CreateDCTopologicalNodeEvent.class )
    public void handle( CreateDCTopologicalNodeEvent event) {
	    LOGGER.info("handling CreateDCTopologicalNodeEvent - " + event );
	    DCTopologicalNode entity = new DCTopologicalNode();
        entity.setDCTopologicalNodeId( event.getDCTopologicalNodeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalNode( entity );
    }

    /*
     * @param	event UpdateDCTopologicalNodeEvent
     */
    @EventHandler( payloadType=UpdateDCTopologicalNodeEvent.class )
    public void handle( UpdateDCTopologicalNodeEvent event) {
    	LOGGER.info("handling UpdateDCTopologicalNodeEvent - " + event );
    	
	    DCTopologicalNode entity = new DCTopologicalNode();
        entity.setDCTopologicalNodeId( event.getDCTopologicalNodeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCTopologicalNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalNode( entity );        
    }
    
    /*
     * @param	event DeleteDCTopologicalNodeEvent
     */
    @EventHandler( payloadType=DeleteDCTopologicalNodeEvent.class )
    public void handle( DeleteDCTopologicalNodeEvent event) {
    	LOGGER.info("handling DeleteDCTopologicalNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCTopologicalNode entity = delete( event.getDCTopologicalNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTopologicalNode( entity );

    }    




    /**
     * Method to retrieve the DCTopologicalNode via an DCTopologicalNodePrimaryKey.
     * @param 	id Long
     * @return 	DCTopologicalNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCTopologicalNode handle( FindDCTopologicalNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCTopologicalNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all DCTopologicalNodes
     *
     * @param	query	FindAllDCTopologicalNodeQuery 
     * @return 	List<DCTopologicalNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCTopologicalNode> handle( FindAllDCTopologicalNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCTopologicalNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCTopologicalNode
	 */
	protected void emitFindDCTopologicalNode( DCTopologicalNode entity ) {
		LOGGER.info("handling emitFindDCTopologicalNode" );
		
	    queryUpdateEmitter.emit(FindDCTopologicalNodeQuery.class,
	                            query -> query.getFilter().getDCTopologicalNodeId().equals(entity.getDCTopologicalNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCTopologicalNode
	 * 
	 * @param		entity	DCTopologicalNode
	 */
	protected void emitFindAllDCTopologicalNode( DCTopologicalNode entity ) {
		LOGGER.info("handling emitFindAllDCTopologicalNode" );
		
	    queryUpdateEmitter.emit(FindAllDCTopologicalNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCTopologicalNodeProjector.class.getName());

}
