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
 * Projector for DiscreteValue as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiscreteValueAggregate
 * 
 * @author your_name_here
 *
 */
@Component("discreteValue-entity-projector")
public class DiscreteValueEntityProjector {
		
	// core constructor
	public DiscreteValueEntityProjector(DiscreteValueRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiscreteValue
	 * 
     * @param	entity DiscreteValue
     */
    public DiscreteValue create( DiscreteValue entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiscreteValue
	 * 
     * @param	entity DiscreteValue
     */
    public DiscreteValue update( DiscreteValue entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiscreteValue
	 * 
     * @param	id		UUID
     */
    public DiscreteValue delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiscreteValue entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiscreteValue via an FindDiscreteValueQuery
     * @return 	query	FindDiscreteValueQuery
     */
    @SuppressWarnings("unused")
    public DiscreteValue find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiscreteValue - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiscreteValues
     *
     * @param	query	FindAllDiscreteValueQuery 
     * @return 	List<DiscreteValue> 
     */
    @SuppressWarnings("unused")
    public List<DiscreteValue> findAll( FindAllDiscreteValueQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiscreteValue - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiscreteValueRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiscreteValueEntityProjector.class.getName());

}
