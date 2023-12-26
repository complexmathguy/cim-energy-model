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
 * Projector for GovHydroWEH as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroWEHAggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroWEH-entity-projector")
public class GovHydroWEHEntityProjector {
		
	// core constructor
	public GovHydroWEHEntityProjector(GovHydroWEHRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroWEH
	 * 
     * @param	entity GovHydroWEH
     */
    public GovHydroWEH create( GovHydroWEH entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroWEH
	 * 
     * @param	entity GovHydroWEH
     */
    public GovHydroWEH update( GovHydroWEH entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroWEH
	 * 
     * @param	id		UUID
     */
    public GovHydroWEH delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroWEH entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroWEH via an FindGovHydroWEHQuery
     * @return 	query	FindGovHydroWEHQuery
     */
    @SuppressWarnings("unused")
    public GovHydroWEH find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroWEH - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroWEHs
     *
     * @param	query	FindAllGovHydroWEHQuery 
     * @return 	List<GovHydroWEH> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroWEH> findAll( FindAllGovHydroWEHQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroWEH - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroWEHRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroWEHEntityProjector.class.getName());

}
