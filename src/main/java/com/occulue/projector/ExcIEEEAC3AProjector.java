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
 * Projector for ExcIEEEAC3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC3A")
@Component("excIEEEAC3A-projector")
public class ExcIEEEAC3AProjector extends ExcIEEEAC3AEntityProjector {
		
	// core constructor
	public ExcIEEEAC3AProjector(ExcIEEEAC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC3AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC3AEvent.class )
    public void handle( CreateExcIEEEAC3AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC3AEvent - " + event );
	    ExcIEEEAC3A entity = new ExcIEEEAC3A();
        entity.setExcIEEEAC3AId( event.getExcIEEEAC3AId() );
        entity.setEfdn( event.getEfdn() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKn( event.getKn() );
        entity.setKr( event.getKr() );
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
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC3A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC3AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC3AEvent.class )
    public void handle( UpdateExcIEEEAC3AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC3AEvent - " + event );
    	
	    ExcIEEEAC3A entity = new ExcIEEEAC3A();
        entity.setExcIEEEAC3AId( event.getExcIEEEAC3AId() );
        entity.setEfdn( event.getEfdn() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKn( event.getKn() );
        entity.setKr( event.getKr() );
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
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEAC3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC3A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC3AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC3AEvent.class )
    public void handle( DeleteExcIEEEAC3AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC3A entity = delete( event.getExcIEEEAC3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC3A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC3A via an ExcIEEEAC3APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC3A handle( FindExcIEEEAC3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC3As
     *
     * @param	query	FindAllExcIEEEAC3AQuery 
     * @return 	List<ExcIEEEAC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC3A> handle( FindAllExcIEEEAC3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC3A
	 */
	protected void emitFindExcIEEEAC3A( ExcIEEEAC3A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC3A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC3AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC3AId().equals(entity.getExcIEEEAC3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC3A
	 * 
	 * @param		entity	ExcIEEEAC3A
	 */
	protected void emitFindAllExcIEEEAC3A( ExcIEEEAC3A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC3A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC3AProjector.class.getName());

}
