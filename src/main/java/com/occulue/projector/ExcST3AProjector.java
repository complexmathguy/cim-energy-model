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
 * Projector for ExcST3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcST3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST3A")
@Component("excST3A-projector")
public class ExcST3AProjector extends ExcST3AEntityProjector {
		
	// core constructor
	public ExcST3AProjector(ExcST3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST3AEvent
     */
    @EventHandler( payloadType=CreateExcST3AEvent.class )
    public void handle( CreateExcST3AEvent event) {
	    LOGGER.info("handling CreateExcST3AEvent - " + event );
	    ExcST3A entity = new ExcST3A();
        entity.setExcST3AId( event.getExcST3AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKj( event.getKj() );
        entity.setKm( event.getKm() );
        entity.setKp( event.getKp() );
        entity.setKs( event.getKs() );
        entity.setKs1( event.getKs1() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setThetap( event.getThetap() );
        entity.setTm( event.getTm() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
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
        emitFindAllExcST3A( entity );
    }

    /*
     * @param	event UpdateExcST3AEvent
     */
    @EventHandler( payloadType=UpdateExcST3AEvent.class )
    public void handle( UpdateExcST3AEvent event) {
    	LOGGER.info("handling UpdateExcST3AEvent - " + event );
    	
	    ExcST3A entity = new ExcST3A();
        entity.setExcST3AId( event.getExcST3AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKj( event.getKj() );
        entity.setKm( event.getKm() );
        entity.setKp( event.getKp() );
        entity.setKs( event.getKs() );
        entity.setKs1( event.getKs1() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setThetap( event.getThetap() );
        entity.setTm( event.getTm() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
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
        emitFindExcST3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST3A( entity );        
    }
    
    /*
     * @param	event DeleteExcST3AEvent
     */
    @EventHandler( payloadType=DeleteExcST3AEvent.class )
    public void handle( DeleteExcST3AEvent event) {
    	LOGGER.info("handling DeleteExcST3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST3A entity = delete( event.getExcST3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST3A( entity );

    }    




    /**
     * Method to retrieve the ExcST3A via an ExcST3APrimaryKey.
     * @param 	id Long
     * @return 	ExcST3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST3A handle( FindExcST3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST3As
     *
     * @param	query	FindAllExcST3AQuery 
     * @return 	List<ExcST3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST3A> handle( FindAllExcST3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST3A
	 */
	protected void emitFindExcST3A( ExcST3A entity ) {
		LOGGER.info("handling emitFindExcST3A" );
		
	    queryUpdateEmitter.emit(FindExcST3AQuery.class,
	                            query -> query.getFilter().getExcST3AId().equals(entity.getExcST3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST3A
	 * 
	 * @param		entity	ExcST3A
	 */
	protected void emitFindAllExcST3A( ExcST3A entity ) {
		LOGGER.info("handling emitFindAllExcST3A" );
		
	    queryUpdateEmitter.emit(FindAllExcST3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST3AProjector.class.getName());

}
