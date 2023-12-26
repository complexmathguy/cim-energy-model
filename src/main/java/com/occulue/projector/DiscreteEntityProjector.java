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
 * Projector for Discrete as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiscreteAggregate
 * 
 * @author your_name_here
 *
 */
@Component("discrete-entity-projector")
public class DiscreteEntityProjector {
		
	// core constructor
	public DiscreteEntityProjector(DiscreteRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Discrete
	 * 
     * @param	entity Discrete
     */
    public Discrete create( Discrete entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Discrete
	 * 
     * @param	entity Discrete
     */
    public Discrete update( Discrete entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Discrete
	 * 
     * @param	id		UUID
     */
    public Discrete delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Discrete entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Discrete via an FindDiscreteQuery
     * @return 	query	FindDiscreteQuery
     */
    @SuppressWarnings("unused")
    public Discrete find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Discrete - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Discretes
     *
     * @param	query	FindAllDiscreteQuery 
     * @return 	List<Discrete> 
     */
    @SuppressWarnings("unused")
    public List<Discrete> findAll( FindAllDiscreteQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Discrete - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiscreteRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiscreteEntityProjector.class.getName());

}
