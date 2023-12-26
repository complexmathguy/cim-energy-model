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
 * Projector for ExcAC2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC2A-entity-projector")
public class ExcAC2AEntityProjector {
		
	// core constructor
	public ExcAC2AEntityProjector(ExcAC2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC2A
	 * 
     * @param	entity ExcAC2A
     */
    public ExcAC2A create( ExcAC2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC2A
	 * 
     * @param	entity ExcAC2A
     */
    public ExcAC2A update( ExcAC2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC2A
	 * 
     * @param	id		UUID
     */
    public ExcAC2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC2A via an FindExcAC2AQuery
     * @return 	query	FindExcAC2AQuery
     */
    @SuppressWarnings("unused")
    public ExcAC2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC2As
     *
     * @param	query	FindAllExcAC2AQuery 
     * @return 	List<ExcAC2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC2A> findAll( FindAllExcAC2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC2AEntityProjector.class.getName());

}
