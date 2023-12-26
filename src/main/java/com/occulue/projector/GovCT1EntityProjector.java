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
 * Projector for GovCT1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovCT1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govCT1-entity-projector")
public class GovCT1EntityProjector {
		
	// core constructor
	public GovCT1EntityProjector(GovCT1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovCT1
	 * 
     * @param	entity GovCT1
     */
    public GovCT1 create( GovCT1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovCT1
	 * 
     * @param	entity GovCT1
     */
    public GovCT1 update( GovCT1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovCT1
	 * 
     * @param	id		UUID
     */
    public GovCT1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovCT1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovCT1 via an FindGovCT1Query
     * @return 	query	FindGovCT1Query
     */
    @SuppressWarnings("unused")
    public GovCT1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovCT1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovCT1s
     *
     * @param	query	FindAllGovCT1Query 
     * @return 	List<GovCT1> 
     */
    @SuppressWarnings("unused")
    public List<GovCT1> findAll( FindAllGovCT1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovCT1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovCT1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovCT1EntityProjector.class.getName());

}
