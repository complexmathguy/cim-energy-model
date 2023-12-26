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
 * Projector for DCBusbar as outlined for the CQRS pattern.  All event handling and query handling related to DCBusbar are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCBusbarAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCBusbar")
@Component("dCBusbar-projector")
public class DCBusbarProjector extends DCBusbarEntityProjector {
		
	// core constructor
	public DCBusbarProjector(DCBusbarRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCBusbarEvent
     */
    @EventHandler( payloadType=CreateDCBusbarEvent.class )
    public void handle( CreateDCBusbarEvent event) {
	    LOGGER.info("handling CreateDCBusbarEvent - " + event );
	    DCBusbar entity = new DCBusbar();
        entity.setDCBusbarId( event.getDCBusbarId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBusbar( entity );
    }

    /*
     * @param	event UpdateDCBusbarEvent
     */
    @EventHandler( payloadType=UpdateDCBusbarEvent.class )
    public void handle( UpdateDCBusbarEvent event) {
    	LOGGER.info("handling UpdateDCBusbarEvent - " + event );
    	
	    DCBusbar entity = new DCBusbar();
        entity.setDCBusbarId( event.getDCBusbarId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCBusbar( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBusbar( entity );        
    }
    
    /*
     * @param	event DeleteDCBusbarEvent
     */
    @EventHandler( payloadType=DeleteDCBusbarEvent.class )
    public void handle( DeleteDCBusbarEvent event) {
    	LOGGER.info("handling DeleteDCBusbarEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCBusbar entity = delete( event.getDCBusbarId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBusbar( entity );

    }    




    /**
     * Method to retrieve the DCBusbar via an DCBusbarPrimaryKey.
     * @param 	id Long
     * @return 	DCBusbar
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCBusbar handle( FindDCBusbarQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCBusbarId() );
    }
    
    /**
     * Method to retrieve a collection of all DCBusbars
     *
     * @param	query	FindAllDCBusbarQuery 
     * @return 	List<DCBusbar> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCBusbar> handle( FindAllDCBusbarQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCBusbar, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCBusbar
	 */
	protected void emitFindDCBusbar( DCBusbar entity ) {
		LOGGER.info("handling emitFindDCBusbar" );
		
	    queryUpdateEmitter.emit(FindDCBusbarQuery.class,
	                            query -> query.getFilter().getDCBusbarId().equals(entity.getDCBusbarId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCBusbar
	 * 
	 * @param		entity	DCBusbar
	 */
	protected void emitFindAllDCBusbar( DCBusbar entity ) {
		LOGGER.info("handling emitFindAllDCBusbar" );
		
	    queryUpdateEmitter.emit(FindAllDCBusbarQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCBusbarProjector.class.getName());

}
