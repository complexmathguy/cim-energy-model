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
 * Projector for ExcAC3A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC3AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC3A-entity-projector")
public class ExcAC3AEntityProjector {
		
	// core constructor
	public ExcAC3AEntityProjector(ExcAC3ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC3A
	 * 
     * @param	entity ExcAC3A
     */
    public ExcAC3A create( ExcAC3A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC3A
	 * 
     * @param	entity ExcAC3A
     */
    public ExcAC3A update( ExcAC3A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC3A
	 * 
     * @param	id		UUID
     */
    public ExcAC3A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC3A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC3A via an FindExcAC3AQuery
     * @return 	query	FindExcAC3AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC3A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC3As
     *
     * @param	query	FindAllExcAC3AQuery 
     * @return 	List<ExcAC3A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC3A> findAll( FindAllExcAC3AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC3ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC3AEntityProjector.class.getName());

}
