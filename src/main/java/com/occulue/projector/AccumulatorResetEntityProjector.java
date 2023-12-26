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
 * Projector for AccumulatorReset as outlined for the CQRS pattern.
 * 
 * Commands are handled by AccumulatorResetAggregate
 * 
 * @author your_name_here
 *
 */
@Component("accumulatorReset-entity-projector")
public class AccumulatorResetEntityProjector {
		
	// core constructor
	public AccumulatorResetEntityProjector(AccumulatorResetRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AccumulatorReset
	 * 
     * @param	entity AccumulatorReset
     */
    public AccumulatorReset create( AccumulatorReset entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AccumulatorReset
	 * 
     * @param	entity AccumulatorReset
     */
    public AccumulatorReset update( AccumulatorReset entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AccumulatorReset
	 * 
     * @param	id		UUID
     */
    public AccumulatorReset delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AccumulatorReset entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AccumulatorReset via an FindAccumulatorResetQuery
     * @return 	query	FindAccumulatorResetQuery
     */
    @SuppressWarnings("unused")
    public AccumulatorReset find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AccumulatorReset - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AccumulatorResets
     *
     * @param	query	FindAllAccumulatorResetQuery 
     * @return 	List<AccumulatorReset> 
     */
    @SuppressWarnings("unused")
    public List<AccumulatorReset> findAll( FindAllAccumulatorResetQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AccumulatorReset - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AccumulatorResetRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorResetEntityProjector.class.getName());

}
