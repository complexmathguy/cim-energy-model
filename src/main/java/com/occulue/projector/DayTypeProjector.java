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
 * Projector for DayType as outlined for the CQRS pattern.  All event handling and query handling related to DayType are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DayTypeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dayType")
@Component("dayType-projector")
public class DayTypeProjector extends DayTypeEntityProjector {
		
	// core constructor
	public DayTypeProjector(DayTypeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDayTypeEvent
     */
    @EventHandler( payloadType=CreateDayTypeEvent.class )
    public void handle( CreateDayTypeEvent event) {
	    LOGGER.info("handling CreateDayTypeEvent - " + event );
	    DayType entity = new DayType();
        entity.setDayTypeId( event.getDayTypeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDayType( entity );
    }

    /*
     * @param	event UpdateDayTypeEvent
     */
    @EventHandler( payloadType=UpdateDayTypeEvent.class )
    public void handle( UpdateDayTypeEvent event) {
    	LOGGER.info("handling UpdateDayTypeEvent - " + event );
    	
	    DayType entity = new DayType();
        entity.setDayTypeId( event.getDayTypeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDayType( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDayType( entity );        
    }
    
    /*
     * @param	event DeleteDayTypeEvent
     */
    @EventHandler( payloadType=DeleteDayTypeEvent.class )
    public void handle( DeleteDayTypeEvent event) {
    	LOGGER.info("handling DeleteDayTypeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DayType entity = delete( event.getDayTypeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDayType( entity );

    }    




    /**
     * Method to retrieve the DayType via an DayTypePrimaryKey.
     * @param 	id Long
     * @return 	DayType
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DayType handle( FindDayTypeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDayTypeId() );
    }
    
    /**
     * Method to retrieve a collection of all DayTypes
     *
     * @param	query	FindAllDayTypeQuery 
     * @return 	List<DayType> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DayType> handle( FindAllDayTypeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDayType, 
	 * but only if the id matches
	 * 
	 * @param		entity	DayType
	 */
	protected void emitFindDayType( DayType entity ) {
		LOGGER.info("handling emitFindDayType" );
		
	    queryUpdateEmitter.emit(FindDayTypeQuery.class,
	                            query -> query.getFilter().getDayTypeId().equals(entity.getDayTypeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDayType
	 * 
	 * @param		entity	DayType
	 */
	protected void emitFindAllDayType( DayType entity ) {
		LOGGER.info("handling emitFindAllDayType" );
		
	    queryUpdateEmitter.emit(FindAllDayTypeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DayTypeProjector.class.getName());

}
