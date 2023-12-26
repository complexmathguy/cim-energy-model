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
 * Projector for Quality61850 as outlined for the CQRS pattern.
 * 
 * Commands are handled by Quality61850Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("quality61850-entity-projector")
public class Quality61850EntityProjector {
		
	// core constructor
	public Quality61850EntityProjector(Quality61850Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Quality61850
	 * 
     * @param	entity Quality61850
     */
    public Quality61850 create( Quality61850 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Quality61850
	 * 
     * @param	entity Quality61850
     */
    public Quality61850 update( Quality61850 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Quality61850
	 * 
     * @param	id		UUID
     */
    public Quality61850 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Quality61850 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Quality61850 via an FindQuality61850Query
     * @return 	query	FindQuality61850Query
     */
    @SuppressWarnings("unused")
    public Quality61850 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Quality61850 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Quality61850s
     *
     * @param	query	FindAllQuality61850Query 
     * @return 	List<Quality61850> 
     */
    @SuppressWarnings("unused")
    public List<Quality61850> findAll( FindAllQuality61850Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Quality61850 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Quality61850Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Quality61850EntityProjector.class.getName());

}
