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
 * Projector for HydroGeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by HydroGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("hydroGeneratingUnit-entity-projector")
public class HydroGeneratingUnitEntityProjector {
		
	// core constructor
	public HydroGeneratingUnitEntityProjector(HydroGeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a HydroGeneratingUnit
	 * 
     * @param	entity HydroGeneratingUnit
     */
    public HydroGeneratingUnit create( HydroGeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a HydroGeneratingUnit
	 * 
     * @param	entity HydroGeneratingUnit
     */
    public HydroGeneratingUnit update( HydroGeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a HydroGeneratingUnit
	 * 
     * @param	id		UUID
     */
    public HydroGeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    HydroGeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the HydroGeneratingUnit via an FindHydroGeneratingUnitQuery
     * @return 	query	FindHydroGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public HydroGeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a HydroGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all HydroGeneratingUnits
     *
     * @param	query	FindAllHydroGeneratingUnitQuery 
     * @return 	List<HydroGeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<HydroGeneratingUnit> findAll( FindAllHydroGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all HydroGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final HydroGeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(HydroGeneratingUnitEntityProjector.class.getName());

}
