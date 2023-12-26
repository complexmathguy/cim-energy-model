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
 * Projector for ControlArea as outlined for the CQRS pattern.  All event handling and query handling related to ControlArea are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ControlAreaAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("controlArea")
@Component("controlArea-projector")
public class ControlAreaProjector extends ControlAreaEntityProjector {
		
	// core constructor
	public ControlAreaProjector(ControlAreaRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateControlAreaEvent
     */
    @EventHandler( payloadType=CreateControlAreaEvent.class )
    public void handle( CreateControlAreaEvent event) {
	    LOGGER.info("handling CreateControlAreaEvent - " + event );
	    ControlArea entity = new ControlArea();
        entity.setControlAreaId( event.getControlAreaId() );
        entity.setType( event.getType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlArea( entity );
    }

    /*
     * @param	event UpdateControlAreaEvent
     */
    @EventHandler( payloadType=UpdateControlAreaEvent.class )
    public void handle( UpdateControlAreaEvent event) {
    	LOGGER.info("handling UpdateControlAreaEvent - " + event );
    	
	    ControlArea entity = new ControlArea();
        entity.setControlAreaId( event.getControlAreaId() );
        entity.setType( event.getType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindControlArea( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlArea( entity );        
    }
    
    /*
     * @param	event DeleteControlAreaEvent
     */
    @EventHandler( payloadType=DeleteControlAreaEvent.class )
    public void handle( DeleteControlAreaEvent event) {
    	LOGGER.info("handling DeleteControlAreaEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ControlArea entity = delete( event.getControlAreaId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlArea( entity );

    }    




    /**
     * Method to retrieve the ControlArea via an ControlAreaPrimaryKey.
     * @param 	id Long
     * @return 	ControlArea
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ControlArea handle( FindControlAreaQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getControlAreaId() );
    }
    
    /**
     * Method to retrieve a collection of all ControlAreas
     *
     * @param	query	FindAllControlAreaQuery 
     * @return 	List<ControlArea> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ControlArea> handle( FindAllControlAreaQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindControlArea, 
	 * but only if the id matches
	 * 
	 * @param		entity	ControlArea
	 */
	protected void emitFindControlArea( ControlArea entity ) {
		LOGGER.info("handling emitFindControlArea" );
		
	    queryUpdateEmitter.emit(FindControlAreaQuery.class,
	                            query -> query.getFilter().getControlAreaId().equals(entity.getControlAreaId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllControlArea
	 * 
	 * @param		entity	ControlArea
	 */
	protected void emitFindAllControlArea( ControlArea entity ) {
		LOGGER.info("handling emitFindAllControlArea" );
		
	    queryUpdateEmitter.emit(FindAllControlAreaQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ControlAreaProjector.class.getName());

}
