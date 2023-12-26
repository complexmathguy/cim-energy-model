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
 * Projector for ExcIEEEAC4A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC4A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC4AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC4A")
@Component("excIEEEAC4A-projector")
public class ExcIEEEAC4AProjector extends ExcIEEEAC4AEntityProjector {
		
	// core constructor
	public ExcIEEEAC4AProjector(ExcIEEEAC4ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC4AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC4AEvent.class )
    public void handle( CreateExcIEEEAC4AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC4AEvent - " + event );
	    ExcIEEEAC4A entity = new ExcIEEEAC4A();
        entity.setExcIEEEAC4AId( event.getExcIEEEAC4AId() );
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
        emitFindAllExcIEEEAC4A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC4AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC4AEvent.class )
    public void handle( UpdateExcIEEEAC4AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC4AEvent - " + event );
    	
	    ExcIEEEAC4A entity = new ExcIEEEAC4A();
        entity.setExcIEEEAC4AId( event.getExcIEEEAC4AId() );
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
        emitFindExcIEEEAC4A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC4A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC4AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC4AEvent.class )
    public void handle( DeleteExcIEEEAC4AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC4AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC4A entity = delete( event.getExcIEEEAC4AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC4A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC4A via an ExcIEEEAC4APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC4A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC4A handle( FindExcIEEEAC4AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC4AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC4As
     *
     * @param	query	FindAllExcIEEEAC4AQuery 
     * @return 	List<ExcIEEEAC4A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC4A> handle( FindAllExcIEEEAC4AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC4A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC4A
	 */
	protected void emitFindExcIEEEAC4A( ExcIEEEAC4A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC4A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC4AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC4AId().equals(entity.getExcIEEEAC4AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC4A
	 * 
	 * @param		entity	ExcIEEEAC4A
	 */
	protected void emitFindAllExcIEEEAC4A( ExcIEEEAC4A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC4A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC4AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC4AProjector.class.getName());

}
