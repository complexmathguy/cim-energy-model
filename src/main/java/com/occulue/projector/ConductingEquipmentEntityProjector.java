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
 * Projector for ConductingEquipment as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConductingEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
@Component("conductingEquipment-entity-projector")
public class ConductingEquipmentEntityProjector {
		
	// core constructor
	public ConductingEquipmentEntityProjector(ConductingEquipmentRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ConductingEquipment
	 * 
     * @param	entity ConductingEquipment
     */
    public ConductingEquipment create( ConductingEquipment entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ConductingEquipment
	 * 
     * @param	entity ConductingEquipment
     */
    public ConductingEquipment update( ConductingEquipment entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ConductingEquipment
	 * 
     * @param	id		UUID
     */
    public ConductingEquipment delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ConductingEquipment entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ConductingEquipment via an FindConductingEquipmentQuery
     * @return 	query	FindConductingEquipmentQuery
     */
    @SuppressWarnings("unused")
    public ConductingEquipment find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ConductingEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ConductingEquipments
     *
     * @param	query	FindAllConductingEquipmentQuery 
     * @return 	List<ConductingEquipment> 
     */
    @SuppressWarnings("unused")
    public List<ConductingEquipment> findAll( FindAllConductingEquipmentQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ConductingEquipment - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConductingEquipmentRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConductingEquipmentEntityProjector.class.getName());

}
