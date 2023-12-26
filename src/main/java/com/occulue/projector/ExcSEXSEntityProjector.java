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
 * Projector for ExcSEXS as outlined for the CQRS pattern.
 * 
 * Commands are handled by ExcSEXSAggregate
 * 
 * @author your_name_here
 *
 */
@Component("excSEXS-entity-projector")
public class ExcSEXSEntityProjector {
		
	// core constructor
	public ExcSEXSEntityProjector(ExcSEXSRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a ExcSEXS
	 * 
     * @param	entity ExcSEXS
     */
    public ExcSEXS create( ExcSEXS entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a ExcSEXS
	 * 
     * @param	entity ExcSEXS
     */
    public ExcSEXS update( ExcSEXS entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a ExcSEXS
	 * 
     * @param	id		UUID
     */
    public ExcSEXS delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    ExcSEXS entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the ExcSEXS via an FindExcSEXSQuery
     * @return 	query	FindExcSEXSQuery
     */
    @SuppressWarnings("unused")
    public ExcSEXS find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a ExcSEXS - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all ExcSEXSs
     *
     * @param	query	FindAllExcSEXSQuery 
     * @return 	List<ExcSEXS> 
     */
    @SuppressWarnings("unused")
    public List<ExcSEXS> findAll( FindAllExcSEXSQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all ExcSEXS - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final ExcSEXSRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(ExcSEXSEntityProjector.class.getName());

}
