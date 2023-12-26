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
 * Projector for StateVariablesVersion as outlined for the CQRS pattern.  All event handling and query handling related to StateVariablesVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by StateVariablesVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("stateVariablesVersion")
@Component("stateVariablesVersion-projector")
public class StateVariablesVersionProjector extends StateVariablesVersionEntityProjector {
		
	// core constructor
	public StateVariablesVersionProjector(StateVariablesVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateStateVariablesVersionEvent
     */
    @EventHandler( payloadType=CreateStateVariablesVersionEvent.class )
    public void handle( CreateStateVariablesVersionEvent event) {
	    LOGGER.info("handling CreateStateVariablesVersionEvent - " + event );
	    StateVariablesVersion entity = new StateVariablesVersion();
        entity.setStateVariablesVersionId( event.getStateVariablesVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStateVariablesVersion( entity );
    }

    /*
     * @param	event UpdateStateVariablesVersionEvent
     */
    @EventHandler( payloadType=UpdateStateVariablesVersionEvent.class )
    public void handle( UpdateStateVariablesVersionEvent event) {
    	LOGGER.info("handling UpdateStateVariablesVersionEvent - " + event );
    	
	    StateVariablesVersion entity = new StateVariablesVersion();
        entity.setStateVariablesVersionId( event.getStateVariablesVersionId() );
        entity.setBaseUML( event.getBaseUML() );
        entity.setBaseURI( event.getBaseURI() );
        entity.setDate( event.getDate() );
        entity.setDifferenceModelURI( event.getDifferenceModelURI() );
        entity.setEntsoeUML( event.getEntsoeUML() );
        entity.setEntsoeURI( event.getEntsoeURI() );
        entity.setModelDescriptionURI( event.getModelDescriptionURI() );
        entity.setNamespaceRDF( event.getNamespaceRDF() );
        entity.setNamespaceUML( event.getNamespaceUML() );
        entity.setShortName( event.getShortName() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindStateVariablesVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStateVariablesVersion( entity );        
    }
    
    /*
     * @param	event DeleteStateVariablesVersionEvent
     */
    @EventHandler( payloadType=DeleteStateVariablesVersionEvent.class )
    public void handle( DeleteStateVariablesVersionEvent event) {
    	LOGGER.info("handling DeleteStateVariablesVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	StateVariablesVersion entity = delete( event.getStateVariablesVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllStateVariablesVersion( entity );

    }    




    /**
     * Method to retrieve the StateVariablesVersion via an StateVariablesVersionPrimaryKey.
     * @param 	id Long
     * @return 	StateVariablesVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public StateVariablesVersion handle( FindStateVariablesVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getStateVariablesVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all StateVariablesVersions
     *
     * @param	query	FindAllStateVariablesVersionQuery 
     * @return 	List<StateVariablesVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<StateVariablesVersion> handle( FindAllStateVariablesVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindStateVariablesVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	StateVariablesVersion
	 */
	protected void emitFindStateVariablesVersion( StateVariablesVersion entity ) {
		LOGGER.info("handling emitFindStateVariablesVersion" );
		
	    queryUpdateEmitter.emit(FindStateVariablesVersionQuery.class,
	                            query -> query.getFilter().getStateVariablesVersionId().equals(entity.getStateVariablesVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllStateVariablesVersion
	 * 
	 * @param		entity	StateVariablesVersion
	 */
	protected void emitFindAllStateVariablesVersion( StateVariablesVersion entity ) {
		LOGGER.info("handling emitFindAllStateVariablesVersion" );
		
	    queryUpdateEmitter.emit(FindAllStateVariablesVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(StateVariablesVersionProjector.class.getName());

}
