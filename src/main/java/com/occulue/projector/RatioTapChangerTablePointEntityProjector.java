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
 * Projector for RatioTapChangerTablePoint as outlined for the CQRS pattern.
 * 
 * Commands are handled by RatioTapChangerTablePointAggregate
 * 
 * @author your_name_here
 *
 */
@Component("ratioTapChangerTablePoint-entity-projector")
public class RatioTapChangerTablePointEntityProjector {
		
	// core constructor
	public RatioTapChangerTablePointEntityProjector(RatioTapChangerTablePointRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RatioTapChangerTablePoint
	 * 
     * @param	entity RatioTapChangerTablePoint
     */
    public RatioTapChangerTablePoint create( RatioTapChangerTablePoint entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RatioTapChangerTablePoint
	 * 
     * @param	entity RatioTapChangerTablePoint
     */
    public RatioTapChangerTablePoint update( RatioTapChangerTablePoint entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RatioTapChangerTablePoint
	 * 
     * @param	id		UUID
     */
    public RatioTapChangerTablePoint delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RatioTapChangerTablePoint entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RatioTapChangerTablePoint via an FindRatioTapChangerTablePointQuery
     * @return 	query	FindRatioTapChangerTablePointQuery
     */
    @SuppressWarnings("unused")
    public RatioTapChangerTablePoint find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RatioTapChangerTablePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RatioTapChangerTablePoints
     *
     * @param	query	FindAllRatioTapChangerTablePointQuery 
     * @return 	List<RatioTapChangerTablePoint> 
     */
    @SuppressWarnings("unused")
    public List<RatioTapChangerTablePoint> findAll( FindAllRatioTapChangerTablePointQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RatioTapChangerTablePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RatioTapChangerTablePointRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerTablePointEntityProjector.class.getName());

}
