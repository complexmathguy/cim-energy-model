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
 * Projector for PssIEEE1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssIEEE1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE1A-entity-projector")
public class PssIEEE1AEntityProjector {
		
	// core constructor
	public PssIEEE1AEntityProjector(PssIEEE1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssIEEE1A
	 * 
     * @param	entity PssIEEE1A
     */
    public PssIEEE1A create( PssIEEE1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssIEEE1A
	 * 
     * @param	entity PssIEEE1A
     */
    public PssIEEE1A update( PssIEEE1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssIEEE1A
	 * 
     * @param	id		UUID
     */
    public PssIEEE1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssIEEE1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssIEEE1A via an FindPssIEEE1AQuery
     * @return 	query	FindPssIEEE1AQuery
     */
    @SuppressWarnings("unused")
    public PssIEEE1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssIEEE1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE1As
     *
     * @param	query	FindAllPssIEEE1AQuery 
     * @return 	List<PssIEEE1A> 
     */
    @SuppressWarnings("unused")
    public List<PssIEEE1A> findAll( FindAllPssIEEE1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssIEEE1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssIEEE1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE1AEntityProjector.class.getName());

}
