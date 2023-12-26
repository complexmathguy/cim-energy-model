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
 * Projector for GovHydro4 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydro4Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydro4-entity-projector")
public class GovHydro4EntityProjector {
		
	// core constructor
	public GovHydro4EntityProjector(GovHydro4Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydro4
	 * 
     * @param	entity GovHydro4
     */
    public GovHydro4 create( GovHydro4 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydro4
	 * 
     * @param	entity GovHydro4
     */
    public GovHydro4 update( GovHydro4 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydro4
	 * 
     * @param	id		UUID
     */
    public GovHydro4 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydro4 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydro4 via an FindGovHydro4Query
     * @return 	query	FindGovHydro4Query
     */
    @SuppressWarnings("unused")
    public GovHydro4 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydro4 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydro4s
     *
     * @param	query	FindAllGovHydro4Query 
     * @return 	List<GovHydro4> 
     */
    @SuppressWarnings("unused")
    public List<GovHydro4> findAll( FindAllGovHydro4Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydro4 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydro4Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro4EntityProjector.class.getName());

}
