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
 * Projector for WindMechIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindMechIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windMechIEC-entity-projector")
public class WindMechIECEntityProjector {
		
	// core constructor
	public WindMechIECEntityProjector(WindMechIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindMechIEC
	 * 
     * @param	entity WindMechIEC
     */
    public WindMechIEC create( WindMechIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindMechIEC
	 * 
     * @param	entity WindMechIEC
     */
    public WindMechIEC update( WindMechIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindMechIEC
	 * 
     * @param	id		UUID
     */
    public WindMechIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindMechIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindMechIEC via an FindWindMechIECQuery
     * @return 	query	FindWindMechIECQuery
     */
    @SuppressWarnings("unused")
    public WindMechIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindMechIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindMechIECs
     *
     * @param	query	FindAllWindMechIECQuery 
     * @return 	List<WindMechIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindMechIEC> findAll( FindAllWindMechIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindMechIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindMechIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindMechIECEntityProjector.class.getName());

}
