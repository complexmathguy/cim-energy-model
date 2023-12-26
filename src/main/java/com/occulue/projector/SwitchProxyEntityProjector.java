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
 * Projector for SwitchProxy as outlined for the CQRS pattern.
 * 
 * Commands are handled by SwitchProxyAggregate
 * 
 * @author your_name_here
 *
 */
@Component("switchProxy-entity-projector")
public class SwitchProxyEntityProjector {
		
	// core constructor
	public SwitchProxyEntityProjector(SwitchProxyRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SwitchProxy
	 * 
     * @param	entity SwitchProxy
     */
    public SwitchProxy create( SwitchProxy entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SwitchProxy
	 * 
     * @param	entity SwitchProxy
     */
    public SwitchProxy update( SwitchProxy entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SwitchProxy
	 * 
     * @param	id		UUID
     */
    public SwitchProxy delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SwitchProxy entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SwitchProxy via an FindSwitchProxyQuery
     * @return 	query	FindSwitchProxyQuery
     */
    @SuppressWarnings("unused")
    public SwitchProxy find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SwitchProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SwitchProxys
     *
     * @param	query	FindAllSwitchProxyQuery 
     * @return 	List<SwitchProxy> 
     */
    @SuppressWarnings("unused")
    public List<SwitchProxy> findAll( FindAllSwitchProxyQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SwitchProxy - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SwitchProxyRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SwitchProxyEntityProjector.class.getName());

}
