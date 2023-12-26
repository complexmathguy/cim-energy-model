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
 * Projector for EnergySchedulingType as outlined for the CQRS pattern.
 * 
 * Commands are handled by EnergySchedulingTypeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("energySchedulingType-entity-projector")
public class EnergySchedulingTypeEntityProjector {
		
	// core constructor
	public EnergySchedulingTypeEntityProjector(EnergySchedulingTypeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EnergySchedulingType
	 * 
     * @param	entity EnergySchedulingType
     */
    public EnergySchedulingType create( EnergySchedulingType entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EnergySchedulingType
	 * 
     * @param	entity EnergySchedulingType
     */
    public EnergySchedulingType update( EnergySchedulingType entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EnergySchedulingType
	 * 
     * @param	id		UUID
     */
    public EnergySchedulingType delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EnergySchedulingType entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EnergySchedulingType via an FindEnergySchedulingTypeQuery
     * @return 	query	FindEnergySchedulingTypeQuery
     */
    @SuppressWarnings("unused")
    public EnergySchedulingType find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EnergySchedulingType - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EnergySchedulingTypes
     *
     * @param	query	FindAllEnergySchedulingTypeQuery 
     * @return 	List<EnergySchedulingType> 
     */
    @SuppressWarnings("unused")
    public List<EnergySchedulingType> findAll( FindAllEnergySchedulingTypeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EnergySchedulingType - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EnergySchedulingTypeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EnergySchedulingTypeEntityProjector.class.getName());

}
