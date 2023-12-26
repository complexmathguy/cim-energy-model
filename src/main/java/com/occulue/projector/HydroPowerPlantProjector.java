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
 * Projector for HydroPowerPlant as outlined for the CQRS pattern.  All event handling and query handling related to HydroPowerPlant are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by HydroPowerPlantAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("hydroPowerPlant")
@Component("hydroPowerPlant-projector")
public class HydroPowerPlantProjector extends HydroPowerPlantEntityProjector {
		
	// core constructor
	public HydroPowerPlantProjector(HydroPowerPlantRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateHydroPowerPlantEvent
     */
    @EventHandler( payloadType=CreateHydroPowerPlantEvent.class )
    public void handle( CreateHydroPowerPlantEvent event) {
	    LOGGER.info("handling CreateHydroPowerPlantEvent - " + event );
	    HydroPowerPlant entity = new HydroPowerPlant();
        entity.setHydroPowerPlantId( event.getHydroPowerPlantId() );
        entity.setHydroPlantStorageType( event.getHydroPlantStorageType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroPowerPlant( entity );
    }

    /*
     * @param	event UpdateHydroPowerPlantEvent
     */
    @EventHandler( payloadType=UpdateHydroPowerPlantEvent.class )
    public void handle( UpdateHydroPowerPlantEvent event) {
    	LOGGER.info("handling UpdateHydroPowerPlantEvent - " + event );
    	
	    HydroPowerPlant entity = new HydroPowerPlant();
        entity.setHydroPowerPlantId( event.getHydroPowerPlantId() );
        entity.setHydroPlantStorageType( event.getHydroPlantStorageType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindHydroPowerPlant( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroPowerPlant( entity );        
    }
    
    /*
     * @param	event DeleteHydroPowerPlantEvent
     */
    @EventHandler( payloadType=DeleteHydroPowerPlantEvent.class )
    public void handle( DeleteHydroPowerPlantEvent event) {
    	LOGGER.info("handling DeleteHydroPowerPlantEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	HydroPowerPlant entity = delete( event.getHydroPowerPlantId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroPowerPlant( entity );

    }    




    /**
     * Method to retrieve the HydroPowerPlant via an HydroPowerPlantPrimaryKey.
     * @param 	id Long
     * @return 	HydroPowerPlant
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public HydroPowerPlant handle( FindHydroPowerPlantQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getHydroPowerPlantId() );
    }
    
    /**
     * Method to retrieve a collection of all HydroPowerPlants
     *
     * @param	query	FindAllHydroPowerPlantQuery 
     * @return 	List<HydroPowerPlant> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<HydroPowerPlant> handle( FindAllHydroPowerPlantQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindHydroPowerPlant, 
	 * but only if the id matches
	 * 
	 * @param		entity	HydroPowerPlant
	 */
	protected void emitFindHydroPowerPlant( HydroPowerPlant entity ) {
		LOGGER.info("handling emitFindHydroPowerPlant" );
		
	    queryUpdateEmitter.emit(FindHydroPowerPlantQuery.class,
	                            query -> query.getFilter().getHydroPowerPlantId().equals(entity.getHydroPowerPlantId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllHydroPowerPlant
	 * 
	 * @param		entity	HydroPowerPlant
	 */
	protected void emitFindAllHydroPowerPlant( HydroPowerPlant entity ) {
		LOGGER.info("handling emitFindAllHydroPowerPlant" );
		
	    queryUpdateEmitter.emit(FindAllHydroPowerPlantQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(HydroPowerPlantProjector.class.getName());

}
