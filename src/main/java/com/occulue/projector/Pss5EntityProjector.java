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
 * Projector for Pss5 as outlined for the CQRS pattern.
 * 
 * Commands are handled by Pss5Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pss5-entity-projector")
public class Pss5EntityProjector {
		
	// core constructor
	public Pss5EntityProjector(Pss5Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Pss5
	 * 
     * @param	entity Pss5
     */
    public Pss5 create( Pss5 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Pss5
	 * 
     * @param	entity Pss5
     */
    public Pss5 update( Pss5 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Pss5
	 * 
     * @param	id		UUID
     */
    public Pss5 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Pss5 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Pss5 via an FindPss5Query
     * @return 	query	FindPss5Query
     */
    @SuppressWarnings("unused")
    public Pss5 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Pss5 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Pss5s
     *
     * @param	query	FindAllPss5Query 
     * @return 	List<Pss5> 
     */
    @SuppressWarnings("unused")
    public List<Pss5> findAll( FindAllPss5Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Pss5 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Pss5Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Pss5EntityProjector.class.getName());

}
