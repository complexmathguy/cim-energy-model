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
 * Projector for GovSteam2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteam2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteam2-entity-projector")
public class GovSteam2EntityProjector {
		
	// core constructor
	public GovSteam2EntityProjector(GovSteam2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteam2
	 * 
     * @param	entity GovSteam2
     */
    public GovSteam2 create( GovSteam2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteam2
	 * 
     * @param	entity GovSteam2
     */
    public GovSteam2 update( GovSteam2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteam2
	 * 
     * @param	id		UUID
     */
    public GovSteam2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteam2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteam2 via an FindGovSteam2Query
     * @return 	query	FindGovSteam2Query
     */
    @SuppressWarnings("unused")
    public GovSteam2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteam2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteam2s
     *
     * @param	query	FindAllGovSteam2Query 
     * @return 	List<GovSteam2> 
     */
    @SuppressWarnings("unused")
    public List<GovSteam2> findAll( FindAllGovSteam2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteam2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteam2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam2EntityProjector.class.getName());

}
