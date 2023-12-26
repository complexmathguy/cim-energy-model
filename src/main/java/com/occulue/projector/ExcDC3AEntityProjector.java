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
 * Projector for ExcDC3A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcDC3AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excDC3A-entity-projector")
public class ExcDC3AEntityProjector {
		
	// core constructor
	public ExcDC3AEntityProjector(ExcDC3ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcDC3A
	 * 
     * @param	entity ExcDC3A
     */
    public ExcDC3A create( ExcDC3A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcDC3A
	 * 
     * @param	entity ExcDC3A
     */
    public ExcDC3A update( ExcDC3A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcDC3A
	 * 
     * @param	id		UUID
     */
    public ExcDC3A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcDC3A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcDC3A via an FindExcDC3AQuery
     * @return 	query	FindExcDC3AQuery
     */
    @SuppressWarnings("unused")
    public ExcDC3A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcDC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcDC3As
     *
     * @param	query	FindAllExcDC3AQuery 
     * @return 	List<ExcDC3A> 
     */
    @SuppressWarnings("unused")
    public List<ExcDC3A> findAll( FindAllExcDC3AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcDC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcDC3ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC3AEntityProjector.class.getName());

}
