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
 * Projector for ExcAC4A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC4AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC4A-entity-projector")
public class ExcAC4AEntityProjector {
		
	// core constructor
	public ExcAC4AEntityProjector(ExcAC4ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC4A
	 * 
     * @param	entity ExcAC4A
     */
    public ExcAC4A create( ExcAC4A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC4A
	 * 
     * @param	entity ExcAC4A
     */
    public ExcAC4A update( ExcAC4A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC4A
	 * 
     * @param	id		UUID
     */
    public ExcAC4A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC4A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC4A via an FindExcAC4AQuery
     * @return 	query	FindExcAC4AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC4A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC4A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC4As
     *
     * @param	query	FindAllExcAC4AQuery 
     * @return 	List<ExcAC4A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC4A> findAll( FindAllExcAC4AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC4A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC4ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC4AEntityProjector.class.getName());

}
