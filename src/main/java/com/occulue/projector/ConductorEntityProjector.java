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
 * Projector for Conductor as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConductorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("conductor-entity-projector")
public class ConductorEntityProjector {
		
	// core constructor
	public ConductorEntityProjector(ConductorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Conductor
	 * 
     * @param	entity Conductor
     */
    public Conductor create( Conductor entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Conductor
	 * 
     * @param	entity Conductor
     */
    public Conductor update( Conductor entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Conductor
	 * 
     * @param	id		UUID
     */
    public Conductor delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Conductor entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Conductor via an FindConductorQuery
     * @return 	query	FindConductorQuery
     */
    @SuppressWarnings("unused")
    public Conductor find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Conductor - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Conductors
     *
     * @param	query	FindAllConductorQuery 
     * @return 	List<Conductor> 
     */
    @SuppressWarnings("unused")
    public List<Conductor> findAll( FindAllConductorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Conductor - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConductorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConductorEntityProjector.class.getName());

}
