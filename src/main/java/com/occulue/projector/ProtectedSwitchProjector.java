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
 * Projector for ProtectedSwitch as outlined for the CQRS pattern.  All event handling and query handling related to ProtectedSwitch are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ProtectedSwitchAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("protectedSwitch")
@Component("protectedSwitch-projector")
public class ProtectedSwitchProjector extends ProtectedSwitchEntityProjector {
		
	// core constructor
	public ProtectedSwitchProjector(ProtectedSwitchRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateProtectedSwitchEvent
     */
    @EventHandler( payloadType=CreateProtectedSwitchEvent.class )
    public void handle( CreateProtectedSwitchEvent event) {
	    LOGGER.info("handling CreateProtectedSwitchEvent - " + event );
	    ProtectedSwitch entity = new ProtectedSwitch();
        entity.setProtectedSwitchId( event.getProtectedSwitchId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProtectedSwitch( entity );
    }

    /*
     * @param	event UpdateProtectedSwitchEvent
     */
    @EventHandler( payloadType=UpdateProtectedSwitchEvent.class )
    public void handle( UpdateProtectedSwitchEvent event) {
    	LOGGER.info("handling UpdateProtectedSwitchEvent - " + event );
    	
	    ProtectedSwitch entity = new ProtectedSwitch();
        entity.setProtectedSwitchId( event.getProtectedSwitchId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindProtectedSwitch( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProtectedSwitch( entity );        
    }
    
    /*
     * @param	event DeleteProtectedSwitchEvent
     */
    @EventHandler( payloadType=DeleteProtectedSwitchEvent.class )
    public void handle( DeleteProtectedSwitchEvent event) {
    	LOGGER.info("handling DeleteProtectedSwitchEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ProtectedSwitch entity = delete( event.getProtectedSwitchId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProtectedSwitch( entity );

    }    




    /**
     * Method to retrieve the ProtectedSwitch via an ProtectedSwitchPrimaryKey.
     * @param 	id Long
     * @return 	ProtectedSwitch
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ProtectedSwitch handle( FindProtectedSwitchQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getProtectedSwitchId() );
    }
    
    /**
     * Method to retrieve a collection of all ProtectedSwitchs
     *
     * @param	query	FindAllProtectedSwitchQuery 
     * @return 	List<ProtectedSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ProtectedSwitch> handle( FindAllProtectedSwitchQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindProtectedSwitch, 
	 * but only if the id matches
	 * 
	 * @param		entity	ProtectedSwitch
	 */
	protected void emitFindProtectedSwitch( ProtectedSwitch entity ) {
		LOGGER.info("handling emitFindProtectedSwitch" );
		
	    queryUpdateEmitter.emit(FindProtectedSwitchQuery.class,
	                            query -> query.getFilter().getProtectedSwitchId().equals(entity.getProtectedSwitchId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllProtectedSwitch
	 * 
	 * @param		entity	ProtectedSwitch
	 */
	protected void emitFindAllProtectedSwitch( ProtectedSwitch entity ) {
		LOGGER.info("handling emitFindAllProtectedSwitch" );
		
	    queryUpdateEmitter.emit(FindAllProtectedSwitchQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ProtectedSwitchProjector.class.getName());

}
