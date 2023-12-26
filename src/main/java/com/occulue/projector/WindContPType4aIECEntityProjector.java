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
 * Projector for WindContPType4aIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindContPType4aIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windContPType4aIEC-entity-projector")
public class WindContPType4aIECEntityProjector {
		
	// core constructor
	public WindContPType4aIECEntityProjector(WindContPType4aIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindContPType4aIEC
	 * 
     * @param	entity WindContPType4aIEC
     */
    public WindContPType4aIEC create( WindContPType4aIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindContPType4aIEC
	 * 
     * @param	entity WindContPType4aIEC
     */
    public WindContPType4aIEC update( WindContPType4aIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindContPType4aIEC
	 * 
     * @param	id		UUID
     */
    public WindContPType4aIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindContPType4aIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindContPType4aIEC via an FindWindContPType4aIECQuery
     * @return 	query	FindWindContPType4aIECQuery
     */
    @SuppressWarnings("unused")
    public WindContPType4aIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindContPType4aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindContPType4aIECs
     *
     * @param	query	FindAllWindContPType4aIECQuery 
     * @return 	List<WindContPType4aIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindContPType4aIEC> findAll( FindAllWindContPType4aIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindContPType4aIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindContPType4aIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindContPType4aIECEntityProjector.class.getName());

}
