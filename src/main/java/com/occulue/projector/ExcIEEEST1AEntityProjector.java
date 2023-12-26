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
 * Projector for ExcIEEEST1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEST1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST1A-entity-projector")
public class ExcIEEEST1AEntityProjector {
		
	// core constructor
	public ExcIEEEST1AEntityProjector(ExcIEEEST1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEST1A
	 * 
     * @param	entity ExcIEEEST1A
     */
    public ExcIEEEST1A create( ExcIEEEST1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEST1A
	 * 
     * @param	entity ExcIEEEST1A
     */
    public ExcIEEEST1A update( ExcIEEEST1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEST1A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEST1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEST1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEST1A via an FindExcIEEEST1AQuery
     * @return 	query	FindExcIEEEST1AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEST1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEST1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST1As
     *
     * @param	query	FindAllExcIEEEST1AQuery 
     * @return 	List<ExcIEEEST1A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEST1A> findAll( FindAllExcIEEEST1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEST1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEST1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST1AEntityProjector.class.getName());

}
