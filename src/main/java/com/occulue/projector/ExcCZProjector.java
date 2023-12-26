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
 * Projector for ExcCZ as outlined for the CQRS pattern.  All event handling and query handling related to ExcCZ are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcCZAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excCZ")
@Component("excCZ-projector")
public class ExcCZProjector extends ExcCZEntityProjector {
		
	// core constructor
	public ExcCZProjector(ExcCZRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcCZEvent
     */
    @EventHandler( payloadType=CreateExcCZEvent.class )
    public void handle( CreateExcCZEvent event) {
	    LOGGER.info("handling CreateExcCZEvent - " + event );
	    ExcCZ entity = new ExcCZ();
        entity.setExcCZId( event.getExcCZId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcCZ( entity );
    }

    /*
     * @param	event UpdateExcCZEvent
     */
    @EventHandler( payloadType=UpdateExcCZEvent.class )
    public void handle( UpdateExcCZEvent event) {
    	LOGGER.info("handling UpdateExcCZEvent - " + event );
    	
	    ExcCZ entity = new ExcCZ();
        entity.setExcCZId( event.getExcCZId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcCZ( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcCZ( entity );        
    }
    
    /*
     * @param	event DeleteExcCZEvent
     */
    @EventHandler( payloadType=DeleteExcCZEvent.class )
    public void handle( DeleteExcCZEvent event) {
    	LOGGER.info("handling DeleteExcCZEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcCZ entity = delete( event.getExcCZId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcCZ( entity );

    }    




    /**
     * Method to retrieve the ExcCZ via an ExcCZPrimaryKey.
     * @param 	id Long
     * @return 	ExcCZ
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcCZ handle( FindExcCZQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcCZId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcCZs
     *
     * @param	query	FindAllExcCZQuery 
     * @return 	List<ExcCZ> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcCZ> handle( FindAllExcCZQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcCZ, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcCZ
	 */
	protected void emitFindExcCZ( ExcCZ entity ) {
		LOGGER.info("handling emitFindExcCZ" );
		
	    queryUpdateEmitter.emit(FindExcCZQuery.class,
	                            query -> query.getFilter().getExcCZId().equals(entity.getExcCZId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcCZ
	 * 
	 * @param		entity	ExcCZ
	 */
	protected void emitFindAllExcCZ( ExcCZ entity ) {
		LOGGER.info("handling emitFindAllExcCZ" );
		
	    queryUpdateEmitter.emit(FindAllExcCZQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcCZProjector.class.getName());

}
