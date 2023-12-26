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
 * Projector for GovHydroIEEE0 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroIEEE0Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroIEEE0-entity-projector")
public class GovHydroIEEE0EntityProjector {
		
	// core constructor
	public GovHydroIEEE0EntityProjector(GovHydroIEEE0Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroIEEE0
	 * 
     * @param	entity GovHydroIEEE0
     */
    public GovHydroIEEE0 create( GovHydroIEEE0 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroIEEE0
	 * 
     * @param	entity GovHydroIEEE0
     */
    public GovHydroIEEE0 update( GovHydroIEEE0 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroIEEE0
	 * 
     * @param	id		UUID
     */
    public GovHydroIEEE0 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroIEEE0 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroIEEE0 via an FindGovHydroIEEE0Query
     * @return 	query	FindGovHydroIEEE0Query
     */
    @SuppressWarnings("unused")
    public GovHydroIEEE0 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroIEEE0 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroIEEE0s
     *
     * @param	query	FindAllGovHydroIEEE0Query 
     * @return 	List<GovHydroIEEE0> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroIEEE0> findAll( FindAllGovHydroIEEE0Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroIEEE0 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroIEEE0Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE0EntityProjector.class.getName());

}
