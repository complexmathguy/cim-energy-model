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
 * Projector for DiscExcContIEEEDEC1A as outlined for the CQRS pattern.  All event handling and query handling related to DiscExcContIEEEDEC1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscExcContIEEEDEC1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discExcContIEEEDEC1A")
@Component("discExcContIEEEDEC1A-projector")
public class DiscExcContIEEEDEC1AProjector extends DiscExcContIEEEDEC1AEntityProjector {
		
	// core constructor
	public DiscExcContIEEEDEC1AProjector(DiscExcContIEEEDEC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscExcContIEEEDEC1AEvent
     */
    @EventHandler( payloadType=CreateDiscExcContIEEEDEC1AEvent.class )
    public void handle( CreateDiscExcContIEEEDEC1AEvent event) {
	    LOGGER.info("handling CreateDiscExcContIEEEDEC1AEvent - " + event );
	    DiscExcContIEEEDEC1A entity = new DiscExcContIEEEDEC1A();
        entity.setDiscExcContIEEEDEC1AId( event.getDiscExcContIEEEDEC1AId() );
        entity.setEsc( event.getEsc() );
        entity.setKan( event.getKan() );
        entity.setKetl( event.getKetl() );
        entity.setTan( event.getTan() );
        entity.setTd( event.getTd() );
        entity.setTl1( event.getTl1() );
        entity.setTl2( event.getTl2() );
        entity.setTw5( event.getTw5() );
        entity.setValue( event.getValue() );
        entity.setVanmax( event.getVanmax() );
        entity.setVomax( event.getVomax() );
        entity.setVomin( event.getVomin() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
        entity.setVtc( event.getVtc() );
        entity.setVtlmt( event.getVtlmt() );
        entity.setVtm( event.getVtm() );
        entity.setVtn( event.getVtn() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC1A( entity );
    }

    /*
     * @param	event UpdateDiscExcContIEEEDEC1AEvent
     */
    @EventHandler( payloadType=UpdateDiscExcContIEEEDEC1AEvent.class )
    public void handle( UpdateDiscExcContIEEEDEC1AEvent event) {
    	LOGGER.info("handling UpdateDiscExcContIEEEDEC1AEvent - " + event );
    	
	    DiscExcContIEEEDEC1A entity = new DiscExcContIEEEDEC1A();
        entity.setDiscExcContIEEEDEC1AId( event.getDiscExcContIEEEDEC1AId() );
        entity.setEsc( event.getEsc() );
        entity.setKan( event.getKan() );
        entity.setKetl( event.getKetl() );
        entity.setTan( event.getTan() );
        entity.setTd( event.getTd() );
        entity.setTl1( event.getTl1() );
        entity.setTl2( event.getTl2() );
        entity.setTw5( event.getTw5() );
        entity.setValue( event.getValue() );
        entity.setVanmax( event.getVanmax() );
        entity.setVomax( event.getVomax() );
        entity.setVomin( event.getVomin() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
        entity.setVtc( event.getVtc() );
        entity.setVtlmt( event.getVtlmt() );
        entity.setVtm( event.getVtm() );
        entity.setVtn( event.getVtn() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscExcContIEEEDEC1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC1A( entity );        
    }
    
    /*
     * @param	event DeleteDiscExcContIEEEDEC1AEvent
     */
    @EventHandler( payloadType=DeleteDiscExcContIEEEDEC1AEvent.class )
    public void handle( DeleteDiscExcContIEEEDEC1AEvent event) {
    	LOGGER.info("handling DeleteDiscExcContIEEEDEC1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiscExcContIEEEDEC1A entity = delete( event.getDiscExcContIEEEDEC1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscExcContIEEEDEC1A( entity );

    }    




    /**
     * Method to retrieve the DiscExcContIEEEDEC1A via an DiscExcContIEEEDEC1APrimaryKey.
     * @param 	id Long
     * @return 	DiscExcContIEEEDEC1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiscExcContIEEEDEC1A handle( FindDiscExcContIEEEDEC1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscExcContIEEEDEC1AId() );
    }
    
    /**
     * Method to retrieve a collection of all DiscExcContIEEEDEC1As
     *
     * @param	query	FindAllDiscExcContIEEEDEC1AQuery 
     * @return 	List<DiscExcContIEEEDEC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiscExcContIEEEDEC1A> handle( FindAllDiscExcContIEEEDEC1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscExcContIEEEDEC1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiscExcContIEEEDEC1A
	 */
	protected void emitFindDiscExcContIEEEDEC1A( DiscExcContIEEEDEC1A entity ) {
		LOGGER.info("handling emitFindDiscExcContIEEEDEC1A" );
		
	    queryUpdateEmitter.emit(FindDiscExcContIEEEDEC1AQuery.class,
	                            query -> query.getFilter().getDiscExcContIEEEDEC1AId().equals(entity.getDiscExcContIEEEDEC1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscExcContIEEEDEC1A
	 * 
	 * @param		entity	DiscExcContIEEEDEC1A
	 */
	protected void emitFindAllDiscExcContIEEEDEC1A( DiscExcContIEEEDEC1A entity ) {
		LOGGER.info("handling emitFindAllDiscExcContIEEEDEC1A" );
		
	    queryUpdateEmitter.emit(FindAllDiscExcContIEEEDEC1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscExcContIEEEDEC1AProjector.class.getName());

}
