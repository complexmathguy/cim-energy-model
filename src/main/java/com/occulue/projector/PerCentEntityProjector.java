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
 * Projector for PerCent as outlined for the CQRS pattern.
 * 
 * Commands are handled by PerCentAggregate
 * 
 * @author your_name_here
 *
 */
@Component("perCent-entity-projector")
public class PerCentEntityProjector {
		
	// core constructor
	public PerCentEntityProjector(PerCentRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PerCent
	 * 
     * @param	entity PerCent
     */
    public PerCent create( PerCent entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PerCent
	 * 
     * @param	entity PerCent
     */
    public PerCent update( PerCent entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PerCent
	 * 
     * @param	id		UUID
     */
    public PerCent delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PerCent entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PerCent via an FindPerCentQuery
     * @return 	query	FindPerCentQuery
     */
    @SuppressWarnings("unused")
    public PerCent find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PerCent - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PerCents
     *
     * @param	query	FindAllPerCentQuery 
     * @return 	List<PerCent> 
     */
    @SuppressWarnings("unused")
    public List<PerCent> findAll( FindAllPerCentQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PerCent - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PerCentRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PerCentEntityProjector.class.getName());

}
