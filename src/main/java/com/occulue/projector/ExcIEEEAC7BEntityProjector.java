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
 * Projector for ExcIEEEAC7B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC7BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC7B-entity-projector")
public class ExcIEEEAC7BEntityProjector {
		
	// core constructor
	public ExcIEEEAC7BEntityProjector(ExcIEEEAC7BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC7B
	 * 
     * @param	entity ExcIEEEAC7B
     */
    public ExcIEEEAC7B create( ExcIEEEAC7B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC7B
	 * 
     * @param	entity ExcIEEEAC7B
     */
    public ExcIEEEAC7B update( ExcIEEEAC7B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC7B
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC7B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC7B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC7B via an FindExcIEEEAC7BQuery
     * @return 	query	FindExcIEEEAC7BQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC7B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC7B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC7Bs
     *
     * @param	query	FindAllExcIEEEAC7BQuery 
     * @return 	List<ExcIEEEAC7B> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC7B> findAll( FindAllExcIEEEAC7BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC7B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC7BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC7BEntityProjector.class.getName());

}
