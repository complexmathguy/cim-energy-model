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
 * Projector for VolumeFlowRate as outlined for the CQRS pattern.  All event handling and query handling related to VolumeFlowRate are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VolumeFlowRateAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("volumeFlowRate")
@Component("volumeFlowRate-projector")
public class VolumeFlowRateProjector extends VolumeFlowRateEntityProjector {
		
	// core constructor
	public VolumeFlowRateProjector(VolumeFlowRateRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVolumeFlowRateEvent
     */
    @EventHandler( payloadType=CreateVolumeFlowRateEvent.class )
    public void handle( CreateVolumeFlowRateEvent event) {
	    LOGGER.info("handling CreateVolumeFlowRateEvent - " + event );
	    VolumeFlowRate entity = new VolumeFlowRate();
        entity.setVolumeFlowRateId( event.getVolumeFlowRateId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
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
        emitFindAllVolumeFlowRate( entity );
    }

    /*
     * @param	event UpdateVolumeFlowRateEvent
     */
    @EventHandler( payloadType=UpdateVolumeFlowRateEvent.class )
    public void handle( UpdateVolumeFlowRateEvent event) {
    	LOGGER.info("handling UpdateVolumeFlowRateEvent - " + event );
    	
	    VolumeFlowRate entity = new VolumeFlowRate();
        entity.setVolumeFlowRateId( event.getVolumeFlowRateId() );
        entity.setDenominatorMultiplier( event.getDenominatorMultiplier() );
        entity.setDenominatorUnit( event.getDenominatorUnit() );
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
        emitFindVolumeFlowRate( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVolumeFlowRate( entity );        
    }
    
    /*
     * @param	event DeleteVolumeFlowRateEvent
     */
    @EventHandler( payloadType=DeleteVolumeFlowRateEvent.class )
    public void handle( DeleteVolumeFlowRateEvent event) {
    	LOGGER.info("handling DeleteVolumeFlowRateEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VolumeFlowRate entity = delete( event.getVolumeFlowRateId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVolumeFlowRate( entity );

    }    




    /**
     * Method to retrieve the VolumeFlowRate via an VolumeFlowRatePrimaryKey.
     * @param 	id Long
     * @return 	VolumeFlowRate
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VolumeFlowRate handle( FindVolumeFlowRateQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVolumeFlowRateId() );
    }
    
    /**
     * Method to retrieve a collection of all VolumeFlowRates
     *
     * @param	query	FindAllVolumeFlowRateQuery 
     * @return 	List<VolumeFlowRate> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VolumeFlowRate> handle( FindAllVolumeFlowRateQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVolumeFlowRate, 
	 * but only if the id matches
	 * 
	 * @param		entity	VolumeFlowRate
	 */
	protected void emitFindVolumeFlowRate( VolumeFlowRate entity ) {
		LOGGER.info("handling emitFindVolumeFlowRate" );
		
	    queryUpdateEmitter.emit(FindVolumeFlowRateQuery.class,
	                            query -> query.getFilter().getVolumeFlowRateId().equals(entity.getVolumeFlowRateId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVolumeFlowRate
	 * 
	 * @param		entity	VolumeFlowRate
	 */
	protected void emitFindAllVolumeFlowRate( VolumeFlowRate entity ) {
		LOGGER.info("handling emitFindAllVolumeFlowRate" );
		
	    queryUpdateEmitter.emit(FindAllVolumeFlowRateQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VolumeFlowRateProjector.class.getName());

}
