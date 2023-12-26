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
 * Projector for OverexcLim2 as outlined for the CQRS pattern.  All event handling and query handling related to OverexcLim2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcLim2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcLim2")
@Component("overexcLim2-projector")
public class OverexcLim2Projector extends OverexcLim2EntityProjector {
		
	// core constructor
	public OverexcLim2Projector(OverexcLim2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcLim2Event
     */
    @EventHandler( payloadType=CreateOverexcLim2Event.class )
    public void handle( CreateOverexcLim2Event event) {
	    LOGGER.info("handling CreateOverexcLim2Event - " + event );
	    OverexcLim2 entity = new OverexcLim2();
        entity.setOverexcLim2Id( event.getOverexcLim2Id() );
        entity.setIfdlim( event.getIfdlim() );
        entity.setKoi( event.getKoi() );
        entity.setVoimax( event.getVoimax() );
        entity.setVoimin( event.getVoimin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLim2( entity );
    }

    /*
     * @param	event UpdateOverexcLim2Event
     */
    @EventHandler( payloadType=UpdateOverexcLim2Event.class )
    public void handle( UpdateOverexcLim2Event event) {
    	LOGGER.info("handling UpdateOverexcLim2Event - " + event );
    	
	    OverexcLim2 entity = new OverexcLim2();
        entity.setOverexcLim2Id( event.getOverexcLim2Id() );
        entity.setIfdlim( event.getIfdlim() );
        entity.setKoi( event.getKoi() );
        entity.setVoimax( event.getVoimax() );
        entity.setVoimin( event.getVoimin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOverexcLim2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLim2( entity );        
    }
    
    /*
     * @param	event DeleteOverexcLim2Event
     */
    @EventHandler( payloadType=DeleteOverexcLim2Event.class )
    public void handle( DeleteOverexcLim2Event event) {
    	LOGGER.info("handling DeleteOverexcLim2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcLim2 entity = delete( event.getOverexcLim2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLim2( entity );

    }    




    /**
     * Method to retrieve the OverexcLim2 via an OverexcLim2PrimaryKey.
     * @param 	id Long
     * @return 	OverexcLim2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcLim2 handle( FindOverexcLim2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcLim2Id() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcLim2s
     *
     * @param	query	FindAllOverexcLim2Query 
     * @return 	List<OverexcLim2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcLim2> handle( FindAllOverexcLim2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcLim2, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcLim2
	 */
	protected void emitFindOverexcLim2( OverexcLim2 entity ) {
		LOGGER.info("handling emitFindOverexcLim2" );
		
	    queryUpdateEmitter.emit(FindOverexcLim2Query.class,
	                            query -> query.getFilter().getOverexcLim2Id().equals(entity.getOverexcLim2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcLim2
	 * 
	 * @param		entity	OverexcLim2
	 */
	protected void emitFindAllOverexcLim2( OverexcLim2 entity ) {
		LOGGER.info("handling emitFindAllOverexcLim2" );
		
	    queryUpdateEmitter.emit(FindAllOverexcLim2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcLim2Projector.class.getName());

}
