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
 * Projector for ExcIEEEAC6A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC6AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC6A-entity-projector")
public class ExcIEEEAC6AEntityProjector {
		
	// core constructor
	public ExcIEEEAC6AEntityProjector(ExcIEEEAC6ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC6A
	 * 
     * @param	entity ExcIEEEAC6A
     */
    public ExcIEEEAC6A create( ExcIEEEAC6A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC6A
	 * 
     * @param	entity ExcIEEEAC6A
     */
    public ExcIEEEAC6A update( ExcIEEEAC6A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC6A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC6A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC6A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC6A via an FindExcIEEEAC6AQuery
     * @return 	query	FindExcIEEEAC6AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC6A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC6A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC6As
     *
     * @param	query	FindAllExcIEEEAC6AQuery 
     * @return 	List<ExcIEEEAC6A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC6A> findAll( FindAllExcIEEEAC6AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC6A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC6ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC6AEntityProjector.class.getName());

}
