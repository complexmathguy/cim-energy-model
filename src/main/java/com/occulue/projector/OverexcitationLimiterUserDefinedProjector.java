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
 * Projector for OverexcitationLimiterUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to OverexcitationLimiterUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcitationLimiterUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcitationLimiterUserDefined")
@Component("overexcitationLimiterUserDefined-projector")
public class OverexcitationLimiterUserDefinedProjector extends OverexcitationLimiterUserDefinedEntityProjector {
		
	// core constructor
	public OverexcitationLimiterUserDefinedProjector(OverexcitationLimiterUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=CreateOverexcitationLimiterUserDefinedEvent.class )
    public void handle( CreateOverexcitationLimiterUserDefinedEvent event) {
	    LOGGER.info("handling CreateOverexcitationLimiterUserDefinedEvent - " + event );
	    OverexcitationLimiterUserDefined entity = new OverexcitationLimiterUserDefined();
        entity.setOverexcitationLimiterUserDefinedId( event.getOverexcitationLimiterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterUserDefined( entity );
    }

    /*
     * @param	event UpdateOverexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateOverexcitationLimiterUserDefinedEvent.class )
    public void handle( UpdateOverexcitationLimiterUserDefinedEvent event) {
    	LOGGER.info("handling UpdateOverexcitationLimiterUserDefinedEvent - " + event );
    	
	    OverexcitationLimiterUserDefined entity = new OverexcitationLimiterUserDefined();
        entity.setOverexcitationLimiterUserDefinedId( event.getOverexcitationLimiterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOverexcitationLimiterUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteOverexcitationLimiterUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteOverexcitationLimiterUserDefinedEvent.class )
    public void handle( DeleteOverexcitationLimiterUserDefinedEvent event) {
    	LOGGER.info("handling DeleteOverexcitationLimiterUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcitationLimiterUserDefined entity = delete( event.getOverexcitationLimiterUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcitationLimiterUserDefined( entity );

    }    




    /**
     * Method to retrieve the OverexcitationLimiterUserDefined via an OverexcitationLimiterUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	OverexcitationLimiterUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcitationLimiterUserDefined handle( FindOverexcitationLimiterUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcitationLimiterUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcitationLimiterUserDefineds
     *
     * @param	query	FindAllOverexcitationLimiterUserDefinedQuery 
     * @return 	List<OverexcitationLimiterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcitationLimiterUserDefined> handle( FindAllOverexcitationLimiterUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcitationLimiterUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcitationLimiterUserDefined
	 */
	protected void emitFindOverexcitationLimiterUserDefined( OverexcitationLimiterUserDefined entity ) {
		LOGGER.info("handling emitFindOverexcitationLimiterUserDefined" );
		
	    queryUpdateEmitter.emit(FindOverexcitationLimiterUserDefinedQuery.class,
	                            query -> query.getFilter().getOverexcitationLimiterUserDefinedId().equals(entity.getOverexcitationLimiterUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcitationLimiterUserDefined
	 * 
	 * @param		entity	OverexcitationLimiterUserDefined
	 */
	protected void emitFindAllOverexcitationLimiterUserDefined( OverexcitationLimiterUserDefined entity ) {
		LOGGER.info("handling emitFindAllOverexcitationLimiterUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllOverexcitationLimiterUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcitationLimiterUserDefinedProjector.class.getName());

}
