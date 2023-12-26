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
 * Projector for ActivePowerPerCurrentFlow as outlined for the CQRS pattern.
 * 
 * Commands are handled by ActivePowerPerCurrentFlowAggregate
 * 
 * @author your_name_here
 *
 */
@Component("activePowerPerCurrentFlow-entity-projector")
public class ActivePowerPerCurrentFlowEntityProjector {
		
	// core constructor
	public ActivePowerPerCurrentFlowEntityProjector(ActivePowerPerCurrentFlowRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ActivePowerPerCurrentFlow
	 * 
     * @param	entity ActivePowerPerCurrentFlow
     */
    public ActivePowerPerCurrentFlow create( ActivePowerPerCurrentFlow entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ActivePowerPerCurrentFlow
	 * 
     * @param	entity ActivePowerPerCurrentFlow
     */
    public ActivePowerPerCurrentFlow update( ActivePowerPerCurrentFlow entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ActivePowerPerCurrentFlow
	 * 
     * @param	id		UUID
     */
    public ActivePowerPerCurrentFlow delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ActivePowerPerCurrentFlow entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ActivePowerPerCurrentFlow via an FindActivePowerPerCurrentFlowQuery
     * @return 	query	FindActivePowerPerCurrentFlowQuery
     */
    @SuppressWarnings("unused")
    public ActivePowerPerCurrentFlow find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ActivePowerPerCurrentFlow - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ActivePowerPerCurrentFlows
     *
     * @param	query	FindAllActivePowerPerCurrentFlowQuery 
     * @return 	List<ActivePowerPerCurrentFlow> 
     */
    @SuppressWarnings("unused")
    public List<ActivePowerPerCurrentFlow> findAll( FindAllActivePowerPerCurrentFlowQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ActivePowerPerCurrentFlow - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ActivePowerPerCurrentFlowRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerPerCurrentFlowEntityProjector.class.getName());

}
