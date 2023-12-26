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
 * Projector for WindGenTurbineType3IEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGenTurbineType3IECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType3IEC-entity-projector")
public class WindGenTurbineType3IECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3IECEntityProjector(WindGenTurbineType3IECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGenTurbineType3IEC
	 * 
     * @param	entity WindGenTurbineType3IEC
     */
    public WindGenTurbineType3IEC create( WindGenTurbineType3IEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGenTurbineType3IEC
	 * 
     * @param	entity WindGenTurbineType3IEC
     */
    public WindGenTurbineType3IEC update( WindGenTurbineType3IEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGenTurbineType3IEC
	 * 
     * @param	id		UUID
     */
    public WindGenTurbineType3IEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGenTurbineType3IEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGenTurbineType3IEC via an FindWindGenTurbineType3IECQuery
     * @return 	query	FindWindGenTurbineType3IECQuery
     */
    @SuppressWarnings("unused")
    public WindGenTurbineType3IEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGenTurbineType3IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3IECs
     *
     * @param	query	FindAllWindGenTurbineType3IECQuery 
     * @return 	List<WindGenTurbineType3IEC> 
     */
    @SuppressWarnings("unused")
    public List<WindGenTurbineType3IEC> findAll( FindAllWindGenTurbineType3IECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGenTurbineType3IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGenTurbineType3IECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3IECEntityProjector.class.getName());

}
