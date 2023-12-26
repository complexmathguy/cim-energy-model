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
 * Projector for PssSB4 as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssSB4Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssSB4-entity-projector")
public class PssSB4EntityProjector {
		
	// core constructor
	public PssSB4EntityProjector(PssSB4Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssSB4
	 * 
     * @param	entity PssSB4
     */
    public PssSB4 create( PssSB4 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssSB4
	 * 
     * @param	entity PssSB4
     */
    public PssSB4 update( PssSB4 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssSB4
	 * 
     * @param	id		UUID
     */
    public PssSB4 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssSB4 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssSB4 via an FindPssSB4Query
     * @return 	query	FindPssSB4Query
     */
    @SuppressWarnings("unused")
    public PssSB4 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssSB4 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssSB4s
     *
     * @param	query	FindAllPssSB4Query 
     * @return 	List<PssSB4> 
     */
    @SuppressWarnings("unused")
    public List<PssSB4> findAll( FindAllPssSB4Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssSB4 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssSB4Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssSB4EntityProjector.class.getName());

}
