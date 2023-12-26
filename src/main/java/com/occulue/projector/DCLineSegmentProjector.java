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
 * Projector for DCLineSegment as outlined for the CQRS pattern.  All event handling and query handling related to DCLineSegment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCLineSegmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCLineSegment")
@Component("dCLineSegment-projector")
public class DCLineSegmentProjector extends DCLineSegmentEntityProjector {
		
	// core constructor
	public DCLineSegmentProjector(DCLineSegmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCLineSegmentEvent
     */
    @EventHandler( payloadType=CreateDCLineSegmentEvent.class )
    public void handle( CreateDCLineSegmentEvent event) {
	    LOGGER.info("handling CreateDCLineSegmentEvent - " + event );
	    DCLineSegment entity = new DCLineSegment();
        entity.setDCLineSegmentId( event.getDCLineSegmentId() );
        entity.setCapacitance( event.getCapacitance() );
        entity.setInductance( event.getInductance() );
        entity.setLength( event.getLength() );
        entity.setResistance( event.getResistance() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLineSegment( entity );
    }

    /*
     * @param	event UpdateDCLineSegmentEvent
     */
    @EventHandler( payloadType=UpdateDCLineSegmentEvent.class )
    public void handle( UpdateDCLineSegmentEvent event) {
    	LOGGER.info("handling UpdateDCLineSegmentEvent - " + event );
    	
	    DCLineSegment entity = new DCLineSegment();
        entity.setDCLineSegmentId( event.getDCLineSegmentId() );
        entity.setCapacitance( event.getCapacitance() );
        entity.setInductance( event.getInductance() );
        entity.setLength( event.getLength() );
        entity.setResistance( event.getResistance() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCLineSegment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLineSegment( entity );        
    }
    
    /*
     * @param	event DeleteDCLineSegmentEvent
     */
    @EventHandler( payloadType=DeleteDCLineSegmentEvent.class )
    public void handle( DeleteDCLineSegmentEvent event) {
    	LOGGER.info("handling DeleteDCLineSegmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCLineSegment entity = delete( event.getDCLineSegmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCLineSegment( entity );

    }    




    /**
     * Method to retrieve the DCLineSegment via an DCLineSegmentPrimaryKey.
     * @param 	id Long
     * @return 	DCLineSegment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCLineSegment handle( FindDCLineSegmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCLineSegmentId() );
    }
    
    /**
     * Method to retrieve a collection of all DCLineSegments
     *
     * @param	query	FindAllDCLineSegmentQuery 
     * @return 	List<DCLineSegment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCLineSegment> handle( FindAllDCLineSegmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCLineSegment, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCLineSegment
	 */
	protected void emitFindDCLineSegment( DCLineSegment entity ) {
		LOGGER.info("handling emitFindDCLineSegment" );
		
	    queryUpdateEmitter.emit(FindDCLineSegmentQuery.class,
	                            query -> query.getFilter().getDCLineSegmentId().equals(entity.getDCLineSegmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCLineSegment
	 * 
	 * @param		entity	DCLineSegment
	 */
	protected void emitFindAllDCLineSegment( DCLineSegment entity ) {
		LOGGER.info("handling emitFindAllDCLineSegment" );
		
	    queryUpdateEmitter.emit(FindAllDCLineSegmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCLineSegmentProjector.class.getName());

}
