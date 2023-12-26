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
 * Projector for RatioTapChanger as outlined for the CQRS pattern.  All event handling and query handling related to RatioTapChanger are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RatioTapChangerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("ratioTapChanger")
@Component("ratioTapChanger-projector")
public class RatioTapChangerProjector extends RatioTapChangerEntityProjector {
		
	// core constructor
	public RatioTapChangerProjector(RatioTapChangerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRatioTapChangerEvent
     */
    @EventHandler( payloadType=CreateRatioTapChangerEvent.class )
    public void handle( CreateRatioTapChangerEvent event) {
	    LOGGER.info("handling CreateRatioTapChangerEvent - " + event );
	    RatioTapChanger entity = new RatioTapChanger();
        entity.setRatioTapChangerId( event.getRatioTapChangerId() );
        entity.setStepVoltageIncrement( event.getStepVoltageIncrement() );
        entity.setTculControlMode( event.getTculControlMode() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChanger( entity );
    }

    /*
     * @param	event UpdateRatioTapChangerEvent
     */
    @EventHandler( payloadType=UpdateRatioTapChangerEvent.class )
    public void handle( UpdateRatioTapChangerEvent event) {
    	LOGGER.info("handling UpdateRatioTapChangerEvent - " + event );
    	
	    RatioTapChanger entity = new RatioTapChanger();
        entity.setRatioTapChangerId( event.getRatioTapChangerId() );
        entity.setStepVoltageIncrement( event.getStepVoltageIncrement() );
        entity.setTculControlMode( event.getTculControlMode() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRatioTapChanger( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChanger( entity );        
    }
    
    /*
     * @param	event DeleteRatioTapChangerEvent
     */
    @EventHandler( payloadType=DeleteRatioTapChangerEvent.class )
    public void handle( DeleteRatioTapChangerEvent event) {
    	LOGGER.info("handling DeleteRatioTapChangerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RatioTapChanger entity = delete( event.getRatioTapChangerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChanger( entity );

    }    




    /**
     * Method to retrieve the RatioTapChanger via an RatioTapChangerPrimaryKey.
     * @param 	id Long
     * @return 	RatioTapChanger
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RatioTapChanger handle( FindRatioTapChangerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRatioTapChangerId() );
    }
    
    /**
     * Method to retrieve a collection of all RatioTapChangers
     *
     * @param	query	FindAllRatioTapChangerQuery 
     * @return 	List<RatioTapChanger> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RatioTapChanger> handle( FindAllRatioTapChangerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRatioTapChanger, 
	 * but only if the id matches
	 * 
	 * @param		entity	RatioTapChanger
	 */
	protected void emitFindRatioTapChanger( RatioTapChanger entity ) {
		LOGGER.info("handling emitFindRatioTapChanger" );
		
	    queryUpdateEmitter.emit(FindRatioTapChangerQuery.class,
	                            query -> query.getFilter().getRatioTapChangerId().equals(entity.getRatioTapChangerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRatioTapChanger
	 * 
	 * @param		entity	RatioTapChanger
	 */
	protected void emitFindAllRatioTapChanger( RatioTapChanger entity ) {
		LOGGER.info("handling emitFindAllRatioTapChanger" );
		
	    queryUpdateEmitter.emit(FindAllRatioTapChangerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerProjector.class.getName());

}
