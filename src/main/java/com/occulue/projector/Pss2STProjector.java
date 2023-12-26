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
 * Projector for Pss2ST as outlined for the CQRS pattern.  All event handling and query handling related to Pss2ST are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Pss2STAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pss2ST")
@Component("pss2ST-projector")
public class Pss2STProjector extends Pss2STEntityProjector {
		
	// core constructor
	public Pss2STProjector(Pss2STRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePss2STEvent
     */
    @EventHandler( payloadType=CreatePss2STEvent.class )
    public void handle( CreatePss2STEvent event) {
	    LOGGER.info("handling CreatePss2STEvent - " + event );
	    Pss2ST entity = new Pss2ST();
        entity.setPss2STId( event.getPss2STId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setLsmax( event.getLsmax() );
        entity.setLsmin( event.getLsmin() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss2ST( entity );
    }

    /*
     * @param	event UpdatePss2STEvent
     */
    @EventHandler( payloadType=UpdatePss2STEvent.class )
    public void handle( UpdatePss2STEvent event) {
    	LOGGER.info("handling UpdatePss2STEvent - " + event );
    	
	    Pss2ST entity = new Pss2ST();
        entity.setPss2STId( event.getPss2STId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setLsmax( event.getLsmax() );
        entity.setLsmin( event.getLsmin() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPss2ST( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss2ST( entity );        
    }
    
    /*
     * @param	event DeletePss2STEvent
     */
    @EventHandler( payloadType=DeletePss2STEvent.class )
    public void handle( DeletePss2STEvent event) {
    	LOGGER.info("handling DeletePss2STEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Pss2ST entity = delete( event.getPss2STId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss2ST( entity );

    }    




    /**
     * Method to retrieve the Pss2ST via an Pss2STPrimaryKey.
     * @param 	id Long
     * @return 	Pss2ST
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Pss2ST handle( FindPss2STQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPss2STId() );
    }
    
    /**
     * Method to retrieve a collection of all Pss2STs
     *
     * @param	query	FindAllPss2STQuery 
     * @return 	List<Pss2ST> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Pss2ST> handle( FindAllPss2STQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPss2ST, 
	 * but only if the id matches
	 * 
	 * @param		entity	Pss2ST
	 */
	protected void emitFindPss2ST( Pss2ST entity ) {
		LOGGER.info("handling emitFindPss2ST" );
		
	    queryUpdateEmitter.emit(FindPss2STQuery.class,
	                            query -> query.getFilter().getPss2STId().equals(entity.getPss2STId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPss2ST
	 * 
	 * @param		entity	Pss2ST
	 */
	protected void emitFindAllPss2ST( Pss2ST entity ) {
		LOGGER.info("handling emitFindAllPss2ST" );
		
	    queryUpdateEmitter.emit(FindAllPss2STQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Pss2STProjector.class.getName());

}
