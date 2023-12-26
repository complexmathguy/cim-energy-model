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
 * Projector for AnalogLimit as outlined for the CQRS pattern.
 * 
 * Commands are handled by AnalogLimitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("analogLimit-entity-projector")
public class AnalogLimitEntityProjector {
		
	// core constructor
	public AnalogLimitEntityProjector(AnalogLimitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AnalogLimit
	 * 
     * @param	entity AnalogLimit
     */
    public AnalogLimit create( AnalogLimit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AnalogLimit
	 * 
     * @param	entity AnalogLimit
     */
    public AnalogLimit update( AnalogLimit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AnalogLimit
	 * 
     * @param	id		UUID
     */
    public AnalogLimit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AnalogLimit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AnalogLimit via an FindAnalogLimitQuery
     * @return 	query	FindAnalogLimitQuery
     */
    @SuppressWarnings("unused")
    public AnalogLimit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AnalogLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AnalogLimits
     *
     * @param	query	FindAllAnalogLimitQuery 
     * @return 	List<AnalogLimit> 
     */
    @SuppressWarnings("unused")
    public List<AnalogLimit> findAll( FindAllAnalogLimitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AnalogLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AnalogLimitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogLimitEntityProjector.class.getName());

}
