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
 * Projector for SvTapStep as outlined for the CQRS pattern.  All event handling and query handling related to SvTapStep are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SvTapStepAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("svTapStep")
@Component("svTapStep-projector")
public class SvTapStepProjector extends SvTapStepEntityProjector {
		
	// core constructor
	public SvTapStepProjector(SvTapStepRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSvTapStepEvent
     */
    @EventHandler( payloadType=CreateSvTapStepEvent.class )
    public void handle( CreateSvTapStepEvent event) {
	    LOGGER.info("handling CreateSvTapStepEvent - " + event );
	    SvTapStep entity = new SvTapStep();
        entity.setSvTapStepId( event.getSvTapStepId() );
        entity.setPosition( event.getPosition() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvTapStep( entity );
    }

    /*
     * @param	event UpdateSvTapStepEvent
     */
    @EventHandler( payloadType=UpdateSvTapStepEvent.class )
    public void handle( UpdateSvTapStepEvent event) {
    	LOGGER.info("handling UpdateSvTapStepEvent - " + event );
    	
	    SvTapStep entity = new SvTapStep();
        entity.setSvTapStepId( event.getSvTapStepId() );
        entity.setPosition( event.getPosition() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSvTapStep( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvTapStep( entity );        
    }
    
    /*
     * @param	event DeleteSvTapStepEvent
     */
    @EventHandler( payloadType=DeleteSvTapStepEvent.class )
    public void handle( DeleteSvTapStepEvent event) {
    	LOGGER.info("handling DeleteSvTapStepEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SvTapStep entity = delete( event.getSvTapStepId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvTapStep( entity );

    }    




    /**
     * Method to retrieve the SvTapStep via an SvTapStepPrimaryKey.
     * @param 	id Long
     * @return 	SvTapStep
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SvTapStep handle( FindSvTapStepQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSvTapStepId() );
    }
    
    /**
     * Method to retrieve a collection of all SvTapSteps
     *
     * @param	query	FindAllSvTapStepQuery 
     * @return 	List<SvTapStep> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SvTapStep> handle( FindAllSvTapStepQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSvTapStep, 
	 * but only if the id matches
	 * 
	 * @param		entity	SvTapStep
	 */
	protected void emitFindSvTapStep( SvTapStep entity ) {
		LOGGER.info("handling emitFindSvTapStep" );
		
	    queryUpdateEmitter.emit(FindSvTapStepQuery.class,
	                            query -> query.getFilter().getSvTapStepId().equals(entity.getSvTapStepId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSvTapStep
	 * 
	 * @param		entity	SvTapStep
	 */
	protected void emitFindAllSvTapStep( SvTapStep entity ) {
		LOGGER.info("handling emitFindAllSvTapStep" );
		
	    queryUpdateEmitter.emit(FindAllSvTapStepQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SvTapStepProjector.class.getName());

}
