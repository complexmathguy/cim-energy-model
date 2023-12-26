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
 * Projector for TapChangerControl as outlined for the CQRS pattern.  All event handling and query handling related to TapChangerControl are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TapChangerControlAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("tapChangerControl")
@Component("tapChangerControl-projector")
public class TapChangerControlProjector extends TapChangerControlEntityProjector {
		
	// core constructor
	public TapChangerControlProjector(TapChangerControlRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTapChangerControlEvent
     */
    @EventHandler( payloadType=CreateTapChangerControlEvent.class )
    public void handle( CreateTapChangerControlEvent event) {
	    LOGGER.info("handling CreateTapChangerControlEvent - " + event );
	    TapChangerControl entity = new TapChangerControl();
        entity.setTapChangerControlId( event.getTapChangerControlId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerControl( entity );
    }

    /*
     * @param	event UpdateTapChangerControlEvent
     */
    @EventHandler( payloadType=UpdateTapChangerControlEvent.class )
    public void handle( UpdateTapChangerControlEvent event) {
    	LOGGER.info("handling UpdateTapChangerControlEvent - " + event );
    	
	    TapChangerControl entity = new TapChangerControl();
        entity.setTapChangerControlId( event.getTapChangerControlId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTapChangerControl( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerControl( entity );        
    }
    
    /*
     * @param	event DeleteTapChangerControlEvent
     */
    @EventHandler( payloadType=DeleteTapChangerControlEvent.class )
    public void handle( DeleteTapChangerControlEvent event) {
    	LOGGER.info("handling DeleteTapChangerControlEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TapChangerControl entity = delete( event.getTapChangerControlId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerControl( entity );

    }    




    /**
     * Method to retrieve the TapChangerControl via an TapChangerControlPrimaryKey.
     * @param 	id Long
     * @return 	TapChangerControl
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TapChangerControl handle( FindTapChangerControlQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTapChangerControlId() );
    }
    
    /**
     * Method to retrieve a collection of all TapChangerControls
     *
     * @param	query	FindAllTapChangerControlQuery 
     * @return 	List<TapChangerControl> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TapChangerControl> handle( FindAllTapChangerControlQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTapChangerControl, 
	 * but only if the id matches
	 * 
	 * @param		entity	TapChangerControl
	 */
	protected void emitFindTapChangerControl( TapChangerControl entity ) {
		LOGGER.info("handling emitFindTapChangerControl" );
		
	    queryUpdateEmitter.emit(FindTapChangerControlQuery.class,
	                            query -> query.getFilter().getTapChangerControlId().equals(entity.getTapChangerControlId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTapChangerControl
	 * 
	 * @param		entity	TapChangerControl
	 */
	protected void emitFindAllTapChangerControl( TapChangerControl entity ) {
		LOGGER.info("handling emitFindAllTapChangerControl" );
		
	    queryUpdateEmitter.emit(FindAllTapChangerControlQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TapChangerControlProjector.class.getName());

}
