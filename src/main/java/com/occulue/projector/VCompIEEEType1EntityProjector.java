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
 * Projector for VCompIEEEType1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by VCompIEEEType1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("vCompIEEEType1-entity-projector")
public class VCompIEEEType1EntityProjector {
		
	// core constructor
	public VCompIEEEType1EntityProjector(VCompIEEEType1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a VCompIEEEType1
	 * 
     * @param	entity VCompIEEEType1
     */
    public VCompIEEEType1 create( VCompIEEEType1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a VCompIEEEType1
	 * 
     * @param	entity VCompIEEEType1
     */
    public VCompIEEEType1 update( VCompIEEEType1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a VCompIEEEType1
	 * 
     * @param	id		UUID
     */
    public VCompIEEEType1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    VCompIEEEType1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the VCompIEEEType1 via an FindVCompIEEEType1Query
     * @return 	query	FindVCompIEEEType1Query
     */
    @SuppressWarnings("unused")
    public VCompIEEEType1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a VCompIEEEType1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all VCompIEEEType1s
     *
     * @param	query	FindAllVCompIEEEType1Query 
     * @return 	List<VCompIEEEType1> 
     */
    @SuppressWarnings("unused")
    public List<VCompIEEEType1> findAll( FindAllVCompIEEEType1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all VCompIEEEType1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final VCompIEEEType1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(VCompIEEEType1EntityProjector.class.getName());

}
