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
 * Projector for LoadGenericNonLinear as outlined for the CQRS pattern.  All event handling and query handling related to LoadGenericNonLinear are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by LoadGenericNonLinearAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("loadGenericNonLinear")
@Component("loadGenericNonLinear-projector")
public class LoadGenericNonLinearProjector extends LoadGenericNonLinearEntityProjector {
		
	// core constructor
	public LoadGenericNonLinearProjector(LoadGenericNonLinearRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateLoadGenericNonLinearEvent
     */
    @EventHandler( payloadType=CreateLoadGenericNonLinearEvent.class )
    public void handle( CreateLoadGenericNonLinearEvent event) {
	    LOGGER.info("handling CreateLoadGenericNonLinearEvent - " + event );
	    LoadGenericNonLinear entity = new LoadGenericNonLinear();
        entity.setLoadGenericNonLinearId( event.getLoadGenericNonLinearId() );
        entity.setBs( event.getBs() );
        entity.setBt( event.getBt() );
        entity.setGenericNonLinearLoadModelType( event.getGenericNonLinearLoadModelType() );
        entity.setLs( event.getLs() );
        entity.setLt( event.getLt() );
        entity.setPt( event.getPt() );
        entity.setQt( event.getQt() );
        entity.setTp( event.getTp() );
        entity.setTq( event.getTq() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadGenericNonLinear( entity );
    }

    /*
     * @param	event UpdateLoadGenericNonLinearEvent
     */
    @EventHandler( payloadType=UpdateLoadGenericNonLinearEvent.class )
    public void handle( UpdateLoadGenericNonLinearEvent event) {
    	LOGGER.info("handling UpdateLoadGenericNonLinearEvent - " + event );
    	
	    LoadGenericNonLinear entity = new LoadGenericNonLinear();
        entity.setLoadGenericNonLinearId( event.getLoadGenericNonLinearId() );
        entity.setBs( event.getBs() );
        entity.setBt( event.getBt() );
        entity.setGenericNonLinearLoadModelType( event.getGenericNonLinearLoadModelType() );
        entity.setLs( event.getLs() );
        entity.setLt( event.getLt() );
        entity.setPt( event.getPt() );
        entity.setQt( event.getQt() );
        entity.setTp( event.getTp() );
        entity.setTq( event.getTq() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindLoadGenericNonLinear( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadGenericNonLinear( entity );        
    }
    
    /*
     * @param	event DeleteLoadGenericNonLinearEvent
     */
    @EventHandler( payloadType=DeleteLoadGenericNonLinearEvent.class )
    public void handle( DeleteLoadGenericNonLinearEvent event) {
    	LOGGER.info("handling DeleteLoadGenericNonLinearEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	LoadGenericNonLinear entity = delete( event.getLoadGenericNonLinearId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllLoadGenericNonLinear( entity );

    }    




    /**
     * Method to retrieve the LoadGenericNonLinear via an LoadGenericNonLinearPrimaryKey.
     * @param 	id Long
     * @return 	LoadGenericNonLinear
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public LoadGenericNonLinear handle( FindLoadGenericNonLinearQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getLoadGenericNonLinearId() );
    }
    
    /**
     * Method to retrieve a collection of all LoadGenericNonLinears
     *
     * @param	query	FindAllLoadGenericNonLinearQuery 
     * @return 	List<LoadGenericNonLinear> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<LoadGenericNonLinear> handle( FindAllLoadGenericNonLinearQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindLoadGenericNonLinear, 
	 * but only if the id matches
	 * 
	 * @param		entity	LoadGenericNonLinear
	 */
	protected void emitFindLoadGenericNonLinear( LoadGenericNonLinear entity ) {
		LOGGER.info("handling emitFindLoadGenericNonLinear" );
		
	    queryUpdateEmitter.emit(FindLoadGenericNonLinearQuery.class,
	                            query -> query.getFilter().getLoadGenericNonLinearId().equals(entity.getLoadGenericNonLinearId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllLoadGenericNonLinear
	 * 
	 * @param		entity	LoadGenericNonLinear
	 */
	protected void emitFindAllLoadGenericNonLinear( LoadGenericNonLinear entity ) {
		LOGGER.info("handling emitFindAllLoadGenericNonLinear" );
		
	    queryUpdateEmitter.emit(FindAllLoadGenericNonLinearQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(LoadGenericNonLinearProjector.class.getName());

}
