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
 * Projector for Terminal as outlined for the CQRS pattern.  All event handling and query handling related to Terminal are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TerminalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("terminal")
@Component("terminal-projector")
public class TerminalProjector extends TerminalEntityProjector {
		
	// core constructor
	public TerminalProjector(TerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTerminalEvent
     */
    @EventHandler( payloadType=CreateTerminalEvent.class )
    public void handle( CreateTerminalEvent event) {
	    LOGGER.info("handling CreateTerminalEvent - " + event );
	    Terminal entity = new Terminal();
        entity.setTerminalId( event.getTerminalId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTerminal( entity );
    }

    /*
     * @param	event UpdateTerminalEvent
     */
    @EventHandler( payloadType=UpdateTerminalEvent.class )
    public void handle( UpdateTerminalEvent event) {
    	LOGGER.info("handling UpdateTerminalEvent - " + event );
    	
	    Terminal entity = new Terminal();
        entity.setTerminalId( event.getTerminalId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTerminal( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTerminal( entity );        
    }
    
    /*
     * @param	event DeleteTerminalEvent
     */
    @EventHandler( payloadType=DeleteTerminalEvent.class )
    public void handle( DeleteTerminalEvent event) {
    	LOGGER.info("handling DeleteTerminalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Terminal entity = delete( event.getTerminalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTerminal( entity );

    }    




    /**
     * Method to retrieve the Terminal via an TerminalPrimaryKey.
     * @param 	id Long
     * @return 	Terminal
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Terminal handle( FindTerminalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTerminalId() );
    }
    
    /**
     * Method to retrieve a collection of all Terminals
     *
     * @param	query	FindAllTerminalQuery 
     * @return 	List<Terminal> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Terminal> handle( FindAllTerminalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTerminal, 
	 * but only if the id matches
	 * 
	 * @param		entity	Terminal
	 */
	protected void emitFindTerminal( Terminal entity ) {
		LOGGER.info("handling emitFindTerminal" );
		
	    queryUpdateEmitter.emit(FindTerminalQuery.class,
	                            query -> query.getFilter().getTerminalId().equals(entity.getTerminalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTerminal
	 * 
	 * @param		entity	Terminal
	 */
	protected void emitFindAllTerminal( Terminal entity ) {
		LOGGER.info("handling emitFindAllTerminal" );
		
	    queryUpdateEmitter.emit(FindAllTerminalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TerminalProjector.class.getName());

}
