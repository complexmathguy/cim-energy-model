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
 * Projector for GeographicalLocationVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by GeographicalLocationVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("geographicalLocationVersion-entity-projector")
public class GeographicalLocationVersionEntityProjector {
		
	// core constructor
	public GeographicalLocationVersionEntityProjector(GeographicalLocationVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GeographicalLocationVersion
	 * 
     * @param	entity GeographicalLocationVersion
     */
    public GeographicalLocationVersion create( GeographicalLocationVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GeographicalLocationVersion
	 * 
     * @param	entity GeographicalLocationVersion
     */
    public GeographicalLocationVersion update( GeographicalLocationVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GeographicalLocationVersion
	 * 
     * @param	id		UUID
     */
    public GeographicalLocationVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GeographicalLocationVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GeographicalLocationVersion via an FindGeographicalLocationVersionQuery
     * @return 	query	FindGeographicalLocationVersionQuery
     */
    @SuppressWarnings("unused")
    public GeographicalLocationVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GeographicalLocationVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GeographicalLocationVersions
     *
     * @param	query	FindAllGeographicalLocationVersionQuery 
     * @return 	List<GeographicalLocationVersion> 
     */
    @SuppressWarnings("unused")
    public List<GeographicalLocationVersion> findAll( FindAllGeographicalLocationVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GeographicalLocationVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GeographicalLocationVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GeographicalLocationVersionEntityProjector.class.getName());

}
