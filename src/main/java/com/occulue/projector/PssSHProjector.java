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
 * Projector for PssSH as outlined for the CQRS pattern.  All event handling and query handling related to PssSH are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssSHAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssSH")
@Component("pssSH-projector")
public class PssSHProjector extends PssSHEntityProjector {
		
	// core constructor
	public PssSHProjector(PssSHRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssSHEvent
     */
    @EventHandler( payloadType=CreatePssSHEvent.class )
    public void handle( CreatePssSHEvent event) {
	    LOGGER.info("handling CreatePssSHEvent - " + event );
	    PssSH entity = new PssSH();
        entity.setPssSHId( event.getPssSHId() );
        entity.setK( event.getK() );
        entity.setK0( event.getK0() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTd( event.getTd() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSH( entity );
    }

    /*
     * @param	event UpdatePssSHEvent
     */
    @EventHandler( payloadType=UpdatePssSHEvent.class )
    public void handle( UpdatePssSHEvent event) {
    	LOGGER.info("handling UpdatePssSHEvent - " + event );
    	
	    PssSH entity = new PssSH();
        entity.setPssSHId( event.getPssSHId() );
        entity.setK( event.getK() );
        entity.setK0( event.getK0() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setK4( event.getK4() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setTd( event.getTd() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssSH( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSH( entity );        
    }
    
    /*
     * @param	event DeletePssSHEvent
     */
    @EventHandler( payloadType=DeletePssSHEvent.class )
    public void handle( DeletePssSHEvent event) {
    	LOGGER.info("handling DeletePssSHEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssSH entity = delete( event.getPssSHId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSH( entity );

    }    




    /**
     * Method to retrieve the PssSH via an PssSHPrimaryKey.
     * @param 	id Long
     * @return 	PssSH
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssSH handle( FindPssSHQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssSHId() );
    }
    
    /**
     * Method to retrieve a collection of all PssSHs
     *
     * @param	query	FindAllPssSHQuery 
     * @return 	List<PssSH> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssSH> handle( FindAllPssSHQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssSH, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssSH
	 */
	protected void emitFindPssSH( PssSH entity ) {
		LOGGER.info("handling emitFindPssSH" );
		
	    queryUpdateEmitter.emit(FindPssSHQuery.class,
	                            query -> query.getFilter().getPssSHId().equals(entity.getPssSHId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssSH
	 * 
	 * @param		entity	PssSH
	 */
	protected void emitFindAllPssSH( PssSH entity ) {
		LOGGER.info("handling emitFindAllPssSH" );
		
	    queryUpdateEmitter.emit(FindAllPssSHQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssSHProjector.class.getName());

}
