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
 * Projector for MonthDayInterval as outlined for the CQRS pattern.
 * 
 * Commands are handled by MonthDayIntervalAggregate
 * 
 * @author your_name_here
 *
 */
@Component("monthDayInterval-entity-projector")
public class MonthDayIntervalEntityProjector {
		
	// core constructor
	public MonthDayIntervalEntityProjector(MonthDayIntervalRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a MonthDayInterval
	 * 
     * @param	entity MonthDayInterval
     */
    public MonthDayInterval create( MonthDayInterval entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a MonthDayInterval
	 * 
     * @param	entity MonthDayInterval
     */
    public MonthDayInterval update( MonthDayInterval entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a MonthDayInterval
	 * 
     * @param	id		UUID
     */
    public MonthDayInterval delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    MonthDayInterval entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the MonthDayInterval via an FindMonthDayIntervalQuery
     * @return 	query	FindMonthDayIntervalQuery
     */
    @SuppressWarnings("unused")
    public MonthDayInterval find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a MonthDayInterval - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all MonthDayIntervals
     *
     * @param	query	FindAllMonthDayIntervalQuery 
     * @return 	List<MonthDayInterval> 
     */
    @SuppressWarnings("unused")
    public List<MonthDayInterval> findAll( FindAllMonthDayIntervalQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all MonthDayInterval - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final MonthDayIntervalRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(MonthDayIntervalEntityProjector.class.getName());

}
