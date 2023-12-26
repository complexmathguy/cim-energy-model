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
 * Projector for ENTSOEJunction as outlined for the CQRS pattern.  All event handling and query handling related to ENTSOEJunction are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ENTSOEJunctionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("eNTSOEJunction")
@Component("eNTSOEJunction-projector")
public class ENTSOEJunctionProjector extends ENTSOEJunctionEntityProjector {
		
	// core constructor
	public ENTSOEJunctionProjector(ENTSOEJunctionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateENTSOEJunctionEvent
     */
    @EventHandler( payloadType=CreateENTSOEJunctionEvent.class )
    public void handle( CreateENTSOEJunctionEvent event) {
	    LOGGER.info("handling CreateENTSOEJunctionEvent - " + event );
	    ENTSOEJunction entity = new ENTSOEJunction();
        entity.setENTSOEJunctionId( event.getENTSOEJunctionId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEJunction( entity );
    }

    /*
     * @param	event UpdateENTSOEJunctionEvent
     */
    @EventHandler( payloadType=UpdateENTSOEJunctionEvent.class )
    public void handle( UpdateENTSOEJunctionEvent event) {
    	LOGGER.info("handling UpdateENTSOEJunctionEvent - " + event );
    	
	    ENTSOEJunction entity = new ENTSOEJunction();
        entity.setENTSOEJunctionId( event.getENTSOEJunctionId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindENTSOEJunction( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEJunction( entity );        
    }
    
    /*
     * @param	event DeleteENTSOEJunctionEvent
     */
    @EventHandler( payloadType=DeleteENTSOEJunctionEvent.class )
    public void handle( DeleteENTSOEJunctionEvent event) {
    	LOGGER.info("handling DeleteENTSOEJunctionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ENTSOEJunction entity = delete( event.getENTSOEJunctionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllENTSOEJunction( entity );

    }    




    /**
     * Method to retrieve the ENTSOEJunction via an ENTSOEJunctionPrimaryKey.
     * @param 	id Long
     * @return 	ENTSOEJunction
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ENTSOEJunction handle( FindENTSOEJunctionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getENTSOEJunctionId() );
    }
    
    /**
     * Method to retrieve a collection of all ENTSOEJunctions
     *
     * @param	query	FindAllENTSOEJunctionQuery 
     * @return 	List<ENTSOEJunction> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ENTSOEJunction> handle( FindAllENTSOEJunctionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindENTSOEJunction, 
	 * but only if the id matches
	 * 
	 * @param		entity	ENTSOEJunction
	 */
	protected void emitFindENTSOEJunction( ENTSOEJunction entity ) {
		LOGGER.info("handling emitFindENTSOEJunction" );
		
	    queryUpdateEmitter.emit(FindENTSOEJunctionQuery.class,
	                            query -> query.getFilter().getENTSOEJunctionId().equals(entity.getENTSOEJunctionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllENTSOEJunction
	 * 
	 * @param		entity	ENTSOEJunction
	 */
	protected void emitFindAllENTSOEJunction( ENTSOEJunction entity ) {
		LOGGER.info("handling emitFindAllENTSOEJunction" );
		
	    queryUpdateEmitter.emit(FindAllENTSOEJunctionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ENTSOEJunctionProjector.class.getName());

}
