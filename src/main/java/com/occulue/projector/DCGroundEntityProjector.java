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
 * Projector for DCGround as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCGroundAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCGround-entity-projector")
public class DCGroundEntityProjector {
		
	// core constructor
	public DCGroundEntityProjector(DCGroundRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCGround
	 * 
     * @param	entity DCGround
     */
    public DCGround create( DCGround entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCGround
	 * 
     * @param	entity DCGround
     */
    public DCGround update( DCGround entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCGround
	 * 
     * @param	id		UUID
     */
    public DCGround delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCGround entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCGround via an FindDCGroundQuery
     * @return 	query	FindDCGroundQuery
     */
    @SuppressWarnings("unused")
    public DCGround find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCGround - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCGrounds
     *
     * @param	query	FindAllDCGroundQuery 
     * @return 	List<DCGround> 
     */
    @SuppressWarnings("unused")
    public List<DCGround> findAll( FindAllDCGroundQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCGround - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCGroundRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCGroundEntityProjector.class.getName());

}
