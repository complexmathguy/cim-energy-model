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
 * Projector for UnderexcLim2Simplified as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcLim2SimplifiedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcLim2Simplified-entity-projector")
public class UnderexcLim2SimplifiedEntityProjector {
		
	// core constructor
	public UnderexcLim2SimplifiedEntityProjector(UnderexcLim2SimplifiedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcLim2Simplified
	 * 
     * @param	entity UnderexcLim2Simplified
     */
    public UnderexcLim2Simplified create( UnderexcLim2Simplified entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcLim2Simplified
	 * 
     * @param	entity UnderexcLim2Simplified
     */
    public UnderexcLim2Simplified update( UnderexcLim2Simplified entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcLim2Simplified
	 * 
     * @param	id		UUID
     */
    public UnderexcLim2Simplified delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcLim2Simplified entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcLim2Simplified via an FindUnderexcLim2SimplifiedQuery
     * @return 	query	FindUnderexcLim2SimplifiedQuery
     */
    @SuppressWarnings("unused")
    public UnderexcLim2Simplified find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcLim2Simplified - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLim2Simplifieds
     *
     * @param	query	FindAllUnderexcLim2SimplifiedQuery 
     * @return 	List<UnderexcLim2Simplified> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcLim2Simplified> findAll( FindAllUnderexcLim2SimplifiedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcLim2Simplified - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcLim2SimplifiedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLim2SimplifiedEntityProjector.class.getName());

}
