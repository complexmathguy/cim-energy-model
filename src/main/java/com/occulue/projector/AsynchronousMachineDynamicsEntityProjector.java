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
 * Projector for AsynchronousMachineDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by AsynchronousMachineDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineDynamics-entity-projector")
public class AsynchronousMachineDynamicsEntityProjector {
		
	// core constructor
	public AsynchronousMachineDynamicsEntityProjector(AsynchronousMachineDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AsynchronousMachineDynamics
	 * 
     * @param	entity AsynchronousMachineDynamics
     */
    public AsynchronousMachineDynamics create( AsynchronousMachineDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AsynchronousMachineDynamics
	 * 
     * @param	entity AsynchronousMachineDynamics
     */
    public AsynchronousMachineDynamics update( AsynchronousMachineDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AsynchronousMachineDynamics
	 * 
     * @param	id		UUID
     */
    public AsynchronousMachineDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AsynchronousMachineDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AsynchronousMachineDynamics via an FindAsynchronousMachineDynamicsQuery
     * @return 	query	FindAsynchronousMachineDynamicsQuery
     */
    @SuppressWarnings("unused")
    public AsynchronousMachineDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AsynchronousMachineDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineDynamicss
     *
     * @param	query	FindAllAsynchronousMachineDynamicsQuery 
     * @return 	List<AsynchronousMachineDynamics> 
     */
    @SuppressWarnings("unused")
    public List<AsynchronousMachineDynamics> findAll( FindAllAsynchronousMachineDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AsynchronousMachineDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AsynchronousMachineDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineDynamicsEntityProjector.class.getName());

}
