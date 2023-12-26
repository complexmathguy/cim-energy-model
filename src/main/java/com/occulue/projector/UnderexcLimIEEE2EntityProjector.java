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
 * Projector for UnderexcLimIEEE2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcLimIEEE2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcLimIEEE2-entity-projector")
public class UnderexcLimIEEE2EntityProjector {
		
	// core constructor
	public UnderexcLimIEEE2EntityProjector(UnderexcLimIEEE2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcLimIEEE2
	 * 
     * @param	entity UnderexcLimIEEE2
     */
    public UnderexcLimIEEE2 create( UnderexcLimIEEE2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcLimIEEE2
	 * 
     * @param	entity UnderexcLimIEEE2
     */
    public UnderexcLimIEEE2 update( UnderexcLimIEEE2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcLimIEEE2
	 * 
     * @param	id		UUID
     */
    public UnderexcLimIEEE2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcLimIEEE2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcLimIEEE2 via an FindUnderexcLimIEEE2Query
     * @return 	query	FindUnderexcLimIEEE2Query
     */
    @SuppressWarnings("unused")
    public UnderexcLimIEEE2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcLimIEEE2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimIEEE2s
     *
     * @param	query	FindAllUnderexcLimIEEE2Query 
     * @return 	List<UnderexcLimIEEE2> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcLimIEEE2> findAll( FindAllUnderexcLimIEEE2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcLimIEEE2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcLimIEEE2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimIEEE2EntityProjector.class.getName());

}
