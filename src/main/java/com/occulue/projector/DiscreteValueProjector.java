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
 * Projector for DiscreteValue as outlined for the CQRS pattern.  All event handling and query handling related to DiscreteValue are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscreteValueAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discreteValue")
@Component("discreteValue-projector")
public class DiscreteValueProjector extends DiscreteValueEntityProjector {
		
	// core constructor
	public DiscreteValueProjector(DiscreteValueRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscreteValueEvent
     */
    @EventHandler( payloadType=CreateDiscreteValueEvent.class )
    public void handle( CreateDiscreteValueEvent event) {
	    LOGGER.info("handling CreateDiscreteValueEvent - " + event );
	    DiscreteValue entity = new DiscreteValue();
        entity.setDiscreteValueId( event.getDiscreteValueId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscreteValue( entity );
    }

    /*
     * @param	event UpdateDiscreteValueEvent
     */
    @EventHandler( payloadType=UpdateDiscreteValueEvent.class )
    public void handle( UpdateDiscreteValueEvent event) {
    	LOGGER.info("handling UpdateDiscreteValueEvent - " + event );
    	
	    DiscreteValue entity = new DiscreteValue();
        entity.setDiscreteValueId( event.getDiscreteValueId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscreteValue( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscreteValue( entity );        
    }
    
    /*
     * @param	event DeleteDiscreteValueEvent
     */
    @EventHandler( payloadType=DeleteDiscreteValueEvent.class )
    public void handle( DeleteDiscreteValueEvent event) {
    	LOGGER.info("handling DeleteDiscreteValueEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DiscreteValue entity = delete( event.getDiscreteValueId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscreteValue( entity );

    }    




    /**
     * Method to retrieve the DiscreteValue via an DiscreteValuePrimaryKey.
     * @param 	id Long
     * @return 	DiscreteValue
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DiscreteValue handle( FindDiscreteValueQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscreteValueId() );
    }
    
    /**
     * Method to retrieve a collection of all DiscreteValues
     *
     * @param	query	FindAllDiscreteValueQuery 
     * @return 	List<DiscreteValue> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DiscreteValue> handle( FindAllDiscreteValueQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscreteValue, 
	 * but only if the id matches
	 * 
	 * @param		entity	DiscreteValue
	 */
	protected void emitFindDiscreteValue( DiscreteValue entity ) {
		LOGGER.info("handling emitFindDiscreteValue" );
		
	    queryUpdateEmitter.emit(FindDiscreteValueQuery.class,
	                            query -> query.getFilter().getDiscreteValueId().equals(entity.getDiscreteValueId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscreteValue
	 * 
	 * @param		entity	DiscreteValue
	 */
	protected void emitFindAllDiscreteValue( DiscreteValue entity ) {
		LOGGER.info("handling emitFindAllDiscreteValue" );
		
	    queryUpdateEmitter.emit(FindAllDiscreteValueQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscreteValueProjector.class.getName());

}
