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
 * Projector for DCTerminal as outlined for the CQRS pattern.  All event handling and query handling related to DCTerminal are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCTerminalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCTerminal")
@Component("dCTerminal-projector")
public class DCTerminalProjector extends DCTerminalEntityProjector {
		
	// core constructor
	public DCTerminalProjector(DCTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCTerminalEvent
     */
    @EventHandler( payloadType=CreateDCTerminalEvent.class )
    public void handle( CreateDCTerminalEvent event) {
	    LOGGER.info("handling CreateDCTerminalEvent - " + event );
	    DCTerminal entity = new DCTerminal();
        entity.setDCTerminalId( event.getDCTerminalId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTerminal( entity );
    }

    /*
     * @param	event UpdateDCTerminalEvent
     */
    @EventHandler( payloadType=UpdateDCTerminalEvent.class )
    public void handle( UpdateDCTerminalEvent event) {
    	LOGGER.info("handling UpdateDCTerminalEvent - " + event );
    	
	    DCTerminal entity = new DCTerminal();
        entity.setDCTerminalId( event.getDCTerminalId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCTerminal( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTerminal( entity );        
    }
    
    /*
     * @param	event DeleteDCTerminalEvent
     */
    @EventHandler( payloadType=DeleteDCTerminalEvent.class )
    public void handle( DeleteDCTerminalEvent event) {
    	LOGGER.info("handling DeleteDCTerminalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCTerminal entity = delete( event.getDCTerminalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCTerminal( entity );

    }    




    /**
     * Method to retrieve the DCTerminal via an DCTerminalPrimaryKey.
     * @param 	id Long
     * @return 	DCTerminal
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCTerminal handle( FindDCTerminalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCTerminalId() );
    }
    
    /**
     * Method to retrieve a collection of all DCTerminals
     *
     * @param	query	FindAllDCTerminalQuery 
     * @return 	List<DCTerminal> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCTerminal> handle( FindAllDCTerminalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCTerminal, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCTerminal
	 */
	protected void emitFindDCTerminal( DCTerminal entity ) {
		LOGGER.info("handling emitFindDCTerminal" );
		
	    queryUpdateEmitter.emit(FindDCTerminalQuery.class,
	                            query -> query.getFilter().getDCTerminalId().equals(entity.getDCTerminalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCTerminal
	 * 
	 * @param		entity	DCTerminal
	 */
	protected void emitFindAllDCTerminal( DCTerminal entity ) {
		LOGGER.info("handling emitFindAllDCTerminal" );
		
	    queryUpdateEmitter.emit(FindAllDCTerminalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCTerminalProjector.class.getName());

}
