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
 * Projector for EquivalentBranch as outlined for the CQRS pattern.
 * 
 * Commands are handled by EquivalentBranchAggregate
 * 
 * @author your_name_here
 *
 */
@Component("equivalentBranch-entity-projector")
public class EquivalentBranchEntityProjector {
		
	// core constructor
	public EquivalentBranchEntityProjector(EquivalentBranchRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a EquivalentBranch
	 * 
     * @param	entity EquivalentBranch
     */
    public EquivalentBranch create( EquivalentBranch entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a EquivalentBranch
	 * 
     * @param	entity EquivalentBranch
     */
    public EquivalentBranch update( EquivalentBranch entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a EquivalentBranch
	 * 
     * @param	id		UUID
     */
    public EquivalentBranch delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    EquivalentBranch entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the EquivalentBranch via an FindEquivalentBranchQuery
     * @return 	query	FindEquivalentBranchQuery
     */
    @SuppressWarnings("unused")
    public EquivalentBranch find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a EquivalentBranch - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all EquivalentBranchs
     *
     * @param	query	FindAllEquivalentBranchQuery 
     * @return 	List<EquivalentBranch> 
     */
    @SuppressWarnings("unused")
    public List<EquivalentBranch> findAll( FindAllEquivalentBranchQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all EquivalentBranch - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final EquivalentBranchRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(EquivalentBranchEntityProjector.class.getName());

}
