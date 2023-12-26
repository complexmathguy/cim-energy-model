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
 * Projector for Pss2B as outlined for the CQRS pattern.
 * 
 * Commands are handled by Pss2BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pss2B-entity-projector")
public class Pss2BEntityProjector {
		
	// core constructor
	public Pss2BEntityProjector(Pss2BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Pss2B
	 * 
     * @param	entity Pss2B
     */
    public Pss2B create( Pss2B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Pss2B
	 * 
     * @param	entity Pss2B
     */
    public Pss2B update( Pss2B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Pss2B
	 * 
     * @param	id		UUID
     */
    public Pss2B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Pss2B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Pss2B via an FindPss2BQuery
     * @return 	query	FindPss2BQuery
     */
    @SuppressWarnings("unused")
    public Pss2B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Pss2B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Pss2Bs
     *
     * @param	query	FindAllPss2BQuery 
     * @return 	List<Pss2B> 
     */
    @SuppressWarnings("unused")
    public List<Pss2B> findAll( FindAllPss2BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Pss2B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Pss2BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Pss2BEntityProjector.class.getName());

}
