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
 * Projector for GeographicalRegion as outlined for the CQRS pattern.
 * 
 * Commands are handled by GeographicalRegionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("geographicalRegion-entity-projector")
public class GeographicalRegionEntityProjector {
		
	// core constructor
	public GeographicalRegionEntityProjector(GeographicalRegionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GeographicalRegion
	 * 
     * @param	entity GeographicalRegion
     */
    public GeographicalRegion create( GeographicalRegion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GeographicalRegion
	 * 
     * @param	entity GeographicalRegion
     */
    public GeographicalRegion update( GeographicalRegion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GeographicalRegion
	 * 
     * @param	id		UUID
     */
    public GeographicalRegion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GeographicalRegion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GeographicalRegion via an FindGeographicalRegionQuery
     * @return 	query	FindGeographicalRegionQuery
     */
    @SuppressWarnings("unused")
    public GeographicalRegion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GeographicalRegion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GeographicalRegions
     *
     * @param	query	FindAllGeographicalRegionQuery 
     * @return 	List<GeographicalRegion> 
     */
    @SuppressWarnings("unused")
    public List<GeographicalRegion> findAll( FindAllGeographicalRegionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GeographicalRegion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GeographicalRegionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GeographicalRegionEntityProjector.class.getName());

}
