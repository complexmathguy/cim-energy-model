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
 * Projector for ENTSOETopologicalNode as outlined for the CQRS pattern.
 * 
 * Commands are handled by ENTSOETopologicalNodeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("eNTSOETopologicalNode-entity-projector")
public class ENTSOETopologicalNodeEntityProjector {
		
	// core constructor
	public ENTSOETopologicalNodeEntityProjector(ENTSOETopologicalNodeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ENTSOETopologicalNode
	 * 
     * @param	entity ENTSOETopologicalNode
     */
    public ENTSOETopologicalNode create( ENTSOETopologicalNode entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ENTSOETopologicalNode
	 * 
     * @param	entity ENTSOETopologicalNode
     */
    public ENTSOETopologicalNode update( ENTSOETopologicalNode entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ENTSOETopologicalNode
	 * 
     * @param	id		UUID
     */
    public ENTSOETopologicalNode delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ENTSOETopologicalNode entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ENTSOETopologicalNode via an FindENTSOETopologicalNodeQuery
     * @return 	query	FindENTSOETopologicalNodeQuery
     */
    @SuppressWarnings("unused")
    public ENTSOETopologicalNode find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ENTSOETopologicalNode - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ENTSOETopologicalNodes
     *
     * @param	query	FindAllENTSOETopologicalNodeQuery 
     * @return 	List<ENTSOETopologicalNode> 
     */
    @SuppressWarnings("unused")
    public List<ENTSOETopologicalNode> findAll( FindAllENTSOETopologicalNodeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ENTSOETopologicalNode - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ENTSOETopologicalNodeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ENTSOETopologicalNodeEntityProjector.class.getName());

}
