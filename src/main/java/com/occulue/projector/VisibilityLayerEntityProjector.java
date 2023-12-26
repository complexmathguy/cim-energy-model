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
 * Projector for VisibilityLayer as outlined for the CQRS pattern.
 * 
 * Commands are handled by VisibilityLayerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("visibilityLayer-entity-projector")
public class VisibilityLayerEntityProjector {
		
	// core constructor
	public VisibilityLayerEntityProjector(VisibilityLayerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VisibilityLayer
	 * 
     * @param	entity VisibilityLayer
     */
    public VisibilityLayer create( VisibilityLayer entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VisibilityLayer
	 * 
     * @param	entity VisibilityLayer
     */
    public VisibilityLayer update( VisibilityLayer entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VisibilityLayer
	 * 
     * @param	id		UUID
     */
    public VisibilityLayer delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VisibilityLayer entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VisibilityLayer via an FindVisibilityLayerQuery
     * @return 	query	FindVisibilityLayerQuery
     */
    @SuppressWarnings("unused")
    public VisibilityLayer find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VisibilityLayer - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VisibilityLayers
     *
     * @param	query	FindAllVisibilityLayerQuery 
     * @return 	List<VisibilityLayer> 
     */
    @SuppressWarnings("unused")
    public List<VisibilityLayer> findAll( FindAllVisibilityLayerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VisibilityLayer - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VisibilityLayerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VisibilityLayerEntityProjector.class.getName());

}
