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
 * Projector for ExcIEEEDC1A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEDC1A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEDC1AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEDC1A")
@Component("excIEEEDC1A-projector")
public class ExcIEEEDC1AProjector extends ExcIEEEDC1AEntityProjector {
		
	// core constructor
	public ExcIEEEDC1AProjector(ExcIEEEDC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEDC1AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEDC1AEvent.class )
    public void handle( CreateExcIEEEDC1AEvent event) {
	    LOGGER.info("handling CreateExcIEEEDC1AEvent - " + event );
	    ExcIEEEDC1A entity = new ExcIEEEDC1A();
        entity.setExcIEEEDC1AId( event.getExcIEEEDC1AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setExclim( event.getExclim() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC1A( entity );
    }

    /*
     * @param	event UpdateExcIEEEDC1AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEDC1AEvent.class )
    public void handle( UpdateExcIEEEDC1AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEDC1AEvent - " + event );
    	
	    ExcIEEEDC1A entity = new ExcIEEEDC1A();
        entity.setExcIEEEDC1AId( event.getExcIEEEDC1AId() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setExclim( event.getExclim() );
        entity.setKa( event.getKa() );
        entity.setKe( event.getKe() );
        entity.setKf( event.getKf() );
        entity.setSeefd1( event.getSeefd1() );
        entity.setSeefd2( event.getSeefd2() );
        entity.setTa( event.getTa() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
        entity.setTf( event.getTf() );
        entity.setUelin( event.getUelin() );
        entity.setVrmax( event.getVrmax() );
        entity.setVrmin( event.getVrmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcIEEEDC1A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC1A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEDC1AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEDC1AEvent.class )
    public void handle( DeleteExcIEEEDC1AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEDC1AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEDC1A entity = delete( event.getExcIEEEDC1AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC1A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEDC1A via an ExcIEEEDC1APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEDC1A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEDC1A handle( FindExcIEEEDC1AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEDC1AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC1As
     *
     * @param	query	FindAllExcIEEEDC1AQuery 
     * @return 	List<ExcIEEEDC1A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEDC1A> handle( FindAllExcIEEEDC1AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEDC1A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEDC1A
	 */
	protected void emitFindExcIEEEDC1A( ExcIEEEDC1A entity ) {
		LOGGER.info("handling emitFindExcIEEEDC1A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEDC1AQuery.class,
	                            query -> query.getFilter().getExcIEEEDC1AId().equals(entity.getExcIEEEDC1AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEDC1A
	 * 
	 * @param		entity	ExcIEEEDC1A
	 */
	protected void emitFindAllExcIEEEDC1A( ExcIEEEDC1A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEDC1A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEDC1AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC1AProjector.class.getName());

}
