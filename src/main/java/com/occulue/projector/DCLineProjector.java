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
 * Projector for DCLine as outlined for the CQRS pattern.  All event handling and query handling related to DCLine are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCLineAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCLine")
@Component("dCLine-projector")
public class DCLineProjector extends DCLineEntityProjector {
		
	// core constructor
	public DCLineProjector(DCLineRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCLineEvent
     */
    @EventHandler( payloadType=CreateDCLineEvent.class )
    public void handle( CreateDCLineEvent event) {
	    LOGGER.info("handling CreateDCLineEvent - " + event );
	    DCLine entity = new DCLine();
        entity.setDCLineId( event.getDCLineId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLine( entity );
    }

    /*
     * @param	event UpdateDCLineEvent
     */
    @EventHandler( payloadType=UpdateDCLineEvent.class )
    public void handle( UpdateDCLineEvent event) {
    	LOGGER.info("handling UpdateDCLineEvent - " + event );
    	
	    DCLine entity = new DCLine();
        entity.setDCLineId( event.getDCLineId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCLine( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLine( entity );        
    }
    
    /*
     * @param	event DeleteDCLineEvent
     */
    @EventHandler( payloadType=DeleteDCLineEvent.class )
    public void handle( DeleteDCLineEvent event) {
    	LOGGER.info("handling DeleteDCLineEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCLine entity = delete( event.getDCLineId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLine( entity );

    }    




    /**
     * Method to retrieve the DCLine via an DCLinePrimaryKey.
     * @param 	id Long
     * @return 	DCLine
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCLine handle( FindDCLineQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCLineId() );
    }
    
    /**
     * Method to retrieve a collection of all DCLines
     *
     * @param	query	FindAllDCLineQuery 
     * @return 	List<DCLine> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCLine> handle( FindAllDCLineQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCLine, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCLine
	 */
	protected void emitFindDCLine( DCLine entity ) {
		LOGGER.info("handling emitFindDCLine" );
		
	    queryUpdateEmitter.emit(FindDCLineQuery.class,
	                            query -> query.getFilter().getDCLineId().equals(entity.getDCLineId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCLine
	 * 
	 * @param		entity	DCLine
	 */
	protected void emitFindAllDCLine( DCLine entity ) {
		LOGGER.info("handling emitFindAllDCLine" );
		
	    queryUpdateEmitter.emit(FindAllDCLineQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCLineProjector.class.getName());

}
