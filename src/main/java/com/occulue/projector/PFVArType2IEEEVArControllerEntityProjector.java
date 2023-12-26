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
 * Projector for PFVArType2IEEEVArController as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArType2IEEEVArControllerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType2IEEEVArController-entity-projector")
public class PFVArType2IEEEVArControllerEntityProjector {
		
	// core constructor
	public PFVArType2IEEEVArControllerEntityProjector(PFVArType2IEEEVArControllerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArType2IEEEVArController
	 * 
     * @param	entity PFVArType2IEEEVArController
     */
    public PFVArType2IEEEVArController create( PFVArType2IEEEVArController entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArType2IEEEVArController
	 * 
     * @param	entity PFVArType2IEEEVArController
     */
    public PFVArType2IEEEVArController update( PFVArType2IEEEVArController entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArType2IEEEVArController
	 * 
     * @param	id		UUID
     */
    public PFVArType2IEEEVArController delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArType2IEEEVArController entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArType2IEEEVArController via an FindPFVArType2IEEEVArControllerQuery
     * @return 	query	FindPFVArType2IEEEVArControllerQuery
     */
    @SuppressWarnings("unused")
    public PFVArType2IEEEVArController find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArType2IEEEVArController - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2IEEEVArControllers
     *
     * @param	query	FindAllPFVArType2IEEEVArControllerQuery 
     * @return 	List<PFVArType2IEEEVArController> 
     */
    @SuppressWarnings("unused")
    public List<PFVArType2IEEEVArController> findAll( FindAllPFVArType2IEEEVArControllerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArType2IEEEVArController - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArType2IEEEVArControllerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEVArControllerEntityProjector.class.getName());

}
