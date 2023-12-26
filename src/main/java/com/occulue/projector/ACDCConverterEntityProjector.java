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
 * Projector for ACDCConverter as outlined for the CQRS pattern.
 * 
 * Commands are handled by ACDCConverterAggregate
 * 
 * @author your_name_here
 *
 */
@Component("aCDCConverter-entity-projector")
public class ACDCConverterEntityProjector {
		
	// core constructor
	public ACDCConverterEntityProjector(ACDCConverterRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ACDCConverter
	 * 
     * @param	entity ACDCConverter
     */
    public ACDCConverter create( ACDCConverter entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ACDCConverter
	 * 
     * @param	entity ACDCConverter
     */
    public ACDCConverter update( ACDCConverter entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ACDCConverter
	 * 
     * @param	id		UUID
     */
    public ACDCConverter delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ACDCConverter entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ACDCConverter via an FindACDCConverterQuery
     * @return 	query	FindACDCConverterQuery
     */
    @SuppressWarnings("unused")
    public ACDCConverter find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ACDCConverter - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ACDCConverters
     *
     * @param	query	FindAllACDCConverterQuery 
     * @return 	List<ACDCConverter> 
     */
    @SuppressWarnings("unused")
    public List<ACDCConverter> findAll( FindAllACDCConverterQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ACDCConverter - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ACDCConverterRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ACDCConverterEntityProjector.class.getName());

}
