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
 * Projector for WindDynamicsLookupTable as outlined for the CQRS pattern.  All event handling and query handling related to WindDynamicsLookupTable are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by WindDynamicsLookupTableAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("windDynamicsLookupTable")
@Component("windDynamicsLookupTable-projector")
public class WindDynamicsLookupTableProjector extends WindDynamicsLookupTableEntityProjector {
		
	// core constructor
	public WindDynamicsLookupTableProjector(WindDynamicsLookupTableRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateWindDynamicsLookupTableEvent
     */
    @EventHandler( payloadType=CreateWindDynamicsLookupTableEvent.class )
    public void handle( CreateWindDynamicsLookupTableEvent event) {
	    LOGGER.info("handling CreateWindDynamicsLookupTableEvent - " + event );
	    WindDynamicsLookupTable entity = new WindDynamicsLookupTable();
        entity.setWindDynamicsLookupTableId( event.getWindDynamicsLookupTableId() );
        entity.setInput( event.getInput() );
        entity.setLookupTableFunctionType( event.getLookupTableFunctionType() );
        entity.setOutput( event.getOutput() );
        entity.setSequence( event.getSequence() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindDynamicsLookupTable( entity );
    }

    /*
     * @param	event UpdateWindDynamicsLookupTableEvent
     */
    @EventHandler( payloadType=UpdateWindDynamicsLookupTableEvent.class )
    public void handle( UpdateWindDynamicsLookupTableEvent event) {
    	LOGGER.info("handling UpdateWindDynamicsLookupTableEvent - " + event );
    	
	    WindDynamicsLookupTable entity = new WindDynamicsLookupTable();
        entity.setWindDynamicsLookupTableId( event.getWindDynamicsLookupTableId() );
        entity.setInput( event.getInput() );
        entity.setLookupTableFunctionType( event.getLookupTableFunctionType() );
        entity.setOutput( event.getOutput() );
        entity.setSequence( event.getSequence() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindWindDynamicsLookupTable( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindDynamicsLookupTable( entity );        
    }
    
    /*
     * @param	event DeleteWindDynamicsLookupTableEvent
     */
    @EventHandler( payloadType=DeleteWindDynamicsLookupTableEvent.class )
    public void handle( DeleteWindDynamicsLookupTableEvent event) {
    	LOGGER.info("handling DeleteWindDynamicsLookupTableEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	WindDynamicsLookupTable entity = delete( event.getWindDynamicsLookupTableId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllWindDynamicsLookupTable( entity );

    }    




    /**
     * Method to retrieve the WindDynamicsLookupTable via an WindDynamicsLookupTablePrimaryKey.
     * @param 	id Long
     * @return 	WindDynamicsLookupTable
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public WindDynamicsLookupTable handle( FindWindDynamicsLookupTableQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getWindDynamicsLookupTableId() );
    }
    
    /**
     * Method to retrieve a collection of all WindDynamicsLookupTables
     *
     * @param	query	FindAllWindDynamicsLookupTableQuery 
     * @return 	List<WindDynamicsLookupTable> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<WindDynamicsLookupTable> handle( FindAllWindDynamicsLookupTableQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindWindDynamicsLookupTable, 
	 * but only if the id matches
	 * 
	 * @param		entity	WindDynamicsLookupTable
	 */
	protected void emitFindWindDynamicsLookupTable( WindDynamicsLookupTable entity ) {
		LOGGER.info("handling emitFindWindDynamicsLookupTable" );
		
	    queryUpdateEmitter.emit(FindWindDynamicsLookupTableQuery.class,
	                            query -> query.getFilter().getWindDynamicsLookupTableId().equals(entity.getWindDynamicsLookupTableId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllWindDynamicsLookupTable
	 * 
	 * @param		entity	WindDynamicsLookupTable
	 */
	protected void emitFindAllWindDynamicsLookupTable( WindDynamicsLookupTable entity ) {
		LOGGER.info("handling emitFindAllWindDynamicsLookupTable" );
		
	    queryUpdateEmitter.emit(FindAllWindDynamicsLookupTableQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(WindDynamicsLookupTableProjector.class.getName());

}
