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
 * Projector for AsynchronousMachineUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to AsynchronousMachineUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AsynchronousMachineUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("asynchronousMachineUserDefined")
@Component("asynchronousMachineUserDefined-projector")
public class AsynchronousMachineUserDefinedProjector extends AsynchronousMachineUserDefinedEntityProjector {
		
	// core constructor
	public AsynchronousMachineUserDefinedProjector(AsynchronousMachineUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAsynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=CreateAsynchronousMachineUserDefinedEvent.class )
    public void handle( CreateAsynchronousMachineUserDefinedEvent event) {
	    LOGGER.info("handling CreateAsynchronousMachineUserDefinedEvent - " + event );
	    AsynchronousMachineUserDefined entity = new AsynchronousMachineUserDefined();
        entity.setAsynchronousMachineUserDefinedId( event.getAsynchronousMachineUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineUserDefined( entity );
    }

    /*
     * @param	event UpdateAsynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateAsynchronousMachineUserDefinedEvent.class )
    public void handle( UpdateAsynchronousMachineUserDefinedEvent event) {
    	LOGGER.info("handling UpdateAsynchronousMachineUserDefinedEvent - " + event );
    	
	    AsynchronousMachineUserDefined entity = new AsynchronousMachineUserDefined();
        entity.setAsynchronousMachineUserDefinedId( event.getAsynchronousMachineUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAsynchronousMachineUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteAsynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteAsynchronousMachineUserDefinedEvent.class )
    public void handle( DeleteAsynchronousMachineUserDefinedEvent event) {
    	LOGGER.info("handling DeleteAsynchronousMachineUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AsynchronousMachineUserDefined entity = delete( event.getAsynchronousMachineUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAsynchronousMachineUserDefined( entity );

    }    




    /**
     * Method to retrieve the AsynchronousMachineUserDefined via an AsynchronousMachineUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	AsynchronousMachineUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AsynchronousMachineUserDefined handle( FindAsynchronousMachineUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAsynchronousMachineUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all AsynchronousMachineUserDefineds
     *
     * @param	query	FindAllAsynchronousMachineUserDefinedQuery 
     * @return 	List<AsynchronousMachineUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AsynchronousMachineUserDefined> handle( FindAllAsynchronousMachineUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAsynchronousMachineUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	AsynchronousMachineUserDefined
	 */
	protected void emitFindAsynchronousMachineUserDefined( AsynchronousMachineUserDefined entity ) {
		LOGGER.info("handling emitFindAsynchronousMachineUserDefined" );
		
	    queryUpdateEmitter.emit(FindAsynchronousMachineUserDefinedQuery.class,
	                            query -> query.getFilter().getAsynchronousMachineUserDefinedId().equals(entity.getAsynchronousMachineUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAsynchronousMachineUserDefined
	 * 
	 * @param		entity	AsynchronousMachineUserDefined
	 */
	protected void emitFindAllAsynchronousMachineUserDefined( AsynchronousMachineUserDefined entity ) {
		LOGGER.info("handling emitFindAllAsynchronousMachineUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllAsynchronousMachineUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AsynchronousMachineUserDefinedProjector.class.getName());

}
