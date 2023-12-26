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
 * Projector for VoltageAdjusterDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by VoltageAdjusterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("voltageAdjusterDynamics-entity-projector")
public class VoltageAdjusterDynamicsEntityProjector {
		
	// core constructor
	public VoltageAdjusterDynamicsEntityProjector(VoltageAdjusterDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VoltageAdjusterDynamics
	 * 
     * @param	entity VoltageAdjusterDynamics
     */
    public VoltageAdjusterDynamics create( VoltageAdjusterDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VoltageAdjusterDynamics
	 * 
     * @param	entity VoltageAdjusterDynamics
     */
    public VoltageAdjusterDynamics update( VoltageAdjusterDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VoltageAdjusterDynamics
	 * 
     * @param	id		UUID
     */
    public VoltageAdjusterDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VoltageAdjusterDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VoltageAdjusterDynamics via an FindVoltageAdjusterDynamicsQuery
     * @return 	query	FindVoltageAdjusterDynamicsQuery
     */
    @SuppressWarnings("unused")
    public VoltageAdjusterDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VoltageAdjusterDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VoltageAdjusterDynamicss
     *
     * @param	query	FindAllVoltageAdjusterDynamicsQuery 
     * @return 	List<VoltageAdjusterDynamics> 
     */
    @SuppressWarnings("unused")
    public List<VoltageAdjusterDynamics> findAll( FindAllVoltageAdjusterDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VoltageAdjusterDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VoltageAdjusterDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageAdjusterDynamicsEntityProjector.class.getName());

}
