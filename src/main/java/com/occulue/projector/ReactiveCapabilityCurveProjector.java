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
 * Projector for ReactiveCapabilityCurve as outlined for the CQRS pattern.  All event handling and query handling related to ReactiveCapabilityCurve are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ReactiveCapabilityCurveAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("reactiveCapabilityCurve")
@Component("reactiveCapabilityCurve-projector")
public class ReactiveCapabilityCurveProjector extends ReactiveCapabilityCurveEntityProjector {
		
	// core constructor
	public ReactiveCapabilityCurveProjector(ReactiveCapabilityCurveRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateReactiveCapabilityCurveEvent
     */
    @EventHandler( payloadType=CreateReactiveCapabilityCurveEvent.class )
    public void handle( CreateReactiveCapabilityCurveEvent event) {
	    LOGGER.info("handling CreateReactiveCapabilityCurveEvent - " + event );
	    ReactiveCapabilityCurve entity = new ReactiveCapabilityCurve();
        entity.setReactiveCapabilityCurveId( event.getReactiveCapabilityCurveId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReactiveCapabilityCurve( entity );
    }

    /*
     * @param	event UpdateReactiveCapabilityCurveEvent
     */
    @EventHandler( payloadType=UpdateReactiveCapabilityCurveEvent.class )
    public void handle( UpdateReactiveCapabilityCurveEvent event) {
    	LOGGER.info("handling UpdateReactiveCapabilityCurveEvent - " + event );
    	
	    ReactiveCapabilityCurve entity = new ReactiveCapabilityCurve();
        entity.setReactiveCapabilityCurveId( event.getReactiveCapabilityCurveId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindReactiveCapabilityCurve( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReactiveCapabilityCurve( entity );        
    }
    
    /*
     * @param	event DeleteReactiveCapabilityCurveEvent
     */
    @EventHandler( payloadType=DeleteReactiveCapabilityCurveEvent.class )
    public void handle( DeleteReactiveCapabilityCurveEvent event) {
    	LOGGER.info("handling DeleteReactiveCapabilityCurveEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ReactiveCapabilityCurve entity = delete( event.getReactiveCapabilityCurveId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReactiveCapabilityCurve( entity );

    }    




    /**
     * Method to retrieve the ReactiveCapabilityCurve via an ReactiveCapabilityCurvePrimaryKey.
     * @param 	id Long
     * @return 	ReactiveCapabilityCurve
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ReactiveCapabilityCurve handle( FindReactiveCapabilityCurveQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getReactiveCapabilityCurveId() );
    }
    
    /**
     * Method to retrieve a collection of all ReactiveCapabilityCurves
     *
     * @param	query	FindAllReactiveCapabilityCurveQuery 
     * @return 	List<ReactiveCapabilityCurve> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ReactiveCapabilityCurve> handle( FindAllReactiveCapabilityCurveQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindReactiveCapabilityCurve, 
	 * but only if the id matches
	 * 
	 * @param		entity	ReactiveCapabilityCurve
	 */
	protected void emitFindReactiveCapabilityCurve( ReactiveCapabilityCurve entity ) {
		LOGGER.info("handling emitFindReactiveCapabilityCurve" );
		
	    queryUpdateEmitter.emit(FindReactiveCapabilityCurveQuery.class,
	                            query -> query.getFilter().getReactiveCapabilityCurveId().equals(entity.getReactiveCapabilityCurveId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllReactiveCapabilityCurve
	 * 
	 * @param		entity	ReactiveCapabilityCurve
	 */
	protected void emitFindAllReactiveCapabilityCurve( ReactiveCapabilityCurve entity ) {
		LOGGER.info("handling emitFindAllReactiveCapabilityCurve" );
		
	    queryUpdateEmitter.emit(FindAllReactiveCapabilityCurveQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ReactiveCapabilityCurveProjector.class.getName());

}
