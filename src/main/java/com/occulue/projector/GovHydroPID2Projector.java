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
 * Projector for GovHydroPID2 as outlined for the CQRS pattern.  All event handling and query handling related to GovHydroPID2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovHydroPID2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govHydroPID2")
@Component("govHydroPID2-projector")
public class GovHydroPID2Projector extends GovHydroPID2EntityProjector {
		
	// core constructor
	public GovHydroPID2Projector(GovHydroPID2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovHydroPID2Event
     */
    @EventHandler( payloadType=CreateGovHydroPID2Event.class )
    public void handle( CreateGovHydroPID2Event event) {
	    LOGGER.info("handling CreateGovHydroPID2Event - " + event );
	    GovHydroPID2 entity = new GovHydroPID2();
        entity.setGovHydroPID2Id( event.getGovHydroPID2Id() );
        entity.setAtw( event.getAtw() );
        entity.setD( event.getD() );
        entity.setFeedbackSignal( event.getFeedbackSignal() );
        entity.setG0( event.getG0() );
        entity.setG1( event.getG1() );
        entity.setG2( event.getG2() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setP1( event.getP1() );
        entity.setP2( event.getP2() );
        entity.setP3( event.getP3() );
        entity.setRperm( event.getRperm() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTreg( event.getTreg() );
        entity.setTw( event.getTw() );
        entity.setVelmax( event.getVelmax() );
        entity.setVelmin( event.getVelmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID2( entity );
    }

    /*
     * @param	event UpdateGovHydroPID2Event
     */
    @EventHandler( payloadType=UpdateGovHydroPID2Event.class )
    public void handle( UpdateGovHydroPID2Event event) {
    	LOGGER.info("handling UpdateGovHydroPID2Event - " + event );
    	
	    GovHydroPID2 entity = new GovHydroPID2();
        entity.setGovHydroPID2Id( event.getGovHydroPID2Id() );
        entity.setAtw( event.getAtw() );
        entity.setD( event.getD() );
        entity.setFeedbackSignal( event.getFeedbackSignal() );
        entity.setG0( event.getG0() );
        entity.setG1( event.getG1() );
        entity.setG2( event.getG2() );
        entity.setGmax( event.getGmax() );
        entity.setGmin( event.getGmin() );
        entity.setKd( event.getKd() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setP1( event.getP1() );
        entity.setP2( event.getP2() );
        entity.setP3( event.getP3() );
        entity.setRperm( event.getRperm() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTreg( event.getTreg() );
        entity.setTw( event.getTw() );
        entity.setVelmax( event.getVelmax() );
        entity.setVelmin( event.getVelmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovHydroPID2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID2( entity );        
    }
    
    /*
     * @param	event DeleteGovHydroPID2Event
     */
    @EventHandler( payloadType=DeleteGovHydroPID2Event.class )
    public void handle( DeleteGovHydroPID2Event event) {
    	LOGGER.info("handling DeleteGovHydroPID2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovHydroPID2 entity = delete( event.getGovHydroPID2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovHydroPID2( entity );

    }    




    /**
     * Method to retrieve the GovHydroPID2 via an GovHydroPID2PrimaryKey.
     * @param 	id Long
     * @return 	GovHydroPID2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovHydroPID2 handle( FindGovHydroPID2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovHydroPID2Id() );
    }
    
    /**
     * Method to retrieve a collection of all GovHydroPID2s
     *
     * @param	query	FindAllGovHydroPID2Query 
     * @return 	List<GovHydroPID2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovHydroPID2> handle( FindAllGovHydroPID2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovHydroPID2, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovHydroPID2
	 */
	protected void emitFindGovHydroPID2( GovHydroPID2 entity ) {
		LOGGER.info("handling emitFindGovHydroPID2" );
		
	    queryUpdateEmitter.emit(FindGovHydroPID2Query.class,
	                            query -> query.getFilter().getGovHydroPID2Id().equals(entity.getGovHydroPID2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovHydroPID2
	 * 
	 * @param		entity	GovHydroPID2
	 */
	protected void emitFindAllGovHydroPID2( GovHydroPID2 entity ) {
		LOGGER.info("handling emitFindAllGovHydroPID2" );
		
	    queryUpdateEmitter.emit(FindAllGovHydroPID2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovHydroPID2Projector.class.getName());

}
