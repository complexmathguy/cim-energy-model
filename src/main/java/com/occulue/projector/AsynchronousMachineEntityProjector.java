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
 * Projector for AsynchronousMachine as outlined for the CQRS pattern.
 * 
 * Commands are handled by AsynchronousMachineAggregate
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachine-entity-projector")
public class AsynchronousMachineEntityProjector {
		
	// core constructor
	public AsynchronousMachineEntityProjector(AsynchronousMachineRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AsynchronousMachine
	 * 
     * @param	entity AsynchronousMachine
     */
    public AsynchronousMachine create( AsynchronousMachine entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AsynchronousMachine
	 * 
     * @param	entity AsynchronousMachine
     */
    public AsynchronousMachine update( AsynchronousMachine entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AsynchronousMachine
	 * 
     * @param	id		UUID
     */
    public AsynchronousMachine delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AsynchronousMachine entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AsynchronousMachine via an FindAsynchronousMachineQuery
     * @return 	query	FindAsynchronousMachineQuery
     */
    @SuppressWarnings("unused")
    public AsynchronousMachine find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AsynchronousMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachines
     *
     * @param	query	FindAllAsynchronousMachineQuery 
     * @return 	List<AsynchronousMachine> 
     */
    @SuppressWarnings("unused")
    public List<AsynchronousMachine> findAll( FindAllAsynchronousMachineQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AsynchronousMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AsynchronousMachineRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineEntityProjector.class.getName());

}
