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
 * Projector for Voltage as outlined for the CQRS pattern.
 * 
 * Commands are handled by VoltageAggregate
 * 
 * @author your_name_here
 *
 */
@Component("voltage-entity-projector")
public class VoltageEntityProjector {
		
	// core constructor
	public VoltageEntityProjector(VoltageRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Voltage
	 * 
     * @param	entity Voltage
     */
    public Voltage create( Voltage entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Voltage
	 * 
     * @param	entity Voltage
     */
    public Voltage update( Voltage entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Voltage
	 * 
     * @param	id		UUID
     */
    public Voltage delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Voltage entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Voltage via an FindVoltageQuery
     * @return 	query	FindVoltageQuery
     */
    @SuppressWarnings("unused")
    public Voltage find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Voltage - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Voltages
     *
     * @param	query	FindAllVoltageQuery 
     * @return 	List<Voltage> 
     */
    @SuppressWarnings("unused")
    public List<Voltage> findAll( FindAllVoltageQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Voltage - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VoltageRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageEntityProjector.class.getName());

}
