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
 * Projector for OverexcLimX2 as outlined for the CQRS pattern.  All event handling and query handling related to OverexcLimX2 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by OverexcLimX2Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("overexcLimX2")
@Component("overexcLimX2-projector")
public class OverexcLimX2Projector extends OverexcLimX2EntityProjector {
		
	// core constructor
	public OverexcLimX2Projector(OverexcLimX2Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateOverexcLimX2Event
     */
    @EventHandler( payloadType=CreateOverexcLimX2Event.class )
    public void handle( CreateOverexcLimX2Event event) {
	    LOGGER.info("handling CreateOverexcLimX2Event - " + event );
	    OverexcLimX2 entity = new OverexcLimX2();
        entity.setOverexcLimX2Id( event.getOverexcLimX2Id() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfd3( event.getEfd3() );
        entity.setEfddes( event.getEfddes() );
        entity.setEfdrated( event.getEfdrated() );
        entity.setKmx( event.getKmx() );
        entity.setM( event.getM() );
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
        emitFindAllOverexcLimX2( entity );
    }

    /*
     * @param	event UpdateOverexcLimX2Event
     */
    @EventHandler( payloadType=UpdateOverexcLimX2Event.class )
    public void handle( UpdateOverexcLimX2Event event) {
    	LOGGER.info("handling UpdateOverexcLimX2Event - " + event );
    	
	    OverexcLimX2 entity = new OverexcLimX2();
        entity.setOverexcLimX2Id( event.getOverexcLimX2Id() );
        entity.setEfd1( event.getEfd1() );
        entity.setEfd2( event.getEfd2() );
        entity.setEfd3( event.getEfd3() );
        entity.setEfddes( event.getEfddes() );
        entity.setEfdrated( event.getEfdrated() );
        entity.setKmx( event.getKmx() );
        entity.setM( event.getM() );
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
        emitFindOverexcLimX2( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimX2( entity );        
    }
    
    /*
     * @param	event DeleteOverexcLimX2Event
     */
    @EventHandler( payloadType=DeleteOverexcLimX2Event.class )
    public void handle( DeleteOverexcLimX2Event event) {
    	LOGGER.info("handling DeleteOverexcLimX2Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	OverexcLimX2 entity = delete( event.getOverexcLimX2Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllOverexcLimX2( entity );

    }    




    /**
     * Method to retrieve the OverexcLimX2 via an OverexcLimX2PrimaryKey.
     * @param 	id Long
     * @return 	OverexcLimX2
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public OverexcLimX2 handle( FindOverexcLimX2Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getOverexcLimX2Id() );
    }
    
    /**
     * Method to retrieve a collection of all OverexcLimX2s
     *
     * @param	query	FindAllOverexcLimX2Query 
     * @return 	List<OverexcLimX2> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<OverexcLimX2> handle( FindAllOverexcLimX2Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindOverexcLimX2, 
	 * but only if the id matches
	 * 
	 * @param		entity	OverexcLimX2
	 */
	protected void emitFindOverexcLimX2( OverexcLimX2 entity ) {
		LOGGER.info("handling emitFindOverexcLimX2" );
		
	    queryUpdateEmitter.emit(FindOverexcLimX2Query.class,
	                            query -> query.getFilter().getOverexcLimX2Id().equals(entity.getOverexcLimX2Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllOverexcLimX2
	 * 
	 * @param		entity	OverexcLimX2
	 */
	protected void emitFindAllOverexcLimX2( OverexcLimX2 entity ) {
		LOGGER.info("handling emitFindAllOverexcLimX2" );
		
	    queryUpdateEmitter.emit(FindAllOverexcLimX2Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(OverexcLimX2Projector.class.getName());

}
