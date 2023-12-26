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
 * Projector for SeriesCompensator as outlined for the CQRS pattern.  All event handling and query handling related to SeriesCompensator are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SeriesCompensatorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("seriesCompensator")
@Component("seriesCompensator-projector")
public class SeriesCompensatorProjector extends SeriesCompensatorEntityProjector {
		
	// core constructor
	public SeriesCompensatorProjector(SeriesCompensatorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSeriesCompensatorEvent
     */
    @EventHandler( payloadType=CreateSeriesCompensatorEvent.class )
    public void handle( CreateSeriesCompensatorEvent event) {
	    LOGGER.info("handling CreateSeriesCompensatorEvent - " + event );
	    SeriesCompensator entity = new SeriesCompensator();
        entity.setSeriesCompensatorId( event.getSeriesCompensatorId() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setVaristorPresent( event.getVaristorPresent() );
        entity.setVaristorRatedCurrent( event.getVaristorRatedCurrent() );
        entity.setVaristorVoltageThreshold( event.getVaristorVoltageThreshold() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeriesCompensator( entity );
    }

    /*
     * @param	event UpdateSeriesCompensatorEvent
     */
    @EventHandler( payloadType=UpdateSeriesCompensatorEvent.class )
    public void handle( UpdateSeriesCompensatorEvent event) {
    	LOGGER.info("handling UpdateSeriesCompensatorEvent - " + event );
    	
	    SeriesCompensator entity = new SeriesCompensator();
        entity.setSeriesCompensatorId( event.getSeriesCompensatorId() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setVaristorPresent( event.getVaristorPresent() );
        entity.setVaristorRatedCurrent( event.getVaristorRatedCurrent() );
        entity.setVaristorVoltageThreshold( event.getVaristorVoltageThreshold() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindSeriesCompensator( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeriesCompensator( entity );        
    }
    
    /*
     * @param	event DeleteSeriesCompensatorEvent
     */
    @EventHandler( payloadType=DeleteSeriesCompensatorEvent.class )
    public void handle( DeleteSeriesCompensatorEvent event) {
    	LOGGER.info("handling DeleteSeriesCompensatorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SeriesCompensator entity = delete( event.getSeriesCompensatorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSeriesCompensator( entity );

    }    




    /**
     * Method to retrieve the SeriesCompensator via an SeriesCompensatorPrimaryKey.
     * @param 	id Long
     * @return 	SeriesCompensator
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SeriesCompensator handle( FindSeriesCompensatorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSeriesCompensatorId() );
    }
    
    /**
     * Method to retrieve a collection of all SeriesCompensators
     *
     * @param	query	FindAllSeriesCompensatorQuery 
     * @return 	List<SeriesCompensator> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SeriesCompensator> handle( FindAllSeriesCompensatorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSeriesCompensator, 
	 * but only if the id matches
	 * 
	 * @param		entity	SeriesCompensator
	 */
	protected void emitFindSeriesCompensator( SeriesCompensator entity ) {
		LOGGER.info("handling emitFindSeriesCompensator" );
		
	    queryUpdateEmitter.emit(FindSeriesCompensatorQuery.class,
	                            query -> query.getFilter().getSeriesCompensatorId().equals(entity.getSeriesCompensatorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSeriesCompensator
	 * 
	 * @param		entity	SeriesCompensator
	 */
	protected void emitFindAllSeriesCompensator( SeriesCompensator entity ) {
		LOGGER.info("handling emitFindAllSeriesCompensator" );
		
	    queryUpdateEmitter.emit(FindAllSeriesCompensatorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SeriesCompensatorProjector.class.getName());

}
