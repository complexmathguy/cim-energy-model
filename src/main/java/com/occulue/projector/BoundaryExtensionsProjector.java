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
 * Projector for BoundaryExtensions as outlined for the CQRS pattern.  All event handling and query handling related to BoundaryExtensions are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by BoundaryExtensionsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("boundaryExtensions")
@Component("boundaryExtensions-projector")
public class BoundaryExtensionsProjector extends BoundaryExtensionsEntityProjector {
		
	// core constructor
	public BoundaryExtensionsProjector(BoundaryExtensionsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateBoundaryExtensionsEvent
     */
    @EventHandler( payloadType=CreateBoundaryExtensionsEvent.class )
    public void handle( CreateBoundaryExtensionsEvent event) {
	    LOGGER.info("handling CreateBoundaryExtensionsEvent - " + event );
	    BoundaryExtensions entity = new BoundaryExtensions();
        entity.setBoundaryExtensionsId( event.getBoundaryExtensionsId() );
        entity.setBoundaryPoint( event.getBoundaryPoint() );
        entity.setFromEndIsoCode( event.getFromEndIsoCode() );
        entity.setFromEndName( event.getFromEndName() );
        entity.setFromEndNameTso( event.getFromEndNameTso() );
        entity.setToEndIsoCode( event.getToEndIsoCode() );
        entity.setToEndName( event.getToEndName() );
        entity.setToEndNameTso( event.getToEndNameTso() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBoundaryExtensions( entity );
    }

    /*
     * @param	event UpdateBoundaryExtensionsEvent
     */
    @EventHandler( payloadType=UpdateBoundaryExtensionsEvent.class )
    public void handle( UpdateBoundaryExtensionsEvent event) {
    	LOGGER.info("handling UpdateBoundaryExtensionsEvent - " + event );
    	
	    BoundaryExtensions entity = new BoundaryExtensions();
        entity.setBoundaryExtensionsId( event.getBoundaryExtensionsId() );
        entity.setBoundaryPoint( event.getBoundaryPoint() );
        entity.setFromEndIsoCode( event.getFromEndIsoCode() );
        entity.setFromEndName( event.getFromEndName() );
        entity.setFromEndNameTso( event.getFromEndNameTso() );
        entity.setToEndIsoCode( event.getToEndIsoCode() );
        entity.setToEndName( event.getToEndName() );
        entity.setToEndNameTso( event.getToEndNameTso() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindBoundaryExtensions( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBoundaryExtensions( entity );        
    }
    
    /*
     * @param	event DeleteBoundaryExtensionsEvent
     */
    @EventHandler( payloadType=DeleteBoundaryExtensionsEvent.class )
    public void handle( DeleteBoundaryExtensionsEvent event) {
    	LOGGER.info("handling DeleteBoundaryExtensionsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	BoundaryExtensions entity = delete( event.getBoundaryExtensionsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllBoundaryExtensions( entity );

    }    




    /**
     * Method to retrieve the BoundaryExtensions via an BoundaryExtensionsPrimaryKey.
     * @param 	id Long
     * @return 	BoundaryExtensions
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public BoundaryExtensions handle( FindBoundaryExtensionsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getBoundaryExtensionsId() );
    }
    
    /**
     * Method to retrieve a collection of all BoundaryExtensionss
     *
     * @param	query	FindAllBoundaryExtensionsQuery 
     * @return 	List<BoundaryExtensions> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<BoundaryExtensions> handle( FindAllBoundaryExtensionsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindBoundaryExtensions, 
	 * but only if the id matches
	 * 
	 * @param		entity	BoundaryExtensions
	 */
	protected void emitFindBoundaryExtensions( BoundaryExtensions entity ) {
		LOGGER.info("handling emitFindBoundaryExtensions" );
		
	    queryUpdateEmitter.emit(FindBoundaryExtensionsQuery.class,
	                            query -> query.getFilter().getBoundaryExtensionsId().equals(entity.getBoundaryExtensionsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllBoundaryExtensions
	 * 
	 * @param		entity	BoundaryExtensions
	 */
	protected void emitFindAllBoundaryExtensions( BoundaryExtensions entity ) {
		LOGGER.info("handling emitFindAllBoundaryExtensions" );
		
	    queryUpdateEmitter.emit(FindAllBoundaryExtensionsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(BoundaryExtensionsProjector.class.getName());

}
