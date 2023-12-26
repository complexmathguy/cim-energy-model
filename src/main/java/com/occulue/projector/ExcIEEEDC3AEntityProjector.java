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
 * Projector for ExcIEEEDC3A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEDC3AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEDC3A-entity-projector")
public class ExcIEEEDC3AEntityProjector {
		
	// core constructor
	public ExcIEEEDC3AEntityProjector(ExcIEEEDC3ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEDC3A
	 * 
     * @param	entity ExcIEEEDC3A
     */
    public ExcIEEEDC3A create( ExcIEEEDC3A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEDC3A
	 * 
     * @param	entity ExcIEEEDC3A
     */
    public ExcIEEEDC3A update( ExcIEEEDC3A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEDC3A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEDC3A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEDC3A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEDC3A via an FindExcIEEEDC3AQuery
     * @return 	query	FindExcIEEEDC3AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEDC3A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEDC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC3As
     *
     * @param	query	FindAllExcIEEEDC3AQuery 
     * @return 	List<ExcIEEEDC3A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEDC3A> findAll( FindAllExcIEEEDC3AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEDC3A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEDC3ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC3AEntityProjector.class.getName());

}
