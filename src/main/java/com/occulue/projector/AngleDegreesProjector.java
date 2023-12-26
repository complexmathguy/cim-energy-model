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
 * Projector for AngleDegrees as outlined for the CQRS pattern.  All event handling and query handling related to AngleDegrees are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AngleDegreesAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("angleDegrees")
@Component("angleDegrees-projector")
public class AngleDegreesProjector extends AngleDegreesEntityProjector {
		
	// core constructor
	public AngleDegreesProjector(AngleDegreesRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAngleDegreesEvent
     */
    @EventHandler( payloadType=CreateAngleDegreesEvent.class )
    public void handle( CreateAngleDegreesEvent event) {
	    LOGGER.info("handling CreateAngleDegreesEvent - " + event );
	    AngleDegrees entity = new AngleDegrees();
        entity.setAngleDegreesId( event.getAngleDegreesId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAngleDegrees( entity );
    }

    /*
     * @param	event UpdateAngleDegreesEvent
     */
    @EventHandler( payloadType=UpdateAngleDegreesEvent.class )
    public void handle( UpdateAngleDegreesEvent event) {
    	LOGGER.info("handling UpdateAngleDegreesEvent - " + event );
    	
	    AngleDegrees entity = new AngleDegrees();
        entity.setAngleDegreesId( event.getAngleDegreesId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAngleDegrees( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAngleDegrees( entity );        
    }
    
    /*
     * @param	event DeleteAngleDegreesEvent
     */
    @EventHandler( payloadType=DeleteAngleDegreesEvent.class )
    public void handle( DeleteAngleDegreesEvent event) {
    	LOGGER.info("handling DeleteAngleDegreesEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AngleDegrees entity = delete( event.getAngleDegreesId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAngleDegrees( entity );

    }    




    /**
     * Method to retrieve the AngleDegrees via an AngleDegreesPrimaryKey.
     * @param 	id Long
     * @return 	AngleDegrees
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AngleDegrees handle( FindAngleDegreesQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAngleDegreesId() );
    }
    
    /**
     * Method to retrieve a collection of all AngleDegreess
     *
     * @param	query	FindAllAngleDegreesQuery 
     * @return 	List<AngleDegrees> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AngleDegrees> handle( FindAllAngleDegreesQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAngleDegrees, 
	 * but only if the id matches
	 * 
	 * @param		entity	AngleDegrees
	 */
	protected void emitFindAngleDegrees( AngleDegrees entity ) {
		LOGGER.info("handling emitFindAngleDegrees" );
		
	    queryUpdateEmitter.emit(FindAngleDegreesQuery.class,
	                            query -> query.getFilter().getAngleDegreesId().equals(entity.getAngleDegreesId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAngleDegrees
	 * 
	 * @param		entity	AngleDegrees
	 */
	protected void emitFindAllAngleDegrees( AngleDegrees entity ) {
		LOGGER.info("handling emitFindAllAngleDegrees" );
		
	    queryUpdateEmitter.emit(FindAllAngleDegreesQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AngleDegreesProjector.class.getName());

}
