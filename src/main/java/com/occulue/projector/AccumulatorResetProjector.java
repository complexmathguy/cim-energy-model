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
 * Projector for AccumulatorReset as outlined for the CQRS pattern.  All event handling and query handling related to AccumulatorReset are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AccumulatorResetAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("accumulatorReset")
@Component("accumulatorReset-projector")
public class AccumulatorResetProjector extends AccumulatorResetEntityProjector {
		
	// core constructor
	public AccumulatorResetProjector(AccumulatorResetRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAccumulatorResetEvent
     */
    @EventHandler( payloadType=CreateAccumulatorResetEvent.class )
    public void handle( CreateAccumulatorResetEvent event) {
	    LOGGER.info("handling CreateAccumulatorResetEvent - " + event );
	    AccumulatorReset entity = new AccumulatorReset();
        entity.setAccumulatorResetId( event.getAccumulatorResetId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorReset( entity );
    }

    /*
     * @param	event UpdateAccumulatorResetEvent
     */
    @EventHandler( payloadType=UpdateAccumulatorResetEvent.class )
    public void handle( UpdateAccumulatorResetEvent event) {
    	LOGGER.info("handling UpdateAccumulatorResetEvent - " + event );
    	
	    AccumulatorReset entity = new AccumulatorReset();
        entity.setAccumulatorResetId( event.getAccumulatorResetId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAccumulatorReset( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorReset( entity );        
    }
    
    /*
     * @param	event DeleteAccumulatorResetEvent
     */
    @EventHandler( payloadType=DeleteAccumulatorResetEvent.class )
    public void handle( DeleteAccumulatorResetEvent event) {
    	LOGGER.info("handling DeleteAccumulatorResetEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AccumulatorReset entity = delete( event.getAccumulatorResetId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorReset( entity );

    }    




    /**
     * Method to retrieve the AccumulatorReset via an AccumulatorResetPrimaryKey.
     * @param 	id Long
     * @return 	AccumulatorReset
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AccumulatorReset handle( FindAccumulatorResetQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAccumulatorResetId() );
    }
    
    /**
     * Method to retrieve a collection of all AccumulatorResets
     *
     * @param	query	FindAllAccumulatorResetQuery 
     * @return 	List<AccumulatorReset> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AccumulatorReset> handle( FindAllAccumulatorResetQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAccumulatorReset, 
	 * but only if the id matches
	 * 
	 * @param		entity	AccumulatorReset
	 */
	protected void emitFindAccumulatorReset( AccumulatorReset entity ) {
		LOGGER.info("handling emitFindAccumulatorReset" );
		
	    queryUpdateEmitter.emit(FindAccumulatorResetQuery.class,
	                            query -> query.getFilter().getAccumulatorResetId().equals(entity.getAccumulatorResetId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAccumulatorReset
	 * 
	 * @param		entity	AccumulatorReset
	 */
	protected void emitFindAllAccumulatorReset( AccumulatorReset entity ) {
		LOGGER.info("handling emitFindAllAccumulatorReset" );
		
	    queryUpdateEmitter.emit(FindAllAccumulatorResetQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorResetProjector.class.getName());

}
