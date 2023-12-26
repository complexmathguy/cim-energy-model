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
 * Projector for GovSteamFV3 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteamFV3Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteamFV3-entity-projector")
public class GovSteamFV3EntityProjector {
		
	// core constructor
	public GovSteamFV3EntityProjector(GovSteamFV3Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteamFV3
	 * 
     * @param	entity GovSteamFV3
     */
    public GovSteamFV3 create( GovSteamFV3 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteamFV3
	 * 
     * @param	entity GovSteamFV3
     */
    public GovSteamFV3 update( GovSteamFV3 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteamFV3
	 * 
     * @param	id		UUID
     */
    public GovSteamFV3 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteamFV3 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteamFV3 via an FindGovSteamFV3Query
     * @return 	query	FindGovSteamFV3Query
     */
    @SuppressWarnings("unused")
    public GovSteamFV3 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteamFV3 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV3s
     *
     * @param	query	FindAllGovSteamFV3Query 
     * @return 	List<GovSteamFV3> 
     */
    @SuppressWarnings("unused")
    public List<GovSteamFV3> findAll( FindAllGovSteamFV3Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteamFV3 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteamFV3Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV3EntityProjector.class.getName());

}
