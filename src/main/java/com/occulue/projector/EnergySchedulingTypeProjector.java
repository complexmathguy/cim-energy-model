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
 * Projector for EnergySchedulingType as outlined for the CQRS pattern.  All event handling and query handling related to EnergySchedulingType are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EnergySchedulingTypeAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("energySchedulingType")
@Component("energySchedulingType-projector")
public class EnergySchedulingTypeProjector extends EnergySchedulingTypeEntityProjector {
		
	// core constructor
	public EnergySchedulingTypeProjector(EnergySchedulingTypeRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEnergySchedulingTypeEvent
     */
    @EventHandler( payloadType=CreateEnergySchedulingTypeEvent.class )
    public void handle( CreateEnergySchedulingTypeEvent event) {
	    LOGGER.info("handling CreateEnergySchedulingTypeEvent - " + event );
	    EnergySchedulingType entity = new EnergySchedulingType();
        entity.setEnergySchedulingTypeId( event.getEnergySchedulingTypeId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergySchedulingType( entity );
    }

    /*
     * @param	event UpdateEnergySchedulingTypeEvent
     */
    @EventHandler( payloadType=UpdateEnergySchedulingTypeEvent.class )
    public void handle( UpdateEnergySchedulingTypeEvent event) {
    	LOGGER.info("handling UpdateEnergySchedulingTypeEvent - " + event );
    	
	    EnergySchedulingType entity = new EnergySchedulingType();
        entity.setEnergySchedulingTypeId( event.getEnergySchedulingTypeId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEnergySchedulingType( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergySchedulingType( entity );        
    }
    
    /*
     * @param	event DeleteEnergySchedulingTypeEvent
     */
    @EventHandler( payloadType=DeleteEnergySchedulingTypeEvent.class )
    public void handle( DeleteEnergySchedulingTypeEvent event) {
    	LOGGER.info("handling DeleteEnergySchedulingTypeEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EnergySchedulingType entity = delete( event.getEnergySchedulingTypeId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEnergySchedulingType( entity );

    }    




    /**
     * Method to retrieve the EnergySchedulingType via an EnergySchedulingTypePrimaryKey.
     * @param 	id Long
     * @return 	EnergySchedulingType
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EnergySchedulingType handle( FindEnergySchedulingTypeQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEnergySchedulingTypeId() );
    }
    
    /**
     * Method to retrieve a collection of all EnergySchedulingTypes
     *
     * @param	query	FindAllEnergySchedulingTypeQuery 
     * @return 	List<EnergySchedulingType> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EnergySchedulingType> handle( FindAllEnergySchedulingTypeQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEnergySchedulingType, 
	 * but only if the id matches
	 * 
	 * @param		entity	EnergySchedulingType
	 */
	protected void emitFindEnergySchedulingType( EnergySchedulingType entity ) {
		LOGGER.info("handling emitFindEnergySchedulingType" );
		
	    queryUpdateEmitter.emit(FindEnergySchedulingTypeQuery.class,
	                            query -> query.getFilter().getEnergySchedulingTypeId().equals(entity.getEnergySchedulingTypeId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEnergySchedulingType
	 * 
	 * @param		entity	EnergySchedulingType
	 */
	protected void emitFindAllEnergySchedulingType( EnergySchedulingType entity ) {
		LOGGER.info("handling emitFindAllEnergySchedulingType" );
		
	    queryUpdateEmitter.emit(FindAllEnergySchedulingTypeQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EnergySchedulingTypeProjector.class.getName());

}
