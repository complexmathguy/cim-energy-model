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
 * Projector for DiscExcContIEEEDEC2A as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiscExcContIEEEDEC2AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("discExcContIEEEDEC2A-entity-projector")
public class DiscExcContIEEEDEC2AEntityProjector {
		
	// core constructor
	public DiscExcContIEEEDEC2AEntityProjector(DiscExcContIEEEDEC2ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiscExcContIEEEDEC2A
	 * 
     * @param	entity DiscExcContIEEEDEC2A
     */
    public DiscExcContIEEEDEC2A create( DiscExcContIEEEDEC2A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiscExcContIEEEDEC2A
	 * 
     * @param	entity DiscExcContIEEEDEC2A
     */
    public DiscExcContIEEEDEC2A update( DiscExcContIEEEDEC2A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiscExcContIEEEDEC2A
	 * 
     * @param	id		UUID
     */
    public DiscExcContIEEEDEC2A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiscExcContIEEEDEC2A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiscExcContIEEEDEC2A via an FindDiscExcContIEEEDEC2AQuery
     * @return 	query	FindDiscExcContIEEEDEC2AQuery
     */
    @SuppressWarnings("unused")
    public DiscExcContIEEEDEC2A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiscExcContIEEEDEC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC2As
     *
     * @param	query	FindAllDiscExcContIEEEDEC2AQuery 
     * @return 	List<DiscExcContIEEEDEC2A> 
     */
    @SuppressWarnings("unused")
    public List<DiscExcContIEEEDEC2A> findAll( FindAllDiscExcContIEEEDEC2AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiscExcContIEEEDEC2A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiscExcContIEEEDEC2ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC2AEntityProjector.class.getName());

}
