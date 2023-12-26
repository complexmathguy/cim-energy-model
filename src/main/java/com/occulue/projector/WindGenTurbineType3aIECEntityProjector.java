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
 * Projector for WindGenTurbineType3aIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGenTurbineType3aIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGenTurbineType3aIEC-entity-projector")
public class WindGenTurbineType3aIECEntityProjector {
		
	// core constructor
	public WindGenTurbineType3aIECEntityProjector(WindGenTurbineType3aIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGenTurbineType3aIEC
	 * 
     * @param	entity WindGenTurbineType3aIEC
     */
    public WindGenTurbineType3aIEC create( WindGenTurbineType3aIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGenTurbineType3aIEC
	 * 
     * @param	entity WindGenTurbineType3aIEC
     */
    public WindGenTurbineType3aIEC update( WindGenTurbineType3aIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGenTurbineType3aIEC
	 * 
     * @param	id		UUID
     */
    public WindGenTurbineType3aIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGenTurbineType3aIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGenTurbineType3aIEC via an FindWindGenTurbineType3aIECQuery
     * @return 	query	FindWindGenTurbineType3aIECQuery
     */
    @SuppressWarnings("unused")
    public WindGenTurbineType3aIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGenTurbineType3aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGenTurbineType3aIECs
     *
     * @param	query	FindAllWindGenTurbineType3aIECQuery 
     * @return 	List<WindGenTurbineType3aIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindGenTurbineType3aIEC> findAll( FindAllWindGenTurbineType3aIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGenTurbineType3aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGenTurbineType3aIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenTurbineType3aIECEntityProjector.class.getName());

}
