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
 * Projector for ExcBBC as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcBBCAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excBBC-entity-projector")
public class ExcBBCEntityProjector {
		
	// core constructor
	public ExcBBCEntityProjector(ExcBBCRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcBBC
	 * 
     * @param	entity ExcBBC
     */
    public ExcBBC create( ExcBBC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcBBC
	 * 
     * @param	entity ExcBBC
     */
    public ExcBBC update( ExcBBC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcBBC
	 * 
     * @param	id		UUID
     */
    public ExcBBC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcBBC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcBBC via an FindExcBBCQuery
     * @return 	query	FindExcBBCQuery
     */
    @SuppressWarnings("unused")
    public ExcBBC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcBBC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcBBCs
     *
     * @param	query	FindAllExcBBCQuery 
     * @return 	List<ExcBBC> 
     */
    @SuppressWarnings("unused")
    public List<ExcBBC> findAll( FindAllExcBBCQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcBBC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcBBCRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcBBCEntityProjector.class.getName());

}
