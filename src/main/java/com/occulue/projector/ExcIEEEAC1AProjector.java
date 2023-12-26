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
 * Projector for ExcIEEEAC1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC1A")
@Component("excIEEEAC1A-projector")
public class ExcIEEEAC1AProjector extends ExcIEEEAC1AEntityProjector {
		
	// core constructor
	public ExcIEEEAC1AProjector(ExcIEEEAC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC1AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC1AEvent.class )
    public void handle( CreateExcIEEEAC1AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC1AEvent - " + event );
	    ExcIEEEAC1A entity = new ExcIEEEAC1A();
        entity.setExcIEEEAC1AId( event.getExcIEEEAC1AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
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
        emitFindAllExcIEEEAC1A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC1AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC1AEvent.class )
    public void handle( UpdateExcIEEEAC1AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC1AEvent - " + event );
    	
	    ExcIEEEAC1A entity = new ExcIEEEAC1A();
        entity.setExcIEEEAC1AId( event.getExcIEEEAC1AId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
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
        emitFindExcIEEEAC1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC1A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC1AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC1AEvent.class )
    public void handle( DeleteExcIEEEAC1AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC1A entity = delete( event.getExcIEEEAC1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC1A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC1A via an ExcIEEEAC1APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC1A handle( FindExcIEEEAC1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC1As
     *
     * @param	query	FindAllExcIEEEAC1AQuery 
     * @return 	List<ExcIEEEAC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC1A> handle( FindAllExcIEEEAC1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC1A
	 */
	protected void emitFindExcIEEEAC1A( ExcIEEEAC1A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC1A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC1AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC1AId().equals(entity.getExcIEEEAC1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC1A
	 * 
	 * @param		entity	ExcIEEEAC1A
	 */
	protected void emitFindAllExcIEEEAC1A( ExcIEEEAC1A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC1A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC1AProjector.class.getName());

}
