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
 * Projector for Simple_Float as outlined for the CQRS pattern.
 * 
 * Commands are handled by Simple_FloatAggregate
 * 
 * @author your_name_here
 *
 */
@Component("simple_Float-entity-projector")
public class Simple_FloatEntityProjector {
		
	// core constructor
	public Simple_FloatEntityProjector(Simple_FloatRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Simple_Float
	 * 
     * @param	entity Simple_Float
     */
    public Simple_Float create( Simple_Float entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Simple_Float
	 * 
     * @param	entity Simple_Float
     */
    public Simple_Float update( Simple_Float entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Simple_Float
	 * 
     * @param	id		UUID
     */
    public Simple_Float delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Simple_Float entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Simple_Float via an FindSimple_FloatQuery
     * @return 	query	FindSimple_FloatQuery
     */
    @SuppressWarnings("unused")
    public Simple_Float find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Simple_Float - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Simple_Floats
     *
     * @param	query	FindAllSimple_FloatQuery 
     * @return 	List<Simple_Float> 
     */
    @SuppressWarnings("unused")
    public List<Simple_Float> findAll( FindAllSimple_FloatQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Simple_Float - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final Simple_FloatRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(Simple_FloatEntityProjector.class.getName());

}
