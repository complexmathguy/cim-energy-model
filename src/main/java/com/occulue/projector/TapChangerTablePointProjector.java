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
 * Projector for TapChangerTablePoint as outlined for the CQRS pattern.  All event handling and query handling related to TapChangerTablePoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TapChangerTablePointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("tapChangerTablePoint")
@Component("tapChangerTablePoint-projector")
public class TapChangerTablePointProjector extends TapChangerTablePointEntityProjector {
		
	// core constructor
	public TapChangerTablePointProjector(TapChangerTablePointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTapChangerTablePointEvent
     */
    @EventHandler( payloadType=CreateTapChangerTablePointEvent.class )
    public void handle( CreateTapChangerTablePointEvent event) {
	    LOGGER.info("handling CreateTapChangerTablePointEvent - " + event );
	    TapChangerTablePoint entity = new TapChangerTablePoint();
        entity.setTapChangerTablePointId( event.getTapChangerTablePointId() );
        entity.setB( event.getB() );
        entity.setG( event.getG() );
        entity.setR( event.getR() );
        entity.setRatio( event.getRatio() );
        entity.setStep( event.getStep() );
        entity.setX( event.getX() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerTablePoint( entity );
    }

    /*
     * @param	event UpdateTapChangerTablePointEvent
     */
    @EventHandler( payloadType=UpdateTapChangerTablePointEvent.class )
    public void handle( UpdateTapChangerTablePointEvent event) {
    	LOGGER.info("handling UpdateTapChangerTablePointEvent - " + event );
    	
	    TapChangerTablePoint entity = new TapChangerTablePoint();
        entity.setTapChangerTablePointId( event.getTapChangerTablePointId() );
        entity.setB( event.getB() );
        entity.setG( event.getG() );
        entity.setR( event.getR() );
        entity.setRatio( event.getRatio() );
        entity.setStep( event.getStep() );
        entity.setX( event.getX() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTapChangerTablePoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerTablePoint( entity );        
    }
    
    /*
     * @param	event DeleteTapChangerTablePointEvent
     */
    @EventHandler( payloadType=DeleteTapChangerTablePointEvent.class )
    public void handle( DeleteTapChangerTablePointEvent event) {
    	LOGGER.info("handling DeleteTapChangerTablePointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TapChangerTablePoint entity = delete( event.getTapChangerTablePointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChangerTablePoint( entity );

    }    




    /**
     * Method to retrieve the TapChangerTablePoint via an TapChangerTablePointPrimaryKey.
     * @param 	id Long
     * @return 	TapChangerTablePoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TapChangerTablePoint handle( FindTapChangerTablePointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTapChangerTablePointId() );
    }
    
    /**
     * Method to retrieve a collection of all TapChangerTablePoints
     *
     * @param	query	FindAllTapChangerTablePointQuery 
     * @return 	List<TapChangerTablePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TapChangerTablePoint> handle( FindAllTapChangerTablePointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTapChangerTablePoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	TapChangerTablePoint
	 */
	protected void emitFindTapChangerTablePoint( TapChangerTablePoint entity ) {
		LOGGER.info("handling emitFindTapChangerTablePoint" );
		
	    queryUpdateEmitter.emit(FindTapChangerTablePointQuery.class,
	                            query -> query.getFilter().getTapChangerTablePointId().equals(entity.getTapChangerTablePointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTapChangerTablePoint
	 * 
	 * @param		entity	TapChangerTablePoint
	 */
	protected void emitFindAllTapChangerTablePoint( TapChangerTablePoint entity ) {
		LOGGER.info("handling emitFindAllTapChangerTablePoint" );
		
	    queryUpdateEmitter.emit(FindAllTapChangerTablePointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TapChangerTablePointProjector.class.getName());

}
