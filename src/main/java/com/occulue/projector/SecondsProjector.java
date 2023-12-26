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
 * Projector for Seconds as outlined for the CQRS pattern.  All event handling and query handling related to Seconds are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SecondsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("seconds")
@Component("seconds-projector")
public class SecondsProjector extends SecondsEntityProjector {
		
	// core constructor
	public SecondsProjector(SecondsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSecondsEvent
     */
    @EventHandler( payloadType=CreateSecondsEvent.class )
    public void handle( CreateSecondsEvent event) {
	    LOGGER.info("handling CreateSecondsEvent - " + event );
	    Seconds entity = new Seconds();
        entity.setSecondsId( event.getSecondsId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeconds( entity );
    }

    /*
     * @param	event UpdateSecondsEvent
     */
    @EventHandler( payloadType=UpdateSecondsEvent.class )
    public void handle( UpdateSecondsEvent event) {
    	LOGGER.info("handling UpdateSecondsEvent - " + event );
    	
	    Seconds entity = new Seconds();
        entity.setSecondsId( event.getSecondsId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSeconds( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeconds( entity );        
    }
    
    /*
     * @param	event DeleteSecondsEvent
     */
    @EventHandler( payloadType=DeleteSecondsEvent.class )
    public void handle( DeleteSecondsEvent event) {
    	LOGGER.info("handling DeleteSecondsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Seconds entity = delete( event.getSecondsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeconds( entity );

    }    




    /**
     * Method to retrieve the Seconds via an SecondsPrimaryKey.
     * @param 	id Long
     * @return 	Seconds
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Seconds handle( FindSecondsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSecondsId() );
    }
    
    /**
     * Method to retrieve a collection of all Secondss
     *
     * @param	query	FindAllSecondsQuery 
     * @return 	List<Seconds> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Seconds> handle( FindAllSecondsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSeconds, 
	 * but only if the id matches
	 * 
	 * @param		entity	Seconds
	 */
	protected void emitFindSeconds( Seconds entity ) {
		LOGGER.info("handling emitFindSeconds" );
		
	    queryUpdateEmitter.emit(FindSecondsQuery.class,
	                            query -> query.getFilter().getSecondsId().equals(entity.getSecondsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSeconds
	 * 
	 * @param		entity	Seconds
	 */
	protected void emitFindAllSeconds( Seconds entity ) {
		LOGGER.info("handling emitFindAllSeconds" );
		
	    queryUpdateEmitter.emit(FindAllSecondsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SecondsProjector.class.getName());

}
