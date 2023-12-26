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
 * Projector for HydroGeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to HydroGeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by HydroGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("hydroGeneratingUnit")
@Component("hydroGeneratingUnit-projector")
public class HydroGeneratingUnitProjector extends HydroGeneratingUnitEntityProjector {
		
	// core constructor
	public HydroGeneratingUnitProjector(HydroGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateHydroGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateHydroGeneratingUnitEvent.class )
    public void handle( CreateHydroGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateHydroGeneratingUnitEvent - " + event );
	    HydroGeneratingUnit entity = new HydroGeneratingUnit();
        entity.setHydroGeneratingUnitId( event.getHydroGeneratingUnitId() );
        entity.setEnergyConversionCapability( event.getEnergyConversionCapability() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateHydroGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateHydroGeneratingUnitEvent.class )
    public void handle( UpdateHydroGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateHydroGeneratingUnitEvent - " + event );
    	
	    HydroGeneratingUnit entity = new HydroGeneratingUnit();
        entity.setHydroGeneratingUnitId( event.getHydroGeneratingUnitId() );
        entity.setEnergyConversionCapability( event.getEnergyConversionCapability() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindHydroGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteHydroGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteHydroGeneratingUnitEvent.class )
    public void handle( DeleteHydroGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteHydroGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	HydroGeneratingUnit entity = delete( event.getHydroGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllHydroGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the HydroGeneratingUnit via an HydroGeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	HydroGeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public HydroGeneratingUnit handle( FindHydroGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getHydroGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all HydroGeneratingUnits
     *
     * @param	query	FindAllHydroGeneratingUnitQuery 
     * @return 	List<HydroGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<HydroGeneratingUnit> handle( FindAllHydroGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindHydroGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	HydroGeneratingUnit
	 */
	protected void emitFindHydroGeneratingUnit( HydroGeneratingUnit entity ) {
		LOGGER.info("handling emitFindHydroGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindHydroGeneratingUnitQuery.class,
	                            query -> query.getFilter().getHydroGeneratingUnitId().equals(entity.getHydroGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllHydroGeneratingUnit
	 * 
	 * @param		entity	HydroGeneratingUnit
	 */
	protected void emitFindAllHydroGeneratingUnit( HydroGeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllHydroGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllHydroGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(HydroGeneratingUnitProjector.class.getName());

}
