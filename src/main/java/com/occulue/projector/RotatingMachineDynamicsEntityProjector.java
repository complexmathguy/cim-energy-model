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
 * Projector for RotatingMachineDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by RotatingMachineDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("rotatingMachineDynamics-entity-projector")
public class RotatingMachineDynamicsEntityProjector {
		
	// core constructor
	public RotatingMachineDynamicsEntityProjector(RotatingMachineDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RotatingMachineDynamics
	 * 
     * @param	entity RotatingMachineDynamics
     */
    public RotatingMachineDynamics create( RotatingMachineDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RotatingMachineDynamics
	 * 
     * @param	entity RotatingMachineDynamics
     */
    public RotatingMachineDynamics update( RotatingMachineDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RotatingMachineDynamics
	 * 
     * @param	id		UUID
     */
    public RotatingMachineDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RotatingMachineDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RotatingMachineDynamics via an FindRotatingMachineDynamicsQuery
     * @return 	query	FindRotatingMachineDynamicsQuery
     */
    @SuppressWarnings("unused")
    public RotatingMachineDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RotatingMachineDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RotatingMachineDynamicss
     *
     * @param	query	FindAllRotatingMachineDynamicsQuery 
     * @return 	List<RotatingMachineDynamics> 
     */
    @SuppressWarnings("unused")
    public List<RotatingMachineDynamics> findAll( FindAllRotatingMachineDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RotatingMachineDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RotatingMachineDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RotatingMachineDynamicsEntityProjector.class.getName());

}
