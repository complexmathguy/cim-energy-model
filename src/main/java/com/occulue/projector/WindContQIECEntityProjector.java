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
 * Projector for WindContQIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindContQIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windContQIEC-entity-projector")
public class WindContQIECEntityProjector {
		
	// core constructor
	public WindContQIECEntityProjector(WindContQIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindContQIEC
	 * 
     * @param	entity WindContQIEC
     */
    public WindContQIEC create( WindContQIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindContQIEC
	 * 
     * @param	entity WindContQIEC
     */
    public WindContQIEC update( WindContQIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindContQIEC
	 * 
     * @param	id		UUID
     */
    public WindContQIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindContQIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindContQIEC via an FindWindContQIECQuery
     * @return 	query	FindWindContQIECQuery
     */
    @SuppressWarnings("unused")
    public WindContQIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindContQIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindContQIECs
     *
     * @param	query	FindAllWindContQIECQuery 
     * @return 	List<WindContQIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindContQIEC> findAll( FindAllWindContQIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindContQIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindContQIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindContQIECEntityProjector.class.getName());

}
