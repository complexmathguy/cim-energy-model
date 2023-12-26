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
 * Projector for TurbLCFB1 as outlined for the CQRS pattern.  All event handling and query handling related to TurbLCFB1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by TurbLCFB1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("turbLCFB1")
@Component("turbLCFB1-projector")
public class TurbLCFB1Projector extends TurbLCFB1EntityProjector {
		
	// core constructor
	public TurbLCFB1Projector(TurbLCFB1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateTurbLCFB1Event
     */
    @EventHandler( payloadType=CreateTurbLCFB1Event.class )
    public void handle( CreateTurbLCFB1Event event) {
	    LOGGER.info("handling CreateTurbLCFB1Event - " + event );
	    TurbLCFB1 entity = new TurbLCFB1();
        entity.setTurbLCFB1Id( event.getTurbLCFB1Id() );
        entity.setDb( event.getDb() );
        entity.setEmax( event.getEmax() );
        entity.setFb( event.getFb() );
        entity.setFbf( event.getFbf() );
        entity.setIrmax( event.getIrmax() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPbf( event.getPbf() );
        entity.setPmwset( event.getPmwset() );
        entity.setSpeedReferenceGovernor( event.getSpeedReferenceGovernor() );
        entity.setTpelec( event.getTpelec() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbLCFB1( entity );
    }

    /*
     * @param	event UpdateTurbLCFB1Event
     */
    @EventHandler( payloadType=UpdateTurbLCFB1Event.class )
    public void handle( UpdateTurbLCFB1Event event) {
    	LOGGER.info("handling UpdateTurbLCFB1Event - " + event );
    	
	    TurbLCFB1 entity = new TurbLCFB1();
        entity.setTurbLCFB1Id( event.getTurbLCFB1Id() );
        entity.setDb( event.getDb() );
        entity.setEmax( event.getEmax() );
        entity.setFb( event.getFb() );
        entity.setFbf( event.getFbf() );
        entity.setIrmax( event.getIrmax() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setMwbase( event.getMwbase() );
        entity.setPbf( event.getPbf() );
        entity.setPmwset( event.getPmwset() );
        entity.setSpeedReferenceGovernor( event.getSpeedReferenceGovernor() );
        entity.setTpelec( event.getTpelec() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindTurbLCFB1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbLCFB1( entity );        
    }
    
    /*
     * @param	event DeleteTurbLCFB1Event
     */
    @EventHandler( payloadType=DeleteTurbLCFB1Event.class )
    public void handle( DeleteTurbLCFB1Event event) {
    	LOGGER.info("handling DeleteTurbLCFB1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	TurbLCFB1 entity = delete( event.getTurbLCFB1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllTurbLCFB1( entity );

    }    




    /**
     * Method to retrieve the TurbLCFB1 via an TurbLCFB1PrimaryKey.
     * @param 	id Long
     * @return 	TurbLCFB1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public TurbLCFB1 handle( FindTurbLCFB1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getTurbLCFB1Id() );
    }
    
    /**
     * Method to retrieve a collection of all TurbLCFB1s
     *
     * @param	query	FindAllTurbLCFB1Query 
     * @return 	List<TurbLCFB1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<TurbLCFB1> handle( FindAllTurbLCFB1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindTurbLCFB1, 
	 * but only if the id matches
	 * 
	 * @param		entity	TurbLCFB1
	 */
	protected void emitFindTurbLCFB1( TurbLCFB1 entity ) {
		LOGGER.info("handling emitFindTurbLCFB1" );
		
	    queryUpdateEmitter.emit(FindTurbLCFB1Query.class,
	                            query -> query.getFilter().getTurbLCFB1Id().equals(entity.getTurbLCFB1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllTurbLCFB1
	 * 
	 * @param		entity	TurbLCFB1
	 */
	protected void emitFindAllTurbLCFB1( TurbLCFB1 entity ) {
		LOGGER.info("handling emitFindAllTurbLCFB1" );
		
	    queryUpdateEmitter.emit(FindAllTurbLCFB1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(TurbLCFB1Projector.class.getName());

}
