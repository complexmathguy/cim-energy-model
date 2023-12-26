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
 * Projector for Voltage as outlined for the CQRS pattern.  All event handling and query handling related to Voltage are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VoltageAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("voltage")
@Component("voltage-projector")
public class VoltageProjector extends VoltageEntityProjector {
		
	// core constructor
	public VoltageProjector(VoltageRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVoltageEvent
     */
    @EventHandler( payloadType=CreateVoltageEvent.class )
    public void handle( CreateVoltageEvent event) {
	    LOGGER.info("handling CreateVoltageEvent - " + event );
	    Voltage entity = new Voltage();
        entity.setVoltageId( event.getVoltageId() );
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
        emitFindAllVoltage( entity );
    }

    /*
     * @param	event UpdateVoltageEvent
     */
    @EventHandler( payloadType=UpdateVoltageEvent.class )
    public void handle( UpdateVoltageEvent event) {
    	LOGGER.info("handling UpdateVoltageEvent - " + event );
    	
	    Voltage entity = new Voltage();
        entity.setVoltageId( event.getVoltageId() );
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
        emitFindVoltage( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltage( entity );        
    }
    
    /*
     * @param	event DeleteVoltageEvent
     */
    @EventHandler( payloadType=DeleteVoltageEvent.class )
    public void handle( DeleteVoltageEvent event) {
    	LOGGER.info("handling DeleteVoltageEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Voltage entity = delete( event.getVoltageId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltage( entity );

    }    




    /**
     * Method to retrieve the Voltage via an VoltagePrimaryKey.
     * @param 	id Long
     * @return 	Voltage
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Voltage handle( FindVoltageQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVoltageId() );
    }
    
    /**
     * Method to retrieve a collection of all Voltages
     *
     * @param	query	FindAllVoltageQuery 
     * @return 	List<Voltage> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Voltage> handle( FindAllVoltageQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVoltage, 
	 * but only if the id matches
	 * 
	 * @param		entity	Voltage
	 */
	protected void emitFindVoltage( Voltage entity ) {
		LOGGER.info("handling emitFindVoltage" );
		
	    queryUpdateEmitter.emit(FindVoltageQuery.class,
	                            query -> query.getFilter().getVoltageId().equals(entity.getVoltageId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVoltage
	 * 
	 * @param		entity	Voltage
	 */
	protected void emitFindAllVoltage( Voltage entity ) {
		LOGGER.info("handling emitFindAllVoltage" );
		
	    queryUpdateEmitter.emit(FindAllVoltageQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VoltageProjector.class.getName());

}
