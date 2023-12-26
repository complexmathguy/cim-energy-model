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
 * Projector for AnalogControl as outlined for the CQRS pattern.  All event handling and query handling related to AnalogControl are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AnalogControlAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("analogControl")
@Component("analogControl-projector")
public class AnalogControlProjector extends AnalogControlEntityProjector {
		
	// core constructor
	public AnalogControlProjector(AnalogControlRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAnalogControlEvent
     */
    @EventHandler( payloadType=CreateAnalogControlEvent.class )
    public void handle( CreateAnalogControlEvent event) {
	    LOGGER.info("handling CreateAnalogControlEvent - " + event );
	    AnalogControl entity = new AnalogControl();
        entity.setAnalogControlId( event.getAnalogControlId() );
        entity.setMaxValue( event.getMaxValue() );
        entity.setMinValue( event.getMinValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogControl( entity );
    }

    /*
     * @param	event UpdateAnalogControlEvent
     */
    @EventHandler( payloadType=UpdateAnalogControlEvent.class )
    public void handle( UpdateAnalogControlEvent event) {
    	LOGGER.info("handling UpdateAnalogControlEvent - " + event );
    	
	    AnalogControl entity = new AnalogControl();
        entity.setAnalogControlId( event.getAnalogControlId() );
        entity.setMaxValue( event.getMaxValue() );
        entity.setMinValue( event.getMinValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAnalogControl( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogControl( entity );        
    }
    
    /*
     * @param	event DeleteAnalogControlEvent
     */
    @EventHandler( payloadType=DeleteAnalogControlEvent.class )
    public void handle( DeleteAnalogControlEvent event) {
    	LOGGER.info("handling DeleteAnalogControlEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AnalogControl entity = delete( event.getAnalogControlId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAnalogControl( entity );

    }    




    /**
     * Method to retrieve the AnalogControl via an AnalogControlPrimaryKey.
     * @param 	id Long
     * @return 	AnalogControl
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AnalogControl handle( FindAnalogControlQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAnalogControlId() );
    }
    
    /**
     * Method to retrieve a collection of all AnalogControls
     *
     * @param	query	FindAllAnalogControlQuery 
     * @return 	List<AnalogControl> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AnalogControl> handle( FindAllAnalogControlQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAnalogControl, 
	 * but only if the id matches
	 * 
	 * @param		entity	AnalogControl
	 */
	protected void emitFindAnalogControl( AnalogControl entity ) {
		LOGGER.info("handling emitFindAnalogControl" );
		
	    queryUpdateEmitter.emit(FindAnalogControlQuery.class,
	                            query -> query.getFilter().getAnalogControlId().equals(entity.getAnalogControlId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAnalogControl
	 * 
	 * @param		entity	AnalogControl
	 */
	protected void emitFindAllAnalogControl( AnalogControl entity ) {
		LOGGER.info("handling emitFindAllAnalogControl" );
		
	    queryUpdateEmitter.emit(FindAllAnalogControlQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AnalogControlProjector.class.getName());

}
