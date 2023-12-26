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
 * Projector for GovSteam0 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteam0Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteam0-entity-projector")
public class GovSteam0EntityProjector {
		
	// core constructor
	public GovSteam0EntityProjector(GovSteam0Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteam0
	 * 
     * @param	entity GovSteam0
     */
    public GovSteam0 create( GovSteam0 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteam0
	 * 
     * @param	entity GovSteam0
     */
    public GovSteam0 update( GovSteam0 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteam0
	 * 
     * @param	id		UUID
     */
    public GovSteam0 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteam0 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteam0 via an FindGovSteam0Query
     * @return 	query	FindGovSteam0Query
     */
    @SuppressWarnings("unused")
    public GovSteam0 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteam0 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteam0s
     *
     * @param	query	FindAllGovSteam0Query 
     * @return 	List<GovSteam0> 
     */
    @SuppressWarnings("unused")
    public List<GovSteam0> findAll( FindAllGovSteam0Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteam0 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteam0Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam0EntityProjector.class.getName());

}
