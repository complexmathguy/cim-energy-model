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
 * Projector for WindPitchContEmulIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindPitchContEmulIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windPitchContEmulIEC-entity-projector")
public class WindPitchContEmulIECEntityProjector {
		
	// core constructor
	public WindPitchContEmulIECEntityProjector(WindPitchContEmulIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindPitchContEmulIEC
	 * 
     * @param	entity WindPitchContEmulIEC
     */
    public WindPitchContEmulIEC create( WindPitchContEmulIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindPitchContEmulIEC
	 * 
     * @param	entity WindPitchContEmulIEC
     */
    public WindPitchContEmulIEC update( WindPitchContEmulIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindPitchContEmulIEC
	 * 
     * @param	id		UUID
     */
    public WindPitchContEmulIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindPitchContEmulIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindPitchContEmulIEC via an FindWindPitchContEmulIECQuery
     * @return 	query	FindWindPitchContEmulIECQuery
     */
    @SuppressWarnings("unused")
    public WindPitchContEmulIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindPitchContEmulIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindPitchContEmulIECs
     *
     * @param	query	FindAllWindPitchContEmulIECQuery 
     * @return 	List<WindPitchContEmulIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindPitchContEmulIEC> findAll( FindAllWindPitchContEmulIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindPitchContEmulIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindPitchContEmulIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindPitchContEmulIECEntityProjector.class.getName());

}
