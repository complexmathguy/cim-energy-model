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
 * Projector for DateProxy as outlined for the CQRS pattern.
 * 
 * Commands are handled by DateProxyAggregate
 * 
 * @author your_name_here
 *
 */
@Component("dateProxy-entity-projector")
public class DateProxyEntityProjector {
		
	// core constructor
	public DateProxyEntityProjector(DateProxyRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DateProxy
	 * 
     * @param	entity DateProxy
     */
    public DateProxy create( DateProxy entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DateProxy
	 * 
     * @param	entity DateProxy
     */
    public DateProxy update( DateProxy entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DateProxy
	 * 
     * @param	id		UUID
     */
    public DateProxy delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DateProxy entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DateProxy via an FindDateProxyQuery
     * @return 	query	FindDateProxyQuery
     */
    @SuppressWarnings("unused")
    public DateProxy find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DateProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DateProxys
     *
     * @param	query	FindAllDateProxyQuery 
     * @return 	List<DateProxy> 
     */
    @SuppressWarnings("unused")
    public List<DateProxy> findAll( FindAllDateProxyQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DateProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DateProxyRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DateProxyEntityProjector.class.getName());

}
