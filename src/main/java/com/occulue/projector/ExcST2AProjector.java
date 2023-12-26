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
 * Projector for ExcST2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcST2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST2A")
@Component("excST2A-projector")
public class ExcST2AProjector extends ExcST2AEntityProjector {
		
	// core constructor
	public ExcST2AProjector(ExcST2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST2AEvent
     */
    @EventHandler( payloadType=CreateExcST2AEvent.class )
    public void handle( CreateExcST2AEvent event) {
	    LOGGER.info("handling CreateExcST2AEvent - " + event );
	    ExcST2A entity = new ExcST2A();
        entity.setExcST2AId( event.getExcST2AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
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
        emitFindAllExcST2A( entity );
    }

    /*
     * @param	event UpdateExcST2AEvent
     */
    @EventHandler( payloadType=UpdateExcST2AEvent.class )
    public void handle( UpdateExcST2AEvent event) {
    	LOGGER.info("handling UpdateExcST2AEvent - " + event );
    	
	    ExcST2A entity = new ExcST2A();
        entity.setExcST2AId( event.getExcST2AId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
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
        emitFindExcST2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST2A( entity );        
    }
    
    /*
     * @param	event DeleteExcST2AEvent
     */
    @EventHandler( payloadType=DeleteExcST2AEvent.class )
    public void handle( DeleteExcST2AEvent event) {
    	LOGGER.info("handling DeleteExcST2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST2A entity = delete( event.getExcST2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST2A( entity );

    }    




    /**
     * Method to retrieve the ExcST2A via an ExcST2APrimaryKey.
     * @param 	id Long
     * @return 	ExcST2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST2A handle( FindExcST2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST2As
     *
     * @param	query	FindAllExcST2AQuery 
     * @return 	List<ExcST2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST2A> handle( FindAllExcST2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST2A
	 */
	protected void emitFindExcST2A( ExcST2A entity ) {
		LOGGER.info("handling emitFindExcST2A" );
		
	    queryUpdateEmitter.emit(FindExcST2AQuery.class,
	                            query -> query.getFilter().getExcST2AId().equals(entity.getExcST2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST2A
	 * 
	 * @param		entity	ExcST2A
	 */
	protected void emitFindAllExcST2A( ExcST2A entity ) {
		LOGGER.info("handling emitFindAllExcST2A" );
		
	    queryUpdateEmitter.emit(FindAllExcST2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST2AProjector.class.getName());

}
