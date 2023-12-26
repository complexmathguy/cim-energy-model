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
 * Projector for WindPlantDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindPlantDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windPlantDynamics-entity-projector")
public class WindPlantDynamicsEntityProjector {
		
	// core constructor
	public WindPlantDynamicsEntityProjector(WindPlantDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindPlantDynamics
	 * 
     * @param	entity WindPlantDynamics
     */
    public WindPlantDynamics create( WindPlantDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindPlantDynamics
	 * 
     * @param	entity WindPlantDynamics
     */
    public WindPlantDynamics update( WindPlantDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindPlantDynamics
	 * 
     * @param	id		UUID
     */
    public WindPlantDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindPlantDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindPlantDynamics via an FindWindPlantDynamicsQuery
     * @return 	query	FindWindPlantDynamicsQuery
     */
    @SuppressWarnings("unused")
    public WindPlantDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindPlantDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindPlantDynamicss
     *
     * @param	query	FindAllWindPlantDynamicsQuery 
     * @return 	List<WindPlantDynamics> 
     */
    @SuppressWarnings("unused")
    public List<WindPlantDynamics> findAll( FindAllWindPlantDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindPlantDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindPlantDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantDynamicsEntityProjector.class.getName());

}
