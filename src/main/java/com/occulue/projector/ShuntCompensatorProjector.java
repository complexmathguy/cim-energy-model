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
 * Projector for ShuntCompensator as outlined for the CQRS pattern.  All event handling and query handling related to ShuntCompensator are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ShuntCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("shuntCompensator")
@Component("shuntCompensator-projector")
public class ShuntCompensatorProjector extends ShuntCompensatorEntityProjector {
		
	// core constructor
	public ShuntCompensatorProjector(ShuntCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateShuntCompensatorEvent
     */
    @EventHandler( payloadType=CreateShuntCompensatorEvent.class )
    public void handle( CreateShuntCompensatorEvent event) {
	    LOGGER.info("handling CreateShuntCompensatorEvent - " + event );
	    ShuntCompensator entity = new ShuntCompensator();
        entity.setShuntCompensatorId( event.getShuntCompensatorId() );
        entity.setAVRDelay( event.getAVRDelay() );
        entity.setGrounded( event.getGrounded() );
        entity.setMaximumSections( event.getMaximumSections() );
        entity.setNomU( event.getNomU() );
        entity.setNormalSections( event.getNormalSections() );
        entity.setSwitchOnCount( event.getSwitchOnCount() );
        entity.setSwitchOnDate( event.getSwitchOnDate() );
        entity.setVoltageSensitivity( event.getVoltageSensitivity() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllShuntCompensator( entity );
    }

    /*
     * @param	event UpdateShuntCompensatorEvent
     */
    @EventHandler( payloadType=UpdateShuntCompensatorEvent.class )
    public void handle( UpdateShuntCompensatorEvent event) {
    	LOGGER.info("handling UpdateShuntCompensatorEvent - " + event );
    	
	    ShuntCompensator entity = new ShuntCompensator();
        entity.setShuntCompensatorId( event.getShuntCompensatorId() );
        entity.setAVRDelay( event.getAVRDelay() );
        entity.setGrounded( event.getGrounded() );
        entity.setMaximumSections( event.getMaximumSections() );
        entity.setNomU( event.getNomU() );
        entity.setNormalSections( event.getNormalSections() );
        entity.setSwitchOnCount( event.getSwitchOnCount() );
        entity.setSwitchOnDate( event.getSwitchOnDate() );
        entity.setVoltageSensitivity( event.getVoltageSensitivity() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindShuntCompensator( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllShuntCompensator( entity );        
    }
    
    /*
     * @param	event DeleteShuntCompensatorEvent
     */
    @EventHandler( payloadType=DeleteShuntCompensatorEvent.class )
    public void handle( DeleteShuntCompensatorEvent event) {
    	LOGGER.info("handling DeleteShuntCompensatorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ShuntCompensator entity = delete( event.getShuntCompensatorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllShuntCompensator( entity );

    }    




    /**
     * Method to retrieve the ShuntCompensator via an ShuntCompensatorPrimaryKey.
     * @param 	id Long
     * @return 	ShuntCompensator
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ShuntCompensator handle( FindShuntCompensatorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getShuntCompensatorId() );
    }
    
    /**
     * Method to retrieve a collection of all ShuntCompensators
     *
     * @param	query	FindAllShuntCompensatorQuery 
     * @return 	List<ShuntCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ShuntCompensator> handle( FindAllShuntCompensatorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindShuntCompensator, 
	 * but only if the id matches
	 * 
	 * @param		entity	ShuntCompensator
	 */
	protected void emitFindShuntCompensator( ShuntCompensator entity ) {
		LOGGER.info("handling emitFindShuntCompensator" );
		
	    queryUpdateEmitter.emit(FindShuntCompensatorQuery.class,
	                            query -> query.getFilter().getShuntCompensatorId().equals(entity.getShuntCompensatorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllShuntCompensator
	 * 
	 * @param		entity	ShuntCompensator
	 */
	protected void emitFindAllShuntCompensator( ShuntCompensator entity ) {
		LOGGER.info("handling emitFindAllShuntCompensator" );
		
	    queryUpdateEmitter.emit(FindAllShuntCompensatorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ShuntCompensatorProjector.class.getName());

}
