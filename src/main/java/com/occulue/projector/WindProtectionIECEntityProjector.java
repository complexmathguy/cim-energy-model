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
 * Projector for WindProtectionIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindProtectionIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windProtectionIEC-entity-projector")
public class WindProtectionIECEntityProjector {
		
	// core constructor
	public WindProtectionIECEntityProjector(WindProtectionIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindProtectionIEC
	 * 
     * @param	entity WindProtectionIEC
     */
    public WindProtectionIEC create( WindProtectionIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindProtectionIEC
	 * 
     * @param	entity WindProtectionIEC
     */
    public WindProtectionIEC update( WindProtectionIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindProtectionIEC
	 * 
     * @param	id		UUID
     */
    public WindProtectionIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindProtectionIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindProtectionIEC via an FindWindProtectionIECQuery
     * @return 	query	FindWindProtectionIECQuery
     */
    @SuppressWarnings("unused")
    public WindProtectionIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindProtectionIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindProtectionIECs
     *
     * @param	query	FindAllWindProtectionIECQuery 
     * @return 	List<WindProtectionIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindProtectionIEC> findAll( FindAllWindProtectionIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindProtectionIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindProtectionIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindProtectionIECEntityProjector.class.getName());

}
