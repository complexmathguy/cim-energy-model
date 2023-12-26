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
 * Projector for UnderexcLimX1 as outlined for the CQRS pattern.  All event handling and query handling related to UnderexcLimX1 are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by UnderexcLimX1Aggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("underexcLimX1")
@Component("underexcLimX1-projector")
public class UnderexcLimX1Projector extends UnderexcLimX1EntityProjector {
		
	// core constructor
	public UnderexcLimX1Projector(UnderexcLimX1Repository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateUnderexcLimX1Event
     */
    @EventHandler( payloadType=CreateUnderexcLimX1Event.class )
    public void handle( CreateUnderexcLimX1Event event) {
	    LOGGER.info("handling CreateUnderexcLimX1Event - " + event );
	    UnderexcLimX1 entity = new UnderexcLimX1();
        entity.setUnderexcLimX1Id( event.getUnderexcLimX1Id() );
        entity.setK( event.getK() );
        entity.setKf2( event.getKf2() );
        entity.setKm( event.getKm() );
        entity.setMelmax( event.getMelmax() );
        entity.setTf2( event.getTf2() );
        entity.setTm( event.getTm() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimX1( entity );
    }

    /*
     * @param	event UpdateUnderexcLimX1Event
     */
    @EventHandler( payloadType=UpdateUnderexcLimX1Event.class )
    public void handle( UpdateUnderexcLimX1Event event) {
    	LOGGER.info("handling UpdateUnderexcLimX1Event - " + event );
    	
	    UnderexcLimX1 entity = new UnderexcLimX1();
        entity.setUnderexcLimX1Id( event.getUnderexcLimX1Id() );
        entity.setK( event.getK() );
        entity.setKf2( event.getKf2() );
        entity.setKm( event.getKm() );
        entity.setMelmax( event.getMelmax() );
        entity.setTf2( event.getTf2() );
        entity.setTm( event.getTm() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindUnderexcLimX1( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimX1( entity );        
    }
    
    /*
     * @param	event DeleteUnderexcLimX1Event
     */
    @EventHandler( payloadType=DeleteUnderexcLimX1Event.class )
    public void handle( DeleteUnderexcLimX1Event event) {
    	LOGGER.info("handling DeleteUnderexcLimX1Event - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	UnderexcLimX1 entity = delete( event.getUnderexcLimX1Id() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllUnderexcLimX1( entity );

    }    




    /**
     * Method to retrieve the UnderexcLimX1 via an UnderexcLimX1PrimaryKey.
     * @param 	id Long
     * @return 	UnderexcLimX1
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public UnderexcLimX1 handle( FindUnderexcLimX1Query query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getUnderexcLimX1Id() );
    }
    
    /**
     * Method to retrieve a collection of all UnderexcLimX1s
     *
     * @param	query	FindAllUnderexcLimX1Query 
     * @return 	List<UnderexcLimX1> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<UnderexcLimX1> handle( FindAllUnderexcLimX1Query query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindUnderexcLimX1, 
	 * but only if the id matches
	 * 
	 * @param		entity	UnderexcLimX1
	 */
	protected void emitFindUnderexcLimX1( UnderexcLimX1 entity ) {
		LOGGER.info("handling emitFindUnderexcLimX1" );
		
	    queryUpdateEmitter.emit(FindUnderexcLimX1Query.class,
	                            query -> query.getFilter().getUnderexcLimX1Id().equals(entity.getUnderexcLimX1Id()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllUnderexcLimX1
	 * 
	 * @param		entity	UnderexcLimX1
	 */
	protected void emitFindAllUnderexcLimX1( UnderexcLimX1 entity ) {
		LOGGER.info("handling emitFindAllUnderexcLimX1" );
		
	    queryUpdateEmitter.emit(FindAllUnderexcLimX1Query.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(UnderexcLimX1Projector.class.getName());

}
