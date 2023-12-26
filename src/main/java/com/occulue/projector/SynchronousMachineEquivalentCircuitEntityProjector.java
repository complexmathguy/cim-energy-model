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
 * Projector for SynchronousMachineEquivalentCircuit as outlined for the CQRS pattern.
 * 
 * Commands are handled by SynchronousMachineEquivalentCircuitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineEquivalentCircuit-entity-projector")
public class SynchronousMachineEquivalentCircuitEntityProjector {
		
	// core constructor
	public SynchronousMachineEquivalentCircuitEntityProjector(SynchronousMachineEquivalentCircuitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SynchronousMachineEquivalentCircuit
	 * 
     * @param	entity SynchronousMachineEquivalentCircuit
     */
    public SynchronousMachineEquivalentCircuit create( SynchronousMachineEquivalentCircuit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SynchronousMachineEquivalentCircuit
	 * 
     * @param	entity SynchronousMachineEquivalentCircuit
     */
    public SynchronousMachineEquivalentCircuit update( SynchronousMachineEquivalentCircuit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SynchronousMachineEquivalentCircuit
	 * 
     * @param	id		UUID
     */
    public SynchronousMachineEquivalentCircuit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SynchronousMachineEquivalentCircuit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SynchronousMachineEquivalentCircuit via an FindSynchronousMachineEquivalentCircuitQuery
     * @return 	query	FindSynchronousMachineEquivalentCircuitQuery
     */
    @SuppressWarnings("unused")
    public SynchronousMachineEquivalentCircuit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SynchronousMachineEquivalentCircuit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineEquivalentCircuits
     *
     * @param	query	FindAllSynchronousMachineEquivalentCircuitQuery 
     * @return 	List<SynchronousMachineEquivalentCircuit> 
     */
    @SuppressWarnings("unused")
    public List<SynchronousMachineEquivalentCircuit> findAll( FindAllSynchronousMachineEquivalentCircuitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SynchronousMachineEquivalentCircuit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SynchronousMachineEquivalentCircuitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineEquivalentCircuitEntityProjector.class.getName());

}
