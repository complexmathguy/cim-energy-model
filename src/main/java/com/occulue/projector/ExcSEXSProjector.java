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
 * Projector for ExcSEXS as outlined for the CQRS pattern.  All event handling and query handling related to ExcSEXS are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcSEXSAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excSEXS")
@Component("excSEXS-projector")
public class ExcSEXSProjector extends ExcSEXSEntityProjector {
		
	// core constructor
	public ExcSEXSProjector(ExcSEXSRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcSEXSEvent
     */
    @EventHandler( payloadType=CreateExcSEXSEvent.class )
    public void handle( CreateExcSEXSEvent event) {
	    LOGGER.info("handling CreateExcSEXSEvent - " + event );
	    ExcSEXS entity = new ExcSEXS();
        entity.setExcSEXSId( event.getExcSEXSId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setKc( event.getKc() );
        entity.setTatb( event.getTatb() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSEXS( entity );
    }

    /*
     * @param	event UpdateExcSEXSEvent
     */
    @EventHandler( payloadType=UpdateExcSEXSEvent.class )
    public void handle( UpdateExcSEXSEvent event) {
    	LOGGER.info("handling UpdateExcSEXSEvent - " + event );
    	
	    ExcSEXS entity = new ExcSEXS();
        entity.setExcSEXSId( event.getExcSEXSId() );
        entity.setEfdmax( event.getEfdmax() );
        entity.setEfdmin( event.getEfdmin() );
        entity.setEmax( event.getEmax() );
        entity.setEmin( event.getEmin() );
        entity.setK( event.getK() );
        entity.setKc( event.getKc() );
        entity.setTatb( event.getTatb() );
        entity.setTb( event.getTb() );
        entity.setTc( event.getTc() );
        entity.setTe( event.getTe() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcSEXS( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSEXS( entity );        
    }
    
    /*
     * @param	event DeleteExcSEXSEvent
     */
    @EventHandler( payloadType=DeleteExcSEXSEvent.class )
    public void handle( DeleteExcSEXSEvent event) {
    	LOGGER.info("handling DeleteExcSEXSEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcSEXS entity = delete( event.getExcSEXSId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcSEXS( entity );

    }    




    /**
     * Method to retrieve the ExcSEXS via an ExcSEXSPrimaryKey.
     * @param 	id Long
     * @return 	ExcSEXS
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcSEXS handle( FindExcSEXSQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcSEXSId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcSEXSs
     *
     * @param	query	FindAllExcSEXSQuery 
     * @return 	List<ExcSEXS> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcSEXS> handle( FindAllExcSEXSQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcSEXS, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcSEXS
	 */
	protected void emitFindExcSEXS( ExcSEXS entity ) {
		LOGGER.info("handling emitFindExcSEXS" );
		
	    queryUpdateEmitter.emit(FindExcSEXSQuery.class,
	                            query -> query.getFilter().getExcSEXSId().equals(entity.getExcSEXSId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcSEXS
	 * 
	 * @param		entity	ExcSEXS
	 */
	protected void emitFindAllExcSEXS( ExcSEXS entity ) {
		LOGGER.info("handling emitFindAllExcSEXS" );
		
	    queryUpdateEmitter.emit(FindAllExcSEXSQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcSEXSProjector.class.getName());

}
