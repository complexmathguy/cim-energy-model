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
 * Projector for WindGenType4IEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindGenType4IECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windGenType4IEC-entity-projector")
public class WindGenType4IECEntityProjector {
		
	// core constructor
	public WindGenType4IECEntityProjector(WindGenType4IECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindGenType4IEC
	 * 
     * @param	entity WindGenType4IEC
     */
    public WindGenType4IEC create( WindGenType4IEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindGenType4IEC
	 * 
     * @param	entity WindGenType4IEC
     */
    public WindGenType4IEC update( WindGenType4IEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindGenType4IEC
	 * 
     * @param	id		UUID
     */
    public WindGenType4IEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindGenType4IEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindGenType4IEC via an FindWindGenType4IECQuery
     * @return 	query	FindWindGenType4IECQuery
     */
    @SuppressWarnings("unused")
    public WindGenType4IEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindGenType4IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindGenType4IECs
     *
     * @param	query	FindAllWindGenType4IECQuery 
     * @return 	List<WindGenType4IEC> 
     */
    @SuppressWarnings("unused")
    public List<WindGenType4IEC> findAll( FindAllWindGenType4IECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindGenType4IEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindGenType4IECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindGenType4IECEntityProjector.class.getName());

}
