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
 * Projector for ExternalNetworkInjection as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExternalNetworkInjectionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("externalNetworkInjection-entity-projector")
public class ExternalNetworkInjectionEntityProjector {
		
	// core constructor
	public ExternalNetworkInjectionEntityProjector(ExternalNetworkInjectionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExternalNetworkInjection
	 * 
     * @param	entity ExternalNetworkInjection
     */
    public ExternalNetworkInjection create( ExternalNetworkInjection entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExternalNetworkInjection
	 * 
     * @param	entity ExternalNetworkInjection
     */
    public ExternalNetworkInjection update( ExternalNetworkInjection entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExternalNetworkInjection
	 * 
     * @param	id		UUID
     */
    public ExternalNetworkInjection delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExternalNetworkInjection entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExternalNetworkInjection via an FindExternalNetworkInjectionQuery
     * @return 	query	FindExternalNetworkInjectionQuery
     */
    @SuppressWarnings("unused")
    public ExternalNetworkInjection find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExternalNetworkInjection - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExternalNetworkInjections
     *
     * @param	query	FindAllExternalNetworkInjectionQuery 
     * @return 	List<ExternalNetworkInjection> 
     */
    @SuppressWarnings("unused")
    public List<ExternalNetworkInjection> findAll( FindAllExternalNetworkInjectionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExternalNetworkInjection - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExternalNetworkInjectionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExternalNetworkInjectionEntityProjector.class.getName());

}
