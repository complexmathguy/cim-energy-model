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
 * Projector for LinearShuntCompensator as outlined for the CQRS pattern.
 * 
 * Commands are handled by LinearShuntCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("linearShuntCompensator-entity-projector")
public class LinearShuntCompensatorEntityProjector {
		
	// core constructor
	public LinearShuntCompensatorEntityProjector(LinearShuntCompensatorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LinearShuntCompensator
	 * 
     * @param	entity LinearShuntCompensator
     */
    public LinearShuntCompensator create( LinearShuntCompensator entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LinearShuntCompensator
	 * 
     * @param	entity LinearShuntCompensator
     */
    public LinearShuntCompensator update( LinearShuntCompensator entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LinearShuntCompensator
	 * 
     * @param	id		UUID
     */
    public LinearShuntCompensator delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LinearShuntCompensator entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LinearShuntCompensator via an FindLinearShuntCompensatorQuery
     * @return 	query	FindLinearShuntCompensatorQuery
     */
    @SuppressWarnings("unused")
    public LinearShuntCompensator find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LinearShuntCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LinearShuntCompensators
     *
     * @param	query	FindAllLinearShuntCompensatorQuery 
     * @return 	List<LinearShuntCompensator> 
     */
    @SuppressWarnings("unused")
    public List<LinearShuntCompensator> findAll( FindAllLinearShuntCompensatorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LinearShuntCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LinearShuntCompensatorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LinearShuntCompensatorEntityProjector.class.getName());

}
