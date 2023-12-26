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
 * Projector for VisibilityLayer as outlined for the CQRS pattern.  All event handling and query handling related to VisibilityLayer are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VisibilityLayerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("visibilityLayer")
@Component("visibilityLayer-projector")
public class VisibilityLayerProjector extends VisibilityLayerEntityProjector {
		
	// core constructor
	public VisibilityLayerProjector(VisibilityLayerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVisibilityLayerEvent
     */
    @EventHandler( payloadType=CreateVisibilityLayerEvent.class )
    public void handle( CreateVisibilityLayerEvent event) {
	    LOGGER.info("handling CreateVisibilityLayerEvent - " + event );
	    VisibilityLayer entity = new VisibilityLayer();
        entity.setVisibilityLayerId( event.getVisibilityLayerId() );
        entity.setDrawingOrder( event.getDrawingOrder() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVisibilityLayer( entity );
    }

    /*
     * @param	event UpdateVisibilityLayerEvent
     */
    @EventHandler( payloadType=UpdateVisibilityLayerEvent.class )
    public void handle( UpdateVisibilityLayerEvent event) {
    	LOGGER.info("handling UpdateVisibilityLayerEvent - " + event );
    	
	    VisibilityLayer entity = new VisibilityLayer();
        entity.setVisibilityLayerId( event.getVisibilityLayerId() );
        entity.setDrawingOrder( event.getDrawingOrder() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVisibilityLayer( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVisibilityLayer( entity );        
    }
    
    /*
     * @param	event DeleteVisibilityLayerEvent
     */
    @EventHandler( payloadType=DeleteVisibilityLayerEvent.class )
    public void handle( DeleteVisibilityLayerEvent event) {
    	LOGGER.info("handling DeleteVisibilityLayerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VisibilityLayer entity = delete( event.getVisibilityLayerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVisibilityLayer( entity );

    }    




    /**
     * Method to retrieve the VisibilityLayer via an VisibilityLayerPrimaryKey.
     * @param 	id Long
     * @return 	VisibilityLayer
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VisibilityLayer handle( FindVisibilityLayerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVisibilityLayerId() );
    }
    
    /**
     * Method to retrieve a collection of all VisibilityLayers
     *
     * @param	query	FindAllVisibilityLayerQuery 
     * @return 	List<VisibilityLayer> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VisibilityLayer> handle( FindAllVisibilityLayerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVisibilityLayer, 
	 * but only if the id matches
	 * 
	 * @param		entity	VisibilityLayer
	 */
	protected void emitFindVisibilityLayer( VisibilityLayer entity ) {
		LOGGER.info("handling emitFindVisibilityLayer" );
		
	    queryUpdateEmitter.emit(FindVisibilityLayerQuery.class,
	                            query -> query.getFilter().getVisibilityLayerId().equals(entity.getVisibilityLayerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVisibilityLayer
	 * 
	 * @param		entity	VisibilityLayer
	 */
	protected void emitFindAllVisibilityLayer( VisibilityLayer entity ) {
		LOGGER.info("handling emitFindAllVisibilityLayer" );
		
	    queryUpdateEmitter.emit(FindAllVisibilityLayerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VisibilityLayerProjector.class.getName());

}
