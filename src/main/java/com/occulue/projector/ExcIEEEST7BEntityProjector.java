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
 * Projector for ExcIEEEST7B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEST7BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEST7B-entity-projector")
public class ExcIEEEST7BEntityProjector {
		
	// core constructor
	public ExcIEEEST7BEntityProjector(ExcIEEEST7BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEST7B
	 * 
     * @param	entity ExcIEEEST7B
     */
    public ExcIEEEST7B create( ExcIEEEST7B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEST7B
	 * 
     * @param	entity ExcIEEEST7B
     */
    public ExcIEEEST7B update( ExcIEEEST7B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEST7B
	 * 
     * @param	id		UUID
     */
    public ExcIEEEST7B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEST7B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEST7B via an FindExcIEEEST7BQuery
     * @return 	query	FindExcIEEEST7BQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEST7B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEST7B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST7Bs
     *
     * @param	query	FindAllExcIEEEST7BQuery 
     * @return 	List<ExcIEEEST7B> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEST7B> findAll( FindAllExcIEEEST7BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEST7B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEST7BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST7BEntityProjector.class.getName());

}
