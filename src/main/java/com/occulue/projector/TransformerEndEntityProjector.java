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
 * Projector for TransformerEnd as outlined for the CQRS pattern.
 * 
 * Commands are handled by TransformerEndAggregate
 * 
 * @author your_name_here
 *
 */
@Component("transformerEnd-entity-projector")
public class TransformerEndEntityProjector {
		
	// core constructor
	public TransformerEndEntityProjector(TransformerEndRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a TransformerEnd
	 * 
     * @param	entity TransformerEnd
     */
    public TransformerEnd create( TransformerEnd entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a TransformerEnd
	 * 
     * @param	entity TransformerEnd
     */
    public TransformerEnd update( TransformerEnd entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a TransformerEnd
	 * 
     * @param	id		UUID
     */
    public TransformerEnd delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    TransformerEnd entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the TransformerEnd via an FindTransformerEndQuery
     * @return 	query	FindTransformerEndQuery
     */
    @SuppressWarnings("unused")
    public TransformerEnd find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a TransformerEnd - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all TransformerEnds
     *
     * @param	query	FindAllTransformerEndQuery 
     * @return 	List<TransformerEnd> 
     */
    @SuppressWarnings("unused")
    public List<TransformerEnd> findAll( FindAllTransformerEndQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all TransformerEnd - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final TransformerEndRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(TransformerEndEntityProjector.class.getName());

}
