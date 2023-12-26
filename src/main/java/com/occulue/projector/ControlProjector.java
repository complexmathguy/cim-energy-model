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
 * Projector for Control as outlined for the CQRS pattern.  All event handling and query handling related to Control are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ControlAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("control")
@Component("control-projector")
public class ControlProjector extends ControlEntityProjector {
		
	// core constructor
	public ControlProjector(ControlRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateControlEvent
     */
    @EventHandler( payloadType=CreateControlEvent.class )
    public void handle( CreateControlEvent event) {
	    LOGGER.info("handling CreateControlEvent - " + event );
	    Control entity = new Control();
        entity.setControlId( event.getControlId() );
        entity.setControlType( event.getControlType() );
        entity.setOperationInProgress( event.getOperationInProgress() );
        entity.setTimeStamp( event.getTimeStamp() );
        entity.setUnitMultiplier( event.getUnitMultiplier() );
        entity.setUnitSymbol( event.getUnitSymbol() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControl( entity );
    }

    /*
     * @param	event UpdateControlEvent
     */
    @EventHandler( payloadType=UpdateControlEvent.class )
    public void handle( UpdateControlEvent event) {
    	LOGGER.info("handling UpdateControlEvent - " + event );
    	
	    Control entity = new Control();
        entity.setControlId( event.getControlId() );
        entity.setControlType( event.getControlType() );
        entity.setOperationInProgress( event.getOperationInProgress() );
        entity.setTimeStamp( event.getTimeStamp() );
        entity.setUnitMultiplier( event.getUnitMultiplier() );
        entity.setUnitSymbol( event.getUnitSymbol() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindControl( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControl( entity );        
    }
    
    /*
     * @param	event DeleteControlEvent
     */
    @EventHandler( payloadType=DeleteControlEvent.class )
    public void handle( DeleteControlEvent event) {
    	LOGGER.info("handling DeleteControlEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Control entity = delete( event.getControlId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControl( entity );

    }    




    /**
     * Method to retrieve the Control via an ControlPrimaryKey.
     * @param 	id Long
     * @return 	Control
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Control handle( FindControlQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getControlId() );
    }
    
    /**
     * Method to retrieve a collection of all Controls
     *
     * @param	query	FindAllControlQuery 
     * @return 	List<Control> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Control> handle( FindAllControlQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindControl, 
	 * but only if the id matches
	 * 
	 * @param		entity	Control
	 */
	protected void emitFindControl( Control entity ) {
		LOGGER.info("handling emitFindControl" );
		
	    queryUpdateEmitter.emit(FindControlQuery.class,
	                            query -> query.getFilter().getControlId().equals(entity.getControlId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllControl
	 * 
	 * @param		entity	Control
	 */
	protected void emitFindAllControl( Control entity ) {
		LOGGER.info("handling emitFindAllControl" );
		
	    queryUpdateEmitter.emit(FindAllControlQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ControlProjector.class.getName());

}
