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
 * Projector for DCConductingEquipment as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCConductingEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCConductingEquipment-entity-projector")
public class DCConductingEquipmentEntityProjector {
		
	// core constructor
	public DCConductingEquipmentEntityProjector(DCConductingEquipmentRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCConductingEquipment
	 * 
     * @param	entity DCConductingEquipment
     */
    public DCConductingEquipment create( DCConductingEquipment entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCConductingEquipment
	 * 
     * @param	entity DCConductingEquipment
     */
    public DCConductingEquipment update( DCConductingEquipment entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCConductingEquipment
	 * 
     * @param	id		UUID
     */
    public DCConductingEquipment delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCConductingEquipment entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCConductingEquipment via an FindDCConductingEquipmentQuery
     * @return 	query	FindDCConductingEquipmentQuery
     */
    @SuppressWarnings("unused")
    public DCConductingEquipment find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCConductingEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCConductingEquipments
     *
     * @param	query	FindAllDCConductingEquipmentQuery 
     * @return 	List<DCConductingEquipment> 
     */
    @SuppressWarnings("unused")
    public List<DCConductingEquipment> findAll( FindAllDCConductingEquipmentQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCConductingEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCConductingEquipmentRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCConductingEquipmentEntityProjector.class.getName());

}
