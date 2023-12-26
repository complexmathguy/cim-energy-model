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
 * Projector for PowerSystemResource as outlined for the CQRS pattern.
 * 
 * Commands are handled by PowerSystemResourceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("powerSystemResource-entity-projector")
public class PowerSystemResourceEntityProjector {
		
	// core constructor
	public PowerSystemResourceEntityProjector(PowerSystemResourceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PowerSystemResource
	 * 
     * @param	entity PowerSystemResource
     */
    public PowerSystemResource create( PowerSystemResource entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PowerSystemResource
	 * 
     * @param	entity PowerSystemResource
     */
    public PowerSystemResource update( PowerSystemResource entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PowerSystemResource
	 * 
     * @param	id		UUID
     */
    public PowerSystemResource delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PowerSystemResource entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PowerSystemResource via an FindPowerSystemResourceQuery
     * @return 	query	FindPowerSystemResourceQuery
     */
    @SuppressWarnings("unused")
    public PowerSystemResource find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PowerSystemResource - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PowerSystemResources
     *
     * @param	query	FindAllPowerSystemResourceQuery 
     * @return 	List<PowerSystemResource> 
     */
    @SuppressWarnings("unused")
    public List<PowerSystemResource> findAll( FindAllPowerSystemResourceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PowerSystemResource - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PowerSystemResourceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemResourceEntityProjector.class.getName());

}
