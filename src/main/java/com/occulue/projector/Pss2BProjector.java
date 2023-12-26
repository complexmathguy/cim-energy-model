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
 * Projector for Pss2B as outlined for the CQRS pattern.  All event handling and query handling related to Pss2B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by Pss2BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pss2B")
@Component("pss2B-projector")
public class Pss2BProjector extends Pss2BEntityProjector {
		
	// core constructor
	public Pss2BProjector(Pss2BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePss2BEvent
     */
    @EventHandler( payloadType=CreatePss2BEvent.class )
    public void handle( CreatePss2BEvent event) {
	    LOGGER.info("handling CreatePss2BEvent - " + event );
	    Pss2B entity = new Pss2B();
        entity.setPss2BId( event.getPss2BId() );
        entity.setA( event.getA() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setKs3( event.getKs3() );
        entity.setKs4( event.getKs4() );
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
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
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
        emitFindAllPss2B( entity );
    }

    /*
     * @param	event UpdatePss2BEvent
     */
    @EventHandler( payloadType=UpdatePss2BEvent.class )
    public void handle( UpdatePss2BEvent event) {
    	LOGGER.info("handling UpdatePss2BEvent - " + event );
    	
	    Pss2B entity = new Pss2B();
        entity.setPss2BId( event.getPss2BId() );
        entity.setA( event.getA() );
        entity.setInputSignal1Type( event.getInputSignal1Type() );
        entity.setInputSignal2Type( event.getInputSignal2Type() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setKs3( event.getKs3() );
        entity.setKs4( event.getKs4() );
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
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
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
        emitFindPss2B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss2B( entity );        
    }
    
    /*
     * @param	event DeletePss2BEvent
     */
    @EventHandler( payloadType=DeletePss2BEvent.class )
    public void handle( DeletePss2BEvent event) {
    	LOGGER.info("handling DeletePss2BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Pss2B entity = delete( event.getPss2BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPss2B( entity );

    }    




    /**
     * Method to retrieve the Pss2B via an Pss2BPrimaryKey.
     * @param 	id Long
     * @return 	Pss2B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Pss2B handle( FindPss2BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPss2BId() );
    }
    
    /**
     * Method to retrieve a collection of all Pss2Bs
     *
     * @param	query	FindAllPss2BQuery 
     * @return 	List<Pss2B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Pss2B> handle( FindAllPss2BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPss2B, 
	 * but only if the id matches
	 * 
	 * @param		entity	Pss2B
	 */
	protected void emitFindPss2B( Pss2B entity ) {
		LOGGER.info("handling emitFindPss2B" );
		
	    queryUpdateEmitter.emit(FindPss2BQuery.class,
	                            query -> query.getFilter().getPss2BId().equals(entity.getPss2BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPss2B
	 * 
	 * @param		entity	Pss2B
	 */
	protected void emitFindAllPss2B( Pss2B entity ) {
		LOGGER.info("handling emitFindAllPss2B" );
		
	    queryUpdateEmitter.emit(FindAllPss2BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(Pss2BProjector.class.getName());

}
