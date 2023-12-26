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
 * Projector for ExcST6B as outlined for the CQRS pattern.  All event handling and query handling related to ExcST6B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST6BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST6B")
@Component("excST6B-projector")
public class ExcST6BProjector extends ExcST6BEntityProjector {
		
	// core constructor
	public ExcST6BProjector(ExcST6BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST6BEvent
     */
    @EventHandler( payloadType=CreateExcST6BEvent.class )
    public void handle( CreateExcST6BEvent event) {
	    LOGGER.info("handling CreateExcST6BEvent - " + event );
	    ExcST6B entity = new ExcST6B();
        entity.setExcST6BId( event.getExcST6BId() );
        entity.setIlr( event.getIlr() );
        entity.setK1( event.getK1() );
        entity.setKcl( event.getKcl() );
        entity.setKff( event.getKff() );
        entity.setKg( event.getKg() );
        entity.setKia( event.getKia() );
        entity.setKlr( event.getKlr() );
        entity.setKm( event.getKm() );
        entity.setKpa( event.getKpa() );
        entity.setKvd( event.getKvd() );
        entity.setOelin( event.getOelin() );
        entity.setTg( event.getTg() );
        entity.setTs( event.getTs() );
        entity.setTvd( event.getTvd() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVilim( event.getVilim() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVmult( event.getVmult() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXc( event.getXc() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST6B( entity );
    }

    /*
     * @param	event UpdateExcST6BEvent
     */
    @EventHandler( payloadType=UpdateExcST6BEvent.class )
    public void handle( UpdateExcST6BEvent event) {
    	LOGGER.info("handling UpdateExcST6BEvent - " + event );
    	
	    ExcST6B entity = new ExcST6B();
        entity.setExcST6BId( event.getExcST6BId() );
        entity.setIlr( event.getIlr() );
        entity.setK1( event.getK1() );
        entity.setKcl( event.getKcl() );
        entity.setKff( event.getKff() );
        entity.setKg( event.getKg() );
        entity.setKia( event.getKia() );
        entity.setKlr( event.getKlr() );
        entity.setKm( event.getKm() );
        entity.setKpa( event.getKpa() );
        entity.setKvd( event.getKvd() );
        entity.setOelin( event.getOelin() );
        entity.setTg( event.getTg() );
        entity.setTs( event.getTs() );
        entity.setTvd( event.getTvd() );
        entity.setVamax( event.getVamax() );
        entity.setVamin( event.getVamin() );
        entity.setVilim( event.getVilim() );
        entity.setVimax( event.getVimax() );
        entity.setVimin( event.getVimin() );
        entity.setVmult( event.getVmult() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
        entity.setXc( event.getXc() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcST6B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST6B( entity );        
    }
    
    /*
     * @param	event DeleteExcST6BEvent
     */
    @EventHandler( payloadType=DeleteExcST6BEvent.class )
    public void handle( DeleteExcST6BEvent event) {
    	LOGGER.info("handling DeleteExcST6BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST6B entity = delete( event.getExcST6BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST6B( entity );

    }    




    /**
     * Method to retrieve the ExcST6B via an ExcST6BPrimaryKey.
     * @param 	id Long
     * @return 	ExcST6B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST6B handle( FindExcST6BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST6BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST6Bs
     *
     * @param	query	FindAllExcST6BQuery 
     * @return 	List<ExcST6B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST6B> handle( FindAllExcST6BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST6B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST6B
	 */
	protected void emitFindExcST6B( ExcST6B entity ) {
		LOGGER.info("handling emitFindExcST6B" );
		
	    queryUpdateEmitter.emit(FindExcST6BQuery.class,
	                            query -> query.getFilter().getExcST6BId().equals(entity.getExcST6BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST6B
	 * 
	 * @param		entity	ExcST6B
	 */
	protected void emitFindAllExcST6B( ExcST6B entity ) {
		LOGGER.info("handling emitFindAllExcST6B" );
		
	    queryUpdateEmitter.emit(FindAllExcST6BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST6BProjector.class.getName());

}
