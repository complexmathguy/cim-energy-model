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
 * Projector for RotatingMachine as outlined for the CQRS pattern.
 * 
 * Commands are handled by RotatingMachineAggregate
 * 
 * @author your_name_here
 *
 */
@Component("rotatingMachine-entity-projector")
public class RotatingMachineEntityProjector {
		
	// core constructor
	public RotatingMachineEntityProjector(RotatingMachineRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RotatingMachine
	 * 
     * @param	entity RotatingMachine
     */
    public RotatingMachine create( RotatingMachine entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RotatingMachine
	 * 
     * @param	entity RotatingMachine
     */
    public RotatingMachine update( RotatingMachine entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RotatingMachine
	 * 
     * @param	id		UUID
     */
    public RotatingMachine delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RotatingMachine entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RotatingMachine via an FindRotatingMachineQuery
     * @return 	query	FindRotatingMachineQuery
     */
    @SuppressWarnings("unused")
    public RotatingMachine find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RotatingMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RotatingMachines
     *
     * @param	query	FindAllRotatingMachineQuery 
     * @return 	List<RotatingMachine> 
     */
    @SuppressWarnings("unused")
    public List<RotatingMachine> findAll( FindAllRotatingMachineQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RotatingMachine - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RotatingMachineRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RotatingMachineEntityProjector.class.getName());

}
