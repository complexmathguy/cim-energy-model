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
 * Projector for Disconnector as outlined for the CQRS pattern.  All event handling and query handling related to Disconnector are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DisconnectorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("disconnector")
@Component("disconnector-projector")
public class DisconnectorProjector extends DisconnectorEntityProjector {
		
	// core constructor
	public DisconnectorProjector(DisconnectorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDisconnectorEvent
     */
    @EventHandler( payloadType=CreateDisconnectorEvent.class )
    public void handle( CreateDisconnectorEvent event) {
	    LOGGER.info("handling CreateDisconnectorEvent - " + event );
	    Disconnector entity = new Disconnector();
        entity.setDisconnectorId( event.getDisconnectorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDisconnector( entity );
    }

    /*
     * @param	event UpdateDisconnectorEvent
     */
    @EventHandler( payloadType=UpdateDisconnectorEvent.class )
    public void handle( UpdateDisconnectorEvent event) {
    	LOGGER.info("handling UpdateDisconnectorEvent - " + event );
    	
	    Disconnector entity = new Disconnector();
        entity.setDisconnectorId( event.getDisconnectorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDisconnector( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDisconnector( entity );        
    }
    
    /*
     * @param	event DeleteDisconnectorEvent
     */
    @EventHandler( payloadType=DeleteDisconnectorEvent.class )
    public void handle( DeleteDisconnectorEvent event) {
    	LOGGER.info("handling DeleteDisconnectorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Disconnector entity = delete( event.getDisconnectorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDisconnector( entity );

    }    




    /**
     * Method to retrieve the Disconnector via an DisconnectorPrimaryKey.
     * @param 	id Long
     * @return 	Disconnector
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Disconnector handle( FindDisconnectorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDisconnectorId() );
    }
    
    /**
     * Method to retrieve a collection of all Disconnectors
     *
     * @param	query	FindAllDisconnectorQuery 
     * @return 	List<Disconnector> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Disconnector> handle( FindAllDisconnectorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDisconnector, 
	 * but only if the id matches
	 * 
	 * @param		entity	Disconnector
	 */
	protected void emitFindDisconnector( Disconnector entity ) {
		LOGGER.info("handling emitFindDisconnector" );
		
	    queryUpdateEmitter.emit(FindDisconnectorQuery.class,
	                            query -> query.getFilter().getDisconnectorId().equals(entity.getDisconnectorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDisconnector
	 * 
	 * @param		entity	Disconnector
	 */
	protected void emitFindAllDisconnector( Disconnector entity ) {
		LOGGER.info("handling emitFindAllDisconnector" );
		
	    queryUpdateEmitter.emit(FindAllDisconnectorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DisconnectorProjector.class.getName());

}
