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
 * Projector for GovSteamIEEE1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteamIEEE1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteamIEEE1-entity-projector")
public class GovSteamIEEE1EntityProjector {
		
	// core constructor
	public GovSteamIEEE1EntityProjector(GovSteamIEEE1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteamIEEE1
	 * 
     * @param	entity GovSteamIEEE1
     */
    public GovSteamIEEE1 create( GovSteamIEEE1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteamIEEE1
	 * 
     * @param	entity GovSteamIEEE1
     */
    public GovSteamIEEE1 update( GovSteamIEEE1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteamIEEE1
	 * 
     * @param	id		UUID
     */
    public GovSteamIEEE1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteamIEEE1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteamIEEE1 via an FindGovSteamIEEE1Query
     * @return 	query	FindGovSteamIEEE1Query
     */
    @SuppressWarnings("unused")
    public GovSteamIEEE1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteamIEEE1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteamIEEE1s
     *
     * @param	query	FindAllGovSteamIEEE1Query 
     * @return 	List<GovSteamIEEE1> 
     */
    @SuppressWarnings("unused")
    public List<GovSteamIEEE1> findAll( FindAllGovSteamIEEE1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteamIEEE1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteamIEEE1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteamIEEE1EntityProjector.class.getName());

}
