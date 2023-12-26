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
 * Projector for ExcDC3A1 as outlined for the CQRS pattern.  All event handling and query handling related to ExcDC3A1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcDC3A1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excDC3A1")
@Component("excDC3A1-projector")
public class ExcDC3A1Projector extends ExcDC3A1EntityProjector {
		
	// core constructor
	public ExcDC3A1Projector(ExcDC3A1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcDC3A1Event
     */
    @EventHandler( payloadType=CreateExcDC3A1Event.class )
    public void handle( CreateExcDC3A1Event event) {
	    LOGGER.info("handling CreateExcDC3A1Event - " + event );
	    ExcDC3A1 entity = new ExcDC3A1();
        entity.setExcDC3A1Id( event.getExcDC3A1Id() );
        entity.setExclim( event.getExclim() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVb1max( event.getVb1max() );
        entity.setVblim( event.getVblim() );
        entity.setVbmax( event.getVbmax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A1( entity );
    }

    /*
     * @param	event UpdateExcDC3A1Event
     */
    @EventHandler( payloadType=UpdateExcDC3A1Event.class )
    public void handle( UpdateExcDC3A1Event event) {
    	LOGGER.info("handling UpdateExcDC3A1Event - " + event );
    	
	    ExcDC3A1 entity = new ExcDC3A1();
        entity.setExcDC3A1Id( event.getExcDC3A1Id() );
        entity.setExclim( event.getExclim() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setTa( event.getTa() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setVb1max( event.getVb1max() );
        entity.setVblim( event.getVblim() );
        entity.setVbmax( event.getVbmax() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcDC3A1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A1( entity );        
    }
    
    /*
     * @param	event DeleteExcDC3A1Event
     */
    @EventHandler( payloadType=DeleteExcDC3A1Event.class )
    public void handle( DeleteExcDC3A1Event event) {
    	LOGGER.info("handling DeleteExcDC3A1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcDC3A1 entity = delete( event.getExcDC3A1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcDC3A1( entity );

    }    




    /**
     * Method to retrieve the ExcDC3A1 via an ExcDC3A1PrimaryKey.
     * @param 	id Long
     * @return 	ExcDC3A1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcDC3A1 handle( FindExcDC3A1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcDC3A1Id() );
    }
    
    /**
     * Method to retrieve a collection of all ExcDC3A1s
     *
     * @param	query	FindAllExcDC3A1Query 
     * @return 	List<ExcDC3A1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcDC3A1> handle( FindAllExcDC3A1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcDC3A1, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcDC3A1
	 */
	protected void emitFindExcDC3A1( ExcDC3A1 entity ) {
		LOGGER.info("handling emitFindExcDC3A1" );
		
	    queryUpdateEmitter.emit(FindExcDC3A1Query.class,
	                            query -> query.getFilter().getExcDC3A1Id().equals(entity.getExcDC3A1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcDC3A1
	 * 
	 * @param		entity	ExcDC3A1
	 */
	protected void emitFindAllExcDC3A1( ExcDC3A1 entity ) {
		LOGGER.info("handling emitFindAllExcDC3A1" );
		
	    queryUpdateEmitter.emit(FindAllExcDC3A1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcDC3A1Projector.class.getName());

}
