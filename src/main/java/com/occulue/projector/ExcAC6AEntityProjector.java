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
 * Projector for ExcAC6A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC6AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC6A-entity-projector")
public class ExcAC6AEntityProjector {
		
	// core constructor
	public ExcAC6AEntityProjector(ExcAC6ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC6A
	 * 
     * @param	entity ExcAC6A
     */
    public ExcAC6A create( ExcAC6A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC6A
	 * 
     * @param	entity ExcAC6A
     */
    public ExcAC6A update( ExcAC6A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC6A
	 * 
     * @param	id		UUID
     */
    public ExcAC6A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC6A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC6A via an FindExcAC6AQuery
     * @return 	query	FindExcAC6AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC6A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC6A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC6As
     *
     * @param	query	FindAllExcAC6AQuery 
     * @return 	List<ExcAC6A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC6A> findAll( FindAllExcAC6AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC6A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC6ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC6AEntityProjector.class.getName());

}
