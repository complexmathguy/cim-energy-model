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
 * Projector for GovSteamSGO as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamSGO are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamSGOAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamSGO")
@Component("govSteamSGO-projector")
public class GovSteamSGOProjector extends GovSteamSGOEntityProjector {
		
	// core constructor
	public GovSteamSGOProjector(GovSteamSGORepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamSGOEvent
     */
    @EventHandler( payloadType=CreateGovSteamSGOEvent.class )
    public void handle( CreateGovSteamSGOEvent event) {
	    LOGGER.info("handling CreateGovSteamSGOEvent - " + event );
	    GovSteamSGO entity = new GovSteamSGO();
        entity.setGovSteamSGOId( event.getGovSteamSGOId() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamSGO( entity );
    }

    /*
     * @param	event UpdateGovSteamSGOEvent
     */
    @EventHandler( payloadType=UpdateGovSteamSGOEvent.class )
    public void handle( UpdateGovSteamSGOEvent event) {
    	LOGGER.info("handling UpdateGovSteamSGOEvent - " + event );
    	
	    GovSteamSGO entity = new GovSteamSGO();
        entity.setGovSteamSGOId( event.getGovSteamSGOId() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamSGO( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamSGO( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamSGOEvent
     */
    @EventHandler( payloadType=DeleteGovSteamSGOEvent.class )
    public void handle( DeleteGovSteamSGOEvent event) {
    	LOGGER.info("handling DeleteGovSteamSGOEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamSGO entity = delete( event.getGovSteamSGOId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamSGO( entity );

    }    




    /**
     * Method to retrieve the GovSteamSGO via an GovSteamSGOPrimaryKey.
     * @param 	id Long
     * @return 	GovSteamSGO
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamSGO handle( FindGovSteamSGOQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamSGOId() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamSGOs
     *
     * @param	query	FindAllGovSteamSGOQuery 
     * @return 	List<GovSteamSGO> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamSGO> handle( FindAllGovSteamSGOQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamSGO, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamSGO
	 */
	protected void emitFindGovSteamSGO( GovSteamSGO entity ) {
		LOGGER.info("handling emitFindGovSteamSGO" );
		
	    queryUpdateEmitter.emit(FindGovSteamSGOQuery.class,
	                            query -> query.getFilter().getGovSteamSGOId().equals(entity.getGovSteamSGOId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamSGO
	 * 
	 * @param		entity	GovSteamSGO
	 */
	protected void emitFindAllGovSteamSGO( GovSteamSGO entity ) {
		LOGGER.info("handling emitFindAllGovSteamSGO" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamSGOQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamSGOProjector.class.getName());

}
