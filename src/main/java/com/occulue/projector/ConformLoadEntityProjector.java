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
 * Projector for ConformLoad as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConformLoadAggregate
 * 
 * @author your_name_here
 *
 */
@Component("conformLoad-entity-projector")
public class ConformLoadEntityProjector {
		
	// core constructor
	public ConformLoadEntityProjector(ConformLoadRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ConformLoad
	 * 
     * @param	entity ConformLoad
     */
    public ConformLoad create( ConformLoad entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ConformLoad
	 * 
     * @param	entity ConformLoad
     */
    public ConformLoad update( ConformLoad entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ConformLoad
	 * 
     * @param	id		UUID
     */
    public ConformLoad delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ConformLoad entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ConformLoad via an FindConformLoadQuery
     * @return 	query	FindConformLoadQuery
     */
    @SuppressWarnings("unused")
    public ConformLoad find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ConformLoad - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ConformLoads
     *
     * @param	query	FindAllConformLoadQuery 
     * @return 	List<ConformLoad> 
     */
    @SuppressWarnings("unused")
    public List<ConformLoad> findAll( FindAllConformLoadQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ConformLoad - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConformLoadRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadEntityProjector.class.getName());

}
