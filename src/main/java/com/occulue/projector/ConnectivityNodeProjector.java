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
 * Projector for ConnectivityNode as outlined for the CQRS pattern.  All event handling and query handling related to ConnectivityNode are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConnectivityNodeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("connectivityNode")
@Component("connectivityNode-projector")
public class ConnectivityNodeProjector extends ConnectivityNodeEntityProjector {
		
	// core constructor
	public ConnectivityNodeProjector(ConnectivityNodeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConnectivityNodeEvent
     */
    @EventHandler( payloadType=CreateConnectivityNodeEvent.class )
    public void handle( CreateConnectivityNodeEvent event) {
	    LOGGER.info("handling CreateConnectivityNodeEvent - " + event );
	    ConnectivityNode entity = new ConnectivityNode();
        entity.setConnectivityNodeId( event.getConnectivityNodeId() );
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
        emitFindAllConnectivityNode( entity );
    }

    /*
     * @param	event UpdateConnectivityNodeEvent
     */
    @EventHandler( payloadType=UpdateConnectivityNodeEvent.class )
    public void handle( UpdateConnectivityNodeEvent event) {
    	LOGGER.info("handling UpdateConnectivityNodeEvent - " + event );
    	
	    ConnectivityNode entity = new ConnectivityNode();
        entity.setConnectivityNodeId( event.getConnectivityNodeId() );
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
        emitFindConnectivityNode( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnectivityNode( entity );        
    }
    
    /*
     * @param	event DeleteConnectivityNodeEvent
     */
    @EventHandler( payloadType=DeleteConnectivityNodeEvent.class )
    public void handle( DeleteConnectivityNodeEvent event) {
    	LOGGER.info("handling DeleteConnectivityNodeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConnectivityNode entity = delete( event.getConnectivityNodeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnectivityNode( entity );

    }    




    /**
     * Method to retrieve the ConnectivityNode via an ConnectivityNodePrimaryKey.
     * @param 	id Long
     * @return 	ConnectivityNode
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConnectivityNode handle( FindConnectivityNodeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConnectivityNodeId() );
    }
    
    /**
     * Method to retrieve a collection of all ConnectivityNodes
     *
     * @param	query	FindAllConnectivityNodeQuery 
     * @return 	List<ConnectivityNode> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConnectivityNode> handle( FindAllConnectivityNodeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConnectivityNode, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConnectivityNode
	 */
	protected void emitFindConnectivityNode( ConnectivityNode entity ) {
		LOGGER.info("handling emitFindConnectivityNode" );
		
	    queryUpdateEmitter.emit(FindConnectivityNodeQuery.class,
	                            query -> query.getFilter().getConnectivityNodeId().equals(entity.getConnectivityNodeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConnectivityNode
	 * 
	 * @param		entity	ConnectivityNode
	 */
	protected void emitFindAllConnectivityNode( ConnectivityNode entity ) {
		LOGGER.info("handling emitFindAllConnectivityNode" );
		
	    queryUpdateEmitter.emit(FindAllConnectivityNodeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConnectivityNodeProjector.class.getName());

}
