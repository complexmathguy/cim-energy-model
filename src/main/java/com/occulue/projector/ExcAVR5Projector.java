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
 * Projector for ExcAVR5 as outlined for the CQRS pattern.  All event handling and query handling related to ExcAVR5 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcAVR5Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excAVR5")
@Component("excAVR5-projector")
public class ExcAVR5Projector extends ExcAVR5EntityProjector {
		
	// core constructor
	public ExcAVR5Projector(ExcAVR5Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcAVR5Event
     */
    @EventHandler( payloadType=CreateExcAVR5Event.class )
    public void handle( CreateExcAVR5Event event) {
	    LOGGER.info("handling CreateExcAVR5Event - " + event );
	    ExcAVR5 entity = new ExcAVR5();
        entity.setExcAVR5Id( event.getExcAVR5Id() );
        entity.setKa( event.getKa() );
        entity.setRex( event.getRex() );
        entity.setTa( event.getTa() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR5( entity );
    }

    /*
     * @param	event UpdateExcAVR5Event
     */
    @EventHandler( payloadType=UpdateExcAVR5Event.class )
    public void handle( UpdateExcAVR5Event event) {
    	LOGGER.info("handling UpdateExcAVR5Event - " + event );
    	
	    ExcAVR5 entity = new ExcAVR5();
        entity.setExcAVR5Id( event.getExcAVR5Id() );
        entity.setKa( event.getKa() );
        entity.setRex( event.getRex() );
        entity.setTa( event.getTa() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcAVR5( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR5( entity );        
    }
    
    /*
     * @param	event DeleteExcAVR5Event
     */
    @EventHandler( payloadType=DeleteExcAVR5Event.class )
    public void handle( DeleteExcAVR5Event event) {
    	LOGGER.info("handling DeleteExcAVR5Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcAVR5 entity = delete( event.getExcAVR5Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcAVR5( entity );

    }    




    /**
     * Method to retrieve the ExcAVR5 via an ExcAVR5PrimaryKey.
     * @param 	id Long
     * @return 	ExcAVR5
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcAVR5 handle( FindExcAVR5Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcAVR5Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcAVR5s
     *
     * @param	query	FindAllExcAVR5Query 
     * @return 	List<ExcAVR5> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcAVR5> handle( FindAllExcAVR5Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcAVR5, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcAVR5
	 */
	protected void emitFindExcAVR5( ExcAVR5 entity ) {
		LOGGER.info("handling emitFindExcAVR5" );
		
	    queryUpdateEmitter.emit(FindExcAVR5Query.class,
	                            query -> query.getFilter().getExcAVR5Id().equals(entity.getExcAVR5Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcAVR5
	 * 
	 * @param		entity	ExcAVR5
	 */
	protected void emitFindAllExcAVR5( ExcAVR5 entity ) {
		LOGGER.info("handling emitFindAllExcAVR5" );
		
	    queryUpdateEmitter.emit(FindAllExcAVR5Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcAVR5Projector.class.getName());

}
