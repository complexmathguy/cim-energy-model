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
 * Projector for ExcIEEEAC2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC2A")
@Component("excIEEEAC2A-projector")
public class ExcIEEEAC2AProjector extends ExcIEEEAC2AEntityProjector {
		
	// core constructor
	public ExcIEEEAC2AProjector(ExcIEEEAC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC2AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC2AEvent.class )
    public void handle( CreateExcIEEEAC2AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC2AEvent - " + event );
	    ExcIEEEAC2A entity = new ExcIEEEAC2A();
        entity.setExcIEEEAC2AId( event.getExcIEEEAC2AId() );
        entity.setKa( event.getKa() );
        entity.setKb( event.getKb() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
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
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC2A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC2AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC2AEvent.class )
    public void handle( UpdateExcIEEEAC2AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC2AEvent - " + event );
    	
	    ExcIEEEAC2A entity = new ExcIEEEAC2A();
        entity.setExcIEEEAC2AId( event.getExcIEEEAC2AId() );
        entity.setKa( event.getKa() );
        entity.setKb( event.getKb() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKh( event.getKh() );
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
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEAC2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC2A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC2AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC2AEvent.class )
    public void handle( DeleteExcIEEEAC2AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC2A entity = delete( event.getExcIEEEAC2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC2A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC2A via an ExcIEEEAC2APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC2A handle( FindExcIEEEAC2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC2As
     *
     * @param	query	FindAllExcIEEEAC2AQuery 
     * @return 	List<ExcIEEEAC2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC2A> handle( FindAllExcIEEEAC2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC2A
	 */
	protected void emitFindExcIEEEAC2A( ExcIEEEAC2A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC2A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC2AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC2AId().equals(entity.getExcIEEEAC2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC2A
	 * 
	 * @param		entity	ExcIEEEAC2A
	 */
	protected void emitFindAllExcIEEEAC2A( ExcIEEEAC2A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC2A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC2AProjector.class.getName());

}
