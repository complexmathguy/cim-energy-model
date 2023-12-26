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
 * Projector for GovHydroPelton as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovHydroPeltonAggregate
 * 
 * @author your_name_here
 *
 */
@Component("govHydroPelton-entity-projector")
public class GovHydroPeltonEntityProjector {
		
	// core constructor
	public GovHydroPeltonEntityProjector(GovHydroPeltonRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovHydroPelton
	 * 
     * @param	entity GovHydroPelton
     */
    public GovHydroPelton create( GovHydroPelton entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovHydroPelton
	 * 
     * @param	entity GovHydroPelton
     */
    public GovHydroPelton update( GovHydroPelton entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovHydroPelton
	 * 
     * @param	id		UUID
     */
    public GovHydroPelton delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovHydroPelton entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovHydroPelton via an FindGovHydroPeltonQuery
     * @return 	query	FindGovHydroPeltonQuery
     */
    @SuppressWarnings("unused")
    public GovHydroPelton find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovHydroPelton - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPeltons
     *
     * @param	query	FindAllGovHydroPeltonQuery 
     * @return 	List<GovHydroPelton> 
     */
    @SuppressWarnings("unused")
    public List<GovHydroPelton> findAll( FindAllGovHydroPeltonQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovHydroPelton - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovHydroPeltonRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPeltonEntityProjector.class.getName());

}
