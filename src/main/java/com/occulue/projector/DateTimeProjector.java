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
 * Projector for DateTime as outlined for the CQRS pattern.  All event handling and query handling related to DateTime are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DateTimeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dateTime")
@Component("dateTime-projector")
public class DateTimeProjector extends DateTimeEntityProjector {
		
	// core constructor
	public DateTimeProjector(DateTimeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDateTimeEvent
     */
    @EventHandler( payloadType=CreateDateTimeEvent.class )
    public void handle( CreateDateTimeEvent event) {
	    LOGGER.info("handling CreateDateTimeEvent - " + event );
	    DateTime entity = new DateTime();
        entity.setDateTimeId( event.getDateTimeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateTime( entity );
    }

    /*
     * @param	event UpdateDateTimeEvent
     */
    @EventHandler( payloadType=UpdateDateTimeEvent.class )
    public void handle( UpdateDateTimeEvent event) {
    	LOGGER.info("handling UpdateDateTimeEvent - " + event );
    	
	    DateTime entity = new DateTime();
        entity.setDateTimeId( event.getDateTimeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDateTime( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateTime( entity );        
    }
    
    /*
     * @param	event DeleteDateTimeEvent
     */
    @EventHandler( payloadType=DeleteDateTimeEvent.class )
    public void handle( DeleteDateTimeEvent event) {
    	LOGGER.info("handling DeleteDateTimeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DateTime entity = delete( event.getDateTimeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDateTime( entity );

    }    




    /**
     * Method to retrieve the DateTime via an DateTimePrimaryKey.
     * @param 	id Long
     * @return 	DateTime
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DateTime handle( FindDateTimeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDateTimeId() );
    }
    
    /**
     * Method to retrieve a collection of all DateTimes
     *
     * @param	query	FindAllDateTimeQuery 
     * @return 	List<DateTime> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DateTime> handle( FindAllDateTimeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDateTime, 
	 * but only if the id matches
	 * 
	 * @param		entity	DateTime
	 */
	protected void emitFindDateTime( DateTime entity ) {
		LOGGER.info("handling emitFindDateTime" );
		
	    queryUpdateEmitter.emit(FindDateTimeQuery.class,
	                            query -> query.getFilter().getDateTimeId().equals(entity.getDateTimeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDateTime
	 * 
	 * @param		entity	DateTime
	 */
	protected void emitFindAllDateTime( DateTime entity ) {
		LOGGER.info("handling emitFindAllDateTime" );
		
	    queryUpdateEmitter.emit(FindAllDateTimeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DateTimeProjector.class.getName());

}
