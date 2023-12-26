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
 * Projector for Connector as outlined for the CQRS pattern.
 * 
 * Commands are handled by ConnectorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("connector-entity-projector")
public class ConnectorEntityProjector {
		
	// core constructor
	public ConnectorEntityProjector(ConnectorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Connector
	 * 
     * @param	entity Connector
     */
    public Connector create( Connector entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Connector
	 * 
     * @param	entity Connector
     */
    public Connector update( Connector entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Connector
	 * 
     * @param	id		UUID
     */
    public Connector delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Connector entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Connector via an FindConnectorQuery
     * @return 	query	FindConnectorQuery
     */
    @SuppressWarnings("unused")
    public Connector find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Connector - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Connectors
     *
     * @param	query	FindAllConnectorQuery 
     * @return 	List<Connector> 
     */
    @SuppressWarnings("unused")
    public List<Connector> findAll( FindAllConnectorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Connector - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ConnectorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ConnectorEntityProjector.class.getName());

}
