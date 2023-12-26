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
 * Projector for GovSteamFV2 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamFV2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamFV2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamFV2")
@Component("govSteamFV2-projector")
public class GovSteamFV2Projector extends GovSteamFV2EntityProjector {
		
	// core constructor
	public GovSteamFV2Projector(GovSteamFV2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamFV2Event
     */
    @EventHandler( payloadType=CreateGovSteamFV2Event.class )
    public void handle( CreateGovSteamFV2Event event) {
	    LOGGER.info("handling CreateGovSteamFV2Event - " + event );
	    GovSteamFV2 entity = new GovSteamFV2();
        entity.setGovSteamFV2Id( event.getGovSteamFV2Id() );
        entity.setDt( event.getDt() );
        entity.setK( event.getK() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT3( event.getT3() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTi( event.getTi() );
        entity.setTt( event.getTt() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV2( entity );
    }

    /*
     * @param	event UpdateGovSteamFV2Event
     */
    @EventHandler( payloadType=UpdateGovSteamFV2Event.class )
    public void handle( UpdateGovSteamFV2Event event) {
    	LOGGER.info("handling UpdateGovSteamFV2Event - " + event );
    	
	    GovSteamFV2 entity = new GovSteamFV2();
        entity.setGovSteamFV2Id( event.getGovSteamFV2Id() );
        entity.setDt( event.getDt() );
        entity.setK( event.getK() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT3( event.getT3() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTi( event.getTi() );
        entity.setTt( event.getTt() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamFV2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV2( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamFV2Event
     */
    @EventHandler( payloadType=DeleteGovSteamFV2Event.class )
    public void handle( DeleteGovSteamFV2Event event) {
    	LOGGER.info("handling DeleteGovSteamFV2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamFV2 entity = delete( event.getGovSteamFV2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV2( entity );

    }    




    /**
     * Method to retrieve the GovSteamFV2 via an GovSteamFV2PrimaryKey.
     * @param 	id Long
     * @return 	GovSteamFV2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamFV2 handle( FindGovSteamFV2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamFV2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV2s
     *
     * @param	query	FindAllGovSteamFV2Query 
     * @return 	List<GovSteamFV2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamFV2> handle( FindAllGovSteamFV2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamFV2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamFV2
	 */
	protected void emitFindGovSteamFV2( GovSteamFV2 entity ) {
		LOGGER.info("handling emitFindGovSteamFV2" );
		
	    queryUpdateEmitter.emit(FindGovSteamFV2Query.class,
	                            query -> query.getFilter().getGovSteamFV2Id().equals(entity.getGovSteamFV2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamFV2
	 * 
	 * @param		entity	GovSteamFV2
	 */
	protected void emitFindAllGovSteamFV2( GovSteamFV2 entity ) {
		LOGGER.info("handling emitFindAllGovSteamFV2" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamFV2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV2Projector.class.getName());

}
