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
 * Projector for BasicIntervalSchedule as outlined for the CQRS pattern.  All event handling and query handling related to BasicIntervalSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BasicIntervalScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("basicIntervalSchedule")
@Component("basicIntervalSchedule-projector")
public class BasicIntervalScheduleProjector extends BasicIntervalScheduleEntityProjector {
		
	// core constructor
	public BasicIntervalScheduleProjector(BasicIntervalScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBasicIntervalScheduleEvent
     */
    @EventHandler( payloadType=CreateBasicIntervalScheduleEvent.class )
    public void handle( CreateBasicIntervalScheduleEvent event) {
	    LOGGER.info("handling CreateBasicIntervalScheduleEvent - " + event );
	    BasicIntervalSchedule entity = new BasicIntervalSchedule();
        entity.setBasicIntervalScheduleId( event.getBasicIntervalScheduleId() );
        entity.setStartTime( event.getStartTime() );
        entity.setValue1Unit( event.getValue1Unit() );
        entity.setValue2Unit( event.getValue2Unit() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBasicIntervalSchedule( entity );
    }

    /*
     * @param	event UpdateBasicIntervalScheduleEvent
     */
    @EventHandler( payloadType=UpdateBasicIntervalScheduleEvent.class )
    public void handle( UpdateBasicIntervalScheduleEvent event) {
    	LOGGER.info("handling UpdateBasicIntervalScheduleEvent - " + event );
    	
	    BasicIntervalSchedule entity = new BasicIntervalSchedule();
        entity.setBasicIntervalScheduleId( event.getBasicIntervalScheduleId() );
        entity.setStartTime( event.getStartTime() );
        entity.setValue1Unit( event.getValue1Unit() );
        entity.setValue2Unit( event.getValue2Unit() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBasicIntervalSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBasicIntervalSchedule( entity );        
    }
    
    /*
     * @param	event DeleteBasicIntervalScheduleEvent
     */
    @EventHandler( payloadType=DeleteBasicIntervalScheduleEvent.class )
    public void handle( DeleteBasicIntervalScheduleEvent event) {
    	LOGGER.info("handling DeleteBasicIntervalScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BasicIntervalSchedule entity = delete( event.getBasicIntervalScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBasicIntervalSchedule( entity );

    }    




    /**
     * Method to retrieve the BasicIntervalSchedule via an BasicIntervalSchedulePrimaryKey.
     * @param 	id Long
     * @return 	BasicIntervalSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BasicIntervalSchedule handle( FindBasicIntervalScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBasicIntervalScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all BasicIntervalSchedules
     *
     * @param	query	FindAllBasicIntervalScheduleQuery 
     * @return 	List<BasicIntervalSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BasicIntervalSchedule> handle( FindAllBasicIntervalScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBasicIntervalSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	BasicIntervalSchedule
	 */
	protected void emitFindBasicIntervalSchedule( BasicIntervalSchedule entity ) {
		LOGGER.info("handling emitFindBasicIntervalSchedule" );
		
	    queryUpdateEmitter.emit(FindBasicIntervalScheduleQuery.class,
	                            query -> query.getFilter().getBasicIntervalScheduleId().equals(entity.getBasicIntervalScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBasicIntervalSchedule
	 * 
	 * @param		entity	BasicIntervalSchedule
	 */
	protected void emitFindAllBasicIntervalSchedule( BasicIntervalSchedule entity ) {
		LOGGER.info("handling emitFindAllBasicIntervalSchedule" );
		
	    queryUpdateEmitter.emit(FindAllBasicIntervalScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BasicIntervalScheduleProjector.class.getName());

}
