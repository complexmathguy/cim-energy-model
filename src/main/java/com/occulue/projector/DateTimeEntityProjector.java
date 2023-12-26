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
 * Projector for DateTime as outlined for the CQRS pattern.
 * 
 * Commands are handled by DateTimeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dateTime-entity-projector")
public class DateTimeEntityProjector {
		
	// core constructor
	public DateTimeEntityProjector(DateTimeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DateTime
	 * 
     * @param	entity DateTime
     */
    public DateTime create( DateTime entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DateTime
	 * 
     * @param	entity DateTime
     */
    public DateTime update( DateTime entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DateTime
	 * 
     * @param	id		UUID
     */
    public DateTime delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DateTime entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DateTime via an FindDateTimeQuery
     * @return 	query	FindDateTimeQuery
     */
    @SuppressWarnings("unused")
    public DateTime find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DateTime - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DateTimes
     *
     * @param	query	FindAllDateTimeQuery 
     * @return 	List<DateTime> 
     */
    @SuppressWarnings("unused")
    public List<DateTime> findAll( FindAllDateTimeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DateTime - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DateTimeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DateTimeEntityProjector.class.getName());

}
