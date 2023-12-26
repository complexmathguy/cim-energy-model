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
 * Projector for PhaseTapChangerAsymmetrical as outlined for the CQRS pattern.
 * 
 * Commands are handled by PhaseTapChangerAsymmetricalAggregate
 * 
 * @author your_name_here
 *
 */
@Component("phaseTapChangerAsymmetrical-entity-projector")
public class PhaseTapChangerAsymmetricalEntityProjector {
		
	// core constructor
	public PhaseTapChangerAsymmetricalEntityProjector(PhaseTapChangerAsymmetricalRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a PhaseTapChangerAsymmetrical
	 * 
     * @param	entity PhaseTapChangerAsymmetrical
     */
    public PhaseTapChangerAsymmetrical create( PhaseTapChangerAsymmetrical entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a PhaseTapChangerAsymmetrical
	 * 
     * @param	entity PhaseTapChangerAsymmetrical
     */
    public PhaseTapChangerAsymmetrical update( PhaseTapChangerAsymmetrical entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a PhaseTapChangerAsymmetrical
	 * 
     * @param	id		UUID
     */
    public PhaseTapChangerAsymmetrical delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    PhaseTapChangerAsymmetrical entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the PhaseTapChangerAsymmetrical via an FindPhaseTapChangerAsymmetricalQuery
     * @return 	query	FindPhaseTapChangerAsymmetricalQuery
     */
    @SuppressWarnings("unused")
    public PhaseTapChangerAsymmetrical find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a PhaseTapChangerAsymmetrical - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerAsymmetricals
     *
     * @param	query	FindAllPhaseTapChangerAsymmetricalQuery 
     * @return 	List<PhaseTapChangerAsymmetrical> 
     */
    @SuppressWarnings("unused")
    public List<PhaseTapChangerAsymmetrical> findAll( FindAllPhaseTapChangerAsymmetricalQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all PhaseTapChangerAsymmetrical - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final PhaseTapChangerAsymmetricalRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerAsymmetricalEntityProjector.class.getName());

}
