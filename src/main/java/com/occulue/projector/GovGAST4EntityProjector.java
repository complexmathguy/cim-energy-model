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
 * Projector for GovGAST4 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovGAST4Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govGAST4-entity-projector")
public class GovGAST4EntityProjector {
		
	// core constructor
	public GovGAST4EntityProjector(GovGAST4Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovGAST4
	 * 
     * @param	entity GovGAST4
     */
    public GovGAST4 create( GovGAST4 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovGAST4
	 * 
     * @param	entity GovGAST4
     */
    public GovGAST4 update( GovGAST4 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovGAST4
	 * 
     * @param	id		UUID
     */
    public GovGAST4 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovGAST4 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovGAST4 via an FindGovGAST4Query
     * @return 	query	FindGovGAST4Query
     */
    @SuppressWarnings("unused")
    public GovGAST4 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovGAST4 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovGAST4s
     *
     * @param	query	FindAllGovGAST4Query 
     * @return 	List<GovGAST4> 
     */
    @SuppressWarnings("unused")
    public List<GovGAST4> findAll( FindAllGovGAST4Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovGAST4 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovGAST4Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST4EntityProjector.class.getName());

}
