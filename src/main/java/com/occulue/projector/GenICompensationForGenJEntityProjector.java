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
 * Projector for GenICompensationForGenJ as outlined for the CQRS pattern.
 * 
 * Commands are handled by GenICompensationForGenJAggregate
 * 
 * @author your_name_here
 *
 */
@Component("genICompensationForGenJ-entity-projector")
public class GenICompensationForGenJEntityProjector {
		
	// core constructor
	public GenICompensationForGenJEntityProjector(GenICompensationForGenJRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GenICompensationForGenJ
	 * 
     * @param	entity GenICompensationForGenJ
     */
    public GenICompensationForGenJ create( GenICompensationForGenJ entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GenICompensationForGenJ
	 * 
     * @param	entity GenICompensationForGenJ
     */
    public GenICompensationForGenJ update( GenICompensationForGenJ entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GenICompensationForGenJ
	 * 
     * @param	id		UUID
     */
    public GenICompensationForGenJ delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GenICompensationForGenJ entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GenICompensationForGenJ via an FindGenICompensationForGenJQuery
     * @return 	query	FindGenICompensationForGenJQuery
     */
    @SuppressWarnings("unused")
    public GenICompensationForGenJ find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GenICompensationForGenJ - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GenICompensationForGenJs
     *
     * @param	query	FindAllGenICompensationForGenJQuery 
     * @return 	List<GenICompensationForGenJ> 
     */
    @SuppressWarnings("unused")
    public List<GenICompensationForGenJ> findAll( FindAllGenICompensationForGenJQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GenICompensationForGenJ - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GenICompensationForGenJRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GenICompensationForGenJEntityProjector.class.getName());

}
