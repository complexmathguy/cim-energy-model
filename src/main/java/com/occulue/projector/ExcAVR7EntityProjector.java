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
 * Projector for ExcAVR7 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR7Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR7-entity-projector")
public class ExcAVR7EntityProjector {
		
	// core constructor
	public ExcAVR7EntityProjector(ExcAVR7Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR7
	 * 
     * @param	entity ExcAVR7
     */
    public ExcAVR7 create( ExcAVR7 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR7
	 * 
     * @param	entity ExcAVR7
     */
    public ExcAVR7 update( ExcAVR7 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR7
	 * 
     * @param	id		UUID
     */
    public ExcAVR7 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR7 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR7 via an FindExcAVR7Query
     * @return 	query	FindExcAVR7Query
     */
    @SuppressWarnings("unused")
    public ExcAVR7 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR7 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR7s
     *
     * @param	query	FindAllExcAVR7Query 
     * @return 	List<ExcAVR7> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR7> findAll( FindAllExcAVR7Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR7 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR7Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR7EntityProjector.class.getName());

}
