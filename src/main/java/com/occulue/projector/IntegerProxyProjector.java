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
 * Projector for IntegerProxy as outlined for the CQRS pattern.  All event handling and query handling related to IntegerProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by IntegerProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("integerProxy")
@Component("integerProxy-projector")
public class IntegerProxyProjector extends IntegerProxyEntityProjector {
		
	// core constructor
	public IntegerProxyProjector(IntegerProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateIntegerProxyEvent
     */
    @EventHandler( payloadType=CreateIntegerProxyEvent.class )
    public void handle( CreateIntegerProxyEvent event) {
	    LOGGER.info("handling CreateIntegerProxyEvent - " + event );
	    IntegerProxy entity = new IntegerProxy();
        entity.setIntegerProxyId( event.getIntegerProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIntegerProxy( entity );
    }

    /*
     * @param	event UpdateIntegerProxyEvent
     */
    @EventHandler( payloadType=UpdateIntegerProxyEvent.class )
    public void handle( UpdateIntegerProxyEvent event) {
    	LOGGER.info("handling UpdateIntegerProxyEvent - " + event );
    	
	    IntegerProxy entity = new IntegerProxy();
        entity.setIntegerProxyId( event.getIntegerProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindIntegerProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIntegerProxy( entity );        
    }
    
    /*
     * @param	event DeleteIntegerProxyEvent
     */
    @EventHandler( payloadType=DeleteIntegerProxyEvent.class )
    public void handle( DeleteIntegerProxyEvent event) {
    	LOGGER.info("handling DeleteIntegerProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	IntegerProxy entity = delete( event.getIntegerProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllIntegerProxy( entity );

    }    




    /**
     * Method to retrieve the IntegerProxy via an IntegerProxyPrimaryKey.
     * @param 	id Long
     * @return 	IntegerProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public IntegerProxy handle( FindIntegerProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getIntegerProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all IntegerProxys
     *
     * @param	query	FindAllIntegerProxyQuery 
     * @return 	List<IntegerProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<IntegerProxy> handle( FindAllIntegerProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindIntegerProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	IntegerProxy
	 */
	protected void emitFindIntegerProxy( IntegerProxy entity ) {
		LOGGER.info("handling emitFindIntegerProxy" );
		
	    queryUpdateEmitter.emit(FindIntegerProxyQuery.class,
	                            query -> query.getFilter().getIntegerProxyId().equals(entity.getIntegerProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllIntegerProxy
	 * 
	 * @param		entity	IntegerProxy
	 */
	protected void emitFindAllIntegerProxy( IntegerProxy entity ) {
		LOGGER.info("handling emitFindAllIntegerProxy" );
		
	    queryUpdateEmitter.emit(FindAllIntegerProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(IntegerProxyProjector.class.getName());

}
