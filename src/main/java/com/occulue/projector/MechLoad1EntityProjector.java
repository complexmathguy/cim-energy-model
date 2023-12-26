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
 * Projector for MechLoad1 as outlined for the CQRS pattern.
 * 
 * Commands are handled by MechLoad1Aggregate
 * 
 * @author your_name_here
 *
 */
@Component("mechLoad1-entity-projector")
public class MechLoad1EntityProjector {
		
	// core constructor
	public MechLoad1EntityProjector(MechLoad1Repository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a MechLoad1
	 * 
     * @param	entity MechLoad1
     */
    public MechLoad1 create( MechLoad1 entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a MechLoad1
	 * 
     * @param	entity MechLoad1
     */
    public MechLoad1 update( MechLoad1 entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a MechLoad1
	 * 
     * @param	id		UUID
     */
    public MechLoad1 delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    MechLoad1 entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the MechLoad1 via an FindMechLoad1Query
     * @return 	query	FindMechLoad1Query
     */
    @SuppressWarnings("unused")
    public MechLoad1 find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a MechLoad1 - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all MechLoad1s
     *
     * @param	query	FindAllMechLoad1Query 
     * @return 	List<MechLoad1> 
     */
    @SuppressWarnings("unused")
    public List<MechLoad1> findAll( FindAllMechLoad1Query query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all MechLoad1 - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final MechLoad1Repository repository;

    private static final Logger LOGGER 	= Logger.getLogger(MechLoad1EntityProjector.class.getName());

}
