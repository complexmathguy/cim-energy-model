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
 * Projector for GovHydroR as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroRAggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroR-entity-projector")
public class GovHydroREntityProjector {
		
	// core constructor
	public GovHydroREntityProjector(GovHydroRRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroR
	 * 
     * @param	entity GovHydroR
     */
    public GovHydroR create( GovHydroR entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroR
	 * 
     * @param	entity GovHydroR
     */
    public GovHydroR update( GovHydroR entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroR
	 * 
     * @param	id		UUID
     */
    public GovHydroR delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroR entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroR via an FindGovHydroRQuery
     * @return 	query	FindGovHydroRQuery
     */
    @SuppressWarnings("unused")
    public GovHydroR find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroR - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroRs
     *
     * @param	query	FindAllGovHydroRQuery 
     * @return 	List<GovHydroR> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroR> findAll( FindAllGovHydroRQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroR - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroRRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroREntityProjector.class.getName());

}
