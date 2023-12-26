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
 * Projector for UnderexcitationLimiterUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by UnderexcitationLimiterUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("underexcitationLimiterUserDefined-entity-projector")
public class UnderexcitationLimiterUserDefinedEntityProjector {
		
	// core constructor
	public UnderexcitationLimiterUserDefinedEntityProjector(UnderexcitationLimiterUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a UnderexcitationLimiterUserDefined
	 * 
     * @param	entity UnderexcitationLimiterUserDefined
     */
    public UnderexcitationLimiterUserDefined create( UnderexcitationLimiterUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a UnderexcitationLimiterUserDefined
	 * 
     * @param	entity UnderexcitationLimiterUserDefined
     */
    public UnderexcitationLimiterUserDefined update( UnderexcitationLimiterUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a UnderexcitationLimiterUserDefined
	 * 
     * @param	id		UUID
     */
    public UnderexcitationLimiterUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    UnderexcitationLimiterUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the UnderexcitationLimiterUserDefined via an FindUnderexcitationLimiterUserDefinedQuery
     * @return 	query	FindUnderexcitationLimiterUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public UnderexcitationLimiterUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a UnderexcitationLimiterUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all UnderexcitationLimiterUserDefineds
     *
     * @param	query	FindAllUnderexcitationLimiterUserDefinedQuery 
     * @return 	List<UnderexcitationLimiterUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<UnderexcitationLimiterUserDefined> findAll( FindAllUnderexcitationLimiterUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all UnderexcitationLimiterUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final UnderexcitationLimiterUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(UnderexcitationLimiterUserDefinedEntityProjector.class.getName());

}
