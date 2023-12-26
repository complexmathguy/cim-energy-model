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
 * Projector for Pss1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by Pss1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pss1-entity-projector")
public class Pss1EntityProjector {
		
	// core constructor
	public Pss1EntityProjector(Pss1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Pss1
	 * 
     * @param	entity Pss1
     */
    public Pss1 create( Pss1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Pss1
	 * 
     * @param	entity Pss1
     */
    public Pss1 update( Pss1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Pss1
	 * 
     * @param	id		UUID
     */
    public Pss1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Pss1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Pss1 via an FindPss1Query
     * @return 	query	FindPss1Query
     */
    @SuppressWarnings("unused")
    public Pss1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Pss1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Pss1s
     *
     * @param	query	FindAllPss1Query 
     * @return 	List<Pss1> 
     */
    @SuppressWarnings("unused")
    public List<Pss1> findAll( FindAllPss1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Pss1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Pss1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Pss1EntityProjector.class.getName());

}
