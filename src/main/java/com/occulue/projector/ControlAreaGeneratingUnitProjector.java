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
 * Projector for ControlAreaGeneratingUnit as outlined for the CQRS pattern.  All event handling and query handling related to ControlAreaGeneratingUnit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ControlAreaGeneratingUnitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("controlAreaGeneratingUnit")
@Component("controlAreaGeneratingUnit-projector")
public class ControlAreaGeneratingUnitProjector extends ControlAreaGeneratingUnitEntityProjector {
		
	// core constructor
	public ControlAreaGeneratingUnitProjector(ControlAreaGeneratingUnitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateControlAreaGeneratingUnitEvent
     */
    @EventHandler( payloadType=CreateControlAreaGeneratingUnitEvent.class )
    public void handle( CreateControlAreaGeneratingUnitEvent event) {
	    LOGGER.info("handling CreateControlAreaGeneratingUnitEvent - " + event );
	    ControlAreaGeneratingUnit entity = new ControlAreaGeneratingUnit();
        entity.setControlAreaGeneratingUnitId( event.getControlAreaGeneratingUnitId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlAreaGeneratingUnit( entity );
    }

    /*
     * @param	event UpdateControlAreaGeneratingUnitEvent
     */
    @EventHandler( payloadType=UpdateControlAreaGeneratingUnitEvent.class )
    public void handle( UpdateControlAreaGeneratingUnitEvent event) {
    	LOGGER.info("handling UpdateControlAreaGeneratingUnitEvent - " + event );
    	
	    ControlAreaGeneratingUnit entity = new ControlAreaGeneratingUnit();
        entity.setControlAreaGeneratingUnitId( event.getControlAreaGeneratingUnitId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindControlAreaGeneratingUnit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlAreaGeneratingUnit( entity );        
    }
    
    /*
     * @param	event DeleteControlAreaGeneratingUnitEvent
     */
    @EventHandler( payloadType=DeleteControlAreaGeneratingUnitEvent.class )
    public void handle( DeleteControlAreaGeneratingUnitEvent event) {
    	LOGGER.info("handling DeleteControlAreaGeneratingUnitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ControlAreaGeneratingUnit entity = delete( event.getControlAreaGeneratingUnitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllControlAreaGeneratingUnit( entity );

    }    




    /**
     * Method to retrieve the ControlAreaGeneratingUnit via an ControlAreaGeneratingUnitPrimaryKey.
     * @param 	id Long
     * @return 	ControlAreaGeneratingUnit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ControlAreaGeneratingUnit handle( FindControlAreaGeneratingUnitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getControlAreaGeneratingUnitId() );
    }
    
    /**
     * Method to retrieve a collection of all ControlAreaGeneratingUnits
     *
     * @param	query	FindAllControlAreaGeneratingUnitQuery 
     * @return 	List<ControlAreaGeneratingUnit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ControlAreaGeneratingUnit> handle( FindAllControlAreaGeneratingUnitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindControlAreaGeneratingUnit, 
	 * but only if the id matches
	 * 
	 * @param		entity	ControlAreaGeneratingUnit
	 */
	protected void emitFindControlAreaGeneratingUnit( ControlAreaGeneratingUnit entity ) {
		LOGGER.info("handling emitFindControlAreaGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindControlAreaGeneratingUnitQuery.class,
	                            query -> query.getFilter().getControlAreaGeneratingUnitId().equals(entity.getControlAreaGeneratingUnitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllControlAreaGeneratingUnit
	 * 
	 * @param		entity	ControlAreaGeneratingUnit
	 */
	protected void emitFindAllControlAreaGeneratingUnit( ControlAreaGeneratingUnit entity ) {
		LOGGER.info("handling emitFindAllControlAreaGeneratingUnit" );
		
	    queryUpdateEmitter.emit(FindAllControlAreaGeneratingUnitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ControlAreaGeneratingUnitProjector.class.getName());

}
