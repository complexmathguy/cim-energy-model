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
 * Projector for Pss1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by Pss1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pss1A-entity-projector")
public class Pss1AEntityProjector {
		
	// core constructor
	public Pss1AEntityProjector(Pss1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Pss1A
	 * 
     * @param	entity Pss1A
     */
    public Pss1A create( Pss1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Pss1A
	 * 
     * @param	entity Pss1A
     */
    public Pss1A update( Pss1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Pss1A
	 * 
     * @param	id		UUID
     */
    public Pss1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Pss1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Pss1A via an FindPss1AQuery
     * @return 	query	FindPss1AQuery
     */
    @SuppressWarnings("unused")
    public Pss1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Pss1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Pss1As
     *
     * @param	query	FindAllPss1AQuery 
     * @return 	List<Pss1A> 
     */
    @SuppressWarnings("unused")
    public List<Pss1A> findAll( FindAllPss1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Pss1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Pss1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Pss1AEntityProjector.class.getName());

}
