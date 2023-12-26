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
 * Projector for MeasurementValueSource as outlined for the CQRS pattern.  All event handling and query handling related to MeasurementValueSource are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by MeasurementValueSourceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("measurementValueSource")
@Component("measurementValueSource-projector")
public class MeasurementValueSourceProjector extends MeasurementValueSourceEntityProjector {
		
	// core constructor
	public MeasurementValueSourceProjector(MeasurementValueSourceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateMeasurementValueSourceEvent
     */
    @EventHandler( payloadType=CreateMeasurementValueSourceEvent.class )
    public void handle( CreateMeasurementValueSourceEvent event) {
	    LOGGER.info("handling CreateMeasurementValueSourceEvent - " + event );
	    MeasurementValueSource entity = new MeasurementValueSource();
        entity.setMeasurementValueSourceId( event.getMeasurementValueSourceId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValueSource( entity );
    }

    /*
     * @param	event UpdateMeasurementValueSourceEvent
     */
    @EventHandler( payloadType=UpdateMeasurementValueSourceEvent.class )
    public void handle( UpdateMeasurementValueSourceEvent event) {
    	LOGGER.info("handling UpdateMeasurementValueSourceEvent - " + event );
    	
	    MeasurementValueSource entity = new MeasurementValueSource();
        entity.setMeasurementValueSourceId( event.getMeasurementValueSourceId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindMeasurementValueSource( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValueSource( entity );        
    }
    
    /*
     * @param	event DeleteMeasurementValueSourceEvent
     */
    @EventHandler( payloadType=DeleteMeasurementValueSourceEvent.class )
    public void handle( DeleteMeasurementValueSourceEvent event) {
    	LOGGER.info("handling DeleteMeasurementValueSourceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	MeasurementValueSource entity = delete( event.getMeasurementValueSourceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllMeasurementValueSource( entity );

    }    




    /**
     * Method to retrieve the MeasurementValueSource via an MeasurementValueSourcePrimaryKey.
     * @param 	id Long
     * @return 	MeasurementValueSource
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public MeasurementValueSource handle( FindMeasurementValueSourceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getMeasurementValueSourceId() );
    }
    
    /**
     * Method to retrieve a collection of all MeasurementValueSources
     *
     * @param	query	FindAllMeasurementValueSourceQuery 
     * @return 	List<MeasurementValueSource> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<MeasurementValueSource> handle( FindAllMeasurementValueSourceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindMeasurementValueSource, 
	 * but only if the id matches
	 * 
	 * @param		entity	MeasurementValueSource
	 */
	protected void emitFindMeasurementValueSource( MeasurementValueSource entity ) {
		LOGGER.info("handling emitFindMeasurementValueSource" );
		
	    queryUpdateEmitter.emit(FindMeasurementValueSourceQuery.class,
	                            query -> query.getFilter().getMeasurementValueSourceId().equals(entity.getMeasurementValueSourceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllMeasurementValueSource
	 * 
	 * @param		entity	MeasurementValueSource
	 */
	protected void emitFindAllMeasurementValueSource( MeasurementValueSource entity ) {
		LOGGER.info("handling emitFindAllMeasurementValueSource" );
		
	    queryUpdateEmitter.emit(FindAllMeasurementValueSourceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(MeasurementValueSourceProjector.class.getName());

}
