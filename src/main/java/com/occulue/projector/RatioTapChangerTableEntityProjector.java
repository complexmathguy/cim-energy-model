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
 * Projector for RatioTapChangerTable as outlined for the CQRS pattern.
 * 
 * Commands are handled by RatioTapChangerTableAggregate
 * 
 * @author your_name_here
 *
 */
@Component("ratioTapChangerTable-entity-projector")
public class RatioTapChangerTableEntityProjector {
		
	// core constructor
	public RatioTapChangerTableEntityProjector(RatioTapChangerTableRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a RatioTapChangerTable
	 * 
     * @param	entity RatioTapChangerTable
     */
    public RatioTapChangerTable create( RatioTapChangerTable entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a RatioTapChangerTable
	 * 
     * @param	entity RatioTapChangerTable
     */
    public RatioTapChangerTable update( RatioTapChangerTable entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a RatioTapChangerTable
	 * 
     * @param	id		UUID
     */
    public RatioTapChangerTable delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    RatioTapChangerTable entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the RatioTapChangerTable via an FindRatioTapChangerTableQuery
     * @return 	query	FindRatioTapChangerTableQuery
     */
    @SuppressWarnings("unused")
    public RatioTapChangerTable find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a RatioTapChangerTable - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all RatioTapChangerTables
     *
     * @param	query	FindAllRatioTapChangerTableQuery 
     * @return 	List<RatioTapChangerTable> 
     */
    @SuppressWarnings("unused")
    public List<RatioTapChangerTable> findAll( FindAllRatioTapChangerTableQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all RatioTapChangerTable - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final RatioTapChangerTableRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerTableEntityProjector.class.getName());

}
