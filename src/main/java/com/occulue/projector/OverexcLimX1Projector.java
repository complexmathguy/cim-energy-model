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
 * Projector for OverexcLimX1 as outlined for the CQRS pattern.  All event handling and query handling related to OverexcLimX1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcLimX1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcLimX1")
@Component("overexcLimX1-projector")
public class OverexcLimX1Projector extends OverexcLimX1EntityProjector {
		
	// core constructor
	public OverexcLimX1Projector(OverexcLimX1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcLimX1Event
     */
    @EventHandler( payloadType=CreateOverexcLimX1Event.class )
    public void handle( CreateOverexcLimX1Event event) {
	    LOGGER.info("handling CreateOverexcLimX1Event - " + event );
	    OverexcLimX1 entity = new OverexcLimX1();
        entity.setOverexcLimX1Id( event.getOverexcLimX1Id() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfd3( event.getEfd3() );
        entity.setEfddes( event.getEfddes() );
        entity.setEfdrated( event.getEfdrated() );
        entity.setKmx( event.getKmx() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVlow( event.getVlow() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimX1( entity );
    }

    /*
     * @param	event UpdateOverexcLimX1Event
     */
    @EventHandler( payloadType=UpdateOverexcLimX1Event.class )
    public void handle( UpdateOverexcLimX1Event event) {
    	LOGGER.info("handling UpdateOverexcLimX1Event - " + event );
    	
	    OverexcLimX1 entity = new OverexcLimX1();
        entity.setOverexcLimX1Id( event.getOverexcLimX1Id() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfd3( event.getEfd3() );
        entity.setEfddes( event.getEfddes() );
        entity.setEfdrated( event.getEfdrated() );
        entity.setKmx( event.getKmx() );
        entity.setT1( event.getT1() );
        entity.setT2( event.getT2() );
        entity.setT3( event.getT3() );
        entity.setVlow( event.getVlow() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindOverexcLimX1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimX1( entity );        
    }
    
    /*
     * @param	event DeleteOverexcLimX1Event
     */
    @EventHandler( payloadType=DeleteOverexcLimX1Event.class )
    public void handle( DeleteOverexcLimX1Event event) {
    	LOGGER.info("handling DeleteOverexcLimX1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcLimX1 entity = delete( event.getOverexcLimX1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimX1( entity );

    }    




    /**
     * Method to retrieve the OverexcLimX1 via an OverexcLimX1PrimaryKey.
     * @param 	id Long
     * @return 	OverexcLimX1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcLimX1 handle( FindOverexcLimX1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcLimX1Id() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcLimX1s
     *
     * @param	query	FindAllOverexcLimX1Query 
     * @return 	List<OverexcLimX1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcLimX1> handle( FindAllOverexcLimX1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcLimX1, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcLimX1
	 */
	protected void emitFindOverexcLimX1( OverexcLimX1 entity ) {
		LOGGER.info("handling emitFindOverexcLimX1" );
		
	    queryUpdateEmitter.emit(FindOverexcLimX1Query.class,
	                            query -> query.getFilter().getOverexcLimX1Id().equals(entity.getOverexcLimX1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcLimX1
	 * 
	 * @param		entity	OverexcLimX1
	 */
	protected void emitFindAllOverexcLimX1( OverexcLimX1 entity ) {
		LOGGER.info("handling emitFindAllOverexcLimX1" );
		
	    queryUpdateEmitter.emit(FindAllOverexcLimX1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimX1Projector.class.getName());

}
