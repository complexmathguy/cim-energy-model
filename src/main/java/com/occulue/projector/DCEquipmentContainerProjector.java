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
 * Projector for DCEquipmentContainer as outlined for the CQRS pattern.  All event handling and query handling related to DCEquipmentContainer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCEquipmentContainerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCEquipmentContainer")
@Component("dCEquipmentContainer-projector")
public class DCEquipmentContainerProjector extends DCEquipmentContainerEntityProjector {
		
	// core constructor
	public DCEquipmentContainerProjector(DCEquipmentContainerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCEquipmentContainerEvent
     */
    @EventHandler( payloadType=CreateDCEquipmentContainerEvent.class )
    public void handle( CreateDCEquipmentContainerEvent event) {
	    LOGGER.info("handling CreateDCEquipmentContainerEvent - " + event );
	    DCEquipmentContainer entity = new DCEquipmentContainer();
        entity.setDCEquipmentContainerId( event.getDCEquipmentContainerId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCEquipmentContainer( entity );
    }

    /*
     * @param	event UpdateDCEquipmentContainerEvent
     */
    @EventHandler( payloadType=UpdateDCEquipmentContainerEvent.class )
    public void handle( UpdateDCEquipmentContainerEvent event) {
    	LOGGER.info("handling UpdateDCEquipmentContainerEvent - " + event );
    	
	    DCEquipmentContainer entity = new DCEquipmentContainer();
        entity.setDCEquipmentContainerId( event.getDCEquipmentContainerId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCEquipmentContainer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCEquipmentContainer( entity );        
    }
    
    /*
     * @param	event DeleteDCEquipmentContainerEvent
     */
    @EventHandler( payloadType=DeleteDCEquipmentContainerEvent.class )
    public void handle( DeleteDCEquipmentContainerEvent event) {
    	LOGGER.info("handling DeleteDCEquipmentContainerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCEquipmentContainer entity = delete( event.getDCEquipmentContainerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCEquipmentContainer( entity );

    }    




    /**
     * Method to retrieve the DCEquipmentContainer via an DCEquipmentContainerPrimaryKey.
     * @param 	id Long
     * @return 	DCEquipmentContainer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCEquipmentContainer handle( FindDCEquipmentContainerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCEquipmentContainerId() );
    }
    
    /**
     * Method to retrieve a collection of all DCEquipmentContainers
     *
     * @param	query	FindAllDCEquipmentContainerQuery 
     * @return 	List<DCEquipmentContainer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCEquipmentContainer> handle( FindAllDCEquipmentContainerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCEquipmentContainer, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCEquipmentContainer
	 */
	protected void emitFindDCEquipmentContainer( DCEquipmentContainer entity ) {
		LOGGER.info("handling emitFindDCEquipmentContainer" );
		
	    queryUpdateEmitter.emit(FindDCEquipmentContainerQuery.class,
	                            query -> query.getFilter().getDCEquipmentContainerId().equals(entity.getDCEquipmentContainerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCEquipmentContainer
	 * 
	 * @param		entity	DCEquipmentContainer
	 */
	protected void emitFindAllDCEquipmentContainer( DCEquipmentContainer entity ) {
		LOGGER.info("handling emitFindAllDCEquipmentContainer" );
		
	    queryUpdateEmitter.emit(FindAllDCEquipmentContainerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCEquipmentContainerProjector.class.getName());

}
