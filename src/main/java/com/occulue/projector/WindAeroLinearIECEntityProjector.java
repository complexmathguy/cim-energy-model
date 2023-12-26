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
 * Projector for WindAeroLinearIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindAeroLinearIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windAeroLinearIEC-entity-projector")
public class WindAeroLinearIECEntityProjector {
		
	// core constructor
	public WindAeroLinearIECEntityProjector(WindAeroLinearIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindAeroLinearIEC
	 * 
     * @param	entity WindAeroLinearIEC
     */
    public WindAeroLinearIEC create( WindAeroLinearIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindAeroLinearIEC
	 * 
     * @param	entity WindAeroLinearIEC
     */
    public WindAeroLinearIEC update( WindAeroLinearIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindAeroLinearIEC
	 * 
     * @param	id		UUID
     */
    public WindAeroLinearIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindAeroLinearIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindAeroLinearIEC via an FindWindAeroLinearIECQuery
     * @return 	query	FindWindAeroLinearIECQuery
     */
    @SuppressWarnings("unused")
    public WindAeroLinearIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindAeroLinearIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindAeroLinearIECs
     *
     * @param	query	FindAllWindAeroLinearIECQuery 
     * @return 	List<WindAeroLinearIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindAeroLinearIEC> findAll( FindAllWindAeroLinearIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindAeroLinearIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindAeroLinearIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindAeroLinearIECEntityProjector.class.getName());

}
