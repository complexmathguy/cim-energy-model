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
 * Projector for ExcIEEEST5B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEST5BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST5B-entity-projector")
public class ExcIEEEST5BEntityProjector {
		
	// core constructor
	public ExcIEEEST5BEntityProjector(ExcIEEEST5BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEST5B
	 * 
     * @param	entity ExcIEEEST5B
     */
    public ExcIEEEST5B create( ExcIEEEST5B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEST5B
	 * 
     * @param	entity ExcIEEEST5B
     */
    public ExcIEEEST5B update( ExcIEEEST5B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEST5B
	 * 
     * @param	id		UUID
     */
    public ExcIEEEST5B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEST5B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEST5B via an FindExcIEEEST5BQuery
     * @return 	query	FindExcIEEEST5BQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEST5B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEST5B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST5Bs
     *
     * @param	query	FindAllExcIEEEST5BQuery 
     * @return 	List<ExcIEEEST5B> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEST5B> findAll( FindAllExcIEEEST5BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEST5B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEST5BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST5BEntityProjector.class.getName());

}
