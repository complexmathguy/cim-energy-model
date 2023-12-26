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
 * Projector for CurveData as outlined for the CQRS pattern.
 * 
 * Commands are handled by CurveDataAggregate
 * 
 * @author your_name_here
 *
 */
@Component("curveData-entity-projector")
public class CurveDataEntityProjector {
		
	// core constructor
	public CurveDataEntityProjector(CurveDataRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a CurveData
	 * 
     * @param	entity CurveData
     */
    public CurveData create( CurveData entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a CurveData
	 * 
     * @param	entity CurveData
     */
    public CurveData update( CurveData entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a CurveData
	 * 
     * @param	id		UUID
     */
    public CurveData delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    CurveData entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the CurveData via an FindCurveDataQuery
     * @return 	query	FindCurveDataQuery
     */
    @SuppressWarnings("unused")
    public CurveData find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a CurveData - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all CurveDatas
     *
     * @param	query	FindAllCurveDataQuery 
     * @return 	List<CurveData> 
     */
    @SuppressWarnings("unused")
    public List<CurveData> findAll( FindAllCurveDataQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all CurveData - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final CurveDataRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(CurveDataEntityProjector.class.getName());

}
