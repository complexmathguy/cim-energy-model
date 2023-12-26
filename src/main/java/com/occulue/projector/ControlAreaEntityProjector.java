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
 * Projector for ControlArea as outlined for the CQRS pattern.
 * 
 * Commands are handled by ControlAreaAggregate
 * 
 * @author your_name_here
 *
 */
@Component("controlArea-entity-projector")
public class ControlAreaEntityProjector {
		
	// core constructor
	public ControlAreaEntityProjector(ControlAreaRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ControlArea
	 * 
     * @param	entity ControlArea
     */
    public ControlArea create( ControlArea entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ControlArea
	 * 
     * @param	entity ControlArea
     */
    public ControlArea update( ControlArea entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ControlArea
	 * 
     * @param	id		UUID
     */
    public ControlArea delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ControlArea entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ControlArea via an FindControlAreaQuery
     * @return 	query	FindControlAreaQuery
     */
    @SuppressWarnings("unused")
    public ControlArea find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ControlArea - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ControlAreas
     *
     * @param	query	FindAllControlAreaQuery 
     * @return 	List<ControlArea> 
     */
    @SuppressWarnings("unused")
    public List<ControlArea> findAll( FindAllControlAreaQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ControlArea - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ControlAreaRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ControlAreaEntityProjector.class.getName());

}
