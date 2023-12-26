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
 * Projector for RatioTapChangerTable as outlined for the CQRS pattern.  All event handling and query handling related to RatioTapChangerTable are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by RatioTapChangerTableAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("ratioTapChangerTable")
@Component("ratioTapChangerTable-projector")
public class RatioTapChangerTableProjector extends RatioTapChangerTableEntityProjector {
		
	// core constructor
	public RatioTapChangerTableProjector(RatioTapChangerTableRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateRatioTapChangerTableEvent
     */
    @EventHandler( payloadType=CreateRatioTapChangerTableEvent.class )
    public void handle( CreateRatioTapChangerTableEvent event) {
	    LOGGER.info("handling CreateRatioTapChangerTableEvent - " + event );
	    RatioTapChangerTable entity = new RatioTapChangerTable();
        entity.setRatioTapChangerTableId( event.getRatioTapChangerTableId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChangerTable( entity );
    }

    /*
     * @param	event UpdateRatioTapChangerTableEvent
     */
    @EventHandler( payloadType=UpdateRatioTapChangerTableEvent.class )
    public void handle( UpdateRatioTapChangerTableEvent event) {
    	LOGGER.info("handling UpdateRatioTapChangerTableEvent - " + event );
    	
	    RatioTapChangerTable entity = new RatioTapChangerTable();
        entity.setRatioTapChangerTableId( event.getRatioTapChangerTableId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindRatioTapChangerTable( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChangerTable( entity );        
    }
    
    /*
     * @param	event DeleteRatioTapChangerTableEvent
     */
    @EventHandler( payloadType=DeleteRatioTapChangerTableEvent.class )
    public void handle( DeleteRatioTapChangerTableEvent event) {
    	LOGGER.info("handling DeleteRatioTapChangerTableEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	RatioTapChangerTable entity = delete( event.getRatioTapChangerTableId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllRatioTapChangerTable( entity );

    }    




    /**
     * Method to retrieve the RatioTapChangerTable via an RatioTapChangerTablePrimaryKey.
     * @param 	id Long
     * @return 	RatioTapChangerTable
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public RatioTapChangerTable handle( FindRatioTapChangerTableQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getRatioTapChangerTableId() );
    }
    
    /**
     * Method to retrieve a collection of all RatioTapChangerTables
     *
     * @param	query	FindAllRatioTapChangerTableQuery 
     * @return 	List<RatioTapChangerTable> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<RatioTapChangerTable> handle( FindAllRatioTapChangerTableQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindRatioTapChangerTable, 
	 * but only if the id matches
	 * 
	 * @param		entity	RatioTapChangerTable
	 */
	protected void emitFindRatioTapChangerTable( RatioTapChangerTable entity ) {
		LOGGER.info("handling emitFindRatioTapChangerTable" );
		
	    queryUpdateEmitter.emit(FindRatioTapChangerTableQuery.class,
	                            query -> query.getFilter().getRatioTapChangerTableId().equals(entity.getRatioTapChangerTableId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllRatioTapChangerTable
	 * 
	 * @param		entity	RatioTapChangerTable
	 */
	protected void emitFindAllRatioTapChangerTable( RatioTapChangerTable entity ) {
		LOGGER.info("handling emitFindAllRatioTapChangerTable" );
		
	    queryUpdateEmitter.emit(FindAllRatioTapChangerTableQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(RatioTapChangerTableProjector.class.getName());

}
