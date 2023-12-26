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
 * Projector for GovHydroIEEE2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroIEEE2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroIEEE2-entity-projector")
public class GovHydroIEEE2EntityProjector {
		
	// core constructor
	public GovHydroIEEE2EntityProjector(GovHydroIEEE2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroIEEE2
	 * 
     * @param	entity GovHydroIEEE2
     */
    public GovHydroIEEE2 create( GovHydroIEEE2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroIEEE2
	 * 
     * @param	entity GovHydroIEEE2
     */
    public GovHydroIEEE2 update( GovHydroIEEE2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroIEEE2
	 * 
     * @param	id		UUID
     */
    public GovHydroIEEE2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroIEEE2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroIEEE2 via an FindGovHydroIEEE2Query
     * @return 	query	FindGovHydroIEEE2Query
     */
    @SuppressWarnings("unused")
    public GovHydroIEEE2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroIEEE2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroIEEE2s
     *
     * @param	query	FindAllGovHydroIEEE2Query 
     * @return 	List<GovHydroIEEE2> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroIEEE2> findAll( FindAllGovHydroIEEE2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroIEEE2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroIEEE2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE2EntityProjector.class.getName());

}
