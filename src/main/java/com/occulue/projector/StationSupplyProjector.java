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
 * Projector for StationSupply as outlined for the CQRS pattern.  All event handling and query handling related to StationSupply are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StationSupplyAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("stationSupply")
@Component("stationSupply-projector")
public class StationSupplyProjector extends StationSupplyEntityProjector {
		
	// core constructor
	public StationSupplyProjector(StationSupplyRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStationSupplyEvent
     */
    @EventHandler( payloadType=CreateStationSupplyEvent.class )
    public void handle( CreateStationSupplyEvent event) {
	    LOGGER.info("handling CreateStationSupplyEvent - " + event );
	    StationSupply entity = new StationSupply();
        entity.setStationSupplyId( event.getStationSupplyId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStationSupply( entity );
    }

    /*
     * @param	event UpdateStationSupplyEvent
     */
    @EventHandler( payloadType=UpdateStationSupplyEvent.class )
    public void handle( UpdateStationSupplyEvent event) {
    	LOGGER.info("handling UpdateStationSupplyEvent - " + event );
    	
	    StationSupply entity = new StationSupply();
        entity.setStationSupplyId( event.getStationSupplyId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStationSupply( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStationSupply( entity );        
    }
    
    /*
     * @param	event DeleteStationSupplyEvent
     */
    @EventHandler( payloadType=DeleteStationSupplyEvent.class )
    public void handle( DeleteStationSupplyEvent event) {
    	LOGGER.info("handling DeleteStationSupplyEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StationSupply entity = delete( event.getStationSupplyId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStationSupply( entity );

    }    




    /**
     * Method to retrieve the StationSupply via an StationSupplyPrimaryKey.
     * @param 	id Long
     * @return 	StationSupply
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StationSupply handle( FindStationSupplyQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStationSupplyId() );
    }
    
    /**
     * Method to retrieve a collection of all StationSupplys
     *
     * @param	query	FindAllStationSupplyQuery 
     * @return 	List<StationSupply> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StationSupply> handle( FindAllStationSupplyQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStationSupply, 
	 * but only if the id matches
	 * 
	 * @param		entity	StationSupply
	 */
	protected void emitFindStationSupply( StationSupply entity ) {
		LOGGER.info("handling emitFindStationSupply" );
		
	    queryUpdateEmitter.emit(FindStationSupplyQuery.class,
	                            query -> query.getFilter().getStationSupplyId().equals(entity.getStationSupplyId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStationSupply
	 * 
	 * @param		entity	StationSupply
	 */
	protected void emitFindAllStationSupply( StationSupply entity ) {
		LOGGER.info("handling emitFindAllStationSupply" );
		
	    queryUpdateEmitter.emit(FindAllStationSupplyQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StationSupplyProjector.class.getName());

}
