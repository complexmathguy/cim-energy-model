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
 * Projector for ExcIEEEAC5A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC5AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC5A-entity-projector")
public class ExcIEEEAC5AEntityProjector {
		
	// core constructor
	public ExcIEEEAC5AEntityProjector(ExcIEEEAC5ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC5A
	 * 
     * @param	entity ExcIEEEAC5A
     */
    public ExcIEEEAC5A create( ExcIEEEAC5A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC5A
	 * 
     * @param	entity ExcIEEEAC5A
     */
    public ExcIEEEAC5A update( ExcIEEEAC5A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC5A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC5A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC5A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC5A via an FindExcIEEEAC5AQuery
     * @return 	query	FindExcIEEEAC5AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC5A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC5A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC5As
     *
     * @param	query	FindAllExcIEEEAC5AQuery 
     * @return 	List<ExcIEEEAC5A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC5A> findAll( FindAllExcIEEEAC5AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC5A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC5ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC5AEntityProjector.class.getName());

}
