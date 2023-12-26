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
 * Projector for AsynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.
 * 
 * Commands are handled by AsynchronousMachineEquivalentCircuitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineEquivalentCircuit-entity-projector")
public class AsynchronousMachineEquivalentCircuitEntityProjector {
		
	// core constructor
	public AsynchronousMachineEquivalentCircuitEntityProjector(AsynchronousMachineEquivalentCircuitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AsynchronousMachineEquivalentCircuit
	 * 
     * @param	entity AsynchronousMachineEquivalentCircuit
     */
    public AsynchronousMachineEquivalentCircuit create( AsynchronousMachineEquivalentCircuit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AsynchronousMachineEquivalentCircuit
	 * 
     * @param	entity AsynchronousMachineEquivalentCircuit
     */
    public AsynchronousMachineEquivalentCircuit update( AsynchronousMachineEquivalentCircuit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AsynchronousMachineEquivalentCircuit
	 * 
     * @param	id		UUID
     */
    public AsynchronousMachineEquivalentCircuit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AsynchronousMachineEquivalentCircuit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AsynchronousMachineEquivalentCircuit via an FindAsynchronousMachineEquivalentCircuitQuery
     * @return 	query	FindAsynchronousMachineEquivalentCircuitQuery
     */
    @SuppressWarnings("unused")
    public AsynchronousMachineEquivalentCircuit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AsynchronousMachineEquivalentCircuit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineEquivalentCircuits
     *
     * @param	query	FindAllAsynchronousMachineEquivalentCircuitQuery 
     * @return 	List<AsynchronousMachineEquivalentCircuit> 
     */
    @SuppressWarnings("unused")
    public List<AsynchronousMachineEquivalentCircuit> findAll( FindAllAsynchronousMachineEquivalentCircuitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AsynchronousMachineEquivalentCircuit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AsynchronousMachineEquivalentCircuitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineEquivalentCircuitEntityProjector.class.getName());

}
