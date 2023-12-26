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
 * Projector for SvTapStep as outlined for the CQRS pattern.
 * 
 * Commands are handled by SvTapStepAggregate
 * 
 * @author your_name_here
 *
 */
@Component("svTapStep-entity-projector")
public class SvTapStepEntityProjector {
		
	// core constructor
	public SvTapStepEntityProjector(SvTapStepRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SvTapStep
	 * 
     * @param	entity SvTapStep
     */
    public SvTapStep create( SvTapStep entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SvTapStep
	 * 
     * @param	entity SvTapStep
     */
    public SvTapStep update( SvTapStep entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SvTapStep
	 * 
     * @param	id		UUID
     */
    public SvTapStep delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SvTapStep entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SvTapStep via an FindSvTapStepQuery
     * @return 	query	FindSvTapStepQuery
     */
    @SuppressWarnings("unused")
    public SvTapStep find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SvTapStep - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SvTapSteps
     *
     * @param	query	FindAllSvTapStepQuery 
     * @return 	List<SvTapStep> 
     */
    @SuppressWarnings("unused")
    public List<SvTapStep> findAll( FindAllSvTapStepQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SvTapStep - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SvTapStepRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SvTapStepEntityProjector.class.getName());

}
