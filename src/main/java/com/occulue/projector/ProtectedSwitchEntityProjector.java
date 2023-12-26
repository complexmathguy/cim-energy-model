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
 * Projector for ProtectedSwitch as outlined for the CQRS pattern.
 * 
 * Commands are handled by ProtectedSwitchAggregate
 * 
 * @author your_name_here
 *
 */
@Component("protectedSwitch-entity-projector")
public class ProtectedSwitchEntityProjector {
		
	// core constructor
	public ProtectedSwitchEntityProjector(ProtectedSwitchRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ProtectedSwitch
	 * 
     * @param	entity ProtectedSwitch
     */
    public ProtectedSwitch create( ProtectedSwitch entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ProtectedSwitch
	 * 
     * @param	entity ProtectedSwitch
     */
    public ProtectedSwitch update( ProtectedSwitch entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ProtectedSwitch
	 * 
     * @param	id		UUID
     */
    public ProtectedSwitch delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ProtectedSwitch entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ProtectedSwitch via an FindProtectedSwitchQuery
     * @return 	query	FindProtectedSwitchQuery
     */
    @SuppressWarnings("unused")
    public ProtectedSwitch find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ProtectedSwitch - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ProtectedSwitchs
     *
     * @param	query	FindAllProtectedSwitchQuery 
     * @return 	List<ProtectedSwitch> 
     */
    @SuppressWarnings("unused")
    public List<ProtectedSwitch> findAll( FindAllProtectedSwitchQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ProtectedSwitch - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ProtectedSwitchRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ProtectedSwitchEntityProjector.class.getName());

}
