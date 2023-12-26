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
 * Projector for GovSteam2 as outlined for the CQRS pattern.  All event handling and query handling related to GovSteam2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteam2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteam2")
@Component("govSteam2-projector")
public class GovSteam2Projector extends GovSteam2EntityProjector {
		
	// core constructor
	public GovSteam2Projector(GovSteam2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteam2Event
     */
    @EventHandler( payloadType=CreateGovSteam2Event.class )
    public void handle( CreateGovSteam2Event event) {
	    LOGGER.info("handling CreateGovSteam2Event - " + event );
	    GovSteam2 entity = new GovSteam2();
        entity.setGovSteam2Id( event.getGovSteam2Id() );
        entity.setDbf( event.getDbf() );
        entity.setK( event.getK() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam2( entity );
    }

    /*
     * @param	event UpdateGovSteam2Event
     */
    @EventHandler( payloadType=UpdateGovSteam2Event.class )
    public void handle( UpdateGovSteam2Event event) {
    	LOGGER.info("handling UpdateGovSteam2Event - " + event );
    	
	    GovSteam2 entity = new GovSteam2();
        entity.setGovSteam2Id( event.getGovSteam2Id() );
        entity.setDbf( event.getDbf() );
        entity.setK( event.getK() );
        entity.setMnef( event.getMnef() );
        entity.setMxef( event.getMxef() );
        entity.setPmax( event.getPmax() );
        entity.setPmin( event.getPmin() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteam2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam2( entity );        
    }
    
    /*
     * @param	event DeleteGovSteam2Event
     */
    @EventHandler( payloadType=DeleteGovSteam2Event.class )
    public void handle( DeleteGovSteam2Event event) {
    	LOGGER.info("handling DeleteGovSteam2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteam2 entity = delete( event.getGovSteam2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteam2( entity );

    }    




    /**
     * Method to retrieve the GovSteam2 via an GovSteam2PrimaryKey.
     * @param 	id Long
     * @return 	GovSteam2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteam2 handle( FindGovSteam2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteam2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteam2s
     *
     * @param	query	FindAllGovSteam2Query 
     * @return 	List<GovSteam2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteam2> handle( FindAllGovSteam2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteam2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteam2
	 */
	protected void emitFindGovSteam2( GovSteam2 entity ) {
		LOGGER.info("handling emitFindGovSteam2" );
		
	    queryUpdateEmitter.emit(FindGovSteam2Query.class,
	                            query -> query.getFilter().getGovSteam2Id().equals(entity.getGovSteam2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteam2
	 * 
	 * @param		entity	GovSteam2
	 */
	protected void emitFindAllGovSteam2( GovSteam2 entity ) {
		LOGGER.info("handling emitFindAllGovSteam2" );
		
	    queryUpdateEmitter.emit(FindAllGovSteam2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteam2Projector.class.getName());

}
