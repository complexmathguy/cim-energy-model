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
 * Projector for ExcAC5A as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC5A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC5AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC5A")
@Component("excAC5A-projector")
public class ExcAC5AProjector extends ExcAC5AEntityProjector {
		
	// core constructor
	public ExcAC5AProjector(ExcAC5ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC5AEvent
     */
    @EventHandler( payloadType=CreateExcAC5AEvent.class )
    public void handle( CreateExcAC5AEvent event) {
	    LOGGER.info("handling CreateExcAC5AEvent - " + event );
	    ExcAC5A entity = new ExcAC5A();
        entity.setExcAC5AId( event.getExcAC5AId() );
        entity.setA( event.getA() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKs( event.getKs() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setTf3( event.getTf3() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC5A( entity );
    }

    /*
     * @param	event UpdateExcAC5AEvent
     */
    @EventHandler( payloadType=UpdateExcAC5AEvent.class )
    public void handle( UpdateExcAC5AEvent event) {
    	LOGGER.info("handling UpdateExcAC5AEvent - " + event );
    	
	    ExcAC5A entity = new ExcAC5A();
        entity.setExcAC5AId( event.getExcAC5AId() );
        entity.setA( event.getA() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKs( event.getKs() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf1( event.getTf1() );
        entity.setTf2( event.getTf2() );
        entity.setTf3( event.getTf3() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC5A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC5A( entity );        
    }
    
    /*
     * @param	event DeleteExcAC5AEvent
     */
    @EventHandler( payloadType=DeleteExcAC5AEvent.class )
    public void handle( DeleteExcAC5AEvent event) {
    	LOGGER.info("handling DeleteExcAC5AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC5A entity = delete( event.getExcAC5AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC5A( entity );

    }    




    /**
     * Method to retrieve the ExcAC5A via an ExcAC5APrimaryKey.
     * @param 	id Long
     * @return 	ExcAC5A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC5A handle( FindExcAC5AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC5AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC5As
     *
     * @param	query	FindAllExcAC5AQuery 
     * @return 	List<ExcAC5A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC5A> handle( FindAllExcAC5AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC5A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC5A
	 */
	protected void emitFindExcAC5A( ExcAC5A entity ) {
		LOGGER.info("handling emitFindExcAC5A" );
		
	    queryUpdateEmitter.emit(FindExcAC5AQuery.class,
	                            query -> query.getFilter().getExcAC5AId().equals(entity.getExcAC5AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC5A
	 * 
	 * @param		entity	ExcAC5A
	 */
	protected void emitFindAllExcAC5A( ExcAC5A entity ) {
		LOGGER.info("handling emitFindAllExcAC5A" );
		
	    queryUpdateEmitter.emit(FindAllExcAC5AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC5AProjector.class.getName());

}
