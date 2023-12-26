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
 * Projector for ExcIEEEST3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST3A")
@Component("excIEEEST3A-projector")
public class ExcIEEEST3AProjector extends ExcIEEEST3AEntityProjector {
		
	// core constructor
	public ExcIEEEST3AProjector(ExcIEEEST3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST3AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST3AEvent.class )
    public void handle( CreateExcIEEEST3AEvent event) {
	    LOGGER.info("handling CreateExcIEEEST3AEvent - " + event );
	    ExcIEEEST3A entity = new ExcIEEEST3A();
        entity.setExcIEEEST3AId( event.getExcIEEEST3AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKm( event.getKm() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setThetap( event.getThetap() );
        entity.setTm( event.getTm() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVmmax( event.getVmmax() );
        entity.setVmmin( event.getVmmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXl( event.getXl() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST3A( entity );
    }

    /*
     * @param	event UpdateExcIEEEST3AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST3AEvent.class )
    public void handle( UpdateExcIEEEST3AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST3AEvent - " + event );
    	
	    ExcIEEEST3A entity = new ExcIEEEST3A();
        entity.setExcIEEEST3AId( event.getExcIEEEST3AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKm( event.getKm() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setThetap( event.getThetap() );
        entity.setTm( event.getTm() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVmmax( event.getVmmax() );
        entity.setVmmin( event.getVmmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXl( event.getXl() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST3A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST3AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST3AEvent.class )
    public void handle( DeleteExcIEEEST3AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST3A entity = delete( event.getExcIEEEST3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST3A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST3A via an ExcIEEEST3APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST3A handle( FindExcIEEEST3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST3As
     *
     * @param	query	FindAllExcIEEEST3AQuery 
     * @return 	List<ExcIEEEST3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST3A> handle( FindAllExcIEEEST3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST3A
	 */
	protected void emitFindExcIEEEST3A( ExcIEEEST3A entity ) {
		LOGGER.info("handling emitFindExcIEEEST3A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST3AQuery.class,
	                            query -> query.getFilter().getExcIEEEST3AId().equals(entity.getExcIEEEST3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST3A
	 * 
	 * @param		entity	ExcIEEEST3A
	 */
	protected void emitFindAllExcIEEEST3A( ExcIEEEST3A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST3A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST3AProjector.class.getName());

}
