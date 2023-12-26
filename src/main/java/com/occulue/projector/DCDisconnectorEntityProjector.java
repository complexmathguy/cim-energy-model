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
 * Projector for DCDisconnector as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCDisconnectorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCDisconnector-entity-projector")
public class DCDisconnectorEntityProjector {
		
	// core constructor
	public DCDisconnectorEntityProjector(DCDisconnectorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCDisconnector
	 * 
     * @param	entity DCDisconnector
     */
    public DCDisconnector create( DCDisconnector entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCDisconnector
	 * 
     * @param	entity DCDisconnector
     */
    public DCDisconnector update( DCDisconnector entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCDisconnector
	 * 
     * @param	id		UUID
     */
    public DCDisconnector delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCDisconnector entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCDisconnector via an FindDCDisconnectorQuery
     * @return 	query	FindDCDisconnectorQuery
     */
    @SuppressWarnings("unused")
    public DCDisconnector find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCDisconnector - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCDisconnectors
     *
     * @param	query	FindAllDCDisconnectorQuery 
     * @return 	List<DCDisconnector> 
     */
    @SuppressWarnings("unused")
    public List<DCDisconnector> findAll( FindAllDCDisconnectorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCDisconnector - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCDisconnectorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCDisconnectorEntityProjector.class.getName());

}
