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
 * Projector for PssPTIST3 as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssPTIST3Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssPTIST3-entity-projector")
public class PssPTIST3EntityProjector {
		
	// core constructor
	public PssPTIST3EntityProjector(PssPTIST3Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssPTIST3
	 * 
     * @param	entity PssPTIST3
     */
    public PssPTIST3 create( PssPTIST3 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssPTIST3
	 * 
     * @param	entity PssPTIST3
     */
    public PssPTIST3 update( PssPTIST3 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssPTIST3
	 * 
     * @param	id		UUID
     */
    public PssPTIST3 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssPTIST3 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssPTIST3 via an FindPssPTIST3Query
     * @return 	query	FindPssPTIST3Query
     */
    @SuppressWarnings("unused")
    public PssPTIST3 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssPTIST3 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssPTIST3s
     *
     * @param	query	FindAllPssPTIST3Query 
     * @return 	List<PssPTIST3> 
     */
    @SuppressWarnings("unused")
    public List<PssPTIST3> findAll( FindAllPssPTIST3Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssPTIST3 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssPTIST3Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST3EntityProjector.class.getName());

}
