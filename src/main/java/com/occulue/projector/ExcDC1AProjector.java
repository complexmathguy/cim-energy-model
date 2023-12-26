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
 * Projector for ExcDC1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcDC1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcDC1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excDC1A")
@Component("excDC1A-projector")
public class ExcDC1AProjector extends ExcDC1AEntityProjector {
		
	// core constructor
	public ExcDC1AProjector(ExcDC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcDC1AEvent
     */
    @EventHandler( payloadType=CreateExcDC1AEvent.class )
    public void handle( CreateExcDC1AEvent event) {
	    LOGGER.info("handling CreateExcDC1AEvent - " + event );
	    ExcDC1A entity = new ExcDC1A();
        entity.setExcDC1AId( event.getExcDC1AId() );
        entity.setEdfmax( event.getEdfmax() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setExclim( event.getExclim() );
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
        emitFindAllExcDC1A( entity );
    }

    /*
     * @param	event UpdateExcDC1AEvent
     */
    @EventHandler( payloadType=UpdateExcDC1AEvent.class )
    public void handle( UpdateExcDC1AEvent event) {
    	LOGGER.info("handling UpdateExcDC1AEvent - " + event );
    	
	    ExcDC1A entity = new ExcDC1A();
        entity.setExcDC1AId( event.getExcDC1AId() );
        entity.setEdfmax( event.getEdfmax() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setExclim( event.getExclim() );
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
        emitFindExcDC1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC1A( entity );        
    }
    
    /*
     * @param	event DeleteExcDC1AEvent
     */
    @EventHandler( payloadType=DeleteExcDC1AEvent.class )
    public void handle( DeleteExcDC1AEvent event) {
    	LOGGER.info("handling DeleteExcDC1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcDC1A entity = delete( event.getExcDC1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC1A( entity );

    }    




    /**
     * Method to retrieve the ExcDC1A via an ExcDC1APrimaryKey.
     * @param 	id Long
     * @return 	ExcDC1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcDC1A handle( FindExcDC1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcDC1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcDC1As
     *
     * @param	query	FindAllExcDC1AQuery 
     * @return 	List<ExcDC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcDC1A> handle( FindAllExcDC1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcDC1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcDC1A
	 */
	protected void emitFindExcDC1A( ExcDC1A entity ) {
		LOGGER.info("handling emitFindExcDC1A" );
		
	    queryUpdateEmitter.emit(FindExcDC1AQuery.class,
	                            query -> query.getFilter().getExcDC1AId().equals(entity.getExcDC1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcDC1A
	 * 
	 * @param		entity	ExcDC1A
	 */
	protected void emitFindAllExcDC1A( ExcDC1A entity ) {
		LOGGER.info("handling emitFindAllExcDC1A" );
		
	    queryUpdateEmitter.emit(FindAllExcDC1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcDC1AProjector.class.getName());

}
