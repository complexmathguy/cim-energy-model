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
 * Projector for DecimalProxy as outlined for the CQRS pattern.  All event handling and query handling related to DecimalProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DecimalProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("decimalProxy")
@Component("decimalProxy-projector")
public class DecimalProxyProjector extends DecimalProxyEntityProjector {
		
	// core constructor
	public DecimalProxyProjector(DecimalProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDecimalProxyEvent
     */
    @EventHandler( payloadType=CreateDecimalProxyEvent.class )
    public void handle( CreateDecimalProxyEvent event) {
	    LOGGER.info("handling CreateDecimalProxyEvent - " + event );
	    DecimalProxy entity = new DecimalProxy();
        entity.setDecimalProxyId( event.getDecimalProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDecimalProxy( entity );
    }

    /*
     * @param	event UpdateDecimalProxyEvent
     */
    @EventHandler( payloadType=UpdateDecimalProxyEvent.class )
    public void handle( UpdateDecimalProxyEvent event) {
    	LOGGER.info("handling UpdateDecimalProxyEvent - " + event );
    	
	    DecimalProxy entity = new DecimalProxy();
        entity.setDecimalProxyId( event.getDecimalProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDecimalProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDecimalProxy( entity );        
    }
    
    /*
     * @param	event DeleteDecimalProxyEvent
     */
    @EventHandler( payloadType=DeleteDecimalProxyEvent.class )
    public void handle( DeleteDecimalProxyEvent event) {
    	LOGGER.info("handling DeleteDecimalProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DecimalProxy entity = delete( event.getDecimalProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDecimalProxy( entity );

    }    




    /**
     * Method to retrieve the DecimalProxy via an DecimalProxyPrimaryKey.
     * @param 	id Long
     * @return 	DecimalProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DecimalProxy handle( FindDecimalProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDecimalProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all DecimalProxys
     *
     * @param	query	FindAllDecimalProxyQuery 
     * @return 	List<DecimalProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DecimalProxy> handle( FindAllDecimalProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDecimalProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	DecimalProxy
	 */
	protected void emitFindDecimalProxy( DecimalProxy entity ) {
		LOGGER.info("handling emitFindDecimalProxy" );
		
	    queryUpdateEmitter.emit(FindDecimalProxyQuery.class,
	                            query -> query.getFilter().getDecimalProxyId().equals(entity.getDecimalProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDecimalProxy
	 * 
	 * @param		entity	DecimalProxy
	 */
	protected void emitFindAllDecimalProxy( DecimalProxy entity ) {
		LOGGER.info("handling emitFindAllDecimalProxy" );
		
	    queryUpdateEmitter.emit(FindAllDecimalProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DecimalProxyProjector.class.getName());

}
