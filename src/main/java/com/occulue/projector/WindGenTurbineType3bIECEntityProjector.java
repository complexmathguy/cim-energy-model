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
 * Projector for WindGenTurbineType3bIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGenTurbineType3bIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType3bIEC-entity-projector")
public class WindGenTurbineType3bIECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3bIECEntityProjector(WindGenTurbineType3bIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGenTurbineType3bIEC
	 * 
     * @param	entity WindGenTurbineType3bIEC
     */
    public WindGenTurbineType3bIEC create( WindGenTurbineType3bIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGenTurbineType3bIEC
	 * 
     * @param	entity WindGenTurbineType3bIEC
     */
    public WindGenTurbineType3bIEC update( WindGenTurbineType3bIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGenTurbineType3bIEC
	 * 
     * @param	id		UUID
     */
    public WindGenTurbineType3bIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGenTurbineType3bIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGenTurbineType3bIEC via an FindWindGenTurbineType3bIECQuery
     * @return 	query	FindWindGenTurbineType3bIECQuery
     */
    @SuppressWarnings("unused")
    public WindGenTurbineType3bIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGenTurbineType3bIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3bIECs
     *
     * @param	query	FindAllWindGenTurbineType3bIECQuery 
     * @return 	List<WindGenTurbineType3bIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindGenTurbineType3bIEC> findAll( FindAllWindGenTurbineType3bIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGenTurbineType3bIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGenTurbineType3bIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3bIECEntityProjector.class.getName());

}
