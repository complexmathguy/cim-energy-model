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
 * Projector for ApparentPowerLimit as outlined for the CQRS pattern.
 * 
 * Commands are handled by ApparentPowerLimitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("apparentPowerLimit-entity-projector")
public class ApparentPowerLimitEntityProjector {
		
	// core constructor
	public ApparentPowerLimitEntityProjector(ApparentPowerLimitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ApparentPowerLimit
	 * 
     * @param	entity ApparentPowerLimit
     */
    public ApparentPowerLimit create( ApparentPowerLimit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ApparentPowerLimit
	 * 
     * @param	entity ApparentPowerLimit
     */
    public ApparentPowerLimit update( ApparentPowerLimit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ApparentPowerLimit
	 * 
     * @param	id		UUID
     */
    public ApparentPowerLimit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ApparentPowerLimit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ApparentPowerLimit via an FindApparentPowerLimitQuery
     * @return 	query	FindApparentPowerLimitQuery
     */
    @SuppressWarnings("unused")
    public ApparentPowerLimit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ApparentPowerLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ApparentPowerLimits
     *
     * @param	query	FindAllApparentPowerLimitQuery 
     * @return 	List<ApparentPowerLimit> 
     */
    @SuppressWarnings("unused")
    public List<ApparentPowerLimit> findAll( FindAllApparentPowerLimitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ApparentPowerLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ApparentPowerLimitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ApparentPowerLimitEntityProjector.class.getName());

}
