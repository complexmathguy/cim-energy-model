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
 * Projector for SynchronousMachineUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to SynchronousMachineUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SynchronousMachineUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("synchronousMachineUserDefined")
@Component("synchronousMachineUserDefined-projector")
public class SynchronousMachineUserDefinedProjector extends SynchronousMachineUserDefinedEntityProjector {
		
	// core constructor
	public SynchronousMachineUserDefinedProjector(SynchronousMachineUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=CreateSynchronousMachineUserDefinedEvent.class )
    public void handle( CreateSynchronousMachineUserDefinedEvent event) {
	    LOGGER.info("handling CreateSynchronousMachineUserDefinedEvent - " + event );
	    SynchronousMachineUserDefined entity = new SynchronousMachineUserDefined();
        entity.setSynchronousMachineUserDefinedId( event.getSynchronousMachineUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineUserDefined( entity );
    }

    /*
     * @param	event UpdateSynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateSynchronousMachineUserDefinedEvent.class )
    public void handle( UpdateSynchronousMachineUserDefinedEvent event) {
    	LOGGER.info("handling UpdateSynchronousMachineUserDefinedEvent - " + event );
    	
	    SynchronousMachineUserDefined entity = new SynchronousMachineUserDefined();
        entity.setSynchronousMachineUserDefinedId( event.getSynchronousMachineUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSynchronousMachineUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteSynchronousMachineUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteSynchronousMachineUserDefinedEvent.class )
    public void handle( DeleteSynchronousMachineUserDefinedEvent event) {
    	LOGGER.info("handling DeleteSynchronousMachineUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SynchronousMachineUserDefined entity = delete( event.getSynchronousMachineUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSynchronousMachineUserDefined( entity );

    }    




    /**
     * Method to retrieve the SynchronousMachineUserDefined via an SynchronousMachineUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	SynchronousMachineUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SynchronousMachineUserDefined handle( FindSynchronousMachineUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSynchronousMachineUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all SynchronousMachineUserDefineds
     *
     * @param	query	FindAllSynchronousMachineUserDefinedQuery 
     * @return 	List<SynchronousMachineUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SynchronousMachineUserDefined> handle( FindAllSynchronousMachineUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSynchronousMachineUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	SynchronousMachineUserDefined
	 */
	protected void emitFindSynchronousMachineUserDefined( SynchronousMachineUserDefined entity ) {
		LOGGER.info("handling emitFindSynchronousMachineUserDefined" );
		
	    queryUpdateEmitter.emit(FindSynchronousMachineUserDefinedQuery.class,
	                            query -> query.getFilter().getSynchronousMachineUserDefinedId().equals(entity.getSynchronousMachineUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSynchronousMachineUserDefined
	 * 
	 * @param		entity	SynchronousMachineUserDefined
	 */
	protected void emitFindAllSynchronousMachineUserDefined( SynchronousMachineUserDefined entity ) {
		LOGGER.info("handling emitFindAllSynchronousMachineUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllSynchronousMachineUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SynchronousMachineUserDefinedProjector.class.getName());

}
