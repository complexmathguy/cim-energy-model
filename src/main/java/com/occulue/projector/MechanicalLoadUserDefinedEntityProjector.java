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
 * Projector for MechanicalLoadUserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by MechanicalLoadUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("mechanicalLoadUserDefined-entity-projector")
public class MechanicalLoadUserDefinedEntityProjector {
		
	// core constructor
	public MechanicalLoadUserDefinedEntityProjector(MechanicalLoadUserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a MechanicalLoadUserDefined
	 * 
     * @param	entity MechanicalLoadUserDefined
     */
    public MechanicalLoadUserDefined create( MechanicalLoadUserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a MechanicalLoadUserDefined
	 * 
     * @param	entity MechanicalLoadUserDefined
     */
    public MechanicalLoadUserDefined update( MechanicalLoadUserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a MechanicalLoadUserDefined
	 * 
     * @param	id		UUID
     */
    public MechanicalLoadUserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    MechanicalLoadUserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the MechanicalLoadUserDefined via an FindMechanicalLoadUserDefinedQuery
     * @return 	query	FindMechanicalLoadUserDefinedQuery
     */
    @SuppressWarnings("unused")
    public MechanicalLoadUserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a MechanicalLoadUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all MechanicalLoadUserDefineds
     *
     * @param	query	FindAllMechanicalLoadUserDefinedQuery 
     * @return 	List<MechanicalLoadUserDefined> 
     */
    @SuppressWarnings("unused")
    public List<MechanicalLoadUserDefined> findAll( FindAllMechanicalLoadUserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all MechanicalLoadUserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final MechanicalLoadUserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(MechanicalLoadUserDefinedEntityProjector.class.getName());

}
