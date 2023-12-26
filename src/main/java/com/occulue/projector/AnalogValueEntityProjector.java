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
 * Projector for AnalogValue as outlined for the CQRS pattern.
 * 
 * Commands are handled by AnalogValueAggregate
 * 
 * @author your_name_here
 *
 */
@Component("analogValue-entity-projector")
public class AnalogValueEntityProjector {
		
	// core constructor
	public AnalogValueEntityProjector(AnalogValueRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a AnalogValue
	 * 
     * @param	entity AnalogValue
     */
    public AnalogValue create( AnalogValue entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a AnalogValue
	 * 
     * @param	entity AnalogValue
     */
    public AnalogValue update( AnalogValue entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a AnalogValue
	 * 
     * @param	id		UUID
     */
    public AnalogValue delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    AnalogValue entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the AnalogValue via an FindAnalogValueQuery
     * @return 	query	FindAnalogValueQuery
     */
    @SuppressWarnings("unused")
    public AnalogValue find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a AnalogValue - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all AnalogValues
     *
     * @param	query	FindAllAnalogValueQuery 
     * @return 	List<AnalogValue> 
     */
    @SuppressWarnings("unused")
    public List<AnalogValue> findAll( FindAllAnalogValueQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all AnalogValue - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final AnalogValueRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(AnalogValueEntityProjector.class.getName());

}
