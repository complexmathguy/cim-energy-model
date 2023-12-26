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
 * Projector for WindGenTurbineType1IEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGenTurbineType1IECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType1IEC-entity-projector")
public class WindGenTurbineType1IECEntityProjector {
		
	// core constructor
	public WindGenTurbineType1IECEntityProjector(WindGenTurbineType1IECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGenTurbineType1IEC
	 * 
     * @param	entity WindGenTurbineType1IEC
     */
    public WindGenTurbineType1IEC create( WindGenTurbineType1IEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGenTurbineType1IEC
	 * 
     * @param	entity WindGenTurbineType1IEC
     */
    public WindGenTurbineType1IEC update( WindGenTurbineType1IEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGenTurbineType1IEC
	 * 
     * @param	id		UUID
     */
    public WindGenTurbineType1IEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGenTurbineType1IEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGenTurbineType1IEC via an FindWindGenTurbineType1IECQuery
     * @return 	query	FindWindGenTurbineType1IECQuery
     */
    @SuppressWarnings("unused")
    public WindGenTurbineType1IEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGenTurbineType1IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType1IECs
     *
     * @param	query	FindAllWindGenTurbineType1IECQuery 
     * @return 	List<WindGenTurbineType1IEC> 
     */
    @SuppressWarnings("unused")
    public List<WindGenTurbineType1IEC> findAll( FindAllWindGenTurbineType1IECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGenTurbineType1IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGenTurbineType1IECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType1IECEntityProjector.class.getName());

}
