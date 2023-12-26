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
 * Projector for ExcAC2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC2A")
@Component("excAC2A-projector")
public class ExcAC2AProjector extends ExcAC2AEntityProjector {
		
	// core constructor
	public ExcAC2AProjector(ExcAC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC2AEvent
     */
    @EventHandler( payloadType=CreateExcAC2AEvent.class )
    public void handle( CreateExcAC2AEvent event) {
	    LOGGER.info("handling CreateExcAC2AEvent - " + event );
	    ExcAC2A entity = new ExcAC2A();
        entity.setExcAC2AId( event.getExcAC2AId() );
        entity.setHvgate( event.getHvgate() );
        entity.setKa( event.getKa() );
        entity.setKb( event.getKb() );
        entity.setKb1( event.getKb1() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
        entity.setKl( event.getKl() );
        entity.setKl1( event.getKl1() );
        entity.setKs( event.getKs() );
        entity.setLvgate( event.getLvgate() );
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
        entity.setVfemax( event.getVfemax() );
        entity.setVlr( event.getVlr() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC2A( entity );
    }

    /*
     * @param	event UpdateExcAC2AEvent
     */
    @EventHandler( payloadType=UpdateExcAC2AEvent.class )
    public void handle( UpdateExcAC2AEvent event) {
    	LOGGER.info("handling UpdateExcAC2AEvent - " + event );
    	
	    ExcAC2A entity = new ExcAC2A();
        entity.setExcAC2AId( event.getExcAC2AId() );
        entity.setHvgate( event.getHvgate() );
        entity.setKa( event.getKa() );
        entity.setKb( event.getKb() );
        entity.setKb1( event.getKb1() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
        entity.setKl( event.getKl() );
        entity.setKl1( event.getKl1() );
        entity.setKs( event.getKs() );
        entity.setLvgate( event.getLvgate() );
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
        entity.setVfemax( event.getVfemax() );
        entity.setVlr( event.getVlr() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC2A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC2AEvent
     */
    @EventHandler( payloadType=DeleteExcAC2AEvent.class )
    public void handle( DeleteExcAC2AEvent event) {
    	LOGGER.info("handling DeleteExcAC2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC2A entity = delete( event.getExcAC2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC2A( entity );

    }    




    /**
     * Method to retrieve the ExcAC2A via an ExcAC2APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC2A handle( FindExcAC2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC2As
     *
     * @param	query	FindAllExcAC2AQuery 
     * @return 	List<ExcAC2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC2A> handle( FindAllExcAC2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC2A
	 */
	protected void emitFindExcAC2A( ExcAC2A entity ) {
		LOGGER.info("handling emitFindExcAC2A" );
		
	    queryUpdateEmitter.emit(FindExcAC2AQuery.class,
	                            query -> query.getFilter().getExcAC2AId().equals(entity.getExcAC2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC2A
	 * 
	 * @param		entity	ExcAC2A
	 */
	protected void emitFindAllExcAC2A( ExcAC2A entity ) {
		LOGGER.info("handling emitFindAllExcAC2A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC2AProjector.class.getName());

}
