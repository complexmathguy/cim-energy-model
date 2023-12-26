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
 * Projector for ExcSCRX as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcSCRXAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excSCRX-entity-projector")
public class ExcSCRXEntityProjector {
		
	// core constructor
	public ExcSCRXEntityProjector(ExcSCRXRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcSCRX
	 * 
     * @param	entity ExcSCRX
     */
    public ExcSCRX create( ExcSCRX entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcSCRX
	 * 
     * @param	entity ExcSCRX
     */
    public ExcSCRX update( ExcSCRX entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcSCRX
	 * 
     * @param	id		UUID
     */
    public ExcSCRX delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcSCRX entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcSCRX via an FindExcSCRXQuery
     * @return 	query	FindExcSCRXQuery
     */
    @SuppressWarnings("unused")
    public ExcSCRX find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcSCRX - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcSCRXs
     *
     * @param	query	FindAllExcSCRXQuery 
     * @return 	List<ExcSCRX> 
     */
    @SuppressWarnings("unused")
    public List<ExcSCRX> findAll( FindAllExcSCRXQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcSCRX - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcSCRXRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSCRXEntityProjector.class.getName());

}
