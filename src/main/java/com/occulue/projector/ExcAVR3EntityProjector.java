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
 * Projector for ExcAVR3 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR3Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR3-entity-projector")
public class ExcAVR3EntityProjector {
		
	// core constructor
	public ExcAVR3EntityProjector(ExcAVR3Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR3
	 * 
     * @param	entity ExcAVR3
     */
    public ExcAVR3 create( ExcAVR3 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR3
	 * 
     * @param	entity ExcAVR3
     */
    public ExcAVR3 update( ExcAVR3 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR3
	 * 
     * @param	id		UUID
     */
    public ExcAVR3 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR3 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR3 via an FindExcAVR3Query
     * @return 	query	FindExcAVR3Query
     */
    @SuppressWarnings("unused")
    public ExcAVR3 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR3 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR3s
     *
     * @param	query	FindAllExcAVR3Query 
     * @return 	List<ExcAVR3> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR3> findAll( FindAllExcAVR3Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR3 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR3Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR3EntityProjector.class.getName());

}
