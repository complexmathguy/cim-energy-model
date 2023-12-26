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
 * Projector for TopologyBoundaryVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by TopologyBoundaryVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("topologyBoundaryVersion-entity-projector")
public class TopologyBoundaryVersionEntityProjector {
		
	// core constructor
	public TopologyBoundaryVersionEntityProjector(TopologyBoundaryVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TopologyBoundaryVersion
	 * 
     * @param	entity TopologyBoundaryVersion
     */
    public TopologyBoundaryVersion create( TopologyBoundaryVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TopologyBoundaryVersion
	 * 
     * @param	entity TopologyBoundaryVersion
     */
    public TopologyBoundaryVersion update( TopologyBoundaryVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TopologyBoundaryVersion
	 * 
     * @param	id		UUID
     */
    public TopologyBoundaryVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TopologyBoundaryVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TopologyBoundaryVersion via an FindTopologyBoundaryVersionQuery
     * @return 	query	FindTopologyBoundaryVersionQuery
     */
    @SuppressWarnings("unused")
    public TopologyBoundaryVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TopologyBoundaryVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TopologyBoundaryVersions
     *
     * @param	query	FindAllTopologyBoundaryVersionQuery 
     * @return 	List<TopologyBoundaryVersion> 
     */
    @SuppressWarnings("unused")
    public List<TopologyBoundaryVersion> findAll( FindAllTopologyBoundaryVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TopologyBoundaryVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TopologyBoundaryVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TopologyBoundaryVersionEntityProjector.class.getName());

}
