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
 * Projector for StringProxy as outlined for the CQRS pattern.  All event handling and query handling related to StringProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StringProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("stringProxy")
@Component("stringProxy-projector")
public class StringProxyProjector extends StringProxyEntityProjector {
		
	// core constructor
	public StringProxyProjector(StringProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStringProxyEvent
     */
    @EventHandler( payloadType=CreateStringProxyEvent.class )
    public void handle( CreateStringProxyEvent event) {
	    LOGGER.info("handling CreateStringProxyEvent - " + event );
	    StringProxy entity = new StringProxy();
        entity.setStringProxyId( event.getStringProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringProxy( entity );
    }

    /*
     * @param	event UpdateStringProxyEvent
     */
    @EventHandler( payloadType=UpdateStringProxyEvent.class )
    public void handle( UpdateStringProxyEvent event) {
    	LOGGER.info("handling UpdateStringProxyEvent - " + event );
    	
	    StringProxy entity = new StringProxy();
        entity.setStringProxyId( event.getStringProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStringProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringProxy( entity );        
    }
    
    /*
     * @param	event DeleteStringProxyEvent
     */
    @EventHandler( payloadType=DeleteStringProxyEvent.class )
    public void handle( DeleteStringProxyEvent event) {
    	LOGGER.info("handling DeleteStringProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StringProxy entity = delete( event.getStringProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStringProxy( entity );

    }    




    /**
     * Method to retrieve the StringProxy via an StringProxyPrimaryKey.
     * @param 	id Long
     * @return 	StringProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StringProxy handle( FindStringProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStringProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all StringProxys
     *
     * @param	query	FindAllStringProxyQuery 
     * @return 	List<StringProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StringProxy> handle( FindAllStringProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStringProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	StringProxy
	 */
	protected void emitFindStringProxy( StringProxy entity ) {
		LOGGER.info("handling emitFindStringProxy" );
		
	    queryUpdateEmitter.emit(FindStringProxyQuery.class,
	                            query -> query.getFilter().getStringProxyId().equals(entity.getStringProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStringProxy
	 * 
	 * @param		entity	StringProxy
	 */
	protected void emitFindAllStringProxy( StringProxy entity ) {
		LOGGER.info("handling emitFindAllStringProxy" );
		
	    queryUpdateEmitter.emit(FindAllStringProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StringProxyProjector.class.getName());

}
