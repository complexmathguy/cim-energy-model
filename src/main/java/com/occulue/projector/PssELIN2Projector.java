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
 * Projector for PssELIN2 as outlined for the CQRS pattern.  All event handling and query handling related to PssELIN2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssELIN2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssELIN2")
@Component("pssELIN2-projector")
public class PssELIN2Projector extends PssELIN2EntityProjector {
		
	// core constructor
	public PssELIN2Projector(PssELIN2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssELIN2Event
     */
    @EventHandler( payloadType=CreatePssELIN2Event.class )
    public void handle( CreatePssELIN2Event event) {
	    LOGGER.info("handling CreatePssELIN2Event - " + event );
	    PssELIN2 entity = new PssELIN2();
        entity.setPssELIN2Id( event.getPssELIN2Id() );
        entity.setApss( event.getApss() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setPpss( event.getPpss() );
        entity.setPsslim( event.getPsslim() );
        entity.setTs1( event.getTs1() );
        entity.setTs2( event.getTs2() );
        entity.setTs3( event.getTs3() );
        entity.setTs4( event.getTs4() );
        entity.setTs5( event.getTs5() );
        entity.setTs6( event.getTs6() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssELIN2( entity );
    }

    /*
     * @param	event UpdatePssELIN2Event
     */
    @EventHandler( payloadType=UpdatePssELIN2Event.class )
    public void handle( UpdatePssELIN2Event event) {
    	LOGGER.info("handling UpdatePssELIN2Event - " + event );
    	
	    PssELIN2 entity = new PssELIN2();
        entity.setPssELIN2Id( event.getPssELIN2Id() );
        entity.setApss( event.getApss() );
        entity.setKs1( event.getKs1() );
        entity.setKs2( event.getKs2() );
        entity.setPpss( event.getPpss() );
        entity.setPsslim( event.getPsslim() );
        entity.setTs1( event.getTs1() );
        entity.setTs2( event.getTs2() );
        entity.setTs3( event.getTs3() );
        entity.setTs4( event.getTs4() );
        entity.setTs5( event.getTs5() );
        entity.setTs6( event.getTs6() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssELIN2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssELIN2( entity );        
    }
    
    /*
     * @param	event DeletePssELIN2Event
     */
    @EventHandler( payloadType=DeletePssELIN2Event.class )
    public void handle( DeletePssELIN2Event event) {
    	LOGGER.info("handling DeletePssELIN2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssELIN2 entity = delete( event.getPssELIN2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssELIN2( entity );

    }    




    /**
     * Method to retrieve the PssELIN2 via an PssELIN2PrimaryKey.
     * @param 	id Long
     * @return 	PssELIN2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssELIN2 handle( FindPssELIN2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssELIN2Id() );
    }
    
    /**
     * Method to retrieve a collection of all PssELIN2s
     *
     * @param	query	FindAllPssELIN2Query 
     * @return 	List<PssELIN2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssELIN2> handle( FindAllPssELIN2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssELIN2, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssELIN2
	 */
	protected void emitFindPssELIN2( PssELIN2 entity ) {
		LOGGER.info("handling emitFindPssELIN2" );
		
	    queryUpdateEmitter.emit(FindPssELIN2Query.class,
	                            query -> query.getFilter().getPssELIN2Id().equals(entity.getPssELIN2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssELIN2
	 * 
	 * @param		entity	PssELIN2
	 */
	protected void emitFindAllPssELIN2( PssELIN2 entity ) {
		LOGGER.info("handling emitFindAllPssELIN2" );
		
	    queryUpdateEmitter.emit(FindAllPssELIN2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssELIN2Projector.class.getName());

}
