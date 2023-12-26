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
 * Projector for NonConformLoad as outlined for the CQRS pattern.
 * 
 * Commands are handled by NonConformLoadAggregate
 * 
 * @author your_name_here
 *
 */
@Component("nonConformLoad-entity-projector")
public class NonConformLoadEntityProjector {
		
	// core constructor
	public NonConformLoadEntityProjector(NonConformLoadRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a NonConformLoad
	 * 
     * @param	entity NonConformLoad
     */
    public NonConformLoad create( NonConformLoad entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a NonConformLoad
	 * 
     * @param	entity NonConformLoad
     */
    public NonConformLoad update( NonConformLoad entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a NonConformLoad
	 * 
     * @param	id		UUID
     */
    public NonConformLoad delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    NonConformLoad entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the NonConformLoad via an FindNonConformLoadQuery
     * @return 	query	FindNonConformLoadQuery
     */
    @SuppressWarnings("unused")
    public NonConformLoad find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a NonConformLoad - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all NonConformLoads
     *
     * @param	query	FindAllNonConformLoadQuery 
     * @return 	List<NonConformLoad> 
     */
    @SuppressWarnings("unused")
    public List<NonConformLoad> findAll( FindAllNonConformLoadQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all NonConformLoad - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final NonConformLoadRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(NonConformLoadEntityProjector.class.getName());

}
