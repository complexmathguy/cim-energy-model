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
 * Projector for WindTurbineType1or2Dynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindTurbineType1or2DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType1or2Dynamics-entity-projector")
public class WindTurbineType1or2DynamicsEntityProjector {
		
	// core constructor
	public WindTurbineType1or2DynamicsEntityProjector(WindTurbineType1or2DynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindTurbineType1or2Dynamics
	 * 
     * @param	entity WindTurbineType1or2Dynamics
     */
    public WindTurbineType1or2Dynamics create( WindTurbineType1or2Dynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindTurbineType1or2Dynamics
	 * 
     * @param	entity WindTurbineType1or2Dynamics
     */
    public WindTurbineType1or2Dynamics update( WindTurbineType1or2Dynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindTurbineType1or2Dynamics
	 * 
     * @param	id		UUID
     */
    public WindTurbineType1or2Dynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindTurbineType1or2Dynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindTurbineType1or2Dynamics via an FindWindTurbineType1or2DynamicsQuery
     * @return 	query	FindWindTurbineType1or2DynamicsQuery
     */
    @SuppressWarnings("unused")
    public WindTurbineType1or2Dynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindTurbineType1or2Dynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType1or2Dynamicss
     *
     * @param	query	FindAllWindTurbineType1or2DynamicsQuery 
     * @return 	List<WindTurbineType1or2Dynamics> 
     */
    @SuppressWarnings("unused")
    public List<WindTurbineType1or2Dynamics> findAll( FindAllWindTurbineType1or2DynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindTurbineType1or2Dynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindTurbineType1or2DynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType1or2DynamicsEntityProjector.class.getName());

}
