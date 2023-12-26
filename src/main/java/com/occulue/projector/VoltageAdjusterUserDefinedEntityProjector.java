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
 * Projector for VoltageAdjusterUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by VoltageAdjusterUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("voltageAdjusterUserDefined-entity-projector")
public class VoltageAdjusterUserDefinedEntityProjector {
		
	// core constructor
	public VoltageAdjusterUserDefinedEntityProjector(VoltageAdjusterUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VoltageAdjusterUserDefined
	 * 
     * @param	entity VoltageAdjusterUserDefined
     */
    public VoltageAdjusterUserDefined create( VoltageAdjusterUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VoltageAdjusterUserDefined
	 * 
     * @param	entity VoltageAdjusterUserDefined
     */
    public VoltageAdjusterUserDefined update( VoltageAdjusterUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VoltageAdjusterUserDefined
	 * 
     * @param	id		UUID
     */
    public VoltageAdjusterUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VoltageAdjusterUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VoltageAdjusterUserDefined via an FindVoltageAdjusterUserDefinedQuery
     * @return 	query	FindVoltageAdjusterUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public VoltageAdjusterUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VoltageAdjusterUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VoltageAdjusterUserDefineds
     *
     * @param	query	FindAllVoltageAdjusterUserDefinedQuery 
     * @return 	List<VoltageAdjusterUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<VoltageAdjusterUserDefined> findAll( FindAllVoltageAdjusterUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VoltageAdjusterUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VoltageAdjusterUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VoltageAdjusterUserDefinedEntityProjector.class.getName());

}
