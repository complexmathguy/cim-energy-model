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
 * Projector for ConformLoadSchedule as outlined for the CQRS pattern.  All event handling and query handling related to ConformLoadSchedule are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConformLoadScheduleAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("conformLoadSchedule")
@Component("conformLoadSchedule-projector")
public class ConformLoadScheduleProjector extends ConformLoadScheduleEntityProjector {
		
	// core constructor
	public ConformLoadScheduleProjector(ConformLoadScheduleRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConformLoadScheduleEvent
     */
    @EventHandler( payloadType=CreateConformLoadScheduleEvent.class )
    public void handle( CreateConformLoadScheduleEvent event) {
	    LOGGER.info("handling CreateConformLoadScheduleEvent - " + event );
	    ConformLoadSchedule entity = new ConformLoadSchedule();
        entity.setConformLoadScheduleId( event.getConformLoadScheduleId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadSchedule( entity );
    }

    /*
     * @param	event UpdateConformLoadScheduleEvent
     */
    @EventHandler( payloadType=UpdateConformLoadScheduleEvent.class )
    public void handle( UpdateConformLoadScheduleEvent event) {
    	LOGGER.info("handling UpdateConformLoadScheduleEvent - " + event );
    	
	    ConformLoadSchedule entity = new ConformLoadSchedule();
        entity.setConformLoadScheduleId( event.getConformLoadScheduleId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConformLoadSchedule( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadSchedule( entity );        
    }
    
    /*
     * @param	event DeleteConformLoadScheduleEvent
     */
    @EventHandler( payloadType=DeleteConformLoadScheduleEvent.class )
    public void handle( DeleteConformLoadScheduleEvent event) {
    	LOGGER.info("handling DeleteConformLoadScheduleEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConformLoadSchedule entity = delete( event.getConformLoadScheduleId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConformLoadSchedule( entity );

    }    




    /**
     * Method to retrieve the ConformLoadSchedule via an ConformLoadSchedulePrimaryKey.
     * @param 	id Long
     * @return 	ConformLoadSchedule
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConformLoadSchedule handle( FindConformLoadScheduleQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConformLoadScheduleId() );
    }
    
    /**
     * Method to retrieve a collection of all ConformLoadSchedules
     *
     * @param	query	FindAllConformLoadScheduleQuery 
     * @return 	List<ConformLoadSchedule> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConformLoadSchedule> handle( FindAllConformLoadScheduleQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConformLoadSchedule, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConformLoadSchedule
	 */
	protected void emitFindConformLoadSchedule( ConformLoadSchedule entity ) {
		LOGGER.info("handling emitFindConformLoadSchedule" );
		
	    queryUpdateEmitter.emit(FindConformLoadScheduleQuery.class,
	                            query -> query.getFilter().getConformLoadScheduleId().equals(entity.getConformLoadScheduleId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConformLoadSchedule
	 * 
	 * @param		entity	ConformLoadSchedule
	 */
	protected void emitFindAllConformLoadSchedule( ConformLoadSchedule entity ) {
		LOGGER.info("handling emitFindAllConformLoadSchedule" );
		
	    queryUpdateEmitter.emit(FindAllConformLoadScheduleQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadScheduleProjector.class.getName());

}
