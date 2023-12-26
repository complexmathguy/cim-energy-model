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
 * Projector for ENTSOEConnectivityNode as outlined for the CQRS pattern.  All event handling and query handling related to ENTSOEConnectivityNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ENTSOEConnectivityNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("eNTSOEConnectivityNode")
@Component("eNTSOEConnectivityNode-projector")
public class ENTSOEConnectivityNodeProjector extends ENTSOEConnectivityNodeEntityProjector {
		
	// core constructor
	public ENTSOEConnectivityNodeProjector(ENTSOEConnectivityNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateENTSOEConnectivityNodeEvent
     */
    @EventHandler( payloadType=CreateENTSOEConnectivityNodeEvent.class )
    public void handle( CreateENTSOEConnectivityNodeEvent event) {
	    LOGGER.info("handling CreateENTSOEConnectivityNodeEvent - " + event );
	    ENTSOEConnectivityNode entity = new ENTSOEConnectivityNode();
        entity.setENTSOEConnectivityNodeId( event.getENTSOEConnectivityNodeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEConnectivityNode( entity );
    }

    /*
     * @param	event UpdateENTSOEConnectivityNodeEvent
     */
    @EventHandler( payloadType=UpdateENTSOEConnectivityNodeEvent.class )
    public void handle( UpdateENTSOEConnectivityNodeEvent event) {
    	LOGGER.info("handling UpdateENTSOEConnectivityNodeEvent - " + event );
    	
	    ENTSOEConnectivityNode entity = new ENTSOEConnectivityNode();
        entity.setENTSOEConnectivityNodeId( event.getENTSOEConnectivityNodeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindENTSOEConnectivityNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEConnectivityNode( entity );        
    }
    
    /*
     * @param	event DeleteENTSOEConnectivityNodeEvent
     */
    @EventHandler( payloadType=DeleteENTSOEConnectivityNodeEvent.class )
    public void handle( DeleteENTSOEConnectivityNodeEvent event) {
    	LOGGER.info("handling DeleteENTSOEConnectivityNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ENTSOEConnectivityNode entity = delete( event.getENTSOEConnectivityNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEConnectivityNode( entity );

    }    




    /**
     * Method to retrieve the ENTSOEConnectivityNode via an ENTSOEConnectivityNodePrimaryKey.
     * @param 	id Long
     * @return 	ENTSOEConnectivityNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ENTSOEConnectivityNode handle( FindENTSOEConnectivityNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getENTSOEConnectivityNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all ENTSOEConnectivityNodes
     *
     * @param	query	FindAllENTSOEConnectivityNodeQuery 
     * @return 	List<ENTSOEConnectivityNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ENTSOEConnectivityNode> handle( FindAllENTSOEConnectivityNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindENTSOEConnectivityNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	ENTSOEConnectivityNode
	 */
	protected void emitFindENTSOEConnectivityNode( ENTSOEConnectivityNode entity ) {
		LOGGER.info("handling emitFindENTSOEConnectivityNode" );
		
	    queryUpdateEmitter.emit(FindENTSOEConnectivityNodeQuery.class,
	                            query -> query.getFilter().getENTSOEConnectivityNodeId().equals(entity.getENTSOEConnectivityNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllENTSOEConnectivityNode
	 * 
	 * @param		entity	ENTSOEConnectivityNode
	 */
	protected void emitFindAllENTSOEConnectivityNode( ENTSOEConnectivityNode entity ) {
		LOGGER.info("handling emitFindAllENTSOEConnectivityNode" );
		
	    queryUpdateEmitter.emit(FindAllENTSOEConnectivityNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEConnectivityNodeProjector.class.getName());

}
