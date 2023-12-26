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
 * Projector for PhaseTapChangerLinear as outlined for the CQRS pattern.
 * 
 * Commands are handled by PhaseTapChangerLinearAggregate
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerLinear-entity-projector")
public class PhaseTapChangerLinearEntityProjector {
		
	// core constructor
	public PhaseTapChangerLinearEntityProjector(PhaseTapChangerLinearRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PhaseTapChangerLinear
	 * 
     * @param	entity PhaseTapChangerLinear
     */
    public PhaseTapChangerLinear create( PhaseTapChangerLinear entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PhaseTapChangerLinear
	 * 
     * @param	entity PhaseTapChangerLinear
     */
    public PhaseTapChangerLinear update( PhaseTapChangerLinear entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PhaseTapChangerLinear
	 * 
     * @param	id		UUID
     */
    public PhaseTapChangerLinear delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PhaseTapChangerLinear entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PhaseTapChangerLinear via an FindPhaseTapChangerLinearQuery
     * @return 	query	FindPhaseTapChangerLinearQuery
     */
    @SuppressWarnings("unused")
    public PhaseTapChangerLinear find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PhaseTapChangerLinear - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerLinears
     *
     * @param	query	FindAllPhaseTapChangerLinearQuery 
     * @return 	List<PhaseTapChangerLinear> 
     */
    @SuppressWarnings("unused")
    public List<PhaseTapChangerLinear> findAll( FindAllPhaseTapChangerLinearQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PhaseTapChangerLinear - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PhaseTapChangerLinearRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerLinearEntityProjector.class.getName());

}
