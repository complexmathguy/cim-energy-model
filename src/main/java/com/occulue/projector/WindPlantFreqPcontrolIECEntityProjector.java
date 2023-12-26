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
 * Projector for WindPlantFreqPcontrolIEC as outlined for the CQRS pattern.
 * 
 * Commands are handled by WindPlantFreqPcontrolIECAggregate
 * 
 * @author your_name_here
 *
 */
@Component("windPlantFreqPcontrolIEC-entity-projector")
public class WindPlantFreqPcontrolIECEntityProjector {
		
	// core constructor
	public WindPlantFreqPcontrolIECEntityProjector(WindPlantFreqPcontrolIECRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a WindPlantFreqPcontrolIEC
	 * 
     * @param	entity WindPlantFreqPcontrolIEC
     */
    public WindPlantFreqPcontrolIEC create( WindPlantFreqPcontrolIEC entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a WindPlantFreqPcontrolIEC
	 * 
     * @param	entity WindPlantFreqPcontrolIEC
     */
    public WindPlantFreqPcontrolIEC update( WindPlantFreqPcontrolIEC entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a WindPlantFreqPcontrolIEC
	 * 
     * @param	id		UUID
     */
    public WindPlantFreqPcontrolIEC delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    WindPlantFreqPcontrolIEC entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the WindPlantFreqPcontrolIEC via an FindWindPlantFreqPcontrolIECQuery
     * @return 	query	FindWindPlantFreqPcontrolIECQuery
     */
    @SuppressWarnings("unused")
    public WindPlantFreqPcontrolIEC find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a WindPlantFreqPcontrolIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all WindPlantFreqPcontrolIECs
     *
     * @param	query	FindAllWindPlantFreqPcontrolIECQuery 
     * @return 	List<WindPlantFreqPcontrolIEC> 
     */
    @SuppressWarnings("unused")
    public List<WindPlantFreqPcontrolIEC> findAll( FindAllWindPlantFreqPcontrolIECQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all WindPlantFreqPcontrolIEC - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final WindPlantFreqPcontrolIECRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(WindPlantFreqPcontrolIECEntityProjector.class.getName());

}
