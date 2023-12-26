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
 * Projector for ValueToAlias as outlined for the CQRS pattern.  All event handling and query handling related to ValueToAlias are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ValueToAliasAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("valueToAlias")
@Component("valueToAlias-projector")
public class ValueToAliasProjector extends ValueToAliasEntityProjector {
		
	// core constructor
	public ValueToAliasProjector(ValueToAliasRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateValueToAliasEvent
     */
    @EventHandler( payloadType=CreateValueToAliasEvent.class )
    public void handle( CreateValueToAliasEvent event) {
	    LOGGER.info("handling CreateValueToAliasEvent - " + event );
	    ValueToAlias entity = new ValueToAlias();
        entity.setValueToAliasId( event.getValueToAliasId() );
        entity.setValue( event.getValue() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueToAlias( entity );
    }

    /*
     * @param	event UpdateValueToAliasEvent
     */
    @EventHandler( payloadType=UpdateValueToAliasEvent.class )
    public void handle( UpdateValueToAliasEvent event) {
    	LOGGER.info("handling UpdateValueToAliasEvent - " + event );
    	
	    ValueToAlias entity = new ValueToAlias();
        entity.setValueToAliasId( event.getValueToAliasId() );
        entity.setValue( event.getValue() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindValueToAlias( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueToAlias( entity );        
    }
    
    /*
     * @param	event DeleteValueToAliasEvent
     */
    @EventHandler( payloadType=DeleteValueToAliasEvent.class )
    public void handle( DeleteValueToAliasEvent event) {
    	LOGGER.info("handling DeleteValueToAliasEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ValueToAlias entity = delete( event.getValueToAliasId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllValueToAlias( entity );

    }    




    /**
     * Method to retrieve the ValueToAlias via an ValueToAliasPrimaryKey.
     * @param 	id Long
     * @return 	ValueToAlias
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ValueToAlias handle( FindValueToAliasQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getValueToAliasId() );
    }
    
    /**
     * Method to retrieve a collection of all ValueToAliass
     *
     * @param	query	FindAllValueToAliasQuery 
     * @return 	List<ValueToAlias> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ValueToAlias> handle( FindAllValueToAliasQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindValueToAlias, 
	 * but only if the id matches
	 * 
	 * @param		entity	ValueToAlias
	 */
	protected void emitFindValueToAlias( ValueToAlias entity ) {
		LOGGER.info("handling emitFindValueToAlias" );
		
	    queryUpdateEmitter.emit(FindValueToAliasQuery.class,
	                            query -> query.getFilter().getValueToAliasId().equals(entity.getValueToAliasId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllValueToAlias
	 * 
	 * @param		entity	ValueToAlias
	 */
	protected void emitFindAllValueToAlias( ValueToAlias entity ) {
		LOGGER.info("handling emitFindAllValueToAlias" );
		
	    queryUpdateEmitter.emit(FindAllValueToAliasQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ValueToAliasProjector.class.getName());

}
