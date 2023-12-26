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
 * Projector for ExcST1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcST1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excST1A-entity-projector")
public class ExcST1AEntityProjector {
		
	// core constructor
	public ExcST1AEntityProjector(ExcST1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcST1A
	 * 
     * @param	entity ExcST1A
     */
    public ExcST1A create( ExcST1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcST1A
	 * 
     * @param	entity ExcST1A
     */
    public ExcST1A update( ExcST1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcST1A
	 * 
     * @param	id		UUID
     */
    public ExcST1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcST1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcST1A via an FindExcST1AQuery
     * @return 	query	FindExcST1AQuery
     */
    @SuppressWarnings("unused")
    public ExcST1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcST1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcST1As
     *
     * @param	query	FindAllExcST1AQuery 
     * @return 	List<ExcST1A> 
     */
    @SuppressWarnings("unused")
    public List<ExcST1A> findAll( FindAllExcST1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcST1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcST1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcST1AEntityProjector.class.getName());

}
