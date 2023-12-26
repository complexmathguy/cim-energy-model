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
 * Projector for PssSB4 as outlined for the CQRS pattern.  All event handling and query handling related to PssSB4 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssSB4Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssSB4")
@Component("pssSB4-projector")
public class PssSB4Projector extends PssSB4EntityProjector {
		
	// core constructor
	public PssSB4Projector(PssSB4Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssSB4Event
     */
    @EventHandler( payloadType=CreatePssSB4Event.class )
    public void handle( CreatePssSB4Event event) {
	    LOGGER.info("handling CreatePssSB4Event - " + event );
	    PssSB4 entity = new PssSB4();
        entity.setPssSB4Id( event.getPssSB4Id() );
        entity.setKx( event.getKx() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTd( event.getTd() );
        entity.setTe( event.getTe() );
        entity.setTt( event.getTt() );
        entity.setTx1( event.getTx1() );
        entity.setTx2( event.getTx2() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSB4( entity );
    }

    /*
     * @param	event UpdatePssSB4Event
     */
    @EventHandler( payloadType=UpdatePssSB4Event.class )
    public void handle( UpdatePssSB4Event event) {
    	LOGGER.info("handling UpdatePssSB4Event - " + event );
    	
	    PssSB4 entity = new PssSB4();
        entity.setPssSB4Id( event.getPssSB4Id() );
        entity.setKx( event.getKx() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTd( event.getTd() );
        entity.setTe( event.getTe() );
        entity.setTt( event.getTt() );
        entity.setTx1( event.getTx1() );
        entity.setTx2( event.getTx2() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssSB4( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSB4( entity );        
    }
    
    /*
     * @param	event DeletePssSB4Event
     */
    @EventHandler( payloadType=DeletePssSB4Event.class )
    public void handle( DeletePssSB4Event event) {
    	LOGGER.info("handling DeletePssSB4Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssSB4 entity = delete( event.getPssSB4Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSB4( entity );

    }    




    /**
     * Method to retrieve the PssSB4 via an PssSB4PrimaryKey.
     * @param 	id Long
     * @return 	PssSB4
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssSB4 handle( FindPssSB4Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssSB4Id() );
    }
    
    /**
     * Method to retrieve a collection of all PssSB4s
     *
     * @param	query	FindAllPssSB4Query 
     * @return 	List<PssSB4> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssSB4> handle( FindAllPssSB4Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssSB4, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssSB4
	 */
	protected void emitFindPssSB4( PssSB4 entity ) {
		LOGGER.info("handling emitFindPssSB4" );
		
	    queryUpdateEmitter.emit(FindPssSB4Query.class,
	                            query -> query.getFilter().getPssSB4Id().equals(entity.getPssSB4Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssSB4
	 * 
	 * @param		entity	PssSB4
	 */
	protected void emitFindAllPssSB4( PssSB4 entity ) {
		LOGGER.info("handling emitFindAllPssSB4" );
		
	    queryUpdateEmitter.emit(FindAllPssSB4Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssSB4Projector.class.getName());

}
