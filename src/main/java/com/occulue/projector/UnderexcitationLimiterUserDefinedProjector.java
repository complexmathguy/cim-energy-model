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
 * Projector for UnderexcitationLimiterUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcitationLimiterUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcitationLimiterUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcitationLimiterUserDefined")
@Component("underexcitationLimiterUserDefined-projector")
public class UnderexcitationLimiterUserDefinedProjector extends UnderexcitationLimiterUserDefinedEntityProjector {
		
	// core constructor
	public UnderexcitationLimiterUserDefinedProjector(UnderexcitationLimiterUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=CreateUnderexcitationLimiterUserDefinedEvent.class )
    public void handle( CreateUnderexcitationLimiterUserDefinedEvent event) {
	    LOGGER.info("handling CreateUnderexcitationLimiterUserDefinedEvent - " + event );
	    UnderexcitationLimiterUserDefined entity = new UnderexcitationLimiterUserDefined();
        entity.setUnderexcitationLimiterUserDefinedId( event.getUnderexcitationLimiterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterUserDefined( entity );
    }

    /*
     * @param	event UpdateUnderexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateUnderexcitationLimiterUserDefinedEvent.class )
    public void handle( UpdateUnderexcitationLimiterUserDefinedEvent event) {
    	LOGGER.info("handling UpdateUnderexcitationLimiterUserDefinedEvent - " + event );
    	
	    UnderexcitationLimiterUserDefined entity = new UnderexcitationLimiterUserDefined();
        entity.setUnderexcitationLimiterUserDefinedId( event.getUnderexcitationLimiterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcitationLimiterUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteUnderexcitationLimiterUserDefinedEvent.class )
    public void handle( DeleteUnderexcitationLimiterUserDefinedEvent event) {
    	LOGGER.info("handling DeleteUnderexcitationLimiterUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcitationLimiterUserDefined entity = delete( event.getUnderexcitationLimiterUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcitationLimiterUserDefined( entity );

    }    




    /**
     * Method to retrieve the UnderexcitationLimiterUserDefined via an UnderexcitationLimiterUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	UnderexcitationLimiterUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcitationLimiterUserDefined handle( FindUnderexcitationLimiterUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcitationLimiterUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcitationLimiterUserDefineds
     *
     * @param	query	FindAllUnderexcitationLimiterUserDefinedQuery 
     * @return 	List<UnderexcitationLimiterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcitationLimiterUserDefined> handle( FindAllUnderexcitationLimiterUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcitationLimiterUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcitationLimiterUserDefined
	 */
	protected void emitFindUnderexcitationLimiterUserDefined( UnderexcitationLimiterUserDefined entity ) {
		LOGGER.info("handling emitFindUnderexcitationLimiterUserDefined" );
		
	    queryUpdateEmitter.emit(FindUnderexcitationLimiterUserDefinedQuery.class,
	                            query -> query.getFilter().getUnderexcitationLimiterUserDefinedId().equals(entity.getUnderexcitationLimiterUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcitationLimiterUserDefined
	 * 
	 * @param		entity	UnderexcitationLimiterUserDefined
	 */
	protected void emitFindAllUnderexcitationLimiterUserDefined( UnderexcitationLimiterUserDefined entity ) {
		LOGGER.info("handling emitFindAllUnderexcitationLimiterUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcitationLimiterUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcitationLimiterUserDefinedProjector.class.getName());

}
