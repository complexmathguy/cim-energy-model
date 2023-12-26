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
 * Projector for DiscExcContIEEEDEC2A as outlined for the CQRS pattern.  All event handling and query handling related to DiscExcContIEEEDEC2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscExcContIEEEDEC2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discExcContIEEEDEC2A")
@Component("discExcContIEEEDEC2A-projector")
public class DiscExcContIEEEDEC2AProjector extends DiscExcContIEEEDEC2AEntityProjector {
		
	// core constructor
	public DiscExcContIEEEDEC2AProjector(DiscExcContIEEEDEC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscExcContIEEEDEC2AEvent
     */
    @EventHandler( payloadType=CreateDiscExcContIEEEDEC2AEvent.class )
    public void handle( CreateDiscExcContIEEEDEC2AEvent event) {
	    LOGGER.info("handling CreateDiscExcContIEEEDEC2AEvent - " + event );
	    DiscExcContIEEEDEC2A entity = new DiscExcContIEEEDEC2A();
        entity.setDiscExcContIEEEDEC2AId( event.getDiscExcContIEEEDEC2AId() );
        entity.setTd1( event.getTd1() );
        entity.setTd2( event.getTd2() );
        entity.setVdmax( event.getVdmax() );
        entity.setVdmin( event.getVdmin() );
        entity.setVk( event.getVk() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC2A( entity );
    }

    /*
     * @param	event UpdateDiscExcContIEEEDEC2AEvent
     */
    @EventHandler( payloadType=UpdateDiscExcContIEEEDEC2AEvent.class )
    public void handle( UpdateDiscExcContIEEEDEC2AEvent event) {
    	LOGGER.info("handling UpdateDiscExcContIEEEDEC2AEvent - " + event );
    	
	    DiscExcContIEEEDEC2A entity = new DiscExcContIEEEDEC2A();
        entity.setDiscExcContIEEEDEC2AId( event.getDiscExcContIEEEDEC2AId() );
        entity.setTd1( event.getTd1() );
        entity.setTd2( event.getTd2() );
        entity.setVdmax( event.getVdmax() );
        entity.setVdmin( event.getVdmin() );
        entity.setVk( event.getVk() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscExcContIEEEDEC2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC2A( entity );        
    }
    
    /*
     * @param	event DeleteDiscExcContIEEEDEC2AEvent
     */
    @EventHandler( payloadType=DeleteDiscExcContIEEEDEC2AEvent.class )
    public void handle( DeleteDiscExcContIEEEDEC2AEvent event) {
    	LOGGER.info("handling DeleteDiscExcContIEEEDEC2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiscExcContIEEEDEC2A entity = delete( event.getDiscExcContIEEEDEC2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC2A( entity );

    }    




    /**
     * Method to retrieve the DiscExcContIEEEDEC2A via an DiscExcContIEEEDEC2APrimaryKey.
     * @param 	id Long
     * @return 	DiscExcContIEEEDEC2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiscExcContIEEEDEC2A handle( FindDiscExcContIEEEDEC2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscExcContIEEEDEC2AId() );
    }
    
    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC2As
     *
     * @param	query	FindAllDiscExcContIEEEDEC2AQuery 
     * @return 	List<DiscExcContIEEEDEC2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiscExcContIEEEDEC2A> handle( FindAllDiscExcContIEEEDEC2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscExcContIEEEDEC2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiscExcContIEEEDEC2A
	 */
	protected void emitFindDiscExcContIEEEDEC2A( DiscExcContIEEEDEC2A entity ) {
		LOGGER.info("handling emitFindDiscExcContIEEEDEC2A" );
		
	    queryUpdateEmitter.emit(FindDiscExcContIEEEDEC2AQuery.class,
	                            query -> query.getFilter().getDiscExcContIEEEDEC2AId().equals(entity.getDiscExcContIEEEDEC2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscExcContIEEEDEC2A
	 * 
	 * @param		entity	DiscExcContIEEEDEC2A
	 */
	protected void emitFindAllDiscExcContIEEEDEC2A( DiscExcContIEEEDEC2A entity ) {
		LOGGER.info("handling emitFindAllDiscExcContIEEEDEC2A" );
		
	    queryUpdateEmitter.emit(FindAllDiscExcContIEEEDEC2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC2AProjector.class.getName());

}
