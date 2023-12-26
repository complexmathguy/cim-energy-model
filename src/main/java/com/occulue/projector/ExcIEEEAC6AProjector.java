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
 * Projector for ExcIEEEAC6A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC6A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC6AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC6A")
@Component("excIEEEAC6A-projector")
public class ExcIEEEAC6AProjector extends ExcIEEEAC6AEntityProjector {
		
	// core constructor
	public ExcIEEEAC6AProjector(ExcIEEEAC6ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC6AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC6AEvent.class )
    public void handle( CreateExcIEEEAC6AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC6AEvent - " + event );
	    ExcIEEEAC6A entity = new ExcIEEEAC6A();
        entity.setExcIEEEAC6AId( event.getExcIEEEAC6AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKh( event.getKh() );
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
        emitFindAllExcIEEEAC6A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC6AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC6AEvent.class )
    public void handle( UpdateExcIEEEAC6AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC6AEvent - " + event );
    	
	    ExcIEEEAC6A entity = new ExcIEEEAC6A();
        entity.setExcIEEEAC6AId( event.getExcIEEEAC6AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKh( event.getKh() );
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
        emitFindExcIEEEAC6A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC6A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC6AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC6AEvent.class )
    public void handle( DeleteExcIEEEAC6AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC6AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC6A entity = delete( event.getExcIEEEAC6AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC6A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC6A via an ExcIEEEAC6APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC6A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC6A handle( FindExcIEEEAC6AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC6AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC6As
     *
     * @param	query	FindAllExcIEEEAC6AQuery 
     * @return 	List<ExcIEEEAC6A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC6A> handle( FindAllExcIEEEAC6AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC6A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC6A
	 */
	protected void emitFindExcIEEEAC6A( ExcIEEEAC6A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC6A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC6AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC6AId().equals(entity.getExcIEEEAC6AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC6A
	 * 
	 * @param		entity	ExcIEEEAC6A
	 */
	protected void emitFindAllExcIEEEAC6A( ExcIEEEAC6A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC6A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC6AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC6AProjector.class.getName());

}
