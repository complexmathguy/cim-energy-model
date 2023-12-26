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
 * Projector for DayType as outlined for the CQRS pattern.
 * 
 * Commands are handled by DayTypeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dayType-entity-projector")
public class DayTypeEntityProjector {
		
	// core constructor
	public DayTypeEntityProjector(DayTypeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DayType
	 * 
     * @param	entity DayType
     */
    public DayType create( DayType entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DayType
	 * 
     * @param	entity DayType
     */
    public DayType update( DayType entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DayType
	 * 
     * @param	id		UUID
     */
    public DayType delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DayType entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DayType via an FindDayTypeQuery
     * @return 	query	FindDayTypeQuery
     */
    @SuppressWarnings("unused")
    public DayType find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DayType - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DayTypes
     *
     * @param	query	FindAllDayTypeQuery 
     * @return 	List<DayType> 
     */
    @SuppressWarnings("unused")
    public List<DayType> findAll( FindAllDayTypeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DayType - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DayTypeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DayTypeEntityProjector.class.getName());

}
