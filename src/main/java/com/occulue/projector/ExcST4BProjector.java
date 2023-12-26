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
 * Projector for ExcST4B as outlined for the CQRS pattern.  All event handling and query handling related to ExcST4B are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcST4BAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excST4B")
@Component("excST4B-projector")
public class ExcST4BProjector extends ExcST4BEntityProjector {
		
	// core constructor
	public ExcST4BProjector(ExcST4BRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcST4BEvent
     */
    @EventHandler( payloadType=CreateExcST4BEvent.class )
    public void handle( CreateExcST4BEvent event) {
	    LOGGER.info("handling CreateExcST4BEvent - " + event );
	    ExcST4B entity = new ExcST4B();
        entity.setExcST4BId( event.getExcST4BId() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKim( event.getKim() );
        entity.setKir( event.getKir() );
        entity.setKp( event.getKp() );
        entity.setKpm( event.getKpm() );
        entity.setKpr( event.getKpr() );
        entity.setLvgate( event.getLvgate() );
        entity.setTa( event.getTa() );
        entity.setThetap( event.getThetap() );
        entity.setUel( event.getUel() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
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
        emitFindAllExcST4B( entity );
    }

    /*
     * @param	event UpdateExcST4BEvent
     */
    @EventHandler( payloadType=UpdateExcST4BEvent.class )
    public void handle( UpdateExcST4BEvent event) {
    	LOGGER.info("handling UpdateExcST4BEvent - " + event );
    	
	    ExcST4B entity = new ExcST4B();
        entity.setExcST4BId( event.getExcST4BId() );
        entity.setKc( event.getKc() );
        entity.setKg( event.getKg() );
        entity.setKi( event.getKi() );
        entity.setKim( event.getKim() );
        entity.setKir( event.getKir() );
        entity.setKp( event.getKp() );
        entity.setKpm( event.getKpm() );
        entity.setKpr( event.getKpr() );
        entity.setLvgate( event.getLvgate() );
        entity.setTa( event.getTa() );
        entity.setThetap( event.getThetap() );
        entity.setUel( event.getUel() );
        entity.setVbmax( event.getVbmax() );
        entity.setVgmax( event.getVgmax() );
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
        emitFindExcST4B( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST4B( entity );        
    }
    
    /*
     * @param	event DeleteExcST4BEvent
     */
    @EventHandler( payloadType=DeleteExcST4BEvent.class )
    public void handle( DeleteExcST4BEvent event) {
    	LOGGER.info("handling DeleteExcST4BEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcST4B entity = delete( event.getExcST4BId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcST4B( entity );

    }    




    /**
     * Method to retrieve the ExcST4B via an ExcST4BPrimaryKey.
     * @param 	id Long
     * @return 	ExcST4B
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcST4B handle( FindExcST4BQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcST4BId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcST4Bs
     *
     * @param	query	FindAllExcST4BQuery 
     * @return 	List<ExcST4B> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcST4B> handle( FindAllExcST4BQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcST4B, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcST4B
	 */
	protected void emitFindExcST4B( ExcST4B entity ) {
		LOGGER.info("handling emitFindExcST4B" );
		
	    queryUpdateEmitter.emit(FindExcST4BQuery.class,
	                            query -> query.getFilter().getExcST4BId().equals(entity.getExcST4BId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcST4B
	 * 
	 * @param		entity	ExcST4B
	 */
	protected void emitFindAllExcST4B( ExcST4B entity ) {
		LOGGER.info("handling emitFindAllExcST4B" );
		
	    queryUpdateEmitter.emit(FindAllExcST4BQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcST4BProjector.class.getName());

}
