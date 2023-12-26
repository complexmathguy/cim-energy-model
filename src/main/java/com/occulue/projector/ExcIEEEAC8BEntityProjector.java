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
 * Projector for ExcIEEEAC8B as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC8BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC8B-entity-projector")
public class ExcIEEEAC8BEntityProjector {
		
	// core constructor
	public ExcIEEEAC8BEntityProjector(ExcIEEEAC8BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC8B
	 * 
     * @param	entity ExcIEEEAC8B
     */
    public ExcIEEEAC8B create( ExcIEEEAC8B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC8B
	 * 
     * @param	entity ExcIEEEAC8B
     */
    public ExcIEEEAC8B update( ExcIEEEAC8B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC8B
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC8B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC8B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC8B via an FindExcIEEEAC8BQuery
     * @return 	query	FindExcIEEEAC8BQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC8B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC8B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC8Bs
     *
     * @param	query	FindAllExcIEEEAC8BQuery 
     * @return 	List<ExcIEEEAC8B> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC8B> findAll( FindAllExcIEEEAC8BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC8B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC8BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC8BEntityProjector.class.getName());

}
