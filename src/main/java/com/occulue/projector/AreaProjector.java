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
 * Projector for Area as outlined for the CQRS pattern.  All event handling and query handling related to Area are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AreaAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("area")
@Component("area-projector")
public class AreaProjector extends AreaEntityProjector {
		
	// core constructor
	public AreaProjector(AreaRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAreaEvent
     */
    @EventHandler( payloadType=CreateAreaEvent.class )
    public void handle( CreateAreaEvent event) {
	    LOGGER.info("handling CreateAreaEvent - " + event );
	    Area entity = new Area();
        entity.setAreaId( event.getAreaId() );
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
        emitFindAllArea( entity );
    }

    /*
     * @param	event UpdateAreaEvent
     */
    @EventHandler( payloadType=UpdateAreaEvent.class )
    public void handle( UpdateAreaEvent event) {
    	LOGGER.info("handling UpdateAreaEvent - " + event );
    	
	    Area entity = new Area();
        entity.setAreaId( event.getAreaId() );
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
        emitFindArea( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllArea( entity );        
    }
    
    /*
     * @param	event DeleteAreaEvent
     */
    @EventHandler( payloadType=DeleteAreaEvent.class )
    public void handle( DeleteAreaEvent event) {
    	LOGGER.info("handling DeleteAreaEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Area entity = delete( event.getAreaId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllArea( entity );

    }    




    /**
     * Method to retrieve the Area via an AreaPrimaryKey.
     * @param 	id Long
     * @return 	Area
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Area handle( FindAreaQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAreaId() );
    }
    
    /**
     * Method to retrieve a collection of all Areas
     *
     * @param	query	FindAllAreaQuery 
     * @return 	List<Area> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Area> handle( FindAllAreaQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindArea, 
	 * but only if the id matches
	 * 
	 * @param		entity	Area
	 */
	protected void emitFindArea( Area entity ) {
		LOGGER.info("handling emitFindArea" );
		
	    queryUpdateEmitter.emit(FindAreaQuery.class,
	                            query -> query.getFilter().getAreaId().equals(entity.getAreaId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllArea
	 * 
	 * @param		entity	Area
	 */
	protected void emitFindAllArea( Area entity ) {
		LOGGER.info("handling emitFindAllArea" );
		
	    queryUpdateEmitter.emit(FindAllAreaQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AreaProjector.class.getName());

}
