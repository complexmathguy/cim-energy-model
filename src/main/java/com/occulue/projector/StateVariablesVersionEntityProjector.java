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
 * Projector for StateVariablesVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by StateVariablesVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("stateVariablesVersion-entity-projector")
public class StateVariablesVersionEntityProjector {
		
	// core constructor
	public StateVariablesVersionEntityProjector(StateVariablesVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a StateVariablesVersion
	 * 
     * @param	entity StateVariablesVersion
     */
    public StateVariablesVersion create( StateVariablesVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a StateVariablesVersion
	 * 
     * @param	entity StateVariablesVersion
     */
    public StateVariablesVersion update( StateVariablesVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a StateVariablesVersion
	 * 
     * @param	id		UUID
     */
    public StateVariablesVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    StateVariablesVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the StateVariablesVersion via an FindStateVariablesVersionQuery
     * @return 	query	FindStateVariablesVersionQuery
     */
    @SuppressWarnings("unused")
    public StateVariablesVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a StateVariablesVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all StateVariablesVersions
     *
     * @param	query	FindAllStateVariablesVersionQuery 
     * @return 	List<StateVariablesVersion> 
     */
    @SuppressWarnings("unused")
    public List<StateVariablesVersion> findAll( FindAllStateVariablesVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all StateVariablesVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final StateVariablesVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(StateVariablesVersionEntityProjector.class.getName());

}
