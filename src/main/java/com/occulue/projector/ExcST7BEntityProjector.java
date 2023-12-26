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
 * Projector for ExcST7B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcST7BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excST7B-entity-projector")
public class ExcST7BEntityProjector {
		
	// core constructor
	public ExcST7BEntityProjector(ExcST7BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcST7B
	 * 
     * @param	entity ExcST7B
     */
    public ExcST7B create( ExcST7B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcST7B
	 * 
     * @param	entity ExcST7B
     */
    public ExcST7B update( ExcST7B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcST7B
	 * 
     * @param	id		UUID
     */
    public ExcST7B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcST7B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcST7B via an FindExcST7BQuery
     * @return 	query	FindExcST7BQuery
     */
    @SuppressWarnings("unused")
    public ExcST7B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcST7B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcST7Bs
     *
     * @param	query	FindAllExcST7BQuery 
     * @return 	List<ExcST7B> 
     */
    @SuppressWarnings("unused")
    public List<ExcST7B> findAll( FindAllExcST7BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcST7B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcST7BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST7BEntityProjector.class.getName());

}
