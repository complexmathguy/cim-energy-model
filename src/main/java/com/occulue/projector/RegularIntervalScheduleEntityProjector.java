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
 * Projector for RegularIntervalSchedule as outlined for the CQRS pattern.
 * 
 * Commands are handled by RegularIntervalScheduleAggregate
 * 
 * @author your_name_here
 *
 */
@Component("regularIntervalSchedule-entity-projector")
public class RegularIntervalScheduleEntityProjector {
		
	// core constructor
	public RegularIntervalScheduleEntityProjector(RegularIntervalScheduleRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RegularIntervalSchedule
	 * 
     * @param	entity RegularIntervalSchedule
     */
    public RegularIntervalSchedule create( RegularIntervalSchedule entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RegularIntervalSchedule
	 * 
     * @param	entity RegularIntervalSchedule
     */
    public RegularIntervalSchedule update( RegularIntervalSchedule entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RegularIntervalSchedule
	 * 
     * @param	id		UUID
     */
    public RegularIntervalSchedule delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RegularIntervalSchedule entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RegularIntervalSchedule via an FindRegularIntervalScheduleQuery
     * @return 	query	FindRegularIntervalScheduleQuery
     */
    @SuppressWarnings("unused")
    public RegularIntervalSchedule find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RegularIntervalSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RegularIntervalSchedules
     *
     * @param	query	FindAllRegularIntervalScheduleQuery 
     * @return 	List<RegularIntervalSchedule> 
     */
    @SuppressWarnings("unused")
    public List<RegularIntervalSchedule> findAll( FindAllRegularIntervalScheduleQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RegularIntervalSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RegularIntervalScheduleRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RegularIntervalScheduleEntityProjector.class.getName());

}
