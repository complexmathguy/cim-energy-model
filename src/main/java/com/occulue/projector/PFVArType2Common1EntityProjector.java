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
 * Projector for PFVArType2Common1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by PFVArType2Common1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pFVArType2Common1-entity-projector")
public class PFVArType2Common1EntityProjector {
		
	// core constructor
	public PFVArType2Common1EntityProjector(PFVArType2Common1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PFVArType2Common1
	 * 
     * @param	entity PFVArType2Common1
     */
    public PFVArType2Common1 create( PFVArType2Common1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PFVArType2Common1
	 * 
     * @param	entity PFVArType2Common1
     */
    public PFVArType2Common1 update( PFVArType2Common1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PFVArType2Common1
	 * 
     * @param	id		UUID
     */
    public PFVArType2Common1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PFVArType2Common1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PFVArType2Common1 via an FindPFVArType2Common1Query
     * @return 	query	FindPFVArType2Common1Query
     */
    @SuppressWarnings("unused")
    public PFVArType2Common1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PFVArType2Common1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2Common1s
     *
     * @param	query	FindAllPFVArType2Common1Query 
     * @return 	List<PFVArType2Common1> 
     */
    @SuppressWarnings("unused")
    public List<PFVArType2Common1> findAll( FindAllPFVArType2Common1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PFVArType2Common1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PFVArType2Common1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2Common1EntityProjector.class.getName());

}
