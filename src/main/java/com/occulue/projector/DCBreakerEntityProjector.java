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
 * Projector for DCBreaker as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCBreakerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCBreaker-entity-projector")
public class DCBreakerEntityProjector {
		
	// core constructor
	public DCBreakerEntityProjector(DCBreakerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCBreaker
	 * 
     * @param	entity DCBreaker
     */
    public DCBreaker create( DCBreaker entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCBreaker
	 * 
     * @param	entity DCBreaker
     */
    public DCBreaker update( DCBreaker entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCBreaker
	 * 
     * @param	id		UUID
     */
    public DCBreaker delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCBreaker entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCBreaker via an FindDCBreakerQuery
     * @return 	query	FindDCBreakerQuery
     */
    @SuppressWarnings("unused")
    public DCBreaker find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCBreaker - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCBreakers
     *
     * @param	query	FindAllDCBreakerQuery 
     * @return 	List<DCBreaker> 
     */
    @SuppressWarnings("unused")
    public List<DCBreaker> findAll( FindAllDCBreakerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCBreaker - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCBreakerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCBreakerEntityProjector.class.getName());

}
