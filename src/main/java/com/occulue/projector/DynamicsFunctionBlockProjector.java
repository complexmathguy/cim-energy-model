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
 * Projector for DynamicsFunctionBlock as outlined for the CQRS pattern.  All event handling and query handling related to DynamicsFunctionBlock are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by DynamicsFunctionBlockAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("dynamicsFunctionBlock")
@Component("dynamicsFunctionBlock-projector")
public class DynamicsFunctionBlockProjector extends DynamicsFunctionBlockEntityProjector {
		
	// core constructor
	public DynamicsFunctionBlockProjector(DynamicsFunctionBlockRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateDynamicsFunctionBlockEvent
     */
    @EventHandler( payloadType=CreateDynamicsFunctionBlockEvent.class )
    public void handle( CreateDynamicsFunctionBlockEvent event) {
	    LOGGER.info("handling CreateDynamicsFunctionBlockEvent - " + event );
	    DynamicsFunctionBlock entity = new DynamicsFunctionBlock();
        entity.setDynamicsFunctionBlockId( event.getDynamicsFunctionBlockId() );
        entity.setEnabled( event.getEnabled() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsFunctionBlock( entity );
    }

    /*
     * @param	event UpdateDynamicsFunctionBlockEvent
     */
    @EventHandler( payloadType=UpdateDynamicsFunctionBlockEvent.class )
    public void handle( UpdateDynamicsFunctionBlockEvent event) {
    	LOGGER.info("handling UpdateDynamicsFunctionBlockEvent - " + event );
    	
	    DynamicsFunctionBlock entity = new DynamicsFunctionBlock();
        entity.setDynamicsFunctionBlockId( event.getDynamicsFunctionBlockId() );
        entity.setEnabled( event.getEnabled() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindDynamicsFunctionBlock( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsFunctionBlock( entity );        
    }
    
    /*
     * @param	event DeleteDynamicsFunctionBlockEvent
     */
    @EventHandler( payloadType=DeleteDynamicsFunctionBlockEvent.class )
    public void handle( DeleteDynamicsFunctionBlockEvent event) {
    	LOGGER.info("handling DeleteDynamicsFunctionBlockEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	DynamicsFunctionBlock entity = delete( event.getDynamicsFunctionBlockId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllDynamicsFunctionBlock( entity );

    }    




    /**
     * Method to retrieve the DynamicsFunctionBlock via an DynamicsFunctionBlockPrimaryKey.
     * @param 	id Long
     * @return 	DynamicsFunctionBlock
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public DynamicsFunctionBlock handle( FindDynamicsFunctionBlockQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getDynamicsFunctionBlockId() );
    }
    
    /**
     * Method to retrieve a collection of all DynamicsFunctionBlocks
     *
     * @param	query	FindAllDynamicsFunctionBlockQuery 
     * @return 	List<DynamicsFunctionBlock> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<DynamicsFunctionBlock> handle( FindAllDynamicsFunctionBlockQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindDynamicsFunctionBlock, 
	 * but only if the id matches
	 * 
	 * @param		entity	DynamicsFunctionBlock
	 */
	protected void emitFindDynamicsFunctionBlock( DynamicsFunctionBlock entity ) {
		LOGGER.info("handling emitFindDynamicsFunctionBlock" );
		
	    queryUpdateEmitter.emit(FindDynamicsFunctionBlockQuery.class,
	                            query -> query.getFilter().getDynamicsFunctionBlockId().equals(entity.getDynamicsFunctionBlockId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllDynamicsFunctionBlock
	 * 
	 * @param		entity	DynamicsFunctionBlock
	 */
	protected void emitFindAllDynamicsFunctionBlock( DynamicsFunctionBlock entity ) {
		LOGGER.info("handling emitFindAllDynamicsFunctionBlock" );
		
	    queryUpdateEmitter.emit(FindAllDynamicsFunctionBlockQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(DynamicsFunctionBlockProjector.class.getName());

}
