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
 * Projector for ValueAliasSet as outlined for the CQRS pattern.  All event handling and query handling related to ValueAliasSet are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ValueAliasSetAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("valueAliasSet")
@Component("valueAliasSet-projector")
public class ValueAliasSetProjector extends ValueAliasSetEntityProjector {
		
	// core constructor
	public ValueAliasSetProjector(ValueAliasSetRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateValueAliasSetEvent
     */
    @EventHandler( payloadType=CreateValueAliasSetEvent.class )
    public void handle( CreateValueAliasSetEvent event) {
	    LOGGER.info("handling CreateValueAliasSetEvent - " + event );
	    ValueAliasSet entity = new ValueAliasSet();
        entity.setValueAliasSetId( event.getValueAliasSetId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueAliasSet( entity );
    }

    /*
     * @param	event UpdateValueAliasSetEvent
     */
    @EventHandler( payloadType=UpdateValueAliasSetEvent.class )
    public void handle( UpdateValueAliasSetEvent event) {
    	LOGGER.info("handling UpdateValueAliasSetEvent - " + event );
    	
	    ValueAliasSet entity = new ValueAliasSet();
        entity.setValueAliasSetId( event.getValueAliasSetId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindValueAliasSet( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueAliasSet( entity );        
    }
    
    /*
     * @param	event DeleteValueAliasSetEvent
     */
    @EventHandler( payloadType=DeleteValueAliasSetEvent.class )
    public void handle( DeleteValueAliasSetEvent event) {
    	LOGGER.info("handling DeleteValueAliasSetEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ValueAliasSet entity = delete( event.getValueAliasSetId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueAliasSet( entity );

    }    




    /**
     * Method to retrieve the ValueAliasSet via an ValueAliasSetPrimaryKey.
     * @param 	id Long
     * @return 	ValueAliasSet
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ValueAliasSet handle( FindValueAliasSetQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getValueAliasSetId() );
    }
    
    /**
     * Method to retrieve a collection of all ValueAliasSets
     *
     * @param	query	FindAllValueAliasSetQuery 
     * @return 	List<ValueAliasSet> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ValueAliasSet> handle( FindAllValueAliasSetQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindValueAliasSet, 
	 * but only if the id matches
	 * 
	 * @param		entity	ValueAliasSet
	 */
	protected void emitFindValueAliasSet( ValueAliasSet entity ) {
		LOGGER.info("handling emitFindValueAliasSet" );
		
	    queryUpdateEmitter.emit(FindValueAliasSetQuery.class,
	                            query -> query.getFilter().getValueAliasSetId().equals(entity.getValueAliasSetId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllValueAliasSet
	 * 
	 * @param		entity	ValueAliasSet
	 */
	protected void emitFindAllValueAliasSet( ValueAliasSet entity ) {
		LOGGER.info("handling emitFindAllValueAliasSet" );
		
	    queryUpdateEmitter.emit(FindAllValueAliasSetQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ValueAliasSetProjector.class.getName());

}
