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
 * Projector for ExcELIN2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcELIN2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excELIN2-entity-projector")
public class ExcELIN2EntityProjector {
		
	// core constructor
	public ExcELIN2EntityProjector(ExcELIN2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcELIN2
	 * 
     * @param	entity ExcELIN2
     */
    public ExcELIN2 create( ExcELIN2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcELIN2
	 * 
     * @param	entity ExcELIN2
     */
    public ExcELIN2 update( ExcELIN2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcELIN2
	 * 
     * @param	id		UUID
     */
    public ExcELIN2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcELIN2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcELIN2 via an FindExcELIN2Query
     * @return 	query	FindExcELIN2Query
     */
    @SuppressWarnings("unused")
    public ExcELIN2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcELIN2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcELIN2s
     *
     * @param	query	FindAllExcELIN2Query 
     * @return 	List<ExcELIN2> 
     */
    @SuppressWarnings("unused")
    public List<ExcELIN2> findAll( FindAllExcELIN2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcELIN2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcELIN2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcELIN2EntityProjector.class.getName());

}
