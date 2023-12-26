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
 * Projector for WindType1or2UserDefined as outlined for the CQRS pattern.  All event handling and query handling related to WindType1or2UserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindType1or2UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windType1or2UserDefined")
@Component("windType1or2UserDefined-projector")
public class WindType1or2UserDefinedProjector extends WindType1or2UserDefinedEntityProjector {
		
	// core constructor
	public WindType1or2UserDefinedProjector(WindType1or2UserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindType1or2UserDefinedEvent
     */
    @EventHandler( payloadType=CreateWindType1or2UserDefinedEvent.class )
    public void handle( CreateWindType1or2UserDefinedEvent event) {
	    LOGGER.info("handling CreateWindType1or2UserDefinedEvent - " + event );
	    WindType1or2UserDefined entity = new WindType1or2UserDefined();
        entity.setWindType1or2UserDefinedId( event.getWindType1or2UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType1or2UserDefined( entity );
    }

    /*
     * @param	event UpdateWindType1or2UserDefinedEvent
     */
    @EventHandler( payloadType=UpdateWindType1or2UserDefinedEvent.class )
    public void handle( UpdateWindType1or2UserDefinedEvent event) {
    	LOGGER.info("handling UpdateWindType1or2UserDefinedEvent - " + event );
    	
	    WindType1or2UserDefined entity = new WindType1or2UserDefined();
        entity.setWindType1or2UserDefinedId( event.getWindType1or2UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindType1or2UserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType1or2UserDefined( entity );        
    }
    
    /*
     * @param	event DeleteWindType1or2UserDefinedEvent
     */
    @EventHandler( payloadType=DeleteWindType1or2UserDefinedEvent.class )
    public void handle( DeleteWindType1or2UserDefinedEvent event) {
    	LOGGER.info("handling DeleteWindType1or2UserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindType1or2UserDefined entity = delete( event.getWindType1or2UserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindType1or2UserDefined( entity );

    }    




    /**
     * Method to retrieve the WindType1or2UserDefined via an WindType1or2UserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	WindType1or2UserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindType1or2UserDefined handle( FindWindType1or2UserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindType1or2UserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all WindType1or2UserDefineds
     *
     * @param	query	FindAllWindType1or2UserDefinedQuery 
     * @return 	List<WindType1or2UserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindType1or2UserDefined> handle( FindAllWindType1or2UserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindType1or2UserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindType1or2UserDefined
	 */
	protected void emitFindWindType1or2UserDefined( WindType1or2UserDefined entity ) {
		LOGGER.info("handling emitFindWindType1or2UserDefined" );
		
	    queryUpdateEmitter.emit(FindWindType1or2UserDefinedQuery.class,
	                            query -> query.getFilter().getWindType1or2UserDefinedId().equals(entity.getWindType1or2UserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindType1or2UserDefined
	 * 
	 * @param		entity	WindType1or2UserDefined
	 */
	protected void emitFindAllWindType1or2UserDefined( WindType1or2UserDefined entity ) {
		LOGGER.info("handling emitFindAllWindType1or2UserDefined" );
		
	    queryUpdateEmitter.emit(FindAllWindType1or2UserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindType1or2UserDefinedProjector.class.getName());

}
