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
 * Projector for GovGAST2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovGAST2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("govGAST2-entity-projector")
public class GovGAST2EntityProjector {
		
	// core constructor
	public GovGAST2EntityProjector(GovGAST2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovGAST2
	 * 
     * @param	entity GovGAST2
     */
    public GovGAST2 create( GovGAST2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovGAST2
	 * 
     * @param	entity GovGAST2
     */
    public GovGAST2 update( GovGAST2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovGAST2
	 * 
     * @param	id		UUID
     */
    public GovGAST2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovGAST2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovGAST2 via an FindGovGAST2Query
     * @return 	query	FindGovGAST2Query
     */
    @SuppressWarnings("unused")
    public GovGAST2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovGAST2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovGAST2s
     *
     * @param	query	FindAllGovGAST2Query 
     * @return 	List<GovGAST2> 
     */
    @SuppressWarnings("unused")
    public List<GovGAST2> findAll( FindAllGovGAST2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovGAST2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovGAST2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovGAST2EntityProjector.class.getName());

}
