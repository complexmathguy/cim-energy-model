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
 * Projector for Discrete as outlined for the CQRS pattern.  All event handling and query handling related to Discrete are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DiscreteAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("discrete")
@Component("discrete-projector")
public class DiscreteProjector extends DiscreteEntityProjector {
		
	// core constructor
	public DiscreteProjector(DiscreteRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDiscreteEvent
     */
    @EventHandler( payloadType=CreateDiscreteEvent.class )
    public void handle( CreateDiscreteEvent event) {
	    LOGGER.info("handling CreateDiscreteEvent - " + event );
	    Discrete entity = new Discrete();
        entity.setDiscreteId( event.getDiscreteId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscrete( entity );
    }

    /*
     * @param	event UpdateDiscreteEvent
     */
    @EventHandler( payloadType=UpdateDiscreteEvent.class )
    public void handle( UpdateDiscreteEvent event) {
    	LOGGER.info("handling UpdateDiscreteEvent - " + event );
    	
	    Discrete entity = new Discrete();
        entity.setDiscreteId( event.getDiscreteId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDiscrete( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscrete( entity );        
    }
    
    /*
     * @param	event DeleteDiscreteEvent
     */
    @EventHandler( payloadType=DeleteDiscreteEvent.class )
    public void handle( DeleteDiscreteEvent event) {
    	LOGGER.info("handling DeleteDiscreteEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Discrete entity = delete( event.getDiscreteId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDiscrete( entity );

    }    




    /**
     * Method to retrieve the Discrete via an DiscretePrimaryKey.
     * @param 	id Long
     * @return 	Discrete
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Discrete handle( FindDiscreteQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDiscreteId() );
    }
    
    /**
     * Method to retrieve a collection of all Discretes
     *
     * @param	query	FindAllDiscreteQuery 
     * @return 	List<Discrete> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Discrete> handle( FindAllDiscreteQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDiscrete, 
	 * but only if the id matches
	 * 
	 * @param		entity	Discrete
	 */
	protected void emitFindDiscrete( Discrete entity ) {
		LOGGER.info("handling emitFindDiscrete" );
		
	    queryUpdateEmitter.emit(FindDiscreteQuery.class,
	                            query -> query.getFilter().getDiscreteId().equals(entity.getDiscreteId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDiscrete
	 * 
	 * @param		entity	Discrete
	 */
	protected void emitFindAllDiscrete( Discrete entity ) {
		LOGGER.info("handling emitFindAllDiscrete" );
		
	    queryUpdateEmitter.emit(FindAllDiscreteQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DiscreteProjector.class.getName());

}
