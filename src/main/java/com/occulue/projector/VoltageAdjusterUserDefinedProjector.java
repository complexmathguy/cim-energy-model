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
 * Projector for VoltageAdjusterUserDefined as outlined for the CQRS pattern.  All event handling and query handling related to VoltageAdjusterUserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VoltageAdjusterUserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("voltageAdjusterUserDefined")
@Component("voltageAdjusterUserDefined-projector")
public class VoltageAdjusterUserDefinedProjector extends VoltageAdjusterUserDefinedEntityProjector {
		
	// core constructor
	public VoltageAdjusterUserDefinedProjector(VoltageAdjusterUserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVoltageAdjusterUserDefinedEvent
     */
    @EventHandler( payloadType=CreateVoltageAdjusterUserDefinedEvent.class )
    public void handle( CreateVoltageAdjusterUserDefinedEvent event) {
	    LOGGER.info("handling CreateVoltageAdjusterUserDefinedEvent - " + event );
	    VoltageAdjusterUserDefined entity = new VoltageAdjusterUserDefined();
        entity.setVoltageAdjusterUserDefinedId( event.getVoltageAdjusterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterUserDefined( entity );
    }

    /*
     * @param	event UpdateVoltageAdjusterUserDefinedEvent
     */
    @EventHandler( payloadType=UpdateVoltageAdjusterUserDefinedEvent.class )
    public void handle( UpdateVoltageAdjusterUserDefinedEvent event) {
    	LOGGER.info("handling UpdateVoltageAdjusterUserDefinedEvent - " + event );
    	
	    VoltageAdjusterUserDefined entity = new VoltageAdjusterUserDefined();
        entity.setVoltageAdjusterUserDefinedId( event.getVoltageAdjusterUserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVoltageAdjusterUserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterUserDefined( entity );        
    }
    
    /*
     * @param	event DeleteVoltageAdjusterUserDefinedEvent
     */
    @EventHandler( payloadType=DeleteVoltageAdjusterUserDefinedEvent.class )
    public void handle( DeleteVoltageAdjusterUserDefinedEvent event) {
    	LOGGER.info("handling DeleteVoltageAdjusterUserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VoltageAdjusterUserDefined entity = delete( event.getVoltageAdjusterUserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVoltageAdjusterUserDefined( entity );

    }    




    /**
     * Method to retrieve the VoltageAdjusterUserDefined via an VoltageAdjusterUserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	VoltageAdjusterUserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VoltageAdjusterUserDefined handle( FindVoltageAdjusterUserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVoltageAdjusterUserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all VoltageAdjusterUserDefineds
     *
     * @param	query	FindAllVoltageAdjusterUserDefinedQuery 
     * @return 	List<VoltageAdjusterUserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VoltageAdjusterUserDefined> handle( FindAllVoltageAdjusterUserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVoltageAdjusterUserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	VoltageAdjusterUserDefined
	 */
	protected void emitFindVoltageAdjusterUserDefined( VoltageAdjusterUserDefined entity ) {
		LOGGER.info("handling emitFindVoltageAdjusterUserDefined" );
		
	    queryUpdateEmitter.emit(FindVoltageAdjusterUserDefinedQuery.class,
	                            query -> query.getFilter().getVoltageAdjusterUserDefinedId().equals(entity.getVoltageAdjusterUserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVoltageAdjusterUserDefined
	 * 
	 * @param		entity	VoltageAdjusterUserDefined
	 */
	protected void emitFindAllVoltageAdjusterUserDefined( VoltageAdjusterUserDefined entity ) {
		LOGGER.info("handling emitFindAllVoltageAdjusterUserDefined" );
		
	    queryUpdateEmitter.emit(FindAllVoltageAdjusterUserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VoltageAdjusterUserDefinedProjector.class.getName());

}
