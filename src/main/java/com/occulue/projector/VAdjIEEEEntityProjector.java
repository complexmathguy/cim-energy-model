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
 * Projector for VAdjIEEE as outlined for the CQRS pattern.
 * 
 * Commands are handled by VAdjIEEEAggregate
 * 
 * @author your_name_here
 *
 */
@Component("vAdjIEEE-entity-projector")
public class VAdjIEEEEntityProjector {
		
	// core constructor
	public VAdjIEEEEntityProjector(VAdjIEEERepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VAdjIEEE
	 * 
     * @param	entity VAdjIEEE
     */
    public VAdjIEEE create( VAdjIEEE entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VAdjIEEE
	 * 
     * @param	entity VAdjIEEE
     */
    public VAdjIEEE update( VAdjIEEE entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VAdjIEEE
	 * 
     * @param	id		UUID
     */
    public VAdjIEEE delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VAdjIEEE entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VAdjIEEE via an FindVAdjIEEEQuery
     * @return 	query	FindVAdjIEEEQuery
     */
    @SuppressWarnings("unused")
    public VAdjIEEE find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VAdjIEEE - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VAdjIEEEs
     *
     * @param	query	FindAllVAdjIEEEQuery 
     * @return 	List<VAdjIEEE> 
     */
    @SuppressWarnings("unused")
    public List<VAdjIEEE> findAll( FindAllVAdjIEEEQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VAdjIEEE - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VAdjIEEERepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VAdjIEEEEntityProjector.class.getName());

}
