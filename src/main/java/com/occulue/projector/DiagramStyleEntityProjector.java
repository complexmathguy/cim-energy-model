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
 * Projector for DiagramStyle as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiagramStyleAggregate
 * 
 * @author your_name_here
 *
 */
@Component("diagramStyle-entity-projector")
public class DiagramStyleEntityProjector {
		
	// core constructor
	public DiagramStyleEntityProjector(DiagramStyleRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiagramStyle
	 * 
     * @param	entity DiagramStyle
     */
    public DiagramStyle create( DiagramStyle entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiagramStyle
	 * 
     * @param	entity DiagramStyle
     */
    public DiagramStyle update( DiagramStyle entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiagramStyle
	 * 
     * @param	id		UUID
     */
    public DiagramStyle delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiagramStyle entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiagramStyle via an FindDiagramStyleQuery
     * @return 	query	FindDiagramStyleQuery
     */
    @SuppressWarnings("unused")
    public DiagramStyle find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiagramStyle - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiagramStyles
     *
     * @param	query	FindAllDiagramStyleQuery 
     * @return 	List<DiagramStyle> 
     */
    @SuppressWarnings("unused")
    public List<DiagramStyle> findAll( FindAllDiagramStyleQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiagramStyle - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiagramStyleRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramStyleEntityProjector.class.getName());

}
