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
 * Projector for ConformLoadGroup as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConformLoadGroupAggregate
 * 
 * @author your_name_here
 *
 */
@Component("conformLoadGroup-entity-projector")
public class ConformLoadGroupEntityProjector {
		
	// core constructor
	public ConformLoadGroupEntityProjector(ConformLoadGroupRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ConformLoadGroup
	 * 
     * @param	entity ConformLoadGroup
     */
    public ConformLoadGroup create( ConformLoadGroup entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ConformLoadGroup
	 * 
     * @param	entity ConformLoadGroup
     */
    public ConformLoadGroup update( ConformLoadGroup entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ConformLoadGroup
	 * 
     * @param	id		UUID
     */
    public ConformLoadGroup delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ConformLoadGroup entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ConformLoadGroup via an FindConformLoadGroupQuery
     * @return 	query	FindConformLoadGroupQuery
     */
    @SuppressWarnings("unused")
    public ConformLoadGroup find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ConformLoadGroup - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ConformLoadGroups
     *
     * @param	query	FindAllConformLoadGroupQuery 
     * @return 	List<ConformLoadGroup> 
     */
    @SuppressWarnings("unused")
    public List<ConformLoadGroup> findAll( FindAllConformLoadGroupQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ConformLoadGroup - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConformLoadGroupRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConformLoadGroupEntityProjector.class.getName());

}
