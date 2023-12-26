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
 * Projector for MeasurementValueQuality as outlined for the CQRS pattern.
 * 
 * Commands are handled by MeasurementValueQualityAggregate
 * 
 * @author your_name_here
 *
 */
@Component("measurementValueQuality-entity-projector")
public class MeasurementValueQualityEntityProjector {
		
	// core constructor
	public MeasurementValueQualityEntityProjector(MeasurementValueQualityRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a MeasurementValueQuality
	 * 
     * @param	entity MeasurementValueQuality
     */
    public MeasurementValueQuality create( MeasurementValueQuality entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a MeasurementValueQuality
	 * 
     * @param	entity MeasurementValueQuality
     */
    public MeasurementValueQuality update( MeasurementValueQuality entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a MeasurementValueQuality
	 * 
     * @param	id		UUID
     */
    public MeasurementValueQuality delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    MeasurementValueQuality entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the MeasurementValueQuality via an FindMeasurementValueQualityQuery
     * @return 	query	FindMeasurementValueQualityQuery
     */
    @SuppressWarnings("unused")
    public MeasurementValueQuality find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a MeasurementValueQuality - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all MeasurementValueQualitys
     *
     * @param	query	FindAllMeasurementValueQualityQuery 
     * @return 	List<MeasurementValueQuality> 
     */
    @SuppressWarnings("unused")
    public List<MeasurementValueQuality> findAll( FindAllMeasurementValueQualityQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all MeasurementValueQuality - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final MeasurementValueQualityRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueQualityEntityProjector.class.getName());

}
