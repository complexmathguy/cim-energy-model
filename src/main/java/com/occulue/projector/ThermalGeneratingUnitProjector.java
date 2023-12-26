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
 * Projector for ThermalGeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to ThermalGeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ThermalGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("thermalGeneratingUnit")
@Component("thermalGeneratingUnit-projector")
public class ThermalGeneratingUnitProjector extends ThermalGeneratingUnitEntityProjector {
		
	// core constructor
	public ThermalGeneratingUnitProjector(ThermalGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateThermalGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateThermalGeneratingUnitEvent.class )
    public void handle( CreateThermalGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateThermalGeneratingUnitEvent - " + event );
	    ThermalGeneratingUnit entity = new ThermalGeneratingUnit();
        entity.setThermalGeneratingUnitId( event.getThermalGeneratingUnitId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllThermalGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateThermalGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateThermalGeneratingUnitEvent.class )
    public void handle( UpdateThermalGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateThermalGeneratingUnitEvent - " + event );
    	
	    ThermalGeneratingUnit entity = new ThermalGeneratingUnit();
        entity.setThermalGeneratingUnitId( event.getThermalGeneratingUnitId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindThermalGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllThermalGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteThermalGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteThermalGeneratingUnitEvent.class )
    public void handle( DeleteThermalGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteThermalGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ThermalGeneratingUnit entity = delete( event.getThermalGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllThermalGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the ThermalGeneratingUnit via an ThermalGeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	ThermalGeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ThermalGeneratingUnit handle( FindThermalGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getThermalGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all ThermalGeneratingUnits
     *
     * @param	query	FindAllThermalGeneratingUnitQuery 
     * @return 	List<ThermalGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ThermalGeneratingUnit> handle( FindAllThermalGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindThermalGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	ThermalGeneratingUnit
	 */
	protected void emitFindThermalGeneratingUnit( ThermalGeneratingUnit entity ) {
		LOGGER.info("handling emitFindThermalGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindThermalGeneratingUnitQuery.class,
	                            query -> query.getFilter().getThermalGeneratingUnitId().equals(entity.getThermalGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllThermalGeneratingUnit
	 * 
	 * @param		entity	ThermalGeneratingUnit
	 */
	protected void emitFindAllThermalGeneratingUnit( ThermalGeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllThermalGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllThermalGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ThermalGeneratingUnitProjector.class.getName());

}
