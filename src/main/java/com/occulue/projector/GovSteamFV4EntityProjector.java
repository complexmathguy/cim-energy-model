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
 * Projector for GovSteamFV4 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteamFV4Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteamFV4-entity-projector")
public class GovSteamFV4EntityProjector {
		
	// core constructor
	public GovSteamFV4EntityProjector(GovSteamFV4Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteamFV4
	 * 
     * @param	entity GovSteamFV4
     */
    public GovSteamFV4 create( GovSteamFV4 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteamFV4
	 * 
     * @param	entity GovSteamFV4
     */
    public GovSteamFV4 update( GovSteamFV4 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteamFV4
	 * 
     * @param	id		UUID
     */
    public GovSteamFV4 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteamFV4 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteamFV4 via an FindGovSteamFV4Query
     * @return 	query	FindGovSteamFV4Query
     */
    @SuppressWarnings("unused")
    public GovSteamFV4 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteamFV4 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV4s
     *
     * @param	query	FindAllGovSteamFV4Query 
     * @return 	List<GovSteamFV4> 
     */
    @SuppressWarnings("unused")
    public List<GovSteamFV4> findAll( FindAllGovSteamFV4Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteamFV4 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteamFV4Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV4EntityProjector.class.getName());

}
