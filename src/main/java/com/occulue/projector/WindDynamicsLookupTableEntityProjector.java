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
 * Projector for WindDynamicsLookupTable as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindDynamicsLookupTableAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windDynamicsLookupTable-entity-projector")
public class WindDynamicsLookupTableEntityProjector {
		
	// core constructor
	public WindDynamicsLookupTableEntityProjector(WindDynamicsLookupTableRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindDynamicsLookupTable
	 * 
     * @param	entity WindDynamicsLookupTable
     */
    public WindDynamicsLookupTable create( WindDynamicsLookupTable entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindDynamicsLookupTable
	 * 
     * @param	entity WindDynamicsLookupTable
     */
    public WindDynamicsLookupTable update( WindDynamicsLookupTable entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindDynamicsLookupTable
	 * 
     * @param	id		UUID
     */
    public WindDynamicsLookupTable delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindDynamicsLookupTable entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindDynamicsLookupTable via an FindWindDynamicsLookupTableQuery
     * @return 	query	FindWindDynamicsLookupTableQuery
     */
    @SuppressWarnings("unused")
    public WindDynamicsLookupTable find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindDynamicsLookupTable - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindDynamicsLookupTables
     *
     * @param	query	FindAllWindDynamicsLookupTableQuery 
     * @return 	List<WindDynamicsLookupTable> 
     */
    @SuppressWarnings("unused")
    public List<WindDynamicsLookupTable> findAll( FindAllWindDynamicsLookupTableQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindDynamicsLookupTable - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindDynamicsLookupTableRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindDynamicsLookupTableEntityProjector.class.getName());

}
