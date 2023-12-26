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
 * Projector for PssSK as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssSKAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssSK-entity-projector")
public class PssSKEntityProjector {
		
	// core constructor
	public PssSKEntityProjector(PssSKRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssSK
	 * 
     * @param	entity PssSK
     */
    public PssSK create( PssSK entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssSK
	 * 
     * @param	entity PssSK
     */
    public PssSK update( PssSK entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssSK
	 * 
     * @param	id		UUID
     */
    public PssSK delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssSK entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssSK via an FindPssSKQuery
     * @return 	query	FindPssSKQuery
     */
    @SuppressWarnings("unused")
    public PssSK find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssSK - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssSKs
     *
     * @param	query	FindAllPssSKQuery 
     * @return 	List<PssSK> 
     */
    @SuppressWarnings("unused")
    public List<PssSK> findAll( FindAllPssSKQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssSK - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssSKRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssSKEntityProjector.class.getName());

}
