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
 * Projector for EquivalentShunt as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquivalentShuntAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equivalentShunt-entity-projector")
public class EquivalentShuntEntityProjector {
		
	// core constructor
	public EquivalentShuntEntityProjector(EquivalentShuntRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquivalentShunt
	 * 
     * @param	entity EquivalentShunt
     */
    public EquivalentShunt create( EquivalentShunt entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquivalentShunt
	 * 
     * @param	entity EquivalentShunt
     */
    public EquivalentShunt update( EquivalentShunt entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquivalentShunt
	 * 
     * @param	id		UUID
     */
    public EquivalentShunt delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquivalentShunt entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquivalentShunt via an FindEquivalentShuntQuery
     * @return 	query	FindEquivalentShuntQuery
     */
    @SuppressWarnings("unused")
    public EquivalentShunt find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquivalentShunt - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquivalentShunts
     *
     * @param	query	FindAllEquivalentShuntQuery 
     * @return 	List<EquivalentShunt> 
     */
    @SuppressWarnings("unused")
    public List<EquivalentShunt> findAll( FindAllEquivalentShuntQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquivalentShunt - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquivalentShuntRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentShuntEntityProjector.class.getName());

}
