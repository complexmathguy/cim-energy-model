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
 * Projector for SynchronousMachineSimplified as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachineSimplified are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineSimplifiedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachineSimplified")
@Component("synchronousMachineSimplified-projector")
public class SynchronousMachineSimplifiedProjector extends SynchronousMachineSimplifiedEntityProjector {
		
	// core constructor
	public SynchronousMachineSimplifiedProjector(SynchronousMachineSimplifiedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineSimplifiedEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineSimplifiedEvent.class )
    public void handle( CreateSynchronousMachineSimplifiedEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineSimplifiedEvent - " + event );
	    SynchronousMachineSimplified entity = new SynchronousMachineSimplified();
        entity.setSynchronousMachineSimplifiedId( event.getSynchronousMachineSimplifiedId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineSimplified( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineSimplifiedEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineSimplifiedEvent.class )
    public void handle( UpdateSynchronousMachineSimplifiedEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineSimplifiedEvent - " + event );
    	
	    SynchronousMachineSimplified entity = new SynchronousMachineSimplified();
        entity.setSynchronousMachineSimplifiedId( event.getSynchronousMachineSimplifiedId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachineSimplified( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineSimplified( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineSimplifiedEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineSimplifiedEvent.class )
    public void handle( DeleteSynchronousMachineSimplifiedEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineSimplifiedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachineSimplified entity = delete( event.getSynchronousMachineSimplifiedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineSimplified( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachineSimplified via an SynchronousMachineSimplifiedPrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachineSimplified
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachineSimplified handle( FindSynchronousMachineSimplifiedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineSimplifiedId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineSimplifieds
     *
     * @param	query	FindAllSynchronousMachineSimplifiedQuery 
     * @return 	List<SynchronousMachineSimplified> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachineSimplified> handle( FindAllSynchronousMachineSimplifiedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachineSimplified, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachineSimplified
	 */
	protected void emitFindSynchronousMachineSimplified( SynchronousMachineSimplified entity ) {
		LOGGER.info("handling emitFindSynchronousMachineSimplified" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineSimplifiedQuery.class,
	                            query -> query.getFilter().getSynchronousMachineSimplifiedId().equals(entity.getSynchronousMachineSimplifiedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachineSimplified
	 * 
	 * @param		entity	SynchronousMachineSimplified
	 */
	protected void emitFindAllSynchronousMachineSimplified( SynchronousMachineSimplified entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachineSimplified" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineSimplifiedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineSimplifiedProjector.class.getName());

}
