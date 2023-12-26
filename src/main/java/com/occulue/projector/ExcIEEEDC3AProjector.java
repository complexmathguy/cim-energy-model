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
 * Projector for ExcIEEEDC3A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEDC3A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEDC3AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEDC3A")
@Component("excIEEEDC3A-projector")
public class ExcIEEEDC3AProjector extends ExcIEEEDC3AEntityProjector {
		
	// core constructor
	public ExcIEEEDC3AProjector(ExcIEEEDC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEDC3AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEDC3AEvent.class )
    public void handle( CreateExcIEEEDC3AEvent event) {
	    LOGGER.info("handling CreateExcIEEEDC3AEvent - " + event );
	    ExcIEEEDC3A entity = new ExcIEEEDC3A();
        entity.setExcIEEEDC3AId( event.getExcIEEEDC3AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setExclim( event.getExclim() );
        entity.setKe( event.getKe() );
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
        emitFindAllExcIEEEDC3A( entity );
    }

    /*
     * @param	event UpdateExcIEEEDC3AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEDC3AEvent.class )
    public void handle( UpdateExcIEEEDC3AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEDC3AEvent - " + event );
    	
	    ExcIEEEDC3A entity = new ExcIEEEDC3A();
        entity.setExcIEEEDC3AId( event.getExcIEEEDC3AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setExclim( event.getExclim() );
        entity.setKe( event.getKe() );
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
        emitFindExcIEEEDC3A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC3A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEDC3AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEDC3AEvent.class )
    public void handle( DeleteExcIEEEDC3AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEDC3AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEDC3A entity = delete( event.getExcIEEEDC3AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC3A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEDC3A via an ExcIEEEDC3APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEDC3A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEDC3A handle( FindExcIEEEDC3AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEDC3AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC3As
     *
     * @param	query	FindAllExcIEEEDC3AQuery 
     * @return 	List<ExcIEEEDC3A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEDC3A> handle( FindAllExcIEEEDC3AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEDC3A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEDC3A
	 */
	protected void emitFindExcIEEEDC3A( ExcIEEEDC3A entity ) {
		LOGGER.info("handling emitFindExcIEEEDC3A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEDC3AQuery.class,
	                            query -> query.getFilter().getExcIEEEDC3AId().equals(entity.getExcIEEEDC3AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEDC3A
	 * 
	 * @param		entity	ExcIEEEDC3A
	 */
	protected void emitFindAllExcIEEEDC3A( ExcIEEEDC3A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEDC3A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEDC3AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC3AProjector.class.getName());

}
