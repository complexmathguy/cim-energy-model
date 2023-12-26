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
 * Projector for LoadGroup as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadGroupAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadGroup-entity-projector")
public class LoadGroupEntityProjector {
		
	// core constructor
	public LoadGroupEntityProjector(LoadGroupRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadGroup
	 * 
     * @param	entity LoadGroup
     */
    public LoadGroup create( LoadGroup entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadGroup
	 * 
     * @param	entity LoadGroup
     */
    public LoadGroup update( LoadGroup entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadGroup
	 * 
     * @param	id		UUID
     */
    public LoadGroup delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadGroup entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadGroup via an FindLoadGroupQuery
     * @return 	query	FindLoadGroupQuery
     */
    @SuppressWarnings("unused")
    public LoadGroup find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadGroup - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadGroups
     *
     * @param	query	FindAllLoadGroupQuery 
     * @return 	List<LoadGroup> 
     */
    @SuppressWarnings("unused")
    public List<LoadGroup> findAll( FindAllLoadGroupQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadGroup - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadGroupRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadGroupEntityProjector.class.getName());

}
