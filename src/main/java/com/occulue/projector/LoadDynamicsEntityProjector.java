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
 * Projector for LoadDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadDynamics-entity-projector")
public class LoadDynamicsEntityProjector {
		
	// core constructor
	public LoadDynamicsEntityProjector(LoadDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadDynamics
	 * 
     * @param	entity LoadDynamics
     */
    public LoadDynamics create( LoadDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadDynamics
	 * 
     * @param	entity LoadDynamics
     */
    public LoadDynamics update( LoadDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadDynamics
	 * 
     * @param	id		UUID
     */
    public LoadDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadDynamics via an FindLoadDynamicsQuery
     * @return 	query	FindLoadDynamicsQuery
     */
    @SuppressWarnings("unused")
    public LoadDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadDynamicss
     *
     * @param	query	FindAllLoadDynamicsQuery 
     * @return 	List<LoadDynamics> 
     */
    @SuppressWarnings("unused")
    public List<LoadDynamics> findAll( FindAllLoadDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadDynamicsEntityProjector.class.getName());

}
