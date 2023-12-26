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
 * Projector for ExcitationSystemUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcitationSystemUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excitationSystemUserDefined-entity-projector")
public class ExcitationSystemUserDefinedEntityProjector {
		
	// core constructor
	public ExcitationSystemUserDefinedEntityProjector(ExcitationSystemUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcitationSystemUserDefined
	 * 
     * @param	entity ExcitationSystemUserDefined
     */
    public ExcitationSystemUserDefined create( ExcitationSystemUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcitationSystemUserDefined
	 * 
     * @param	entity ExcitationSystemUserDefined
     */
    public ExcitationSystemUserDefined update( ExcitationSystemUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcitationSystemUserDefined
	 * 
     * @param	id		UUID
     */
    public ExcitationSystemUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcitationSystemUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcitationSystemUserDefined via an FindExcitationSystemUserDefinedQuery
     * @return 	query	FindExcitationSystemUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public ExcitationSystemUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcitationSystemUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcitationSystemUserDefineds
     *
     * @param	query	FindAllExcitationSystemUserDefinedQuery 
     * @return 	List<ExcitationSystemUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<ExcitationSystemUserDefined> findAll( FindAllExcitationSystemUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcitationSystemUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcitationSystemUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcitationSystemUserDefinedEntityProjector.class.getName());

}
