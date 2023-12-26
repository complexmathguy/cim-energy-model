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
 * Projector for PssIEEE2B as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssIEEE2BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE2B-entity-projector")
public class PssIEEE2BEntityProjector {
		
	// core constructor
	public PssIEEE2BEntityProjector(PssIEEE2BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssIEEE2B
	 * 
     * @param	entity PssIEEE2B
     */
    public PssIEEE2B create( PssIEEE2B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssIEEE2B
	 * 
     * @param	entity PssIEEE2B
     */
    public PssIEEE2B update( PssIEEE2B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssIEEE2B
	 * 
     * @param	id		UUID
     */
    public PssIEEE2B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssIEEE2B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssIEEE2B via an FindPssIEEE2BQuery
     * @return 	query	FindPssIEEE2BQuery
     */
    @SuppressWarnings("unused")
    public PssIEEE2B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssIEEE2B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE2Bs
     *
     * @param	query	FindAllPssIEEE2BQuery 
     * @return 	List<PssIEEE2B> 
     */
    @SuppressWarnings("unused")
    public List<PssIEEE2B> findAll( FindAllPssIEEE2BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssIEEE2B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssIEEE2BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE2BEntityProjector.class.getName());

}
