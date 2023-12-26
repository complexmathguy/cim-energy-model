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
 * Projector for Frequency as outlined for the CQRS pattern.
 * 
 * Commands are handled by FrequencyAggregate
 * 
 * @author your_name_here
 *
 */
@Component("frequency-entity-projector")
public class FrequencyEntityProjector {
		
	// core constructor
	public FrequencyEntityProjector(FrequencyRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Frequency
	 * 
     * @param	entity Frequency
     */
    public Frequency create( Frequency entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Frequency
	 * 
     * @param	entity Frequency
     */
    public Frequency update( Frequency entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Frequency
	 * 
     * @param	id		UUID
     */
    public Frequency delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Frequency entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Frequency via an FindFrequencyQuery
     * @return 	query	FindFrequencyQuery
     */
    @SuppressWarnings("unused")
    public Frequency find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Frequency - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Frequencys
     *
     * @param	query	FindAllFrequencyQuery 
     * @return 	List<Frequency> 
     */
    @SuppressWarnings("unused")
    public List<Frequency> findAll( FindAllFrequencyQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Frequency - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final FrequencyRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(FrequencyEntityProjector.class.getName());

}
