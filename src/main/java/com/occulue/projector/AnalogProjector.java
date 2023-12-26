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
 * Projector for Analog as outlined for the CQRS pattern.  All event handling and query handling related to Analog are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AnalogAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("analog")
@Component("analog-projector")
public class AnalogProjector extends AnalogEntityProjector {
		
	// core constructor
	public AnalogProjector(AnalogRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAnalogEvent
     */
    @EventHandler( payloadType=CreateAnalogEvent.class )
    public void handle( CreateAnalogEvent event) {
	    LOGGER.info("handling CreateAnalogEvent - " + event );
	    Analog entity = new Analog();
        entity.setAnalogId( event.getAnalogId() );
        entity.setPositiveFlowIn( event.getPositiveFlowIn() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalog( entity );
    }

    /*
     * @param	event UpdateAnalogEvent
     */
    @EventHandler( payloadType=UpdateAnalogEvent.class )
    public void handle( UpdateAnalogEvent event) {
    	LOGGER.info("handling UpdateAnalogEvent - " + event );
    	
	    Analog entity = new Analog();
        entity.setAnalogId( event.getAnalogId() );
        entity.setPositiveFlowIn( event.getPositiveFlowIn() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAnalog( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalog( entity );        
    }
    
    /*
     * @param	event DeleteAnalogEvent
     */
    @EventHandler( payloadType=DeleteAnalogEvent.class )
    public void handle( DeleteAnalogEvent event) {
    	LOGGER.info("handling DeleteAnalogEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Analog entity = delete( event.getAnalogId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalog( entity );

    }    




    /**
     * Method to retrieve the Analog via an AnalogPrimaryKey.
     * @param 	id Long
     * @return 	Analog
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Analog handle( FindAnalogQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAnalogId() );
    }
    
    /**
     * Method to retrieve a collection of all Analogs
     *
     * @param	query	FindAllAnalogQuery 
     * @return 	List<Analog> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Analog> handle( FindAllAnalogQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAnalog, 
	 * but only if the id matches
	 * 
	 * @param		entity	Analog
	 */
	protected void emitFindAnalog( Analog entity ) {
		LOGGER.info("handling emitFindAnalog" );
		
	    queryUpdateEmitter.emit(FindAnalogQuery.class,
	                            query -> query.getFilter().getAnalogId().equals(entity.getAnalogId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAnalog
	 * 
	 * @param		entity	Analog
	 */
	protected void emitFindAllAnalog( Analog entity ) {
		LOGGER.info("handling emitFindAllAnalog" );
		
	    queryUpdateEmitter.emit(FindAllAnalogQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AnalogProjector.class.getName());

}
