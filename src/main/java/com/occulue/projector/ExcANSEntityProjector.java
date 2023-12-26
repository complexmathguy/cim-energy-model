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
 * Projector for ExcANS as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcANSAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excANS-entity-projector")
public class ExcANSEntityProjector {
		
	// core constructor
	public ExcANSEntityProjector(ExcANSRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcANS
	 * 
     * @param	entity ExcANS
     */
    public ExcANS create( ExcANS entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcANS
	 * 
     * @param	entity ExcANS
     */
    public ExcANS update( ExcANS entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcANS
	 * 
     * @param	id		UUID
     */
    public ExcANS delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcANS entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcANS via an FindExcANSQuery
     * @return 	query	FindExcANSQuery
     */
    @SuppressWarnings("unused")
    public ExcANS find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcANS - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcANSs
     *
     * @param	query	FindAllExcANSQuery 
     * @return 	List<ExcANS> 
     */
    @SuppressWarnings("unused")
    public List<ExcANS> findAll( FindAllExcANSQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcANS - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcANSRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcANSEntityProjector.class.getName());

}
