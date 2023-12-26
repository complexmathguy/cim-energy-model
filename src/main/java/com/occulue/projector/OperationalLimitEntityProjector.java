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
 * Projector for OperationalLimit as outlined for the CQRS pattern.
 * 
 * Commands are handled by OperationalLimitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("operationalLimit-entity-projector")
public class OperationalLimitEntityProjector {
		
	// core constructor
	public OperationalLimitEntityProjector(OperationalLimitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a OperationalLimit
	 * 
     * @param	entity OperationalLimit
     */
    public OperationalLimit create( OperationalLimit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a OperationalLimit
	 * 
     * @param	entity OperationalLimit
     */
    public OperationalLimit update( OperationalLimit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a OperationalLimit
	 * 
     * @param	id		UUID
     */
    public OperationalLimit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    OperationalLimit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the OperationalLimit via an FindOperationalLimitQuery
     * @return 	query	FindOperationalLimitQuery
     */
    @SuppressWarnings("unused")
    public OperationalLimit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a OperationalLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all OperationalLimits
     *
     * @param	query	FindAllOperationalLimitQuery 
     * @return 	List<OperationalLimit> 
     */
    @SuppressWarnings("unused")
    public List<OperationalLimit> findAll( FindAllOperationalLimitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all OperationalLimit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final OperationalLimitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitEntityProjector.class.getName());

}
