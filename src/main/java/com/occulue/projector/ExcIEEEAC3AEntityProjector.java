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
 * Projector for ExcIEEEAC3A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC3AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC3A-entity-projector")
public class ExcIEEEAC3AEntityProjector {
		
	// core constructor
	public ExcIEEEAC3AEntityProjector(ExcIEEEAC3ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC3A
	 * 
     * @param	entity ExcIEEEAC3A
     */
    public ExcIEEEAC3A create( ExcIEEEAC3A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC3A
	 * 
     * @param	entity ExcIEEEAC3A
     */
    public ExcIEEEAC3A update( ExcIEEEAC3A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC3A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC3A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC3A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC3A via an FindExcIEEEAC3AQuery
     * @return 	query	FindExcIEEEAC3AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC3A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC3As
     *
     * @param	query	FindAllExcIEEEAC3AQuery 
     * @return 	List<ExcIEEEAC3A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC3A> findAll( FindAllExcIEEEAC3AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC3ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC3AEntityProjector.class.getName());

}
