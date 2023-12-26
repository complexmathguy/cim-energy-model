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
 * Projector for Staticpowersystemmodel as outlined for the CQRS pattern.  All event handling and query handling related to Staticpowersystemmodel are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StaticpowersystemmodelAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("staticpowersystemmodel")
@Component("staticpowersystemmodel-projector")
public class StaticpowersystemmodelProjector extends StaticpowersystemmodelEntityProjector {
		
	// core constructor
	public StaticpowersystemmodelProjector(StaticpowersystemmodelRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStaticpowersystemmodelEvent
     */
    @EventHandler( payloadType=CreateStaticpowersystemmodelEvent.class )
    public void handle( CreateStaticpowersystemmodelEvent event) {
	    LOGGER.info("handling CreateStaticpowersystemmodelEvent - " + event );
	    Staticpowersystemmodel entity = new Staticpowersystemmodel();
        entity.setStaticpowersystemmodelId( event.getStaticpowersystemmodelId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticpowersystemmodel( entity );
    }

    /*
     * @param	event UpdateStaticpowersystemmodelEvent
     */
    @EventHandler( payloadType=UpdateStaticpowersystemmodelEvent.class )
    public void handle( UpdateStaticpowersystemmodelEvent event) {
    	LOGGER.info("handling UpdateStaticpowersystemmodelEvent - " + event );
    	
	    Staticpowersystemmodel entity = new Staticpowersystemmodel();
        entity.setStaticpowersystemmodelId( event.getStaticpowersystemmodelId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStaticpowersystemmodel( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticpowersystemmodel( entity );        
    }
    
    /*
     * @param	event DeleteStaticpowersystemmodelEvent
     */
    @EventHandler( payloadType=DeleteStaticpowersystemmodelEvent.class )
    public void handle( DeleteStaticpowersystemmodelEvent event) {
    	LOGGER.info("handling DeleteStaticpowersystemmodelEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Staticpowersystemmodel entity = delete( event.getStaticpowersystemmodelId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticpowersystemmodel( entity );

    }    




    /**
     * Method to retrieve the Staticpowersystemmodel via an StaticpowersystemmodelPrimaryKey.
     * @param 	id Long
     * @return 	Staticpowersystemmodel
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Staticpowersystemmodel handle( FindStaticpowersystemmodelQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStaticpowersystemmodelId() );
    }
    
    /**
     * Method to retrieve a collection of all Staticpowersystemmodels
     *
     * @param	query	FindAllStaticpowersystemmodelQuery 
     * @return 	List<Staticpowersystemmodel> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Staticpowersystemmodel> handle( FindAllStaticpowersystemmodelQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStaticpowersystemmodel, 
	 * but only if the id matches
	 * 
	 * @param		entity	Staticpowersystemmodel
	 */
	protected void emitFindStaticpowersystemmodel( Staticpowersystemmodel entity ) {
		LOGGER.info("handling emitFindStaticpowersystemmodel" );
		
	    queryUpdateEmitter.emit(FindStaticpowersystemmodelQuery.class,
	                            query -> query.getFilter().getStaticpowersystemmodelId().equals(entity.getStaticpowersystemmodelId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStaticpowersystemmodel
	 * 
	 * @param		entity	Staticpowersystemmodel
	 */
	protected void emitFindAllStaticpowersystemmodel( Staticpowersystemmodel entity ) {
		LOGGER.info("handling emitFindAllStaticpowersystemmodel" );
		
	    queryUpdateEmitter.emit(FindAllStaticpowersystemmodelQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StaticpowersystemmodelProjector.class.getName());

}
