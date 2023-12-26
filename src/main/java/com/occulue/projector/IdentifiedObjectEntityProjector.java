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
 * Projector for IdentifiedObject as outlined for the CQRS pattern.
 * 
 * Commands are handled by IdentifiedObjectAggregate
 * 
 * @author your_name_here
 *
 */
@Component("identifiedObject-entity-projector")
public class IdentifiedObjectEntityProjector {
		
	// core constructor
	public IdentifiedObjectEntityProjector(IdentifiedObjectRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a IdentifiedObject
	 * 
     * @param	entity IdentifiedObject
     */
    public IdentifiedObject create( IdentifiedObject entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a IdentifiedObject
	 * 
     * @param	entity IdentifiedObject
     */
    public IdentifiedObject update( IdentifiedObject entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a IdentifiedObject
	 * 
     * @param	id		UUID
     */
    public IdentifiedObject delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    IdentifiedObject entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the IdentifiedObject via an FindIdentifiedObjectQuery
     * @return 	query	FindIdentifiedObjectQuery
     */
    @SuppressWarnings("unused")
    public IdentifiedObject find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a IdentifiedObject - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all IdentifiedObjects
     *
     * @param	query	FindAllIdentifiedObjectQuery 
     * @return 	List<IdentifiedObject> 
     */
    @SuppressWarnings("unused")
    public List<IdentifiedObject> findAll( FindAllIdentifiedObjectQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all IdentifiedObject - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final IdentifiedObjectRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(IdentifiedObjectEntityProjector.class.getName());

}
