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
 * Projector for GovHydroPID2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroPID2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroPID2-entity-projector")
public class GovHydroPID2EntityProjector {
		
	// core constructor
	public GovHydroPID2EntityProjector(GovHydroPID2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroPID2
	 * 
     * @param	entity GovHydroPID2
     */
    public GovHydroPID2 create( GovHydroPID2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroPID2
	 * 
     * @param	entity GovHydroPID2
     */
    public GovHydroPID2 update( GovHydroPID2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroPID2
	 * 
     * @param	id		UUID
     */
    public GovHydroPID2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroPID2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroPID2 via an FindGovHydroPID2Query
     * @return 	query	FindGovHydroPID2Query
     */
    @SuppressWarnings("unused")
    public GovHydroPID2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroPID2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPID2s
     *
     * @param	query	FindAllGovHydroPID2Query 
     * @return 	List<GovHydroPID2> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroPID2> findAll( FindAllGovHydroPID2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroPID2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroPID2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPID2EntityProjector.class.getName());

}
