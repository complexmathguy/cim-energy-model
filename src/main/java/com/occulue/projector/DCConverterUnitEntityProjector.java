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
 * Projector for DCConverterUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCConverterUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCConverterUnit-entity-projector")
public class DCConverterUnitEntityProjector {
		
	// core constructor
	public DCConverterUnitEntityProjector(DCConverterUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCConverterUnit
	 * 
     * @param	entity DCConverterUnit
     */
    public DCConverterUnit create( DCConverterUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCConverterUnit
	 * 
     * @param	entity DCConverterUnit
     */
    public DCConverterUnit update( DCConverterUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCConverterUnit
	 * 
     * @param	id		UUID
     */
    public DCConverterUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCConverterUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCConverterUnit via an FindDCConverterUnitQuery
     * @return 	query	FindDCConverterUnitQuery
     */
    @SuppressWarnings("unused")
    public DCConverterUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCConverterUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCConverterUnits
     *
     * @param	query	FindAllDCConverterUnitQuery 
     * @return 	List<DCConverterUnit> 
     */
    @SuppressWarnings("unused")
    public List<DCConverterUnit> findAll( FindAllDCConverterUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCConverterUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCConverterUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCConverterUnitEntityProjector.class.getName());

}
