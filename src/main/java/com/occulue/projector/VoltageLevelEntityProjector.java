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
 * Projector for VoltageLevel as outlined for the CQRS pattern.
 * 
 * Commands are handled by VoltageLevelAggregate
 * 
 * @author your_name_here
 *
 */
@Component("voltageLevel-entity-projector")
public class VoltageLevelEntityProjector {
		
	// core constructor
	public VoltageLevelEntityProjector(VoltageLevelRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VoltageLevel
	 * 
     * @param	entity VoltageLevel
     */
    public VoltageLevel create( VoltageLevel entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VoltageLevel
	 * 
     * @param	entity VoltageLevel
     */
    public VoltageLevel update( VoltageLevel entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VoltageLevel
	 * 
     * @param	id		UUID
     */
    public VoltageLevel delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VoltageLevel entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VoltageLevel via an FindVoltageLevelQuery
     * @return 	query	FindVoltageLevelQuery
     */
    @SuppressWarnings("unused")
    public VoltageLevel find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VoltageLevel - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VoltageLevels
     *
     * @param	query	FindAllVoltageLevelQuery 
     * @return 	List<VoltageLevel> 
     */
    @SuppressWarnings("unused")
    public List<VoltageLevel> findAll( FindAllVoltageLevelQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VoltageLevel - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VoltageLevelRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageLevelEntityProjector.class.getName());

}
