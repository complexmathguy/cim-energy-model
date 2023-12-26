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
 * Projector for ExcIEEEAC2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEAC2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEAC2A-entity-projector")
public class ExcIEEEAC2AEntityProjector {
		
	// core constructor
	public ExcIEEEAC2AEntityProjector(ExcIEEEAC2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEAC2A
	 * 
     * @param	entity ExcIEEEAC2A
     */
    public ExcIEEEAC2A create( ExcIEEEAC2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEAC2A
	 * 
     * @param	entity ExcIEEEAC2A
     */
    public ExcIEEEAC2A update( ExcIEEEAC2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEAC2A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEAC2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEAC2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEAC2A via an FindExcIEEEAC2AQuery
     * @return 	query	FindExcIEEEAC2AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEAC2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEAC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC2As
     *
     * @param	query	FindAllExcIEEEAC2AQuery 
     * @return 	List<ExcIEEEAC2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEAC2A> findAll( FindAllExcIEEEAC2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEAC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEAC2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC2AEntityProjector.class.getName());

}
