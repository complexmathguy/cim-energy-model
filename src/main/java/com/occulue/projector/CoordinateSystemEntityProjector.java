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
 * Projector for CoordinateSystem as outlined for the CQRS pattern.
 * 
 * Commands are handled by CoordinateSystemAggregate
 * 
 * @author your_name_here
 *
 */
@Component("coordinateSystem-entity-projector")
public class CoordinateSystemEntityProjector {
		
	// core constructor
	public CoordinateSystemEntityProjector(CoordinateSystemRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a CoordinateSystem
	 * 
     * @param	entity CoordinateSystem
     */
    public CoordinateSystem create( CoordinateSystem entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a CoordinateSystem
	 * 
     * @param	entity CoordinateSystem
     */
    public CoordinateSystem update( CoordinateSystem entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a CoordinateSystem
	 * 
     * @param	id		UUID
     */
    public CoordinateSystem delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    CoordinateSystem entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the CoordinateSystem via an FindCoordinateSystemQuery
     * @return 	query	FindCoordinateSystemQuery
     */
    @SuppressWarnings("unused")
    public CoordinateSystem find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a CoordinateSystem - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all CoordinateSystems
     *
     * @param	query	FindAllCoordinateSystemQuery 
     * @return 	List<CoordinateSystem> 
     */
    @SuppressWarnings("unused")
    public List<CoordinateSystem> findAll( FindAllCoordinateSystemQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all CoordinateSystem - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final CoordinateSystemRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(CoordinateSystemEntityProjector.class.getName());

}
