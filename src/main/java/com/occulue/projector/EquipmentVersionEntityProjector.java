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
 * Projector for EquipmentVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquipmentVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equipmentVersion-entity-projector")
public class EquipmentVersionEntityProjector {
		
	// core constructor
	public EquipmentVersionEntityProjector(EquipmentVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquipmentVersion
	 * 
     * @param	entity EquipmentVersion
     */
    public EquipmentVersion create( EquipmentVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquipmentVersion
	 * 
     * @param	entity EquipmentVersion
     */
    public EquipmentVersion update( EquipmentVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquipmentVersion
	 * 
     * @param	id		UUID
     */
    public EquipmentVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquipmentVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquipmentVersion via an FindEquipmentVersionQuery
     * @return 	query	FindEquipmentVersionQuery
     */
    @SuppressWarnings("unused")
    public EquipmentVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquipmentVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquipmentVersions
     *
     * @param	query	FindAllEquipmentVersionQuery 
     * @return 	List<EquipmentVersion> 
     */
    @SuppressWarnings("unused")
    public List<EquipmentVersion> findAll( FindAllEquipmentVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquipmentVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquipmentVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquipmentVersionEntityProjector.class.getName());

}
