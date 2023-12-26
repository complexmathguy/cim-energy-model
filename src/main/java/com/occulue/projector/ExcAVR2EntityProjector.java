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
 * Projector for ExcAVR2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcAVR2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("excAVR2-entity-projector")
public class ExcAVR2EntityProjector {
		
	// core constructor
	public ExcAVR2EntityProjector(ExcAVR2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcAVR2
	 * 
     * @param	entity ExcAVR2
     */
    public ExcAVR2 create( ExcAVR2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcAVR2
	 * 
     * @param	entity ExcAVR2
     */
    public ExcAVR2 update( ExcAVR2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcAVR2
	 * 
     * @param	id		UUID
     */
    public ExcAVR2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcAVR2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcAVR2 via an FindExcAVR2Query
     * @return 	query	FindExcAVR2Query
     */
    @SuppressWarnings("unused")
    public ExcAVR2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcAVR2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR2s
     *
     * @param	query	FindAllExcAVR2Query 
     * @return 	List<ExcAVR2> 
     */
    @SuppressWarnings("unused")
    public List<ExcAVR2> findAll( FindAllExcAVR2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcAVR2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcAVR2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR2EntityProjector.class.getName());

}
