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
 * Projector for SubGeographicalRegion as outlined for the CQRS pattern.
 * 
 * Commands are handled by SubGeographicalRegionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("subGeographicalRegion-entity-projector")
public class SubGeographicalRegionEntityProjector {
		
	// core constructor
	public SubGeographicalRegionEntityProjector(SubGeographicalRegionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SubGeographicalRegion
	 * 
     * @param	entity SubGeographicalRegion
     */
    public SubGeographicalRegion create( SubGeographicalRegion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SubGeographicalRegion
	 * 
     * @param	entity SubGeographicalRegion
     */
    public SubGeographicalRegion update( SubGeographicalRegion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SubGeographicalRegion
	 * 
     * @param	id		UUID
     */
    public SubGeographicalRegion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SubGeographicalRegion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SubGeographicalRegion via an FindSubGeographicalRegionQuery
     * @return 	query	FindSubGeographicalRegionQuery
     */
    @SuppressWarnings("unused")
    public SubGeographicalRegion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SubGeographicalRegion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SubGeographicalRegions
     *
     * @param	query	FindAllSubGeographicalRegionQuery 
     * @return 	List<SubGeographicalRegion> 
     */
    @SuppressWarnings("unused")
    public List<SubGeographicalRegion> findAll( FindAllSubGeographicalRegionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SubGeographicalRegion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SubGeographicalRegionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SubGeographicalRegionEntityProjector.class.getName());

}
