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
 * Projector for ApparentPowerLimit as outlined for the CQRS pattern.  All event handling and query handling related to ApparentPowerLimit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ApparentPowerLimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("apparentPowerLimit")
@Component("apparentPowerLimit-projector")
public class ApparentPowerLimitProjector extends ApparentPowerLimitEntityProjector {
		
	// core constructor
	public ApparentPowerLimitProjector(ApparentPowerLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateApparentPowerLimitEvent
     */
    @EventHandler( payloadType=CreateApparentPowerLimitEvent.class )
    public void handle( CreateApparentPowerLimitEvent event) {
	    LOGGER.info("handling CreateApparentPowerLimitEvent - " + event );
	    ApparentPowerLimit entity = new ApparentPowerLimit();
        entity.setApparentPowerLimitId( event.getApparentPowerLimitId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllApparentPowerLimit( entity );
    }

    /*
     * @param	event UpdateApparentPowerLimitEvent
     */
    @EventHandler( payloadType=UpdateApparentPowerLimitEvent.class )
    public void handle( UpdateApparentPowerLimitEvent event) {
    	LOGGER.info("handling UpdateApparentPowerLimitEvent - " + event );
    	
	    ApparentPowerLimit entity = new ApparentPowerLimit();
        entity.setApparentPowerLimitId( event.getApparentPowerLimitId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindApparentPowerLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllApparentPowerLimit( entity );        
    }
    
    /*
     * @param	event DeleteApparentPowerLimitEvent
     */
    @EventHandler( payloadType=DeleteApparentPowerLimitEvent.class )
    public void handle( DeleteApparentPowerLimitEvent event) {
    	LOGGER.info("handling DeleteApparentPowerLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ApparentPowerLimit entity = delete( event.getApparentPowerLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllApparentPowerLimit( entity );

    }    




    /**
     * Method to retrieve the ApparentPowerLimit via an ApparentPowerLimitPrimaryKey.
     * @param 	id Long
     * @return 	ApparentPowerLimit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ApparentPowerLimit handle( FindApparentPowerLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getApparentPowerLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all ApparentPowerLimits
     *
     * @param	query	FindAllApparentPowerLimitQuery 
     * @return 	List<ApparentPowerLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ApparentPowerLimit> handle( FindAllApparentPowerLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindApparentPowerLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	ApparentPowerLimit
	 */
	protected void emitFindApparentPowerLimit( ApparentPowerLimit entity ) {
		LOGGER.info("handling emitFindApparentPowerLimit" );
		
	    queryUpdateEmitter.emit(FindApparentPowerLimitQuery.class,
	                            query -> query.getFilter().getApparentPowerLimitId().equals(entity.getApparentPowerLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllApparentPowerLimit
	 * 
	 * @param		entity	ApparentPowerLimit
	 */
	protected void emitFindAllApparentPowerLimit( ApparentPowerLimit entity ) {
		LOGGER.info("handling emitFindAllApparentPowerLimit" );
		
	    queryUpdateEmitter.emit(FindAllApparentPowerLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ApparentPowerLimitProjector.class.getName());

}
