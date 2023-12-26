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
 * Projector for DCSeriesDevice as outlined for the CQRS pattern.  All event handling and query handling related to DCSeriesDevice are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DCSeriesDeviceAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dCSeriesDevice")
@Component("dCSeriesDevice-projector")
public class DCSeriesDeviceProjector extends DCSeriesDeviceEntityProjector {
		
	// core constructor
	public DCSeriesDeviceProjector(DCSeriesDeviceRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDCSeriesDeviceEvent
     */
    @EventHandler( payloadType=CreateDCSeriesDeviceEvent.class )
    public void handle( CreateDCSeriesDeviceEvent event) {
	    LOGGER.info("handling CreateDCSeriesDeviceEvent - " + event );
	    DCSeriesDevice entity = new DCSeriesDevice();
        entity.setDCSeriesDeviceId( event.getDCSeriesDeviceId() );
        entity.setInductance( event.getInductance() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistance( event.getResistance() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSeriesDevice( entity );
    }

    /*
     * @param	event UpdateDCSeriesDeviceEvent
     */
    @EventHandler( payloadType=UpdateDCSeriesDeviceEvent.class )
    public void handle( UpdateDCSeriesDeviceEvent event) {
    	LOGGER.info("handling UpdateDCSeriesDeviceEvent - " + event );
    	
	    DCSeriesDevice entity = new DCSeriesDevice();
        entity.setDCSeriesDeviceId( event.getDCSeriesDeviceId() );
        entity.setInductance( event.getInductance() );
        entity.setRatedUdc( event.getRatedUdc() );
        entity.setResistance( event.getResistance() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDCSeriesDevice( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSeriesDevice( entity );        
    }
    
    /*
     * @param	event DeleteDCSeriesDeviceEvent
     */
    @EventHandler( payloadType=DeleteDCSeriesDeviceEvent.class )
    public void handle( DeleteDCSeriesDeviceEvent event) {
    	LOGGER.info("handling DeleteDCSeriesDeviceEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DCSeriesDevice entity = delete( event.getDCSeriesDeviceId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDCSeriesDevice( entity );

    }    




    /**
     * Method to retrieve the DCSeriesDevice via an DCSeriesDevicePrimaryKey.
     * @param 	id Long
     * @return 	DCSeriesDevice
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DCSeriesDevice handle( FindDCSeriesDeviceQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDCSeriesDeviceId() );
    }
    
    /**
     * Method to retrieve a collection of all DCSeriesDevices
     *
     * @param	query	FindAllDCSeriesDeviceQuery 
     * @return 	List<DCSeriesDevice> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DCSeriesDevice> handle( FindAllDCSeriesDeviceQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDCSeriesDevice, 
	 * but only if the id matches
	 * 
	 * @param		entity	DCSeriesDevice
	 */
	protected void emitFindDCSeriesDevice( DCSeriesDevice entity ) {
		LOGGER.info("handling emitFindDCSeriesDevice" );
		
	    queryUpdateEmitter.emit(FindDCSeriesDeviceQuery.class,
	                            query -> query.getFilter().getDCSeriesDeviceId().equals(entity.getDCSeriesDeviceId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDCSeriesDevice
	 * 
	 * @param		entity	DCSeriesDevice
	 */
	protected void emitFindAllDCSeriesDevice( DCSeriesDevice entity ) {
		LOGGER.info("handling emitFindAllDCSeriesDevice" );
		
	    queryUpdateEmitter.emit(FindAllDCSeriesDeviceQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DCSeriesDeviceProjector.class.getName());

}
