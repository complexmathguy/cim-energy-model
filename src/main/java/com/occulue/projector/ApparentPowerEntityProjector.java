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
 * Projector for ApparentPower as outlined for the CQRS pattern.
 * 
 * Commands are handled by ApparentPowerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("apparentPower-entity-projector")
public class ApparentPowerEntityProjector {
		
	// core constructor
	public ApparentPowerEntityProjector(ApparentPowerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ApparentPower
	 * 
     * @param	entity ApparentPower
     */
    public ApparentPower create( ApparentPower entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ApparentPower
	 * 
     * @param	entity ApparentPower
     */
    public ApparentPower update( ApparentPower entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ApparentPower
	 * 
     * @param	id		UUID
     */
    public ApparentPower delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ApparentPower entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ApparentPower via an FindApparentPowerQuery
     * @return 	query	FindApparentPowerQuery
     */
    @SuppressWarnings("unused")
    public ApparentPower find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ApparentPower - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ApparentPowers
     *
     * @param	query	FindAllApparentPowerQuery 
     * @return 	List<ApparentPower> 
     */
    @SuppressWarnings("unused")
    public List<ApparentPower> findAll( FindAllApparentPowerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ApparentPower - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ApparentPowerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ApparentPowerEntityProjector.class.getName());

}
