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
 * Projector for PFVArType1IEEEVArController as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArType1IEEEVArControllerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType1IEEEVArController-entity-projector")
public class PFVArType1IEEEVArControllerEntityProjector {
		
	// core constructor
	public PFVArType1IEEEVArControllerEntityProjector(PFVArType1IEEEVArControllerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArType1IEEEVArController
	 * 
     * @param	entity PFVArType1IEEEVArController
     */
    public PFVArType1IEEEVArController create( PFVArType1IEEEVArController entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArType1IEEEVArController
	 * 
     * @param	entity PFVArType1IEEEVArController
     */
    public PFVArType1IEEEVArController update( PFVArType1IEEEVArController entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArType1IEEEVArController
	 * 
     * @param	id		UUID
     */
    public PFVArType1IEEEVArController delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArType1IEEEVArController entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArType1IEEEVArController via an FindPFVArType1IEEEVArControllerQuery
     * @return 	query	FindPFVArType1IEEEVArControllerQuery
     */
    @SuppressWarnings("unused")
    public PFVArType1IEEEVArController find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArType1IEEEVArController - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArType1IEEEVArControllers
     *
     * @param	query	FindAllPFVArType1IEEEVArControllerQuery 
     * @return 	List<PFVArType1IEEEVArController> 
     */
    @SuppressWarnings("unused")
    public List<PFVArType1IEEEVArController> findAll( FindAllPFVArType1IEEEVArControllerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArType1IEEEVArController - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArType1IEEEVArControllerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEVArControllerEntityProjector.class.getName());

}
