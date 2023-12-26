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
 * Projector for DCBusbar as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCBusbarAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCBusbar-entity-projector")
public class DCBusbarEntityProjector {
		
	// core constructor
	public DCBusbarEntityProjector(DCBusbarRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCBusbar
	 * 
     * @param	entity DCBusbar
     */
    public DCBusbar create( DCBusbar entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCBusbar
	 * 
     * @param	entity DCBusbar
     */
    public DCBusbar update( DCBusbar entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCBusbar
	 * 
     * @param	id		UUID
     */
    public DCBusbar delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCBusbar entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCBusbar via an FindDCBusbarQuery
     * @return 	query	FindDCBusbarQuery
     */
    @SuppressWarnings("unused")
    public DCBusbar find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCBusbar - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCBusbars
     *
     * @param	query	FindAllDCBusbarQuery 
     * @return 	List<DCBusbar> 
     */
    @SuppressWarnings("unused")
    public List<DCBusbar> findAll( FindAllDCBusbarQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCBusbar - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCBusbarRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCBusbarEntityProjector.class.getName());

}
