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
 * Projector for WindTurbineType3or4IEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindTurbineType3or4IECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType3or4IEC-entity-projector")
public class WindTurbineType3or4IECEntityProjector {
		
	// core constructor
	public WindTurbineType3or4IECEntityProjector(WindTurbineType3or4IECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindTurbineType3or4IEC
	 * 
     * @param	entity WindTurbineType3or4IEC
     */
    public WindTurbineType3or4IEC create( WindTurbineType3or4IEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindTurbineType3or4IEC
	 * 
     * @param	entity WindTurbineType3or4IEC
     */
    public WindTurbineType3or4IEC update( WindTurbineType3or4IEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindTurbineType3or4IEC
	 * 
     * @param	id		UUID
     */
    public WindTurbineType3or4IEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindTurbineType3or4IEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindTurbineType3or4IEC via an FindWindTurbineType3or4IECQuery
     * @return 	query	FindWindTurbineType3or4IECQuery
     */
    @SuppressWarnings("unused")
    public WindTurbineType3or4IEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindTurbineType3or4IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType3or4IECs
     *
     * @param	query	FindAllWindTurbineType3or4IECQuery 
     * @return 	List<WindTurbineType3or4IEC> 
     */
    @SuppressWarnings("unused")
    public List<WindTurbineType3or4IEC> findAll( FindAllWindTurbineType3or4IECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindTurbineType3or4IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindTurbineType3or4IECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType3or4IECEntityProjector.class.getName());

}
