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
 * Projector for GovSteamFV3 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamFV3 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamFV3Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamFV3")
@Component("govSteamFV3-projector")
public class GovSteamFV3Projector extends GovSteamFV3EntityProjector {
		
	// core constructor
	public GovSteamFV3Projector(GovSteamFV3Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamFV3Event
     */
    @EventHandler( payloadType=CreateGovSteamFV3Event.class )
    public void handle( CreateGovSteamFV3Event event) {
	    LOGGER.info("handling CreateGovSteamFV3Event - " + event );
	    GovSteamFV3 entity = new GovSteamFV3();
        entity.setGovSteamFV3Id( event.getGovSteamFV3Id() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setPrmax( event.getPrmax() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV3( entity );
    }

    /*
     * @param	event UpdateGovSteamFV3Event
     */
    @EventHandler( payloadType=UpdateGovSteamFV3Event.class )
    public void handle( UpdateGovSteamFV3Event event) {
    	LOGGER.info("handling UpdateGovSteamFV3Event - " + event );
    	
	    GovSteamFV3 entity = new GovSteamFV3();
        entity.setGovSteamFV3Id( event.getGovSteamFV3Id() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setPrmax( event.getPrmax() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamFV3( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV3( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamFV3Event
     */
    @EventHandler( payloadType=DeleteGovSteamFV3Event.class )
    public void handle( DeleteGovSteamFV3Event event) {
    	LOGGER.info("handling DeleteGovSteamFV3Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamFV3 entity = delete( event.getGovSteamFV3Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamFV3( entity );

    }    




    /**
     * Method to retrieve the GovSteamFV3 via an GovSteamFV3PrimaryKey.
     * @param 	id Long
     * @return 	GovSteamFV3
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamFV3 handle( FindGovSteamFV3Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamFV3Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamFV3s
     *
     * @param	query	FindAllGovSteamFV3Query 
     * @return 	List<GovSteamFV3> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamFV3> handle( FindAllGovSteamFV3Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamFV3, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamFV3
	 */
	protected void emitFindGovSteamFV3( GovSteamFV3 entity ) {
		LOGGER.info("handling emitFindGovSteamFV3" );
		
	    queryUpdateEmitter.emit(FindGovSteamFV3Query.class,
	                            query -> query.getFilter().getGovSteamFV3Id().equals(entity.getGovSteamFV3Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamFV3
	 * 
	 * @param		entity	GovSteamFV3
	 */
	protected void emitFindAllGovSteamFV3( GovSteamFV3 entity ) {
		LOGGER.info("handling emitFindAllGovSteamFV3" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamFV3Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamFV3Projector.class.getName());

}
