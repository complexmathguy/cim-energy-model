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
 * Projector for WindType1or2UserDefined as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindType1or2UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windType1or2UserDefined-entity-projector")
public class WindType1or2UserDefinedEntityProjector {
		
	// core constructor
	public WindType1or2UserDefinedEntityProjector(WindType1or2UserDefinedRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindType1or2UserDefined
	 * 
     * @param	entity WindType1or2UserDefined
     */
    public WindType1or2UserDefined create( WindType1or2UserDefined entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindType1or2UserDefined
	 * 
     * @param	entity WindType1or2UserDefined
     */
    public WindType1or2UserDefined update( WindType1or2UserDefined entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindType1or2UserDefined
	 * 
     * @param	id		UUID
     */
    public WindType1or2UserDefined delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindType1or2UserDefined entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindType1or2UserDefined via an FindWindType1or2UserDefinedQuery
     * @return 	query	FindWindType1or2UserDefinedQuery
     */
    @SuppressWarnings("unused")
    public WindType1or2UserDefined find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindType1or2UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindType1or2UserDefineds
     *
     * @param	query	FindAllWindType1or2UserDefinedQuery 
     * @return 	List<WindType1or2UserDefined> 
     */
    @SuppressWarnings("unused")
    public List<WindType1or2UserDefined> findAll( FindAllWindType1or2UserDefinedQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindType1or2UserDefined - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindType1or2UserDefinedRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindType1or2UserDefinedEntityProjector.class.getName());

}
