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
 * Projector for Pss5 as outlined for the CQRS pattern.  All event handling and query handling related to Pss5 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Pss5Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pss5")
@Component("pss5-projector")
public class Pss5Projector extends Pss5EntityProjector {
		
	// core constructor
	public Pss5Projector(Pss5Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePss5Event
     */
    @EventHandler( payloadType=CreatePss5Event.class )
    public void handle( CreatePss5Event event) {
	    LOGGER.info("handling CreatePss5Event - " + event );
	    Pss5 entity = new Pss5();
        entity.setPss5Id( event.getPss5Id() );
        entity.setCtw2( event.getCtw2() );
        entity.setDeadband( event.getDeadband() );
        entity.setIsfreq( event.getIsfreq() );
        entity.setKf( event.getKf() );
        entity.setKpe( event.getKpe() );
        entity.setKpss( event.getKpss() );
        entity.setPmm( event.getPmm() );
        entity.setTl1( event.getTl1() );
        entity.setTl2( event.getTl2() );
        entity.setTl3( event.getTl3() );
        entity.setTl4( event.getTl4() );
        entity.setTpe( event.getTpe() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setVadat( event.getVadat() );
        entity.setVsmn( event.getVsmn() );
        entity.setVsmx( event.getVsmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss5( entity );
    }

    /*
     * @param	event UpdatePss5Event
     */
    @EventHandler( payloadType=UpdatePss5Event.class )
    public void handle( UpdatePss5Event event) {
    	LOGGER.info("handling UpdatePss5Event - " + event );
    	
	    Pss5 entity = new Pss5();
        entity.setPss5Id( event.getPss5Id() );
        entity.setCtw2( event.getCtw2() );
        entity.setDeadband( event.getDeadband() );
        entity.setIsfreq( event.getIsfreq() );
        entity.setKf( event.getKf() );
        entity.setKpe( event.getKpe() );
        entity.setKpss( event.getKpss() );
        entity.setPmm( event.getPmm() );
        entity.setTl1( event.getTl1() );
        entity.setTl2( event.getTl2() );
        entity.setTl3( event.getTl3() );
        entity.setTl4( event.getTl4() );
        entity.setTpe( event.getTpe() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setVadat( event.getVadat() );
        entity.setVsmn( event.getVsmn() );
        entity.setVsmx( event.getVsmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPss5( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss5( entity );        
    }
    
    /*
     * @param	event DeletePss5Event
     */
    @EventHandler( payloadType=DeletePss5Event.class )
    public void handle( DeletePss5Event event) {
    	LOGGER.info("handling DeletePss5Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Pss5 entity = delete( event.getPss5Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss5( entity );

    }    




    /**
     * Method to retrieve the Pss5 via an Pss5PrimaryKey.
     * @param 	id Long
     * @return 	Pss5
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Pss5 handle( FindPss5Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPss5Id() );
    }
    
    /**
     * Method to retrieve a collection of all Pss5s
     *
     * @param	query	FindAllPss5Query 
     * @return 	List<Pss5> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Pss5> handle( FindAllPss5Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPss5, 
	 * but only if the id matches
	 * 
	 * @param		entity	Pss5
	 */
	protected void emitFindPss5( Pss5 entity ) {
		LOGGER.info("handling emitFindPss5" );
		
	    queryUpdateEmitter.emit(FindPss5Query.class,
	                            query -> query.getFilter().getPss5Id().equals(entity.getPss5Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPss5
	 * 
	 * @param		entity	Pss5
	 */
	protected void emitFindAllPss5( Pss5 entity ) {
		LOGGER.info("handling emitFindAllPss5" );
		
	    queryUpdateEmitter.emit(FindAllPss5Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Pss5Projector.class.getName());

}
