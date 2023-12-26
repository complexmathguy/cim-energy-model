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
 * Projector for WindContPType4bIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindContPType4bIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windContPType4bIEC-entity-projector")
public class WindContPType4bIECEntityProjector {
		
	// core constructor
	public WindContPType4bIECEntityProjector(WindContPType4bIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindContPType4bIEC
	 * 
     * @param	entity WindContPType4bIEC
     */
    public WindContPType4bIEC create( WindContPType4bIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindContPType4bIEC
	 * 
     * @param	entity WindContPType4bIEC
     */
    public WindContPType4bIEC update( WindContPType4bIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindContPType4bIEC
	 * 
     * @param	id		UUID
     */
    public WindContPType4bIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindContPType4bIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindContPType4bIEC via an FindWindContPType4bIECQuery
     * @return 	query	FindWindContPType4bIECQuery
     */
    @SuppressWarnings("unused")
    public WindContPType4bIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindContPType4bIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindContPType4bIECs
     *
     * @param	query	FindAllWindContPType4bIECQuery 
     * @return 	List<WindContPType4bIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindContPType4bIEC> findAll( FindAllWindContPType4bIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindContPType4bIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindContPType4bIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType4bIECEntityProjector.class.getName());

}
