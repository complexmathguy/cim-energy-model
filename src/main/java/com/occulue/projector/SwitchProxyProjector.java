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
 * Projector for SwitchProxy as outlined for the CQRS pattern.  All event handling and query handling related to SwitchProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SwitchProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("switchProxy")
@Component("switchProxy-projector")
public class SwitchProxyProjector extends SwitchProxyEntityProjector {
		
	// core constructor
	public SwitchProxyProjector(SwitchProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSwitchProxyEvent
     */
    @EventHandler( payloadType=CreateSwitchProxyEvent.class )
    public void handle( CreateSwitchProxyEvent event) {
	    LOGGER.info("handling CreateSwitchProxyEvent - " + event );
	    SwitchProxy entity = new SwitchProxy();
        entity.setSwitchProxyId( event.getSwitchProxyId() );
        entity.setNormalOpen( event.getNormalOpen() );
        entity.setRatedCurrent( event.getRatedCurrent() );
        entity.setRetained( event.getRetained() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchProxy( entity );
    }

    /*
     * @param	event UpdateSwitchProxyEvent
     */
    @EventHandler( payloadType=UpdateSwitchProxyEvent.class )
    public void handle( UpdateSwitchProxyEvent event) {
    	LOGGER.info("handling UpdateSwitchProxyEvent - " + event );
    	
	    SwitchProxy entity = new SwitchProxy();
        entity.setSwitchProxyId( event.getSwitchProxyId() );
        entity.setNormalOpen( event.getNormalOpen() );
        entity.setRatedCurrent( event.getRatedCurrent() );
        entity.setRetained( event.getRetained() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSwitchProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchProxy( entity );        
    }
    
    /*
     * @param	event DeleteSwitchProxyEvent
     */
    @EventHandler( payloadType=DeleteSwitchProxyEvent.class )
    public void handle( DeleteSwitchProxyEvent event) {
    	LOGGER.info("handling DeleteSwitchProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SwitchProxy entity = delete( event.getSwitchProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchProxy( entity );

    }    




    /**
     * Method to retrieve the SwitchProxy via an SwitchProxyPrimaryKey.
     * @param 	id Long
     * @return 	SwitchProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SwitchProxy handle( FindSwitchProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSwitchProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all SwitchProxys
     *
     * @param	query	FindAllSwitchProxyQuery 
     * @return 	List<SwitchProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SwitchProxy> handle( FindAllSwitchProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSwitchProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	SwitchProxy
	 */
	protected void emitFindSwitchProxy( SwitchProxy entity ) {
		LOGGER.info("handling emitFindSwitchProxy" );
		
	    queryUpdateEmitter.emit(FindSwitchProxyQuery.class,
	                            query -> query.getFilter().getSwitchProxyId().equals(entity.getSwitchProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSwitchProxy
	 * 
	 * @param		entity	SwitchProxy
	 */
	protected void emitFindAllSwitchProxy( SwitchProxy entity ) {
		LOGGER.info("handling emitFindAllSwitchProxy" );
		
	    queryUpdateEmitter.emit(FindAllSwitchProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SwitchProxyProjector.class.getName());

}
