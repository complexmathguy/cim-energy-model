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
 * Projector for OverexcLimX2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by OverexcLimX2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("overexcLimX2-entity-projector")
public class OverexcLimX2EntityProjector {
		
	// core constructor
	public OverexcLimX2EntityProjector(OverexcLimX2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a OverexcLimX2
	 * 
     * @param	entity OverexcLimX2
     */
    public OverexcLimX2 create( OverexcLimX2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a OverexcLimX2
	 * 
     * @param	entity OverexcLimX2
     */
    public OverexcLimX2 update( OverexcLimX2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a OverexcLimX2
	 * 
     * @param	id		UUID
     */
    public OverexcLimX2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    OverexcLimX2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the OverexcLimX2 via an FindOverexcLimX2Query
     * @return 	query	FindOverexcLimX2Query
     */
    @SuppressWarnings("unused")
    public OverexcLimX2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a OverexcLimX2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all OverexcLimX2s
     *
     * @param	query	FindAllOverexcLimX2Query 
     * @return 	List<OverexcLimX2> 
     */
    @SuppressWarnings("unused")
    public List<OverexcLimX2> findAll( FindAllOverexcLimX2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all OverexcLimX2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final OverexcLimX2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimX2EntityProjector.class.getName());

}
