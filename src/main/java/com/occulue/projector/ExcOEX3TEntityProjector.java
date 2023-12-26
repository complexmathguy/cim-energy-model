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
 * Projector for ExcOEX3T as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcOEX3TAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excOEX3T-entity-projector")
public class ExcOEX3TEntityProjector {
		
	// core constructor
	public ExcOEX3TEntityProjector(ExcOEX3TRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcOEX3T
	 * 
     * @param	entity ExcOEX3T
     */
    public ExcOEX3T create( ExcOEX3T entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcOEX3T
	 * 
     * @param	entity ExcOEX3T
     */
    public ExcOEX3T update( ExcOEX3T entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcOEX3T
	 * 
     * @param	id		UUID
     */
    public ExcOEX3T delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcOEX3T entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcOEX3T via an FindExcOEX3TQuery
     * @return 	query	FindExcOEX3TQuery
     */
    @SuppressWarnings("unused")
    public ExcOEX3T find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcOEX3T - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcOEX3Ts
     *
     * @param	query	FindAllExcOEX3TQuery 
     * @return 	List<ExcOEX3T> 
     */
    @SuppressWarnings("unused")
    public List<ExcOEX3T> findAll( FindAllExcOEX3TQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcOEX3T - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcOEX3TRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcOEX3TEntityProjector.class.getName());

}
