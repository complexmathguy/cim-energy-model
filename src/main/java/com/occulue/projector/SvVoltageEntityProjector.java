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
 * Projector for SvVoltage as outlined for the CQRS pattern.
 * 
 * Commands are handled by SvVoltageAggregate
 * 
 * @author your_name_here
 *
 */
@Component("svVoltage-entity-projector")
public class SvVoltageEntityProjector {
		
	// core constructor
	public SvVoltageEntityProjector(SvVoltageRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SvVoltage
	 * 
     * @param	entity SvVoltage
     */
    public SvVoltage create( SvVoltage entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SvVoltage
	 * 
     * @param	entity SvVoltage
     */
    public SvVoltage update( SvVoltage entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SvVoltage
	 * 
     * @param	id		UUID
     */
    public SvVoltage delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SvVoltage entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SvVoltage via an FindSvVoltageQuery
     * @return 	query	FindSvVoltageQuery
     */
    @SuppressWarnings("unused")
    public SvVoltage find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SvVoltage - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SvVoltages
     *
     * @param	query	FindAllSvVoltageQuery 
     * @return 	List<SvVoltage> 
     */
    @SuppressWarnings("unused")
    public List<SvVoltage> findAll( FindAllSvVoltageQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SvVoltage - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SvVoltageRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SvVoltageEntityProjector.class.getName());

}
