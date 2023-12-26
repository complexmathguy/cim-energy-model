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
 * Projector for GovHydroPID as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroPIDAggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroPID-entity-projector")
public class GovHydroPIDEntityProjector {
		
	// core constructor
	public GovHydroPIDEntityProjector(GovHydroPIDRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroPID
	 * 
     * @param	entity GovHydroPID
     */
    public GovHydroPID create( GovHydroPID entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroPID
	 * 
     * @param	entity GovHydroPID
     */
    public GovHydroPID update( GovHydroPID entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroPID
	 * 
     * @param	id		UUID
     */
    public GovHydroPID delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroPID entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroPID via an FindGovHydroPIDQuery
     * @return 	query	FindGovHydroPIDQuery
     */
    @SuppressWarnings("unused")
    public GovHydroPID find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroPID - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPIDs
     *
     * @param	query	FindAllGovHydroPIDQuery 
     * @return 	List<GovHydroPID> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroPID> findAll( FindAllGovHydroPIDQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroPID - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroPIDRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPIDEntityProjector.class.getName());

}
