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
 * Projector for PowerTransformerEnd as outlined for the CQRS pattern.  All event handling and query handling related to PowerTransformerEnd are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PowerTransformerEndAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("powerTransformerEnd")
@Component("powerTransformerEnd-projector")
public class PowerTransformerEndProjector extends PowerTransformerEndEntityProjector {
		
	// core constructor
	public PowerTransformerEndProjector(PowerTransformerEndRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePowerTransformerEndEvent
     */
    @EventHandler( payloadType=CreatePowerTransformerEndEvent.class )
    public void handle( CreatePowerTransformerEndEvent event) {
	    LOGGER.info("handling CreatePowerTransformerEndEvent - " + event );
	    PowerTransformerEnd entity = new PowerTransformerEnd();
        entity.setPowerTransformerEndId( event.getPowerTransformerEndId() );
        entity.setB( event.getB() );
        entity.setB0( event.getB0() );
        entity.setConnectionKind( event.getConnectionKind() );
        entity.setG( event.getG() );
        entity.setG0( event.getG0() );
        entity.setPhaseAngleClock( event.getPhaseAngleClock() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setRatedS( event.getRatedS() );
        entity.setRatedU( event.getRatedU() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformerEnd( entity );
    }

    /*
     * @param	event UpdatePowerTransformerEndEvent
     */
    @EventHandler( payloadType=UpdatePowerTransformerEndEvent.class )
    public void handle( UpdatePowerTransformerEndEvent event) {
    	LOGGER.info("handling UpdatePowerTransformerEndEvent - " + event );
    	
	    PowerTransformerEnd entity = new PowerTransformerEnd();
        entity.setPowerTransformerEndId( event.getPowerTransformerEndId() );
        entity.setB( event.getB() );
        entity.setB0( event.getB0() );
        entity.setConnectionKind( event.getConnectionKind() );
        entity.setG( event.getG() );
        entity.setG0( event.getG0() );
        entity.setPhaseAngleClock( event.getPhaseAngleClock() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setRatedS( event.getRatedS() );
        entity.setRatedU( event.getRatedU() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPowerTransformerEnd( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformerEnd( entity );        
    }
    
    /*
     * @param	event DeletePowerTransformerEndEvent
     */
    @EventHandler( payloadType=DeletePowerTransformerEndEvent.class )
    public void handle( DeletePowerTransformerEndEvent event) {
    	LOGGER.info("handling DeletePowerTransformerEndEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PowerTransformerEnd entity = delete( event.getPowerTransformerEndId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPowerTransformerEnd( entity );

    }    




    /**
     * Method to retrieve the PowerTransformerEnd via an PowerTransformerEndPrimaryKey.
     * @param 	id Long
     * @return 	PowerTransformerEnd
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PowerTransformerEnd handle( FindPowerTransformerEndQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPowerTransformerEndId() );
    }
    
    /**
     * Method to retrieve a collection of all PowerTransformerEnds
     *
     * @param	query	FindAllPowerTransformerEndQuery 
     * @return 	List<PowerTransformerEnd> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PowerTransformerEnd> handle( FindAllPowerTransformerEndQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPowerTransformerEnd, 
	 * but only if the id matches
	 * 
	 * @param		entity	PowerTransformerEnd
	 */
	protected void emitFindPowerTransformerEnd( PowerTransformerEnd entity ) {
		LOGGER.info("handling emitFindPowerTransformerEnd" );
		
	    queryUpdateEmitter.emit(FindPowerTransformerEndQuery.class,
	                            query -> query.getFilter().getPowerTransformerEndId().equals(entity.getPowerTransformerEndId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPowerTransformerEnd
	 * 
	 * @param		entity	PowerTransformerEnd
	 */
	protected void emitFindAllPowerTransformerEnd( PowerTransformerEnd entity ) {
		LOGGER.info("handling emitFindAllPowerTransformerEnd" );
		
	    queryUpdateEmitter.emit(FindAllPowerTransformerEndQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PowerTransformerEndProjector.class.getName());

}
