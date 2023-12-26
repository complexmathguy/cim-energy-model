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
 * Projector for EquivalentInjection as outlined for the CQRS pattern.  All event handling and query handling related to EquivalentInjection are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by EquivalentInjectionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("equivalentInjection")
@Component("equivalentInjection-projector")
public class EquivalentInjectionProjector extends EquivalentInjectionEntityProjector {
		
	// core constructor
	public EquivalentInjectionProjector(EquivalentInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateEquivalentInjectionEvent
     */
    @EventHandler( payloadType=CreateEquivalentInjectionEvent.class )
    public void handle( CreateEquivalentInjectionEvent event) {
	    LOGGER.info("handling CreateEquivalentInjectionEvent - " + event );
	    EquivalentInjection entity = new EquivalentInjection();
        entity.setEquivalentInjectionId( event.getEquivalentInjectionId() );
        entity.setMaxP( event.getMaxP() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMinP( event.getMinP() );
        entity.setMinQ( event.getMinQ() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setR2( event.getR2() );
        entity.setRegulationCapability( event.getRegulationCapability() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
        entity.setX2( event.getX2() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentInjection( entity );
    }

    /*
     * @param	event UpdateEquivalentInjectionEvent
     */
    @EventHandler( payloadType=UpdateEquivalentInjectionEvent.class )
    public void handle( UpdateEquivalentInjectionEvent event) {
    	LOGGER.info("handling UpdateEquivalentInjectionEvent - " + event );
    	
	    EquivalentInjection entity = new EquivalentInjection();
        entity.setEquivalentInjectionId( event.getEquivalentInjectionId() );
        entity.setMaxP( event.getMaxP() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMinP( event.getMinP() );
        entity.setMinQ( event.getMinQ() );
        entity.setR( event.getR() );
        entity.setR0( event.getR0() );
        entity.setR2( event.getR2() );
        entity.setRegulationCapability( event.getRegulationCapability() );
        entity.setX( event.getX() );
        entity.setX0( event.getX0() );
        entity.setX2( event.getX2() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindEquivalentInjection( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentInjection( entity );        
    }
    
    /*
     * @param	event DeleteEquivalentInjectionEvent
     */
    @EventHandler( payloadType=DeleteEquivalentInjectionEvent.class )
    public void handle( DeleteEquivalentInjectionEvent event) {
    	LOGGER.info("handling DeleteEquivalentInjectionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	EquivalentInjection entity = delete( event.getEquivalentInjectionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllEquivalentInjection( entity );

    }    




    /**
     * Method to retrieve the EquivalentInjection via an EquivalentInjectionPrimaryKey.
     * @param 	id Long
     * @return 	EquivalentInjection
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public EquivalentInjection handle( FindEquivalentInjectionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getEquivalentInjectionId() );
    }
    
    /**
     * Method to retrieve a collection of all EquivalentInjections
     *
     * @param	query	FindAllEquivalentInjectionQuery 
     * @return 	List<EquivalentInjection> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<EquivalentInjection> handle( FindAllEquivalentInjectionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindEquivalentInjection, 
	 * but only if the id matches
	 * 
	 * @param		entity	EquivalentInjection
	 */
	protected void emitFindEquivalentInjection( EquivalentInjection entity ) {
		LOGGER.info("handling emitFindEquivalentInjection" );
		
	    queryUpdateEmitter.emit(FindEquivalentInjectionQuery.class,
	                            query -> query.getFilter().getEquivalentInjectionId().equals(entity.getEquivalentInjectionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllEquivalentInjection
	 * 
	 * @param		entity	EquivalentInjection
	 */
	protected void emitFindAllEquivalentInjection( EquivalentInjection entity ) {
		LOGGER.info("handling emitFindAllEquivalentInjection" );
		
	    queryUpdateEmitter.emit(FindAllEquivalentInjectionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(EquivalentInjectionProjector.class.getName());

}
