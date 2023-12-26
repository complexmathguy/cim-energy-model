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
 * Projector for DiagramLayoutVersion as outlined for the CQRS pattern.
 * 
 * Commands are handled by DiagramLayoutVersionAggregate
 * 
 * @author your_name_here
 *
 */
@Component("diagramLayoutVersion-entity-projector")
public class DiagramLayoutVersionEntityProjector {
		
	// core constructor
	public DiagramLayoutVersionEntityProjector(DiagramLayoutVersionRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a DiagramLayoutVersion
	 * 
     * @param	entity DiagramLayoutVersion
     */
    public DiagramLayoutVersion create( DiagramLayoutVersion entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a DiagramLayoutVersion
	 * 
     * @param	entity DiagramLayoutVersion
     */
    public DiagramLayoutVersion update( DiagramLayoutVersion entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a DiagramLayoutVersion
	 * 
     * @param	id		UUID
     */
    public DiagramLayoutVersion delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    DiagramLayoutVersion entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the DiagramLayoutVersion via an FindDiagramLayoutVersionQuery
     * @return 	query	FindDiagramLayoutVersionQuery
     */
    @SuppressWarnings("unused")
    public DiagramLayoutVersion find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a DiagramLayoutVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all DiagramLayoutVersions
     *
     * @param	query	FindAllDiagramLayoutVersionQuery 
     * @return 	List<DiagramLayoutVersion> 
     */
    @SuppressWarnings("unused")
    public List<DiagramLayoutVersion> findAll( FindAllDiagramLayoutVersionQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all DiagramLayoutVersion - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final DiagramLayoutVersionRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(DiagramLayoutVersionEntityProjector.class.getName());

}
