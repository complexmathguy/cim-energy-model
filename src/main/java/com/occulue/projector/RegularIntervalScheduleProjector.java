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
 * Projector for RegularIntervalSchedule as outlined for the CQRS pattern.  All event handling and query handling related to RegularIntervalSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RegularIntervalScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("regularIntervalSchedule")
@Component("regularIntervalSchedule-projector")
public class RegularIntervalScheduleProjector extends RegularIntervalScheduleEntityProjector {
		
	// core constructor
	public RegularIntervalScheduleProjector(RegularIntervalScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRegularIntervalScheduleEvent
     */
    @EventHandler( payloadType=CreateRegularIntervalScheduleEvent.class )
    public void handle( CreateRegularIntervalScheduleEvent event) {
	    LOGGER.info("handling CreateRegularIntervalScheduleEvent - " + event );
	    RegularIntervalSchedule entity = new RegularIntervalSchedule();
        entity.setRegularIntervalScheduleId( event.getRegularIntervalScheduleId() );
        entity.setEndTime( event.getEndTime() );
        entity.setTimeStep( event.getTimeStep() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularIntervalSchedule( entity );
    }

    /*
     * @param	event UpdateRegularIntervalScheduleEvent
     */
    @EventHandler( payloadType=UpdateRegularIntervalScheduleEvent.class )
    public void handle( UpdateRegularIntervalScheduleEvent event) {
    	LOGGER.info("handling UpdateRegularIntervalScheduleEvent - " + event );
    	
	    RegularIntervalSchedule entity = new RegularIntervalSchedule();
        entity.setRegularIntervalScheduleId( event.getRegularIntervalScheduleId() );
        entity.setEndTime( event.getEndTime() );
        entity.setTimeStep( event.getTimeStep() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRegularIntervalSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularIntervalSchedule( entity );        
    }
    
    /*
     * @param	event DeleteRegularIntervalScheduleEvent
     */
    @EventHandler( payloadType=DeleteRegularIntervalScheduleEvent.class )
    public void handle( DeleteRegularIntervalScheduleEvent event) {
    	LOGGER.info("handling DeleteRegularIntervalScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RegularIntervalSchedule entity = delete( event.getRegularIntervalScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularIntervalSchedule( entity );

    }    




    /**
     * Method to retrieve the RegularIntervalSchedule via an RegularIntervalSchedulePrimaryKey.
     * @param 	id Long
     * @return 	RegularIntervalSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RegularIntervalSchedule handle( FindRegularIntervalScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRegularIntervalScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all RegularIntervalSchedules
     *
     * @param	query	FindAllRegularIntervalScheduleQuery 
     * @return 	List<RegularIntervalSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RegularIntervalSchedule> handle( FindAllRegularIntervalScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRegularIntervalSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	RegularIntervalSchedule
	 */
	protected void emitFindRegularIntervalSchedule( RegularIntervalSchedule entity ) {
		LOGGER.info("handling emitFindRegularIntervalSchedule" );
		
	    queryUpdateEmitter.emit(FindRegularIntervalScheduleQuery.class,
	                            query -> query.getFilter().getRegularIntervalScheduleId().equals(entity.getRegularIntervalScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRegularIntervalSchedule
	 * 
	 * @param		entity	RegularIntervalSchedule
	 */
	protected void emitFindAllRegularIntervalSchedule( RegularIntervalSchedule entity ) {
		LOGGER.info("handling emitFindAllRegularIntervalSchedule" );
		
	    queryUpdateEmitter.emit(FindAllRegularIntervalScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RegularIntervalScheduleProjector.class.getName());

}
