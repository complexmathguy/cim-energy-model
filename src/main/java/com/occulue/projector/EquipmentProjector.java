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
 * Projector for Equipment as outlined for the CQRS pattern.  All event handling and query handling related to Equipment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquipmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equipment")
@Component("equipment-projector")
public class EquipmentProjector extends EquipmentEntityProjector {
		
	// core constructor
	public EquipmentProjector(EquipmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquipmentEvent
     */
    @EventHandler( payloadType=CreateEquipmentEvent.class )
    public void handle( CreateEquipmentEvent event) {
	    LOGGER.info("handling CreateEquipmentEvent - " + event );
	    Equipment entity = new Equipment();
        entity.setEquipmentId( event.getEquipmentId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipment( entity );
    }

    /*
     * @param	event UpdateEquipmentEvent
     */
    @EventHandler( payloadType=UpdateEquipmentEvent.class )
    public void handle( UpdateEquipmentEvent event) {
    	LOGGER.info("handling UpdateEquipmentEvent - " + event );
    	
	    Equipment entity = new Equipment();
        entity.setEquipmentId( event.getEquipmentId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquipment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipment( entity );        
    }
    
    /*
     * @param	event DeleteEquipmentEvent
     */
    @EventHandler( payloadType=DeleteEquipmentEvent.class )
    public void handle( DeleteEquipmentEvent event) {
    	LOGGER.info("handling DeleteEquipmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Equipment entity = delete( event.getEquipmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipment( entity );

    }    




    /**
     * Method to retrieve the Equipment via an EquipmentPrimaryKey.
     * @param 	id Long
     * @return 	Equipment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Equipment handle( FindEquipmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquipmentId() );
    }
    
    /**
     * Method to retrieve a collection of all Equipments
     *
     * @param	query	FindAllEquipmentQuery 
     * @return 	List<Equipment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Equipment> handle( FindAllEquipmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquipment, 
	 * but only if the id matches
	 * 
	 * @param		entity	Equipment
	 */
	protected void emitFindEquipment( Equipment entity ) {
		LOGGER.info("handling emitFindEquipment" );
		
	    queryUpdateEmitter.emit(FindEquipmentQuery.class,
	                            query -> query.getFilter().getEquipmentId().equals(entity.getEquipmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquipment
	 * 
	 * @param		entity	Equipment
	 */
	protected void emitFindAllEquipment( Equipment entity ) {
		LOGGER.info("handling emitFindAllEquipment" );
		
	    queryUpdateEmitter.emit(FindAllEquipmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquipmentProjector.class.getName());

}
