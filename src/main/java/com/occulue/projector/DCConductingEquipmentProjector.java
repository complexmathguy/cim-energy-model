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
 * Projector for DCConductingEquipment as outlined for the CQRS pattern.  All event handling and query handling related to DCConductingEquipment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCConductingEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCConductingEquipment")
@Component("dCConductingEquipment-projector")
public class DCConductingEquipmentProjector extends DCConductingEquipmentEntityProjector {
		
	// core constructor
	public DCConductingEquipmentProjector(DCConductingEquipmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCConductingEquipmentEvent
     */
    @EventHandler( payloadType=CreateDCConductingEquipmentEvent.class )
    public void handle( CreateDCConductingEquipmentEvent event) {
	    LOGGER.info("handling CreateDCConductingEquipmentEvent - " + event );
	    DCConductingEquipment entity = new DCConductingEquipment();
        entity.setDCConductingEquipmentId( event.getDCConductingEquipmentId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConductingEquipment( entity );
    }

    /*
     * @param	event UpdateDCConductingEquipmentEvent
     */
    @EventHandler( payloadType=UpdateDCConductingEquipmentEvent.class )
    public void handle( UpdateDCConductingEquipmentEvent event) {
    	LOGGER.info("handling UpdateDCConductingEquipmentEvent - " + event );
    	
	    DCConductingEquipment entity = new DCConductingEquipment();
        entity.setDCConductingEquipmentId( event.getDCConductingEquipmentId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCConductingEquipment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConductingEquipment( entity );        
    }
    
    /*
     * @param	event DeleteDCConductingEquipmentEvent
     */
    @EventHandler( payloadType=DeleteDCConductingEquipmentEvent.class )
    public void handle( DeleteDCConductingEquipmentEvent event) {
    	LOGGER.info("handling DeleteDCConductingEquipmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCConductingEquipment entity = delete( event.getDCConductingEquipmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCConductingEquipment( entity );

    }    




    /**
     * Method to retrieve the DCConductingEquipment via an DCConductingEquipmentPrimaryKey.
     * @param 	id Long
     * @return 	DCConductingEquipment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCConductingEquipment handle( FindDCConductingEquipmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCConductingEquipmentId() );
    }
    
    /**
     * Method to retrieve a collection of all DCConductingEquipments
     *
     * @param	query	FindAllDCConductingEquipmentQuery 
     * @return 	List<DCConductingEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCConductingEquipment> handle( FindAllDCConductingEquipmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCConductingEquipment, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCConductingEquipment
	 */
	protected void emitFindDCConductingEquipment( DCConductingEquipment entity ) {
		LOGGER.info("handling emitFindDCConductingEquipment" );
		
	    queryUpdateEmitter.emit(FindDCConductingEquipmentQuery.class,
	                            query -> query.getFilter().getDCConductingEquipmentId().equals(entity.getDCConductingEquipmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCConductingEquipment
	 * 
	 * @param		entity	DCConductingEquipment
	 */
	protected void emitFindAllDCConductingEquipment( DCConductingEquipment entity ) {
		LOGGER.info("handling emitFindAllDCConductingEquipment" );
		
	    queryUpdateEmitter.emit(FindAllDCConductingEquipmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCConductingEquipmentProjector.class.getName());

}
