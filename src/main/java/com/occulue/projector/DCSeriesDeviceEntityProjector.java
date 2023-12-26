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
 * Projector for DCSeriesDevice as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCSeriesDeviceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCSeriesDevice-entity-projector")
public class DCSeriesDeviceEntityProjector {
		
	// core constructor
	public DCSeriesDeviceEntityProjector(DCSeriesDeviceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCSeriesDevice
	 * 
     * @param	entity DCSeriesDevice
     */
    public DCSeriesDevice create( DCSeriesDevice entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCSeriesDevice
	 * 
     * @param	entity DCSeriesDevice
     */
    public DCSeriesDevice update( DCSeriesDevice entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCSeriesDevice
	 * 
     * @param	id		UUID
     */
    public DCSeriesDevice delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCSeriesDevice entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCSeriesDevice via an FindDCSeriesDeviceQuery
     * @return 	query	FindDCSeriesDeviceQuery
     */
    @SuppressWarnings("unused")
    public DCSeriesDevice find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCSeriesDevice - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCSeriesDevices
     *
     * @param	query	FindAllDCSeriesDeviceQuery 
     * @return 	List<DCSeriesDevice> 
     */
    @SuppressWarnings("unused")
    public List<DCSeriesDevice> findAll( FindAllDCSeriesDeviceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCSeriesDevice - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCSeriesDeviceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCSeriesDeviceEntityProjector.class.getName());

}
