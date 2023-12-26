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
 * Projector for DCBaseTerminal as outlined for the CQRS pattern.  All event handling and query handling related to DCBaseTerminal are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCBaseTerminalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCBaseTerminal")
@Component("dCBaseTerminal-projector")
public class DCBaseTerminalProjector extends DCBaseTerminalEntityProjector {
		
	// core constructor
	public DCBaseTerminalProjector(DCBaseTerminalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCBaseTerminalEvent
     */
    @EventHandler( payloadType=CreateDCBaseTerminalEvent.class )
    public void handle( CreateDCBaseTerminalEvent event) {
	    LOGGER.info("handling CreateDCBaseTerminalEvent - " + event );
	    DCBaseTerminal entity = new DCBaseTerminal();
        entity.setDCBaseTerminalId( event.getDCBaseTerminalId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBaseTerminal( entity );
    }

    /*
     * @param	event UpdateDCBaseTerminalEvent
     */
    @EventHandler( payloadType=UpdateDCBaseTerminalEvent.class )
    public void handle( UpdateDCBaseTerminalEvent event) {
    	LOGGER.info("handling UpdateDCBaseTerminalEvent - " + event );
    	
	    DCBaseTerminal entity = new DCBaseTerminal();
        entity.setDCBaseTerminalId( event.getDCBaseTerminalId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCBaseTerminal( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBaseTerminal( entity );        
    }
    
    /*
     * @param	event DeleteDCBaseTerminalEvent
     */
    @EventHandler( payloadType=DeleteDCBaseTerminalEvent.class )
    public void handle( DeleteDCBaseTerminalEvent event) {
    	LOGGER.info("handling DeleteDCBaseTerminalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCBaseTerminal entity = delete( event.getDCBaseTerminalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCBaseTerminal( entity );

    }    




    /**
     * Method to retrieve the DCBaseTerminal via an DCBaseTerminalPrimaryKey.
     * @param 	id Long
     * @return 	DCBaseTerminal
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCBaseTerminal handle( FindDCBaseTerminalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCBaseTerminalId() );
    }
    
    /**
     * Method to retrieve a collection of all DCBaseTerminals
     *
     * @param	query	FindAllDCBaseTerminalQuery 
     * @return 	List<DCBaseTerminal> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCBaseTerminal> handle( FindAllDCBaseTerminalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCBaseTerminal, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCBaseTerminal
	 */
	protected void emitFindDCBaseTerminal( DCBaseTerminal entity ) {
		LOGGER.info("handling emitFindDCBaseTerminal" );
		
	    queryUpdateEmitter.emit(FindDCBaseTerminalQuery.class,
	                            query -> query.getFilter().getDCBaseTerminalId().equals(entity.getDCBaseTerminalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCBaseTerminal
	 * 
	 * @param		entity	DCBaseTerminal
	 */
	protected void emitFindAllDCBaseTerminal( DCBaseTerminal entity ) {
		LOGGER.info("handling emitFindAllDCBaseTerminal" );
		
	    queryUpdateEmitter.emit(FindAllDCBaseTerminalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCBaseTerminalProjector.class.getName());

}
