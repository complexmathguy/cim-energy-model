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
 * Projector for TapChangerControl as outlined for the CQRS pattern.
 * 
 * Commands are handled by TapChangerControlAggregate
 * 
 * @author your_name_here
 *
 */
@Component("tapChangerControl-entity-projector")
public class TapChangerControlEntityProjector {
		
	// core constructor
	public TapChangerControlEntityProjector(TapChangerControlRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TapChangerControl
	 * 
     * @param	entity TapChangerControl
     */
    public TapChangerControl create( TapChangerControl entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TapChangerControl
	 * 
     * @param	entity TapChangerControl
     */
    public TapChangerControl update( TapChangerControl entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TapChangerControl
	 * 
     * @param	id		UUID
     */
    public TapChangerControl delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TapChangerControl entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TapChangerControl via an FindTapChangerControlQuery
     * @return 	query	FindTapChangerControlQuery
     */
    @SuppressWarnings("unused")
    public TapChangerControl find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TapChangerControl - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TapChangerControls
     *
     * @param	query	FindAllTapChangerControlQuery 
     * @return 	List<TapChangerControl> 
     */
    @SuppressWarnings("unused")
    public List<TapChangerControl> findAll( FindAllTapChangerControlQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TapChangerControl - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TapChangerControlRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerControlEntityProjector.class.getName());

}
