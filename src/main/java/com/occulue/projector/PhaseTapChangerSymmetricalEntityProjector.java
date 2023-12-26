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
 * Projector for PhaseTapChangerSymmetrical as outlined for the CQRS pattern.
 * 
 * Commands are handled by PhaseTapChangerSymmetricalAggregate
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerSymmetrical-entity-projector")
public class PhaseTapChangerSymmetricalEntityProjector {
		
	// core constructor
	public PhaseTapChangerSymmetricalEntityProjector(PhaseTapChangerSymmetricalRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PhaseTapChangerSymmetrical
	 * 
     * @param	entity PhaseTapChangerSymmetrical
     */
    public PhaseTapChangerSymmetrical create( PhaseTapChangerSymmetrical entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PhaseTapChangerSymmetrical
	 * 
     * @param	entity PhaseTapChangerSymmetrical
     */
    public PhaseTapChangerSymmetrical update( PhaseTapChangerSymmetrical entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PhaseTapChangerSymmetrical
	 * 
     * @param	id		UUID
     */
    public PhaseTapChangerSymmetrical delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PhaseTapChangerSymmetrical entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PhaseTapChangerSymmetrical via an FindPhaseTapChangerSymmetricalQuery
     * @return 	query	FindPhaseTapChangerSymmetricalQuery
     */
    @SuppressWarnings("unused")
    public PhaseTapChangerSymmetrical find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PhaseTapChangerSymmetrical - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerSymmetricals
     *
     * @param	query	FindAllPhaseTapChangerSymmetricalQuery 
     * @return 	List<PhaseTapChangerSymmetrical> 
     */
    @SuppressWarnings("unused")
    public List<PhaseTapChangerSymmetrical> findAll( FindAllPhaseTapChangerSymmetricalQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PhaseTapChangerSymmetrical - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PhaseTapChangerSymmetricalRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerSymmetricalEntityProjector.class.getName());

}
