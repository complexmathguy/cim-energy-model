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
 * Projector for ReportingGroup as outlined for the CQRS pattern.  All event handling and query handling related to ReportingGroup are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ReportingGroupAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("reportingGroup")
@Component("reportingGroup-projector")
public class ReportingGroupProjector extends ReportingGroupEntityProjector {
		
	// core constructor
	public ReportingGroupProjector(ReportingGroupRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateReportingGroupEvent
     */
    @EventHandler( payloadType=CreateReportingGroupEvent.class )
    public void handle( CreateReportingGroupEvent event) {
	    LOGGER.info("handling CreateReportingGroupEvent - " + event );
	    ReportingGroup entity = new ReportingGroup();
        entity.setReportingGroupId( event.getReportingGroupId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReportingGroup( entity );
    }

    /*
     * @param	event UpdateReportingGroupEvent
     */
    @EventHandler( payloadType=UpdateReportingGroupEvent.class )
    public void handle( UpdateReportingGroupEvent event) {
    	LOGGER.info("handling UpdateReportingGroupEvent - " + event );
    	
	    ReportingGroup entity = new ReportingGroup();
        entity.setReportingGroupId( event.getReportingGroupId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindReportingGroup( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReportingGroup( entity );        
    }
    
    /*
     * @param	event DeleteReportingGroupEvent
     */
    @EventHandler( payloadType=DeleteReportingGroupEvent.class )
    public void handle( DeleteReportingGroupEvent event) {
    	LOGGER.info("handling DeleteReportingGroupEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ReportingGroup entity = delete( event.getReportingGroupId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllReportingGroup( entity );

    }    




    /**
     * Method to retrieve the ReportingGroup via an ReportingGroupPrimaryKey.
     * @param 	id Long
     * @return 	ReportingGroup
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ReportingGroup handle( FindReportingGroupQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getReportingGroupId() );
    }
    
    /**
     * Method to retrieve a collection of all ReportingGroups
     *
     * @param	query	FindAllReportingGroupQuery 
     * @return 	List<ReportingGroup> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ReportingGroup> handle( FindAllReportingGroupQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindReportingGroup, 
	 * but only if the id matches
	 * 
	 * @param		entity	ReportingGroup
	 */
	protected void emitFindReportingGroup( ReportingGroup entity ) {
		LOGGER.info("handling emitFindReportingGroup" );
		
	    queryUpdateEmitter.emit(FindReportingGroupQuery.class,
	                            query -> query.getFilter().getReportingGroupId().equals(entity.getReportingGroupId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllReportingGroup
	 * 
	 * @param		entity	ReportingGroup
	 */
	protected void emitFindAllReportingGroup( ReportingGroup entity ) {
		LOGGER.info("handling emitFindAllReportingGroup" );
		
	    queryUpdateEmitter.emit(FindAllReportingGroupQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ReportingGroupProjector.class.getName());

}
