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
 * Projector for EquipmentContainer as outlined for the CQRS pattern.  All event handling and query handling related to EquipmentContainer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquipmentContainerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equipmentContainer")
@Component("equipmentContainer-projector")
public class EquipmentContainerProjector extends EquipmentContainerEntityProjector {
		
	// core constructor
	public EquipmentContainerProjector(EquipmentContainerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquipmentContainerEvent
     */
    @EventHandler( payloadType=CreateEquipmentContainerEvent.class )
    public void handle( CreateEquipmentContainerEvent event) {
	    LOGGER.info("handling CreateEquipmentContainerEvent - " + event );
	    EquipmentContainer entity = new EquipmentContainer();
        entity.setEquipmentContainerId( event.getEquipmentContainerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentContainer( entity );
    }

    /*
     * @param	event UpdateEquipmentContainerEvent
     */
    @EventHandler( payloadType=UpdateEquipmentContainerEvent.class )
    public void handle( UpdateEquipmentContainerEvent event) {
    	LOGGER.info("handling UpdateEquipmentContainerEvent - " + event );
    	
	    EquipmentContainer entity = new EquipmentContainer();
        entity.setEquipmentContainerId( event.getEquipmentContainerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquipmentContainer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentContainer( entity );        
    }
    
    /*
     * @param	event DeleteEquipmentContainerEvent
     */
    @EventHandler( payloadType=DeleteEquipmentContainerEvent.class )
    public void handle( DeleteEquipmentContainerEvent event) {
    	LOGGER.info("handling DeleteEquipmentContainerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquipmentContainer entity = delete( event.getEquipmentContainerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquipmentContainer( entity );

    }    




    /**
     * Method to retrieve the EquipmentContainer via an EquipmentContainerPrimaryKey.
     * @param 	id Long
     * @return 	EquipmentContainer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquipmentContainer handle( FindEquipmentContainerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquipmentContainerId() );
    }
    
    /**
     * Method to retrieve a collection of all EquipmentContainers
     *
     * @param	query	FindAllEquipmentContainerQuery 
     * @return 	List<EquipmentContainer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquipmentContainer> handle( FindAllEquipmentContainerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquipmentContainer, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquipmentContainer
	 */
	protected void emitFindEquipmentContainer( EquipmentContainer entity ) {
		LOGGER.info("handling emitFindEquipmentContainer" );
		
	    queryUpdateEmitter.emit(FindEquipmentContainerQuery.class,
	                            query -> query.getFilter().getEquipmentContainerId().equals(entity.getEquipmentContainerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquipmentContainer
	 * 
	 * @param		entity	EquipmentContainer
	 */
	protected void emitFindAllEquipmentContainer( EquipmentContainer entity ) {
		LOGGER.info("handling emitFindAllEquipmentContainer" );
		
	    queryUpdateEmitter.emit(FindAllEquipmentContainerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquipmentContainerProjector.class.getName());

}
