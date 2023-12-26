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
 * Projector for PowerTransformerEnd as outlined for the CQRS pattern.
 * 
 * Commands are handled by PowerTransformerEndAggregate
 * 
 * @author your_name_here
 *
 */
@Component("powerTransformerEnd-entity-projector")
public class PowerTransformerEndEntityProjector {
		
	// core constructor
	public PowerTransformerEndEntityProjector(PowerTransformerEndRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PowerTransformerEnd
	 * 
     * @param	entity PowerTransformerEnd
     */
    public PowerTransformerEnd create( PowerTransformerEnd entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PowerTransformerEnd
	 * 
     * @param	entity PowerTransformerEnd
     */
    public PowerTransformerEnd update( PowerTransformerEnd entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PowerTransformerEnd
	 * 
     * @param	id		UUID
     */
    public PowerTransformerEnd delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PowerTransformerEnd entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PowerTransformerEnd via an FindPowerTransformerEndQuery
     * @return 	query	FindPowerTransformerEndQuery
     */
    @SuppressWarnings("unused")
    public PowerTransformerEnd find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PowerTransformerEnd - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PowerTransformerEnds
     *
     * @param	query	FindAllPowerTransformerEndQuery 
     * @return 	List<PowerTransformerEnd> 
     */
    @SuppressWarnings("unused")
    public List<PowerTransformerEnd> findAll( FindAllPowerTransformerEndQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PowerTransformerEnd - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PowerTransformerEndRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PowerTransformerEndEntityProjector.class.getName());

}
