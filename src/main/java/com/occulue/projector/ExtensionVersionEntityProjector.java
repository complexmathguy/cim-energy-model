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
 * Projector for ExtensionVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExtensionVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("extensionVersion-entity-projector")
public class ExtensionVersionEntityProjector {
		
	// core constructor
	public ExtensionVersionEntityProjector(ExtensionVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExtensionVersion
	 * 
     * @param	entity ExtensionVersion
     */
    public ExtensionVersion create( ExtensionVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExtensionVersion
	 * 
     * @param	entity ExtensionVersion
     */
    public ExtensionVersion update( ExtensionVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExtensionVersion
	 * 
     * @param	id		UUID
     */
    public ExtensionVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExtensionVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExtensionVersion via an FindExtensionVersionQuery
     * @return 	query	FindExtensionVersionQuery
     */
    @SuppressWarnings("unused")
    public ExtensionVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExtensionVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExtensionVersions
     *
     * @param	query	FindAllExtensionVersionQuery 
     * @return 	List<ExtensionVersion> 
     */
    @SuppressWarnings("unused")
    public List<ExtensionVersion> findAll( FindAllExtensionVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExtensionVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExtensionVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExtensionVersionEntityProjector.class.getName());

}
