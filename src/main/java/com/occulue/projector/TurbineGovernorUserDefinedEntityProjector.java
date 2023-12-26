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
 * Projector for TurbineGovernorUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by TurbineGovernorUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("turbineGovernorUserDefined-entity-projector")
public class TurbineGovernorUserDefinedEntityProjector {
		
	// core constructor
	public TurbineGovernorUserDefinedEntityProjector(TurbineGovernorUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TurbineGovernorUserDefined
	 * 
     * @param	entity TurbineGovernorUserDefined
     */
    public TurbineGovernorUserDefined create( TurbineGovernorUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TurbineGovernorUserDefined
	 * 
     * @param	entity TurbineGovernorUserDefined
     */
    public TurbineGovernorUserDefined update( TurbineGovernorUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TurbineGovernorUserDefined
	 * 
     * @param	id		UUID
     */
    public TurbineGovernorUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TurbineGovernorUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TurbineGovernorUserDefined via an FindTurbineGovernorUserDefinedQuery
     * @return 	query	FindTurbineGovernorUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public TurbineGovernorUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TurbineGovernorUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TurbineGovernorUserDefineds
     *
     * @param	query	FindAllTurbineGovernorUserDefinedQuery 
     * @return 	List<TurbineGovernorUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<TurbineGovernorUserDefined> findAll( FindAllTurbineGovernorUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TurbineGovernorUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TurbineGovernorUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TurbineGovernorUserDefinedEntityProjector.class.getName());

}
