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
 * Projector for WindPlantUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindPlantUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windPlantUserDefined-entity-projector")
public class WindPlantUserDefinedEntityProjector {
		
	// core constructor
	public WindPlantUserDefinedEntityProjector(WindPlantUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindPlantUserDefined
	 * 
     * @param	entity WindPlantUserDefined
     */
    public WindPlantUserDefined create( WindPlantUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindPlantUserDefined
	 * 
     * @param	entity WindPlantUserDefined
     */
    public WindPlantUserDefined update( WindPlantUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindPlantUserDefined
	 * 
     * @param	id		UUID
     */
    public WindPlantUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindPlantUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindPlantUserDefined via an FindWindPlantUserDefinedQuery
     * @return 	query	FindWindPlantUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public WindPlantUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindPlantUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindPlantUserDefineds
     *
     * @param	query	FindAllWindPlantUserDefinedQuery 
     * @return 	List<WindPlantUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<WindPlantUserDefined> findAll( FindAllWindPlantUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindPlantUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindPlantUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantUserDefinedEntityProjector.class.getName());

}
