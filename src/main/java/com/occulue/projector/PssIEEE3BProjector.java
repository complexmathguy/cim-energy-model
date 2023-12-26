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
 * Projector for PssIEEE3B as outlined for the CQRS pattern.  All event handling and query handling related to PssIEEE3B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssIEEE3BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssIEEE3B")
@Component("pssIEEE3B-projector")
public class PssIEEE3BProjector extends PssIEEE3BEntityProjector {
		
	// core constructor
	public PssIEEE3BProjector(PssIEEE3BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssIEEE3BEvent
     */
    @EventHandler( payloadType=CreatePssIEEE3BEvent.class )
    public void handle( CreatePssIEEE3BEvent event) {
	    LOGGER.info("handling CreatePssIEEE3BEvent - " + event );
	    PssIEEE3B entity = new PssIEEE3B();
        entity.setPssIEEE3BId( event.getPssIEEE3BId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setA7( event.getA7() );
        entity.setA8( event.getA8() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setTw3( event.getTw3() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE3B( entity );
    }

    /*
     * @param	event UpdatePssIEEE3BEvent
     */
    @EventHandler( payloadType=UpdatePssIEEE3BEvent.class )
    public void handle( UpdatePssIEEE3BEvent event) {
    	LOGGER.info("handling UpdatePssIEEE3BEvent - " + event );
    	
	    PssIEEE3B entity = new PssIEEE3B();
        entity.setPssIEEE3BId( event.getPssIEEE3BId() );
        entity.setA1( event.getA1() );
        entity.setA2( event.getA2() );
        entity.setA3( event.getA3() );
        entity.setA4( event.getA4() );
        entity.setA5( event.getA5() );
        entity.setA6( event.getA6() );
        entity.setA7( event.getA7() );
        entity.setA8( event.getA8() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setTw3( event.getTw3() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssIEEE3B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE3B( entity );        
    }
    
    /*
     * @param	event DeletePssIEEE3BEvent
     */
    @EventHandler( payloadType=DeletePssIEEE3BEvent.class )
    public void handle( DeletePssIEEE3BEvent event) {
    	LOGGER.info("handling DeletePssIEEE3BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssIEEE3B entity = delete( event.getPssIEEE3BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE3B( entity );

    }    




    /**
     * Method to retrieve the PssIEEE3B via an PssIEEE3BPrimaryKey.
     * @param 	id Long
     * @return 	PssIEEE3B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssIEEE3B handle( FindPssIEEE3BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssIEEE3BId() );
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE3Bs
     *
     * @param	query	FindAllPssIEEE3BQuery 
     * @return 	List<PssIEEE3B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssIEEE3B> handle( FindAllPssIEEE3BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssIEEE3B, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssIEEE3B
	 */
	protected void emitFindPssIEEE3B( PssIEEE3B entity ) {
		LOGGER.info("handling emitFindPssIEEE3B" );
		
	    queryUpdateEmitter.emit(FindPssIEEE3BQuery.class,
	                            query -> query.getFilter().getPssIEEE3BId().equals(entity.getPssIEEE3BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssIEEE3B
	 * 
	 * @param		entity	PssIEEE3B
	 */
	protected void emitFindAllPssIEEE3B( PssIEEE3B entity ) {
		LOGGER.info("handling emitFindAllPssIEEE3B" );
		
	    queryUpdateEmitter.emit(FindAllPssIEEE3BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE3BProjector.class.getName());

}
