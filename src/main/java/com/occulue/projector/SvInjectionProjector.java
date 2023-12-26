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
 * Projector for SvInjection as outlined for the CQRS pattern.  All event handling and query handling related to SvInjection are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SvInjectionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("svInjection")
@Component("svInjection-projector")
public class SvInjectionProjector extends SvInjectionEntityProjector {
		
	// core constructor
	public SvInjectionProjector(SvInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSvInjectionEvent
     */
    @EventHandler( payloadType=CreateSvInjectionEvent.class )
    public void handle( CreateSvInjectionEvent event) {
	    LOGGER.info("handling CreateSvInjectionEvent - " + event );
	    SvInjection entity = new SvInjection();
        entity.setSvInjectionId( event.getSvInjectionId() );
        entity.setPInjection( event.getPInjection() );
        entity.setQInjection( event.getQInjection() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvInjection( entity );
    }

    /*
     * @param	event UpdateSvInjectionEvent
     */
    @EventHandler( payloadType=UpdateSvInjectionEvent.class )
    public void handle( UpdateSvInjectionEvent event) {
    	LOGGER.info("handling UpdateSvInjectionEvent - " + event );
    	
	    SvInjection entity = new SvInjection();
        entity.setSvInjectionId( event.getSvInjectionId() );
        entity.setPInjection( event.getPInjection() );
        entity.setQInjection( event.getQInjection() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSvInjection( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvInjection( entity );        
    }
    
    /*
     * @param	event DeleteSvInjectionEvent
     */
    @EventHandler( payloadType=DeleteSvInjectionEvent.class )
    public void handle( DeleteSvInjectionEvent event) {
    	LOGGER.info("handling DeleteSvInjectionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SvInjection entity = delete( event.getSvInjectionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSvInjection( entity );

    }    




    /**
     * Method to retrieve the SvInjection via an SvInjectionPrimaryKey.
     * @param 	id Long
     * @return 	SvInjection
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SvInjection handle( FindSvInjectionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSvInjectionId() );
    }
    
    /**
     * Method to retrieve a collection of all SvInjections
     *
     * @param	query	FindAllSvInjectionQuery 
     * @return 	List<SvInjection> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SvInjection> handle( FindAllSvInjectionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSvInjection, 
	 * but only if the id matches
	 * 
	 * @param		entity	SvInjection
	 */
	protected void emitFindSvInjection( SvInjection entity ) {
		LOGGER.info("handling emitFindSvInjection" );
		
	    queryUpdateEmitter.emit(FindSvInjectionQuery.class,
	                            query -> query.getFilter().getSvInjectionId().equals(entity.getSvInjectionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSvInjection
	 * 
	 * @param		entity	SvInjection
	 */
	protected void emitFindAllSvInjection( SvInjection entity ) {
		LOGGER.info("handling emitFindAllSvInjection" );
		
	    queryUpdateEmitter.emit(FindAllSvInjectionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SvInjectionProjector.class.getName());

}
