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
 * Projector for PFVArType1IEEEPFController as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArType1IEEEPFControllerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType1IEEEPFController-entity-projector")
public class PFVArType1IEEEPFControllerEntityProjector {
		
	// core constructor
	public PFVArType1IEEEPFControllerEntityProjector(PFVArType1IEEEPFControllerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArType1IEEEPFController
	 * 
     * @param	entity PFVArType1IEEEPFController
     */
    public PFVArType1IEEEPFController create( PFVArType1IEEEPFController entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArType1IEEEPFController
	 * 
     * @param	entity PFVArType1IEEEPFController
     */
    public PFVArType1IEEEPFController update( PFVArType1IEEEPFController entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArType1IEEEPFController
	 * 
     * @param	id		UUID
     */
    public PFVArType1IEEEPFController delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArType1IEEEPFController entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArType1IEEEPFController via an FindPFVArType1IEEEPFControllerQuery
     * @return 	query	FindPFVArType1IEEEPFControllerQuery
     */
    @SuppressWarnings("unused")
    public PFVArType1IEEEPFController find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArType1IEEEPFController - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArType1IEEEPFControllers
     *
     * @param	query	FindAllPFVArType1IEEEPFControllerQuery 
     * @return 	List<PFVArType1IEEEPFController> 
     */
    @SuppressWarnings("unused")
    public List<PFVArType1IEEEPFController> findAll( FindAllPFVArType1IEEEPFControllerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArType1IEEEPFController - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArType1IEEEPFControllerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEPFControllerEntityProjector.class.getName());

}
