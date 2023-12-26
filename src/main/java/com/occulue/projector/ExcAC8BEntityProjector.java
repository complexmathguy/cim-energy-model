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
 * Projector for ExcAC8B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAC8BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAC8B-entity-projector")
public class ExcAC8BEntityProjector {
		
	// core constructor
	public ExcAC8BEntityProjector(ExcAC8BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAC8B
	 * 
     * @param	entity ExcAC8B
     */
    public ExcAC8B create( ExcAC8B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAC8B
	 * 
     * @param	entity ExcAC8B
     */
    public ExcAC8B update( ExcAC8B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAC8B
	 * 
     * @param	id		UUID
     */
    public ExcAC8B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAC8B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAC8B via an FindExcAC8BQuery
     * @return 	query	FindExcAC8BQuery
     */
    @SuppressWarnings("unused")
    public ExcAC8B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAC8B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAC8Bs
     *
     * @param	query	FindAllExcAC8BQuery 
     * @return 	List<ExcAC8B> 
     */
    @SuppressWarnings("unused")
    public List<ExcAC8B> findAll( FindAllExcAC8BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAC8B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAC8BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAC8BEntityProjector.class.getName());

}
