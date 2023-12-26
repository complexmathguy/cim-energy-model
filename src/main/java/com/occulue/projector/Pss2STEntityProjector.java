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
 * Projector for Pss2ST as outlined for the CQRS pattern.
 * 
 * Commands are handled by Pss2STAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pss2ST-entity-projector")
public class Pss2STEntityProjector {
		
	// core constructor
	public Pss2STEntityProjector(Pss2STRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Pss2ST
	 * 
     * @param	entity Pss2ST
     */
    public Pss2ST create( Pss2ST entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Pss2ST
	 * 
     * @param	entity Pss2ST
     */
    public Pss2ST update( Pss2ST entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Pss2ST
	 * 
     * @param	id		UUID
     */
    public Pss2ST delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Pss2ST entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Pss2ST via an FindPss2STQuery
     * @return 	query	FindPss2STQuery
     */
    @SuppressWarnings("unused")
    public Pss2ST find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Pss2ST - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Pss2STs
     *
     * @param	query	FindAllPss2STQuery 
     * @return 	List<Pss2ST> 
     */
    @SuppressWarnings("unused")
    public List<Pss2ST> findAll( FindAllPss2STQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Pss2ST - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Pss2STRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Pss2STEntityProjector.class.getName());

}
