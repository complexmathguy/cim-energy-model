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
 * Projector for SwitchSchedule as outlined for the CQRS pattern.  All event handling and query handling related to SwitchSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SwitchScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("switchSchedule")
@Component("switchSchedule-projector")
public class SwitchScheduleProjector extends SwitchScheduleEntityProjector {
		
	// core constructor
	public SwitchScheduleProjector(SwitchScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSwitchScheduleEvent
     */
    @EventHandler( payloadType=CreateSwitchScheduleEvent.class )
    public void handle( CreateSwitchScheduleEvent event) {
	    LOGGER.info("handling CreateSwitchScheduleEvent - " + event );
	    SwitchSchedule entity = new SwitchSchedule();
        entity.setSwitchScheduleId( event.getSwitchScheduleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchSchedule( entity );
    }

    /*
     * @param	event UpdateSwitchScheduleEvent
     */
    @EventHandler( payloadType=UpdateSwitchScheduleEvent.class )
    public void handle( UpdateSwitchScheduleEvent event) {
    	LOGGER.info("handling UpdateSwitchScheduleEvent - " + event );
    	
	    SwitchSchedule entity = new SwitchSchedule();
        entity.setSwitchScheduleId( event.getSwitchScheduleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSwitchSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchSchedule( entity );        
    }
    
    /*
     * @param	event DeleteSwitchScheduleEvent
     */
    @EventHandler( payloadType=DeleteSwitchScheduleEvent.class )
    public void handle( DeleteSwitchScheduleEvent event) {
    	LOGGER.info("handling DeleteSwitchScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SwitchSchedule entity = delete( event.getSwitchScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSwitchSchedule( entity );

    }    




    /**
     * Method to retrieve the SwitchSchedule via an SwitchSchedulePrimaryKey.
     * @param 	id Long
     * @return 	SwitchSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SwitchSchedule handle( FindSwitchScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSwitchScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all SwitchSchedules
     *
     * @param	query	FindAllSwitchScheduleQuery 
     * @return 	List<SwitchSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SwitchSchedule> handle( FindAllSwitchScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSwitchSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	SwitchSchedule
	 */
	protected void emitFindSwitchSchedule( SwitchSchedule entity ) {
		LOGGER.info("handling emitFindSwitchSchedule" );
		
	    queryUpdateEmitter.emit(FindSwitchScheduleQuery.class,
	                            query -> query.getFilter().getSwitchScheduleId().equals(entity.getSwitchScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSwitchSchedule
	 * 
	 * @param		entity	SwitchSchedule
	 */
	protected void emitFindAllSwitchSchedule( SwitchSchedule entity ) {
		LOGGER.info("handling emitFindAllSwitchSchedule" );
		
	    queryUpdateEmitter.emit(FindAllSwitchScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SwitchScheduleProjector.class.getName());

}
