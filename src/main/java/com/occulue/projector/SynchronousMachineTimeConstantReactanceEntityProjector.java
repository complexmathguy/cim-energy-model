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
 * Projector for SynchronousMachineTimeConstantReactance as outlined for the CQRS pattern.
 * 
 * Commands are handled by SynchronousMachineTimeConstantReactanceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineTimeConstantReactance-entity-projector")
public class SynchronousMachineTimeConstantReactanceEntityProjector {
		
	// core constructor
	public SynchronousMachineTimeConstantReactanceEntityProjector(SynchronousMachineTimeConstantReactanceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SynchronousMachineTimeConstantReactance
	 * 
     * @param	entity SynchronousMachineTimeConstantReactance
     */
    public SynchronousMachineTimeConstantReactance create( SynchronousMachineTimeConstantReactance entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SynchronousMachineTimeConstantReactance
	 * 
     * @param	entity SynchronousMachineTimeConstantReactance
     */
    public SynchronousMachineTimeConstantReactance update( SynchronousMachineTimeConstantReactance entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SynchronousMachineTimeConstantReactance
	 * 
     * @param	id		UUID
     */
    public SynchronousMachineTimeConstantReactance delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SynchronousMachineTimeConstantReactance entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SynchronousMachineTimeConstantReactance via an FindSynchronousMachineTimeConstantReactanceQuery
     * @return 	query	FindSynchronousMachineTimeConstantReactanceQuery
     */
    @SuppressWarnings("unused")
    public SynchronousMachineTimeConstantReactance find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SynchronousMachineTimeConstantReactance - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineTimeConstantReactances
     *
     * @param	query	FindAllSynchronousMachineTimeConstantReactanceQuery 
     * @return 	List<SynchronousMachineTimeConstantReactance> 
     */
    @SuppressWarnings("unused")
    public List<SynchronousMachineTimeConstantReactance> findAll( FindAllSynchronousMachineTimeConstantReactanceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SynchronousMachineTimeConstantReactance - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SynchronousMachineTimeConstantReactanceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineTimeConstantReactanceEntityProjector.class.getName());

}
