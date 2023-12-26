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
 * Projector for ExcAC3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC3A")
@Component("excAC3A-projector")
public class ExcAC3AProjector extends ExcAC3AEntityProjector {
		
	// core constructor
	public ExcAC3AProjector(ExcAC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC3AEvent
     */
    @EventHandler( payloadType=CreateExcAC3AEvent.class )
    public void handle( CreateExcAC3AEvent event) {
	    LOGGER.info("handling CreateExcAC3AEvent - " + event );
	    ExcAC3A entity = new ExcAC3A();
        entity.setExcAC3AId( event.getExcAC3AId() );
        entity.setEfdn( event.getEfdn() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKlv( event.getKlv() );
        entity.setKn( event.getKn() );
        entity.setKr( event.getKr() );
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
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVlv( event.getVlv() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC3A( entity );
    }

    /*
     * @param	event UpdateExcAC3AEvent
     */
    @EventHandler( payloadType=UpdateExcAC3AEvent.class )
    public void handle( UpdateExcAC3AEvent event) {
    	LOGGER.info("handling UpdateExcAC3AEvent - " + event );
    	
	    ExcAC3A entity = new ExcAC3A();
        entity.setExcAC3AId( event.getExcAC3AId() );
        entity.setEfdn( event.getEfdn() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKlv( event.getKlv() );
        entity.setKn( event.getKn() );
        entity.setKr( event.getKr() );
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
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVlv( event.getVlv() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC3A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC3AEvent
     */
    @EventHandler( payloadType=DeleteExcAC3AEvent.class )
    public void handle( DeleteExcAC3AEvent event) {
    	LOGGER.info("handling DeleteExcAC3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC3A entity = delete( event.getExcAC3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC3A( entity );

    }    




    /**
     * Method to retrieve the ExcAC3A via an ExcAC3APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC3A handle( FindExcAC3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC3As
     *
     * @param	query	FindAllExcAC3AQuery 
     * @return 	List<ExcAC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC3A> handle( FindAllExcAC3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC3A
	 */
	protected void emitFindExcAC3A( ExcAC3A entity ) {
		LOGGER.info("handling emitFindExcAC3A" );
		
	    queryUpdateEmitter.emit(FindExcAC3AQuery.class,
	                            query -> query.getFilter().getExcAC3AId().equals(entity.getExcAC3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC3A
	 * 
	 * @param		entity	ExcAC3A
	 */
	protected void emitFindAllExcAC3A( ExcAC3A entity ) {
		LOGGER.info("handling emitFindAllExcAC3A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC3AProjector.class.getName());

}
