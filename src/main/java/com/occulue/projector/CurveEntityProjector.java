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
 * Projector for Curve as outlined for the CQRS pattern.
 * 
 * Commands are handled by CurveAggregate
 * 
 * @author your_name_here
 *
 */
@Component("curve-entity-projector")
public class CurveEntityProjector {
		
	// core constructor
	public CurveEntityProjector(CurveRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a Curve
	 * 
     * @param	entity Curve
     */
    public Curve create( Curve entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a Curve
	 * 
     * @param	entity Curve
     */
    public Curve update( Curve entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a Curve
	 * 
     * @param	id		UUID
     */
    public Curve delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    Curve entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the Curve via an FindCurveQuery
     * @return 	query	FindCurveQuery
     */
    @SuppressWarnings("unused")
    public Curve find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a Curve - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all Curves
     *
     * @param	query	FindAllCurveQuery 
     * @return 	List<Curve> 
     */
    @SuppressWarnings("unused")
    public List<Curve> findAll( FindAllCurveQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all Curve - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final CurveRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(CurveEntityProjector.class.getName());

}
