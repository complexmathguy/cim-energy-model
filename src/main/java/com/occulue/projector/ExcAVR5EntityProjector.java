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
 * Projector for ExcAVR5 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR5Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR5-entity-projector")
public class ExcAVR5EntityProjector {
		
	// core constructor
	public ExcAVR5EntityProjector(ExcAVR5Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR5
	 * 
     * @param	entity ExcAVR5
     */
    public ExcAVR5 create( ExcAVR5 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR5
	 * 
     * @param	entity ExcAVR5
     */
    public ExcAVR5 update( ExcAVR5 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR5
	 * 
     * @param	id		UUID
     */
    public ExcAVR5 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR5 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR5 via an FindExcAVR5Query
     * @return 	query	FindExcAVR5Query
     */
    @SuppressWarnings("unused")
    public ExcAVR5 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR5 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR5s
     *
     * @param	query	FindAllExcAVR5Query 
     * @return 	List<ExcAVR5> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR5> findAll( FindAllExcAVR5Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR5 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR5Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR5EntityProjector.class.getName());

}
