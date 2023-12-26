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
 * Projector for PhaseTapChanger as outlined for the CQRS pattern.
 * 
 * Commands are handled by PhaseTapChangerAggregate
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChanger-entity-projector")
public class PhaseTapChangerEntityProjector {
		
	// core constructor
	public PhaseTapChangerEntityProjector(PhaseTapChangerRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PhaseTapChanger
	 * 
     * @param	entity PhaseTapChanger
     */
    public PhaseTapChanger create( PhaseTapChanger entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PhaseTapChanger
	 * 
     * @param	entity PhaseTapChanger
     */
    public PhaseTapChanger update( PhaseTapChanger entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PhaseTapChanger
	 * 
     * @param	id		UUID
     */
    public PhaseTapChanger delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PhaseTapChanger entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PhaseTapChanger via an FindPhaseTapChangerQuery
     * @return 	query	FindPhaseTapChangerQuery
     */
    @SuppressWarnings("unused")
    public PhaseTapChanger find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PhaseTapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangers
     *
     * @param	query	FindAllPhaseTapChangerQuery 
     * @return 	List<PhaseTapChanger> 
     */
    @SuppressWarnings("unused")
    public List<PhaseTapChanger> findAll( FindAllPhaseTapChangerQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PhaseTapChanger - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PhaseTapChangerRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerEntityProjector.class.getName());

}
