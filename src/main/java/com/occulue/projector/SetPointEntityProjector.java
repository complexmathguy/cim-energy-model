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
 * Projector for SetPoint as outlined for the CQRS pattern.
 * 
 * Commands are handled by SetPointAggregate
 * 
 * @author your_name_here
 *
 */
@Component("setPoint-entity-projector")
public class SetPointEntityProjector {
		
	// core constructor
	public SetPointEntityProjector(SetPointRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SetPoint
	 * 
     * @param	entity SetPoint
     */
    public SetPoint create( SetPoint entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SetPoint
	 * 
     * @param	entity SetPoint
     */
    public SetPoint update( SetPoint entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SetPoint
	 * 
     * @param	id		UUID
     */
    public SetPoint delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SetPoint entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SetPoint via an FindSetPointQuery
     * @return 	query	FindSetPointQuery
     */
    @SuppressWarnings("unused")
    public SetPoint find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SetPoint - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SetPoints
     *
     * @param	query	FindAllSetPointQuery 
     * @return 	List<SetPoint> 
     */
    @SuppressWarnings("unused")
    public List<SetPoint> findAll( FindAllSetPointQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SetPoint - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SetPointRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SetPointEntityProjector.class.getName());

}
