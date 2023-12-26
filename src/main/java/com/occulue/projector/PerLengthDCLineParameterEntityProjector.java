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
 * Projector for PerLengthDCLineParameter as outlined for the CQRS pattern.
 * 
 * Commands are handled by PerLengthDCLineParameterAggregate
 * 
 * @author your_name_here
 *
 */
@Component("perLengthDCLineParameter-entity-projector")
public class PerLengthDCLineParameterEntityProjector {
		
	// core constructor
	public PerLengthDCLineParameterEntityProjector(PerLengthDCLineParameterRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PerLengthDCLineParameter
	 * 
     * @param	entity PerLengthDCLineParameter
     */
    public PerLengthDCLineParameter create( PerLengthDCLineParameter entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PerLengthDCLineParameter
	 * 
     * @param	entity PerLengthDCLineParameter
     */
    public PerLengthDCLineParameter update( PerLengthDCLineParameter entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PerLengthDCLineParameter
	 * 
     * @param	id		UUID
     */
    public PerLengthDCLineParameter delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PerLengthDCLineParameter entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PerLengthDCLineParameter via an FindPerLengthDCLineParameterQuery
     * @return 	query	FindPerLengthDCLineParameterQuery
     */
    @SuppressWarnings("unused")
    public PerLengthDCLineParameter find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PerLengthDCLineParameter - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PerLengthDCLineParameters
     *
     * @param	query	FindAllPerLengthDCLineParameterQuery 
     * @return 	List<PerLengthDCLineParameter> 
     */
    @SuppressWarnings("unused")
    public List<PerLengthDCLineParameter> findAll( FindAllPerLengthDCLineParameterQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PerLengthDCLineParameter - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PerLengthDCLineParameterRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PerLengthDCLineParameterEntityProjector.class.getName());

}
