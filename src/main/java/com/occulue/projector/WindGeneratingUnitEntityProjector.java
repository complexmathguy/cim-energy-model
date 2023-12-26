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
 * Projector for WindGeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGeneratingUnit-entity-projector")
public class WindGeneratingUnitEntityProjector {
		
	// core constructor
	public WindGeneratingUnitEntityProjector(WindGeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGeneratingUnit
	 * 
     * @param	entity WindGeneratingUnit
     */
    public WindGeneratingUnit create( WindGeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGeneratingUnit
	 * 
     * @param	entity WindGeneratingUnit
     */
    public WindGeneratingUnit update( WindGeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGeneratingUnit
	 * 
     * @param	id		UUID
     */
    public WindGeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGeneratingUnit via an FindWindGeneratingUnitQuery
     * @return 	query	FindWindGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public WindGeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGeneratingUnits
     *
     * @param	query	FindAllWindGeneratingUnitQuery 
     * @return 	List<WindGeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<WindGeneratingUnit> findAll( FindAllWindGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGeneratingUnitEntityProjector.class.getName());

}
