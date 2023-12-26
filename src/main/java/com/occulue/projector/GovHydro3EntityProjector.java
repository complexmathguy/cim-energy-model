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
 * Projector for GovHydro3 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydro3Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydro3-entity-projector")
public class GovHydro3EntityProjector {
		
	// core constructor
	public GovHydro3EntityProjector(GovHydro3Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydro3
	 * 
     * @param	entity GovHydro3
     */
    public GovHydro3 create( GovHydro3 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydro3
	 * 
     * @param	entity GovHydro3
     */
    public GovHydro3 update( GovHydro3 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydro3
	 * 
     * @param	id		UUID
     */
    public GovHydro3 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydro3 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydro3 via an FindGovHydro3Query
     * @return 	query	FindGovHydro3Query
     */
    @SuppressWarnings("unused")
    public GovHydro3 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydro3 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydro3s
     *
     * @param	query	FindAllGovHydro3Query 
     * @return 	List<GovHydro3> 
     */
    @SuppressWarnings("unused")
    public List<GovHydro3> findAll( FindAllGovHydro3Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydro3 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydro3Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro3EntityProjector.class.getName());

}
