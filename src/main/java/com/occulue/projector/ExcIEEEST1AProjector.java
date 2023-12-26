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
 * Projector for ExcIEEEST1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST1A")
@Component("excIEEEST1A-projector")
public class ExcIEEEST1AProjector extends ExcIEEEST1AEntityProjector {
		
	// core constructor
	public ExcIEEEST1AProjector(ExcIEEEST1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST1AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST1AEvent.class )
    public void handle( CreateExcIEEEST1AEvent event) {
	    LOGGER.info("handling CreateExcIEEEST1AEvent - " + event );
	    ExcIEEEST1A entity = new ExcIEEEST1A();
        entity.setExcIEEEST1AId( event.getExcIEEEST1AId() );
        entity.setIlr( event.getIlr() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKf( event.getKf() );
        entity.setKlr( event.getKlr() );
        entity.setPssin( event.getPssin() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTb1( event.getTb1() );
        entity.setTc( event.getTc() );
        entity.setTc1( event.getTc1() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST1A( entity );
    }

    /*
     * @param	event UpdateExcIEEEST1AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST1AEvent.class )
    public void handle( UpdateExcIEEEST1AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST1AEvent - " + event );
    	
	    ExcIEEEST1A entity = new ExcIEEEST1A();
        entity.setExcIEEEST1AId( event.getExcIEEEST1AId() );
        entity.setIlr( event.getIlr() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKf( event.getKf() );
        entity.setKlr( event.getKlr() );
        entity.setPssin( event.getPssin() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTb1( event.getTb1() );
        entity.setTc( event.getTc() );
        entity.setTc1( event.getTc1() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST1A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST1AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST1AEvent.class )
    public void handle( DeleteExcIEEEST1AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST1A entity = delete( event.getExcIEEEST1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST1A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST1A via an ExcIEEEST1APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST1A handle( FindExcIEEEST1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST1As
     *
     * @param	query	FindAllExcIEEEST1AQuery 
     * @return 	List<ExcIEEEST1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST1A> handle( FindAllExcIEEEST1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST1A
	 */
	protected void emitFindExcIEEEST1A( ExcIEEEST1A entity ) {
		LOGGER.info("handling emitFindExcIEEEST1A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST1AQuery.class,
	                            query -> query.getFilter().getExcIEEEST1AId().equals(entity.getExcIEEEST1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST1A
	 * 
	 * @param		entity	ExcIEEEST1A
	 */
	protected void emitFindAllExcIEEEST1A( ExcIEEEST1A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST1A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST1AProjector.class.getName());

}
