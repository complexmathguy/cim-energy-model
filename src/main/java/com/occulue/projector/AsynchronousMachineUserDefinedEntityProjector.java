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
 * Projector for AsynchronousMachineUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by AsynchronousMachineUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("asynchronousMachineUserDefined-entity-projector")
public class AsynchronousMachineUserDefinedEntityProjector {
		
	// core constructor
	public AsynchronousMachineUserDefinedEntityProjector(AsynchronousMachineUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AsynchronousMachineUserDefined
	 * 
     * @param	entity AsynchronousMachineUserDefined
     */
    public AsynchronousMachineUserDefined create( AsynchronousMachineUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AsynchronousMachineUserDefined
	 * 
     * @param	entity AsynchronousMachineUserDefined
     */
    public AsynchronousMachineUserDefined update( AsynchronousMachineUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AsynchronousMachineUserDefined
	 * 
     * @param	id		UUID
     */
    public AsynchronousMachineUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AsynchronousMachineUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AsynchronousMachineUserDefined via an FindAsynchronousMachineUserDefinedQuery
     * @return 	query	FindAsynchronousMachineUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public AsynchronousMachineUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AsynchronousMachineUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineUserDefineds
     *
     * @param	query	FindAllAsynchronousMachineUserDefinedQuery 
     * @return 	List<AsynchronousMachineUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<AsynchronousMachineUserDefined> findAll( FindAllAsynchronousMachineUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AsynchronousMachineUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AsynchronousMachineUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineUserDefinedEntityProjector.class.getName());

}
