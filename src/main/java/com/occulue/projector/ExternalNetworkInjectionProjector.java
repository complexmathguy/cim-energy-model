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
 * Projector for ExternalNetworkInjection as outlined for the CQRS pattern.  All event handling and query handling related to ExternalNetworkInjection are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ExternalNetworkInjectionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("externalNetworkInjection")
@Component("externalNetworkInjection-projector")
public class ExternalNetworkInjectionProjector extends ExternalNetworkInjectionEntityProjector {
		
	// core constructor
	public ExternalNetworkInjectionProjector(ExternalNetworkInjectionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateExternalNetworkInjectionEvent
     */
    @EventHandler( payloadType=CreateExternalNetworkInjectionEvent.class )
    public void handle( CreateExternalNetworkInjectionEvent event) {
	    LOGGER.info("handling CreateExternalNetworkInjectionEvent - " + event );
	    ExternalNetworkInjection entity = new ExternalNetworkInjection();
        entity.setExternalNetworkInjectionId( event.getExternalNetworkInjectionId() );
        entity.setGovernorSCD( event.getGovernorSCD() );
        entity.setIkSecond( event.getIkSecond() );
        entity.setMaxInitialSymShCCurrent( event.getMaxInitialSymShCCurrent() );
        entity.setMaxP( event.getMaxP() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMaxR0ToX0Ratio( event.getMaxR0ToX0Ratio() );
        entity.setMaxR1ToX1Ratio( event.getMaxR1ToX1Ratio() );
        entity.setMaxZ0ToZ1Ratio( event.getMaxZ0ToZ1Ratio() );
        entity.setMinInitialSymShCCurrent( event.getMinInitialSymShCCurrent() );
        entity.setMinP( event.getMinP() );
        entity.setMinQ( event.getMinQ() );
        entity.setMinR0ToX0Ratio( event.getMinR0ToX0Ratio() );
        entity.setMinR1ToX1Ratio( event.getMinR1ToX1Ratio() );
        entity.setMinZ0ToZ1Ratio( event.getMinZ0ToZ1Ratio() );
        entity.setVoltageFactor( event.getVoltageFactor() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExternalNetworkInjection( entity );
    }

    /*
     * @param	event UpdateExternalNetworkInjectionEvent
     */
    @EventHandler( payloadType=UpdateExternalNetworkInjectionEvent.class )
    public void handle( UpdateExternalNetworkInjectionEvent event) {
    	LOGGER.info("handling UpdateExternalNetworkInjectionEvent - " + event );
    	
	    ExternalNetworkInjection entity = new ExternalNetworkInjection();
        entity.setExternalNetworkInjectionId( event.getExternalNetworkInjectionId() );
        entity.setGovernorSCD( event.getGovernorSCD() );
        entity.setIkSecond( event.getIkSecond() );
        entity.setMaxInitialSymShCCurrent( event.getMaxInitialSymShCCurrent() );
        entity.setMaxP( event.getMaxP() );
        entity.setMaxQ( event.getMaxQ() );
        entity.setMaxR0ToX0Ratio( event.getMaxR0ToX0Ratio() );
        entity.setMaxR1ToX1Ratio( event.getMaxR1ToX1Ratio() );
        entity.setMaxZ0ToZ1Ratio( event.getMaxZ0ToZ1Ratio() );
        entity.setMinInitialSymShCCurrent( event.getMinInitialSymShCCurrent() );
        entity.setMinP( event.getMinP() );
        entity.setMinQ( event.getMinQ() );
        entity.setMinR0ToX0Ratio( event.getMinR0ToX0Ratio() );
        entity.setMinR1ToX1Ratio( event.getMinR1ToX1Ratio() );
        entity.setMinZ0ToZ1Ratio( event.getMinZ0ToZ1Ratio() );
        entity.setVoltageFactor( event.getVoltageFactor() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindExternalNetworkInjection( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExternalNetworkInjection( entity );        
    }
    
    /*
     * @param	event DeleteExternalNetworkInjectionEvent
     */
    @EventHandler( payloadType=DeleteExternalNetworkInjectionEvent.class )
    public void handle( DeleteExternalNetworkInjectionEvent event) {
    	LOGGER.info("handling DeleteExternalNetworkInjectionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ExternalNetworkInjection entity = delete( event.getExternalNetworkInjectionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllExternalNetworkInjection( entity );

    }    




    /**
     * Method to retrieve the ExternalNetworkInjection via an ExternalNetworkInjectionPrimaryKey.
     * @param 	id Long
     * @return 	ExternalNetworkInjection
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ExternalNetworkInjection handle( FindExternalNetworkInjectionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getExternalNetworkInjectionId() );
    }
    
    /**
     * Method to retrieve a collection of all ExternalNetworkInjections
     *
     * @param	query	FindAllExternalNetworkInjectionQuery 
     * @return 	List<ExternalNetworkInjection> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ExternalNetworkInjection> handle( FindAllExternalNetworkInjectionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindExternalNetworkInjection, 
	 * but only if the id matches
	 * 
	 * @param		entity	ExternalNetworkInjection
	 */
	protected void emitFindExternalNetworkInjection( ExternalNetworkInjection entity ) {
		LOGGER.info("handling emitFindExternalNetworkInjection" );
		
	    queryUpdateEmitter.emit(FindExternalNetworkInjectionQuery.class,
	                            query -> query.getFilter().getExternalNetworkInjectionId().equals(entity.getExternalNetworkInjectionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllExternalNetworkInjection
	 * 
	 * @param		entity	ExternalNetworkInjection
	 */
	protected void emitFindAllExternalNetworkInjection( ExternalNetworkInjection entity ) {
		LOGGER.info("handling emitFindAllExternalNetworkInjection" );
		
	    queryUpdateEmitter.emit(FindAllExternalNetworkInjectionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ExternalNetworkInjectionProjector.class.getName());

}
