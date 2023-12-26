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
 * Projector for GovSteamCC as outlined for the CQRS pattern.  All event handling and query handling related to GovSteamCC are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GovSteamCCAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("govSteamCC")
@Component("govSteamCC-projector")
public class GovSteamCCProjector extends GovSteamCCEntityProjector {
		
	// core constructor
	public GovSteamCCProjector(GovSteamCCRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGovSteamCCEvent
     */
    @EventHandler( payloadType=CreateGovSteamCCEvent.class )
    public void handle( CreateGovSteamCCEvent event) {
	    LOGGER.info("handling CreateGovSteamCCEvent - " + event );
	    GovSteamCC entity = new GovSteamCC();
        entity.setGovSteamCCId( event.getGovSteamCCId() );
        entity.setDhp( event.getDhp() );
        entity.setDlp( event.getDlp() );
        entity.setFhp( event.getFhp() );
        entity.setFlp( event.getFlp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmaxhp( event.getPmaxhp() );
        entity.setPmaxlp( event.getPmaxlp() );
        entity.setRhp( event.getRhp() );
        entity.setRlp( event.getRlp() );
        entity.setT1hp( event.getT1hp() );
        entity.setT1lp( event.getT1lp() );
        entity.setT3hp( event.getT3hp() );
        entity.setT3lp( event.getT3lp() );
        entity.setT4hp( event.getT4hp() );
        entity.setT4lp( event.getT4lp() );
        entity.setT5hp( event.getT5hp() );
        entity.setT5lp( event.getT5lp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamCC( entity );
    }

    /*
     * @param	event UpdateGovSteamCCEvent
     */
    @EventHandler( payloadType=UpdateGovSteamCCEvent.class )
    public void handle( UpdateGovSteamCCEvent event) {
    	LOGGER.info("handling UpdateGovSteamCCEvent - " + event );
    	
	    GovSteamCC entity = new GovSteamCC();
        entity.setGovSteamCCId( event.getGovSteamCCId() );
        entity.setDhp( event.getDhp() );
        entity.setDlp( event.getDlp() );
        entity.setFhp( event.getFhp() );
        entity.setFlp( event.getFlp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPmaxhp( event.getPmaxhp() );
        entity.setPmaxlp( event.getPmaxlp() );
        entity.setRhp( event.getRhp() );
        entity.setRlp( event.getRlp() );
        entity.setT1hp( event.getT1hp() );
        entity.setT1lp( event.getT1lp() );
        entity.setT3hp( event.getT3hp() );
        entity.setT3lp( event.getT3lp() );
        entity.setT4hp( event.getT4hp() );
        entity.setT4lp( event.getT4lp() );
        entity.setT5hp( event.getT5hp() );
        entity.setT5lp( event.getT5lp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGovSteamCC( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamCC( entity );        
    }
    
    /*
     * @param	event DeleteGovSteamCCEvent
     */
    @EventHandler( payloadType=DeleteGovSteamCCEvent.class )
    public void handle( DeleteGovSteamCCEvent event) {
    	LOGGER.info("handling DeleteGovSteamCCEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GovSteamCC entity = delete( event.getGovSteamCCId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGovSteamCC( entity );

    }    




    /**
     * Method to retrieve the GovSteamCC via an GovSteamCCPrimaryKey.
     * @param 	id Long
     * @return 	GovSteamCC
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GovSteamCC handle( FindGovSteamCCQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGovSteamCCId() );
    }
    
    /**
     * Method to retrieve a collection of all GovSteamCCs
     *
     * @param	query	FindAllGovSteamCCQuery 
     * @return 	List<GovSteamCC> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GovSteamCC> handle( FindAllGovSteamCCQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGovSteamCC, 
	 * but only if the id matches
	 * 
	 * @param		entity	GovSteamCC
	 */
	protected void emitFindGovSteamCC( GovSteamCC entity ) {
		LOGGER.info("handling emitFindGovSteamCC" );
		
	    queryUpdateEmitter.emit(FindGovSteamCCQuery.class,
	                            query -> query.getFilter().getGovSteamCCId().equals(entity.getGovSteamCCId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGovSteamCC
	 * 
	 * @param		entity	GovSteamCC
	 */
	protected void emitFindAllGovSteamCC( GovSteamCC entity ) {
		LOGGER.info("handling emitFindAllGovSteamCC" );
		
	    queryUpdateEmitter.emit(FindAllGovSteamCCQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GovSteamCCProjector.class.getName());

}
