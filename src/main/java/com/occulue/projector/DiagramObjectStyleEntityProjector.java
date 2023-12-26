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
 * Projector for DiagramObjectStyle as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiagramObjectStyleAggregate
 * 
 * @author your_name_here
 *
 */
@Component("diagramObjectStyle-entity-projector")
public class DiagramObjectStyleEntityProjector {
		
	// core constructor
	public DiagramObjectStyleEntityProjector(DiagramObjectStyleRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiagramObjectStyle
	 * 
     * @param	entity DiagramObjectStyle
     */
    public DiagramObjectStyle create( DiagramObjectStyle entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiagramObjectStyle
	 * 
     * @param	entity DiagramObjectStyle
     */
    public DiagramObjectStyle update( DiagramObjectStyle entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiagramObjectStyle
	 * 
     * @param	id		UUID
     */
    public DiagramObjectStyle delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiagramObjectStyle entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiagramObjectStyle via an FindDiagramObjectStyleQuery
     * @return 	query	FindDiagramObjectStyleQuery
     */
    @SuppressWarnings("unused")
    public DiagramObjectStyle find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiagramObjectStyle - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiagramObjectStyles
     *
     * @param	query	FindAllDiagramObjectStyleQuery 
     * @return 	List<DiagramObjectStyle> 
     */
    @SuppressWarnings("unused")
    public List<DiagramObjectStyle> findAll( FindAllDiagramObjectStyleQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiagramObjectStyle - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiagramObjectStyleRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramObjectStyleEntityProjector.class.getName());

}
