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
 * Projector for FossilFuel as outlined for the CQRS pattern.  All event handling and query handling related to FossilFuel are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by FossilFuelAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("fossilFuel")
@Component("fossilFuel-projector")
public class FossilFuelProjector extends FossilFuelEntityProjector {
		
	// core constructor
	public FossilFuelProjector(FossilFuelRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateFossilFuelEvent
     */
    @EventHandler( payloadType=CreateFossilFuelEvent.class )
    public void handle( CreateFossilFuelEvent event) {
	    LOGGER.info("handling CreateFossilFuelEvent - " + event );
	    FossilFuel entity = new FossilFuel();
        entity.setFossilFuelId( event.getFossilFuelId() );
        entity.setFossilFuelType( event.getFossilFuelType() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFossilFuel( entity );
    }

    /*
     * @param	event UpdateFossilFuelEvent
     */
    @EventHandler( payloadType=UpdateFossilFuelEvent.class )
    public void handle( UpdateFossilFuelEvent event) {
    	LOGGER.info("handling UpdateFossilFuelEvent - " + event );
    	
	    FossilFuel entity = new FossilFuel();
        entity.setFossilFuelId( event.getFossilFuelId() );
        entity.setFossilFuelType( event.getFossilFuelType() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindFossilFuel( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFossilFuel( entity );        
    }
    
    /*
     * @param	event DeleteFossilFuelEvent
     */
    @EventHandler( payloadType=DeleteFossilFuelEvent.class )
    public void handle( DeleteFossilFuelEvent event) {
    	LOGGER.info("handling DeleteFossilFuelEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	FossilFuel entity = delete( event.getFossilFuelId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllFossilFuel( entity );

    }    




    /**
     * Method to retrieve the FossilFuel via an FossilFuelPrimaryKey.
     * @param 	id Long
     * @return 	FossilFuel
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public FossilFuel handle( FindFossilFuelQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getFossilFuelId() );
    }
    
    /**
     * Method to retrieve a collection of all FossilFuels
     *
     * @param	query	FindAllFossilFuelQuery 
     * @return 	List<FossilFuel> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<FossilFuel> handle( FindAllFossilFuelQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindFossilFuel, 
	 * but only if the id matches
	 * 
	 * @param		entity	FossilFuel
	 */
	protected void emitFindFossilFuel( FossilFuel entity ) {
		LOGGER.info("handling emitFindFossilFuel" );
		
	    queryUpdateEmitter.emit(FindFossilFuelQuery.class,
	                            query -> query.getFilter().getFossilFuelId().equals(entity.getFossilFuelId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllFossilFuel
	 * 
	 * @param		entity	FossilFuel
	 */
	protected void emitFindAllFossilFuel( FossilFuel entity ) {
		LOGGER.info("handling emitFindAllFossilFuel" );
		
	    queryUpdateEmitter.emit(FindAllFossilFuelQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(FossilFuelProjector.class.getName());

}
