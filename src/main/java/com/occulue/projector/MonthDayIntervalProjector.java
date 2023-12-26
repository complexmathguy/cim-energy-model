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
 * Projector for MonthDayInterval as outlined for the CQRS pattern.  All event handling and query handling related to MonthDayInterval are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MonthDayIntervalAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("monthDayInterval")
@Component("monthDayInterval-projector")
public class MonthDayIntervalProjector extends MonthDayIntervalEntityProjector {
		
	// core constructor
	public MonthDayIntervalProjector(MonthDayIntervalRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMonthDayIntervalEvent
     */
    @EventHandler( payloadType=CreateMonthDayIntervalEvent.class )
    public void handle( CreateMonthDayIntervalEvent event) {
	    LOGGER.info("handling CreateMonthDayIntervalEvent - " + event );
	    MonthDayInterval entity = new MonthDayInterval();
        entity.setMonthDayIntervalId( event.getMonthDayIntervalId() );
        entity.setEnd( event.getEnd() );
        entity.setStart( event.getStart() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDayInterval( entity );
    }

    /*
     * @param	event UpdateMonthDayIntervalEvent
     */
    @EventHandler( payloadType=UpdateMonthDayIntervalEvent.class )
    public void handle( UpdateMonthDayIntervalEvent event) {
    	LOGGER.info("handling UpdateMonthDayIntervalEvent - " + event );
    	
	    MonthDayInterval entity = new MonthDayInterval();
        entity.setMonthDayIntervalId( event.getMonthDayIntervalId() );
        entity.setEnd( event.getEnd() );
        entity.setStart( event.getStart() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMonthDayInterval( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDayInterval( entity );        
    }
    
    /*
     * @param	event DeleteMonthDayIntervalEvent
     */
    @EventHandler( payloadType=DeleteMonthDayIntervalEvent.class )
    public void handle( DeleteMonthDayIntervalEvent event) {
    	LOGGER.info("handling DeleteMonthDayIntervalEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MonthDayInterval entity = delete( event.getMonthDayIntervalId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMonthDayInterval( entity );

    }    




    /**
     * Method to retrieve the MonthDayInterval via an MonthDayIntervalPrimaryKey.
     * @param 	id Long
     * @return 	MonthDayInterval
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MonthDayInterval handle( FindMonthDayIntervalQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMonthDayIntervalId() );
    }
    
    /**
     * Method to retrieve a collection of all MonthDayIntervals
     *
     * @param	query	FindAllMonthDayIntervalQuery 
     * @return 	List<MonthDayInterval> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MonthDayInterval> handle( FindAllMonthDayIntervalQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMonthDayInterval, 
	 * but only if the id matches
	 * 
	 * @param		entity	MonthDayInterval
	 */
	protected void emitFindMonthDayInterval( MonthDayInterval entity ) {
		LOGGER.info("handling emitFindMonthDayInterval" );
		
	    queryUpdateEmitter.emit(FindMonthDayIntervalQuery.class,
	                            query -> query.getFilter().getMonthDayIntervalId().equals(entity.getMonthDayIntervalId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMonthDayInterval
	 * 
	 * @param		entity	MonthDayInterval
	 */
	protected void emitFindAllMonthDayInterval( MonthDayInterval entity ) {
		LOGGER.info("handling emitFindAllMonthDayInterval" );
		
	    queryUpdateEmitter.emit(FindAllMonthDayIntervalQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MonthDayIntervalProjector.class.getName());

}
