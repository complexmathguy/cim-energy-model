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
 * Projector for TapSchedule as outlined for the CQRS pattern.  All event handling and query handling related to TapSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TapScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("tapSchedule")
@Component("tapSchedule-projector")
public class TapScheduleProjector extends TapScheduleEntityProjector {
		
	// core constructor
	public TapScheduleProjector(TapScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTapScheduleEvent
     */
    @EventHandler( payloadType=CreateTapScheduleEvent.class )
    public void handle( CreateTapScheduleEvent event) {
	    LOGGER.info("handling CreateTapScheduleEvent - " + event );
	    TapSchedule entity = new TapSchedule();
        entity.setTapScheduleId( event.getTapScheduleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapSchedule( entity );
    }

    /*
     * @param	event UpdateTapScheduleEvent
     */
    @EventHandler( payloadType=UpdateTapScheduleEvent.class )
    public void handle( UpdateTapScheduleEvent event) {
    	LOGGER.info("handling UpdateTapScheduleEvent - " + event );
    	
	    TapSchedule entity = new TapSchedule();
        entity.setTapScheduleId( event.getTapScheduleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTapSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapSchedule( entity );        
    }
    
    /*
     * @param	event DeleteTapScheduleEvent
     */
    @EventHandler( payloadType=DeleteTapScheduleEvent.class )
    public void handle( DeleteTapScheduleEvent event) {
    	LOGGER.info("handling DeleteTapScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TapSchedule entity = delete( event.getTapScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapSchedule( entity );

    }    




    /**
     * Method to retrieve the TapSchedule via an TapSchedulePrimaryKey.
     * @param 	id Long
     * @return 	TapSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TapSchedule handle( FindTapScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTapScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all TapSchedules
     *
     * @param	query	FindAllTapScheduleQuery 
     * @return 	List<TapSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TapSchedule> handle( FindAllTapScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTapSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	TapSchedule
	 */
	protected void emitFindTapSchedule( TapSchedule entity ) {
		LOGGER.info("handling emitFindTapSchedule" );
		
	    queryUpdateEmitter.emit(FindTapScheduleQuery.class,
	                            query -> query.getFilter().getTapScheduleId().equals(entity.getTapScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTapSchedule
	 * 
	 * @param		entity	TapSchedule
	 */
	protected void emitFindAllTapSchedule( TapSchedule entity ) {
		LOGGER.info("handling emitFindAllTapSchedule" );
		
	    queryUpdateEmitter.emit(FindAllTapScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TapScheduleProjector.class.getName());

}
