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
 * Projector for DCNode as outlined for the CQRS pattern.
 * 
 * Commands are handled by DCNodeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dCNode-entity-projector")
public class DCNodeEntityProjector {
		
	// core constructor
	public DCNodeEntityProjector(DCNodeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DCNode
	 * 
     * @param	entity DCNode
     */
    public DCNode create( DCNode entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DCNode
	 * 
     * @param	entity DCNode
     */
    public DCNode update( DCNode entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DCNode
	 * 
     * @param	id		UUID
     */
    public DCNode delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DCNode entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DCNode via an FindDCNodeQuery
     * @return 	query	FindDCNodeQuery
     */
    @SuppressWarnings("unused")
    public DCNode find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DCNode - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DCNodes
     *
     * @param	query	FindAllDCNodeQuery 
     * @return 	List<DCNode> 
     */
    @SuppressWarnings("unused")
    public List<DCNode> findAll( FindAllDCNodeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DCNode - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DCNodeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DCNodeEntityProjector.class.getName());

}
