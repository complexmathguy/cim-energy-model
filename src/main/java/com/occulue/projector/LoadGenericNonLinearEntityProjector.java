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
 * Projector for LoadGenericNonLinear as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadGenericNonLinearAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadGenericNonLinear-entity-projector")
public class LoadGenericNonLinearEntityProjector {
		
	// core constructor
	public LoadGenericNonLinearEntityProjector(LoadGenericNonLinearRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadGenericNonLinear
	 * 
     * @param	entity LoadGenericNonLinear
     */
    public LoadGenericNonLinear create( LoadGenericNonLinear entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadGenericNonLinear
	 * 
     * @param	entity LoadGenericNonLinear
     */
    public LoadGenericNonLinear update( LoadGenericNonLinear entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadGenericNonLinear
	 * 
     * @param	id		UUID
     */
    public LoadGenericNonLinear delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadGenericNonLinear entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadGenericNonLinear via an FindLoadGenericNonLinearQuery
     * @return 	query	FindLoadGenericNonLinearQuery
     */
    @SuppressWarnings("unused")
    public LoadGenericNonLinear find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadGenericNonLinear - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadGenericNonLinears
     *
     * @param	query	FindAllLoadGenericNonLinearQuery 
     * @return 	List<LoadGenericNonLinear> 
     */
    @SuppressWarnings("unused")
    public List<LoadGenericNonLinear> findAll( FindAllLoadGenericNonLinearQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadGenericNonLinear - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadGenericNonLinearRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadGenericNonLinearEntityProjector.class.getName());

}
