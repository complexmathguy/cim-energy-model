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
 * Projector for PssWECC as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssWECCAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssWECC-entity-projector")
public class PssWECCEntityProjector {
		
	// core constructor
	public PssWECCEntityProjector(PssWECCRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssWECC
	 * 
     * @param	entity PssWECC
     */
    public PssWECC create( PssWECC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssWECC
	 * 
     * @param	entity PssWECC
     */
    public PssWECC update( PssWECC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssWECC
	 * 
     * @param	id		UUID
     */
    public PssWECC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssWECC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssWECC via an FindPssWECCQuery
     * @return 	query	FindPssWECCQuery
     */
    @SuppressWarnings("unused")
    public PssWECC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssWECC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssWECCs
     *
     * @param	query	FindAllPssWECCQuery 
     * @return 	List<PssWECC> 
     */
    @SuppressWarnings("unused")
    public List<PssWECC> findAll( FindAllPssWECCQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssWECC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssWECCRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssWECCEntityProjector.class.getName());

}
