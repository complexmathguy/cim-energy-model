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
 * Projector for NonlinearShuntCompensator as outlined for the CQRS pattern.  All event handling and query handling related to NonlinearShuntCompensator are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by NonlinearShuntCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("nonlinearShuntCompensator")
@Component("nonlinearShuntCompensator-projector")
public class NonlinearShuntCompensatorProjector extends NonlinearShuntCompensatorEntityProjector {
		
	// core constructor
	public NonlinearShuntCompensatorProjector(NonlinearShuntCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateNonlinearShuntCompensatorEvent
     */
    @EventHandler( payloadType=CreateNonlinearShuntCompensatorEvent.class )
    public void handle( CreateNonlinearShuntCompensatorEvent event) {
	    LOGGER.info("handling CreateNonlinearShuntCompensatorEvent - " + event );
	    NonlinearShuntCompensator entity = new NonlinearShuntCompensator();
        entity.setNonlinearShuntCompensatorId( event.getNonlinearShuntCompensatorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensator( entity );
    }

    /*
     * @param	event UpdateNonlinearShuntCompensatorEvent
     */
    @EventHandler( payloadType=UpdateNonlinearShuntCompensatorEvent.class )
    public void handle( UpdateNonlinearShuntCompensatorEvent event) {
    	LOGGER.info("handling UpdateNonlinearShuntCompensatorEvent - " + event );
    	
	    NonlinearShuntCompensator entity = new NonlinearShuntCompensator();
        entity.setNonlinearShuntCompensatorId( event.getNonlinearShuntCompensatorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindNonlinearShuntCompensator( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensator( entity );        
    }
    
    /*
     * @param	event DeleteNonlinearShuntCompensatorEvent
     */
    @EventHandler( payloadType=DeleteNonlinearShuntCompensatorEvent.class )
    public void handle( DeleteNonlinearShuntCompensatorEvent event) {
    	LOGGER.info("handling DeleteNonlinearShuntCompensatorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	NonlinearShuntCompensator entity = delete( event.getNonlinearShuntCompensatorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllNonlinearShuntCompensator( entity );

    }    




    /**
     * Method to retrieve the NonlinearShuntCompensator via an NonlinearShuntCompensatorPrimaryKey.
     * @param 	id Long
     * @return 	NonlinearShuntCompensator
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public NonlinearShuntCompensator handle( FindNonlinearShuntCompensatorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getNonlinearShuntCompensatorId() );
    }
    
    /**
     * Method to retrieve a collection of all NonlinearShuntCompensators
     *
     * @param	query	FindAllNonlinearShuntCompensatorQuery 
     * @return 	List<NonlinearShuntCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<NonlinearShuntCompensator> handle( FindAllNonlinearShuntCompensatorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindNonlinearShuntCompensator, 
	 * but only if the id matches
	 * 
	 * @param		entity	NonlinearShuntCompensator
	 */
	protected void emitFindNonlinearShuntCompensator( NonlinearShuntCompensator entity ) {
		LOGGER.info("handling emitFindNonlinearShuntCompensator" );
		
	    queryUpdateEmitter.emit(FindNonlinearShuntCompensatorQuery.class,
	                            query -> query.getFilter().getNonlinearShuntCompensatorId().equals(entity.getNonlinearShuntCompensatorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllNonlinearShuntCompensator
	 * 
	 * @param		entity	NonlinearShuntCompensator
	 */
	protected void emitFindAllNonlinearShuntCompensator( NonlinearShuntCompensator entity ) {
		LOGGER.info("handling emitFindAllNonlinearShuntCompensator" );
		
	    queryUpdateEmitter.emit(FindAllNonlinearShuntCompensatorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(NonlinearShuntCompensatorProjector.class.getName());

}
