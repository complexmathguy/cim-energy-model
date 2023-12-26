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
 * Projector for ExcAC5A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC5AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC5A-entity-projector")
public class ExcAC5AEntityProjector {
		
	// core constructor
	public ExcAC5AEntityProjector(ExcAC5ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC5A
	 * 
     * @param	entity ExcAC5A
     */
    public ExcAC5A create( ExcAC5A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC5A
	 * 
     * @param	entity ExcAC5A
     */
    public ExcAC5A update( ExcAC5A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC5A
	 * 
     * @param	id		UUID
     */
    public ExcAC5A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC5A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC5A via an FindExcAC5AQuery
     * @return 	query	FindExcAC5AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC5A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC5A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC5As
     *
     * @param	query	FindAllExcAC5AQuery 
     * @return 	List<ExcAC5A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC5A> findAll( FindAllExcAC5AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC5A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC5ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC5AEntityProjector.class.getName());

}
