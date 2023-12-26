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
 * Projector for RegularTimePoint as outlined for the CQRS pattern.  All event handling and query handling related to RegularTimePoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RegularTimePointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("regularTimePoint")
@Component("regularTimePoint-projector")
public class RegularTimePointProjector extends RegularTimePointEntityProjector {
		
	// core constructor
	public RegularTimePointProjector(RegularTimePointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRegularTimePointEvent
     */
    @EventHandler( payloadType=CreateRegularTimePointEvent.class )
    public void handle( CreateRegularTimePointEvent event) {
	    LOGGER.info("handling CreateRegularTimePointEvent - " + event );
	    RegularTimePoint entity = new RegularTimePoint();
        entity.setRegularTimePointId( event.getRegularTimePointId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
        entity.setValue1( event.getValue1() );
        entity.setValue2( event.getValue2() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularTimePoint( entity );
    }

    /*
     * @param	event UpdateRegularTimePointEvent
     */
    @EventHandler( payloadType=UpdateRegularTimePointEvent.class )
    public void handle( UpdateRegularTimePointEvent event) {
    	LOGGER.info("handling UpdateRegularTimePointEvent - " + event );
    	
	    RegularTimePoint entity = new RegularTimePoint();
        entity.setRegularTimePointId( event.getRegularTimePointId() );
        entity.setSequenceNumber( event.getSequenceNumber() );
        entity.setValue1( event.getValue1() );
        entity.setValue2( event.getValue2() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRegularTimePoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularTimePoint( entity );        
    }
    
    /*
     * @param	event DeleteRegularTimePointEvent
     */
    @EventHandler( payloadType=DeleteRegularTimePointEvent.class )
    public void handle( DeleteRegularTimePointEvent event) {
    	LOGGER.info("handling DeleteRegularTimePointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RegularTimePoint entity = delete( event.getRegularTimePointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegularTimePoint( entity );

    }    




    /**
     * Method to retrieve the RegularTimePoint via an RegularTimePointPrimaryKey.
     * @param 	id Long
     * @return 	RegularTimePoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RegularTimePoint handle( FindRegularTimePointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRegularTimePointId() );
    }
    
    /**
     * Method to retrieve a collection of all RegularTimePoints
     *
     * @param	query	FindAllRegularTimePointQuery 
     * @return 	List<RegularTimePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RegularTimePoint> handle( FindAllRegularTimePointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRegularTimePoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	RegularTimePoint
	 */
	protected void emitFindRegularTimePoint( RegularTimePoint entity ) {
		LOGGER.info("handling emitFindRegularTimePoint" );
		
	    queryUpdateEmitter.emit(FindRegularTimePointQuery.class,
	                            query -> query.getFilter().getRegularTimePointId().equals(entity.getRegularTimePointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRegularTimePoint
	 * 
	 * @param		entity	RegularTimePoint
	 */
	protected void emitFindAllRegularTimePoint( RegularTimePoint entity ) {
		LOGGER.info("handling emitFindAllRegularTimePoint" );
		
	    queryUpdateEmitter.emit(FindAllRegularTimePointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RegularTimePointProjector.class.getName());

}
