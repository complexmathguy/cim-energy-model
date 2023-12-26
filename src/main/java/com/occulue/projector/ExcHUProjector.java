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
 * Projector for ExcHU as outlined for the CQRS pattern.  All event handling and query handling related to ExcHU are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcHUAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excHU")
@Component("excHU-projector")
public class ExcHUProjector extends ExcHUEntityProjector {
		
	// core constructor
	public ExcHUProjector(ExcHURepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcHUEvent
     */
    @EventHandler( payloadType=CreateExcHUEvent.class )
    public void handle( CreateExcHUEvent event) {
	    LOGGER.info("handling CreateExcHUEvent - " + event );
	    ExcHU entity = new ExcHU();
        entity.setExcHUId( event.getExcHUId() );
        entity.setAe( event.getAe() );
        entity.setAi( event.getAi() );
        entity.setAtr( event.getAtr() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setImax( event.getImax() );
        entity.setImin( event.getImin() );
        entity.setKe( event.getKe() );
        entity.setKi( event.getKi() );
        entity.setTe( event.getTe() );
        entity.setTi( event.getTi() );
        entity.setTr( event.getTr() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcHU( entity );
    }

    /*
     * @param	event UpdateExcHUEvent
     */
    @EventHandler( payloadType=UpdateExcHUEvent.class )
    public void handle( UpdateExcHUEvent event) {
    	LOGGER.info("handling UpdateExcHUEvent - " + event );
    	
	    ExcHU entity = new ExcHU();
        entity.setExcHUId( event.getExcHUId() );
        entity.setAe( event.getAe() );
        entity.setAi( event.getAi() );
        entity.setAtr( event.getAtr() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setImax( event.getImax() );
        entity.setImin( event.getImin() );
        entity.setKe( event.getKe() );
        entity.setKi( event.getKi() );
        entity.setTe( event.getTe() );
        entity.setTi( event.getTi() );
        entity.setTr( event.getTr() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcHU( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcHU( entity );        
    }
    
    /*
     * @param	event DeleteExcHUEvent
     */
    @EventHandler( payloadType=DeleteExcHUEvent.class )
    public void handle( DeleteExcHUEvent event) {
    	LOGGER.info("handling DeleteExcHUEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcHU entity = delete( event.getExcHUId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcHU( entity );

    }    




    /**
     * Method to retrieve the ExcHU via an ExcHUPrimaryKey.
     * @param 	id Long
     * @return 	ExcHU
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcHU handle( FindExcHUQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcHUId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcHUs
     *
     * @param	query	FindAllExcHUQuery 
     * @return 	List<ExcHU> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcHU> handle( FindAllExcHUQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcHU, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcHU
	 */
	protected void emitFindExcHU( ExcHU entity ) {
		LOGGER.info("handling emitFindExcHU" );
		
	    queryUpdateEmitter.emit(FindExcHUQuery.class,
	                            query -> query.getFilter().getExcHUId().equals(entity.getExcHUId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcHU
	 * 
	 * @param		entity	ExcHU
	 */
	protected void emitFindAllExcHU( ExcHU entity ) {
		LOGGER.info("handling emitFindAllExcHU" );
		
	    queryUpdateEmitter.emit(FindAllExcHUQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcHUProjector.class.getName());

}
