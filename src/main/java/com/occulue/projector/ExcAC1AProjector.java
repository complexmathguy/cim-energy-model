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
 * Projector for ExcAC1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC1A")
@Component("excAC1A-projector")
public class ExcAC1AProjector extends ExcAC1AEntityProjector {
		
	// core constructor
	public ExcAC1AProjector(ExcAC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC1AEvent
     */
    @EventHandler( payloadType=CreateExcAC1AEvent.class )
    public void handle( CreateExcAC1AEvent event) {
	    LOGGER.info("handling CreateExcAC1AEvent - " + event );
	    ExcAC1A entity = new ExcAC1A();
        entity.setExcAC1AId( event.getExcAC1AId() );
        entity.setHvlvgates( event.getHvlvgates() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKs( event.getKs() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC1A( entity );
    }

    /*
     * @param	event UpdateExcAC1AEvent
     */
    @EventHandler( payloadType=UpdateExcAC1AEvent.class )
    public void handle( UpdateExcAC1AEvent event) {
    	LOGGER.info("handling UpdateExcAC1AEvent - " + event );
    	
	    ExcAC1A entity = new ExcAC1A();
        entity.setExcAC1AId( event.getExcAC1AId() );
        entity.setHvlvgates( event.getHvlvgates() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKs( event.getKs() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC1A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC1AEvent
     */
    @EventHandler( payloadType=DeleteExcAC1AEvent.class )
    public void handle( DeleteExcAC1AEvent event) {
    	LOGGER.info("handling DeleteExcAC1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC1A entity = delete( event.getExcAC1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC1A( entity );

    }    




    /**
     * Method to retrieve the ExcAC1A via an ExcAC1APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC1A handle( FindExcAC1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC1As
     *
     * @param	query	FindAllExcAC1AQuery 
     * @return 	List<ExcAC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC1A> handle( FindAllExcAC1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC1A
	 */
	protected void emitFindExcAC1A( ExcAC1A entity ) {
		LOGGER.info("handling emitFindExcAC1A" );
		
	    queryUpdateEmitter.emit(FindExcAC1AQuery.class,
	                            query -> query.getFilter().getExcAC1AId().equals(entity.getExcAC1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC1A
	 * 
	 * @param		entity	ExcAC1A
	 */
	protected void emitFindAllExcAC1A( ExcAC1A entity ) {
		LOGGER.info("handling emitFindAllExcAC1A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC1AProjector.class.getName());

}
