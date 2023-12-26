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
 * Projector for GovSteam1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovSteam1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govSteam1-entity-projector")
public class GovSteam1EntityProjector {
		
	// core constructor
	public GovSteam1EntityProjector(GovSteam1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovSteam1
	 * 
     * @param	entity GovSteam1
     */
    public GovSteam1 create( GovSteam1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovSteam1
	 * 
     * @param	entity GovSteam1
     */
    public GovSteam1 update( GovSteam1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovSteam1
	 * 
     * @param	id		UUID
     */
    public GovSteam1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovSteam1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovSteam1 via an FindGovSteam1Query
     * @return 	query	FindGovSteam1Query
     */
    @SuppressWarnings("unused")
    public GovSteam1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovSteam1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovSteam1s
     *
     * @param	query	FindAllGovSteam1Query 
     * @return 	List<GovSteam1> 
     */
    @SuppressWarnings("unused")
    public List<GovSteam1> findAll( FindAllGovSteam1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovSteam1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovSteam1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovSteam1EntityProjector.class.getName());

}
