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
 * Projector for WindType3or4UserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindType3or4UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windType3or4UserDefined-entity-projector")
public class WindType3or4UserDefinedEntityProjector {
		
	// core constructor
	public WindType3or4UserDefinedEntityProjector(WindType3or4UserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindType3or4UserDefined
	 * 
     * @param	entity WindType3or4UserDefined
     */
    public WindType3or4UserDefined create( WindType3or4UserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindType3or4UserDefined
	 * 
     * @param	entity WindType3or4UserDefined
     */
    public WindType3or4UserDefined update( WindType3or4UserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindType3or4UserDefined
	 * 
     * @param	id		UUID
     */
    public WindType3or4UserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindType3or4UserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindType3or4UserDefined via an FindWindType3or4UserDefinedQuery
     * @return 	query	FindWindType3or4UserDefinedQuery
     */
    @SuppressWarnings("unused")
    public WindType3or4UserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindType3or4UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindType3or4UserDefineds
     *
     * @param	query	FindAllWindType3or4UserDefinedQuery 
     * @return 	List<WindType3or4UserDefined> 
     */
    @SuppressWarnings("unused")
    public List<WindType3or4UserDefined> findAll( FindAllWindType3or4UserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindType3or4UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindType3or4UserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindType3or4UserDefinedEntityProjector.class.getName());

}
