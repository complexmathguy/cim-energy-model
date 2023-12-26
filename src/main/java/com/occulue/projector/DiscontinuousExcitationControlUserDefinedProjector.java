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
 * Projector for DiscontinuousExcitationControlUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to DiscontinuousExcitationControlUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscontinuousExcitationControlUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discontinuousExcitationControlUserDefined")
@Component("discontinuousExcitationControlUserDefined-projector")
public class DiscontinuousExcitationControlUserDefinedProjector extends DiscontinuousExcitationControlUserDefinedEntityProjector {
		
	// core constructor
	public DiscontinuousExcitationControlUserDefinedProjector(DiscontinuousExcitationControlUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscontinuousExcitationControlUserDefinedEvent
     */
    @EventHandler( payloadType=CreateDiscontinuousExcitationControlUserDefinedEvent.class )
    public void handle( CreateDiscontinuousExcitationControlUserDefinedEvent event) {
	    LOGGER.info("handling CreateDiscontinuousExcitationControlUserDefinedEvent - " + event );
	    DiscontinuousExcitationControlUserDefined entity = new DiscontinuousExcitationControlUserDefined();
        entity.setDiscontinuousExcitationControlUserDefinedId( event.getDiscontinuousExcitationControlUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscontinuousExcitationControlUserDefined( entity );
    }

    /*
     * @param	event UpdateDiscontinuousExcitationControlUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateDiscontinuousExcitationControlUserDefinedEvent.class )
    public void handle( UpdateDiscontinuousExcitationControlUserDefinedEvent event) {
    	LOGGER.info("handling UpdateDiscontinuousExcitationControlUserDefinedEvent - " + event );
    	
	    DiscontinuousExcitationControlUserDefined entity = new DiscontinuousExcitationControlUserDefined();
        entity.setDiscontinuousExcitationControlUserDefinedId( event.getDiscontinuousExcitationControlUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscontinuousExcitationControlUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscontinuousExcitationControlUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteDiscontinuousExcitationControlUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteDiscontinuousExcitationControlUserDefinedEvent.class )
    public void handle( DeleteDiscontinuousExcitationControlUserDefinedEvent event) {
    	LOGGER.info("handling DeleteDiscontinuousExcitationControlUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiscontinuousExcitationControlUserDefined entity = delete( event.getDiscontinuousExcitationControlUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscontinuousExcitationControlUserDefined( entity );

    }    




    /**
     * Method to retrieve the DiscontinuousExcitationControlUserDefined via an DiscontinuousExcitationControlUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	DiscontinuousExcitationControlUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiscontinuousExcitationControlUserDefined handle( FindDiscontinuousExcitationControlUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscontinuousExcitationControlUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all DiscontinuousExcitationControlUserDefineds
     *
     * @param	query	FindAllDiscontinuousExcitationControlUserDefinedQuery 
     * @return 	List<DiscontinuousExcitationControlUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiscontinuousExcitationControlUserDefined> handle( FindAllDiscontinuousExcitationControlUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscontinuousExcitationControlUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiscontinuousExcitationControlUserDefined
	 */
	protected void emitFindDiscontinuousExcitationControlUserDefined( DiscontinuousExcitationControlUserDefined entity ) {
		LOGGER.info("handling emitFindDiscontinuousExcitationControlUserDefined" );
		
	    queryUpdateEmitter.emit(FindDiscontinuousExcitationControlUserDefinedQuery.class,
	                            query -> query.getFilter().getDiscontinuousExcitationControlUserDefinedId().equals(entity.getDiscontinuousExcitationControlUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscontinuousExcitationControlUserDefined
	 * 
	 * @param		entity	DiscontinuousExcitationControlUserDefined
	 */
	protected void emitFindAllDiscontinuousExcitationControlUserDefined( DiscontinuousExcitationControlUserDefined entity ) {
		LOGGER.info("handling emitFindAllDiscontinuousExcitationControlUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllDiscontinuousExcitationControlUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscontinuousExcitationControlUserDefinedProjector.class.getName());

}
