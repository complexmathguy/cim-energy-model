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
 * Projector for PssPTIST1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssPTIST1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssPTIST1-entity-projector")
public class PssPTIST1EntityProjector {
		
	// core constructor
	public PssPTIST1EntityProjector(PssPTIST1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssPTIST1
	 * 
     * @param	entity PssPTIST1
     */
    public PssPTIST1 create( PssPTIST1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssPTIST1
	 * 
     * @param	entity PssPTIST1
     */
    public PssPTIST1 update( PssPTIST1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssPTIST1
	 * 
     * @param	id		UUID
     */
    public PssPTIST1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssPTIST1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssPTIST1 via an FindPssPTIST1Query
     * @return 	query	FindPssPTIST1Query
     */
    @SuppressWarnings("unused")
    public PssPTIST1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssPTIST1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssPTIST1s
     *
     * @param	query	FindAllPssPTIST1Query 
     * @return 	List<PssPTIST1> 
     */
    @SuppressWarnings("unused")
    public List<PssPTIST1> findAll( FindAllPssPTIST1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssPTIST1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssPTIST1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST1EntityProjector.class.getName());

}
