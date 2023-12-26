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
 * Projector for ExcST1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcST1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST1A")
@Component("excST1A-projector")
public class ExcST1AProjector extends ExcST1AEntityProjector {
		
	// core constructor
	public ExcST1AProjector(ExcST1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST1AEvent
     */
    @EventHandler( payloadType=CreateExcST1AEvent.class )
    public void handle( CreateExcST1AEvent event) {
	    LOGGER.info("handling CreateExcST1AEvent - " + event );
	    ExcST1A entity = new ExcST1A();
        entity.setExcST1AId( event.getExcST1AId() );
        entity.setIlr( event.getIlr() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKf( event.getKf() );
        entity.setKlr( event.getKlr() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTb1( event.getTb1() );
        entity.setTc( event.getTc() );
        entity.setTc1( event.getTc1() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXe( event.getXe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST1A( entity );
    }

    /*
     * @param	event UpdateExcST1AEvent
     */
    @EventHandler( payloadType=UpdateExcST1AEvent.class )
    public void handle( UpdateExcST1AEvent event) {
    	LOGGER.info("handling UpdateExcST1AEvent - " + event );
    	
	    ExcST1A entity = new ExcST1A();
        entity.setExcST1AId( event.getExcST1AId() );
        entity.setIlr( event.getIlr() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKf( event.getKf() );
        entity.setKlr( event.getKlr() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTb1( event.getTb1() );
        entity.setTc( event.getTc() );
        entity.setTc1( event.getTc1() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXe( event.getXe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcST1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST1A( entity );        
    }
    
    /*
     * @param	event DeleteExcST1AEvent
     */
    @EventHandler( payloadType=DeleteExcST1AEvent.class )
    public void handle( DeleteExcST1AEvent event) {
    	LOGGER.info("handling DeleteExcST1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST1A entity = delete( event.getExcST1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST1A( entity );

    }    




    /**
     * Method to retrieve the ExcST1A via an ExcST1APrimaryKey.
     * @param 	id Long
     * @return 	ExcST1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST1A handle( FindExcST1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST1As
     *
     * @param	query	FindAllExcST1AQuery 
     * @return 	List<ExcST1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST1A> handle( FindAllExcST1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST1A
	 */
	protected void emitFindExcST1A( ExcST1A entity ) {
		LOGGER.info("handling emitFindExcST1A" );
		
	    queryUpdateEmitter.emit(FindExcST1AQuery.class,
	                            query -> query.getFilter().getExcST1AId().equals(entity.getExcST1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST1A
	 * 
	 * @param		entity	ExcST1A
	 */
	protected void emitFindAllExcST1A( ExcST1A entity ) {
		LOGGER.info("handling emitFindAllExcST1A" );
		
	    queryUpdateEmitter.emit(FindAllExcST1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST1AProjector.class.getName());

}
