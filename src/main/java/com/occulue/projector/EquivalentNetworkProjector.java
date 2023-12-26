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
 * Projector for EquivalentNetwork as outlined for the CQRS pattern.  All event handling and query handling related to EquivalentNetwork are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquivalentNetworkAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equivalentNetwork")
@Component("equivalentNetwork-projector")
public class EquivalentNetworkProjector extends EquivalentNetworkEntityProjector {
		
	// core constructor
	public EquivalentNetworkProjector(EquivalentNetworkRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquivalentNetworkEvent
     */
    @EventHandler( payloadType=CreateEquivalentNetworkEvent.class )
    public void handle( CreateEquivalentNetworkEvent event) {
	    LOGGER.info("handling CreateEquivalentNetworkEvent - " + event );
	    EquivalentNetwork entity = new EquivalentNetwork();
        entity.setEquivalentNetworkId( event.getEquivalentNetworkId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentNetwork( entity );
    }

    /*
     * @param	event UpdateEquivalentNetworkEvent
     */
    @EventHandler( payloadType=UpdateEquivalentNetworkEvent.class )
    public void handle( UpdateEquivalentNetworkEvent event) {
    	LOGGER.info("handling UpdateEquivalentNetworkEvent - " + event );
    	
	    EquivalentNetwork entity = new EquivalentNetwork();
        entity.setEquivalentNetworkId( event.getEquivalentNetworkId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquivalentNetwork( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentNetwork( entity );        
    }
    
    /*
     * @param	event DeleteEquivalentNetworkEvent
     */
    @EventHandler( payloadType=DeleteEquivalentNetworkEvent.class )
    public void handle( DeleteEquivalentNetworkEvent event) {
    	LOGGER.info("handling DeleteEquivalentNetworkEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquivalentNetwork entity = delete( event.getEquivalentNetworkId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentNetwork( entity );

    }    




    /**
     * Method to retrieve the EquivalentNetwork via an EquivalentNetworkPrimaryKey.
     * @param 	id Long
     * @return 	EquivalentNetwork
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquivalentNetwork handle( FindEquivalentNetworkQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquivalentNetworkId() );
    }
    
    /**
     * Method to retrieve a collection of all EquivalentNetworks
     *
     * @param	query	FindAllEquivalentNetworkQuery 
     * @return 	List<EquivalentNetwork> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquivalentNetwork> handle( FindAllEquivalentNetworkQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquivalentNetwork, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquivalentNetwork
	 */
	protected void emitFindEquivalentNetwork( EquivalentNetwork entity ) {
		LOGGER.info("handling emitFindEquivalentNetwork" );
		
	    queryUpdateEmitter.emit(FindEquivalentNetworkQuery.class,
	                            query -> query.getFilter().getEquivalentNetworkId().equals(entity.getEquivalentNetworkId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquivalentNetwork
	 * 
	 * @param		entity	EquivalentNetwork
	 */
	protected void emitFindAllEquivalentNetwork( EquivalentNetwork entity ) {
		LOGGER.info("handling emitFindAllEquivalentNetwork" );
		
	    queryUpdateEmitter.emit(FindAllEquivalentNetworkQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquivalentNetworkProjector.class.getName());

}
