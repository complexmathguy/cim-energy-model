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
 * Projector for ConductingEquipment as outlined for the CQRS pattern.  All event handling and query handling related to ConductingEquipment are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ConductingEquipmentAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("conductingEquipment")
@Component("conductingEquipment-projector")
public class ConductingEquipmentProjector extends ConductingEquipmentEntityProjector {
		
	// core constructor
	public ConductingEquipmentProjector(ConductingEquipmentRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateConductingEquipmentEvent
     */
    @EventHandler( payloadType=CreateConductingEquipmentEvent.class )
    public void handle( CreateConductingEquipmentEvent event) {
	    LOGGER.info("handling CreateConductingEquipmentEvent - " + event );
	    ConductingEquipment entity = new ConductingEquipment();
        entity.setConductingEquipmentId( event.getConductingEquipmentId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConductingEquipment( entity );
    }

    /*
     * @param	event UpdateConductingEquipmentEvent
     */
    @EventHandler( payloadType=UpdateConductingEquipmentEvent.class )
    public void handle( UpdateConductingEquipmentEvent event) {
    	LOGGER.info("handling UpdateConductingEquipmentEvent - " + event );
    	
	    ConductingEquipment entity = new ConductingEquipment();
        entity.setConductingEquipmentId( event.getConductingEquipmentId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindConductingEquipment( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConductingEquipment( entity );        
    }
    
    /*
     * @param	event DeleteConductingEquipmentEvent
     */
    @EventHandler( payloadType=DeleteConductingEquipmentEvent.class )
    public void handle( DeleteConductingEquipmentEvent event) {
    	LOGGER.info("handling DeleteConductingEquipmentEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ConductingEquipment entity = delete( event.getConductingEquipmentId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllConductingEquipment( entity );

    }    




    /**
     * Method to retrieve the ConductingEquipment via an ConductingEquipmentPrimaryKey.
     * @param 	id Long
     * @return 	ConductingEquipment
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ConductingEquipment handle( FindConductingEquipmentQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getConductingEquipmentId() );
    }
    
    /**
     * Method to retrieve a collection of all ConductingEquipments
     *
     * @param	query	FindAllConductingEquipmentQuery 
     * @return 	List<ConductingEquipment> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ConductingEquipment> handle( FindAllConductingEquipmentQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindConductingEquipment, 
	 * but only if the id matches
	 * 
	 * @param		entity	ConductingEquipment
	 */
	protected void emitFindConductingEquipment( ConductingEquipment entity ) {
		LOGGER.info("handling emitFindConductingEquipment" );
		
	    queryUpdateEmitter.emit(FindConductingEquipmentQuery.class,
	                            query -> query.getFilter().getConductingEquipmentId().equals(entity.getConductingEquipmentId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllConductingEquipment
	 * 
	 * @param		entity	ConductingEquipment
	 */
	protected void emitFindAllConductingEquipment( ConductingEquipment entity ) {
		LOGGER.info("handling emitFindAllConductingEquipment" );
		
	    queryUpdateEmitter.emit(FindAllConductingEquipmentQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ConductingEquipmentProjector.class.getName());

}
