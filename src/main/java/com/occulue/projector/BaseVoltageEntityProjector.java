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
 * Projector for BaseVoltage as outlined for the CQRS pattern.
 * 
 * Commands are handled by BaseVoltageAggregate
 * 
 * @author your_name_here
 *
 */
@Component("baseVoltage-entity-projector")
public class BaseVoltageEntityProjector {
		
	// core constructor
	public BaseVoltageEntityProjector(BaseVoltageRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a BaseVoltage
	 * 
     * @param	entity BaseVoltage
     */
    public BaseVoltage create( BaseVoltage entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a BaseVoltage
	 * 
     * @param	entity BaseVoltage
     */
    public BaseVoltage update( BaseVoltage entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a BaseVoltage
	 * 
     * @param	id		UUID
     */
    public BaseVoltage delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    BaseVoltage entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the BaseVoltage via an FindBaseVoltageQuery
     * @return 	query	FindBaseVoltageQuery
     */
    @SuppressWarnings("unused")
    public BaseVoltage find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a BaseVoltage - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all BaseVoltages
     *
     * @param	query	FindAllBaseVoltageQuery 
     * @return 	List<BaseVoltage> 
     */
    @SuppressWarnings("unused")
    public List<BaseVoltage> findAll( FindAllBaseVoltageQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all BaseVoltage - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final BaseVoltageRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(BaseVoltageEntityProjector.class.getName());

}
