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
 * Projector for PssELIN2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by PssELIN2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("pssELIN2-entity-projector")
public class PssELIN2EntityProjector {
		
	// core constructor
	public PssELIN2EntityProjector(PssELIN2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PssELIN2
	 * 
     * @param	entity PssELIN2
     */
    public PssELIN2 create( PssELIN2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PssELIN2
	 * 
     * @param	entity PssELIN2
     */
    public PssELIN2 update( PssELIN2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PssELIN2
	 * 
     * @param	id		UUID
     */
    public PssELIN2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PssELIN2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PssELIN2 via an FindPssELIN2Query
     * @return 	query	FindPssELIN2Query
     */
    @SuppressWarnings("unused")
    public PssELIN2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PssELIN2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PssELIN2s
     *
     * @param	query	FindAllPssELIN2Query 
     * @return 	List<PssELIN2> 
     */
    @SuppressWarnings("unused")
    public List<PssELIN2> findAll( FindAllPssELIN2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PssELIN2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PssELIN2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PssELIN2EntityProjector.class.getName());

}
