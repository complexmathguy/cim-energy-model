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
 * Projector for ExcSK as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcSKAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excSK-entity-projector")
public class ExcSKEntityProjector {
		
	// core constructor
	public ExcSKEntityProjector(ExcSKRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcSK
	 * 
     * @param	entity ExcSK
     */
    public ExcSK create( ExcSK entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcSK
	 * 
     * @param	entity ExcSK
     */
    public ExcSK update( ExcSK entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcSK
	 * 
     * @param	id		UUID
     */
    public ExcSK delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcSK entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcSK via an FindExcSKQuery
     * @return 	query	FindExcSKQuery
     */
    @SuppressWarnings("unused")
    public ExcSK find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcSK - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcSKs
     *
     * @param	query	FindAllExcSKQuery 
     * @return 	List<ExcSK> 
     */
    @SuppressWarnings("unused")
    public List<ExcSK> findAll( FindAllExcSKQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcSK - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcSKRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSKEntityProjector.class.getName());

}
