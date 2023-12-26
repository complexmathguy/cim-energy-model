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
 * Projector for ExcIEEEDC2A as outlined for the CQRS pattern.  All event handling and query handling related to ExcIEEEDC2A are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcIEEEDC2AAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excIEEEDC2A")
@Component("excIEEEDC2A-projector")
public class ExcIEEEDC2AProjector extends ExcIEEEDC2AEntityProjector {
		
	// core constructor
	public ExcIEEEDC2AProjector(ExcIEEEDC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcIEEEDC2AEvent
     */
    @EventHandler( payloadType=CreateExcIEEEDC2AEvent.class )
    public void handle( CreateExcIEEEDC2AEvent event) {
	    LOGGER.info("handling CreateExcIEEEDC2AEvent - " + event );
	    ExcIEEEDC2A entity = new ExcIEEEDC2A();
        entity.setExcIEEEDC2AId( event.getExcIEEEDC2AId() );
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
        emitFindAllExcIEEEDC2A( entity );
    }

    /*
     * @param	event UpdateExcIEEEDC2AEvent
     */
    @EventHandler( payloadType=UpdateExcIEEEDC2AEvent.class )
    public void handle( UpdateExcIEEEDC2AEvent event) {
    	LOGGER.info("handling UpdateExcIEEEDC2AEvent - " + event );
    	
	    ExcIEEEDC2A entity = new ExcIEEEDC2A();
        entity.setExcIEEEDC2AId( event.getExcIEEEDC2AId() );
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
        emitFindExcIEEEDC2A( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC2A( entity );        
    }
    
    /*
     * @param	event DeleteExcIEEEDC2AEvent
     */
    @EventHandler( payloadType=DeleteExcIEEEDC2AEvent.class )
    public void handle( DeleteExcIEEEDC2AEvent event) {
    	LOGGER.info("handling DeleteExcIEEEDC2AEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcIEEEDC2A entity = delete( event.getExcIEEEDC2AId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcIEEEDC2A( entity );

    }    




    /**
     * Method to retrieve the ExcIEEEDC2A via an ExcIEEEDC2APrimaryKey.
     * @param 	id Long
     * @return 	ExcIEEEDC2A
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcIEEEDC2A handle( FindExcIEEEDC2AQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcIEEEDC2AId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcIEEEDC2As
     *
     * @param	query	FindAllExcIEEEDC2AQuery 
     * @return 	List<ExcIEEEDC2A> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcIEEEDC2A> handle( FindAllExcIEEEDC2AQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcIEEEDC2A, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcIEEEDC2A
	 */
	protected void emitFindExcIEEEDC2A( ExcIEEEDC2A entity ) {
		LOGGER.info("handling emitFindExcIEEEDC2A" );
		
	    queryUpdateEmitter.emit(FindExcIEEEDC2AQuery.class,
	                            query -> query.getFilter().getExcIEEEDC2AId().equals(entity.getExcIEEEDC2AId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcIEEEDC2A
	 * 
	 * @param		entity	ExcIEEEDC2A
	 */
	protected void emitFindAllExcIEEEDC2A( ExcIEEEDC2A entity ) {
		LOGGER.info("handling emitFindAllExcIEEEDC2A" );
		
	    queryUpdateEmitter.emit(FindAllExcIEEEDC2AQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcIEEEDC2AProjector.class.getName());

}
