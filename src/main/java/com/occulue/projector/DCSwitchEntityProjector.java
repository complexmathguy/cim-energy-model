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
 * Projector for DCSwitch as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCSwitchAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCSwitch-entity-projector")
public class DCSwitchEntityProjector {
		
	// core constructor
	public DCSwitchEntityProjector(DCSwitchRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCSwitch
	 * 
     * @param	entity DCSwitch
     */
    public DCSwitch create( DCSwitch entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCSwitch
	 * 
     * @param	entity DCSwitch
     */
    public DCSwitch update( DCSwitch entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCSwitch
	 * 
     * @param	id		UUID
     */
    public DCSwitch delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCSwitch entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCSwitch via an FindDCSwitchQuery
     * @return 	query	FindDCSwitchQuery
     */
    @SuppressWarnings("unused")
    public DCSwitch find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCSwitch - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCSwitchs
     *
     * @param	query	FindAllDCSwitchQuery 
     * @return 	List<DCSwitch> 
     */
    @SuppressWarnings("unused")
    public List<DCSwitch> findAll( FindAllDCSwitchQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCSwitch - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCSwitchRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCSwitchEntityProjector.class.getName());

}
