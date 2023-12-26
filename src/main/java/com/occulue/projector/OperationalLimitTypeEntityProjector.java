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
 * Projector for OperationalLimitType as outlined for the CQRS pattern.
 * 
 * Commands are handled by OperationalLimitTypeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("operationalLimitType-entity-projector")
public class OperationalLimitTypeEntityProjector {
		
	// core constructor
	public OperationalLimitTypeEntityProjector(OperationalLimitTypeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a OperationalLimitType
	 * 
     * @param	entity OperationalLimitType
     */
    public OperationalLimitType create( OperationalLimitType entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a OperationalLimitType
	 * 
     * @param	entity OperationalLimitType
     */
    public OperationalLimitType update( OperationalLimitType entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a OperationalLimitType
	 * 
     * @param	id		UUID
     */
    public OperationalLimitType delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    OperationalLimitType entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the OperationalLimitType via an FindOperationalLimitTypeQuery
     * @return 	query	FindOperationalLimitTypeQuery
     */
    @SuppressWarnings("unused")
    public OperationalLimitType find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a OperationalLimitType - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all OperationalLimitTypes
     *
     * @param	query	FindAllOperationalLimitTypeQuery 
     * @return 	List<OperationalLimitType> 
     */
    @SuppressWarnings("unused")
    public List<OperationalLimitType> findAll( FindAllOperationalLimitTypeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all OperationalLimitType - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final OperationalLimitTypeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(OperationalLimitTypeEntityProjector.class.getName());

}
