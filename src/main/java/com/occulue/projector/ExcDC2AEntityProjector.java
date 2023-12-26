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
 * Projector for ExcDC2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcDC2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excDC2A-entity-projector")
public class ExcDC2AEntityProjector {
		
	// core constructor
	public ExcDC2AEntityProjector(ExcDC2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcDC2A
	 * 
     * @param	entity ExcDC2A
     */
    public ExcDC2A create( ExcDC2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcDC2A
	 * 
     * @param	entity ExcDC2A
     */
    public ExcDC2A update( ExcDC2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcDC2A
	 * 
     * @param	id		UUID
     */
    public ExcDC2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcDC2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcDC2A via an FindExcDC2AQuery
     * @return 	query	FindExcDC2AQuery
     */
    @SuppressWarnings("unused")
    public ExcDC2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcDC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcDC2As
     *
     * @param	query	FindAllExcDC2AQuery 
     * @return 	List<ExcDC2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcDC2A> findAll( FindAllExcDC2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcDC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcDC2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcDC2AEntityProjector.class.getName());

}
