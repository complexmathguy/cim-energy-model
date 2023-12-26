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
 * Projector for SynchronousMachineSimplified as outlined for the CQRS pattern.
 * 
 * Commands are handled by SynchronousMachineSimplifiedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineSimplified-entity-projector")
public class SynchronousMachineSimplifiedEntityProjector {
		
	// core constructor
	public SynchronousMachineSimplifiedEntityProjector(SynchronousMachineSimplifiedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SynchronousMachineSimplified
	 * 
     * @param	entity SynchronousMachineSimplified
     */
    public SynchronousMachineSimplified create( SynchronousMachineSimplified entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SynchronousMachineSimplified
	 * 
     * @param	entity SynchronousMachineSimplified
     */
    public SynchronousMachineSimplified update( SynchronousMachineSimplified entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SynchronousMachineSimplified
	 * 
     * @param	id		UUID
     */
    public SynchronousMachineSimplified delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SynchronousMachineSimplified entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SynchronousMachineSimplified via an FindSynchronousMachineSimplifiedQuery
     * @return 	query	FindSynchronousMachineSimplifiedQuery
     */
    @SuppressWarnings("unused")
    public SynchronousMachineSimplified find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SynchronousMachineSimplified - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineSimplifieds
     *
     * @param	query	FindAllSynchronousMachineSimplifiedQuery 
     * @return 	List<SynchronousMachineSimplified> 
     */
    @SuppressWarnings("unused")
    public List<SynchronousMachineSimplified> findAll( FindAllSynchronousMachineSimplifiedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SynchronousMachineSimplified - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SynchronousMachineSimplifiedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineSimplifiedEntityProjector.class.getName());

}
