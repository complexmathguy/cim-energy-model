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
 * Projector for PFVArControllerType1Dynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArControllerType1DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArControllerType1Dynamics-entity-projector")
public class PFVArControllerType1DynamicsEntityProjector {
		
	// core constructor
	public PFVArControllerType1DynamicsEntityProjector(PFVArControllerType1DynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArControllerType1Dynamics
	 * 
     * @param	entity PFVArControllerType1Dynamics
     */
    public PFVArControllerType1Dynamics create( PFVArControllerType1Dynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArControllerType1Dynamics
	 * 
     * @param	entity PFVArControllerType1Dynamics
     */
    public PFVArControllerType1Dynamics update( PFVArControllerType1Dynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArControllerType1Dynamics
	 * 
     * @param	id		UUID
     */
    public PFVArControllerType1Dynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArControllerType1Dynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArControllerType1Dynamics via an FindPFVArControllerType1DynamicsQuery
     * @return 	query	FindPFVArControllerType1DynamicsQuery
     */
    @SuppressWarnings("unused")
    public PFVArControllerType1Dynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArControllerType1Dynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArControllerType1Dynamicss
     *
     * @param	query	FindAllPFVArControllerType1DynamicsQuery 
     * @return 	List<PFVArControllerType1Dynamics> 
     */
    @SuppressWarnings("unused")
    public List<PFVArControllerType1Dynamics> findAll( FindAllPFVArControllerType1DynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArControllerType1Dynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArControllerType1DynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType1DynamicsEntityProjector.class.getName());

}
