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
 * Projector for GovHydro1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydro1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydro1-entity-projector")
public class GovHydro1EntityProjector {
		
	// core constructor
	public GovHydro1EntityProjector(GovHydro1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydro1
	 * 
     * @param	entity GovHydro1
     */
    public GovHydro1 create( GovHydro1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydro1
	 * 
     * @param	entity GovHydro1
     */
    public GovHydro1 update( GovHydro1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydro1
	 * 
     * @param	id		UUID
     */
    public GovHydro1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydro1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydro1 via an FindGovHydro1Query
     * @return 	query	FindGovHydro1Query
     */
    @SuppressWarnings("unused")
    public GovHydro1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydro1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydro1s
     *
     * @param	query	FindAllGovHydro1Query 
     * @return 	List<GovHydro1> 
     */
    @SuppressWarnings("unused")
    public List<GovHydro1> findAll( FindAllGovHydro1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydro1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydro1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro1EntityProjector.class.getName());

}
