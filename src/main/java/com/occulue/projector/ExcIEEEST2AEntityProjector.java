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
 * Projector for ExcIEEEST2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEST2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST2A-entity-projector")
public class ExcIEEEST2AEntityProjector {
		
	// core constructor
	public ExcIEEEST2AEntityProjector(ExcIEEEST2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEST2A
	 * 
     * @param	entity ExcIEEEST2A
     */
    public ExcIEEEST2A create( ExcIEEEST2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEST2A
	 * 
     * @param	entity ExcIEEEST2A
     */
    public ExcIEEEST2A update( ExcIEEEST2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEST2A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEST2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEST2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEST2A via an FindExcIEEEST2AQuery
     * @return 	query	FindExcIEEEST2AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEST2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEST2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST2As
     *
     * @param	query	FindAllExcIEEEST2AQuery 
     * @return 	List<ExcIEEEST2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEST2A> findAll( FindAllExcIEEEST2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEST2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEST2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST2AEntityProjector.class.getName());

}
