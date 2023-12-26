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
 * Projector for ExcCZ as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcCZAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excCZ-entity-projector")
public class ExcCZEntityProjector {
		
	// core constructor
	public ExcCZEntityProjector(ExcCZRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcCZ
	 * 
     * @param	entity ExcCZ
     */
    public ExcCZ create( ExcCZ entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcCZ
	 * 
     * @param	entity ExcCZ
     */
    public ExcCZ update( ExcCZ entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcCZ
	 * 
     * @param	id		UUID
     */
    public ExcCZ delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcCZ entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcCZ via an FindExcCZQuery
     * @return 	query	FindExcCZQuery
     */
    @SuppressWarnings("unused")
    public ExcCZ find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcCZ - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcCZs
     *
     * @param	query	FindAllExcCZQuery 
     * @return 	List<ExcCZ> 
     */
    @SuppressWarnings("unused")
    public List<ExcCZ> findAll( FindAllExcCZQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcCZ - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcCZRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcCZEntityProjector.class.getName());

}
