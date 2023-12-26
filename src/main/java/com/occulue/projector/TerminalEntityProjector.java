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
 * Projector for Terminal as outlined for the CQRS pattern.
 * 
 * Commands are handled by TerminalAggregate
 * 
 * @author your_name_here
 *
 */
@Component("terminal-entity-projector")
public class TerminalEntityProjector {
		
	// core constructor
	public TerminalEntityProjector(TerminalRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Terminal
	 * 
     * @param	entity Terminal
     */
    public Terminal create( Terminal entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Terminal
	 * 
     * @param	entity Terminal
     */
    public Terminal update( Terminal entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Terminal
	 * 
     * @param	id		UUID
     */
    public Terminal delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Terminal entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Terminal via an FindTerminalQuery
     * @return 	query	FindTerminalQuery
     */
    @SuppressWarnings("unused")
    public Terminal find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Terminal - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Terminals
     *
     * @param	query	FindAllTerminalQuery 
     * @return 	List<Terminal> 
     */
    @SuppressWarnings("unused")
    public List<Terminal> findAll( FindAllTerminalQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Terminal - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TerminalRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TerminalEntityProjector.class.getName());

}
