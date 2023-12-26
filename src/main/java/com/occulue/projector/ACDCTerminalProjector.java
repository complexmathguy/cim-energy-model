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
 * Projector for ACDCTerminal as outlined for the CQRS pattern.  All event handling and query handling related to ACDCTerminal are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ACDCTerminalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("aCDCTerminal")
@Component("aCDCTerminal-projector")
public class ACDCTerminalProjector extends ACDCTerminalEntityProjector {
		
	// core constructor
	public ACDCTerminalProjector(ACDCTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateACDCTerminalEvent
     */
    @EventHandler( payloadType=CreateACDCTerminalEvent.class )
    public void handle( CreateACDCTerminalEvent event) {
	    LOGGER.info("handling CreateACDCTerminalEvent - " + event );
	    ACDCTerminal entity = new ACDCTerminal();
        entity.setACDCTerminalId( event.getACDCTerminalId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCTerminal( entity );
    }

    /*
     * @param	event UpdateACDCTerminalEvent
     */
    @EventHandler( payloadType=UpdateACDCTerminalEvent.class )
    public void handle( UpdateACDCTerminalEvent event) {
    	LOGGER.info("handling UpdateACDCTerminalEvent - " + event );
    	
	    ACDCTerminal entity = new ACDCTerminal();
        entity.setACDCTerminalId( event.getACDCTerminalId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindACDCTerminal( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCTerminal( entity );        
    }
    
    /*
     * @param	event DeleteACDCTerminalEvent
     */
    @EventHandler( payloadType=DeleteACDCTerminalEvent.class )
    public void handle( DeleteACDCTerminalEvent event) {
    	LOGGER.info("handling DeleteACDCTerminalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ACDCTerminal entity = delete( event.getACDCTerminalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCTerminal( entity );

    }    




    /**
     * Method to retrieve the ACDCTerminal via an ACDCTerminalPrimaryKey.
     * @param 	id Long
     * @return 	ACDCTerminal
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ACDCTerminal handle( FindACDCTerminalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getACDCTerminalId() );
    }
    
    /**
     * Method to retrieve a collection of all ACDCTerminals
     *
     * @param	query	FindAllACDCTerminalQuery 
     * @return 	List<ACDCTerminal> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ACDCTerminal> handle( FindAllACDCTerminalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindACDCTerminal, 
	 * but only if the id matches
	 * 
	 * @param		entity	ACDCTerminal
	 */
	protected void emitFindACDCTerminal( ACDCTerminal entity ) {
		LOGGER.info("handling emitFindACDCTerminal" );
		
	    queryUpdateEmitter.emit(FindACDCTerminalQuery.class,
	                            query -> query.getFilter().getACDCTerminalId().equals(entity.getACDCTerminalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllACDCTerminal
	 * 
	 * @param		entity	ACDCTerminal
	 */
	protected void emitFindAllACDCTerminal( ACDCTerminal entity ) {
		LOGGER.info("handling emitFindAllACDCTerminal" );
		
	    queryUpdateEmitter.emit(FindAllACDCTerminalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ACDCTerminalProjector.class.getName());

}
