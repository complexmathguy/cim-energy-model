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
 * Projector for NonlinearShuntCompensator as outlined for the CQRS pattern.
 * 
 * Commands are handled by NonlinearShuntCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("nonlinearShuntCompensator-entity-projector")
public class NonlinearShuntCompensatorEntityProjector {
		
	// core constructor
	public NonlinearShuntCompensatorEntityProjector(NonlinearShuntCompensatorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a NonlinearShuntCompensator
	 * 
     * @param	entity NonlinearShuntCompensator
     */
    public NonlinearShuntCompensator create( NonlinearShuntCompensator entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a NonlinearShuntCompensator
	 * 
     * @param	entity NonlinearShuntCompensator
     */
    public NonlinearShuntCompensator update( NonlinearShuntCompensator entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a NonlinearShuntCompensator
	 * 
     * @param	id		UUID
     */
    public NonlinearShuntCompensator delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    NonlinearShuntCompensator entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the NonlinearShuntCompensator via an FindNonlinearShuntCompensatorQuery
     * @return 	query	FindNonlinearShuntCompensatorQuery
     */
    @SuppressWarnings("unused")
    public NonlinearShuntCompensator find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a NonlinearShuntCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all NonlinearShuntCompensators
     *
     * @param	query	FindAllNonlinearShuntCompensatorQuery 
     * @return 	List<NonlinearShuntCompensator> 
     */
    @SuppressWarnings("unused")
    public List<NonlinearShuntCompensator> findAll( FindAllNonlinearShuntCompensatorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all NonlinearShuntCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final NonlinearShuntCompensatorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(NonlinearShuntCompensatorEntityProjector.class.getName());

}
