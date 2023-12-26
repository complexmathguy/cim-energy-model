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
 * Projector for Quality61850 as outlined for the CQRS pattern.  All event handling and query handling related to Quality61850 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Quality61850Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("quality61850")
@Component("quality61850-projector")
public class Quality61850Projector extends Quality61850EntityProjector {
		
	// core constructor
	public Quality61850Projector(Quality61850Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateQuality61850Event
     */
    @EventHandler( payloadType=CreateQuality61850Event.class )
    public void handle( CreateQuality61850Event event) {
	    LOGGER.info("handling CreateQuality61850Event - " + event );
	    Quality61850 entity = new Quality61850();
        entity.setQuality61850Id( event.getQuality61850Id() );
        entity.setBadReference( event.getBadReference() );
        entity.setEstimatorReplaced( event.getEstimatorReplaced() );
        entity.setFailure( event.getFailure() );
        entity.setOldData( event.getOldData() );
        entity.setOperatorBlocked( event.getOperatorBlocked() );
        entity.setOscillatory( event.getOscillatory() );
        entity.setOutOfRange( event.getOutOfRange() );
        entity.setOverFlow( event.getOverFlow() );
        entity.setSource( event.getSource() );
        entity.setSuspect( event.getSuspect() );
        entity.setTest( event.getTest() );
        entity.setValidity( event.getValidity() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllQuality61850( entity );
    }

    /*
     * @param	event UpdateQuality61850Event
     */
    @EventHandler( payloadType=UpdateQuality61850Event.class )
    public void handle( UpdateQuality61850Event event) {
    	LOGGER.info("handling UpdateQuality61850Event - " + event );
    	
	    Quality61850 entity = new Quality61850();
        entity.setQuality61850Id( event.getQuality61850Id() );
        entity.setBadReference( event.getBadReference() );
        entity.setEstimatorReplaced( event.getEstimatorReplaced() );
        entity.setFailure( event.getFailure() );
        entity.setOldData( event.getOldData() );
        entity.setOperatorBlocked( event.getOperatorBlocked() );
        entity.setOscillatory( event.getOscillatory() );
        entity.setOutOfRange( event.getOutOfRange() );
        entity.setOverFlow( event.getOverFlow() );
        entity.setSource( event.getSource() );
        entity.setSuspect( event.getSuspect() );
        entity.setTest( event.getTest() );
        entity.setValidity( event.getValidity() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindQuality61850( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllQuality61850( entity );        
    }
    
    /*
     * @param	event DeleteQuality61850Event
     */
    @EventHandler( payloadType=DeleteQuality61850Event.class )
    public void handle( DeleteQuality61850Event event) {
    	LOGGER.info("handling DeleteQuality61850Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Quality61850 entity = delete( event.getQuality61850Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllQuality61850( entity );

    }    




    /**
     * Method to retrieve the Quality61850 via an Quality61850PrimaryKey.
     * @param 	id Long
     * @return 	Quality61850
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Quality61850 handle( FindQuality61850Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getQuality61850Id() );
    }
    
    /**
     * Method to retrieve a collection of all Quality61850s
     *
     * @param	query	FindAllQuality61850Query 
     * @return 	List<Quality61850> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Quality61850> handle( FindAllQuality61850Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindQuality61850, 
	 * but only if the id matches
	 * 
	 * @param		entity	Quality61850
	 */
	protected void emitFindQuality61850( Quality61850 entity ) {
		LOGGER.info("handling emitFindQuality61850" );
		
	    queryUpdateEmitter.emit(FindQuality61850Query.class,
	                            query -> query.getFilter().getQuality61850Id().equals(entity.getQuality61850Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllQuality61850
	 * 
	 * @param		entity	Quality61850
	 */
	protected void emitFindAllQuality61850( Quality61850 entity ) {
		LOGGER.info("handling emitFindAllQuality61850" );
		
	    queryUpdateEmitter.emit(FindAllQuality61850Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Quality61850Projector.class.getName());

}
