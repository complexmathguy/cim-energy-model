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
 * Projector for ConnectivityNodeContainer as outlined for the CQRS pattern.  All event handling and query handling related to ConnectivityNodeContainer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConnectivityNodeContainerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("connectivityNodeContainer")
@Component("connectivityNodeContainer-projector")
public class ConnectivityNodeContainerProjector extends ConnectivityNodeContainerEntityProjector {
		
	// core constructor
	public ConnectivityNodeContainerProjector(ConnectivityNodeContainerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConnectivityNodeContainerEvent
     */
    @EventHandler( payloadType=CreateConnectivityNodeContainerEvent.class )
    public void handle( CreateConnectivityNodeContainerEvent event) {
	    LOGGER.info("handling CreateConnectivityNodeContainerEvent - " + event );
	    ConnectivityNodeContainer entity = new ConnectivityNodeContainer();
        entity.setConnectivityNodeContainerId( event.getConnectivityNodeContainerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnectivityNodeContainer( entity );
    }

    /*
     * @param	event UpdateConnectivityNodeContainerEvent
     */
    @EventHandler( payloadType=UpdateConnectivityNodeContainerEvent.class )
    public void handle( UpdateConnectivityNodeContainerEvent event) {
    	LOGGER.info("handling UpdateConnectivityNodeContainerEvent - " + event );
    	
	    ConnectivityNodeContainer entity = new ConnectivityNodeContainer();
        entity.setConnectivityNodeContainerId( event.getConnectivityNodeContainerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConnectivityNodeContainer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnectivityNodeContainer( entity );        
    }
    
    /*
     * @param	event DeleteConnectivityNodeContainerEvent
     */
    @EventHandler( payloadType=DeleteConnectivityNodeContainerEvent.class )
    public void handle( DeleteConnectivityNodeContainerEvent event) {
    	LOGGER.info("handling DeleteConnectivityNodeContainerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConnectivityNodeContainer entity = delete( event.getConnectivityNodeContainerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnectivityNodeContainer( entity );

    }    




    /**
     * Method to retrieve the ConnectivityNodeContainer via an ConnectivityNodeContainerPrimaryKey.
     * @param 	id Long
     * @return 	ConnectivityNodeContainer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConnectivityNodeContainer handle( FindConnectivityNodeContainerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConnectivityNodeContainerId() );
    }
    
    /**
     * Method to retrieve a collection of all ConnectivityNodeContainers
     *
     * @param	query	FindAllConnectivityNodeContainerQuery 
     * @return 	List<ConnectivityNodeContainer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConnectivityNodeContainer> handle( FindAllConnectivityNodeContainerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConnectivityNodeContainer, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConnectivityNodeContainer
	 */
	protected void emitFindConnectivityNodeContainer( ConnectivityNodeContainer entity ) {
		LOGGER.info("handling emitFindConnectivityNodeContainer" );
		
	    queryUpdateEmitter.emit(FindConnectivityNodeContainerQuery.class,
	                            query -> query.getFilter().getConnectivityNodeContainerId().equals(entity.getConnectivityNodeContainerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConnectivityNodeContainer
	 * 
	 * @param		entity	ConnectivityNodeContainer
	 */
	protected void emitFindAllConnectivityNodeContainer( ConnectivityNodeContainer entity ) {
		LOGGER.info("handling emitFindAllConnectivityNodeContainer" );
		
	    queryUpdateEmitter.emit(FindAllConnectivityNodeContainerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConnectivityNodeContainerProjector.class.getName());

}
