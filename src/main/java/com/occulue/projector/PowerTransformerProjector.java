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
 * Projector for PowerTransformer as outlined for the CQRS pattern.  All event handling and query handling related to PowerTransformer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PowerTransformerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("powerTransformer")
@Component("powerTransformer-projector")
public class PowerTransformerProjector extends PowerTransformerEntityProjector {
		
	// core constructor
	public PowerTransformerProjector(PowerTransformerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePowerTransformerEvent
     */
    @EventHandler( payloadType=CreatePowerTransformerEvent.class )
    public void handle( CreatePowerTransformerEvent event) {
	    LOGGER.info("handling CreatePowerTransformerEvent - " + event );
	    PowerTransformer entity = new PowerTransformer();
        entity.setPowerTransformerId( event.getPowerTransformerId() );
        entity.setBeforeShCircuitHighestOperatingCurrent( event.getBeforeShCircuitHighestOperatingCurrent() );
        entity.setBeforeShCircuitHighestOperatingVoltage( event.getBeforeShCircuitHighestOperatingVoltage() );
        entity.setBeforeShortCircuitAnglePf( event.getBeforeShortCircuitAnglePf() );
        entity.setHighSideMinOperatingU( event.getHighSideMinOperatingU() );
        entity.setIsPartOfGeneratorUnit( event.getIsPartOfGeneratorUnit() );
        entity.setOperationalValuesConsidered( event.getOperationalValuesConsidered() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformer( entity );
    }

    /*
     * @param	event UpdatePowerTransformerEvent
     */
    @EventHandler( payloadType=UpdatePowerTransformerEvent.class )
    public void handle( UpdatePowerTransformerEvent event) {
    	LOGGER.info("handling UpdatePowerTransformerEvent - " + event );
    	
	    PowerTransformer entity = new PowerTransformer();
        entity.setPowerTransformerId( event.getPowerTransformerId() );
        entity.setBeforeShCircuitHighestOperatingCurrent( event.getBeforeShCircuitHighestOperatingCurrent() );
        entity.setBeforeShCircuitHighestOperatingVoltage( event.getBeforeShCircuitHighestOperatingVoltage() );
        entity.setBeforeShortCircuitAnglePf( event.getBeforeShortCircuitAnglePf() );
        entity.setHighSideMinOperatingU( event.getHighSideMinOperatingU() );
        entity.setIsPartOfGeneratorUnit( event.getIsPartOfGeneratorUnit() );
        entity.setOperationalValuesConsidered( event.getOperationalValuesConsidered() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPowerTransformer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformer( entity );        
    }
    
    /*
     * @param	event DeletePowerTransformerEvent
     */
    @EventHandler( payloadType=DeletePowerTransformerEvent.class )
    public void handle( DeletePowerTransformerEvent event) {
    	LOGGER.info("handling DeletePowerTransformerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PowerTransformer entity = delete( event.getPowerTransformerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformer( entity );

    }    




    /**
     * Method to retrieve the PowerTransformer via an PowerTransformerPrimaryKey.
     * @param 	id Long
     * @return 	PowerTransformer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PowerTransformer handle( FindPowerTransformerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPowerTransformerId() );
    }
    
    /**
     * Method to retrieve a collection of all PowerTransformers
     *
     * @param	query	FindAllPowerTransformerQuery 
     * @return 	List<PowerTransformer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PowerTransformer> handle( FindAllPowerTransformerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPowerTransformer, 
	 * but only if the id matches
	 * 
	 * @param		entity	PowerTransformer
	 */
	protected void emitFindPowerTransformer( PowerTransformer entity ) {
		LOGGER.info("handling emitFindPowerTransformer" );
		
	    queryUpdateEmitter.emit(FindPowerTransformerQuery.class,
	                            query -> query.getFilter().getPowerTransformerId().equals(entity.getPowerTransformerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPowerTransformer
	 * 
	 * @param		entity	PowerTransformer
	 */
	protected void emitFindAllPowerTransformer( PowerTransformer entity ) {
		LOGGER.info("handling emitFindAllPowerTransformer" );
		
	    queryUpdateEmitter.emit(FindAllPowerTransformerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PowerTransformerProjector.class.getName());

}
