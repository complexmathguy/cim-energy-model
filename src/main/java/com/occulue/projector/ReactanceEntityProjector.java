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
 * Projector for Reactance as outlined for the CQRS pattern.
 * 
 * Commands are handled by ReactanceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("reactance-entity-projector")
public class ReactanceEntityProjector {
		
	// core constructor
	public ReactanceEntityProjector(ReactanceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Reactance
	 * 
     * @param	entity Reactance
     */
    public Reactance create( Reactance entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Reactance
	 * 
     * @param	entity Reactance
     */
    public Reactance update( Reactance entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Reactance
	 * 
     * @param	id		UUID
     */
    public Reactance delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Reactance entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Reactance via an FindReactanceQuery
     * @return 	query	FindReactanceQuery
     */
    @SuppressWarnings("unused")
    public Reactance find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Reactance - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Reactances
     *
     * @param	query	FindAllReactanceQuery 
     * @return 	List<Reactance> 
     */
    @SuppressWarnings("unused")
    public List<Reactance> findAll( FindAllReactanceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Reactance - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ReactanceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ReactanceEntityProjector.class.getName());

}
