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
 * Projector for GovCT2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovCT2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govCT2-entity-projector")
public class GovCT2EntityProjector {
		
	// core constructor
	public GovCT2EntityProjector(GovCT2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovCT2
	 * 
     * @param	entity GovCT2
     */
    public GovCT2 create( GovCT2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovCT2
	 * 
     * @param	entity GovCT2
     */
    public GovCT2 update( GovCT2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovCT2
	 * 
     * @param	id		UUID
     */
    public GovCT2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovCT2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovCT2 via an FindGovCT2Query
     * @return 	query	FindGovCT2Query
     */
    @SuppressWarnings("unused")
    public GovCT2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovCT2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovCT2s
     *
     * @param	query	FindAllGovCT2Query 
     * @return 	List<GovCT2> 
     */
    @SuppressWarnings("unused")
    public List<GovCT2> findAll( FindAllGovCT2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovCT2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovCT2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovCT2EntityProjector.class.getName());

}
