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
 * Projector for ExcIEEEDC2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcIEEEDC2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excIEEEDC2A-entity-projector")
public class ExcIEEEDC2AEntityProjector {
		
	// core constructor
	public ExcIEEEDC2AEntityProjector(ExcIEEEDC2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcIEEEDC2A
	 * 
     * @param	entity ExcIEEEDC2A
     */
    public ExcIEEEDC2A create( ExcIEEEDC2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcIEEEDC2A
	 * 
     * @param	entity ExcIEEEDC2A
     */
    public ExcIEEEDC2A update( ExcIEEEDC2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcIEEEDC2A
	 * 
     * @param	id		UUID
     */
    public ExcIEEEDC2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcIEEEDC2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcIEEEDC2A via an FindExcIEEEDC2AQuery
     * @return 	query	FindExcIEEEDC2AQuery
     */
    @SuppressWarnings("unused")
    public ExcIEEEDC2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcIEEEDC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC2As
     *
     * @param	query	FindAllExcIEEEDC2AQuery 
     * @return 	List<ExcIEEEDC2A> 
     */
    @SuppressWarnings("unused")
    public List<ExcIEEEDC2A> findAll( FindAllExcIEEEDC2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcIEEEDC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcIEEEDC2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC2AEntityProjector.class.getName());

}
