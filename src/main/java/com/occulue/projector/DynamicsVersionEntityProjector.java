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
 * Projector for DynamicsVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by DynamicsVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dynamicsVersion-entity-projector")
public class DynamicsVersionEntityProjector {
		
	// core constructor
	public DynamicsVersionEntityProjector(DynamicsVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DynamicsVersion
	 * 
     * @param	entity DynamicsVersion
     */
    public DynamicsVersion create( DynamicsVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DynamicsVersion
	 * 
     * @param	entity DynamicsVersion
     */
    public DynamicsVersion update( DynamicsVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DynamicsVersion
	 * 
     * @param	id		UUID
     */
    public DynamicsVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DynamicsVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DynamicsVersion via an FindDynamicsVersionQuery
     * @return 	query	FindDynamicsVersionQuery
     */
    @SuppressWarnings("unused")
    public DynamicsVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DynamicsVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DynamicsVersions
     *
     * @param	query	FindAllDynamicsVersionQuery 
     * @return 	List<DynamicsVersion> 
     */
    @SuppressWarnings("unused")
    public List<DynamicsVersion> findAll( FindAllDynamicsVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DynamicsVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DynamicsVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DynamicsVersionEntityProjector.class.getName());

}
