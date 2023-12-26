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
 * Projector for ControlAreaGeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by ControlAreaGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("controlAreaGeneratingUnit-entity-projector")
public class ControlAreaGeneratingUnitEntityProjector {
		
	// core constructor
	public ControlAreaGeneratingUnitEntityProjector(ControlAreaGeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ControlAreaGeneratingUnit
	 * 
     * @param	entity ControlAreaGeneratingUnit
     */
    public ControlAreaGeneratingUnit create( ControlAreaGeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ControlAreaGeneratingUnit
	 * 
     * @param	entity ControlAreaGeneratingUnit
     */
    public ControlAreaGeneratingUnit update( ControlAreaGeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ControlAreaGeneratingUnit
	 * 
     * @param	id		UUID
     */
    public ControlAreaGeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ControlAreaGeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ControlAreaGeneratingUnit via an FindControlAreaGeneratingUnitQuery
     * @return 	query	FindControlAreaGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public ControlAreaGeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ControlAreaGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ControlAreaGeneratingUnits
     *
     * @param	query	FindAllControlAreaGeneratingUnitQuery 
     * @return 	List<ControlAreaGeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<ControlAreaGeneratingUnit> findAll( FindAllControlAreaGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ControlAreaGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ControlAreaGeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ControlAreaGeneratingUnitEntityProjector.class.getName());

}
