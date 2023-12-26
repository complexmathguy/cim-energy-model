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
 * Projector for ExcST7B as outlined for the CQRS pattern.  All event handling and query handling related to ExcST7B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST7BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST7B")
@Component("excST7B-projector")
public class ExcST7BProjector extends ExcST7BEntityProjector {
		
	// core constructor
	public ExcST7BProjector(ExcST7BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST7BEvent
     */
    @EventHandler( payloadType=CreateExcST7BEvent.class )
    public void handle( CreateExcST7BEvent event) {
	    LOGGER.info("handling CreateExcST7BEvent - " + event );
	    ExcST7B entity = new ExcST7B();
        entity.setExcST7BId( event.getExcST7BId() );
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
        entity.setTs( event.getTs() );
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
        emitFindAllExcST7B( entity );
    }

    /*
     * @param	event UpdateExcST7BEvent
     */
    @EventHandler( payloadType=UpdateExcST7BEvent.class )
    public void handle( UpdateExcST7BEvent event) {
    	LOGGER.info("handling UpdateExcST7BEvent - " + event );
    	
	    ExcST7B entity = new ExcST7B();
        entity.setExcST7BId( event.getExcST7BId() );
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
        entity.setTs( event.getTs() );
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
        emitFindExcST7B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST7B( entity );        
    }
    
    /*
     * @param	event DeleteExcST7BEvent
     */
    @EventHandler( payloadType=DeleteExcST7BEvent.class )
    public void handle( DeleteExcST7BEvent event) {
    	LOGGER.info("handling DeleteExcST7BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST7B entity = delete( event.getExcST7BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST7B( entity );

    }    




    /**
     * Method to retrieve the ExcST7B via an ExcST7BPrimaryKey.
     * @param 	id Long
     * @return 	ExcST7B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST7B handle( FindExcST7BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST7BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST7Bs
     *
     * @param	query	FindAllExcST7BQuery 
     * @return 	List<ExcST7B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST7B> handle( FindAllExcST7BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST7B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST7B
	 */
	protected void emitFindExcST7B( ExcST7B entity ) {
		LOGGER.info("handling emitFindExcST7B" );
		
	    queryUpdateEmitter.emit(FindExcST7BQuery.class,
	                            query -> query.getFilter().getExcST7BId().equals(entity.getExcST7BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST7B
	 * 
	 * @param		entity	ExcST7B
	 */
	protected void emitFindAllExcST7B( ExcST7B entity ) {
		LOGGER.info("handling emitFindAllExcST7B" );
		
	    queryUpdateEmitter.emit(FindAllExcST7BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST7BProjector.class.getName());

}
