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
 * Projector for VCompIEEEType2 as outlined for the CQRS pattern.
 * 
 * Commands are handled by VCompIEEEType2Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("vCompIEEEType2-entity-projector")
public class VCompIEEEType2EntityProjector {
		
	// core constructor
	public VCompIEEEType2EntityProjector(VCompIEEEType2Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VCompIEEEType2
	 * 
     * @param	entity VCompIEEEType2
     */
    public VCompIEEEType2 create( VCompIEEEType2 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VCompIEEEType2
	 * 
     * @param	entity VCompIEEEType2
     */
    public VCompIEEEType2 update( VCompIEEEType2 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VCompIEEEType2
	 * 
     * @param	id		UUID
     */
    public VCompIEEEType2 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VCompIEEEType2 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VCompIEEEType2 via an FindVCompIEEEType2Query
     * @return 	query	FindVCompIEEEType2Query
     */
    @SuppressWarnings("unused")
    public VCompIEEEType2 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VCompIEEEType2 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VCompIEEEType2s
     *
     * @param	query	FindAllVCompIEEEType2Query 
     * @return 	List<VCompIEEEType2> 
     */
    @SuppressWarnings("unused")
    public List<VCompIEEEType2> findAll( FindAllVCompIEEEType2Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VCompIEEEType2 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VCompIEEEType2Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VCompIEEEType2EntityProjector.class.getName());

}
