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
 * Projector for FloatProxy as outlined for the CQRS pattern.  All event handling and query handling related to FloatProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by FloatProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("floatProxy")
@Component("floatProxy-projector")
public class FloatProxyProjector extends FloatProxyEntityProjector {
		
	// core constructor
	public FloatProxyProjector(FloatProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateFloatProxyEvent
     */
    @EventHandler( payloadType=CreateFloatProxyEvent.class )
    public void handle( CreateFloatProxyEvent event) {
	    LOGGER.info("handling CreateFloatProxyEvent - " + event );
	    FloatProxy entity = new FloatProxy();
        entity.setFloatProxyId( event.getFloatProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFloatProxy( entity );
    }

    /*
     * @param	event UpdateFloatProxyEvent
     */
    @EventHandler( payloadType=UpdateFloatProxyEvent.class )
    public void handle( UpdateFloatProxyEvent event) {
    	LOGGER.info("handling UpdateFloatProxyEvent - " + event );
    	
	    FloatProxy entity = new FloatProxy();
        entity.setFloatProxyId( event.getFloatProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindFloatProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFloatProxy( entity );        
    }
    
    /*
     * @param	event DeleteFloatProxyEvent
     */
    @EventHandler( payloadType=DeleteFloatProxyEvent.class )
    public void handle( DeleteFloatProxyEvent event) {
    	LOGGER.info("handling DeleteFloatProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	FloatProxy entity = delete( event.getFloatProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFloatProxy( entity );

    }    




    /**
     * Method to retrieve the FloatProxy via an FloatProxyPrimaryKey.
     * @param 	id Long
     * @return 	FloatProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public FloatProxy handle( FindFloatProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getFloatProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all FloatProxys
     *
     * @param	query	FindAllFloatProxyQuery 
     * @return 	List<FloatProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<FloatProxy> handle( FindAllFloatProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindFloatProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	FloatProxy
	 */
	protected void emitFindFloatProxy( FloatProxy entity ) {
		LOGGER.info("handling emitFindFloatProxy" );
		
	    queryUpdateEmitter.emit(FindFloatProxyQuery.class,
	                            query -> query.getFilter().getFloatProxyId().equals(entity.getFloatProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllFloatProxy
	 * 
	 * @param		entity	FloatProxy
	 */
	protected void emitFindAllFloatProxy( FloatProxy entity ) {
		LOGGER.info("handling emitFindAllFloatProxy" );
		
	    queryUpdateEmitter.emit(FindAllFloatProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(FloatProxyProjector.class.getName());

}
