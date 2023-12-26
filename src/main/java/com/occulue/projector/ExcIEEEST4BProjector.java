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
 * Projector for ExcIEEEST4B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEST4B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEST4BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEST4B")
@Component("excIEEEST4B-projector")
public class ExcIEEEST4BProjector extends ExcIEEEST4BEntityProjector {
		
	// core constructor
	public ExcIEEEST4BProjector(ExcIEEEST4BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEST4BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEST4BEvent.class )
    public void handle( CreateExcIEEEST4BEvent event) {
	    LOGGER.info("handling CreateExcIEEEST4BEvent - " + event );
	    ExcIEEEST4B entity = new ExcIEEEST4B();
        entity.setExcIEEEST4BId( event.getExcIEEEST4BId() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKim( event.getKim() );
        entity.setKir( event.getKir() );
        entity.setKp( event.getKp() );
        entity.setKpm( event.getKpm() );
        entity.setKpr( event.getKpr() );
        entity.setTa( event.getTa() );
        entity.setThetap( event.getThetap() );
        entity.setVbmax( event.getVbmax() );
        entity.setVmmax( event.getVmmax() );
        entity.setVmmin( event.getVmmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXl( event.getXl() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST4B( entity );
    }

    /*
     * @param	event UpdateExcIEEEST4BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEST4BEvent.class )
    public void handle( UpdateExcIEEEST4BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEST4BEvent - " + event );
    	
	    ExcIEEEST4B entity = new ExcIEEEST4B();
        entity.setExcIEEEST4BId( event.getExcIEEEST4BId() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKim( event.getKim() );
        entity.setKir( event.getKir() );
        entity.setKp( event.getKp() );
        entity.setKpm( event.getKpm() );
        entity.setKpr( event.getKpr() );
        entity.setTa( event.getTa() );
        entity.setThetap( event.getThetap() );
        entity.setVbmax( event.getVbmax() );
        entity.setVmmax( event.getVmmax() );
        entity.setVmmin( event.getVmmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXl( event.getXl() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEST4B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST4B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEST4BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEST4BEvent.class )
    public void handle( DeleteExcIEEEST4BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEST4BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEST4B entity = delete( event.getExcIEEEST4BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEST4B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEST4B via an ExcIEEEST4BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEST4B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEST4B handle( FindExcIEEEST4BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEST4BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEST4Bs
     *
     * @param	query	FindAllExcIEEEST4BQuery 
     * @return 	List<ExcIEEEST4B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEST4B> handle( FindAllExcIEEEST4BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEST4B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEST4B
	 */
	protected void emitFindExcIEEEST4B( ExcIEEEST4B entity ) {
		LOGGER.info("handling emitFindExcIEEEST4B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEST4BQuery.class,
	                            query -> query.getFilter().getExcIEEEST4BId().equals(entity.getExcIEEEST4BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEST4B
	 * 
	 * @param		entity	ExcIEEEST4B
	 */
	protected void emitFindAllExcIEEEST4B( ExcIEEEST4B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEST4B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEST4BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEST4BProjector.class.getName());

}
