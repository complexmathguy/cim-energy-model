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
 * Projector for TurbineLoadControllerDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by TurbineLoadControllerDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("turbineLoadControllerDynamics-entity-projector")
public class TurbineLoadControllerDynamicsEntityProjector {
		
	// core constructor
	public TurbineLoadControllerDynamicsEntityProjector(TurbineLoadControllerDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TurbineLoadControllerDynamics
	 * 
     * @param	entity TurbineLoadControllerDynamics
     */
    public TurbineLoadControllerDynamics create( TurbineLoadControllerDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TurbineLoadControllerDynamics
	 * 
     * @param	entity TurbineLoadControllerDynamics
     */
    public TurbineLoadControllerDynamics update( TurbineLoadControllerDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TurbineLoadControllerDynamics
	 * 
     * @param	id		UUID
     */
    public TurbineLoadControllerDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TurbineLoadControllerDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TurbineLoadControllerDynamics via an FindTurbineLoadControllerDynamicsQuery
     * @return 	query	FindTurbineLoadControllerDynamicsQuery
     */
    @SuppressWarnings("unused")
    public TurbineLoadControllerDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TurbineLoadControllerDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TurbineLoadControllerDynamicss
     *
     * @param	query	FindAllTurbineLoadControllerDynamicsQuery 
     * @return 	List<TurbineLoadControllerDynamics> 
     */
    @SuppressWarnings("unused")
    public List<TurbineLoadControllerDynamics> findAll( FindAllTurbineLoadControllerDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TurbineLoadControllerDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TurbineLoadControllerDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TurbineLoadControllerDynamicsEntityProjector.class.getName());

}
