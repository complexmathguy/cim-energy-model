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
 * Projector for ExcPIC as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcPICAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excPIC-entity-projector")
public class ExcPICEntityProjector {
		
	// core constructor
	public ExcPICEntityProjector(ExcPICRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcPIC
	 * 
     * @param	entity ExcPIC
     */
    public ExcPIC create( ExcPIC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcPIC
	 * 
     * @param	entity ExcPIC
     */
    public ExcPIC update( ExcPIC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcPIC
	 * 
     * @param	id		UUID
     */
    public ExcPIC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcPIC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcPIC via an FindExcPICQuery
     * @return 	query	FindExcPICQuery
     */
    @SuppressWarnings("unused")
    public ExcPIC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcPIC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcPICs
     *
     * @param	query	FindAllExcPICQuery 
     * @return 	List<ExcPIC> 
     */
    @SuppressWarnings("unused")
    public List<ExcPIC> findAll( FindAllExcPICQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcPIC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcPICRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcPICEntityProjector.class.getName());

}
