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
 * Projector for DiscExcContIEEEDEC3A as outlined for the CQRS pattern.  All event handling and query handling related to DiscExcContIEEEDEC3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscExcContIEEEDEC3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discExcContIEEEDEC3A")
@Component("discExcContIEEEDEC3A-projector")
public class DiscExcContIEEEDEC3AProjector extends DiscExcContIEEEDEC3AEntityProjector {
		
	// core constructor
	public DiscExcContIEEEDEC3AProjector(DiscExcContIEEEDEC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscExcContIEEEDEC3AEvent
     */
    @EventHandler( payloadType=CreateDiscExcContIEEEDEC3AEvent.class )
    public void handle( CreateDiscExcContIEEEDEC3AEvent event) {
	    LOGGER.info("handling CreateDiscExcContIEEEDEC3AEvent - " + event );
	    DiscExcContIEEEDEC3A entity = new DiscExcContIEEEDEC3A();
        entity.setDiscExcContIEEEDEC3AId( event.getDiscExcContIEEEDEC3AId() );
        entity.setTdr( event.getTdr() );
        entity.setVtmin( event.getVtmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC3A( entity );
    }

    /*
     * @param	event UpdateDiscExcContIEEEDEC3AEvent
     */
    @EventHandler( payloadType=UpdateDiscExcContIEEEDEC3AEvent.class )
    public void handle( UpdateDiscExcContIEEEDEC3AEvent event) {
    	LOGGER.info("handling UpdateDiscExcContIEEEDEC3AEvent - " + event );
    	
	    DiscExcContIEEEDEC3A entity = new DiscExcContIEEEDEC3A();
        entity.setDiscExcContIEEEDEC3AId( event.getDiscExcContIEEEDEC3AId() );
        entity.setTdr( event.getTdr() );
        entity.setVtmin( event.getVtmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscExcContIEEEDEC3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC3A( entity );        
    }
    
    /*
     * @param	event DeleteDiscExcContIEEEDEC3AEvent
     */
    @EventHandler( payloadType=DeleteDiscExcContIEEEDEC3AEvent.class )
    public void handle( DeleteDiscExcContIEEEDEC3AEvent event) {
    	LOGGER.info("handling DeleteDiscExcContIEEEDEC3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiscExcContIEEEDEC3A entity = delete( event.getDiscExcContIEEEDEC3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC3A( entity );

    }    




    /**
     * Method to retrieve the DiscExcContIEEEDEC3A via an DiscExcContIEEEDEC3APrimaryKey.
     * @param 	id Long
     * @return 	DiscExcContIEEEDEC3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiscExcContIEEEDEC3A handle( FindDiscExcContIEEEDEC3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscExcContIEEEDEC3AId() );
    }
    
    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC3As
     *
     * @param	query	FindAllDiscExcContIEEEDEC3AQuery 
     * @return 	List<DiscExcContIEEEDEC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiscExcContIEEEDEC3A> handle( FindAllDiscExcContIEEEDEC3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscExcContIEEEDEC3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiscExcContIEEEDEC3A
	 */
	protected void emitFindDiscExcContIEEEDEC3A( DiscExcContIEEEDEC3A entity ) {
		LOGGER.info("handling emitFindDiscExcContIEEEDEC3A" );
		
	    queryUpdateEmitter.emit(FindDiscExcContIEEEDEC3AQuery.class,
	                            query -> query.getFilter().getDiscExcContIEEEDEC3AId().equals(entity.getDiscExcContIEEEDEC3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscExcContIEEEDEC3A
	 * 
	 * @param		entity	DiscExcContIEEEDEC3A
	 */
	protected void emitFindAllDiscExcContIEEEDEC3A( DiscExcContIEEEDEC3A entity ) {
		LOGGER.info("handling emitFindAllDiscExcContIEEEDEC3A" );
		
	    queryUpdateEmitter.emit(FindAllDiscExcContIEEEDEC3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC3AProjector.class.getName());

}
