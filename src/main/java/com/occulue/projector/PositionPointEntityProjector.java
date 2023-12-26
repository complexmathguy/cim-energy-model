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
 * Projector for PositionPoint as outlined for the CQRS pattern.
 * 
 * Commands are handled by PositionPointAggregate
 * 
 * @author your_name_here
 *
 */
@Component("positionPoint-entity-projector")
public class PositionPointEntityProjector {
		
	// core constructor
	public PositionPointEntityProjector(PositionPointRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PositionPoint
	 * 
     * @param	entity PositionPoint
     */
    public PositionPoint create( PositionPoint entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PositionPoint
	 * 
     * @param	entity PositionPoint
     */
    public PositionPoint update( PositionPoint entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PositionPoint
	 * 
     * @param	id		UUID
     */
    public PositionPoint delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PositionPoint entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PositionPoint via an FindPositionPointQuery
     * @return 	query	FindPositionPointQuery
     */
    @SuppressWarnings("unused")
    public PositionPoint find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PositionPoint - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PositionPoints
     *
     * @param	query	FindAllPositionPointQuery 
     * @return 	List<PositionPoint> 
     */
    @SuppressWarnings("unused")
    public List<PositionPoint> findAll( FindAllPositionPointQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PositionPoint - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PositionPointRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PositionPointEntityProjector.class.getName());

}
