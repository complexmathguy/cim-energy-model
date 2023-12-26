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
 * Projector for ACDCConverterDCTerminal as outlined for the CQRS pattern.  All event handling and query handling related to ACDCConverterDCTerminal are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ACDCConverterDCTerminalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("aCDCConverterDCTerminal")
@Component("aCDCConverterDCTerminal-projector")
public class ACDCConverterDCTerminalProjector extends ACDCConverterDCTerminalEntityProjector {
		
	// core constructor
	public ACDCConverterDCTerminalProjector(ACDCConverterDCTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateACDCConverterDCTerminalEvent
     */
    @EventHandler( payloadType=CreateACDCConverterDCTerminalEvent.class )
    public void handle( CreateACDCConverterDCTerminalEvent event) {
	    LOGGER.info("handling CreateACDCConverterDCTerminalEvent - " + event );
	    ACDCConverterDCTerminal entity = new ACDCConverterDCTerminal();
        entity.setACDCConverterDCTerminalId( event.getACDCConverterDCTerminalId() );
        entity.setPolarity( event.getPolarity() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverterDCTerminal( entity );
    }

    /*
     * @param	event UpdateACDCConverterDCTerminalEvent
     */
    @EventHandler( payloadType=UpdateACDCConverterDCTerminalEvent.class )
    public void handle( UpdateACDCConverterDCTerminalEvent event) {
    	LOGGER.info("handling UpdateACDCConverterDCTerminalEvent - " + event );
    	
	    ACDCConverterDCTerminal entity = new ACDCConverterDCTerminal();
        entity.setACDCConverterDCTerminalId( event.getACDCConverterDCTerminalId() );
        entity.setPolarity( event.getPolarity() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindACDCConverterDCTerminal( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverterDCTerminal( entity );        
    }
    
    /*
     * @param	event DeleteACDCConverterDCTerminalEvent
     */
    @EventHandler( payloadType=DeleteACDCConverterDCTerminalEvent.class )
    public void handle( DeleteACDCConverterDCTerminalEvent event) {
    	LOGGER.info("handling DeleteACDCConverterDCTerminalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ACDCConverterDCTerminal entity = delete( event.getACDCConverterDCTerminalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllACDCConverterDCTerminal( entity );

    }    




    /**
     * Method to retrieve the ACDCConverterDCTerminal via an ACDCConverterDCTerminalPrimaryKey.
     * @param 	id Long
     * @return 	ACDCConverterDCTerminal
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ACDCConverterDCTerminal handle( FindACDCConverterDCTerminalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getACDCConverterDCTerminalId() );
    }
    
    /**
     * Method to retrieve a collection of all ACDCConverterDCTerminals
     *
     * @param	query	FindAllACDCConverterDCTerminalQuery 
     * @return 	List<ACDCConverterDCTerminal> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ACDCConverterDCTerminal> handle( FindAllACDCConverterDCTerminalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindACDCConverterDCTerminal, 
	 * but only if the id matches
	 * 
	 * @param		entity	ACDCConverterDCTerminal
	 */
	protected void emitFindACDCConverterDCTerminal( ACDCConverterDCTerminal entity ) {
		LOGGER.info("handling emitFindACDCConverterDCTerminal" );
		
	    queryUpdateEmitter.emit(FindACDCConverterDCTerminalQuery.class,
	                            query -> query.getFilter().getACDCConverterDCTerminalId().equals(entity.getACDCConverterDCTerminalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllACDCConverterDCTerminal
	 * 
	 * @param		entity	ACDCConverterDCTerminal
	 */
	protected void emitFindAllACDCConverterDCTerminal( ACDCConverterDCTerminal entity ) {
		LOGGER.info("handling emitFindAllACDCConverterDCTerminal" );
		
	    queryUpdateEmitter.emit(FindAllACDCConverterDCTerminalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ACDCConverterDCTerminalProjector.class.getName());

}
