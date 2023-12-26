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
 * Projector for ExcST3A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcST3AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excST3A-entity-projector")
public class ExcST3AEntityProjector {
		
	// core constructor
	public ExcST3AEntityProjector(ExcST3ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcST3A
	 * 
     * @param	entity ExcST3A
     */
    public ExcST3A create( ExcST3A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcST3A
	 * 
     * @param	entity ExcST3A
     */
    public ExcST3A update( ExcST3A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcST3A
	 * 
     * @param	id		UUID
     */
    public ExcST3A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcST3A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcST3A via an FindExcST3AQuery
     * @return 	query	FindExcST3AQuery
     */
    @SuppressWarnings("unused")
    public ExcST3A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcST3A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcST3As
     *
     * @param	query	FindAllExcST3AQuery 
     * @return 	List<ExcST3A> 
     */
    @SuppressWarnings("unused")
    public List<ExcST3A> findAll( FindAllExcST3AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcST3A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcST3ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST3AEntityProjector.class.getName());

}
