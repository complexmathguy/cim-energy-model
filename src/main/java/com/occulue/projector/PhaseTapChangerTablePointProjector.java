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
 * Projector for PhaseTapChangerTablePoint as outlined for the CQRS pattern.  All event handling and query handling related to PhaseTapChangerTablePoint are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PhaseTapChangerTablePointAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("phaseTapChangerTablePoint")
@Component("phaseTapChangerTablePoint-projector")
public class PhaseTapChangerTablePointProjector extends PhaseTapChangerTablePointEntityProjector {
		
	// core constructor
	public PhaseTapChangerTablePointProjector(PhaseTapChangerTablePointRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePhaseTapChangerTablePointEvent
     */
    @EventHandler( payloadType=CreatePhaseTapChangerTablePointEvent.class )
    public void handle( CreatePhaseTapChangerTablePointEvent event) {
	    LOGGER.info("handling CreatePhaseTapChangerTablePointEvent - " + event );
	    PhaseTapChangerTablePoint entity = new PhaseTapChangerTablePoint();
        entity.setPhaseTapChangerTablePointId( event.getPhaseTapChangerTablePointId() );
        entity.setAngle( event.getAngle() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTablePoint( entity );
    }

    /*
     * @param	event UpdatePhaseTapChangerTablePointEvent
     */
    @EventHandler( payloadType=UpdatePhaseTapChangerTablePointEvent.class )
    public void handle( UpdatePhaseTapChangerTablePointEvent event) {
    	LOGGER.info("handling UpdatePhaseTapChangerTablePointEvent - " + event );
    	
	    PhaseTapChangerTablePoint entity = new PhaseTapChangerTablePoint();
        entity.setPhaseTapChangerTablePointId( event.getPhaseTapChangerTablePointId() );
        entity.setAngle( event.getAngle() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPhaseTapChangerTablePoint( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTablePoint( entity );        
    }
    
    /*
     * @param	event DeletePhaseTapChangerTablePointEvent
     */
    @EventHandler( payloadType=DeletePhaseTapChangerTablePointEvent.class )
    public void handle( DeletePhaseTapChangerTablePointEvent event) {
    	LOGGER.info("handling DeletePhaseTapChangerTablePointEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PhaseTapChangerTablePoint entity = delete( event.getPhaseTapChangerTablePointId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPhaseTapChangerTablePoint( entity );

    }    




    /**
     * Method to retrieve the PhaseTapChangerTablePoint via an PhaseTapChangerTablePointPrimaryKey.
     * @param 	id Long
     * @return 	PhaseTapChangerTablePoint
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PhaseTapChangerTablePoint handle( FindPhaseTapChangerTablePointQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPhaseTapChangerTablePointId() );
    }
    
    /**
     * Method to retrieve a collection of all PhaseTapChangerTablePoints
     *
     * @param	query	FindAllPhaseTapChangerTablePointQuery 
     * @return 	List<PhaseTapChangerTablePoint> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PhaseTapChangerTablePoint> handle( FindAllPhaseTapChangerTablePointQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPhaseTapChangerTablePoint, 
	 * but only if the id matches
	 * 
	 * @param		entity	PhaseTapChangerTablePoint
	 */
	protected void emitFindPhaseTapChangerTablePoint( PhaseTapChangerTablePoint entity ) {
		LOGGER.info("handling emitFindPhaseTapChangerTablePoint" );
		
	    queryUpdateEmitter.emit(FindPhaseTapChangerTablePointQuery.class,
	                            query -> query.getFilter().getPhaseTapChangerTablePointId().equals(entity.getPhaseTapChangerTablePointId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPhaseTapChangerTablePoint
	 * 
	 * @param		entity	PhaseTapChangerTablePoint
	 */
	protected void emitFindAllPhaseTapChangerTablePoint( PhaseTapChangerTablePoint entity ) {
		LOGGER.info("handling emitFindAllPhaseTapChangerTablePoint" );
		
	    queryUpdateEmitter.emit(FindAllPhaseTapChangerTablePointQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PhaseTapChangerTablePointProjector.class.getName());

}
