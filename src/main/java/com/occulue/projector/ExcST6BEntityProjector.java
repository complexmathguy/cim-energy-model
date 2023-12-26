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
 * Projector for ExcST6B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcST6BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excST6B-entity-projector")
public class ExcST6BEntityProjector {
		
	// core constructor
	public ExcST6BEntityProjector(ExcST6BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcST6B
	 * 
     * @param	entity ExcST6B
     */
    public ExcST6B create( ExcST6B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcST6B
	 * 
     * @param	entity ExcST6B
     */
    public ExcST6B update( ExcST6B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcST6B
	 * 
     * @param	id		UUID
     */
    public ExcST6B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcST6B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcST6B via an FindExcST6BQuery
     * @return 	query	FindExcST6BQuery
     */
    @SuppressWarnings("unused")
    public ExcST6B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcST6B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcST6Bs
     *
     * @param	query	FindAllExcST6BQuery 
     * @return 	List<ExcST6B> 
     */
    @SuppressWarnings("unused")
    public List<ExcST6B> findAll( FindAllExcST6BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcST6B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcST6BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST6BEntityProjector.class.getName());

}
