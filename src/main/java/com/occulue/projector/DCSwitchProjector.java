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
 * Projector for DCSwitch as outlined for the CQRS pattern.  All event handling and query handling related to DCSwitch are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCSwitchAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCSwitch")
@Component("dCSwitch-projector")
public class DCSwitchProjector extends DCSwitchEntityProjector {
		
	// core constructor
	public DCSwitchProjector(DCSwitchRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCSwitchEvent
     */
    @EventHandler( payloadType=CreateDCSwitchEvent.class )
    public void handle( CreateDCSwitchEvent event) {
	    LOGGER.info("handling CreateDCSwitchEvent - " + event );
	    DCSwitch entity = new DCSwitch();
        entity.setDCSwitchId( event.getDCSwitchId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSwitch( entity );
    }

    /*
     * @param	event UpdateDCSwitchEvent
     */
    @EventHandler( payloadType=UpdateDCSwitchEvent.class )
    public void handle( UpdateDCSwitchEvent event) {
    	LOGGER.info("handling UpdateDCSwitchEvent - " + event );
    	
	    DCSwitch entity = new DCSwitch();
        entity.setDCSwitchId( event.getDCSwitchId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCSwitch( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSwitch( entity );        
    }
    
    /*
     * @param	event DeleteDCSwitchEvent
     */
    @EventHandler( payloadType=DeleteDCSwitchEvent.class )
    public void handle( DeleteDCSwitchEvent event) {
    	LOGGER.info("handling DeleteDCSwitchEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCSwitch entity = delete( event.getDCSwitchId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSwitch( entity );

    }    




    /**
     * Method to retrieve the DCSwitch via an DCSwitchPrimaryKey.
     * @param 	id Long
     * @return 	DCSwitch
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCSwitch handle( FindDCSwitchQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCSwitchId() );
    }
    
    /**
     * Method to retrieve a collection of all DCSwitchs
     *
     * @param	query	FindAllDCSwitchQuery 
     * @return 	List<DCSwitch> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCSwitch> handle( FindAllDCSwitchQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCSwitch, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCSwitch
	 */
	protected void emitFindDCSwitch( DCSwitch entity ) {
		LOGGER.info("handling emitFindDCSwitch" );
		
	    queryUpdateEmitter.emit(FindDCSwitchQuery.class,
	                            query -> query.getFilter().getDCSwitchId().equals(entity.getDCSwitchId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCSwitch
	 * 
	 * @param		entity	DCSwitch
	 */
	protected void emitFindAllDCSwitch( DCSwitch entity ) {
		LOGGER.info("handling emitFindAllDCSwitch" );
		
	    queryUpdateEmitter.emit(FindAllDCSwitchQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCSwitchProjector.class.getName());

}
