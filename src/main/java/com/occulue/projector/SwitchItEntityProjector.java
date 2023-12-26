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
 * Projector for SwitchIt as outlined for the CQRS pattern.
 * 
 * Commands are handled by SwitchItAggregate
 * 
 * @author your_name_here
 *
 */
@Component("switchIt-entity-projector")
public class SwitchItEntityProjector {
		
	// core constructor
	public SwitchItEntityProjector(SwitchItRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SwitchIt
	 * 
     * @param	entity SwitchIt
     */
    public SwitchIt create( SwitchIt entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SwitchIt
	 * 
     * @param	entity SwitchIt
     */
    public SwitchIt update( SwitchIt entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SwitchIt
	 * 
     * @param	id		UUID
     */
    public SwitchIt delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SwitchIt entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SwitchIt via an FindSwitchItQuery
     * @return 	query	FindSwitchItQuery
     */
    @SuppressWarnings("unused")
    public SwitchIt find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SwitchIt - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SwitchIts
     *
     * @param	query	FindAllSwitchItQuery 
     * @return 	List<SwitchIt> 
     */
    @SuppressWarnings("unused")
    public List<SwitchIt> findAll( FindAllSwitchItQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SwitchIt - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SwitchItRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SwitchItEntityProjector.class.getName());

}
