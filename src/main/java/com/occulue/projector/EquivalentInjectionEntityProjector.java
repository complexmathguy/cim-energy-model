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
 * Projector for EquivalentInjection as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquivalentInjectionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equivalentInjection-entity-projector")
public class EquivalentInjectionEntityProjector {
		
	// core constructor
	public EquivalentInjectionEntityProjector(EquivalentInjectionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquivalentInjection
	 * 
     * @param	entity EquivalentInjection
     */
    public EquivalentInjection create( EquivalentInjection entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquivalentInjection
	 * 
     * @param	entity EquivalentInjection
     */
    public EquivalentInjection update( EquivalentInjection entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquivalentInjection
	 * 
     * @param	id		UUID
     */
    public EquivalentInjection delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquivalentInjection entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquivalentInjection via an FindEquivalentInjectionQuery
     * @return 	query	FindEquivalentInjectionQuery
     */
    @SuppressWarnings("unused")
    public EquivalentInjection find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquivalentInjection - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquivalentInjections
     *
     * @param	query	FindAllEquivalentInjectionQuery 
     * @return 	List<EquivalentInjection> 
     */
    @SuppressWarnings("unused")
    public List<EquivalentInjection> findAll( FindAllEquivalentInjectionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquivalentInjection - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquivalentInjectionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentInjectionEntityProjector.class.getName());

}
