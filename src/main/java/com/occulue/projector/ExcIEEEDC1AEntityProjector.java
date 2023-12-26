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
 * Projector for ExcIEEEDC1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEDC1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEDC1A-entity-projector")
public class ExcIEEEDC1AEntityProjector {
		
	// core constructor
	public ExcIEEEDC1AEntityProjector(ExcIEEEDC1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEDC1A
	 * 
     * @param	entity ExcIEEEDC1A
     */
    public ExcIEEEDC1A create( ExcIEEEDC1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEDC1A
	 * 
     * @param	entity ExcIEEEDC1A
     */
    public ExcIEEEDC1A update( ExcIEEEDC1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEDC1A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEDC1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEDC1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEDC1A via an FindExcIEEEDC1AQuery
     * @return 	query	FindExcIEEEDC1AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEDC1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEDC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC1As
     *
     * @param	query	FindAllExcIEEEDC1AQuery 
     * @return 	List<ExcIEEEDC1A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEDC1A> findAll( FindAllExcIEEEDC1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEDC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEDC1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC1AEntityProjector.class.getName());

}
