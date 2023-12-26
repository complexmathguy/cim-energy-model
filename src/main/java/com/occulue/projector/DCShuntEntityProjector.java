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
 * Projector for DCShunt as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCShuntAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCShunt-entity-projector")
public class DCShuntEntityProjector {
		
	// core constructor
	public DCShuntEntityProjector(DCShuntRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCShunt
	 * 
     * @param	entity DCShunt
     */
    public DCShunt create( DCShunt entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCShunt
	 * 
     * @param	entity DCShunt
     */
    public DCShunt update( DCShunt entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCShunt
	 * 
     * @param	id		UUID
     */
    public DCShunt delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCShunt entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCShunt via an FindDCShuntQuery
     * @return 	query	FindDCShuntQuery
     */
    @SuppressWarnings("unused")
    public DCShunt find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCShunt - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCShunts
     *
     * @param	query	FindAllDCShuntQuery 
     * @return 	List<DCShunt> 
     */
    @SuppressWarnings("unused")
    public List<DCShunt> findAll( FindAllDCShuntQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCShunt - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCShuntRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCShuntEntityProjector.class.getName());

}
