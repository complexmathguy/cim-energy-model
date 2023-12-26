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
 * Projector for FossilFuel as outlined for the CQRS pattern.
 * 
 * Commands are handled by FossilFuelAggregate
 * 
 * @author your_name_here
 *
 */
@Component("fossilFuel-entity-projector")
public class FossilFuelEntityProjector {
		
	// core constructor
	public FossilFuelEntityProjector(FossilFuelRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a FossilFuel
	 * 
     * @param	entity FossilFuel
     */
    public FossilFuel create( FossilFuel entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a FossilFuel
	 * 
     * @param	entity FossilFuel
     */
    public FossilFuel update( FossilFuel entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a FossilFuel
	 * 
     * @param	id		UUID
     */
    public FossilFuel delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    FossilFuel entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the FossilFuel via an FindFossilFuelQuery
     * @return 	query	FindFossilFuelQuery
     */
    @SuppressWarnings("unused")
    public FossilFuel find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a FossilFuel - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all FossilFuels
     *
     * @param	query	FindAllFossilFuelQuery 
     * @return 	List<FossilFuel> 
     */
    @SuppressWarnings("unused")
    public List<FossilFuel> findAll( FindAllFossilFuelQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all FossilFuel - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final FossilFuelRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(FossilFuelEntityProjector.class.getName());

}
