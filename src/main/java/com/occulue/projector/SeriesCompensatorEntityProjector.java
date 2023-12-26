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
 * Projector for SeriesCompensator as outlined for the CQRS pattern.
 * 
 * Commands are handled by SeriesCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
@Component("seriesCompensator-entity-projector")
public class SeriesCompensatorEntityProjector {
		
	// core constructor
	public SeriesCompensatorEntityProjector(SeriesCompensatorRepository repository ) {
        this.repository = repository;
    }	

	/*
	 * Insert a SeriesCompensator
	 * 
     * @param	entity SeriesCompensator
     */
    public SeriesCompensator create( SeriesCompensator entity) {
	    LOGGER.info("creating " + entity.toString() );
	   
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    return repository.save(entity);
        
    }

	/*
	 * Update a SeriesCompensator
	 * 
     * @param	entity SeriesCompensator
     */
    public SeriesCompensator update( SeriesCompensator entity) {
	    LOGGER.info("updating " + entity.toString() );

	    // ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		return repository.save(entity);

    }
    
	/*
	 * Delete a SeriesCompensator
	 * 
     * @param	id		UUID
     */
    public SeriesCompensator delete( UUID id ) {
	    LOGGER.info("deleting " + id.toString() );

    	// ------------------------------------------
    	// locate the entity by the provided id
    	// ------------------------------------------
	    SeriesCompensator entity = repository.findById(id).get();
	    
    	// ------------------------------------------
    	// delete what is discovered 
    	// ------------------------------------------
    	repository.delete( entity );
    	
    	return entity;
    }    




    /**
     * Method to retrieve the SeriesCompensator via an FindSeriesCompensatorQuery
     * @return 	query	FindSeriesCompensatorQuery
     */
    @SuppressWarnings("unused")
    public SeriesCompensator find( UUID id ) {
    	LOGGER.info("handling find using " + id.toString() );
    	try {
    		return repository.findById(id).get();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find a SeriesCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }
    
    /**
     * Method to retrieve a collection of all SeriesCompensators
     *
     * @param	query	FindAllSeriesCompensatorQuery 
     * @return 	List<SeriesCompensator> 
     */
    @SuppressWarnings("unused")
    public List<SeriesCompensator> findAll( FindAllSeriesCompensatorQuery query ) {
    	LOGGER.info("handling findAll using " + query.toString() );
    	try {
    		return repository.findAll();
    	}
    	catch( IllegalArgumentException exc ) {
    		LOGGER.log( Level.WARNING, "Failed to find all SeriesCompensator - {0}", exc.getMessage() );
    	}
    	return null;
    }

    //--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
    protected final SeriesCompensatorRepository repository;

    private static final Logger LOGGER 	= Logger.getLogger(SeriesCompensatorEntityProjector.class.getName());

}
