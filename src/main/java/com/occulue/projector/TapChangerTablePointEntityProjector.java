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
 * Projector for TapChangerTablePoint as outlined for the CQRS pattern.
 * 
 * Commands are handled by TapChangerTablePointAggregate
 * 
 * @author your_name_here
 *
 */
@Component("tapChangerTablePoint-entity-projector")
public class TapChangerTablePointEntityProjector {
		
	// core constructor
	public TapChangerTablePointEntityProjector(TapChangerTablePointRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TapChangerTablePoint
	 * 
     * @param	entity TapChangerTablePoint
     */
    public TapChangerTablePoint create( TapChangerTablePoint entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TapChangerTablePoint
	 * 
     * @param	entity TapChangerTablePoint
     */
    public TapChangerTablePoint update( TapChangerTablePoint entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TapChangerTablePoint
	 * 
     * @param	id		UUID
     */
    public TapChangerTablePoint delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TapChangerTablePoint entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TapChangerTablePoint via an FindTapChangerTablePointQuery
     * @return 	query	FindTapChangerTablePointQuery
     */
    @SuppressWarnings("unused")
    public TapChangerTablePoint find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TapChangerTablePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TapChangerTablePoints
     *
     * @param	query	FindAllTapChangerTablePointQuery 
     * @return 	List<TapChangerTablePoint> 
     */
    @SuppressWarnings("unused")
    public List<TapChangerTablePoint> findAll( FindAllTapChangerTablePointQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TapChangerTablePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TapChangerTablePointRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TapChangerTablePointEntityProjector.class.getName());

}
