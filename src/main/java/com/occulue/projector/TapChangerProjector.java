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
 * Projector for TapChanger as outlined for the CQRS pattern.  All event handling and query handling related to TapChanger are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TapChangerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("tapChanger")
@Component("tapChanger-projector")
public class TapChangerProjector extends TapChangerEntityProjector {
		
	// core constructor
	public TapChangerProjector(TapChangerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTapChangerEvent
     */
    @EventHandler( payloadType=CreateTapChangerEvent.class )
    public void handle( CreateTapChangerEvent event) {
	    LOGGER.info("handling CreateTapChangerEvent - " + event );
	    TapChanger entity = new TapChanger();
        entity.setTapChangerId( event.getTapChangerId() );
        entity.setHighStep( event.getHighStep() );
        entity.setLowStep( event.getLowStep() );
        entity.setLtcFlag( event.getLtcFlag() );
        entity.setNeutralStep( event.getNeutralStep() );
        entity.setNeutralU( event.getNeutralU() );
        entity.setNormalStep( event.getNormalStep() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChanger( entity );
    }

    /*
     * @param	event UpdateTapChangerEvent
     */
    @EventHandler( payloadType=UpdateTapChangerEvent.class )
    public void handle( UpdateTapChangerEvent event) {
    	LOGGER.info("handling UpdateTapChangerEvent - " + event );
    	
	    TapChanger entity = new TapChanger();
        entity.setTapChangerId( event.getTapChangerId() );
        entity.setHighStep( event.getHighStep() );
        entity.setLowStep( event.getLowStep() );
        entity.setLtcFlag( event.getLtcFlag() );
        entity.setNeutralStep( event.getNeutralStep() );
        entity.setNeutralU( event.getNeutralU() );
        entity.setNormalStep( event.getNormalStep() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTapChanger( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChanger( entity );        
    }
    
    /*
     * @param	event DeleteTapChangerEvent
     */
    @EventHandler( payloadType=DeleteTapChangerEvent.class )
    public void handle( DeleteTapChangerEvent event) {
    	LOGGER.info("handling DeleteTapChangerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TapChanger entity = delete( event.getTapChangerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTapChanger( entity );

    }    




    /**
     * Method to retrieve the TapChanger via an TapChangerPrimaryKey.
     * @param 	id Long
     * @return 	TapChanger
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TapChanger handle( FindTapChangerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTapChangerId() );
    }
    
    /**
     * Method to retrieve a collection of all TapChangers
     *
     * @param	query	FindAllTapChangerQuery 
     * @return 	List<TapChanger> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TapChanger> handle( FindAllTapChangerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTapChanger, 
	 * but only if the id matches
	 * 
	 * @param		entity	TapChanger
	 */
	protected void emitFindTapChanger( TapChanger entity ) {
		LOGGER.info("handling emitFindTapChanger" );
		
	    queryUpdateEmitter.emit(FindTapChangerQuery.class,
	                            query -> query.getFilter().getTapChangerId().equals(entity.getTapChangerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTapChanger
	 * 
	 * @param		entity	TapChanger
	 */
	protected void emitFindAllTapChanger( TapChanger entity ) {
		LOGGER.info("handling emitFindAllTapChanger" );
		
	    queryUpdateEmitter.emit(FindAllTapChangerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TapChangerProjector.class.getName());

}
