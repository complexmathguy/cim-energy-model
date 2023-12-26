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
 * Projector for PFVArControllerType1UserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArControllerType1UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArControllerType1UserDefined-entity-projector")
public class PFVArControllerType1UserDefinedEntityProjector {
		
	// core constructor
	public PFVArControllerType1UserDefinedEntityProjector(PFVArControllerType1UserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArControllerType1UserDefined
	 * 
     * @param	entity PFVArControllerType1UserDefined
     */
    public PFVArControllerType1UserDefined create( PFVArControllerType1UserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArControllerType1UserDefined
	 * 
     * @param	entity PFVArControllerType1UserDefined
     */
    public PFVArControllerType1UserDefined update( PFVArControllerType1UserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArControllerType1UserDefined
	 * 
     * @param	id		UUID
     */
    public PFVArControllerType1UserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArControllerType1UserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArControllerType1UserDefined via an FindPFVArControllerType1UserDefinedQuery
     * @return 	query	FindPFVArControllerType1UserDefinedQuery
     */
    @SuppressWarnings("unused")
    public PFVArControllerType1UserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArControllerType1UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArControllerType1UserDefineds
     *
     * @param	query	FindAllPFVArControllerType1UserDefinedQuery 
     * @return 	List<PFVArControllerType1UserDefined> 
     */
    @SuppressWarnings("unused")
    public List<PFVArControllerType1UserDefined> findAll( FindAllPFVArControllerType1UserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArControllerType1UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArControllerType1UserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType1UserDefinedEntityProjector.class.getName());

}
