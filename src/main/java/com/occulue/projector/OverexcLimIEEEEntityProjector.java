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
 * Projector for OverexcLimIEEE as outlined for the CQRS pattern.
 * 
 * Commands are handled by OverexcLimIEEEAggregate
 * 
 * @author your_name_here
 *
 */
@Component("overexcLimIEEE-entity-projector")
public class OverexcLimIEEEEntityProjector {
		
	// core constructor
	public OverexcLimIEEEEntityProjector(OverexcLimIEEERepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a OverexcLimIEEE
	 * 
     * @param	entity OverexcLimIEEE
     */
    public OverexcLimIEEE create( OverexcLimIEEE entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a OverexcLimIEEE
	 * 
     * @param	entity OverexcLimIEEE
     */
    public OverexcLimIEEE update( OverexcLimIEEE entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a OverexcLimIEEE
	 * 
     * @param	id		UUID
     */
    public OverexcLimIEEE delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    OverexcLimIEEE entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the OverexcLimIEEE via an FindOverexcLimIEEEQuery
     * @return 	query	FindOverexcLimIEEEQuery
     */
    @SuppressWarnings("unused")
    public OverexcLimIEEE find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a OverexcLimIEEE - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all OverexcLimIEEEs
     *
     * @param	query	FindAllOverexcLimIEEEQuery 
     * @return 	List<OverexcLimIEEE> 
     */
    @SuppressWarnings("unused")
    public List<OverexcLimIEEE> findAll( FindAllOverexcLimIEEEQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all OverexcLimIEEE - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final OverexcLimIEEERepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimIEEEEntityProjector.class.getName());

}
