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
 * Projector for TurbineLoadControllerUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by TurbineLoadControllerUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("turbineLoadControllerUserDefined-entity-projector")
public class TurbineLoadControllerUserDefinedEntityProjector {
		
	// core constructor
	public TurbineLoadControllerUserDefinedEntityProjector(TurbineLoadControllerUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TurbineLoadControllerUserDefined
	 * 
     * @param	entity TurbineLoadControllerUserDefined
     */
    public TurbineLoadControllerUserDefined create( TurbineLoadControllerUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TurbineLoadControllerUserDefined
	 * 
     * @param	entity TurbineLoadControllerUserDefined
     */
    public TurbineLoadControllerUserDefined update( TurbineLoadControllerUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TurbineLoadControllerUserDefined
	 * 
     * @param	id		UUID
     */
    public TurbineLoadControllerUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TurbineLoadControllerUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TurbineLoadControllerUserDefined via an FindTurbineLoadControllerUserDefinedQuery
     * @return 	query	FindTurbineLoadControllerUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public TurbineLoadControllerUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TurbineLoadControllerUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TurbineLoadControllerUserDefineds
     *
     * @param	query	FindAllTurbineLoadControllerUserDefinedQuery 
     * @return 	List<TurbineLoadControllerUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<TurbineLoadControllerUserDefined> findAll( FindAllTurbineLoadControllerUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TurbineLoadControllerUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TurbineLoadControllerUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TurbineLoadControllerUserDefinedEntityProjector.class.getName());

}
