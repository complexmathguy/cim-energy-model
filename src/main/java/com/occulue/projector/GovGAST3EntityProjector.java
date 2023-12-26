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
 * Projector for GovGAST3 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovGAST3Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govGAST3-entity-projector")
public class GovGAST3EntityProjector {
		
	// core constructor
	public GovGAST3EntityProjector(GovGAST3Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovGAST3
	 * 
     * @param	entity GovGAST3
     */
    public GovGAST3 create( GovGAST3 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovGAST3
	 * 
     * @param	entity GovGAST3
     */
    public GovGAST3 update( GovGAST3 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovGAST3
	 * 
     * @param	id		UUID
     */
    public GovGAST3 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovGAST3 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovGAST3 via an FindGovGAST3Query
     * @return 	query	FindGovGAST3Query
     */
    @SuppressWarnings("unused")
    public GovGAST3 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovGAST3 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovGAST3s
     *
     * @param	query	FindAllGovGAST3Query 
     * @return 	List<GovGAST3> 
     */
    @SuppressWarnings("unused")
    public List<GovGAST3> findAll( FindAllGovGAST3Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovGAST3 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovGAST3Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST3EntityProjector.class.getName());

}
