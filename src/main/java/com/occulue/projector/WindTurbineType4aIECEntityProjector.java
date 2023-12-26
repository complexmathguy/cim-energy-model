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
 * Projector for WindTurbineType4aIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindTurbineType4aIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windTurbineType4aIEC-entity-projector")
public class WindTurbineType4aIECEntityProjector {
		
	// core constructor
	public WindTurbineType4aIECEntityProjector(WindTurbineType4aIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindTurbineType4aIEC
	 * 
     * @param	entity WindTurbineType4aIEC
     */
    public WindTurbineType4aIEC create( WindTurbineType4aIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindTurbineType4aIEC
	 * 
     * @param	entity WindTurbineType4aIEC
     */
    public WindTurbineType4aIEC update( WindTurbineType4aIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindTurbineType4aIEC
	 * 
     * @param	id		UUID
     */
    public WindTurbineType4aIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindTurbineType4aIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindTurbineType4aIEC via an FindWindTurbineType4aIECQuery
     * @return 	query	FindWindTurbineType4aIECQuery
     */
    @SuppressWarnings("unused")
    public WindTurbineType4aIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindTurbineType4aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindTurbineType4aIECs
     *
     * @param	query	FindAllWindTurbineType4aIECQuery 
     * @return 	List<WindTurbineType4aIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindTurbineType4aIEC> findAll( FindAllWindTurbineType4aIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindTurbineType4aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindTurbineType4aIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindTurbineType4aIECEntityProjector.class.getName());

}
