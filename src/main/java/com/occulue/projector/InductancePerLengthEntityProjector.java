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
 * Projector for InductancePerLength as outlined for the CQRS pattern.
 * 
 * Commands are handled by InductancePerLengthAggregate
 * 
 * @author your_name_here
 *
 */
@Component("inductancePerLength-entity-projector")
public class InductancePerLengthEntityProjector {
		
	// core constructor
	public InductancePerLengthEntityProjector(InductancePerLengthRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a InductancePerLength
	 * 
     * @param	entity InductancePerLength
     */
    public InductancePerLength create( InductancePerLength entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a InductancePerLength
	 * 
     * @param	entity InductancePerLength
     */
    public InductancePerLength update( InductancePerLength entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a InductancePerLength
	 * 
     * @param	id		UUID
     */
    public InductancePerLength delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    InductancePerLength entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the InductancePerLength via an FindInductancePerLengthQuery
     * @return 	query	FindInductancePerLengthQuery
     */
    @SuppressWarnings("unused")
    public InductancePerLength find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a InductancePerLength - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all InductancePerLengths
     *
     * @param	query	FindAllInductancePerLengthQuery 
     * @return 	List<InductancePerLength> 
     */
    @SuppressWarnings("unused")
    public List<InductancePerLength> findAll( FindAllInductancePerLengthQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all InductancePerLength - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final InductancePerLengthRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(InductancePerLengthEntityProjector.class.getName());

}
