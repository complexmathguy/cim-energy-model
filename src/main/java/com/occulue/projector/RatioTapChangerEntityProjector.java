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
 * Projector for RatioTapChanger as outlined for the CQRS pattern.
 * 
 * Commands are handled by RatioTapChangerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("ratioTapChanger-entity-projector")
public class RatioTapChangerEntityProjector {
		
	// core constructor
	public RatioTapChangerEntityProjector(RatioTapChangerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RatioTapChanger
	 * 
     * @param	entity RatioTapChanger
     */
    public RatioTapChanger create( RatioTapChanger entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RatioTapChanger
	 * 
     * @param	entity RatioTapChanger
     */
    public RatioTapChanger update( RatioTapChanger entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RatioTapChanger
	 * 
     * @param	id		UUID
     */
    public RatioTapChanger delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RatioTapChanger entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RatioTapChanger via an FindRatioTapChangerQuery
     * @return 	query	FindRatioTapChangerQuery
     */
    @SuppressWarnings("unused")
    public RatioTapChanger find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RatioTapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RatioTapChangers
     *
     * @param	query	FindAllRatioTapChangerQuery 
     * @return 	List<RatioTapChanger> 
     */
    @SuppressWarnings("unused")
    public List<RatioTapChanger> findAll( FindAllRatioTapChangerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RatioTapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RatioTapChangerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerEntityProjector.class.getName());

}
