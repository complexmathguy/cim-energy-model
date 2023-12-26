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
 * Projector for Pss1 as outlined for the CQRS pattern.  All event handling and query handling related to Pss1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Pss1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pss1")
@Component("pss1-projector")
public class Pss1Projector extends Pss1EntityProjector {
		
	// core constructor
	public Pss1Projector(Pss1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePss1Event
     */
    @EventHandler( payloadType=CreatePss1Event.class )
    public void handle( CreatePss1Event event) {
	    LOGGER.info("handling CreatePss1Event - " + event );
	    Pss1 entity = new Pss1();
        entity.setPss1Id( event.getPss1Id() );
        entity.setKf( event.getKf() );
        entity.setKpe( event.getKpe() );
        entity.setKs( event.getKs() );
        entity.setKw( event.getKw() );
        entity.setPmin( event.getPmin() );
        entity.setT10( event.getT10() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setTpe( event.getTpe() );
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
        emitFindAllPss1( entity );
    }

    /*
     * @param	event UpdatePss1Event
     */
    @EventHandler( payloadType=UpdatePss1Event.class )
    public void handle( UpdatePss1Event event) {
    	LOGGER.info("handling UpdatePss1Event - " + event );
    	
	    Pss1 entity = new Pss1();
        entity.setPss1Id( event.getPss1Id() );
        entity.setKf( event.getKf() );
        entity.setKpe( event.getKpe() );
        entity.setKs( event.getKs() );
        entity.setKw( event.getKw() );
        entity.setPmin( event.getPmin() );
        entity.setT10( event.getT10() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setTpe( event.getTpe() );
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
        emitFindPss1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss1( entity );        
    }
    
    /*
     * @param	event DeletePss1Event
     */
    @EventHandler( payloadType=DeletePss1Event.class )
    public void handle( DeletePss1Event event) {
    	LOGGER.info("handling DeletePss1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Pss1 entity = delete( event.getPss1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss1( entity );

    }    




    /**
     * Method to retrieve the Pss1 via an Pss1PrimaryKey.
     * @param 	id Long
     * @return 	Pss1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Pss1 handle( FindPss1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPss1Id() );
    }
    
    /**
     * Method to retrieve a collection of all Pss1s
     *
     * @param	query	FindAllPss1Query 
     * @return 	List<Pss1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Pss1> handle( FindAllPss1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPss1, 
	 * but only if the id matches
	 * 
	 * @param		entity	Pss1
	 */
	protected void emitFindPss1( Pss1 entity ) {
		LOGGER.info("handling emitFindPss1" );
		
	    queryUpdateEmitter.emit(FindPss1Query.class,
	                            query -> query.getFilter().getPss1Id().equals(entity.getPss1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPss1
	 * 
	 * @param		entity	Pss1
	 */
	protected void emitFindAllPss1( Pss1 entity ) {
		LOGGER.info("handling emitFindAllPss1" );
		
	    queryUpdateEmitter.emit(FindAllPss1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Pss1Projector.class.getName());

}
