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
 * Projector for ProprietaryParameterDynamics as outlined for the CQRS pattern.
 * 
 * Commands are handled by ProprietaryParameterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
@Component("proprietaryParameterDynamics-entity-projector")
public class ProprietaryParameterDynamicsEntityProjector {
		
	// core constructor
	public ProprietaryParameterDynamicsEntityProjector(ProprietaryParameterDynamicsRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ProprietaryParameterDynamics
	 * 
     * @param	entity ProprietaryParameterDynamics
     */
    public ProprietaryParameterDynamics create( ProprietaryParameterDynamics entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ProprietaryParameterDynamics
	 * 
     * @param	entity ProprietaryParameterDynamics
     */
    public ProprietaryParameterDynamics update( ProprietaryParameterDynamics entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ProprietaryParameterDynamics
	 * 
     * @param	id		UUID
     */
    public ProprietaryParameterDynamics delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ProprietaryParameterDynamics entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ProprietaryParameterDynamics via an FindProprietaryParameterDynamicsQuery
     * @return 	query	FindProprietaryParameterDynamicsQuery
     */
    @SuppressWarnings("unused")
    public ProprietaryParameterDynamics find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ProprietaryParameterDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ProprietaryParameterDynamicss
     *
     * @param	query	FindAllProprietaryParameterDynamicsQuery 
     * @return 	List<ProprietaryParameterDynamics> 
     */
    @SuppressWarnings("unused")
    public List<ProprietaryParameterDynamics> findAll( FindAllProprietaryParameterDynamicsQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ProprietaryParameterDynamics - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ProprietaryParameterDynamicsRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ProprietaryParameterDynamicsEntityProjector.class.getName());

}
