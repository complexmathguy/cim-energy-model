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
 * Projector for ExcANS as outlined for the CQRS pattern.  All event handling and query handling related to ExcANS are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExcANSAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("excANS")
@Component("excANS-projector")
public class ExcANSProjector extends ExcANSEntityProjector {
		
	// core constructor
	public ExcANSProjector(ExcANSRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExcANSEvent
     */
    @EventHandler( payloadType=CreateExcANSEvent.class )
    public void handle( CreateExcANSEvent event) {
	    LOGGER.info("handling CreateExcANSEvent - " + event );
	    ExcANS entity = new ExcANS();
        entity.setExcANSId( event.getExcANSId() );
        entity.setBlint( event.getBlint() );
        entity.setIfmn( event.getIfmn() );
        entity.setIfmx( event.getIfmx() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setKce( event.getKce() );
        entity.setKrvecc( event.getKrvecc() );
        entity.setKvfif( event.getKvfif() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setTb( event.getTb() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcANS( entity );
    }

    /*
     * @param	event UpdateExcANSEvent
     */
    @EventHandler( payloadType=UpdateExcANSEvent.class )
    public void handle( UpdateExcANSEvent event) {
    	LOGGER.info("handling UpdateExcANSEvent - " + event );
    	
	    ExcANS entity = new ExcANS();
        entity.setExcANSId( event.getExcANSId() );
        entity.setBlint( event.getBlint() );
        entity.setIfmn( event.getIfmn() );
        entity.setIfmx( event.getIfmx() );
        entity.setK2( event.getK2() );
        entity.setK3( event.getK3() );
        entity.setKce( event.getKce() );
        entity.setKrvecc( event.getKrvecc() );
        entity.setKvfif( event.getKvfif() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setTb( event.getTb() );
        entity.setVrmn( event.getVrmn() );
        entity.setVrmx( event.getVrmx() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExcANS( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcANS( entity );        
    }
    
    /*
     * @param	event DeleteExcANSEvent
     */
    @EventHandler( payloadType=DeleteExcANSEvent.class )
    public void handle( DeleteExcANSEvent event) {
    	LOGGER.info("handling DeleteExcANSEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExcANS entity = delete( event.getExcANSId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExcANS( entity );

    }    




    /**
     * Method to retrieve the ExcANS via an ExcANSPrimaryKey.
     * @param 	id Long
     * @return 	ExcANS
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExcANS handle( FindExcANSQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExcANSId() );
    }
    
    /**
     * Method to retrieve a collection of all ExcANSs
     *
     * @param	query	FindAllExcANSQuery 
     * @return 	List<ExcANS> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExcANS> handle( FindAllExcANSQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExcANS, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExcANS
	 */
	protected void emitFindExcANS( ExcANS entity ) {
		LOGGER.info("handling emitFindExcANS" );
		
	    queryUpdateEmitter.emit(FindExcANSQuery.class,
	                            query -> query.getFilter().getExcANSId().equals(entity.getExcANSId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExcANS
	 * 
	 * @param		entity	ExcANS
	 */
	protected void emitFindAllExcANS( ExcANS entity ) {
		LOGGER.info("handling emitFindAllExcANS" );
		
	    queryUpdateEmitter.emit(FindAllExcANSQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExcANSProjector.class.getName());

}
