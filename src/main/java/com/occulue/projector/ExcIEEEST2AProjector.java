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
 * Projector for ExcIEEEST2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST2A")
@Component("excIEEEST2A-projector")
public class ExcIEEEST2AProjector extends ExcIEEEST2AEntityProjector {
		
	// core constructor
	public ExcIEEEST2AProjector(ExcIEEEST2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST2AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST2AEvent.class )
    public void handle( CreateExcIEEEST2AEvent event) {
	    LOGGER.info("handling CreateExcIEEEST2AEvent - " + event );
	    ExcIEEEST2A entity = new ExcIEEEST2A();
        entity.setExcIEEEST2AId( event.getExcIEEEST2AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST2A( entity );
    }

    /*
     * @param	event UpdateExcIEEEST2AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST2AEvent.class )
    public void handle( UpdateExcIEEEST2AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST2AEvent - " + event );
    	
	    ExcIEEEST2A entity = new ExcIEEEST2A();
        entity.setExcIEEEST2AId( event.getExcIEEEST2AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST2A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST2AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST2AEvent.class )
    public void handle( DeleteExcIEEEST2AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST2A entity = delete( event.getExcIEEEST2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST2A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST2A via an ExcIEEEST2APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST2A handle( FindExcIEEEST2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST2As
     *
     * @param	query	FindAllExcIEEEST2AQuery 
     * @return 	List<ExcIEEEST2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST2A> handle( FindAllExcIEEEST2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST2A
	 */
	protected void emitFindExcIEEEST2A( ExcIEEEST2A entity ) {
		LOGGER.info("handling emitFindExcIEEEST2A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST2AQuery.class,
	                            query -> query.getFilter().getExcIEEEST2AId().equals(entity.getExcIEEEST2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST2A
	 * 
	 * @param		entity	ExcIEEEST2A
	 */
	protected void emitFindAllExcIEEEST2A( ExcIEEEST2A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST2A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST2AProjector.class.getName());

}
