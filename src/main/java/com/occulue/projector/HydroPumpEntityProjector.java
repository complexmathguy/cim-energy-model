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
 * Projector for HydroPump as outlined for the CQRS pattern.
 * 
 * Commands are handled by HydroPumpAggregate
 * 
 * @author your_name_here
 *
 */
@Component("hydroPump-entity-projector")
public class HydroPumpEntityProjector {
		
	// core constructor
	public HydroPumpEntityProjector(HydroPumpRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a HydroPump
	 * 
     * @param	entity HydroPump
     */
    public HydroPump create( HydroPump entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a HydroPump
	 * 
     * @param	entity HydroPump
     */
    public HydroPump update( HydroPump entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a HydroPump
	 * 
     * @param	id		UUID
     */
    public HydroPump delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    HydroPump entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the HydroPump via an FindHydroPumpQuery
     * @return 	query	FindHydroPumpQuery
     */
    @SuppressWarnings("unused")
    public HydroPump find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a HydroPump - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all HydroPumps
     *
     * @param	query	FindAllHydroPumpQuery 
     * @return 	List<HydroPump> 
     */
    @SuppressWarnings("unused")
    public List<HydroPump> findAll( FindAllHydroPumpQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all HydroPump - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final HydroPumpRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(HydroPumpEntityProjector.class.getName());

}
