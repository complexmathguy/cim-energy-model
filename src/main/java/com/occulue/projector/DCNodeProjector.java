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
 * Projector for DCNode as outlined for the CQRS pattern.  All event handling and query handling related to DCNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCNode")
@Component("dCNode-projector")
public class DCNodeProjector extends DCNodeEntityProjector {
		
	// core constructor
	public DCNodeProjector(DCNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCNodeEvent
     */
    @EventHandler( payloadType=CreateDCNodeEvent.class )
    public void handle( CreateDCNodeEvent event) {
	    LOGGER.info("handling CreateDCNodeEvent - " + event );
	    DCNode entity = new DCNode();
        entity.setDCNodeId( event.getDCNodeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCNode( entity );
    }

    /*
     * @param	event UpdateDCNodeEvent
     */
    @EventHandler( payloadType=UpdateDCNodeEvent.class )
    public void handle( UpdateDCNodeEvent event) {
    	LOGGER.info("handling UpdateDCNodeEvent - " + event );
    	
	    DCNode entity = new DCNode();
        entity.setDCNodeId( event.getDCNodeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCNode( entity );        
    }
    
    /*
     * @param	event DeleteDCNodeEvent
     */
    @EventHandler( payloadType=DeleteDCNodeEvent.class )
    public void handle( DeleteDCNodeEvent event) {
    	LOGGER.info("handling DeleteDCNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCNode entity = delete( event.getDCNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCNode( entity );

    }    




    /**
     * Method to retrieve the DCNode via an DCNodePrimaryKey.
     * @param 	id Long
     * @return 	DCNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCNode handle( FindDCNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all DCNodes
     *
     * @param	query	FindAllDCNodeQuery 
     * @return 	List<DCNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCNode> handle( FindAllDCNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCNode
	 */
	protected void emitFindDCNode( DCNode entity ) {
		LOGGER.info("handling emitFindDCNode" );
		
	    queryUpdateEmitter.emit(FindDCNodeQuery.class,
	                            query -> query.getFilter().getDCNodeId().equals(entity.getDCNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCNode
	 * 
	 * @param		entity	DCNode
	 */
	protected void emitFindAllDCNode( DCNode entity ) {
		LOGGER.info("handling emitFindAllDCNode" );
		
	    queryUpdateEmitter.emit(FindAllDCNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCNodeProjector.class.getName());

}
