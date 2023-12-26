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
 * Projector for ExcIEEEST6B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEST6BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST6B-entity-projector")
public class ExcIEEEST6BEntityProjector {
		
	// core constructor
	public ExcIEEEST6BEntityProjector(ExcIEEEST6BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEST6B
	 * 
     * @param	entity ExcIEEEST6B
     */
    public ExcIEEEST6B create( ExcIEEEST6B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEST6B
	 * 
     * @param	entity ExcIEEEST6B
     */
    public ExcIEEEST6B update( ExcIEEEST6B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEST6B
	 * 
     * @param	id		UUID
     */
    public ExcIEEEST6B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEST6B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEST6B via an FindExcIEEEST6BQuery
     * @return 	query	FindExcIEEEST6BQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEST6B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEST6B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST6Bs
     *
     * @param	query	FindAllExcIEEEST6BQuery 
     * @return 	List<ExcIEEEST6B> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEST6B> findAll( FindAllExcIEEEST6BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEST6B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEST6BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST6BEntityProjector.class.getName());

}
