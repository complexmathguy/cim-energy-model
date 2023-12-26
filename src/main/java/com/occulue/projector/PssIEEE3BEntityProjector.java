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
 * Projector for PssIEEE3B as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssIEEE3BAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssIEEE3B-entity-projector")
public class PssIEEE3BEntityProjector {
		
	// core constructor
	public PssIEEE3BEntityProjector(PssIEEE3BRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssIEEE3B
	 * 
     * @param	entity PssIEEE3B
     */
    public PssIEEE3B create( PssIEEE3B entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssIEEE3B
	 * 
     * @param	entity PssIEEE3B
     */
    public PssIEEE3B update( PssIEEE3B entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssIEEE3B
	 * 
     * @param	id		UUID
     */
    public PssIEEE3B delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssIEEE3B entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssIEEE3B via an FindPssIEEE3BQuery
     * @return 	query	FindPssIEEE3BQuery
     */
    @SuppressWarnings("unused")
    public PssIEEE3B find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssIEEE3B - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE3Bs
     *
     * @param	query	FindAllPssIEEE3BQuery 
     * @return 	List<PssIEEE3B> 
     */
    @SuppressWarnings("unused")
    public List<PssIEEE3B> findAll( FindAllPssIEEE3BQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssIEEE3B - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssIEEE3BRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE3BEntityProjector.class.getName());

}
