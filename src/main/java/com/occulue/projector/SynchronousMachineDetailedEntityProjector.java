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
 * Projector for SynchronousMachineDetailed as outlined for the CQRS pattern.
 * 
 * Commands are handled by SynchronousMachineDetailedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("synchronousMachineDetailed-entity-projector")
public class SynchronousMachineDetailedEntityProjector {
		
	// core constructor
	public SynchronousMachineDetailedEntityProjector(SynchronousMachineDetailedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SynchronousMachineDetailed
	 * 
     * @param	entity SynchronousMachineDetailed
     */
    public SynchronousMachineDetailed create( SynchronousMachineDetailed entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SynchronousMachineDetailed
	 * 
     * @param	entity SynchronousMachineDetailed
     */
    public SynchronousMachineDetailed update( SynchronousMachineDetailed entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SynchronousMachineDetailed
	 * 
     * @param	id		UUID
     */
    public SynchronousMachineDetailed delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SynchronousMachineDetailed entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SynchronousMachineDetailed via an FindSynchronousMachineDetailedQuery
     * @return 	query	FindSynchronousMachineDetailedQuery
     */
    @SuppressWarnings("unused")
    public SynchronousMachineDetailed find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SynchronousMachineDetailed - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineDetaileds
     *
     * @param	query	FindAllSynchronousMachineDetailedQuery 
     * @return 	List<SynchronousMachineDetailed> 
     */
    @SuppressWarnings("unused")
    public List<SynchronousMachineDetailed> findAll( FindAllSynchronousMachineDetailedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SynchronousMachineDetailed - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SynchronousMachineDetailedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineDetailedEntityProjector.class.getName());

}
