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
 * Projector for NonConformLoadSchedule as outlined for the CQRS pattern.  All event handling and query handling related to NonConformLoadSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NonConformLoadScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nonConformLoadSchedule")
@Component("nonConformLoadSchedule-projector")
public class NonConformLoadScheduleProjector extends NonConformLoadScheduleEntityProjector {
		
	// core constructor
	public NonConformLoadScheduleProjector(NonConformLoadScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNonConformLoadScheduleEvent
     */
    @EventHandler( payloadType=CreateNonConformLoadScheduleEvent.class )
    public void handle( CreateNonConformLoadScheduleEvent event) {
	    LOGGER.info("handling CreateNonConformLoadScheduleEvent - " + event );
	    NonConformLoadSchedule entity = new NonConformLoadSchedule();
        entity.setNonConformLoadScheduleId( event.getNonConformLoadScheduleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadSchedule( entity );
    }

    /*
     * @param	event UpdateNonConformLoadScheduleEvent
     */
    @EventHandler( payloadType=UpdateNonConformLoadScheduleEvent.class )
    public void handle( UpdateNonConformLoadScheduleEvent event) {
    	LOGGER.info("handling UpdateNonConformLoadScheduleEvent - " + event );
    	
	    NonConformLoadSchedule entity = new NonConformLoadSchedule();
        entity.setNonConformLoadScheduleId( event.getNonConformLoadScheduleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNonConformLoadSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadSchedule( entity );        
    }
    
    /*
     * @param	event DeleteNonConformLoadScheduleEvent
     */
    @EventHandler( payloadType=DeleteNonConformLoadScheduleEvent.class )
    public void handle( DeleteNonConformLoadScheduleEvent event) {
    	LOGGER.info("handling DeleteNonConformLoadScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NonConformLoadSchedule entity = delete( event.getNonConformLoadScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonConformLoadSchedule( entity );

    }    




    /**
     * Method to retrieve the NonConformLoadSchedule via an NonConformLoadSchedulePrimaryKey.
     * @param 	id Long
     * @return 	NonConformLoadSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NonConformLoadSchedule handle( FindNonConformLoadScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNonConformLoadScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all NonConformLoadSchedules
     *
     * @param	query	FindAllNonConformLoadScheduleQuery 
     * @return 	List<NonConformLoadSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NonConformLoadSchedule> handle( FindAllNonConformLoadScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNonConformLoadSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	NonConformLoadSchedule
	 */
	protected void emitFindNonConformLoadSchedule( NonConformLoadSchedule entity ) {
		LOGGER.info("handling emitFindNonConformLoadSchedule" );
		
	    queryUpdateEmitter.emit(FindNonConformLoadScheduleQuery.class,
	                            query -> query.getFilter().getNonConformLoadScheduleId().equals(entity.getNonConformLoadScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNonConformLoadSchedule
	 * 
	 * @param		entity	NonConformLoadSchedule
	 */
	protected void emitFindAllNonConformLoadSchedule( NonConformLoadSchedule entity ) {
		LOGGER.info("handling emitFindAllNonConformLoadSchedule" );
		
	    queryUpdateEmitter.emit(FindAllNonConformLoadScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadScheduleProjector.class.getName());

}
