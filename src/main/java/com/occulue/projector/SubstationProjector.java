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

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.repository.*;

/**
 * Projector for Substation as outlined for the CQRS pattern.  All event handling and query handling related to Substation are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SubstationAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("substation")
@Component("substation-projector")
public class SubstationProjector extends SubstationEntityProjector {
		
	// core constructor
	public SubstationProjector(SubstationRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSubstationEvent
     */
    @EventHandler( payloadType=CreateSubstationEvent.class )
    public void handle( CreateSubstationEvent event) {
	    LOGGER.info("handling CreateSubstationEvent - " + event );
	    Substation entity = new Substation();
        entity.setSubstationId( event.getSubstationId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubstation( entity );
    }

    /*
     * @param	event UpdateSubstationEvent
     */
    @EventHandler( payloadType=UpdateSubstationEvent.class )
    public void handle( UpdateSubstationEvent event) {
    	LOGGER.info("handling UpdateSubstationEvent - " + event );
    	
	    Substation entity = new Substation();
        entity.setSubstationId( event.getSubstationId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSubstation( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubstation( entity );        
    }
    
    /*
     * @param	event DeleteSubstationEvent
     */
    @EventHandler( payloadType=DeleteSubstationEvent.class )
    public void handle( DeleteSubstationEvent event) {
    	LOGGER.info("handling DeleteSubstationEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Substation entity = delete( event.getSubstationId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSubstation( entity );

    }    




    /**
     * Method to retrieve the Substation via an SubstationPrimaryKey.
     * @param 	id Long
     * @return 	Substation
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Substation handle( FindSubstationQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSubstationId() );
    }
    
    /**
     * Method to retrieve a collection of all Substations
     *
     * @param	query	FindAllSubstationQuery 
     * @return 	List<Substation> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Substation> handle( FindAllSubstationQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSubstation, 
	 * but only if the id matches
	 * 
	 * @param		entity	Substation
	 */
	protected void emitFindSubstation( Substation entity ) {
		LOGGER.info("handling emitFindSubstation" );
		
	    queryUpdateEmitter.emit(FindSubstationQuery.class,
	                            query -> query.getFilter().getSubstationId().equals(entity.getSubstationId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSubstation
	 * 
	 * @param		entity	Substation
	 */
	protected void emitFindAllSubstation( Substation entity ) {
		LOGGER.info("handling emitFindAllSubstation" );
		
	    queryUpdateEmitter.emit(FindAllSubstationQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SubstationProjector.class.getName());

}
