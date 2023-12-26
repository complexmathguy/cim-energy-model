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
 * Projector for ExcAC4A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC4A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC4AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC4A")
@Component("excAC4A-projector")
public class ExcAC4AProjector extends ExcAC4AEntityProjector {
		
	// core constructor
	public ExcAC4AProjector(ExcAC4ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC4AEvent
     */
    @EventHandler( payloadType=CreateExcAC4AEvent.class )
    public void handle( CreateExcAC4AEvent event) {
	    LOGGER.info("handling CreateExcAC4AEvent - " + event );
	    ExcAC4A entity = new ExcAC4A();
        entity.setExcAC4AId( event.getExcAC4AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC4A( entity );
    }

    /*
     * @param	event UpdateExcAC4AEvent
     */
    @EventHandler( payloadType=UpdateExcAC4AEvent.class )
    public void handle( UpdateExcAC4AEvent event) {
    	LOGGER.info("handling UpdateExcAC4AEvent - " + event );
    	
	    ExcAC4A entity = new ExcAC4A();
        entity.setExcAC4AId( event.getExcAC4AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC4A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC4A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC4AEvent
     */
    @EventHandler( payloadType=DeleteExcAC4AEvent.class )
    public void handle( DeleteExcAC4AEvent event) {
    	LOGGER.info("handling DeleteExcAC4AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC4A entity = delete( event.getExcAC4AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC4A( entity );

    }    




    /**
     * Method to retrieve the ExcAC4A via an ExcAC4APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC4A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC4A handle( FindExcAC4AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC4AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC4As
     *
     * @param	query	FindAllExcAC4AQuery 
     * @return 	List<ExcAC4A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC4A> handle( FindAllExcAC4AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC4A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC4A
	 */
	protected void emitFindExcAC4A( ExcAC4A entity ) {
		LOGGER.info("handling emitFindExcAC4A" );
		
	    queryUpdateEmitter.emit(FindExcAC4AQuery.class,
	                            query -> query.getFilter().getExcAC4AId().equals(entity.getExcAC4AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC4A
	 * 
	 * @param		entity	ExcAC4A
	 */
	protected void emitFindAllExcAC4A( ExcAC4A entity ) {
		LOGGER.info("handling emitFindAllExcAC4A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC4AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC4AProjector.class.getName());

}
