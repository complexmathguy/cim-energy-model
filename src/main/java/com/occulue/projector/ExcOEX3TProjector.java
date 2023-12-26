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
 * Projector for ExcOEX3T as outlined for the CQRS pattern.  All event handling and query handling related to ExcOEX3T are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcOEX3TAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excOEX3T")
@Component("excOEX3T-projector")
public class ExcOEX3TProjector extends ExcOEX3TEntityProjector {
		
	// core constructor
	public ExcOEX3TProjector(ExcOEX3TRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcOEX3TEvent
     */
    @EventHandler( payloadType=CreateExcOEX3TEvent.class )
    public void handle( CreateExcOEX3TEvent event) {
	    LOGGER.info("handling CreateExcOEX3TEvent - " + event );
	    ExcOEX3T entity = new ExcOEX3T();
        entity.setExcOEX3TId( event.getExcOEX3TId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSee1( event.getSee1() );
        entity.setSee2( event.getSee2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcOEX3T( entity );
    }

    /*
     * @param	event UpdateExcOEX3TEvent
     */
    @EventHandler( payloadType=UpdateExcOEX3TEvent.class )
    public void handle( UpdateExcOEX3TEvent event) {
    	LOGGER.info("handling UpdateExcOEX3TEvent - " + event );
    	
	    ExcOEX3T entity = new ExcOEX3T();
        entity.setExcOEX3TId( event.getExcOEX3TId() );
        entity.setE1( event.getE1() );
        entity.setE2( event.getE2() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSee1( event.getSee1() );
        entity.setSee2( event.getSee2() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setT4( event.getT4() );
        entity.setT5( event.getT5() );
        entity.setT6( event.getT6() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcOEX3T( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcOEX3T( entity );        
    }
    
    /*
     * @param	event DeleteExcOEX3TEvent
     */
    @EventHandler( payloadType=DeleteExcOEX3TEvent.class )
    public void handle( DeleteExcOEX3TEvent event) {
    	LOGGER.info("handling DeleteExcOEX3TEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcOEX3T entity = delete( event.getExcOEX3TId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcOEX3T( entity );

    }    




    /**
     * Method to retrieve the ExcOEX3T via an ExcOEX3TPrimaryKey.
     * @param 	id Long
     * @return 	ExcOEX3T
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcOEX3T handle( FindExcOEX3TQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcOEX3TId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcOEX3Ts
     *
     * @param	query	FindAllExcOEX3TQuery 
     * @return 	List<ExcOEX3T> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcOEX3T> handle( FindAllExcOEX3TQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcOEX3T, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcOEX3T
	 */
	protected void emitFindExcOEX3T( ExcOEX3T entity ) {
		LOGGER.info("handling emitFindExcOEX3T" );
		
	    queryUpdateEmitter.emit(FindExcOEX3TQuery.class,
	                            query -> query.getFilter().getExcOEX3TId().equals(entity.getExcOEX3TId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcOEX3T
	 * 
	 * @param		entity	ExcOEX3T
	 */
	protected void emitFindAllExcOEX3T( ExcOEX3T entity ) {
		LOGGER.info("handling emitFindAllExcOEX3T" );
		
	    queryUpdateEmitter.emit(FindAllExcOEX3TQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcOEX3TProjector.class.getName());

}
