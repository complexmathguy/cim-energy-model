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
 * Projector for UnderexcLimX2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcLimX2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimX2-entity-projector")
public class UnderexcLimX2EntityProjector {
		
	// core constructor
	public UnderexcLimX2EntityProjector(UnderexcLimX2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcLimX2
	 * 
     * @param	entity UnderexcLimX2
     */
    public UnderexcLimX2 create( UnderexcLimX2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcLimX2
	 * 
     * @param	entity UnderexcLimX2
     */
    public UnderexcLimX2 update( UnderexcLimX2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcLimX2
	 * 
     * @param	id		UUID
     */
    public UnderexcLimX2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcLimX2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcLimX2 via an FindUnderexcLimX2Query
     * @return 	query	FindUnderexcLimX2Query
     */
    @SuppressWarnings("unused")
    public UnderexcLimX2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcLimX2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimX2s
     *
     * @param	query	FindAllUnderexcLimX2Query 
     * @return 	List<UnderexcLimX2> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcLimX2> findAll( FindAllUnderexcLimX2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcLimX2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcLimX2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimX2EntityProjector.class.getName());

}
