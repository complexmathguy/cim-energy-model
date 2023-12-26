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
 * Projector for GovGAST as outlined for the CQRS pattern.
 * 
 * Commands are handled by GovGASTAggregate
 * 
 * @author your_name_here
 *
 */
@Component("govGAST-entity-projector")
public class GovGASTEntityProjector {
		
	// core constructor
	public GovGASTEntityProjector(GovGASTRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a GovGAST
	 * 
     * @param	entity GovGAST
     */
    public GovGAST create( GovGAST entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a GovGAST
	 * 
     * @param	entity GovGAST
     */
    public GovGAST update( GovGAST entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a GovGAST
	 * 
     * @param	id		UUID
     */
    public GovGAST delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    GovGAST entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the GovGAST via an FindGovGASTQuery
     * @return 	query	FindGovGASTQuery
     */
    @SuppressWarnings("unused")
    public GovGAST find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a GovGAST - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all GovGASTs
     *
     * @param	query	FindAllGovGASTQuery 
     * @return 	List<GovGAST> 
     */
    @SuppressWarnings("unused")
    public List<GovGAST> findAll( FindAllGovGASTQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all GovGAST - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final GovGASTRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(GovGASTEntityProjector.class.getName());

}
