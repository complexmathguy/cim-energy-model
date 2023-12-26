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
 * Projector for TurbLCFB1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by TurbLCFB1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("turbLCFB1-entity-projector")
public class TurbLCFB1EntityProjector {
		
	// core constructor
	public TurbLCFB1EntityProjector(TurbLCFB1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TurbLCFB1
	 * 
     * @param	entity TurbLCFB1
     */
    public TurbLCFB1 create( TurbLCFB1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TurbLCFB1
	 * 
     * @param	entity TurbLCFB1
     */
    public TurbLCFB1 update( TurbLCFB1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TurbLCFB1
	 * 
     * @param	id		UUID
     */
    public TurbLCFB1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TurbLCFB1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TurbLCFB1 via an FindTurbLCFB1Query
     * @return 	query	FindTurbLCFB1Query
     */
    @SuppressWarnings("unused")
    public TurbLCFB1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TurbLCFB1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TurbLCFB1s
     *
     * @param	query	FindAllTurbLCFB1Query 
     * @return 	List<TurbLCFB1> 
     */
    @SuppressWarnings("unused")
    public List<TurbLCFB1> findAll( FindAllTurbLCFB1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TurbLCFB1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TurbLCFB1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TurbLCFB1EntityProjector.class.getName());

}
