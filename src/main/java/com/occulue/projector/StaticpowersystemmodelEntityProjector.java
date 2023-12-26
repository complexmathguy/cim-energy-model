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
 * Projector for Staticpowersystemmodel as outlined for the CQRS pattern.
 * 
 * Commands are handled by StaticpowersystemmodelAggregate
 * 
 * @author your_name_here
 *
 */
@Component("staticpowersystemmodel-entity-projector")
public class StaticpowersystemmodelEntityProjector {
		
	// core constructor
	public StaticpowersystemmodelEntityProjector(StaticpowersystemmodelRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Staticpowersystemmodel
	 * 
     * @param	entity Staticpowersystemmodel
     */
    public Staticpowersystemmodel create( Staticpowersystemmodel entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Staticpowersystemmodel
	 * 
     * @param	entity Staticpowersystemmodel
     */
    public Staticpowersystemmodel update( Staticpowersystemmodel entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Staticpowersystemmodel
	 * 
     * @param	id		UUID
     */
    public Staticpowersystemmodel delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Staticpowersystemmodel entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Staticpowersystemmodel via an FindStaticpowersystemmodelQuery
     * @return 	query	FindStaticpowersystemmodelQuery
     */
    @SuppressWarnings("unused")
    public Staticpowersystemmodel find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Staticpowersystemmodel - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Staticpowersystemmodels
     *
     * @param	query	FindAllStaticpowersystemmodelQuery 
     * @return 	List<Staticpowersystemmodel> 
     */
    @SuppressWarnings("unused")
    public List<Staticpowersystemmodel> findAll( FindAllStaticpowersystemmodelQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Staticpowersystemmodel - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final StaticpowersystemmodelRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(StaticpowersystemmodelEntityProjector.class.getName());

}
