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
 * Projector for LoadComposite as outlined for the CQRS pattern.
 * 
 * Commands are handled by LoadCompositeAggregate
 * 
 * @author your_name_here
 *
 */
@Component("loadComposite-entity-projector")
public class LoadCompositeEntityProjector {
		
	// core constructor
	public LoadCompositeEntityProjector(LoadCompositeRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a LoadComposite
	 * 
     * @param	entity LoadComposite
     */
    public LoadComposite create( LoadComposite entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a LoadComposite
	 * 
     * @param	entity LoadComposite
     */
    public LoadComposite update( LoadComposite entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a LoadComposite
	 * 
     * @param	id		UUID
     */
    public LoadComposite delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    LoadComposite entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the LoadComposite via an FindLoadCompositeQuery
     * @return 	query	FindLoadCompositeQuery
     */
    @SuppressWarnings("unused")
    public LoadComposite find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a LoadComposite - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all LoadComposites
     *
     * @param	query	FindAllLoadCompositeQuery 
     * @return 	List<LoadComposite> 
     */
    @SuppressWarnings("unused")
    public List<LoadComposite> findAll( FindAllLoadCompositeQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all LoadComposite - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final LoadCompositeRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(LoadCompositeEntityProjector.class.getName());

}
