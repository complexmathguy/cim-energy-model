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
 * Projector for ExcIEEEAC7B as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEAC7B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEAC7BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEAC7B")
@Component("excIEEEAC7B-projector")
public class ExcIEEEAC7BProjector extends ExcIEEEAC7BEntityProjector {
		
	// core constructor
	public ExcIEEEAC7BProjector(ExcIEEEAC7BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEAC7BEvent
     */
    @EventHandler( payloadType=CreateExcIEEEAC7BEvent.class )
    public void handle( CreateExcIEEEAC7BEvent event) {
	    LOGGER.info("handling CreateExcIEEEAC7BEvent - " + event );
	    ExcIEEEAC7B entity = new ExcIEEEAC7B();
        entity.setExcIEEEAC7BId( event.getExcIEEEAC7BId() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKf3( event.getKf3() );
        entity.setKia( event.getKia() );
        entity.setKir( event.getKir() );
        entity.setKl( event.getKl() );
        entity.setKp( event.getKp() );
        entity.setKpa( event.getKpa() );
        entity.setKpr( event.getKpr() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
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
        emitFindAllExcIEEEAC7B( entity );
    }

    /*
     * @param	event UpdateExcIEEEAC7BEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEAC7BEvent.class )
    public void handle( UpdateExcIEEEAC7BEvent event) {
    	LOGGER.info("handling UpdateExcIEEEAC7BEvent - " + event );
    	
	    ExcIEEEAC7B entity = new ExcIEEEAC7B();
        entity.setExcIEEEAC7BId( event.getExcIEEEAC7BId() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKf1( event.getKf1() );
        entity.setKf2( event.getKf2() );
        entity.setKf3( event.getKf3() );
        entity.setKia( event.getKia() );
        entity.setKir( event.getKir() );
        entity.setKl( event.getKl() );
        entity.setKp( event.getKp() );
        entity.setKpa( event.getKpa() );
        entity.setKpr( event.getKpr() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
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
        emitFindExcIEEEAC7B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC7B( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEAC7BEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEAC7BEvent.class )
    public void handle( DeleteExcIEEEAC7BEvent event) {
    	LOGGER.info("handling DeleteExcIEEEAC7BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEAC7B entity = delete( event.getExcIEEEAC7BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEAC7B( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEAC7B via an ExcIEEEAC7BPrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEAC7B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEAC7B handle( FindExcIEEEAC7BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEAC7BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEAC7Bs
     *
     * @param	query	FindAllExcIEEEAC7BQuery 
     * @return 	List<ExcIEEEAC7B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEAC7B> handle( FindAllExcIEEEAC7BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEAC7B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEAC7B
	 */
	protected void emitFindExcIEEEAC7B( ExcIEEEAC7B entity ) {
		LOGGER.info("handling emitFindExcIEEEAC7B" );
		
	    queryUpdateEmitter.emit(FindExcIEEEAC7BQuery.class,
	                            query -> query.getFilter().getExcIEEEAC7BId().equals(entity.getExcIEEEAC7BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEAC7B
	 * 
	 * @param		entity	ExcIEEEAC7B
	 */
	protected void emitFindAllExcIEEEAC7B( ExcIEEEAC7B entity ) {
		LOGGER.info("handling emitFindAllExcIEEEAC7B" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEAC7BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEAC7BProjector.class.getName());

}
