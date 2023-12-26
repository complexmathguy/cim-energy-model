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
 * Projector for GovSteamFV2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteamFV2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteamFV2-entity-projector")
public class GovSteamFV2EntityProjector {
		
	// core constructor
	public GovSteamFV2EntityProjector(GovSteamFV2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteamFV2
	 * 
     * @param	entity GovSteamFV2
     */
    public GovSteamFV2 create( GovSteamFV2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteamFV2
	 * 
     * @param	entity GovSteamFV2
     */
    public GovSteamFV2 update( GovSteamFV2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteamFV2
	 * 
     * @param	id		UUID
     */
    public GovSteamFV2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteamFV2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteamFV2 via an FindGovSteamFV2Query
     * @return 	query	FindGovSteamFV2Query
     */
    @SuppressWarnings("unused")
    public GovSteamFV2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteamFV2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV2s
     *
     * @param	query	FindAllGovSteamFV2Query 
     * @return 	List<GovSteamFV2> 
     */
    @SuppressWarnings("unused")
    public List<GovSteamFV2> findAll( FindAllGovSteamFV2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteamFV2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteamFV2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV2EntityProjector.class.getName());

}
