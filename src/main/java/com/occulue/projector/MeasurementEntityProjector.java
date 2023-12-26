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
 * Projector for Measurement as outlined for the CQRS pattern.
 * 
 * Commands are handled by MeasurementAggregate
 * 
 * @author your_name_here
 *
 */
@Component("measurement-entity-projector")
public class MeasurementEntityProjector {
		
	// core constructor
	public MeasurementEntityProjector(MeasurementRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Measurement
	 * 
     * @param	entity Measurement
     */
    public Measurement create( Measurement entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Measurement
	 * 
     * @param	entity Measurement
     */
    public Measurement update( Measurement entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Measurement
	 * 
     * @param	id		UUID
     */
    public Measurement delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Measurement entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Measurement via an FindMeasurementQuery
     * @return 	query	FindMeasurementQuery
     */
    @SuppressWarnings("unused")
    public Measurement find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Measurement - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Measurements
     *
     * @param	query	FindAllMeasurementQuery 
     * @return 	List<Measurement> 
     */
    @SuppressWarnings("unused")
    public List<Measurement> findAll( FindAllMeasurementQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Measurement - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final MeasurementRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(MeasurementEntityProjector.class.getName());

}
