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
 * Projector for ExcIEEEST6B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST6B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST6BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST6B")
@Component("excIEEEST6B-projector")
public class ExcIEEEST6BProjector extends ExcIEEEST6BEntityProjector {
		
	// core constructor
	public ExcIEEEST6BProjector(ExcIEEEST6BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST6BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST6BEvent.class )
    public void handle( CreateExcIEEEST6BEvent event) {
	    LOGGER.info("handling CreateExcIEEEST6BEvent - " + event );
	    ExcIEEEST6B entity = new ExcIEEEST6B();
        entity.setExcIEEEST6BId( event.getExcIEEEST6BId() );
        entity.setIlr( event.getIlr() );
        entity.setKci( event.getKci() );
        entity.setKff( event.getKff() );
        entity.setKg( event.getKg() );
        entity.setKia( event.getKia() );
        entity.setKlr( event.getKlr() );
        entity.setKm( event.getKm() );
        entity.setKpa( event.getKpa() );
        entity.setOelin( event.getOelin() );
        entity.setTg( event.getTg() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST6B( entity );
    }

    /*
     * @param	event UpdateExcIEEEST6BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST6BEvent.class )
    public void handle( UpdateExcIEEEST6BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST6BEvent - " + event );
    	
	    ExcIEEEST6B entity = new ExcIEEEST6B();
        entity.setExcIEEEST6BId( event.getExcIEEEST6BId() );
        entity.setIlr( event.getIlr() );
        entity.setKci( event.getKci() );
        entity.setKff( event.getKff() );
        entity.setKg( event.getKg() );
        entity.setKia( event.getKia() );
        entity.setKlr( event.getKlr() );
        entity.setKm( event.getKm() );
        entity.setKpa( event.getKpa() );
        entity.setOelin( event.getOelin() );
        entity.setTg( event.getTg() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST6B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST6B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST6BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST6BEvent.class )
    public void handle( DeleteExcIEEEST6BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST6BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST6B entity = delete( event.getExcIEEEST6BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST6B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST6B via an ExcIEEEST6BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST6B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST6B handle( FindExcIEEEST6BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST6BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST6Bs
     *
     * @param	query	FindAllExcIEEEST6BQuery 
     * @return 	List<ExcIEEEST6B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST6B> handle( FindAllExcIEEEST6BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST6B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST6B
	 */
	protected void emitFindExcIEEEST6B( ExcIEEEST6B entity ) {
		LOGGER.info("handling emitFindExcIEEEST6B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST6BQuery.class,
	                            query -> query.getFilter().getExcIEEEST6BId().equals(entity.getExcIEEEST6BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST6B
	 * 
	 * @param		entity	ExcIEEEST6B
	 */
	protected void emitFindAllExcIEEEST6B( ExcIEEEST6B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST6B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST6BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST6BProjector.class.getName());

}
