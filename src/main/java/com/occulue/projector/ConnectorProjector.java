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
 * Projector for Connector as outlined for the CQRS pattern.  All event handling and query handling related to Connector are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConnectorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("connector")
@Component("connector-projector")
public class ConnectorProjector extends ConnectorEntityProjector {
		
	// core constructor
	public ConnectorProjector(ConnectorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConnectorEvent
     */
    @EventHandler( payloadType=CreateConnectorEvent.class )
    public void handle( CreateConnectorEvent event) {
	    LOGGER.info("handling CreateConnectorEvent - " + event );
	    Connector entity = new Connector();
        entity.setConnectorId( event.getConnectorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnector( entity );
    }

    /*
     * @param	event UpdateConnectorEvent
     */
    @EventHandler( payloadType=UpdateConnectorEvent.class )
    public void handle( UpdateConnectorEvent event) {
    	LOGGER.info("handling UpdateConnectorEvent - " + event );
    	
	    Connector entity = new Connector();
        entity.setConnectorId( event.getConnectorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConnector( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnector( entity );        
    }
    
    /*
     * @param	event DeleteConnectorEvent
     */
    @EventHandler( payloadType=DeleteConnectorEvent.class )
    public void handle( DeleteConnectorEvent event) {
    	LOGGER.info("handling DeleteConnectorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Connector entity = delete( event.getConnectorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConnector( entity );

    }    




    /**
     * Method to retrieve the Connector via an ConnectorPrimaryKey.
     * @param 	id Long
     * @return 	Connector
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Connector handle( FindConnectorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConnectorId() );
    }
    
    /**
     * Method to retrieve a collection of all Connectors
     *
     * @param	query	FindAllConnectorQuery 
     * @return 	List<Connector> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Connector> handle( FindAllConnectorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConnector, 
	 * but only if the id matches
	 * 
	 * @param		entity	Connector
	 */
	protected void emitFindConnector( Connector entity ) {
		LOGGER.info("handling emitFindConnector" );
		
	    queryUpdateEmitter.emit(FindConnectorQuery.class,
	                            query -> query.getFilter().getConnectorId().equals(entity.getConnectorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConnector
	 * 
	 * @param		entity	Connector
	 */
	protected void emitFindAllConnector( Connector entity ) {
		LOGGER.info("handling emitFindAllConnector" );
		
	    queryUpdateEmitter.emit(FindAllConnectorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConnectorProjector.class.getName());

}
