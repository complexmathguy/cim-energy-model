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
 * Projector for LoadResponseCharacteristic as outlined for the CQRS pattern.  All event handling and query handling related to LoadResponseCharacteristic are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadResponseCharacteristicAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadResponseCharacteristic")
@Component("loadResponseCharacteristic-projector")
public class LoadResponseCharacteristicProjector extends LoadResponseCharacteristicEntityProjector {
		
	// core constructor
	public LoadResponseCharacteristicProjector(LoadResponseCharacteristicRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadResponseCharacteristicEvent
     */
    @EventHandler( payloadType=CreateLoadResponseCharacteristicEvent.class )
    public void handle( CreateLoadResponseCharacteristicEvent event) {
	    LOGGER.info("handling CreateLoadResponseCharacteristicEvent - " + event );
	    LoadResponseCharacteristic entity = new LoadResponseCharacteristic();
        entity.setLoadResponseCharacteristicId( event.getLoadResponseCharacteristicId() );
        entity.setExponentModel( event.getExponentModel() );
        entity.setPConstantCurrent( event.getPConstantCurrent() );
        entity.setPConstantImpedance( event.getPConstantImpedance() );
        entity.setPConstantPower( event.getPConstantPower() );
        entity.setPFrequencyExponent( event.getPFrequencyExponent() );
        entity.setPVoltageExponent( event.getPVoltageExponent() );
        entity.setQConstantCurrent( event.getQConstantCurrent() );
        entity.setQConstantImpedance( event.getQConstantImpedance() );
        entity.setQConstantPower( event.getQConstantPower() );
        entity.setQFrequencyExponent( event.getQFrequencyExponent() );
        entity.setQVoltageExponent( event.getQVoltageExponent() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadResponseCharacteristic( entity );
    }

    /*
     * @param	event UpdateLoadResponseCharacteristicEvent
     */
    @EventHandler( payloadType=UpdateLoadResponseCharacteristicEvent.class )
    public void handle( UpdateLoadResponseCharacteristicEvent event) {
    	LOGGER.info("handling UpdateLoadResponseCharacteristicEvent - " + event );
    	
	    LoadResponseCharacteristic entity = new LoadResponseCharacteristic();
        entity.setLoadResponseCharacteristicId( event.getLoadResponseCharacteristicId() );
        entity.setExponentModel( event.getExponentModel() );
        entity.setPConstantCurrent( event.getPConstantCurrent() );
        entity.setPConstantImpedance( event.getPConstantImpedance() );
        entity.setPConstantPower( event.getPConstantPower() );
        entity.setPFrequencyExponent( event.getPFrequencyExponent() );
        entity.setPVoltageExponent( event.getPVoltageExponent() );
        entity.setQConstantCurrent( event.getQConstantCurrent() );
        entity.setQConstantImpedance( event.getQConstantImpedance() );
        entity.setQConstantPower( event.getQConstantPower() );
        entity.setQFrequencyExponent( event.getQFrequencyExponent() );
        entity.setQVoltageExponent( event.getQVoltageExponent() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadResponseCharacteristic( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadResponseCharacteristic( entity );        
    }
    
    /*
     * @param	event DeleteLoadResponseCharacteristicEvent
     */
    @EventHandler( payloadType=DeleteLoadResponseCharacteristicEvent.class )
    public void handle( DeleteLoadResponseCharacteristicEvent event) {
    	LOGGER.info("handling DeleteLoadResponseCharacteristicEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadResponseCharacteristic entity = delete( event.getLoadResponseCharacteristicId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadResponseCharacteristic( entity );

    }    




    /**
     * Method to retrieve the LoadResponseCharacteristic via an LoadResponseCharacteristicPrimaryKey.
     * @param 	id Long
     * @return 	LoadResponseCharacteristic
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadResponseCharacteristic handle( FindLoadResponseCharacteristicQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadResponseCharacteristicId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadResponseCharacteristics
     *
     * @param	query	FindAllLoadResponseCharacteristicQuery 
     * @return 	List<LoadResponseCharacteristic> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadResponseCharacteristic> handle( FindAllLoadResponseCharacteristicQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadResponseCharacteristic, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadResponseCharacteristic
	 */
	protected void emitFindLoadResponseCharacteristic( LoadResponseCharacteristic entity ) {
		LOGGER.info("handling emitFindLoadResponseCharacteristic" );
		
	    queryUpdateEmitter.emit(FindLoadResponseCharacteristicQuery.class,
	                            query -> query.getFilter().getLoadResponseCharacteristicId().equals(entity.getLoadResponseCharacteristicId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadResponseCharacteristic
	 * 
	 * @param		entity	LoadResponseCharacteristic
	 */
	protected void emitFindAllLoadResponseCharacteristic( LoadResponseCharacteristic entity ) {
		LOGGER.info("handling emitFindAllLoadResponseCharacteristic" );
		
	    queryUpdateEmitter.emit(FindAllLoadResponseCharacteristicQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadResponseCharacteristicProjector.class.getName());

}
