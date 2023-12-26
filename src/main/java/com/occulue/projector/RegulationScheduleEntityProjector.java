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
 * Projector for RegulationSchedule as outlined for the CQRS pattern.
 * 
 * Commands are handled by RegulationScheduleAggregate
 * 
 * @author your_name_here
 *
 */
@Component("regulationSchedule-entity-projector")
public class RegulationScheduleEntityProjector {
		
	// core constructor
	public RegulationScheduleEntityProjector(RegulationScheduleRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RegulationSchedule
	 * 
     * @param	entity RegulationSchedule
     */
    public RegulationSchedule create( RegulationSchedule entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RegulationSchedule
	 * 
     * @param	entity RegulationSchedule
     */
    public RegulationSchedule update( RegulationSchedule entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RegulationSchedule
	 * 
     * @param	id		UUID
     */
    public RegulationSchedule delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RegulationSchedule entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RegulationSchedule via an FindRegulationScheduleQuery
     * @return 	query	FindRegulationScheduleQuery
     */
    @SuppressWarnings("unused")
    public RegulationSchedule find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RegulationSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RegulationSchedules
     *
     * @param	query	FindAllRegulationScheduleQuery 
     * @return 	List<RegulationSchedule> 
     */
    @SuppressWarnings("unused")
    public List<RegulationSchedule> findAll( FindAllRegulationScheduleQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RegulationSchedule - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RegulationScheduleRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RegulationScheduleEntityProjector.class.getName());

}
