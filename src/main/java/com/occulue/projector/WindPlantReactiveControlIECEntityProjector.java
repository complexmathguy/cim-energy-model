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
 * Projector for WindPlantReactiveControlIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindPlantReactiveControlIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windPlantReactiveControlIEC-entity-projector")
public class WindPlantReactiveControlIECEntityProjector {
		
	// core constructor
	public WindPlantReactiveControlIECEntityProjector(WindPlantReactiveControlIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindPlantReactiveControlIEC
	 * 
     * @param	entity WindPlantReactiveControlIEC
     */
    public WindPlantReactiveControlIEC create( WindPlantReactiveControlIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindPlantReactiveControlIEC
	 * 
     * @param	entity WindPlantReactiveControlIEC
     */
    public WindPlantReactiveControlIEC update( WindPlantReactiveControlIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindPlantReactiveControlIEC
	 * 
     * @param	id		UUID
     */
    public WindPlantReactiveControlIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindPlantReactiveControlIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindPlantReactiveControlIEC via an FindWindPlantReactiveControlIECQuery
     * @return 	query	FindWindPlantReactiveControlIECQuery
     */
    @SuppressWarnings("unused")
    public WindPlantReactiveControlIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindPlantReactiveControlIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindPlantReactiveControlIECs
     *
     * @param	query	FindAllWindPlantReactiveControlIECQuery 
     * @return 	List<WindPlantReactiveControlIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindPlantReactiveControlIEC> findAll( FindAllWindPlantReactiveControlIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindPlantReactiveControlIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindPlantReactiveControlIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantReactiveControlIECEntityProjector.class.getName());

}
