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
 * Projector for ExcitationSystemUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to ExcitationSystemUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcitationSystemUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excitationSystemUserDefined")
@Component("excitationSystemUserDefined-projector")
public class ExcitationSystemUserDefinedProjector extends ExcitationSystemUserDefinedEntityProjector {
		
	// core constructor
	public ExcitationSystemUserDefinedProjector(ExcitationSystemUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcitationSystemUserDefinedEvent
     */
    @EventHandler( payloadType=CreateExcitationSystemUserDefinedEvent.class )
    public void handle( CreateExcitationSystemUserDefinedEvent event) {
	    LOGGER.info("handling CreateExcitationSystemUserDefinedEvent - " + event );
	    ExcitationSystemUserDefined entity = new ExcitationSystemUserDefined();
        entity.setExcitationSystemUserDefinedId( event.getExcitationSystemUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemUserDefined( entity );
    }

    /*
     * @param	event UpdateExcitationSystemUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateExcitationSystemUserDefinedEvent.class )
    public void handle( UpdateExcitationSystemUserDefinedEvent event) {
    	LOGGER.info("handling UpdateExcitationSystemUserDefinedEvent - " + event );
    	
	    ExcitationSystemUserDefined entity = new ExcitationSystemUserDefined();
        entity.setExcitationSystemUserDefinedId( event.getExcitationSystemUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcitationSystemUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteExcitationSystemUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteExcitationSystemUserDefinedEvent.class )
    public void handle( DeleteExcitationSystemUserDefinedEvent event) {
    	LOGGER.info("handling DeleteExcitationSystemUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcitationSystemUserDefined entity = delete( event.getExcitationSystemUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcitationSystemUserDefined( entity );

    }    




    /**
     * Method to retrieve the ExcitationSystemUserDefined via an ExcitationSystemUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	ExcitationSystemUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcitationSystemUserDefined handle( FindExcitationSystemUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcitationSystemUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcitationSystemUserDefineds
     *
     * @param	query	FindAllExcitationSystemUserDefinedQuery 
     * @return 	List<ExcitationSystemUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcitationSystemUserDefined> handle( FindAllExcitationSystemUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcitationSystemUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcitationSystemUserDefined
	 */
	protected void emitFindExcitationSystemUserDefined( ExcitationSystemUserDefined entity ) {
		LOGGER.info("handling emitFindExcitationSystemUserDefined" );
		
	    queryUpdateEmitter.emit(FindExcitationSystemUserDefinedQuery.class,
	                            query -> query.getFilter().getExcitationSystemUserDefinedId().equals(entity.getExcitationSystemUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcitationSystemUserDefined
	 * 
	 * @param		entity	ExcitationSystemUserDefined
	 */
	protected void emitFindAllExcitationSystemUserDefined( ExcitationSystemUserDefined entity ) {
		LOGGER.info("handling emitFindAllExcitationSystemUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllExcitationSystemUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcitationSystemUserDefinedProjector.class.getName());

}
