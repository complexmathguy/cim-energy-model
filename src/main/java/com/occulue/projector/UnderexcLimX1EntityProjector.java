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
 * Projector for UnderexcLimX1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcLimX1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimX1-entity-projector")
public class UnderexcLimX1EntityProjector {
		
	// core constructor
	public UnderexcLimX1EntityProjector(UnderexcLimX1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcLimX1
	 * 
     * @param	entity UnderexcLimX1
     */
    public UnderexcLimX1 create( UnderexcLimX1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcLimX1
	 * 
     * @param	entity UnderexcLimX1
     */
    public UnderexcLimX1 update( UnderexcLimX1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcLimX1
	 * 
     * @param	id		UUID
     */
    public UnderexcLimX1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcLimX1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcLimX1 via an FindUnderexcLimX1Query
     * @return 	query	FindUnderexcLimX1Query
     */
    @SuppressWarnings("unused")
    public UnderexcLimX1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcLimX1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimX1s
     *
     * @param	query	FindAllUnderexcLimX1Query 
     * @return 	List<UnderexcLimX1> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcLimX1> findAll( FindAllUnderexcLimX1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcLimX1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcLimX1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimX1EntityProjector.class.getName());

}
