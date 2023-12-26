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
 * Projector for PssIEEE4B as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssIEEE4BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE4B-entity-projector")
public class PssIEEE4BEntityProjector {
		
	// core constructor
	public PssIEEE4BEntityProjector(PssIEEE4BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssIEEE4B
	 * 
     * @param	entity PssIEEE4B
     */
    public PssIEEE4B create( PssIEEE4B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssIEEE4B
	 * 
     * @param	entity PssIEEE4B
     */
    public PssIEEE4B update( PssIEEE4B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssIEEE4B
	 * 
     * @param	id		UUID
     */
    public PssIEEE4B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssIEEE4B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssIEEE4B via an FindPssIEEE4BQuery
     * @return 	query	FindPssIEEE4BQuery
     */
    @SuppressWarnings("unused")
    public PssIEEE4B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssIEEE4B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE4Bs
     *
     * @param	query	FindAllPssIEEE4BQuery 
     * @return 	List<PssIEEE4B> 
     */
    @SuppressWarnings("unused")
    public List<PssIEEE4B> findAll( FindAllPssIEEE4BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssIEEE4B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssIEEE4BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE4BEntityProjector.class.getName());

}
