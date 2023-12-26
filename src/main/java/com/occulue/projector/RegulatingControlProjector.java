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
 * Projector for RegulatingControl as outlined for the CQRS pattern.  All event handling and query handling related to RegulatingControl are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RegulatingControlAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("regulatingControl")
@Component("regulatingControl-projector")
public class RegulatingControlProjector extends RegulatingControlEntityProjector {
		
	// core constructor
	public RegulatingControlProjector(RegulatingControlRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRegulatingControlEvent
     */
    @EventHandler( payloadType=CreateRegulatingControlEvent.class )
    public void handle( CreateRegulatingControlEvent event) {
	    LOGGER.info("handling CreateRegulatingControlEvent - " + event );
	    RegulatingControl entity = new RegulatingControl();
        entity.setRegulatingControlId( event.getRegulatingControlId() );
        entity.setMode( event.getMode() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegulatingControl( entity );
    }

    /*
     * @param	event UpdateRegulatingControlEvent
     */
    @EventHandler( payloadType=UpdateRegulatingControlEvent.class )
    public void handle( UpdateRegulatingControlEvent event) {
    	LOGGER.info("handling UpdateRegulatingControlEvent - " + event );
    	
	    RegulatingControl entity = new RegulatingControl();
        entity.setRegulatingControlId( event.getRegulatingControlId() );
        entity.setMode( event.getMode() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRegulatingControl( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegulatingControl( entity );        
    }
    
    /*
     * @param	event DeleteRegulatingControlEvent
     */
    @EventHandler( payloadType=DeleteRegulatingControlEvent.class )
    public void handle( DeleteRegulatingControlEvent event) {
    	LOGGER.info("handling DeleteRegulatingControlEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RegulatingControl entity = delete( event.getRegulatingControlId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRegulatingControl( entity );

    }    




    /**
     * Method to retrieve the RegulatingControl via an RegulatingControlPrimaryKey.
     * @param 	id Long
     * @return 	RegulatingControl
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RegulatingControl handle( FindRegulatingControlQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRegulatingControlId() );
    }
    
    /**
     * Method to retrieve a collection of all RegulatingControls
     *
     * @param	query	FindAllRegulatingControlQuery 
     * @return 	List<RegulatingControl> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RegulatingControl> handle( FindAllRegulatingControlQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRegulatingControl, 
	 * but only if the id matches
	 * 
	 * @param		entity	RegulatingControl
	 */
	protected void emitFindRegulatingControl( RegulatingControl entity ) {
		LOGGER.info("handling emitFindRegulatingControl" );
		
	    queryUpdateEmitter.emit(FindRegulatingControlQuery.class,
	                            query -> query.getFilter().getRegulatingControlId().equals(entity.getRegulatingControlId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRegulatingControl
	 * 
	 * @param		entity	RegulatingControl
	 */
	protected void emitFindAllRegulatingControl( RegulatingControl entity ) {
		LOGGER.info("handling emitFindAllRegulatingControl" );
		
	    queryUpdateEmitter.emit(FindAllRegulatingControlQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RegulatingControlProjector.class.getName());

}
