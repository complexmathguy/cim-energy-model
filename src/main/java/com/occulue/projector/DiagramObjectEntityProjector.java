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
 * Projector for DiagramObject as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiagramObjectAggregate
 * 
 * @author your_name_here
 *
 */
@Component("diagramObject-entity-projector")
public class DiagramObjectEntityProjector {
		
	// core constructor
	public DiagramObjectEntityProjector(DiagramObjectRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiagramObject
	 * 
     * @param	entity DiagramObject
     */
    public DiagramObject create( DiagramObject entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiagramObject
	 * 
     * @param	entity DiagramObject
     */
    public DiagramObject update( DiagramObject entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiagramObject
	 * 
     * @param	id		UUID
     */
    public DiagramObject delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiagramObject entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiagramObject via an FindDiagramObjectQuery
     * @return 	query	FindDiagramObjectQuery
     */
    @SuppressWarnings("unused")
    public DiagramObject find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiagramObject - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjects
     *
     * @param	query	FindAllDiagramObjectQuery 
     * @return 	List<DiagramObject> 
     */
    @SuppressWarnings("unused")
    public List<DiagramObject> findAll( FindAllDiagramObjectQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiagramObject - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiagramObjectRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectEntityProjector.class.getName());

}
