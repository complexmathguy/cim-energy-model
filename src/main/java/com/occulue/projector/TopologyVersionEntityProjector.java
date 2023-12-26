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
 * Projector for TopologyVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by TopologyVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("topologyVersion-entity-projector")
public class TopologyVersionEntityProjector {
		
	// core constructor
	public TopologyVersionEntityProjector(TopologyVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TopologyVersion
	 * 
     * @param	entity TopologyVersion
     */
    public TopologyVersion create( TopologyVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TopologyVersion
	 * 
     * @param	entity TopologyVersion
     */
    public TopologyVersion update( TopologyVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TopologyVersion
	 * 
     * @param	id		UUID
     */
    public TopologyVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TopologyVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TopologyVersion via an FindTopologyVersionQuery
     * @return 	query	FindTopologyVersionQuery
     */
    @SuppressWarnings("unused")
    public TopologyVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TopologyVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TopologyVersions
     *
     * @param	query	FindAllTopologyVersionQuery 
     * @return 	List<TopologyVersion> 
     */
    @SuppressWarnings("unused")
    public List<TopologyVersion> findAll( FindAllTopologyVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TopologyVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TopologyVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TopologyVersionEntityProjector.class.getName());

}
