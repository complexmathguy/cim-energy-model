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
 * Projector for LimitSet as outlined for the CQRS pattern.  All event handling and query handling related to LimitSet are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LimitSetAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("limitSet")
@Component("limitSet-projector")
public class LimitSetProjector extends LimitSetEntityProjector {
		
	// core constructor
	public LimitSetProjector(LimitSetRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLimitSetEvent
     */
    @EventHandler( payloadType=CreateLimitSetEvent.class )
    public void handle( CreateLimitSetEvent event) {
	    LOGGER.info("handling CreateLimitSetEvent - " + event );
	    LimitSet entity = new LimitSet();
        entity.setLimitSetId( event.getLimitSetId() );
        entity.setIsPercentageLimits( event.getIsPercentageLimits() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimitSet( entity );
    }

    /*
     * @param	event UpdateLimitSetEvent
     */
    @EventHandler( payloadType=UpdateLimitSetEvent.class )
    public void handle( UpdateLimitSetEvent event) {
    	LOGGER.info("handling UpdateLimitSetEvent - " + event );
    	
	    LimitSet entity = new LimitSet();
        entity.setLimitSetId( event.getLimitSetId() );
        entity.setIsPercentageLimits( event.getIsPercentageLimits() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLimitSet( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimitSet( entity );        
    }
    
    /*
     * @param	event DeleteLimitSetEvent
     */
    @EventHandler( payloadType=DeleteLimitSetEvent.class )
    public void handle( DeleteLimitSetEvent event) {
    	LOGGER.info("handling DeleteLimitSetEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LimitSet entity = delete( event.getLimitSetId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLimitSet( entity );

    }    




    /**
     * Method to retrieve the LimitSet via an LimitSetPrimaryKey.
     * @param 	id Long
     * @return 	LimitSet
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LimitSet handle( FindLimitSetQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLimitSetId() );
    }
    
    /**
     * Method to retrieve a collection of all LimitSets
     *
     * @param	query	FindAllLimitSetQuery 
     * @return 	List<LimitSet> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LimitSet> handle( FindAllLimitSetQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLimitSet, 
	 * but only if the id matches
	 * 
	 * @param		entity	LimitSet
	 */
	protected void emitFindLimitSet( LimitSet entity ) {
		LOGGER.info("handling emitFindLimitSet" );
		
	    queryUpdateEmitter.emit(FindLimitSetQuery.class,
	                            query -> query.getFilter().getLimitSetId().equals(entity.getLimitSetId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLimitSet
	 * 
	 * @param		entity	LimitSet
	 */
	protected void emitFindAllLimitSet( LimitSet entity ) {
		LOGGER.info("handling emitFindAllLimitSet" );
		
	    queryUpdateEmitter.emit(FindAllLimitSetQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LimitSetProjector.class.getName());

}
