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
 * Projector for ExcIEEEAC4A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC4AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC4A-entity-projector")
public class ExcIEEEAC4AEntityProjector {
		
	// core constructor
	public ExcIEEEAC4AEntityProjector(ExcIEEEAC4ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC4A
	 * 
     * @param	entity ExcIEEEAC4A
     */
    public ExcIEEEAC4A create( ExcIEEEAC4A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC4A
	 * 
     * @param	entity ExcIEEEAC4A
     */
    public ExcIEEEAC4A update( ExcIEEEAC4A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC4A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC4A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC4A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC4A via an FindExcIEEEAC4AQuery
     * @return 	query	FindExcIEEEAC4AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC4A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC4A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC4As
     *
     * @param	query	FindAllExcIEEEAC4AQuery 
     * @return 	List<ExcIEEEAC4A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC4A> findAll( FindAllExcIEEEAC4AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC4A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC4ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC4AEntityProjector.class.getName());

}
