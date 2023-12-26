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
 * Projector for PFVArType2IEEEPFController as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArType2IEEEPFControllerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType2IEEEPFController-entity-projector")
public class PFVArType2IEEEPFControllerEntityProjector {
		
	// core constructor
	public PFVArType2IEEEPFControllerEntityProjector(PFVArType2IEEEPFControllerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArType2IEEEPFController
	 * 
     * @param	entity PFVArType2IEEEPFController
     */
    public PFVArType2IEEEPFController create( PFVArType2IEEEPFController entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArType2IEEEPFController
	 * 
     * @param	entity PFVArType2IEEEPFController
     */
    public PFVArType2IEEEPFController update( PFVArType2IEEEPFController entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArType2IEEEPFController
	 * 
     * @param	id		UUID
     */
    public PFVArType2IEEEPFController delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArType2IEEEPFController entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArType2IEEEPFController via an FindPFVArType2IEEEPFControllerQuery
     * @return 	query	FindPFVArType2IEEEPFControllerQuery
     */
    @SuppressWarnings("unused")
    public PFVArType2IEEEPFController find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArType2IEEEPFController - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2IEEEPFControllers
     *
     * @param	query	FindAllPFVArType2IEEEPFControllerQuery 
     * @return 	List<PFVArType2IEEEPFController> 
     */
    @SuppressWarnings("unused")
    public List<PFVArType2IEEEPFController> findAll( FindAllPFVArType2IEEEPFControllerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArType2IEEEPFController - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArType2IEEEPFControllerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEPFControllerEntityProjector.class.getName());

}
