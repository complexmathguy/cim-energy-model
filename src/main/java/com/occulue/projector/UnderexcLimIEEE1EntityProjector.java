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
 * Projector for UnderexcLimIEEE1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcLimIEEE1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimIEEE1-entity-projector")
public class UnderexcLimIEEE1EntityProjector {
		
	// core constructor
	public UnderexcLimIEEE1EntityProjector(UnderexcLimIEEE1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcLimIEEE1
	 * 
     * @param	entity UnderexcLimIEEE1
     */
    public UnderexcLimIEEE1 create( UnderexcLimIEEE1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcLimIEEE1
	 * 
     * @param	entity UnderexcLimIEEE1
     */
    public UnderexcLimIEEE1 update( UnderexcLimIEEE1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcLimIEEE1
	 * 
     * @param	id		UUID
     */
    public UnderexcLimIEEE1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcLimIEEE1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcLimIEEE1 via an FindUnderexcLimIEEE1Query
     * @return 	query	FindUnderexcLimIEEE1Query
     */
    @SuppressWarnings("unused")
    public UnderexcLimIEEE1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcLimIEEE1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimIEEE1s
     *
     * @param	query	FindAllUnderexcLimIEEE1Query 
     * @return 	List<UnderexcLimIEEE1> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcLimIEEE1> findAll( FindAllUnderexcLimIEEE1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcLimIEEE1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcLimIEEE1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE1EntityProjector.class.getName());

}
