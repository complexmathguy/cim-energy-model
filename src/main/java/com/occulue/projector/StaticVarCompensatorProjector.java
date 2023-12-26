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
 * Projector for StaticVarCompensator as outlined for the CQRS pattern.  All event handling and query handling related to StaticVarCompensator are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StaticVarCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("staticVarCompensator")
@Component("staticVarCompensator-projector")
public class StaticVarCompensatorProjector extends StaticVarCompensatorEntityProjector {
		
	// core constructor
	public StaticVarCompensatorProjector(StaticVarCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStaticVarCompensatorEvent
     */
    @EventHandler( payloadType=CreateStaticVarCompensatorEvent.class )
    public void handle( CreateStaticVarCompensatorEvent event) {
	    LOGGER.info("handling CreateStaticVarCompensatorEvent - " + event );
	    StaticVarCompensator entity = new StaticVarCompensator();
        entity.setStaticVarCompensatorId( event.getStaticVarCompensatorId() );
        entity.setCapacitiveRating( event.getCapacitiveRating() );
        entity.setInductiveRating( event.getInductiveRating() );
        entity.setSlope( event.getSlope() );
        entity.setSVCControlMode( event.getSVCControlMode() );
        entity.setVoltageSetPoint( event.getVoltageSetPoint() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticVarCompensator( entity );
    }

    /*
     * @param	event UpdateStaticVarCompensatorEvent
     */
    @EventHandler( payloadType=UpdateStaticVarCompensatorEvent.class )
    public void handle( UpdateStaticVarCompensatorEvent event) {
    	LOGGER.info("handling UpdateStaticVarCompensatorEvent - " + event );
    	
	    StaticVarCompensator entity = new StaticVarCompensator();
        entity.setStaticVarCompensatorId( event.getStaticVarCompensatorId() );
        entity.setCapacitiveRating( event.getCapacitiveRating() );
        entity.setInductiveRating( event.getInductiveRating() );
        entity.setSlope( event.getSlope() );
        entity.setSVCControlMode( event.getSVCControlMode() );
        entity.setVoltageSetPoint( event.getVoltageSetPoint() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStaticVarCompensator( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticVarCompensator( entity );        
    }
    
    /*
     * @param	event DeleteStaticVarCompensatorEvent
     */
    @EventHandler( payloadType=DeleteStaticVarCompensatorEvent.class )
    public void handle( DeleteStaticVarCompensatorEvent event) {
    	LOGGER.info("handling DeleteStaticVarCompensatorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StaticVarCompensator entity = delete( event.getStaticVarCompensatorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStaticVarCompensator( entity );

    }    




    /**
     * Method to retrieve the StaticVarCompensator via an StaticVarCompensatorPrimaryKey.
     * @param 	id Long
     * @return 	StaticVarCompensator
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StaticVarCompensator handle( FindStaticVarCompensatorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStaticVarCompensatorId() );
    }
    
    /**
     * Method to retrieve a collection of all StaticVarCompensators
     *
     * @param	query	FindAllStaticVarCompensatorQuery 
     * @return 	List<StaticVarCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StaticVarCompensator> handle( FindAllStaticVarCompensatorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStaticVarCompensator, 
	 * but only if the id matches
	 * 
	 * @param		entity	StaticVarCompensator
	 */
	protected void emitFindStaticVarCompensator( StaticVarCompensator entity ) {
		LOGGER.info("handling emitFindStaticVarCompensator" );
		
	    queryUpdateEmitter.emit(FindStaticVarCompensatorQuery.class,
	                            query -> query.getFilter().getStaticVarCompensatorId().equals(entity.getStaticVarCompensatorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStaticVarCompensator
	 * 
	 * @param		entity	StaticVarCompensator
	 */
	protected void emitFindAllStaticVarCompensator( StaticVarCompensator entity ) {
		LOGGER.info("handling emitFindAllStaticVarCompensator" );
		
	    queryUpdateEmitter.emit(FindAllStaticVarCompensatorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StaticVarCompensatorProjector.class.getName());

}
