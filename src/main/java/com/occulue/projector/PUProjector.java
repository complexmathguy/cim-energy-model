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
 * Projector for PU as outlined for the CQRS pattern.  All event handling and query handling related to PU are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PUAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pU")
@Component("pU-projector")
public class PUProjector extends PUEntityProjector {
		
	// core constructor
	public PUProjector(PURepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePUEvent
     */
    @EventHandler( payloadType=CreatePUEvent.class )
    public void handle( CreatePUEvent event) {
	    LOGGER.info("handling CreatePUEvent - " + event );
	    PU entity = new PU();
        entity.setPUId( event.getPUId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPU( entity );
    }

    /*
     * @param	event UpdatePUEvent
     */
    @EventHandler( payloadType=UpdatePUEvent.class )
    public void handle( UpdatePUEvent event) {
    	LOGGER.info("handling UpdatePUEvent - " + event );
    	
	    PU entity = new PU();
        entity.setPUId( event.getPUId() );
        entity.setMultiplier( event.getMultiplier() );
        entity.setUnit( event.getUnit() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPU( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPU( entity );        
    }
    
    /*
     * @param	event DeletePUEvent
     */
    @EventHandler( payloadType=DeletePUEvent.class )
    public void handle( DeletePUEvent event) {
    	LOGGER.info("handling DeletePUEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PU entity = delete( event.getPUId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPU( entity );

    }    




    /**
     * Method to retrieve the PU via an PUPrimaryKey.
     * @param 	id Long
     * @return 	PU
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PU handle( FindPUQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPUId() );
    }
    
    /**
     * Method to retrieve a collection of all PUs
     *
     * @param	query	FindAllPUQuery 
     * @return 	List<PU> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PU> handle( FindAllPUQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPU, 
	 * but only if the id matches
	 * 
	 * @param		entity	PU
	 */
	protected void emitFindPU( PU entity ) {
		LOGGER.info("handling emitFindPU" );
		
	    queryUpdateEmitter.emit(FindPUQuery.class,
	                            query -> query.getFilter().getPUId().equals(entity.getPUId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPU
	 * 
	 * @param		entity	PU
	 */
	protected void emitFindAllPU( PU entity ) {
		LOGGER.info("handling emitFindAllPU" );
		
	    queryUpdateEmitter.emit(FindAllPUQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PUProjector.class.getName());

}
