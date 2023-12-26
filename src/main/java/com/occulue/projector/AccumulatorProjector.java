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
 * Projector for Accumulator as outlined for the CQRS pattern.  All event handling and query handling related to Accumulator are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AccumulatorAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("accumulator")
@Component("accumulator-projector")
public class AccumulatorProjector extends AccumulatorEntityProjector {
		
	// core constructor
	public AccumulatorProjector(AccumulatorRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAccumulatorEvent
     */
    @EventHandler( payloadType=CreateAccumulatorEvent.class )
    public void handle( CreateAccumulatorEvent event) {
	    LOGGER.info("handling CreateAccumulatorEvent - " + event );
	    Accumulator entity = new Accumulator();
        entity.setAccumulatorId( event.getAccumulatorId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulator( entity );
    }

    /*
     * @param	event UpdateAccumulatorEvent
     */
    @EventHandler( payloadType=UpdateAccumulatorEvent.class )
    public void handle( UpdateAccumulatorEvent event) {
    	LOGGER.info("handling UpdateAccumulatorEvent - " + event );
    	
	    Accumulator entity = new Accumulator();
        entity.setAccumulatorId( event.getAccumulatorId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAccumulator( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulator( entity );        
    }
    
    /*
     * @param	event DeleteAccumulatorEvent
     */
    @EventHandler( payloadType=DeleteAccumulatorEvent.class )
    public void handle( DeleteAccumulatorEvent event) {
    	LOGGER.info("handling DeleteAccumulatorEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Accumulator entity = delete( event.getAccumulatorId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulator( entity );

    }    




    /**
     * Method to retrieve the Accumulator via an AccumulatorPrimaryKey.
     * @param 	id Long
     * @return 	Accumulator
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Accumulator handle( FindAccumulatorQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAccumulatorId() );
    }
    
    /**
     * Method to retrieve a collection of all Accumulators
     *
     * @param	query	FindAllAccumulatorQuery 
     * @return 	List<Accumulator> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Accumulator> handle( FindAllAccumulatorQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAccumulator, 
	 * but only if the id matches
	 * 
	 * @param		entity	Accumulator
	 */
	protected void emitFindAccumulator( Accumulator entity ) {
		LOGGER.info("handling emitFindAccumulator" );
		
	    queryUpdateEmitter.emit(FindAccumulatorQuery.class,
	                            query -> query.getFilter().getAccumulatorId().equals(entity.getAccumulatorId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAccumulator
	 * 
	 * @param		entity	Accumulator
	 */
	protected void emitFindAllAccumulator( Accumulator entity ) {
		LOGGER.info("handling emitFindAllAccumulator" );
		
	    queryUpdateEmitter.emit(FindAllAccumulatorQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorProjector.class.getName());

}
