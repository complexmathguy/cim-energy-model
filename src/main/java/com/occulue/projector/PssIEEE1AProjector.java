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
 * Projector for PssIEEE1A as outlined for the CQRS pattern.  All event handling and query handling related to PssIEEE1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssIEEE1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssIEEE1A")
@Component("pssIEEE1A-projector")
public class PssIEEE1AProjector extends PssIEEE1AEntityProjector {
		
	// core constructor
	public PssIEEE1AProjector(PssIEEE1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssIEEE1AEvent
     */
    @EventHandler( payloadType=CreatePssIEEE1AEvent.class )
    public void handle( CreatePssIEEE1AEvent event) {
	    LOGGER.info("handling CreatePssIEEE1AEvent - " + event );
	    PssIEEE1A entity = new PssIEEE1A();
        entity.setPssIEEE1AId( event.getPssIEEE1AId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setInputSignalType( event.getInputSignalType() );
        entity.setKs( event.getKs() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE1A( entity );
    }

    /*
     * @param	event UpdatePssIEEE1AEvent
     */
    @EventHandler( payloadType=UpdatePssIEEE1AEvent.class )
    public void handle( UpdatePssIEEE1AEvent event) {
    	LOGGER.info("handling UpdatePssIEEE1AEvent - " + event );
    	
	    PssIEEE1A entity = new PssIEEE1A();
        entity.setPssIEEE1AId( event.getPssIEEE1AId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setInputSignalType( event.getInputSignalType() );
        entity.setKs( event.getKs() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssIEEE1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE1A( entity );        
    }
    
    /*
     * @param	event DeletePssIEEE1AEvent
     */
    @EventHandler( payloadType=DeletePssIEEE1AEvent.class )
    public void handle( DeletePssIEEE1AEvent event) {
    	LOGGER.info("handling DeletePssIEEE1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssIEEE1A entity = delete( event.getPssIEEE1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE1A( entity );

    }    




    /**
     * Method to retrieve the PssIEEE1A via an PssIEEE1APrimaryKey.
     * @param 	id Long
     * @return 	PssIEEE1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssIEEE1A handle( FindPssIEEE1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssIEEE1AId() );
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE1As
     *
     * @param	query	FindAllPssIEEE1AQuery 
     * @return 	List<PssIEEE1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssIEEE1A> handle( FindAllPssIEEE1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssIEEE1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssIEEE1A
	 */
	protected void emitFindPssIEEE1A( PssIEEE1A entity ) {
		LOGGER.info("handling emitFindPssIEEE1A" );
		
	    queryUpdateEmitter.emit(FindPssIEEE1AQuery.class,
	                            query -> query.getFilter().getPssIEEE1AId().equals(entity.getPssIEEE1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssIEEE1A
	 * 
	 * @param		entity	PssIEEE1A
	 */
	protected void emitFindAllPssIEEE1A( PssIEEE1A entity ) {
		LOGGER.info("handling emitFindAllPssIEEE1A" );
		
	    queryUpdateEmitter.emit(FindAllPssIEEE1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE1AProjector.class.getName());

}
