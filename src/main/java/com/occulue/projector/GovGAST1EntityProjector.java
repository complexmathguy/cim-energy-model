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
 * Projector for GovGAST1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovGAST1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govGAST1-entity-projector")
public class GovGAST1EntityProjector {
		
	// core constructor
	public GovGAST1EntityProjector(GovGAST1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovGAST1
	 * 
     * @param	entity GovGAST1
     */
    public GovGAST1 create( GovGAST1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovGAST1
	 * 
     * @param	entity GovGAST1
     */
    public GovGAST1 update( GovGAST1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovGAST1
	 * 
     * @param	id		UUID
     */
    public GovGAST1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovGAST1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovGAST1 via an FindGovGAST1Query
     * @return 	query	FindGovGAST1Query
     */
    @SuppressWarnings("unused")
    public GovGAST1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovGAST1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovGAST1s
     *
     * @param	query	FindAllGovGAST1Query 
     * @return 	List<GovGAST1> 
     */
    @SuppressWarnings("unused")
    public List<GovGAST1> findAll( FindAllGovGAST1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovGAST1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovGAST1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST1EntityProjector.class.getName());

}
