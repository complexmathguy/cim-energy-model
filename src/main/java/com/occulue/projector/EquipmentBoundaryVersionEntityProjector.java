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
 * Projector for EquipmentBoundaryVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquipmentBoundaryVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equipmentBoundaryVersion-entity-projector")
public class EquipmentBoundaryVersionEntityProjector {
		
	// core constructor
	public EquipmentBoundaryVersionEntityProjector(EquipmentBoundaryVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquipmentBoundaryVersion
	 * 
     * @param	entity EquipmentBoundaryVersion
     */
    public EquipmentBoundaryVersion create( EquipmentBoundaryVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquipmentBoundaryVersion
	 * 
     * @param	entity EquipmentBoundaryVersion
     */
    public EquipmentBoundaryVersion update( EquipmentBoundaryVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquipmentBoundaryVersion
	 * 
     * @param	id		UUID
     */
    public EquipmentBoundaryVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquipmentBoundaryVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquipmentBoundaryVersion via an FindEquipmentBoundaryVersionQuery
     * @return 	query	FindEquipmentBoundaryVersionQuery
     */
    @SuppressWarnings("unused")
    public EquipmentBoundaryVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquipmentBoundaryVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquipmentBoundaryVersions
     *
     * @param	query	FindAllEquipmentBoundaryVersionQuery 
     * @return 	List<EquipmentBoundaryVersion> 
     */
    @SuppressWarnings("unused")
    public List<EquipmentBoundaryVersion> findAll( FindAllEquipmentBoundaryVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquipmentBoundaryVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquipmentBoundaryVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquipmentBoundaryVersionEntityProjector.class.getName());

}
