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
 * Projector for PssSK as outlined for the CQRS pattern.  All event handling and query handling related to PssSK are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PssSKAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pssSK")
@Component("pssSK-projector")
public class PssSKProjector extends PssSKEntityProjector {
		
	// core constructor
	public PssSKProjector(PssSKRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePssSKEvent
     */
    @EventHandler( payloadType=CreatePssSKEvent.class )
    public void handle( CreatePssSKEvent event) {
	    LOGGER.info("handling CreatePssSKEvent - " + event );
	    PssSK entity = new PssSK();
        entity.setPssSKId( event.getPssSKId() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSK( entity );
    }

    /*
     * @param	event UpdatePssSKEvent
     */
    @EventHandler( payloadType=UpdatePssSKEvent.class )
    public void handle( UpdatePssSKEvent event) {
    	LOGGER.info("handling UpdatePssSKEvent - " + event );
    	
	    PssSK entity = new PssSK();
        entity.setPssSKId( event.getPssSKId() );
        entity.setK1( event.getK1() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setVsmax( event.getVsmax() );
        entity.setVsmin( event.getVsmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPssSK( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSK( entity );        
    }
    
    /*
     * @param	event DeletePssSKEvent
     */
    @EventHandler( payloadType=DeletePssSKEvent.class )
    public void handle( DeletePssSKEvent event) {
    	LOGGER.info("handling DeletePssSKEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PssSK entity = delete( event.getPssSKId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPssSK( entity );

    }    




    /**
     * Method to retrieve the PssSK via an PssSKPrimaryKey.
     * @param 	id Long
     * @return 	PssSK
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PssSK handle( FindPssSKQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPssSKId() );
    }
    
    /**
     * Method to retrieve a collection of all PssSKs
     *
     * @param	query	FindAllPssSKQuery 
     * @return 	List<PssSK> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PssSK> handle( FindAllPssSKQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPssSK, 
	 * but only if the id matches
	 * 
	 * @param		entity	PssSK
	 */
	protected void emitFindPssSK( PssSK entity ) {
		LOGGER.info("handling emitFindPssSK" );
		
	    queryUpdateEmitter.emit(FindPssSKQuery.class,
	                            query -> query.getFilter().getPssSKId().equals(entity.getPssSKId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPssSK
	 * 
	 * @param		entity	PssSK
	 */
	protected void emitFindAllPssSK( PssSK entity ) {
		LOGGER.info("handling emitFindAllPssSK" );
		
	    queryUpdateEmitter.emit(FindAllPssSKQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PssSKProjector.class.getName());

}
