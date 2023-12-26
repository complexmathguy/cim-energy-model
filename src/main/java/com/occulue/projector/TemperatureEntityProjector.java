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
 * Projector for Temperature as outlined for the CQRS pattern.
 * 
 * Commands are handled by TemperatureAggregate
 * 
 * @author your_name_here
 *
 */
@Component("temperature-entity-projector")
public class TemperatureEntityProjector {
		
	// core constructor
	public TemperatureEntityProjector(TemperatureRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Temperature
	 * 
     * @param	entity Temperature
     */
    public Temperature create( Temperature entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Temperature
	 * 
     * @param	entity Temperature
     */
    public Temperature update( Temperature entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Temperature
	 * 
     * @param	id		UUID
     */
    public Temperature delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Temperature entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Temperature via an FindTemperatureQuery
     * @return 	query	FindTemperatureQuery
     */
    @SuppressWarnings("unused")
    public Temperature find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Temperature - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Temperatures
     *
     * @param	query	FindAllTemperatureQuery 
     * @return 	List<Temperature> 
     */
    @SuppressWarnings("unused")
    public List<Temperature> findAll( FindAllTemperatureQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Temperature - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TemperatureRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TemperatureEntityProjector.class.getName());

}
