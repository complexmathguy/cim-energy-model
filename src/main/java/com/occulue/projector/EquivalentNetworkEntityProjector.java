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
 * Projector for EquivalentNetwork as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquivalentNetworkAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equivalentNetwork-entity-projector")
public class EquivalentNetworkEntityProjector {
		
	// core constructor
	public EquivalentNetworkEntityProjector(EquivalentNetworkRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquivalentNetwork
	 * 
     * @param	entity EquivalentNetwork
     */
    public EquivalentNetwork create( EquivalentNetwork entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquivalentNetwork
	 * 
     * @param	entity EquivalentNetwork
     */
    public EquivalentNetwork update( EquivalentNetwork entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquivalentNetwork
	 * 
     * @param	id		UUID
     */
    public EquivalentNetwork delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquivalentNetwork entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquivalentNetwork via an FindEquivalentNetworkQuery
     * @return 	query	FindEquivalentNetworkQuery
     */
    @SuppressWarnings("unused")
    public EquivalentNetwork find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquivalentNetwork - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquivalentNetworks
     *
     * @param	query	FindAllEquivalentNetworkQuery 
     * @return 	List<EquivalentNetwork> 
     */
    @SuppressWarnings("unused")
    public List<EquivalentNetwork> findAll( FindAllEquivalentNetworkQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquivalentNetwork - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquivalentNetworkRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentNetworkEntityProjector.class.getName());

}
