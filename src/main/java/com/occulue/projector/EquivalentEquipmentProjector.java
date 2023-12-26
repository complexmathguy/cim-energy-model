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
 * Projector for EquivalentEquipment as outlined for the CQRS pattern.  All event handling and query handling related to EquivalentEquipment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquivalentEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equivalentEquipment")
@Component("equivalentEquipment-projector")
public class EquivalentEquipmentProjector extends EquivalentEquipmentEntityProjector {
		
	// core constructor
	public EquivalentEquipmentProjector(EquivalentEquipmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquivalentEquipmentEvent
     */
    @EventHandler( payloadType=CreateEquivalentEquipmentEvent.class )
    public void handle( CreateEquivalentEquipmentEvent event) {
	    LOGGER.info("handling CreateEquivalentEquipmentEvent - " + event );
	    EquivalentEquipment entity = new EquivalentEquipment();
        entity.setEquivalentEquipmentId( event.getEquivalentEquipmentId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentEquipment( entity );
    }

    /*
     * @param	event UpdateEquivalentEquipmentEvent
     */
    @EventHandler( payloadType=UpdateEquivalentEquipmentEvent.class )
    public void handle( UpdateEquivalentEquipmentEvent event) {
    	LOGGER.info("handling UpdateEquivalentEquipmentEvent - " + event );
    	
	    EquivalentEquipment entity = new EquivalentEquipment();
        entity.setEquivalentEquipmentId( event.getEquivalentEquipmentId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquivalentEquipment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentEquipment( entity );        
    }
    
    /*
     * @param	event DeleteEquivalentEquipmentEvent
     */
    @EventHandler( payloadType=DeleteEquivalentEquipmentEvent.class )
    public void handle( DeleteEquivalentEquipmentEvent event) {
    	LOGGER.info("handling DeleteEquivalentEquipmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquivalentEquipment entity = delete( event.getEquivalentEquipmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentEquipment( entity );

    }    




    /**
     * Method to retrieve the EquivalentEquipment via an EquivalentEquipmentPrimaryKey.
     * @param 	id Long
     * @return 	EquivalentEquipment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquivalentEquipment handle( FindEquivalentEquipmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquivalentEquipmentId() );
    }
    
    /**
     * Method to retrieve a collection of all EquivalentEquipments
     *
     * @param	query	FindAllEquivalentEquipmentQuery 
     * @return 	List<EquivalentEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquivalentEquipment> handle( FindAllEquivalentEquipmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquivalentEquipment, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquivalentEquipment
	 */
	protected void emitFindEquivalentEquipment( EquivalentEquipment entity ) {
		LOGGER.info("handling emitFindEquivalentEquipment" );
		
	    queryUpdateEmitter.emit(FindEquivalentEquipmentQuery.class,
	                            query -> query.getFilter().getEquivalentEquipmentId().equals(entity.getEquivalentEquipmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquivalentEquipment
	 * 
	 * @param		entity	EquivalentEquipment
	 */
	protected void emitFindAllEquivalentEquipment( EquivalentEquipment entity ) {
		LOGGER.info("handling emitFindAllEquivalentEquipment" );
		
	    queryUpdateEmitter.emit(FindAllEquivalentEquipmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquivalentEquipmentProjector.class.getName());

}
