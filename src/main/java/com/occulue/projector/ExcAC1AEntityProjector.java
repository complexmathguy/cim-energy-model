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
 * Projector for ExcAC1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC1A-entity-projector")
public class ExcAC1AEntityProjector {
		
	// core constructor
	public ExcAC1AEntityProjector(ExcAC1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC1A
	 * 
     * @param	entity ExcAC1A
     */
    public ExcAC1A create( ExcAC1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC1A
	 * 
     * @param	entity ExcAC1A
     */
    public ExcAC1A update( ExcAC1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC1A
	 * 
     * @param	id		UUID
     */
    public ExcAC1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC1A via an FindExcAC1AQuery
     * @return 	query	FindExcAC1AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC1As
     *
     * @param	query	FindAllExcAC1AQuery 
     * @return 	List<ExcAC1A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC1A> findAll( FindAllExcAC1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC1AEntityProjector.class.getName());

}
