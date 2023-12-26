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
 * Projector for Measurement as outlined for the CQRS pattern.  All event handling and query handling related to Measurement are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MeasurementAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("measurement")
@Component("measurement-projector")
public class MeasurementProjector extends MeasurementEntityProjector {
		
	// core constructor
	public MeasurementProjector(MeasurementRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMeasurementEvent
     */
    @EventHandler( payloadType=CreateMeasurementEvent.class )
    public void handle( CreateMeasurementEvent event) {
	    LOGGER.info("handling CreateMeasurementEvent - " + event );
	    Measurement entity = new Measurement();
        entity.setMeasurementId( event.getMeasurementId() );
        entity.setMeasurementType( event.getMeasurementType() );
        entity.setPhases( event.getPhases() );
        entity.setUnitMultiplier( event.getUnitMultiplier() );
        entity.setUnitSymbol( event.getUnitSymbol() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurement( entity );
    }

    /*
     * @param	event UpdateMeasurementEvent
     */
    @EventHandler( payloadType=UpdateMeasurementEvent.class )
    public void handle( UpdateMeasurementEvent event) {
    	LOGGER.info("handling UpdateMeasurementEvent - " + event );
    	
	    Measurement entity = new Measurement();
        entity.setMeasurementId( event.getMeasurementId() );
        entity.setMeasurementType( event.getMeasurementType() );
        entity.setPhases( event.getPhases() );
        entity.setUnitMultiplier( event.getUnitMultiplier() );
        entity.setUnitSymbol( event.getUnitSymbol() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMeasurement( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurement( entity );        
    }
    
    /*
     * @param	event DeleteMeasurementEvent
     */
    @EventHandler( payloadType=DeleteMeasurementEvent.class )
    public void handle( DeleteMeasurementEvent event) {
    	LOGGER.info("handling DeleteMeasurementEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Measurement entity = delete( event.getMeasurementId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurement( entity );

    }    




    /**
     * Method to retrieve the Measurement via an MeasurementPrimaryKey.
     * @param 	id Long
     * @return 	Measurement
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Measurement handle( FindMeasurementQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMeasurementId() );
    }
    
    /**
     * Method to retrieve a collection of all Measurements
     *
     * @param	query	FindAllMeasurementQuery 
     * @return 	List<Measurement> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Measurement> handle( FindAllMeasurementQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMeasurement, 
	 * but only if the id matches
	 * 
	 * @param		entity	Measurement
	 */
	protected void emitFindMeasurement( Measurement entity ) {
		LOGGER.info("handling emitFindMeasurement" );
		
	    queryUpdateEmitter.emit(FindMeasurementQuery.class,
	                            query -> query.getFilter().getMeasurementId().equals(entity.getMeasurementId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMeasurement
	 * 
	 * @param		entity	Measurement
	 */
	protected void emitFindAllMeasurement( Measurement entity ) {
		LOGGER.info("handling emitFindAllMeasurement" );
		
	    queryUpdateEmitter.emit(FindAllMeasurementQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MeasurementProjector.class.getName());

}
