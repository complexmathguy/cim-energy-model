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
 * Projector for WindGeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to WindGeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windGeneratingUnit")
@Component("windGeneratingUnit-projector")
public class WindGeneratingUnitProjector extends WindGeneratingUnitEntityProjector {
		
	// core constructor
	public WindGeneratingUnitProjector(WindGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateWindGeneratingUnitEvent.class )
    public void handle( CreateWindGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateWindGeneratingUnitEvent - " + event );
	    WindGeneratingUnit entity = new WindGeneratingUnit();
        entity.setWindGeneratingUnitId( event.getWindGeneratingUnitId() );
        entity.setWindGenUnitType( event.getWindGenUnitType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateWindGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateWindGeneratingUnitEvent.class )
    public void handle( UpdateWindGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateWindGeneratingUnitEvent - " + event );
    	
	    WindGeneratingUnit entity = new WindGeneratingUnit();
        entity.setWindGeneratingUnitId( event.getWindGeneratingUnitId() );
        entity.setWindGenUnitType( event.getWindGenUnitType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteWindGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteWindGeneratingUnitEvent.class )
    public void handle( DeleteWindGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteWindGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindGeneratingUnit entity = delete( event.getWindGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the WindGeneratingUnit via an WindGeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	WindGeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindGeneratingUnit handle( FindWindGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all WindGeneratingUnits
     *
     * @param	query	FindAllWindGeneratingUnitQuery 
     * @return 	List<WindGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindGeneratingUnit> handle( FindAllWindGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindGeneratingUnit
	 */
	protected void emitFindWindGeneratingUnit( WindGeneratingUnit entity ) {
		LOGGER.info("handling emitFindWindGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindWindGeneratingUnitQuery.class,
	                            query -> query.getFilter().getWindGeneratingUnitId().equals(entity.getWindGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindGeneratingUnit
	 * 
	 * @param		entity	WindGeneratingUnit
	 */
	protected void emitFindAllWindGeneratingUnit( WindGeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllWindGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllWindGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindGeneratingUnitProjector.class.getName());

}
