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
 * Projector for SetPoint as outlined for the CQRS pattern.  All event handling and query handling related to SetPoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SetPointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("setPoint")
@Component("setPoint-projector")
public class SetPointProjector extends SetPointEntityProjector {
		
	// core constructor
	public SetPointProjector(SetPointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSetPointEvent
     */
    @EventHandler( payloadType=CreateSetPointEvent.class )
    public void handle( CreateSetPointEvent event) {
	    LOGGER.info("handling CreateSetPointEvent - " + event );
	    SetPoint entity = new SetPoint();
        entity.setSetPointId( event.getSetPointId() );
        entity.setNormalValue( event.getNormalValue() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSetPoint( entity );
    }

    /*
     * @param	event UpdateSetPointEvent
     */
    @EventHandler( payloadType=UpdateSetPointEvent.class )
    public void handle( UpdateSetPointEvent event) {
    	LOGGER.info("handling UpdateSetPointEvent - " + event );
    	
	    SetPoint entity = new SetPoint();
        entity.setSetPointId( event.getSetPointId() );
        entity.setNormalValue( event.getNormalValue() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSetPoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSetPoint( entity );        
    }
    
    /*
     * @param	event DeleteSetPointEvent
     */
    @EventHandler( payloadType=DeleteSetPointEvent.class )
    public void handle( DeleteSetPointEvent event) {
    	LOGGER.info("handling DeleteSetPointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SetPoint entity = delete( event.getSetPointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSetPoint( entity );

    }    




    /**
     * Method to retrieve the SetPoint via an SetPointPrimaryKey.
     * @param 	id Long
     * @return 	SetPoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SetPoint handle( FindSetPointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSetPointId() );
    }
    
    /**
     * Method to retrieve a collection of all SetPoints
     *
     * @param	query	FindAllSetPointQuery 
     * @return 	List<SetPoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SetPoint> handle( FindAllSetPointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSetPoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	SetPoint
	 */
	protected void emitFindSetPoint( SetPoint entity ) {
		LOGGER.info("handling emitFindSetPoint" );
		
	    queryUpdateEmitter.emit(FindSetPointQuery.class,
	                            query -> query.getFilter().getSetPointId().equals(entity.getSetPointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSetPoint
	 * 
	 * @param		entity	SetPoint
	 */
	protected void emitFindAllSetPoint( SetPoint entity ) {
		LOGGER.info("handling emitFindAllSetPoint" );
		
	    queryUpdateEmitter.emit(FindAllSetPointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SetPointProjector.class.getName());

}
