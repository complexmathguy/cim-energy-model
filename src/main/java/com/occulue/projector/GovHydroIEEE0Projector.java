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
 * Projector for GovHydroIEEE0 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroIEEE0 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroIEEE0Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroIEEE0")
@Component("govHydroIEEE0-projector")
public class GovHydroIEEE0Projector extends GovHydroIEEE0EntityProjector {
		
	// core constructor
	public GovHydroIEEE0Projector(GovHydroIEEE0Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroIEEE0Event
     */
    @EventHandler( payloadType=CreateGovHydroIEEE0Event.class )
    public void handle( CreateGovHydroIEEE0Event event) {
	    LOGGER.info("handling CreateGovHydroIEEE0Event - " + event );
	    GovHydroIEEE0 entity = new GovHydroIEEE0();
        entity.setGovHydroIEEE0Id( event.getGovHydroIEEE0Id() );
        entity.setK( event.getK() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE0( entity );
    }

    /*
     * @param	event UpdateGovHydroIEEE0Event
     */
    @EventHandler( payloadType=UpdateGovHydroIEEE0Event.class )
    public void handle( UpdateGovHydroIEEE0Event event) {
    	LOGGER.info("handling UpdateGovHydroIEEE0Event - " + event );
    	
	    GovHydroIEEE0 entity = new GovHydroIEEE0();
        entity.setGovHydroIEEE0Id( event.getGovHydroIEEE0Id() );
        entity.setK( event.getK() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroIEEE0( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE0( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroIEEE0Event
     */
    @EventHandler( payloadType=DeleteGovHydroIEEE0Event.class )
    public void handle( DeleteGovHydroIEEE0Event event) {
    	LOGGER.info("handling DeleteGovHydroIEEE0Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroIEEE0 entity = delete( event.getGovHydroIEEE0Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroIEEE0( entity );

    }    




    /**
     * Method to retrieve the GovHydroIEEE0 via an GovHydroIEEE0PrimaryKey.
     * @param 	id Long
     * @return 	GovHydroIEEE0
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroIEEE0 handle( FindGovHydroIEEE0Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroIEEE0Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroIEEE0s
     *
     * @param	query	FindAllGovHydroIEEE0Query 
     * @return 	List<GovHydroIEEE0> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroIEEE0> handle( FindAllGovHydroIEEE0Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroIEEE0, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroIEEE0
	 */
	protected void emitFindGovHydroIEEE0( GovHydroIEEE0 entity ) {
		LOGGER.info("handling emitFindGovHydroIEEE0" );
		
	    queryUpdateEmitter.emit(FindGovHydroIEEE0Query.class,
	                            query -> query.getFilter().getGovHydroIEEE0Id().equals(entity.getGovHydroIEEE0Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroIEEE0
	 * 
	 * @param		entity	GovHydroIEEE0
	 */
	protected void emitFindAllGovHydroIEEE0( GovHydroIEEE0 entity ) {
		LOGGER.info("handling emitFindAllGovHydroIEEE0" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroIEEE0Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroIEEE0Projector.class.getName());

}
