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
 * Projector for AnalogLimit as outlined for the CQRS pattern.  All event handling and query handling related to AnalogLimit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AnalogLimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("analogLimit")
@Component("analogLimit-projector")
public class AnalogLimitProjector extends AnalogLimitEntityProjector {
		
	// core constructor
	public AnalogLimitProjector(AnalogLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAnalogLimitEvent
     */
    @EventHandler( payloadType=CreateAnalogLimitEvent.class )
    public void handle( CreateAnalogLimitEvent event) {
	    LOGGER.info("handling CreateAnalogLimitEvent - " + event );
	    AnalogLimit entity = new AnalogLimit();
        entity.setAnalogLimitId( event.getAnalogLimitId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimit( entity );
    }

    /*
     * @param	event UpdateAnalogLimitEvent
     */
    @EventHandler( payloadType=UpdateAnalogLimitEvent.class )
    public void handle( UpdateAnalogLimitEvent event) {
    	LOGGER.info("handling UpdateAnalogLimitEvent - " + event );
    	
	    AnalogLimit entity = new AnalogLimit();
        entity.setAnalogLimitId( event.getAnalogLimitId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAnalogLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimit( entity );        
    }
    
    /*
     * @param	event DeleteAnalogLimitEvent
     */
    @EventHandler( payloadType=DeleteAnalogLimitEvent.class )
    public void handle( DeleteAnalogLimitEvent event) {
    	LOGGER.info("handling DeleteAnalogLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AnalogLimit entity = delete( event.getAnalogLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogLimit( entity );

    }    




    /**
     * Method to retrieve the AnalogLimit via an AnalogLimitPrimaryKey.
     * @param 	id Long
     * @return 	AnalogLimit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AnalogLimit handle( FindAnalogLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAnalogLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all AnalogLimits
     *
     * @param	query	FindAllAnalogLimitQuery 
     * @return 	List<AnalogLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AnalogLimit> handle( FindAllAnalogLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAnalogLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	AnalogLimit
	 */
	protected void emitFindAnalogLimit( AnalogLimit entity ) {
		LOGGER.info("handling emitFindAnalogLimit" );
		
	    queryUpdateEmitter.emit(FindAnalogLimitQuery.class,
	                            query -> query.getFilter().getAnalogLimitId().equals(entity.getAnalogLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAnalogLimit
	 * 
	 * @param		entity	AnalogLimit
	 */
	protected void emitFindAllAnalogLimit( AnalogLimit entity ) {
		LOGGER.info("handling emitFindAllAnalogLimit" );
		
	    queryUpdateEmitter.emit(FindAllAnalogLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AnalogLimitProjector.class.getName());

}
