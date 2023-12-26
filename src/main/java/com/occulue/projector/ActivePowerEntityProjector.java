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
 * Projector for ActivePower as outlined for the CQRS pattern.
 * 
 * Commands are handled by ActivePowerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("activePower-entity-projector")
public class ActivePowerEntityProjector {
		
	// core constructor
	public ActivePowerEntityProjector(ActivePowerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ActivePower
	 * 
     * @param	entity ActivePower
     */
    public ActivePower create( ActivePower entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ActivePower
	 * 
     * @param	entity ActivePower
     */
    public ActivePower update( ActivePower entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ActivePower
	 * 
     * @param	id		UUID
     */
    public ActivePower delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ActivePower entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ActivePower via an FindActivePowerQuery
     * @return 	query	FindActivePowerQuery
     */
    @SuppressWarnings("unused")
    public ActivePower find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ActivePower - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ActivePowers
     *
     * @param	query	FindAllActivePowerQuery 
     * @return 	List<ActivePower> 
     */
    @SuppressWarnings("unused")
    public List<ActivePower> findAll( FindAllActivePowerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ActivePower - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ActivePowerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ActivePowerEntityProjector.class.getName());

}
