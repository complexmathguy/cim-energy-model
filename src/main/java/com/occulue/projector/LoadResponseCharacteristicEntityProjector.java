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
 * Projector for LoadResponseCharacteristic as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadResponseCharacteristicAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadResponseCharacteristic-entity-projector")
public class LoadResponseCharacteristicEntityProjector {
		
	// core constructor
	public LoadResponseCharacteristicEntityProjector(LoadResponseCharacteristicRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadResponseCharacteristic
	 * 
     * @param	entity LoadResponseCharacteristic
     */
    public LoadResponseCharacteristic create( LoadResponseCharacteristic entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadResponseCharacteristic
	 * 
     * @param	entity LoadResponseCharacteristic
     */
    public LoadResponseCharacteristic update( LoadResponseCharacteristic entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadResponseCharacteristic
	 * 
     * @param	id		UUID
     */
    public LoadResponseCharacteristic delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadResponseCharacteristic entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadResponseCharacteristic via an FindLoadResponseCharacteristicQuery
     * @return 	query	FindLoadResponseCharacteristicQuery
     */
    @SuppressWarnings("unused")
    public LoadResponseCharacteristic find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadResponseCharacteristic - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadResponseCharacteristics
     *
     * @param	query	FindAllLoadResponseCharacteristicQuery 
     * @return 	List<LoadResponseCharacteristic> 
     */
    @SuppressWarnings("unused")
    public List<LoadResponseCharacteristic> findAll( FindAllLoadResponseCharacteristicQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadResponseCharacteristic - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadResponseCharacteristicRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadResponseCharacteristicEntityProjector.class.getName());

}
