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
 * Projector for PowerSystemStabilizerDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by PowerSystemStabilizerDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("powerSystemStabilizerDynamics-entity-projector")
public class PowerSystemStabilizerDynamicsEntityProjector {
		
	// core constructor
	public PowerSystemStabilizerDynamicsEntityProjector(PowerSystemStabilizerDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PowerSystemStabilizerDynamics
	 * 
     * @param	entity PowerSystemStabilizerDynamics
     */
    public PowerSystemStabilizerDynamics create( PowerSystemStabilizerDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PowerSystemStabilizerDynamics
	 * 
     * @param	entity PowerSystemStabilizerDynamics
     */
    public PowerSystemStabilizerDynamics update( PowerSystemStabilizerDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PowerSystemStabilizerDynamics
	 * 
     * @param	id		UUID
     */
    public PowerSystemStabilizerDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PowerSystemStabilizerDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PowerSystemStabilizerDynamics via an FindPowerSystemStabilizerDynamicsQuery
     * @return 	query	FindPowerSystemStabilizerDynamicsQuery
     */
    @SuppressWarnings("unused")
    public PowerSystemStabilizerDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PowerSystemStabilizerDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PowerSystemStabilizerDynamicss
     *
     * @param	query	FindAllPowerSystemStabilizerDynamicsQuery 
     * @return 	List<PowerSystemStabilizerDynamics> 
     */
    @SuppressWarnings("unused")
    public List<PowerSystemStabilizerDynamics> findAll( FindAllPowerSystemStabilizerDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PowerSystemStabilizerDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PowerSystemStabilizerDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PowerSystemStabilizerDynamicsEntityProjector.class.getName());

}
