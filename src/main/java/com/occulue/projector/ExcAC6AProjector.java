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
 * Projector for ExcAC6A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC6A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC6AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC6A")
@Component("excAC6A-projector")
public class ExcAC6AProjector extends ExcAC6AEntityProjector {
		
	// core constructor
	public ExcAC6AProjector(ExcAC6ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC6AEvent
     */
    @EventHandler( payloadType=CreateExcAC6AEvent.class )
    public void handle( CreateExcAC6AEvent event) {
	    LOGGER.info("handling CreateExcAC6AEvent - " + event );
	    ExcAC6A entity = new ExcAC6A();
        entity.setExcAC6AId( event.getExcAC6AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKh( event.getKh() );
        entity.setKs( event.getKs() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTh( event.getTh() );
        entity.setTj( event.getTj() );
        entity.setTk( event.getTk() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVfelim( event.getVfelim() );
        entity.setVhmax( event.getVhmax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC6A( entity );
    }

    /*
     * @param	event UpdateExcAC6AEvent
     */
    @EventHandler( payloadType=UpdateExcAC6AEvent.class )
    public void handle( UpdateExcAC6AEvent event) {
    	LOGGER.info("handling UpdateExcAC6AEvent - " + event );
    	
	    ExcAC6A entity = new ExcAC6A();
        entity.setExcAC6AId( event.getExcAC6AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKh( event.getKh() );
        entity.setKs( event.getKs() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTh( event.getTh() );
        entity.setTj( event.getTj() );
        entity.setTk( event.getTk() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVfelim( event.getVfelim() );
        entity.setVhmax( event.getVhmax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC6A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC6A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC6AEvent
     */
    @EventHandler( payloadType=DeleteExcAC6AEvent.class )
    public void handle( DeleteExcAC6AEvent event) {
    	LOGGER.info("handling DeleteExcAC6AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC6A entity = delete( event.getExcAC6AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC6A( entity );

    }    




    /**
     * Method to retrieve the ExcAC6A via an ExcAC6APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC6A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC6A handle( FindExcAC6AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC6AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC6As
     *
     * @param	query	FindAllExcAC6AQuery 
     * @return 	List<ExcAC6A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC6A> handle( FindAllExcAC6AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC6A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC6A
	 */
	protected void emitFindExcAC6A( ExcAC6A entity ) {
		LOGGER.info("handling emitFindExcAC6A" );
		
	    queryUpdateEmitter.emit(FindExcAC6AQuery.class,
	                            query -> query.getFilter().getExcAC6AId().equals(entity.getExcAC6AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC6A
	 * 
	 * @param		entity	ExcAC6A
	 */
	protected void emitFindAllExcAC6A( ExcAC6A entity ) {
		LOGGER.info("handling emitFindAllExcAC6A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC6AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC6AProjector.class.getName());

}
