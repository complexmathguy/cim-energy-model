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
 * Projector for MonthDay as outlined for the CQRS pattern.  All event handling and query handling related to MonthDay are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MonthDayAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("monthDay")
@Component("monthDay-projector")
public class MonthDayProjector extends MonthDayEntityProjector {
		
	// core constructor
	public MonthDayProjector(MonthDayRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMonthDayEvent
     */
    @EventHandler( payloadType=CreateMonthDayEvent.class )
    public void handle( CreateMonthDayEvent event) {
	    LOGGER.info("handling CreateMonthDayEvent - " + event );
	    MonthDay entity = new MonthDay();
        entity.setMonthDayId( event.getMonthDayId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDay( entity );
    }

    /*
     * @param	event UpdateMonthDayEvent
     */
    @EventHandler( payloadType=UpdateMonthDayEvent.class )
    public void handle( UpdateMonthDayEvent event) {
    	LOGGER.info("handling UpdateMonthDayEvent - " + event );
    	
	    MonthDay entity = new MonthDay();
        entity.setMonthDayId( event.getMonthDayId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMonthDay( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDay( entity );        
    }
    
    /*
     * @param	event DeleteMonthDayEvent
     */
    @EventHandler( payloadType=DeleteMonthDayEvent.class )
    public void handle( DeleteMonthDayEvent event) {
    	LOGGER.info("handling DeleteMonthDayEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MonthDay entity = delete( event.getMonthDayId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDay( entity );

    }    




    /**
     * Method to retrieve the MonthDay via an MonthDayPrimaryKey.
     * @param 	id Long
     * @return 	MonthDay
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MonthDay handle( FindMonthDayQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMonthDayId() );
    }
    
    /**
     * Method to retrieve a collection of all MonthDays
     *
     * @param	query	FindAllMonthDayQuery 
     * @return 	List<MonthDay> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MonthDay> handle( FindAllMonthDayQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMonthDay, 
	 * but only if the id matches
	 * 
	 * @param		entity	MonthDay
	 */
	protected void emitFindMonthDay( MonthDay entity ) {
		LOGGER.info("handling emitFindMonthDay" );
		
	    queryUpdateEmitter.emit(FindMonthDayQuery.class,
	                            query -> query.getFilter().getMonthDayId().equals(entity.getMonthDayId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMonthDay
	 * 
	 * @param		entity	MonthDay
	 */
	protected void emitFindAllMonthDay( MonthDay entity ) {
		LOGGER.info("handling emitFindAllMonthDay" );
		
	    queryUpdateEmitter.emit(FindAllMonthDayQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MonthDayProjector.class.getName());

}
