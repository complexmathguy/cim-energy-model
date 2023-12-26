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
 * Projector for ExcDC3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcDC3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcDC3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excDC3A")
@Component("excDC3A-projector")
public class ExcDC3AProjector extends ExcDC3AEntityProjector {
		
	// core constructor
	public ExcDC3AProjector(ExcDC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcDC3AEvent
     */
    @EventHandler( payloadType=CreateExcDC3AEvent.class )
    public void handle( CreateExcDC3AEvent event) {
	    LOGGER.info("handling CreateExcDC3AEvent - " + event );
	    ExcDC3A entity = new ExcDC3A();
        entity.setExcDC3AId( event.getExcDC3AId() );
        entity.setEdfmax( event.getEdfmax() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfdlim( event.getEfdlim() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setExclim( event.getExclim() );
        entity.setKe( event.getKe() );
        entity.setKr( event.getKr() );
        entity.setKs( event.getKs() );
        entity.setKv( event.getKv() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTe( event.getTe() );
        entity.setTrh( event.getTrh() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A( entity );
    }

    /*
     * @param	event UpdateExcDC3AEvent
     */
    @EventHandler( payloadType=UpdateExcDC3AEvent.class )
    public void handle( UpdateExcDC3AEvent event) {
    	LOGGER.info("handling UpdateExcDC3AEvent - " + event );
    	
	    ExcDC3A entity = new ExcDC3A();
        entity.setExcDC3AId( event.getExcDC3AId() );
        entity.setEdfmax( event.getEdfmax() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfdlim( event.getEfdlim() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setExclim( event.getExclim() );
        entity.setKe( event.getKe() );
        entity.setKr( event.getKr() );
        entity.setKs( event.getKs() );
        entity.setKv( event.getKv() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTe( event.getTe() );
        entity.setTrh( event.getTrh() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcDC3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A( entity );        
    }
    
    /*
     * @param	event DeleteExcDC3AEvent
     */
    @EventHandler( payloadType=DeleteExcDC3AEvent.class )
    public void handle( DeleteExcDC3AEvent event) {
    	LOGGER.info("handling DeleteExcDC3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcDC3A entity = delete( event.getExcDC3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A( entity );

    }    




    /**
     * Method to retrieve the ExcDC3A via an ExcDC3APrimaryKey.
     * @param 	id Long
     * @return 	ExcDC3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcDC3A handle( FindExcDC3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcDC3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcDC3As
     *
     * @param	query	FindAllExcDC3AQuery 
     * @return 	List<ExcDC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcDC3A> handle( FindAllExcDC3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcDC3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcDC3A
	 */
	protected void emitFindExcDC3A( ExcDC3A entity ) {
		LOGGER.info("handling emitFindExcDC3A" );
		
	    queryUpdateEmitter.emit(FindExcDC3AQuery.class,
	                            query -> query.getFilter().getExcDC3AId().equals(entity.getExcDC3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcDC3A
	 * 
	 * @param		entity	ExcDC3A
	 */
	protected void emitFindAllExcDC3A( ExcDC3A entity ) {
		LOGGER.info("handling emitFindAllExcDC3A" );
		
	    queryUpdateEmitter.emit(FindAllExcDC3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcDC3AProjector.class.getName());

}
