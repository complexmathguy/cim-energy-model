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
 * Projector for VoltageLimit as outlined for the CQRS pattern.
 * 
 * Commands are handled by VoltageLimitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("voltageLimit-entity-projector")
public class VoltageLimitEntityProjector {
		
	// core constructor
	public VoltageLimitEntityProjector(VoltageLimitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VoltageLimit
	 * 
     * @param	entity VoltageLimit
     */
    public VoltageLimit create( VoltageLimit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VoltageLimit
	 * 
     * @param	entity VoltageLimit
     */
    public VoltageLimit update( VoltageLimit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VoltageLimit
	 * 
     * @param	id		UUID
     */
    public VoltageLimit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VoltageLimit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VoltageLimit via an FindVoltageLimitQuery
     * @return 	query	FindVoltageLimitQuery
     */
    @SuppressWarnings("unused")
    public VoltageLimit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VoltageLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VoltageLimits
     *
     * @param	query	FindAllVoltageLimitQuery 
     * @return 	List<VoltageLimit> 
     */
    @SuppressWarnings("unused")
    public List<VoltageLimit> findAll( FindAllVoltageLimitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VoltageLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VoltageLimitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageLimitEntityProjector.class.getName());

}
