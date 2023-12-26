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
 * Projector for ACDCTerminal as outlined for the CQRS pattern.
 * 
 * Commands are handled by ACDCTerminalAggregate
 * 
 * @author your_name_here
 *
 */
@Component("aCDCTerminal-entity-projector")
public class ACDCTerminalEntityProjector {
		
	// core constructor
	public ACDCTerminalEntityProjector(ACDCTerminalRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ACDCTerminal
	 * 
     * @param	entity ACDCTerminal
     */
    public ACDCTerminal create( ACDCTerminal entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ACDCTerminal
	 * 
     * @param	entity ACDCTerminal
     */
    public ACDCTerminal update( ACDCTerminal entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ACDCTerminal
	 * 
     * @param	id		UUID
     */
    public ACDCTerminal delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ACDCTerminal entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ACDCTerminal via an FindACDCTerminalQuery
     * @return 	query	FindACDCTerminalQuery
     */
    @SuppressWarnings("unused")
    public ACDCTerminal find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ACDCTerminal - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ACDCTerminals
     *
     * @param	query	FindAllACDCTerminalQuery 
     * @return 	List<ACDCTerminal> 
     */
    @SuppressWarnings("unused")
    public List<ACDCTerminal> findAll( FindAllACDCTerminalQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ACDCTerminal - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ACDCTerminalRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ACDCTerminalEntityProjector.class.getName());

}
