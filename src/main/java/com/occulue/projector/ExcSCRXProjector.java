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
 * Projector for ExcSCRX as outlined for the CQRS pattern.  All event handling and query handling related to ExcSCRX are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcSCRXAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excSCRX")
@Component("excSCRX-projector")
public class ExcSCRXProjector extends ExcSCRXEntityProjector {
		
	// core constructor
	public ExcSCRXProjector(ExcSCRXRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcSCRXEvent
     */
    @EventHandler( payloadType=CreateExcSCRXEvent.class )
    public void handle( CreateExcSCRXEvent event) {
	    LOGGER.info("handling CreateExcSCRXEvent - " + event );
	    ExcSCRX entity = new ExcSCRX();
        entity.setExcSCRXId( event.getExcSCRXId() );
        entity.setCswitch( event.getCswitch() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setRcrfd( event.getRcrfd() );
        entity.setTatb( event.getTatb() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSCRX( entity );
    }

    /*
     * @param	event UpdateExcSCRXEvent
     */
    @EventHandler( payloadType=UpdateExcSCRXEvent.class )
    public void handle( UpdateExcSCRXEvent event) {
    	LOGGER.info("handling UpdateExcSCRXEvent - " + event );
    	
	    ExcSCRX entity = new ExcSCRX();
        entity.setExcSCRXId( event.getExcSCRXId() );
        entity.setCswitch( event.getCswitch() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setRcrfd( event.getRcrfd() );
        entity.setTatb( event.getTatb() );
        entity.setTb( event.getTb() );
        entity.setTe( event.getTe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcSCRX( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSCRX( entity );        
    }
    
    /*
     * @param	event DeleteExcSCRXEvent
     */
    @EventHandler( payloadType=DeleteExcSCRXEvent.class )
    public void handle( DeleteExcSCRXEvent event) {
    	LOGGER.info("handling DeleteExcSCRXEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcSCRX entity = delete( event.getExcSCRXId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSCRX( entity );

    }    




    /**
     * Method to retrieve the ExcSCRX via an ExcSCRXPrimaryKey.
     * @param 	id Long
     * @return 	ExcSCRX
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcSCRX handle( FindExcSCRXQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcSCRXId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcSCRXs
     *
     * @param	query	FindAllExcSCRXQuery 
     * @return 	List<ExcSCRX> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcSCRX> handle( FindAllExcSCRXQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcSCRX, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcSCRX
	 */
	protected void emitFindExcSCRX( ExcSCRX entity ) {
		LOGGER.info("handling emitFindExcSCRX" );
		
	    queryUpdateEmitter.emit(FindExcSCRXQuery.class,
	                            query -> query.getFilter().getExcSCRXId().equals(entity.getExcSCRXId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcSCRX
	 * 
	 * @param		entity	ExcSCRX
	 */
	protected void emitFindAllExcSCRX( ExcSCRX entity ) {
		LOGGER.info("handling emitFindAllExcSCRX" );
		
	    queryUpdateEmitter.emit(FindAllExcSCRXQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcSCRXProjector.class.getName());

}
