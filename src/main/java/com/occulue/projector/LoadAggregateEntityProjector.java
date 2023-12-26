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
 * Projector for LoadAggregate as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadAggregateAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadAggregate-entity-projector")
public class LoadAggregateEntityProjector {
		
	// core constructor
	public LoadAggregateEntityProjector(LoadAggregateRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadAggregate
	 * 
     * @param	entity LoadAggregate
     */
    public LoadAggregate create( LoadAggregate entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadAggregate
	 * 
     * @param	entity LoadAggregate
     */
    public LoadAggregate update( LoadAggregate entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadAggregate
	 * 
     * @param	id		UUID
     */
    public LoadAggregate delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadAggregate entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadAggregate via an FindLoadAggregateQuery
     * @return 	query	FindLoadAggregateQuery
     */
    @SuppressWarnings("unused")
    public LoadAggregate find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadAggregate - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadAggregates
     *
     * @param	query	FindAllLoadAggregateQuery 
     * @return 	List<LoadAggregate> 
     */
    @SuppressWarnings("unused")
    public List<LoadAggregate> findAll( FindAllLoadAggregateQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadAggregate - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadAggregateRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadAggregateEntityProjector.class.getName());

}
