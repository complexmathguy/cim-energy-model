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
 * Projector for LoadArea as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadAreaAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadArea-entity-projector")
public class LoadAreaEntityProjector {
		
	// core constructor
	public LoadAreaEntityProjector(LoadAreaRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadArea
	 * 
     * @param	entity LoadArea
     */
    public LoadArea create( LoadArea entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadArea
	 * 
     * @param	entity LoadArea
     */
    public LoadArea update( LoadArea entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadArea
	 * 
     * @param	id		UUID
     */
    public LoadArea delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadArea entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadArea via an FindLoadAreaQuery
     * @return 	query	FindLoadAreaQuery
     */
    @SuppressWarnings("unused")
    public LoadArea find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadArea - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadAreas
     *
     * @param	query	FindAllLoadAreaQuery 
     * @return 	List<LoadArea> 
     */
    @SuppressWarnings("unused")
    public List<LoadArea> findAll( FindAllLoadAreaQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadArea - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadAreaRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadAreaEntityProjector.class.getName());

}
