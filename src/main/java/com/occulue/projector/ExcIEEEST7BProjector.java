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
 * Projector for ExcIEEEST7B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST7B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST7BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST7B")
@Component("excIEEEST7B-projector")
public class ExcIEEEST7BProjector extends ExcIEEEST7BEntityProjector {
		
	// core constructor
	public ExcIEEEST7BProjector(ExcIEEEST7BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST7BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST7BEvent.class )
    public void handle( CreateExcIEEEST7BEvent event) {
	    LOGGER.info("handling CreateExcIEEEST7BEvent - " + event );
	    ExcIEEEST7B entity = new ExcIEEEST7B();
        entity.setExcIEEEST7BId( event.getExcIEEEST7BId() );
        entity.setKh( event.getKh() );
        entity.setKia( event.getKia() );
        entity.setKl( event.getKl() );
        entity.setKpa( event.getKpa() );
        entity.setOelin( event.getOelin() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTf( event.getTf() );
        entity.setTg( event.getTg() );
        entity.setTia( event.getTia() );
        entity.setUelin( event.getUelin() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST7B( entity );
    }

    /*
     * @param	event UpdateExcIEEEST7BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST7BEvent.class )
    public void handle( UpdateExcIEEEST7BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST7BEvent - " + event );
    	
	    ExcIEEEST7B entity = new ExcIEEEST7B();
        entity.setExcIEEEST7BId( event.getExcIEEEST7BId() );
        entity.setKh( event.getKh() );
        entity.setKia( event.getKia() );
        entity.setKl( event.getKl() );
        entity.setKpa( event.getKpa() );
        entity.setOelin( event.getOelin() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTf( event.getTf() );
        entity.setTg( event.getTg() );
        entity.setTia( event.getTia() );
        entity.setUelin( event.getUelin() );
        entity.setVmax( event.getVmax() );
        entity.setVmin( event.getVmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST7B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST7B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST7BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST7BEvent.class )
    public void handle( DeleteExcIEEEST7BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST7BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST7B entity = delete( event.getExcIEEEST7BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST7B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST7B via an ExcIEEEST7BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST7B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST7B handle( FindExcIEEEST7BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST7BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST7Bs
     *
     * @param	query	FindAllExcIEEEST7BQuery 
     * @return 	List<ExcIEEEST7B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST7B> handle( FindAllExcIEEEST7BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST7B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST7B
	 */
	protected void emitFindExcIEEEST7B( ExcIEEEST7B entity ) {
		LOGGER.info("handling emitFindExcIEEEST7B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST7BQuery.class,
	                            query -> query.getFilter().getExcIEEEST7BId().equals(entity.getExcIEEEST7BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST7B
	 * 
	 * @param		entity	ExcIEEEST7B
	 */
	protected void emitFindAllExcIEEEST7B( ExcIEEEST7B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST7B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST7BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST7BProjector.class.getName());

}
