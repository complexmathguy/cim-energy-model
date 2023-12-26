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
 * Projector for AnalogLimitSet as outlined for the CQRS pattern.  All event handling and query handling related to AnalogLimitSet are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AnalogLimitSetAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("analogLimitSet")
@Component("analogLimitSet-projector")
public class AnalogLimitSetProjector extends AnalogLimitSetEntityProjector {
		
	// core constructor
	public AnalogLimitSetProjector(AnalogLimitSetRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAnalogLimitSetEvent
     */
    @EventHandler( payloadType=CreateAnalogLimitSetEvent.class )
    public void handle( CreateAnalogLimitSetEvent event) {
	    LOGGER.info("handling CreateAnalogLimitSetEvent - " + event );
	    AnalogLimitSet entity = new AnalogLimitSet();
        entity.setAnalogLimitSetId( event.getAnalogLimitSetId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimitSet( entity );
    }

    /*
     * @param	event UpdateAnalogLimitSetEvent
     */
    @EventHandler( payloadType=UpdateAnalogLimitSetEvent.class )
    public void handle( UpdateAnalogLimitSetEvent event) {
    	LOGGER.info("handling UpdateAnalogLimitSetEvent - " + event );
    	
	    AnalogLimitSet entity = new AnalogLimitSet();
        entity.setAnalogLimitSetId( event.getAnalogLimitSetId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAnalogLimitSet( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimitSet( entity );        
    }
    
    /*
     * @param	event DeleteAnalogLimitSetEvent
     */
    @EventHandler( payloadType=DeleteAnalogLimitSetEvent.class )
    public void handle( DeleteAnalogLimitSetEvent event) {
    	LOGGER.info("handling DeleteAnalogLimitSetEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AnalogLimitSet entity = delete( event.getAnalogLimitSetId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimitSet( entity );

    }    




    /**
     * Method to retrieve the AnalogLimitSet via an AnalogLimitSetPrimaryKey.
     * @param 	id Long
     * @return 	AnalogLimitSet
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AnalogLimitSet handle( FindAnalogLimitSetQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAnalogLimitSetId() );
    }
    
    /**
     * Method to retrieve a collection of all AnalogLimitSets
     *
     * @param	query	FindAllAnalogLimitSetQuery 
     * @return 	List<AnalogLimitSet> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AnalogLimitSet> handle( FindAllAnalogLimitSetQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAnalogLimitSet, 
	 * but only if the id matches
	 * 
	 * @param		entity	AnalogLimitSet
	 */
	protected void emitFindAnalogLimitSet( AnalogLimitSet entity ) {
		LOGGER.info("handling emitFindAnalogLimitSet" );
		
	    queryUpdateEmitter.emit(FindAnalogLimitSetQuery.class,
	                            query -> query.getFilter().getAnalogLimitSetId().equals(entity.getAnalogLimitSetId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAnalogLimitSet
	 * 
	 * @param		entity	AnalogLimitSet
	 */
	protected void emitFindAllAnalogLimitSet( AnalogLimitSet entity ) {
		LOGGER.info("handling emitFindAllAnalogLimitSet" );
		
	    queryUpdateEmitter.emit(FindAllAnalogLimitSetQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AnalogLimitSetProjector.class.getName());

}
