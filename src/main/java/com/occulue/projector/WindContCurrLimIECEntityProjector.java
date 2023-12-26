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
 * Projector for WindContCurrLimIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindContCurrLimIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windContCurrLimIEC-entity-projector")
public class WindContCurrLimIECEntityProjector {
		
	// core constructor
	public WindContCurrLimIECEntityProjector(WindContCurrLimIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindContCurrLimIEC
	 * 
     * @param	entity WindContCurrLimIEC
     */
    public WindContCurrLimIEC create( WindContCurrLimIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindContCurrLimIEC
	 * 
     * @param	entity WindContCurrLimIEC
     */
    public WindContCurrLimIEC update( WindContCurrLimIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindContCurrLimIEC
	 * 
     * @param	id		UUID
     */
    public WindContCurrLimIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindContCurrLimIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindContCurrLimIEC via an FindWindContCurrLimIECQuery
     * @return 	query	FindWindContCurrLimIECQuery
     */
    @SuppressWarnings("unused")
    public WindContCurrLimIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindContCurrLimIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindContCurrLimIECs
     *
     * @param	query	FindAllWindContCurrLimIECQuery 
     * @return 	List<WindContCurrLimIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindContCurrLimIEC> findAll( FindAllWindContCurrLimIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindContCurrLimIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindContCurrLimIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindContCurrLimIECEntityProjector.class.getName());

}
