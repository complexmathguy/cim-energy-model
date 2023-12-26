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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for SolarGeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by SolarGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("solarGeneratingUnit-entity-projector")
public class SolarGeneratingUnitEntityProjector {
		
	// core constructor
	public SolarGeneratingUnitEntityProjector(SolarGeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SolarGeneratingUnit
	 * 
     * @param	entity SolarGeneratingUnit
     */
    public SolarGeneratingUnit create( SolarGeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SolarGeneratingUnit
	 * 
     * @param	entity SolarGeneratingUnit
     */
    public SolarGeneratingUnit update( SolarGeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SolarGeneratingUnit
	 * 
     * @param	id		UUID
     */
    public SolarGeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SolarGeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SolarGeneratingUnit via an FindSolarGeneratingUnitQuery
     * @return 	query	FindSolarGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public SolarGeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SolarGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SolarGeneratingUnits
     *
     * @param	query	FindAllSolarGeneratingUnitQuery 
     * @return 	List<SolarGeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<SolarGeneratingUnit> findAll( FindAllSolarGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SolarGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SolarGeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SolarGeneratingUnitEntityProjector.class.getName());

}
