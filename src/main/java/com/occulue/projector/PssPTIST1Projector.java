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
 * Projector for PssPTIST1 as outlined for the CQRS pattern.  All event handling and query handling related to PssPTIST1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssPTIST1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssPTIST1")
@Component("pssPTIST1-projector")
public class PssPTIST1Projector extends PssPTIST1EntityProjector {
		
	// core constructor
	public PssPTIST1Projector(PssPTIST1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssPTIST1Event
     */
    @EventHandler( payloadType=CreatePssPTIST1Event.class )
    public void handle( CreatePssPTIST1Event event) {
	    LOGGER.info("handling CreatePssPTIST1Event - " + event );
	    PssPTIST1 entity = new PssPTIST1();
        entity.setPssPTIST1Id( event.getPssPTIST1Id() );
        entity.setDtc( event.getDtc() );
        entity.setDtf( event.getDtf() );
        entity.setDtp( event.getDtp() );
        entity.setK( event.getK() );
        entity.setM( event.getM() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST1( entity );
    }

    /*
     * @param	event UpdatePssPTIST1Event
     */
    @EventHandler( payloadType=UpdatePssPTIST1Event.class )
    public void handle( UpdatePssPTIST1Event event) {
    	LOGGER.info("handling UpdatePssPTIST1Event - " + event );
    	
	    PssPTIST1 entity = new PssPTIST1();
        entity.setPssPTIST1Id( event.getPssPTIST1Id() );
        entity.setDtc( event.getDtc() );
        entity.setDtf( event.getDtf() );
        entity.setDtp( event.getDtp() );
        entity.setK( event.getK() );
        entity.setM( event.getM() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTf( event.getTf() );
        entity.setTp( event.getTp() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssPTIST1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST1( entity );        
    }
    
    /*
     * @param	event DeletePssPTIST1Event
     */
    @EventHandler( payloadType=DeletePssPTIST1Event.class )
    public void handle( DeletePssPTIST1Event event) {
    	LOGGER.info("handling DeletePssPTIST1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssPTIST1 entity = delete( event.getPssPTIST1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssPTIST1( entity );

    }    




    /**
     * Method to retrieve the PssPTIST1 via an PssPTIST1PrimaryKey.
     * @param 	id Long
     * @return 	PssPTIST1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssPTIST1 handle( FindPssPTIST1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssPTIST1Id() );
    }
    
    /**
     * Method to retrieve a collection of all PssPTIST1s
     *
     * @param	query	FindAllPssPTIST1Query 
     * @return 	List<PssPTIST1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssPTIST1> handle( FindAllPssPTIST1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssPTIST1, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssPTIST1
	 */
	protected void emitFindPssPTIST1( PssPTIST1 entity ) {
		LOGGER.info("handling emitFindPssPTIST1" );
		
	    queryUpdateEmitter.emit(FindPssPTIST1Query.class,
	                            query -> query.getFilter().getPssPTIST1Id().equals(entity.getPssPTIST1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssPTIST1
	 * 
	 * @param		entity	PssPTIST1
	 */
	protected void emitFindAllPssPTIST1( PssPTIST1 entity ) {
		LOGGER.info("handling emitFindAllPssPTIST1" );
		
	    queryUpdateEmitter.emit(FindAllPssPTIST1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssPTIST1Projector.class.getName());

}
