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
 * Projector for CsConverter as outlined for the CQRS pattern.
 * 
 * Commands are handled by CsConverterAggregate
 * 
 * @author your_name_here
 *
 */
@Component("csConverter-entity-projector")
public class CsConverterEntityProjector {
		
	// core constructor
	public CsConverterEntityProjector(CsConverterRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a CsConverter
	 * 
     * @param	entity CsConverter
     */
    public CsConverter create( CsConverter entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a CsConverter
	 * 
     * @param	entity CsConverter
     */
    public CsConverter update( CsConverter entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a CsConverter
	 * 
     * @param	id		UUID
     */
    public CsConverter delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    CsConverter entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the CsConverter via an FindCsConverterQuery
     * @return 	query	FindCsConverterQuery
     */
    @SuppressWarnings("unused")
    public CsConverter find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a CsConverter - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all CsConverters
     *
     * @param	query	FindAllCsConverterQuery 
     * @return 	List<CsConverter> 
     */
    @SuppressWarnings("unused")
    public List<CsConverter> findAll( FindAllCsConverterQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all CsConverter - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final CsConverterRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(CsConverterEntityProjector.class.getName());

}
