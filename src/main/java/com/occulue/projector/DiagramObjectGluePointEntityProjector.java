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
 * Projector for DiagramObjectGluePoint as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiagramObjectGluePointAggregate
 * 
 * @author your_name_here
 *
 */
@Component("diagramObjectGluePoint-entity-projector")
public class DiagramObjectGluePointEntityProjector {
		
	// core constructor
	public DiagramObjectGluePointEntityProjector(DiagramObjectGluePointRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiagramObjectGluePoint
	 * 
     * @param	entity DiagramObjectGluePoint
     */
    public DiagramObjectGluePoint create( DiagramObjectGluePoint entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiagramObjectGluePoint
	 * 
     * @param	entity DiagramObjectGluePoint
     */
    public DiagramObjectGluePoint update( DiagramObjectGluePoint entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiagramObjectGluePoint
	 * 
     * @param	id		UUID
     */
    public DiagramObjectGluePoint delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiagramObjectGluePoint entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiagramObjectGluePoint via an FindDiagramObjectGluePointQuery
     * @return 	query	FindDiagramObjectGluePointQuery
     */
    @SuppressWarnings("unused")
    public DiagramObjectGluePoint find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiagramObjectGluePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjectGluePoints
     *
     * @param	query	FindAllDiagramObjectGluePointQuery 
     * @return 	List<DiagramObjectGluePoint> 
     */
    @SuppressWarnings("unused")
    public List<DiagramObjectGluePoint> findAll( FindAllDiagramObjectGluePointQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiagramObjectGluePoint - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiagramObjectGluePointRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectGluePointEntityProjector.class.getName());

}
