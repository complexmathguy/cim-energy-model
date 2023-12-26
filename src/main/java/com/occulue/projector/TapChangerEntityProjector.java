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
 * Projector for TapChanger as outlined for the CQRS pattern.
 * 
 * Commands are handled by TapChangerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("tapChanger-entity-projector")
public class TapChangerEntityProjector {
		
	// core constructor
	public TapChangerEntityProjector(TapChangerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TapChanger
	 * 
     * @param	entity TapChanger
     */
    public TapChanger create( TapChanger entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TapChanger
	 * 
     * @param	entity TapChanger
     */
    public TapChanger update( TapChanger entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TapChanger
	 * 
     * @param	id		UUID
     */
    public TapChanger delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TapChanger entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TapChanger via an FindTapChangerQuery
     * @return 	query	FindTapChangerQuery
     */
    @SuppressWarnings("unused")
    public TapChanger find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TapChangers
     *
     * @param	query	FindAllTapChangerQuery 
     * @return 	List<TapChanger> 
     */
    @SuppressWarnings("unused")
    public List<TapChanger> findAll( FindAllTapChangerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TapChangerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerEntityProjector.class.getName());

}
