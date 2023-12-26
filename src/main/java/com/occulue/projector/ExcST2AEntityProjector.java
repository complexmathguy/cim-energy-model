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
 * Projector for ExcST2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcST2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excST2A-entity-projector")
public class ExcST2AEntityProjector {
		
	// core constructor
	public ExcST2AEntityProjector(ExcST2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcST2A
	 * 
     * @param	entity ExcST2A
     */
    public ExcST2A create( ExcST2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcST2A
	 * 
     * @param	entity ExcST2A
     */
    public ExcST2A update( ExcST2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcST2A
	 * 
     * @param	id		UUID
     */
    public ExcST2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcST2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcST2A via an FindExcST2AQuery
     * @return 	query	FindExcST2AQuery
     */
    @SuppressWarnings("unused")
    public ExcST2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcST2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcST2As
     *
     * @param	query	FindAllExcST2AQuery 
     * @return 	List<ExcST2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcST2A> findAll( FindAllExcST2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcST2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcST2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST2AEntityProjector.class.getName());

}
