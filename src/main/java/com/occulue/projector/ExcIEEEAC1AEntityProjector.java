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
 * Projector for ExcIEEEAC1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC1A-entity-projector")
public class ExcIEEEAC1AEntityProjector {
		
	// core constructor
	public ExcIEEEAC1AEntityProjector(ExcIEEEAC1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC1A
	 * 
     * @param	entity ExcIEEEAC1A
     */
    public ExcIEEEAC1A create( ExcIEEEAC1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC1A
	 * 
     * @param	entity ExcIEEEAC1A
     */
    public ExcIEEEAC1A update( ExcIEEEAC1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC1A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC1A via an FindExcIEEEAC1AQuery
     * @return 	query	FindExcIEEEAC1AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC1As
     *
     * @param	query	FindAllExcIEEEAC1AQuery 
     * @return 	List<ExcIEEEAC1A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC1A> findAll( FindAllExcIEEEAC1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC1AEntityProjector.class.getName());

}
