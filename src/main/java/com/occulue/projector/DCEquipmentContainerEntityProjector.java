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
 * Projector for DCEquipmentContainer as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCEquipmentContainerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCEquipmentContainer-entity-projector")
public class DCEquipmentContainerEntityProjector {
		
	// core constructor
	public DCEquipmentContainerEntityProjector(DCEquipmentContainerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCEquipmentContainer
	 * 
     * @param	entity DCEquipmentContainer
     */
    public DCEquipmentContainer create( DCEquipmentContainer entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCEquipmentContainer
	 * 
     * @param	entity DCEquipmentContainer
     */
    public DCEquipmentContainer update( DCEquipmentContainer entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCEquipmentContainer
	 * 
     * @param	id		UUID
     */
    public DCEquipmentContainer delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCEquipmentContainer entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCEquipmentContainer via an FindDCEquipmentContainerQuery
     * @return 	query	FindDCEquipmentContainerQuery
     */
    @SuppressWarnings("unused")
    public DCEquipmentContainer find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCEquipmentContainer - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCEquipmentContainers
     *
     * @param	query	FindAllDCEquipmentContainerQuery 
     * @return 	List<DCEquipmentContainer> 
     */
    @SuppressWarnings("unused")
    public List<DCEquipmentContainer> findAll( FindAllDCEquipmentContainerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCEquipmentContainer - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCEquipmentContainerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCEquipmentContainerEntityProjector.class.getName());

}
