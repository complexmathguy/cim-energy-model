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
 * Projector for GovSteam0 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteam0 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteam0Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteam0")
@Component("govSteam0-projector")
public class GovSteam0Projector extends GovSteam0EntityProjector {
		
	// core constructor
	public GovSteam0Projector(GovSteam0Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteam0Event
     */
    @EventHandler( payloadType=CreateGovSteam0Event.class )
    public void handle( CreateGovSteam0Event event) {
	    LOGGER.info("handling CreateGovSteam0Event - " + event );
	    GovSteam0 entity = new GovSteam0();
        entity.setGovSteam0Id( event.getGovSteam0Id() );
        entity.setDt( event.getDt() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam0( entity );
    }

    /*
     * @param	event UpdateGovSteam0Event
     */
    @EventHandler( payloadType=UpdateGovSteam0Event.class )
    public void handle( UpdateGovSteam0Event event) {
    	LOGGER.info("handling UpdateGovSteam0Event - " + event );
    	
	    GovSteam0 entity = new GovSteam0();
        entity.setGovSteam0Id( event.getGovSteam0Id() );
        entity.setDt( event.getDt() );
        entity.setMwbase( event.getMwbase() );
        entity.setR( event.getR() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteam0( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam0( entity );        
    }
    
    /*
     * @param	event DeleteGovSteam0Event
     */
    @EventHandler( payloadType=DeleteGovSteam0Event.class )
    public void handle( DeleteGovSteam0Event event) {
    	LOGGER.info("handling DeleteGovSteam0Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteam0 entity = delete( event.getGovSteam0Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam0( entity );

    }    




    /**
     * Method to retrieve the GovSteam0 via an GovSteam0PrimaryKey.
     * @param 	id Long
     * @return 	GovSteam0
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteam0 handle( FindGovSteam0Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteam0Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteam0s
     *
     * @param	query	FindAllGovSteam0Query 
     * @return 	List<GovSteam0> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteam0> handle( FindAllGovSteam0Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteam0, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteam0
	 */
	protected void emitFindGovSteam0( GovSteam0 entity ) {
		LOGGER.info("handling emitFindGovSteam0" );
		
	    queryUpdateEmitter.emit(FindGovSteam0Query.class,
	                            query -> query.getFilter().getGovSteam0Id().equals(entity.getGovSteam0Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteam0
	 * 
	 * @param		entity	GovSteam0
	 */
	protected void emitFindAllGovSteam0( GovSteam0 entity ) {
		LOGGER.info("handling emitFindAllGovSteam0" );
		
	    queryUpdateEmitter.emit(FindAllGovSteam0Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteam0Projector.class.getName());

}
