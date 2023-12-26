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
 * Projector for ProprietaryParameterDynamics as outlined for the CQRS pattern.  All event handling and query handling related to ProprietaryParameterDynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by ProprietaryParameterDynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("proprietaryParameterDynamics")
@Component("proprietaryParameterDynamics-projector")
public class ProprietaryParameterDynamicsProjector extends ProprietaryParameterDynamicsEntityProjector {
		
	// core constructor
	public ProprietaryParameterDynamicsProjector(ProprietaryParameterDynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateProprietaryParameterDynamicsEvent
     */
    @EventHandler( payloadType=CreateProprietaryParameterDynamicsEvent.class )
    public void handle( CreateProprietaryParameterDynamicsEvent event) {
	    LOGGER.info("handling CreateProprietaryParameterDynamicsEvent - " + event );
	    ProprietaryParameterDynamics entity = new ProprietaryParameterDynamics();
        entity.setProprietaryParameterDynamicsId( event.getProprietaryParameterDynamicsId() );
        entity.setBooleanParameterValue( event.getBooleanParameterValue() );
        entity.setFloatParameterValue( event.getFloatParameterValue() );
        entity.setIntegerParameterValue( event.getIntegerParameterValue() );
        entity.setParameterNumber( event.getParameterNumber() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProprietaryParameterDynamics( entity );
    }

    /*
     * @param	event UpdateProprietaryParameterDynamicsEvent
     */
    @EventHandler( payloadType=UpdateProprietaryParameterDynamicsEvent.class )
    public void handle( UpdateProprietaryParameterDynamicsEvent event) {
    	LOGGER.info("handling UpdateProprietaryParameterDynamicsEvent - " + event );
    	
	    ProprietaryParameterDynamics entity = new ProprietaryParameterDynamics();
        entity.setProprietaryParameterDynamicsId( event.getProprietaryParameterDynamicsId() );
        entity.setBooleanParameterValue( event.getBooleanParameterValue() );
        entity.setFloatParameterValue( event.getFloatParameterValue() );
        entity.setIntegerParameterValue( event.getIntegerParameterValue() );
        entity.setParameterNumber( event.getParameterNumber() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindProprietaryParameterDynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProprietaryParameterDynamics( entity );        
    }
    
    /*
     * @param	event DeleteProprietaryParameterDynamicsEvent
     */
    @EventHandler( payloadType=DeleteProprietaryParameterDynamicsEvent.class )
    public void handle( DeleteProprietaryParameterDynamicsEvent event) {
    	LOGGER.info("handling DeleteProprietaryParameterDynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	ProprietaryParameterDynamics entity = delete( event.getProprietaryParameterDynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllProprietaryParameterDynamics( entity );

    }    




    /**
     * Method to retrieve the ProprietaryParameterDynamics via an ProprietaryParameterDynamicsPrimaryKey.
     * @param 	id Long
     * @return 	ProprietaryParameterDynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public ProprietaryParameterDynamics handle( FindProprietaryParameterDynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getProprietaryParameterDynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all ProprietaryParameterDynamicss
     *
     * @param	query	FindAllProprietaryParameterDynamicsQuery 
     * @return 	List<ProprietaryParameterDynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<ProprietaryParameterDynamics> handle( FindAllProprietaryParameterDynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindProprietaryParameterDynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	ProprietaryParameterDynamics
	 */
	protected void emitFindProprietaryParameterDynamics( ProprietaryParameterDynamics entity ) {
		LOGGER.info("handling emitFindProprietaryParameterDynamics" );
		
	    queryUpdateEmitter.emit(FindProprietaryParameterDynamicsQuery.class,
	                            query -> query.getFilter().getProprietaryParameterDynamicsId().equals(entity.getProprietaryParameterDynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllProprietaryParameterDynamics
	 * 
	 * @param		entity	ProprietaryParameterDynamics
	 */
	protected void emitFindAllProprietaryParameterDynamics( ProprietaryParameterDynamics entity ) {
		LOGGER.info("handling emitFindAllProprietaryParameterDynamics" );
		
	    queryUpdateEmitter.emit(FindAllProprietaryParameterDynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(ProprietaryParameterDynamicsProjector.class.getName());

}
