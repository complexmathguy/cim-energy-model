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
 * Projector for SteadyStateHypothesisVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by SteadyStateHypothesisVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("steadyStateHypothesisVersion-entity-projector")
public class SteadyStateHypothesisVersionEntityProjector {
		
	// core constructor
	public SteadyStateHypothesisVersionEntityProjector(SteadyStateHypothesisVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SteadyStateHypothesisVersion
	 * 
     * @param	entity SteadyStateHypothesisVersion
     */
    public SteadyStateHypothesisVersion create( SteadyStateHypothesisVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SteadyStateHypothesisVersion
	 * 
     * @param	entity SteadyStateHypothesisVersion
     */
    public SteadyStateHypothesisVersion update( SteadyStateHypothesisVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SteadyStateHypothesisVersion
	 * 
     * @param	id		UUID
     */
    public SteadyStateHypothesisVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SteadyStateHypothesisVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SteadyStateHypothesisVersion via an FindSteadyStateHypothesisVersionQuery
     * @return 	query	FindSteadyStateHypothesisVersionQuery
     */
    @SuppressWarnings("unused")
    public SteadyStateHypothesisVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SteadyStateHypothesisVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SteadyStateHypothesisVersions
     *
     * @param	query	FindAllSteadyStateHypothesisVersionQuery 
     * @return 	List<SteadyStateHypothesisVersion> 
     */
    @SuppressWarnings("unused")
    public List<SteadyStateHypothesisVersion> findAll( FindAllSteadyStateHypothesisVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SteadyStateHypothesisVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SteadyStateHypothesisVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SteadyStateHypothesisVersionEntityProjector.class.getName());

}
