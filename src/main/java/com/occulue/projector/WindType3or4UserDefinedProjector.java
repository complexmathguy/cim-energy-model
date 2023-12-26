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
 * Projector for WindType3or4UserDefined as outlined for the CQRS pattern.  All event handling and query handling related to WindType3or4UserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindType3or4UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windType3or4UserDefined")
@Component("windType3or4UserDefined-projector")
public class WindType3or4UserDefinedProjector extends WindType3or4UserDefinedEntityProjector {
		
	// core constructor
	public WindType3or4UserDefinedProjector(WindType3or4UserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindType3or4UserDefinedEvent
     */
    @EventHandler( payloadType=CreateWindType3or4UserDefinedEvent.class )
    public void handle( CreateWindType3or4UserDefinedEvent event) {
	    LOGGER.info("handling CreateWindType3or4UserDefinedEvent - " + event );
	    WindType3or4UserDefined entity = new WindType3or4UserDefined();
        entity.setWindType3or4UserDefinedId( event.getWindType3or4UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType3or4UserDefined( entity );
    }

    /*
     * @param	event UpdateWindType3or4UserDefinedEvent
     */
    @EventHandler( payloadType=UpdateWindType3or4UserDefinedEvent.class )
    public void handle( UpdateWindType3or4UserDefinedEvent event) {
    	LOGGER.info("handling UpdateWindType3or4UserDefinedEvent - " + event );
    	
	    WindType3or4UserDefined entity = new WindType3or4UserDefined();
        entity.setWindType3or4UserDefinedId( event.getWindType3or4UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindType3or4UserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType3or4UserDefined( entity );        
    }
    
    /*
     * @param	event DeleteWindType3or4UserDefinedEvent
     */
    @EventHandler( payloadType=DeleteWindType3or4UserDefinedEvent.class )
    public void handle( DeleteWindType3or4UserDefinedEvent event) {
    	LOGGER.info("handling DeleteWindType3or4UserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindType3or4UserDefined entity = delete( event.getWindType3or4UserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType3or4UserDefined( entity );

    }    




    /**
     * Method to retrieve the WindType3or4UserDefined via an WindType3or4UserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	WindType3or4UserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindType3or4UserDefined handle( FindWindType3or4UserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindType3or4UserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all WindType3or4UserDefineds
     *
     * @param	query	FindAllWindType3or4UserDefinedQuery 
     * @return 	List<WindType3or4UserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindType3or4UserDefined> handle( FindAllWindType3or4UserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindType3or4UserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindType3or4UserDefined
	 */
	protected void emitFindWindType3or4UserDefined( WindType3or4UserDefined entity ) {
		LOGGER.info("handling emitFindWindType3or4UserDefined" );
		
	    queryUpdateEmitter.emit(FindWindType3or4UserDefinedQuery.class,
	                            query -> query.getFilter().getWindType3or4UserDefinedId().equals(entity.getWindType3or4UserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindType3or4UserDefined
	 * 
	 * @param		entity	WindType3or4UserDefined
	 */
	protected void emitFindAllWindType3or4UserDefined( WindType3or4UserDefined entity ) {
		LOGGER.info("handling emitFindAllWindType3or4UserDefined" );
		
	    queryUpdateEmitter.emit(FindAllWindType3or4UserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindType3or4UserDefinedProjector.class.getName());

}
