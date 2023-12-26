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
 * Projector for Resistance as outlined for the CQRS pattern.
 * 
 * Commands are handled by ResistanceAggregate
 * 
 * @author your_name_here
 *
 */
@Component("resistance-entity-projector")
public class ResistanceEntityProjector {
		
	// core constructor
	public ResistanceEntityProjector(ResistanceRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Resistance
	 * 
     * @param	entity Resistance
     */
    public Resistance create( Resistance entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Resistance
	 * 
     * @param	entity Resistance
     */
    public Resistance update( Resistance entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Resistance
	 * 
     * @param	id		UUID
     */
    public Resistance delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Resistance entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Resistance via an FindResistanceQuery
     * @return 	query	FindResistanceQuery
     */
    @SuppressWarnings("unused")
    public Resistance find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Resistance - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Resistances
     *
     * @param	query	FindAllResistanceQuery 
     * @return 	List<Resistance> 
     */
    @SuppressWarnings("unused")
    public List<Resistance> findAll( FindAllResistanceQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Resistance - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ResistanceRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ResistanceEntityProjector.class.getName());

}
