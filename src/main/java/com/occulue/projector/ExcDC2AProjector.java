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
 * Projector for ExcDC2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcDC2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcDC2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excDC2A")
@Component("excDC2A-projector")
public class ExcDC2AProjector extends ExcDC2AEntityProjector {
		
	// core constructor
	public ExcDC2AProjector(ExcDC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcDC2AEvent
     */
    @EventHandler( payloadType=CreateExcDC2AEvent.class )
    public void handle( CreateExcDC2AEvent event) {
	    LOGGER.info("handling CreateExcDC2AEvent - " + event );
	    ExcDC2A entity = new ExcDC2A();
        entity.setExcDC2AId( event.getExcDC2AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
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
        entity.setTf1( event.getTf1() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setVtlim( event.getVtlim() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC2A( entity );
    }

    /*
     * @param	event UpdateExcDC2AEvent
     */
    @EventHandler( payloadType=UpdateExcDC2AEvent.class )
    public void handle( UpdateExcDC2AEvent event) {
    	LOGGER.info("handling UpdateExcDC2AEvent - " + event );
    	
	    ExcDC2A entity = new ExcDC2A();
        entity.setExcDC2AId( event.getExcDC2AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
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
        entity.setTf1( event.getTf1() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setVtlim( event.getVtlim() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcDC2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC2A( entity );        
    }
    
    /*
     * @param	event DeleteExcDC2AEvent
     */
    @EventHandler( payloadType=DeleteExcDC2AEvent.class )
    public void handle( DeleteExcDC2AEvent event) {
    	LOGGER.info("handling DeleteExcDC2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcDC2A entity = delete( event.getExcDC2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC2A( entity );

    }    




    /**
     * Method to retrieve the ExcDC2A via an ExcDC2APrimaryKey.
     * @param 	id Long
     * @return 	ExcDC2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcDC2A handle( FindExcDC2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcDC2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcDC2As
     *
     * @param	query	FindAllExcDC2AQuery 
     * @return 	List<ExcDC2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcDC2A> handle( FindAllExcDC2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcDC2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcDC2A
	 */
	protected void emitFindExcDC2A( ExcDC2A entity ) {
		LOGGER.info("handling emitFindExcDC2A" );
		
	    queryUpdateEmitter.emit(FindExcDC2AQuery.class,
	                            query -> query.getFilter().getExcDC2AId().equals(entity.getExcDC2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcDC2A
	 * 
	 * @param		entity	ExcDC2A
	 */
	protected void emitFindAllExcDC2A( ExcDC2A entity ) {
		LOGGER.info("handling emitFindAllExcDC2A" );
		
	    queryUpdateEmitter.emit(FindAllExcDC2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcDC2AProjector.class.getName());

}
