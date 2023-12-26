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
 * Projector for PssIEEE2B as outlined for the CQRS pattern.  All event handling and query handling related to PssIEEE2B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssIEEE2BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssIEEE2B")
@Component("pssIEEE2B-projector")
public class PssIEEE2BProjector extends PssIEEE2BEntityProjector {
		
	// core constructor
	public PssIEEE2BProjector(PssIEEE2BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssIEEE2BEvent
     */
    @EventHandler( payloadType=CreatePssIEEE2BEvent.class )
    public void handle( CreatePssIEEE2BEvent event) {
	    LOGGER.info("handling CreatePssIEEE2BEvent - " + event );
	    PssIEEE2B entity = new PssIEEE2B();
        entity.setPssIEEE2BId( event.getPssIEEE2BId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setKs3( event.getKs3() );
        entity.setM( event.getM() );
        entity.setN( event.getN() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT11( event.getT11() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setTw3( event.getTw3() );
        entity.setTw4( event.getTw4() );
        entity.setVsi1max( event.getVsi1max() );
        entity.setVsi1min( event.getVsi1min() );
        entity.setVsi2max( event.getVsi2max() );
        entity.setVsi2min( event.getVsi2min() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE2B( entity );
    }

    /*
     * @param	event UpdatePssIEEE2BEvent
     */
    @EventHandler( payloadType=UpdatePssIEEE2BEvent.class )
    public void handle( UpdatePssIEEE2BEvent event) {
    	LOGGER.info("handling UpdatePssIEEE2BEvent - " + event );
    	
	    PssIEEE2B entity = new PssIEEE2B();
        entity.setPssIEEE2BId( event.getPssIEEE2BId() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setKs3( event.getKs3() );
        entity.setM( event.getM() );
        entity.setN( event.getN() );
        entity.setT1( event.getT1() );
        entity.setT10( event.getT10() );
        entity.setT11( event.getT11() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT6( event.getT6() );
        entity.setT7( event.getT7() );
        entity.setT8( event.getT8() );
        entity.setT9( event.getT9() );
        entity.setTw1( event.getTw1() );
        entity.setTw2( event.getTw2() );
        entity.setTw3( event.getTw3() );
        entity.setTw4( event.getTw4() );
        entity.setVsi1max( event.getVsi1max() );
        entity.setVsi1min( event.getVsi1min() );
        entity.setVsi2max( event.getVsi2max() );
        entity.setVsi2min( event.getVsi2min() );
        entity.setVstmax( event.getVstmax() );
        entity.setVstmin( event.getVstmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssIEEE2B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE2B( entity );        
    }
    
    /*
     * @param	event DeletePssIEEE2BEvent
     */
    @EventHandler( payloadType=DeletePssIEEE2BEvent.class )
    public void handle( DeletePssIEEE2BEvent event) {
    	LOGGER.info("handling DeletePssIEEE2BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssIEEE2B entity = delete( event.getPssIEEE2BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssIEEE2B( entity );

    }    




    /**
     * Method to retrieve the PssIEEE2B via an PssIEEE2BPrimaryKey.
     * @param 	id Long
     * @return 	PssIEEE2B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssIEEE2B handle( FindPssIEEE2BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssIEEE2BId() );
    }
    
    /**
     * Method to retrieve a collection of all PssIEEE2Bs
     *
     * @param	query	FindAllPssIEEE2BQuery 
     * @return 	List<PssIEEE2B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssIEEE2B> handle( FindAllPssIEEE2BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssIEEE2B, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssIEEE2B
	 */
	protected void emitFindPssIEEE2B( PssIEEE2B entity ) {
		LOGGER.info("handling emitFindPssIEEE2B" );
		
	    queryUpdateEmitter.emit(FindPssIEEE2BQuery.class,
	                            query -> query.getFilter().getPssIEEE2BId().equals(entity.getPssIEEE2BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssIEEE2B
	 * 
	 * @param		entity	PssIEEE2B
	 */
	protected void emitFindAllPssIEEE2B( PssIEEE2B entity ) {
		LOGGER.info("handling emitFindAllPssIEEE2B" );
		
	    queryUpdateEmitter.emit(FindAllPssIEEE2BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssIEEE2BProjector.class.getName());

}
