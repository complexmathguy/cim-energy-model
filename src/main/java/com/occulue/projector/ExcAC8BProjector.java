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
 * Projector for ExcAC8B as outlined for the CQRS pattern.  All event handling and query handling related to ExcAC8B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAC8BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAC8B")
@Component("excAC8B-projector")
public class ExcAC8BProjector extends ExcAC8BEntityProjector {
		
	// core constructor
	public ExcAC8BProjector(ExcAC8BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAC8BEvent
     */
    @EventHandler( payloadType=CreateExcAC8BEvent.class )
    public void handle( CreateExcAC8BEvent event) {
	    LOGGER.info("handling CreateExcAC8BEvent - " + event );
	    ExcAC8B entity = new ExcAC8B();
        entity.setExcAC8BId( event.getExcAC8BId() );
        entity.setInlim( event.getInlim() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKir( event.getKir() );
        entity.setKpr( event.getKpr() );
        entity.setKs( event.getKs() );
        entity.setPidlim( event.getPidlim() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setTelim( event.getTelim() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVpidmax( event.getVpidmax() );
        entity.setVpidmin( event.getVpidmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setVtmult( event.getVtmult() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC8B( entity );
    }

    /*
     * @param	event UpdateExcAC8BEvent
     */
    @EventHandler( payloadType=UpdateExcAC8BEvent.class )
    public void handle( UpdateExcAC8BEvent event) {
    	LOGGER.info("handling UpdateExcAC8BEvent - " + event );
    	
	    ExcAC8B entity = new ExcAC8B();
        entity.setExcAC8BId( event.getExcAC8BId() );
        entity.setInlim( event.getInlim() );
        entity.setKa( event.getKa() );
        entity.setKc( event.getKc() );
        entity.setKd( event.getKd() );
        entity.setKdr( event.getKdr() );
        entity.setKe( event.getKe() );
        entity.setKir( event.getKir() );
        entity.setKpr( event.getKpr() );
        entity.setKs( event.getKs() );
        entity.setPidlim( event.getPidlim() );
        entity.setSeve1( event.getSeve1() );
        entity.setSeve2( event.getSeve2() );
        entity.setTa( event.getTa() );
        entity.setTdr( event.getTdr() );
        entity.setTe( event.getTe() );
        entity.setTelim( event.getTelim() );
        entity.setVe1( event.getVe1() );
        entity.setVe2( event.getVe2() );
        entity.setVemin( event.getVemin() );
        entity.setVfemax( event.getVfemax() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVpidmax( event.getVpidmax() );
        entity.setVpidmin( event.getVpidmin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setVtmult( event.getVtmult() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAC8B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC8B( entity );        
    }
    
    /*
     * @param	event DeleteExcAC8BEvent
     */
    @EventHandler( payloadType=DeleteExcAC8BEvent.class )
    public void handle( DeleteExcAC8BEvent event) {
    	LOGGER.info("handling DeleteExcAC8BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAC8B entity = delete( event.getExcAC8BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAC8B( entity );

    }    




    /**
     * Method to retrieve the ExcAC8B via an ExcAC8BPrimaryKey.
     * @param 	id Long
     * @return 	ExcAC8B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAC8B handle( FindExcAC8BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAC8BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAC8Bs
     *
     * @param	query	FindAllExcAC8BQuery 
     * @return 	List<ExcAC8B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAC8B> handle( FindAllExcAC8BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAC8B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAC8B
	 */
	protected void emitFindExcAC8B( ExcAC8B entity ) {
		LOGGER.info("handling emitFindExcAC8B" );
		
	    queryUpdateEmitter.emit(FindExcAC8BQuery.class,
	                            query -> query.getFilter().getExcAC8BId().equals(entity.getExcAC8BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAC8B
	 * 
	 * @param		entity	ExcAC8B
	 */
	protected void emitFindAllExcAC8B( ExcAC8B entity ) {
		LOGGER.info("handling emitFindAllExcAC8B" );
		
	    queryUpdateEmitter.emit(FindAllExcAC8BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAC8BProjector.class.getName());

}
