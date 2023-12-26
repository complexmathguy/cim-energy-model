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
 * Projector for AsynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.
 * 
 * Commands are handled by AsynchronousMachineTimeConstantReactanceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineTimeConstantReactance-entity-projector")
public class AsynchronousMachineTimeConstantReactanceEntityProjector {
		
	// core constructor
	public AsynchronousMachineTimeConstantReactanceEntityProjector(AsynchronousMachineTimeConstantReactanceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AsynchronousMachineTimeConstantReactance
	 * 
     * @param	entity AsynchronousMachineTimeConstantReactance
     */
    public AsynchronousMachineTimeConstantReactance create( AsynchronousMachineTimeConstantReactance entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AsynchronousMachineTimeConstantReactance
	 * 
     * @param	entity AsynchronousMachineTimeConstantReactance
     */
    public AsynchronousMachineTimeConstantReactance update( AsynchronousMachineTimeConstantReactance entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AsynchronousMachineTimeConstantReactance
	 * 
     * @param	id		UUID
     */
    public AsynchronousMachineTimeConstantReactance delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AsynchronousMachineTimeConstantReactance entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AsynchronousMachineTimeConstantReactance via an FindAsynchronousMachineTimeConstantReactanceQuery
     * @return 	query	FindAsynchronousMachineTimeConstantReactanceQuery
     */
    @SuppressWarnings("unused")
    public AsynchronousMachineTimeConstantReactance find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AsynchronousMachineTimeConstantReactance - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineTimeConstantReactances
     *
     * @param	query	FindAllAsynchronousMachineTimeConstantReactanceQuery 
     * @return 	List<AsynchronousMachineTimeConstantReactance> 
     */
    @SuppressWarnings("unused")
    public List<AsynchronousMachineTimeConstantReactance> findAll( FindAllAsynchronousMachineTimeConstantReactanceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AsynchronousMachineTimeConstantReactance - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AsynchronousMachineTimeConstantReactanceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineTimeConstantReactanceEntityProjector.class.getName());

}
