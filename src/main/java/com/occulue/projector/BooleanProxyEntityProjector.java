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
 * Projector for BooleanProxy as outlined for the CQRS pattern.
 * 
 * Commands are handled by BooleanProxyAggregate
 * 
 * @author your_name_here
 *
 */
@Component("booleanProxy-entity-projector")
public class BooleanProxyEntityProjector {
		
	// core constructor
	public BooleanProxyEntityProjector(BooleanProxyRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a BooleanProxy
	 * 
     * @param	entity BooleanProxy
     */
    public BooleanProxy create( BooleanProxy entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a BooleanProxy
	 * 
     * @param	entity BooleanProxy
     */
    public BooleanProxy update( BooleanProxy entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a BooleanProxy
	 * 
     * @param	id		UUID
     */
    public BooleanProxy delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    BooleanProxy entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the BooleanProxy via an FindBooleanProxyQuery
     * @return 	query	FindBooleanProxyQuery
     */
    @SuppressWarnings("unused")
    public BooleanProxy find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a BooleanProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all BooleanProxys
     *
     * @param	query	FindAllBooleanProxyQuery 
     * @return 	List<BooleanProxy> 
     */
    @SuppressWarnings("unused")
    public List<BooleanProxy> findAll( FindAllBooleanProxyQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all BooleanProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final BooleanProxyRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(BooleanProxyEntityProjector.class.getName());

}
