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
 * Projector for DynamicsFunctionBlock as outlined for the CQRS pattern.
 * 
 * Commands are handled by DynamicsFunctionBlockAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dynamicsFunctionBlock-entity-projector")
public class DynamicsFunctionBlockEntityProjector {
		
	// core constructor
	public DynamicsFunctionBlockEntityProjector(DynamicsFunctionBlockRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DynamicsFunctionBlock
	 * 
     * @param	entity DynamicsFunctionBlock
     */
    public DynamicsFunctionBlock create( DynamicsFunctionBlock entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DynamicsFunctionBlock
	 * 
     * @param	entity DynamicsFunctionBlock
     */
    public DynamicsFunctionBlock update( DynamicsFunctionBlock entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DynamicsFunctionBlock
	 * 
     * @param	id		UUID
     */
    public DynamicsFunctionBlock delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DynamicsFunctionBlock entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DynamicsFunctionBlock via an FindDynamicsFunctionBlockQuery
     * @return 	query	FindDynamicsFunctionBlockQuery
     */
    @SuppressWarnings("unused")
    public DynamicsFunctionBlock find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DynamicsFunctionBlock - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DynamicsFunctionBlocks
     *
     * @param	query	FindAllDynamicsFunctionBlockQuery 
     * @return 	List<DynamicsFunctionBlock> 
     */
    @SuppressWarnings("unused")
    public List<DynamicsFunctionBlock> findAll( FindAllDynamicsFunctionBlockQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DynamicsFunctionBlock - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DynamicsFunctionBlockRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DynamicsFunctionBlockEntityProjector.class.getName());

}
