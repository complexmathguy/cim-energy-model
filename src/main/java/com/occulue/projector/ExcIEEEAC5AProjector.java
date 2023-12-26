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
 * Projector for ExcIEEEAC5A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC5A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC5AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC5A")
@Component("excIEEEAC5A-projector")
public class ExcIEEEAC5AProjector extends ExcIEEEAC5AEntityProjector {
		
	// core constructor
	public ExcIEEEAC5AProjector(ExcIEEEAC5ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC5AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC5AEvent.class )
    public void handle( CreateExcIEEEAC5AEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC5AEvent - " + event );
	    ExcIEEEAC5A entity = new ExcIEEEAC5A();
        entity.setExcIEEEAC5AId( event.getExcIEEEAC5AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
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
        emitFindAllExcIEEEAC5A( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC5AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC5AEvent.class )
    public void handle( UpdateExcIEEEAC5AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC5AEvent - " + event );
    	
	    ExcIEEEAC5A entity = new ExcIEEEAC5A();
        entity.setExcIEEEAC5AId( event.getExcIEEEAC5AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
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
        emitFindExcIEEEAC5A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC5A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC5AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC5AEvent.class )
    public void handle( DeleteExcIEEEAC5AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC5AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC5A entity = delete( event.getExcIEEEAC5AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC5A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC5A via an ExcIEEEAC5APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC5A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC5A handle( FindExcIEEEAC5AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC5AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC5As
     *
     * @param	query	FindAllExcIEEEAC5AQuery 
     * @return 	List<ExcIEEEAC5A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC5A> handle( FindAllExcIEEEAC5AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC5A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC5A
	 */
	protected void emitFindExcIEEEAC5A( ExcIEEEAC5A entity ) {
		LOGGER.info("handling emitFindExcIEEEAC5A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC5AQuery.class,
	                            query -> query.getFilter().getExcIEEEAC5AId().equals(entity.getExcIEEEAC5AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC5A
	 * 
	 * @param		entity	ExcIEEEAC5A
	 */
	protected void emitFindAllExcIEEEAC5A( ExcIEEEAC5A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC5A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC5AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC5AProjector.class.getName());

}
