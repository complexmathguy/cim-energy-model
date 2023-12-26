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
 * Projector for VoltageLimit as outlined for the CQRS pattern.  All event handling and query handling related to VoltageLimit are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VoltageLimitAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("voltageLimit")
@Component("voltageLimit-projector")
public class VoltageLimitProjector extends VoltageLimitEntityProjector {
		
	// core constructor
	public VoltageLimitProjector(VoltageLimitRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVoltageLimitEvent
     */
    @EventHandler( payloadType=CreateVoltageLimitEvent.class )
    public void handle( CreateVoltageLimitEvent event) {
	    LOGGER.info("handling CreateVoltageLimitEvent - " + event );
	    VoltageLimit entity = new VoltageLimit();
        entity.setVoltageLimitId( event.getVoltageLimitId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageLimit( entity );
    }

    /*
     * @param	event UpdateVoltageLimitEvent
     */
    @EventHandler( payloadType=UpdateVoltageLimitEvent.class )
    public void handle( UpdateVoltageLimitEvent event) {
    	LOGGER.info("handling UpdateVoltageLimitEvent - " + event );
    	
	    VoltageLimit entity = new VoltageLimit();
        entity.setVoltageLimitId( event.getVoltageLimitId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVoltageLimit( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageLimit( entity );        
    }
    
    /*
     * @param	event DeleteVoltageLimitEvent
     */
    @EventHandler( payloadType=DeleteVoltageLimitEvent.class )
    public void handle( DeleteVoltageLimitEvent event) {
    	LOGGER.info("handling DeleteVoltageLimitEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VoltageLimit entity = delete( event.getVoltageLimitId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageLimit( entity );

    }    




    /**
     * Method to retrieve the VoltageLimit via an VoltageLimitPrimaryKey.
     * @param 	id Long
     * @return 	VoltageLimit
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VoltageLimit handle( FindVoltageLimitQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVoltageLimitId() );
    }
    
    /**
     * Method to retrieve a collection of all VoltageLimits
     *
     * @param	query	FindAllVoltageLimitQuery 
     * @return 	List<VoltageLimit> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VoltageLimit> handle( FindAllVoltageLimitQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVoltageLimit, 
	 * but only if the id matches
	 * 
	 * @param		entity	VoltageLimit
	 */
	protected void emitFindVoltageLimit( VoltageLimit entity ) {
		LOGGER.info("handling emitFindVoltageLimit" );
		
	    queryUpdateEmitter.emit(FindVoltageLimitQuery.class,
	                            query -> query.getFilter().getVoltageLimitId().equals(entity.getVoltageLimitId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVoltageLimit
	 * 
	 * @param		entity	VoltageLimit
	 */
	protected void emitFindAllVoltageLimit( VoltageLimit entity ) {
		LOGGER.info("handling emitFindAllVoltageLimit" );
		
	    queryUpdateEmitter.emit(FindAllVoltageLimitQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VoltageLimitProjector.class.getName());

}
