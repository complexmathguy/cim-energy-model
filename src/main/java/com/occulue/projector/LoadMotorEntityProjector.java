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
 * Projector for LoadMotor as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadMotorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadMotor-entity-projector")
public class LoadMotorEntityProjector {
		
	// core constructor
	public LoadMotorEntityProjector(LoadMotorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadMotor
	 * 
     * @param	entity LoadMotor
     */
    public LoadMotor create( LoadMotor entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadMotor
	 * 
     * @param	entity LoadMotor
     */
    public LoadMotor update( LoadMotor entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadMotor
	 * 
     * @param	id		UUID
     */
    public LoadMotor delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadMotor entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadMotor via an FindLoadMotorQuery
     * @return 	query	FindLoadMotorQuery
     */
    @SuppressWarnings("unused")
    public LoadMotor find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadMotor - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadMotors
     *
     * @param	query	FindAllLoadMotorQuery 
     * @return 	List<LoadMotor> 
     */
    @SuppressWarnings("unused")
    public List<LoadMotor> findAll( FindAllLoadMotorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadMotor - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadMotorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadMotorEntityProjector.class.getName());

}
