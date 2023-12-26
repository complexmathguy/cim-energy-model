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
 * Projector for ConnectivityNodeContainer as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConnectivityNodeContainerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("connectivityNodeContainer-entity-projector")
public class ConnectivityNodeContainerEntityProjector {
		
	// core constructor
	public ConnectivityNodeContainerEntityProjector(ConnectivityNodeContainerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ConnectivityNodeContainer
	 * 
     * @param	entity ConnectivityNodeContainer
     */
    public ConnectivityNodeContainer create( ConnectivityNodeContainer entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ConnectivityNodeContainer
	 * 
     * @param	entity ConnectivityNodeContainer
     */
    public ConnectivityNodeContainer update( ConnectivityNodeContainer entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ConnectivityNodeContainer
	 * 
     * @param	id		UUID
     */
    public ConnectivityNodeContainer delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ConnectivityNodeContainer entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ConnectivityNodeContainer via an FindConnectivityNodeContainerQuery
     * @return 	query	FindConnectivityNodeContainerQuery
     */
    @SuppressWarnings("unused")
    public ConnectivityNodeContainer find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ConnectivityNodeContainer - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ConnectivityNodeContainers
     *
     * @param	query	FindAllConnectivityNodeContainerQuery 
     * @return 	List<ConnectivityNodeContainer> 
     */
    @SuppressWarnings("unused")
    public List<ConnectivityNodeContainer> findAll( FindAllConnectivityNodeContainerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ConnectivityNodeContainer - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConnectivityNodeContainerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConnectivityNodeContainerEntityProjector.class.getName());

}
