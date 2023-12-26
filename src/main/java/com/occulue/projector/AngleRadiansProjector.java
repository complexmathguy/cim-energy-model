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
 * Projector for AngleRadians as outlined for the CQRS pattern.  All event handling and query handling related to AngleRadians are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AngleRadiansAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("angleRadians")
@Component("angleRadians-projector")
public class AngleRadiansProjector extends AngleRadiansEntityProjector {
		
	// core constructor
	public AngleRadiansProjector(AngleRadiansRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAngleRadiansEvent
     */
    @EventHandler( payloadType=CreateAngleRadiansEvent.class )
    public void handle( CreateAngleRadiansEvent event) {
	    LOGGER.info("handling CreateAngleRadiansEvent - " + event );
	    AngleRadians entity = new AngleRadians();
        entity.setAngleRadiansId( event.getAngleRadiansId() );
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
        emitFindAllAngleRadians( entity );
    }

    /*
     * @param	event UpdateAngleRadiansEvent
     */
    @EventHandler( payloadType=UpdateAngleRadiansEvent.class )
    public void handle( UpdateAngleRadiansEvent event) {
    	LOGGER.info("handling UpdateAngleRadiansEvent - " + event );
    	
	    AngleRadians entity = new AngleRadians();
        entity.setAngleRadiansId( event.getAngleRadiansId() );
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
        emitFindAngleRadians( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAngleRadians( entity );        
    }
    
    /*
     * @param	event DeleteAngleRadiansEvent
     */
    @EventHandler( payloadType=DeleteAngleRadiansEvent.class )
    public void handle( DeleteAngleRadiansEvent event) {
    	LOGGER.info("handling DeleteAngleRadiansEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AngleRadians entity = delete( event.getAngleRadiansId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAngleRadians( entity );

    }    




    /**
     * Method to retrieve the AngleRadians via an AngleRadiansPrimaryKey.
     * @param 	id Long
     * @return 	AngleRadians
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AngleRadians handle( FindAngleRadiansQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAngleRadiansId() );
    }
    
    /**
     * Method to retrieve a collection of all AngleRadianss
     *
     * @param	query	FindAllAngleRadiansQuery 
     * @return 	List<AngleRadians> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AngleRadians> handle( FindAllAngleRadiansQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAngleRadians, 
	 * but only if the id matches
	 * 
	 * @param		entity	AngleRadians
	 */
	protected void emitFindAngleRadians( AngleRadians entity ) {
		LOGGER.info("handling emitFindAngleRadians" );
		
	    queryUpdateEmitter.emit(FindAngleRadiansQuery.class,
	                            query -> query.getFilter().getAngleRadiansId().equals(entity.getAngleRadiansId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAngleRadians
	 * 
	 * @param		entity	AngleRadians
	 */
	protected void emitFindAllAngleRadians( AngleRadians entity ) {
		LOGGER.info("handling emitFindAllAngleRadians" );
		
	    queryUpdateEmitter.emit(FindAllAngleRadiansQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AngleRadiansProjector.class.getName());

}
