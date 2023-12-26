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
 * Projector for AccumulatorValue as outlined for the CQRS pattern.  All event handling and query handling related to AccumulatorValue are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by AccumulatorValueAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("accumulatorValue")
@Component("accumulatorValue-projector")
public class AccumulatorValueProjector extends AccumulatorValueEntityProjector {
		
	// core constructor
	public AccumulatorValueProjector(AccumulatorValueRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateAccumulatorValueEvent
     */
    @EventHandler( payloadType=CreateAccumulatorValueEvent.class )
    public void handle( CreateAccumulatorValueEvent event) {
	    LOGGER.info("handling CreateAccumulatorValueEvent - " + event );
	    AccumulatorValue entity = new AccumulatorValue();
        entity.setAccumulatorValueId( event.getAccumulatorValueId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorValue( entity );
    }

    /*
     * @param	event UpdateAccumulatorValueEvent
     */
    @EventHandler( payloadType=UpdateAccumulatorValueEvent.class )
    public void handle( UpdateAccumulatorValueEvent event) {
    	LOGGER.info("handling UpdateAccumulatorValueEvent - " + event );
    	
	    AccumulatorValue entity = new AccumulatorValue();
        entity.setAccumulatorValueId( event.getAccumulatorValueId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindAccumulatorValue( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorValue( entity );        
    }
    
    /*
     * @param	event DeleteAccumulatorValueEvent
     */
    @EventHandler( payloadType=DeleteAccumulatorValueEvent.class )
    public void handle( DeleteAccumulatorValueEvent event) {
    	LOGGER.info("handling DeleteAccumulatorValueEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	AccumulatorValue entity = delete( event.getAccumulatorValueId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllAccumulatorValue( entity );

    }    




    /**
     * Method to retrieve the AccumulatorValue via an AccumulatorValuePrimaryKey.
     * @param 	id Long
     * @return 	AccumulatorValue
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public AccumulatorValue handle( FindAccumulatorValueQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getAccumulatorValueId() );
    }
    
    /**
     * Method to retrieve a collection of all AccumulatorValues
     *
     * @param	query	FindAllAccumulatorValueQuery 
     * @return 	List<AccumulatorValue> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<AccumulatorValue> handle( FindAllAccumulatorValueQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindAccumulatorValue, 
	 * but only if the id matches
	 * 
	 * @param		entity	AccumulatorValue
	 */
	protected void emitFindAccumulatorValue( AccumulatorValue entity ) {
		LOGGER.info("handling emitFindAccumulatorValue" );
		
	    queryUpdateEmitter.emit(FindAccumulatorValueQuery.class,
	                            query -> query.getFilter().getAccumulatorValueId().equals(entity.getAccumulatorValueId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllAccumulatorValue
	 * 
	 * @param		entity	AccumulatorValue
	 */
	protected void emitFindAllAccumulatorValue( AccumulatorValue entity ) {
		LOGGER.info("handling emitFindAllAccumulatorValue" );
		
	    queryUpdateEmitter.emit(FindAllAccumulatorValueQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(AccumulatorValueProjector.class.getName());

}
