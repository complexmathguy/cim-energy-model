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
 * Projector for EquivalentEquipment as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquivalentEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equivalentEquipment-entity-projector")
public class EquivalentEquipmentEntityProjector {
		
	// core constructor
	public EquivalentEquipmentEntityProjector(EquivalentEquipmentRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquivalentEquipment
	 * 
     * @param	entity EquivalentEquipment
     */
    public EquivalentEquipment create( EquivalentEquipment entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquivalentEquipment
	 * 
     * @param	entity EquivalentEquipment
     */
    public EquivalentEquipment update( EquivalentEquipment entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquivalentEquipment
	 * 
     * @param	id		UUID
     */
    public EquivalentEquipment delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquivalentEquipment entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquivalentEquipment via an FindEquivalentEquipmentQuery
     * @return 	query	FindEquivalentEquipmentQuery
     */
    @SuppressWarnings("unused")
    public EquivalentEquipment find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquivalentEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquivalentEquipments
     *
     * @param	query	FindAllEquivalentEquipmentQuery 
     * @return 	List<EquivalentEquipment> 
     */
    @SuppressWarnings("unused")
    public List<EquivalentEquipment> findAll( FindAllEquivalentEquipmentQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquivalentEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquivalentEquipmentRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentEquipmentEntityProjector.class.getName());

}
