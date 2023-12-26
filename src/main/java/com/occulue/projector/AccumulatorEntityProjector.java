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
 * Projector for Accumulator as outlined for the CQRS pattern.
 * 
 * Commands are handled by AccumulatorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("accumulator-entity-projector")
public class AccumulatorEntityProjector {
		
	// core constructor
	public AccumulatorEntityProjector(AccumulatorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Accumulator
	 * 
     * @param	entity Accumulator
     */
    public Accumulator create( Accumulator entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Accumulator
	 * 
     * @param	entity Accumulator
     */
    public Accumulator update( Accumulator entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Accumulator
	 * 
     * @param	id		UUID
     */
    public Accumulator delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Accumulator entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Accumulator via an FindAccumulatorQuery
     * @return 	query	FindAccumulatorQuery
     */
    @SuppressWarnings("unused")
    public Accumulator find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Accumulator - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Accumulators
     *
     * @param	query	FindAllAccumulatorQuery 
     * @return 	List<Accumulator> 
     */
    @SuppressWarnings("unused")
    public List<Accumulator> findAll( FindAllAccumulatorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Accumulator - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AccumulatorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorEntityProjector.class.getName());

}
