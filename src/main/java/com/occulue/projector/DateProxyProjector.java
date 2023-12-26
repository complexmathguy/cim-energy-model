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
 * Projector for DateProxy as outlined for the CQRS pattern.  All event handling and query handling related to DateProxy are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DateProxyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dateProxy")
@Component("dateProxy-projector")
public class DateProxyProjector extends DateProxyEntityProjector {
		
	// core constructor
	public DateProxyProjector(DateProxyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDateProxyEvent
     */
    @EventHandler( payloadType=CreateDateProxyEvent.class )
    public void handle( CreateDateProxyEvent event) {
	    LOGGER.info("handling CreateDateProxyEvent - " + event );
	    DateProxy entity = new DateProxy();
        entity.setDateProxyId( event.getDateProxyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateProxy( entity );
    }

    /*
     * @param	event UpdateDateProxyEvent
     */
    @EventHandler( payloadType=UpdateDateProxyEvent.class )
    public void handle( UpdateDateProxyEvent event) {
    	LOGGER.info("handling UpdateDateProxyEvent - " + event );
    	
	    DateProxy entity = new DateProxy();
        entity.setDateProxyId( event.getDateProxyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDateProxy( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateProxy( entity );        
    }
    
    /*
     * @param	event DeleteDateProxyEvent
     */
    @EventHandler( payloadType=DeleteDateProxyEvent.class )
    public void handle( DeleteDateProxyEvent event) {
    	LOGGER.info("handling DeleteDateProxyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DateProxy entity = delete( event.getDateProxyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateProxy( entity );

    }    




    /**
     * Method to retrieve the DateProxy via an DateProxyPrimaryKey.
     * @param 	id Long
     * @return 	DateProxy
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DateProxy handle( FindDateProxyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDateProxyId() );
    }
    
    /**
     * Method to retrieve a collection of all DateProxys
     *
     * @param	query	FindAllDateProxyQuery 
     * @return 	List<DateProxy> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DateProxy> handle( FindAllDateProxyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDateProxy, 
	 * but only if the id matches
	 * 
	 * @param		entity	DateProxy
	 */
	protected void emitFindDateProxy( DateProxy entity ) {
		LOGGER.info("handling emitFindDateProxy" );
		
	    queryUpdateEmitter.emit(FindDateProxyQuery.class,
	                            query -> query.getFilter().getDateProxyId().equals(entity.getDateProxyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDateProxy
	 * 
	 * @param		entity	DateProxy
	 */
	protected void emitFindAllDateProxy( DateProxy entity ) {
		LOGGER.info("handling emitFindAllDateProxy" );
		
	    queryUpdateEmitter.emit(FindAllDateProxyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DateProxyProjector.class.getName());

}
