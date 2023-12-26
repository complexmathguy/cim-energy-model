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
 * Projector for GeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by GeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("generatingUnit-entity-projector")
public class GeneratingUnitEntityProjector {
		
	// core constructor
	public GeneratingUnitEntityProjector(GeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GeneratingUnit
	 * 
     * @param	entity GeneratingUnit
     */
    public GeneratingUnit create( GeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GeneratingUnit
	 * 
     * @param	entity GeneratingUnit
     */
    public GeneratingUnit update( GeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GeneratingUnit
	 * 
     * @param	id		UUID
     */
    public GeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GeneratingUnit via an FindGeneratingUnitQuery
     * @return 	query	FindGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public GeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GeneratingUnits
     *
     * @param	query	FindAllGeneratingUnitQuery 
     * @return 	List<GeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<GeneratingUnit> findAll( FindAllGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GeneratingUnitEntityProjector.class.getName());

}
