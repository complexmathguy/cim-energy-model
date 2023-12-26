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
 * Projector for BasicIntervalSchedule as outlined for the CQRS pattern.
 * 
 * Commands are handled by BasicIntervalScheduleAggregate
 * 
 * @author your_name_here
 *
 */
@Component("basicIntervalSchedule-entity-projector")
public class BasicIntervalScheduleEntityProjector {
		
	// core constructor
	public BasicIntervalScheduleEntityProjector(BasicIntervalScheduleRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a BasicIntervalSchedule
	 * 
     * @param	entity BasicIntervalSchedule
     */
    public BasicIntervalSchedule create( BasicIntervalSchedule entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a BasicIntervalSchedule
	 * 
     * @param	entity BasicIntervalSchedule
     */
    public BasicIntervalSchedule update( BasicIntervalSchedule entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a BasicIntervalSchedule
	 * 
     * @param	id		UUID
     */
    public BasicIntervalSchedule delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    BasicIntervalSchedule entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the BasicIntervalSchedule via an FindBasicIntervalScheduleQuery
     * @return 	query	FindBasicIntervalScheduleQuery
     */
    @SuppressWarnings("unused")
    public BasicIntervalSchedule find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a BasicIntervalSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all BasicIntervalSchedules
     *
     * @param	query	FindAllBasicIntervalScheduleQuery 
     * @return 	List<BasicIntervalSchedule> 
     */
    @SuppressWarnings("unused")
    public List<BasicIntervalSchedule> findAll( FindAllBasicIntervalScheduleQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all BasicIntervalSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final BasicIntervalScheduleRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(BasicIntervalScheduleEntityProjector.class.getName());

}
