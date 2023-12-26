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
 * Projector for NuclearGeneratingUnit as outlined for the CQRS pattern.
 * 
 * Commands are handled by NuclearGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
@Component("nuclearGeneratingUnit-entity-projector")
public class NuclearGeneratingUnitEntityProjector {
		
	// core constructor
	public NuclearGeneratingUnitEntityProjector(NuclearGeneratingUnitRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a NuclearGeneratingUnit
	 * 
     * @param	entity NuclearGeneratingUnit
     */
    public NuclearGeneratingUnit create( NuclearGeneratingUnit entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a NuclearGeneratingUnit
	 * 
     * @param	entity NuclearGeneratingUnit
     */
    public NuclearGeneratingUnit update( NuclearGeneratingUnit entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a NuclearGeneratingUnit
	 * 
     * @param	id		UUID
     */
    public NuclearGeneratingUnit delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    NuclearGeneratingUnit entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the NuclearGeneratingUnit via an FindNuclearGeneratingUnitQuery
     * @return 	query	FindNuclearGeneratingUnitQuery
     */
    @SuppressWarnings("unused")
    public NuclearGeneratingUnit find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a NuclearGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all NuclearGeneratingUnits
     *
     * @param	query	FindAllNuclearGeneratingUnitQuery 
     * @return 	List<NuclearGeneratingUnit> 
     */
    @SuppressWarnings("unused")
    public List<NuclearGeneratingUnit> findAll( FindAllNuclearGeneratingUnitQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all NuclearGeneratingUnit - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final NuclearGeneratingUnitRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(NuclearGeneratingUnitEntityProjector.class.getName());

}
