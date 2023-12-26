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
 * Projector for EnergyConsumer as outlined for the CQRS pattern.
 * 
 * Commands are handled by EnergyConsumerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("energyConsumer-entity-projector")
public class EnergyConsumerEntityProjector {
		
	// core constructor
	public EnergyConsumerEntityProjector(EnergyConsumerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EnergyConsumer
	 * 
     * @param	entity EnergyConsumer
     */
    public EnergyConsumer create( EnergyConsumer entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EnergyConsumer
	 * 
     * @param	entity EnergyConsumer
     */
    public EnergyConsumer update( EnergyConsumer entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EnergyConsumer
	 * 
     * @param	id		UUID
     */
    public EnergyConsumer delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EnergyConsumer entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EnergyConsumer via an FindEnergyConsumerQuery
     * @return 	query	FindEnergyConsumerQuery
     */
    @SuppressWarnings("unused")
    public EnergyConsumer find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EnergyConsumer - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EnergyConsumers
     *
     * @param	query	FindAllEnergyConsumerQuery 
     * @return 	List<EnergyConsumer> 
     */
    @SuppressWarnings("unused")
    public List<EnergyConsumer> findAll( FindAllEnergyConsumerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EnergyConsumer - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EnergyConsumerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EnergyConsumerEntityProjector.class.getName());

}
