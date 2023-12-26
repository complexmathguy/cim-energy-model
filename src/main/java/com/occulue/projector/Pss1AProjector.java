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
 * Projector for Pss1A as outlined for the CQRS pattern.  All event handling and query handling related to Pss1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Pss1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pss1A")
@Component("pss1A-projector")
public class Pss1AProjector extends Pss1AEntityProjector {
		
	// core constructor
	public Pss1AProjector(Pss1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePss1AEvent
     */
    @EventHandler( payloadType=CreatePss1AEvent.class )
    public void handle( CreatePss1AEvent event) {
	    LOGGER.info("handling CreatePss1AEvent - " + event );
	    Pss1A entity = new Pss1A();
        entity.setPss1AId( event.getPss1AId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setA7( event.getA7() );
        entity.setA8( event.getA8() );
        entity.setInputSignalType( event.getInputSignalType() );
        entity.setKd( event.getKd() );
        entity.setKs( event.getKs() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTdelay( event.getTdelay() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss1A( entity );
    }

    /*
     * @param	event UpdatePss1AEvent
     */
    @EventHandler( payloadType=UpdatePss1AEvent.class )
    public void handle( UpdatePss1AEvent event) {
    	LOGGER.info("handling UpdatePss1AEvent - " + event );
    	
	    Pss1A entity = new Pss1A();
        entity.setPss1AId( event.getPss1AId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setA7( event.getA7() );
        entity.setA8( event.getA8() );
        entity.setInputSignalType( event.getInputSignalType() );
        entity.setKd( event.getKd() );
        entity.setKs( event.getKs() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTdelay( event.getTdelay() );
        entity.setVcl( event.getVcl() );
        entity.setVcu( event.getVcu() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPss1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss1A( entity );        
    }
    
    /*
     * @param	event DeletePss1AEvent
     */
    @EventHandler( payloadType=DeletePss1AEvent.class )
    public void handle( DeletePss1AEvent event) {
    	LOGGER.info("handling DeletePss1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Pss1A entity = delete( event.getPss1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss1A( entity );

    }    




    /**
     * Method to retrieve the Pss1A via an Pss1APrimaryKey.
     * @param 	id Long
     * @return 	Pss1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Pss1A handle( FindPss1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPss1AId() );
    }
    
    /**
     * Method to retrieve a collection of all Pss1As
     *
     * @param	query	FindAllPss1AQuery 
     * @return 	List<Pss1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Pss1A> handle( FindAllPss1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPss1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	Pss1A
	 */
	protected void emitFindPss1A( Pss1A entity ) {
		LOGGER.info("handling emitFindPss1A" );
		
	    queryUpdateEmitter.emit(FindPss1AQuery.class,
	                            query -> query.getFilter().getPss1AId().equals(entity.getPss1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPss1A
	 * 
	 * @param		entity	Pss1A
	 */
	protected void emitFindAllPss1A( Pss1A entity ) {
		LOGGER.info("handling emitFindAllPss1A" );
		
	    queryUpdateEmitter.emit(FindAllPss1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Pss1AProjector.class.getName());

}
