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
 * Projector for BusNameMarker as outlined for the CQRS pattern.  All event handling and query handling related to BusNameMarker are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BusNameMarkerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("busNameMarker")
@Component("busNameMarker-projector")
public class BusNameMarkerProjector extends BusNameMarkerEntityProjector {
		
	// core constructor
	public BusNameMarkerProjector(BusNameMarkerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBusNameMarkerEvent
     */
    @EventHandler( payloadType=CreateBusNameMarkerEvent.class )
    public void handle( CreateBusNameMarkerEvent event) {
	    LOGGER.info("handling CreateBusNameMarkerEvent - " + event );
	    BusNameMarker entity = new BusNameMarker();
        entity.setBusNameMarkerId( event.getBusNameMarkerId() );
        entity.setPriority( event.getPriority() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusNameMarker( entity );
    }

    /*
     * @param	event UpdateBusNameMarkerEvent
     */
    @EventHandler( payloadType=UpdateBusNameMarkerEvent.class )
    public void handle( UpdateBusNameMarkerEvent event) {
    	LOGGER.info("handling UpdateBusNameMarkerEvent - " + event );
    	
	    BusNameMarker entity = new BusNameMarker();
        entity.setBusNameMarkerId( event.getBusNameMarkerId() );
        entity.setPriority( event.getPriority() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBusNameMarker( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusNameMarker( entity );        
    }
    
    /*
     * @param	event DeleteBusNameMarkerEvent
     */
    @EventHandler( payloadType=DeleteBusNameMarkerEvent.class )
    public void handle( DeleteBusNameMarkerEvent event) {
    	LOGGER.info("handling DeleteBusNameMarkerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BusNameMarker entity = delete( event.getBusNameMarkerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBusNameMarker( entity );

    }    




    /**
     * Method to retrieve the BusNameMarker via an BusNameMarkerPrimaryKey.
     * @param 	id Long
     * @return 	BusNameMarker
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BusNameMarker handle( FindBusNameMarkerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBusNameMarkerId() );
    }
    
    /**
     * Method to retrieve a collection of all BusNameMarkers
     *
     * @param	query	FindAllBusNameMarkerQuery 
     * @return 	List<BusNameMarker> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BusNameMarker> handle( FindAllBusNameMarkerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBusNameMarker, 
	 * but only if the id matches
	 * 
	 * @param		entity	BusNameMarker
	 */
	protected void emitFindBusNameMarker( BusNameMarker entity ) {
		LOGGER.info("handling emitFindBusNameMarker" );
		
	    queryUpdateEmitter.emit(FindBusNameMarkerQuery.class,
	                            query -> query.getFilter().getBusNameMarkerId().equals(entity.getBusNameMarkerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBusNameMarker
	 * 
	 * @param		entity	BusNameMarker
	 */
	protected void emitFindAllBusNameMarker( BusNameMarker entity ) {
		LOGGER.info("handling emitFindAllBusNameMarker" );
		
	    queryUpdateEmitter.emit(FindAllBusNameMarkerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BusNameMarkerProjector.class.getName());

}
