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
 * Projector for ExcIEEEAC8B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC8B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC8BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC8B")
@Component("excIEEEAC8B-projector")
public class ExcIEEEAC8BProjector extends ExcIEEEAC8BEntityProjector {
		
	// core constructor
	public ExcIEEEAC8BProjector(ExcIEEEAC8BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC8BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC8BEvent.class )
    public void handle( CreateExcIEEEAC8BEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC8BEvent - " + event );
	    ExcIEEEAC8B entity = new ExcIEEEAC8B();
        entity.setExcIEEEAC8BId( event.getExcIEEEAC8BId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKir( event.getKir() );
        entity.setKpr( event.getKpr() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC8B( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC8BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC8BEvent.class )
    public void handle( UpdateExcIEEEAC8BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC8BEvent - " + event );
    	
	    ExcIEEEAC8B entity = new ExcIEEEAC8B();
        entity.setExcIEEEAC8BId( event.getExcIEEEAC8BId() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKir( event.getKir() );
        entity.setKpr( event.getKpr() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEAC8B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC8B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC8BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC8BEvent.class )
    public void handle( DeleteExcIEEEAC8BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC8BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC8B entity = delete( event.getExcIEEEAC8BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC8B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC8B via an ExcIEEEAC8BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC8B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC8B handle( FindExcIEEEAC8BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC8BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC8Bs
     *
     * @param	query	FindAllExcIEEEAC8BQuery 
     * @return 	List<ExcIEEEAC8B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC8B> handle( FindAllExcIEEEAC8BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC8B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC8B
	 */
	protected void emitFindExcIEEEAC8B( ExcIEEEAC8B entity ) {
		LOGGER.info("handling emitFindExcIEEEAC8B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC8BQuery.class,
	                            query -> query.getFilter().getExcIEEEAC8BId().equals(entity.getExcIEEEAC8BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC8B
	 * 
	 * @param		entity	ExcIEEEAC8B
	 */
	protected void emitFindAllExcIEEEAC8B( ExcIEEEAC8B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC8B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC8BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC8BProjector.class.getName());

}
