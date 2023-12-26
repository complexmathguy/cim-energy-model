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
 * Projector for ExcAVR4 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR4Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR4-entity-projector")
public class ExcAVR4EntityProjector {
		
	// core constructor
	public ExcAVR4EntityProjector(ExcAVR4Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR4
	 * 
     * @param	entity ExcAVR4
     */
    public ExcAVR4 create( ExcAVR4 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR4
	 * 
     * @param	entity ExcAVR4
     */
    public ExcAVR4 update( ExcAVR4 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR4
	 * 
     * @param	id		UUID
     */
    public ExcAVR4 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR4 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR4 via an FindExcAVR4Query
     * @return 	query	FindExcAVR4Query
     */
    @SuppressWarnings("unused")
    public ExcAVR4 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR4 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR4s
     *
     * @param	query	FindAllExcAVR4Query 
     * @return 	List<ExcAVR4> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR4> findAll( FindAllExcAVR4Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR4 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR4Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR4EntityProjector.class.getName());

}
