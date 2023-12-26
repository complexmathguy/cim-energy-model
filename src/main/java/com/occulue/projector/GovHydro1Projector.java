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
 * Projector for GovHydro1 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydro1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydro1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydro1")
@Component("govHydro1-projector")
public class GovHydro1Projector extends GovHydro1EntityProjector {
		
	// core constructor
	public GovHydro1Projector(GovHydro1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydro1Event
     */
    @EventHandler( payloadType=CreateGovHydro1Event.class )
    public void handle( CreateGovHydro1Event event) {
	    LOGGER.info("handling CreateGovHydro1Event - " + event );
	    GovHydro1 entity = new GovHydro1();
        entity.setGovHydro1Id( event.getGovHydro1Id() );
        entity.setAt( event.getAt() );
        entity.setDturb( event.getDturb() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setHdam( event.getHdam() );
        entity.setMwbase( event.getMwbase() );
        entity.setQnl( event.getQnl() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTf( event.getTf() );
        entity.setTg( event.getTg() );
        entity.setTr( event.getTr() );
        entity.setTw( event.getTw() );
        entity.setVelm( event.getVelm() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro1( entity );
    }

    /*
     * @param	event UpdateGovHydro1Event
     */
    @EventHandler( payloadType=UpdateGovHydro1Event.class )
    public void handle( UpdateGovHydro1Event event) {
    	LOGGER.info("handling UpdateGovHydro1Event - " + event );
    	
	    GovHydro1 entity = new GovHydro1();
        entity.setGovHydro1Id( event.getGovHydro1Id() );
        entity.setAt( event.getAt() );
        entity.setDturb( event.getDturb() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setHdam( event.getHdam() );
        entity.setMwbase( event.getMwbase() );
        entity.setQnl( event.getQnl() );
        entity.setRperm( event.getRperm() );
        entity.setRtemp( event.getRtemp() );
        entity.setTf( event.getTf() );
        entity.setTg( event.getTg() );
        entity.setTr( event.getTr() );
        entity.setTw( event.getTw() );
        entity.setVelm( event.getVelm() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydro1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro1( entity );        
    }
    
    /*
     * @param	event DeleteGovHydro1Event
     */
    @EventHandler( payloadType=DeleteGovHydro1Event.class )
    public void handle( DeleteGovHydro1Event event) {
    	LOGGER.info("handling DeleteGovHydro1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydro1 entity = delete( event.getGovHydro1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydro1( entity );

    }    




    /**
     * Method to retrieve the GovHydro1 via an GovHydro1PrimaryKey.
     * @param 	id Long
     * @return 	GovHydro1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydro1 handle( FindGovHydro1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydro1Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydro1s
     *
     * @param	query	FindAllGovHydro1Query 
     * @return 	List<GovHydro1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydro1> handle( FindAllGovHydro1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydro1, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydro1
	 */
	protected void emitFindGovHydro1( GovHydro1 entity ) {
		LOGGER.info("handling emitFindGovHydro1" );
		
	    queryUpdateEmitter.emit(FindGovHydro1Query.class,
	                            query -> query.getFilter().getGovHydro1Id().equals(entity.getGovHydro1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydro1
	 * 
	 * @param		entity	GovHydro1
	 */
	protected void emitFindAllGovHydro1( GovHydro1 entity ) {
		LOGGER.info("handling emitFindAllGovHydro1" );
		
	    queryUpdateEmitter.emit(FindAllGovHydro1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydro1Projector.class.getName());

}
