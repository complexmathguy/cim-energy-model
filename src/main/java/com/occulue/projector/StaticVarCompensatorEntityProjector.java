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
 * Projector for StaticVarCompensator as outlined for the CQRS pattern.
 * 
 * Commands are handled by StaticVarCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("staticVarCompensator-entity-projector")
public class StaticVarCompensatorEntityProjector {
		
	// core constructor
	public StaticVarCompensatorEntityProjector(StaticVarCompensatorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a StaticVarCompensator
	 * 
     * @param	entity StaticVarCompensator
     */
    public StaticVarCompensator create( StaticVarCompensator entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a StaticVarCompensator
	 * 
     * @param	entity StaticVarCompensator
     */
    public StaticVarCompensator update( StaticVarCompensator entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a StaticVarCompensator
	 * 
     * @param	id		UUID
     */
    public StaticVarCompensator delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    StaticVarCompensator entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the StaticVarCompensator via an FindStaticVarCompensatorQuery
     * @return 	query	FindStaticVarCompensatorQuery
     */
    @SuppressWarnings("unused")
    public StaticVarCompensator find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a StaticVarCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all StaticVarCompensators
     *
     * @param	query	FindAllStaticVarCompensatorQuery 
     * @return 	List<StaticVarCompensator> 
     */
    @SuppressWarnings("unused")
    public List<StaticVarCompensator> findAll( FindAllStaticVarCompensatorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all StaticVarCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final StaticVarCompensatorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(StaticVarCompensatorEntityProjector.class.getName());

}
