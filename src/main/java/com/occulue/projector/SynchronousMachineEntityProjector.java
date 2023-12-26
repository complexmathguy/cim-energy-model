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
 * Projector for SynchronousMachine as outlined for the CQRS pattern.
 * 
 * Commands are handled by SynchronousMachineAggregate
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachine-entity-projector")
public class SynchronousMachineEntityProjector {
		
	// core constructor
	public SynchronousMachineEntityProjector(SynchronousMachineRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SynchronousMachine
	 * 
     * @param	entity SynchronousMachine
     */
    public SynchronousMachine create( SynchronousMachine entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SynchronousMachine
	 * 
     * @param	entity SynchronousMachine
     */
    public SynchronousMachine update( SynchronousMachine entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SynchronousMachine
	 * 
     * @param	id		UUID
     */
    public SynchronousMachine delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SynchronousMachine entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SynchronousMachine via an FindSynchronousMachineQuery
     * @return 	query	FindSynchronousMachineQuery
     */
    @SuppressWarnings("unused")
    public SynchronousMachine find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SynchronousMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachines
     *
     * @param	query	FindAllSynchronousMachineQuery 
     * @return 	List<SynchronousMachine> 
     */
    @SuppressWarnings("unused")
    public List<SynchronousMachine> findAll( FindAllSynchronousMachineQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SynchronousMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SynchronousMachineRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineEntityProjector.class.getName());

}
