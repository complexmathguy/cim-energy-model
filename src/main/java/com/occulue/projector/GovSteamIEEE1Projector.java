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
 * Projector for GovSteamIEEE1 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamIEEE1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamIEEE1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamIEEE1")
@Component("govSteamIEEE1-projector")
public class GovSteamIEEE1Projector extends GovSteamIEEE1EntityProjector {
		
	// core constructor
	public GovSteamIEEE1Projector(GovSteamIEEE1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamIEEE1Event
     */
    @EventHandler( payloadType=CreateGovSteamIEEE1Event.class )
    public void handle( CreateGovSteamIEEE1Event event) {
	    LOGGER.info("handling CreateGovSteamIEEE1Event - " + event );
	    GovSteamIEEE1 entity = new GovSteamIEEE1();
        entity.setGovSteamIEEE1Id( event.getGovSteamIEEE1Id() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setK7( event.getK7() );
        entity.setK8( event.getK8() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamIEEE1( entity );
    }

    /*
     * @param	event UpdateGovSteamIEEE1Event
     */
    @EventHandler( payloadType=UpdateGovSteamIEEE1Event.class )
    public void handle( UpdateGovSteamIEEE1Event event) {
    	LOGGER.info("handling UpdateGovSteamIEEE1Event - " + event );
    	
	    GovSteamIEEE1 entity = new GovSteamIEEE1();
        entity.setGovSteamIEEE1Id( event.getGovSteamIEEE1Id() );
        entity.setK( event.getK() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setK5( event.getK5() );
        entity.setK6( event.getK6() );
        entity.setK7( event.getK7() );
        entity.setK8( event.getK8() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setUc( event.getUc() );
        entity.setUo( event.getUo() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamIEEE1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamIEEE1( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamIEEE1Event
     */
    @EventHandler( payloadType=DeleteGovSteamIEEE1Event.class )
    public void handle( DeleteGovSteamIEEE1Event event) {
    	LOGGER.info("handling DeleteGovSteamIEEE1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamIEEE1 entity = delete( event.getGovSteamIEEE1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamIEEE1( entity );

    }    




    /**
     * Method to retrieve the GovSteamIEEE1 via an GovSteamIEEE1PrimaryKey.
     * @param 	id Long
     * @return 	GovSteamIEEE1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamIEEE1 handle( FindGovSteamIEEE1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamIEEE1Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamIEEE1s
     *
     * @param	query	FindAllGovSteamIEEE1Query 
     * @return 	List<GovSteamIEEE1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamIEEE1> handle( FindAllGovSteamIEEE1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamIEEE1, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamIEEE1
	 */
	protected void emitFindGovSteamIEEE1( GovSteamIEEE1 entity ) {
		LOGGER.info("handling emitFindGovSteamIEEE1" );
		
	    queryUpdateEmitter.emit(FindGovSteamIEEE1Query.class,
	                            query -> query.getFilter().getGovSteamIEEE1Id().equals(entity.getGovSteamIEEE1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamIEEE1
	 * 
	 * @param		entity	GovSteamIEEE1
	 */
	protected void emitFindAllGovSteamIEEE1( GovSteamIEEE1 entity ) {
		LOGGER.info("handling emitFindAllGovSteamIEEE1" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamIEEE1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamIEEE1Projector.class.getName());

}
