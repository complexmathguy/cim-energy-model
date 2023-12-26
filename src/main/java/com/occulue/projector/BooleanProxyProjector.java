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
 * Projector for BooleanProxy as outlined for the CQRS pattern.  All event handling and query handling related to BooleanProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BooleanProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("booleanProxy")
@Component("booleanProxy-projector")
public class BooleanProxyProjector extends BooleanProxyEntityProjector {
		
	// core constructor
	public BooleanProxyProjector(BooleanProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBooleanProxyEvent
     */
    @EventHandler( payloadType=CreateBooleanProxyEvent.class )
    public void handle( CreateBooleanProxyEvent event) {
	    LOGGER.info("handling CreateBooleanProxyEvent - " + event );
	    BooleanProxy entity = new BooleanProxy();
        entity.setBooleanProxyId( event.getBooleanProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBooleanProxy( entity );
    }

    /*
     * @param	event UpdateBooleanProxyEvent
     */
    @EventHandler( payloadType=UpdateBooleanProxyEvent.class )
    public void handle( UpdateBooleanProxyEvent event) {
    	LOGGER.info("handling UpdateBooleanProxyEvent - " + event );
    	
	    BooleanProxy entity = new BooleanProxy();
        entity.setBooleanProxyId( event.getBooleanProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBooleanProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBooleanProxy( entity );        
    }
    
    /*
     * @param	event DeleteBooleanProxyEvent
     */
    @EventHandler( payloadType=DeleteBooleanProxyEvent.class )
    public void handle( DeleteBooleanProxyEvent event) {
    	LOGGER.info("handling DeleteBooleanProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BooleanProxy entity = delete( event.getBooleanProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBooleanProxy( entity );

    }    




    /**
     * Method to retrieve the BooleanProxy via an BooleanProxyPrimaryKey.
     * @param 	id Long
     * @return 	BooleanProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BooleanProxy handle( FindBooleanProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBooleanProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all BooleanProxys
     *
     * @param	query	FindAllBooleanProxyQuery 
     * @return 	List<BooleanProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BooleanProxy> handle( FindAllBooleanProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBooleanProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	BooleanProxy
	 */
	protected void emitFindBooleanProxy( BooleanProxy entity ) {
		LOGGER.info("handling emitFindBooleanProxy" );
		
	    queryUpdateEmitter.emit(FindBooleanProxyQuery.class,
	                            query -> query.getFilter().getBooleanProxyId().equals(entity.getBooleanProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBooleanProxy
	 * 
	 * @param		entity	BooleanProxy
	 */
	protected void emitFindAllBooleanProxy( BooleanProxy entity ) {
		LOGGER.info("handling emitFindAllBooleanProxy" );
		
	    queryUpdateEmitter.emit(FindAllBooleanProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BooleanProxyProjector.class.getName());

}
