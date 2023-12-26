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
 * Projector for DiscExcContIEEEDEC1A as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiscExcContIEEEDEC1AAggregate
 * 
 * @author your_name_here
 *
 */
@Component("discExcContIEEEDEC1A-entity-projector")
public class DiscExcContIEEEDEC1AEntityProjector {
		
	// core constructor
	public DiscExcContIEEEDEC1AEntityProjector(DiscExcContIEEEDEC1ARepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiscExcContIEEEDEC1A
	 * 
     * @param	entity DiscExcContIEEEDEC1A
     */
    public DiscExcContIEEEDEC1A create( DiscExcContIEEEDEC1A entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiscExcContIEEEDEC1A
	 * 
     * @param	entity DiscExcContIEEEDEC1A
     */
    public DiscExcContIEEEDEC1A update( DiscExcContIEEEDEC1A entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiscExcContIEEEDEC1A
	 * 
     * @param	id		UUID
     */
    public DiscExcContIEEEDEC1A delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiscExcContIEEEDEC1A entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiscExcContIEEEDEC1A via an FindDiscExcContIEEEDEC1AQuery
     * @return 	query	FindDiscExcContIEEEDEC1AQuery
     */
    @SuppressWarnings("unused")
    public DiscExcContIEEEDEC1A find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiscExcContIEEEDEC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC1As
     *
     * @param	query	FindAllDiscExcContIEEEDEC1AQuery 
     * @return 	List<DiscExcContIEEEDEC1A> 
     */
    @SuppressWarnings("unused")
    public List<DiscExcContIEEEDEC1A> findAll( FindAllDiscExcContIEEEDEC1AQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiscExcContIEEEDEC1A - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiscExcContIEEEDEC1ARepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC1AEntityProjector.class.getName());

}
