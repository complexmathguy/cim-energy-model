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
 * Projector for ExcAVR1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR1-entity-projector")
public class ExcAVR1EntityProjector {
		
	// core constructor
	public ExcAVR1EntityProjector(ExcAVR1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR1
	 * 
     * @param	entity ExcAVR1
     */
    public ExcAVR1 create( ExcAVR1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR1
	 * 
     * @param	entity ExcAVR1
     */
    public ExcAVR1 update( ExcAVR1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR1
	 * 
     * @param	id		UUID
     */
    public ExcAVR1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR1 via an FindExcAVR1Query
     * @return 	query	FindExcAVR1Query
     */
    @SuppressWarnings("unused")
    public ExcAVR1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR1s
     *
     * @param	query	FindAllExcAVR1Query 
     * @return 	List<ExcAVR1> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR1> findAll( FindAllExcAVR1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR1EntityProjector.class.getName());

}
