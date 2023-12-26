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
 * Projector for GovHydro2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydro2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydro2-entity-projector")
public class GovHydro2EntityProjector {
		
	// core constructor
	public GovHydro2EntityProjector(GovHydro2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydro2
	 * 
     * @param	entity GovHydro2
     */
    public GovHydro2 create( GovHydro2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydro2
	 * 
     * @param	entity GovHydro2
     */
    public GovHydro2 update( GovHydro2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydro2
	 * 
     * @param	id		UUID
     */
    public GovHydro2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydro2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydro2 via an FindGovHydro2Query
     * @return 	query	FindGovHydro2Query
     */
    @SuppressWarnings("unused")
    public GovHydro2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydro2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydro2s
     *
     * @param	query	FindAllGovHydro2Query 
     * @return 	List<GovHydro2> 
     */
    @SuppressWarnings("unused")
    public List<GovHydro2> findAll( FindAllGovHydro2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydro2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydro2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydro2EntityProjector.class.getName());

}
