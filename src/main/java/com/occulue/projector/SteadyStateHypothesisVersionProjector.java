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
 * Projector for SteadyStateHypothesisVersion as outlined for the CQRS pattern.  All event handling and query handling related to SteadyStateHypothesisVersion are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by SteadyStateHypothesisVersionAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("steadyStateHypothesisVersion")
@Component("steadyStateHypothesisVersion-projector")
public class SteadyStateHypothesisVersionProjector extends SteadyStateHypothesisVersionEntityProjector {
		
	// core constructor
	public SteadyStateHypothesisVersionProjector(SteadyStateHypothesisVersionRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateSteadyStateHypothesisVersionEvent
     */
    @EventHandler( payloadType=CreateSteadyStateHypothesisVersionEvent.class )
    public void handle( CreateSteadyStateHypothesisVersionEvent event) {
	    LOGGER.info("handling CreateSteadyStateHypothesisVersionEvent - " + event );
	    SteadyStateHypothesisVersion entity = new SteadyStateHypothesisVersion();
        entity.setSteadyStateHypothesisVersionId( event.getSteadyStateHypothesisVersionId() );
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
        emitFindAllSteadyStateHypothesisVersion( entity );
    }

    /*
     * @param	event UpdateSteadyStateHypothesisVersionEvent
     */
    @EventHandler( payloadType=UpdateSteadyStateHypothesisVersionEvent.class )
    public void handle( UpdateSteadyStateHypothesisVersionEvent event) {
    	LOGGER.info("handling UpdateSteadyStateHypothesisVersionEvent - " + event );
    	
	    SteadyStateHypothesisVersion entity = new SteadyStateHypothesisVersion();
        entity.setSteadyStateHypothesisVersionId( event.getSteadyStateHypothesisVersionId() );
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
        emitFindSteadyStateHypothesisVersion( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSteadyStateHypothesisVersion( entity );        
    }
    
    /*
     * @param	event DeleteSteadyStateHypothesisVersionEvent
     */
    @EventHandler( payloadType=DeleteSteadyStateHypothesisVersionEvent.class )
    public void handle( DeleteSteadyStateHypothesisVersionEvent event) {
    	LOGGER.info("handling DeleteSteadyStateHypothesisVersionEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	SteadyStateHypothesisVersion entity = delete( event.getSteadyStateHypothesisVersionId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllSteadyStateHypothesisVersion( entity );

    }    




    /**
     * Method to retrieve the SteadyStateHypothesisVersion via an SteadyStateHypothesisVersionPrimaryKey.
     * @param 	id Long
     * @return 	SteadyStateHypothesisVersion
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public SteadyStateHypothesisVersion handle( FindSteadyStateHypothesisVersionQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getSteadyStateHypothesisVersionId() );
    }
    
    /**
     * Method to retrieve a collection of all SteadyStateHypothesisVersions
     *
     * @param	query	FindAllSteadyStateHypothesisVersionQuery 
     * @return 	List<SteadyStateHypothesisVersion> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<SteadyStateHypothesisVersion> handle( FindAllSteadyStateHypothesisVersionQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindSteadyStateHypothesisVersion, 
	 * but only if the id matches
	 * 
	 * @param		entity	SteadyStateHypothesisVersion
	 */
	protected void emitFindSteadyStateHypothesisVersion( SteadyStateHypothesisVersion entity ) {
		LOGGER.info("handling emitFindSteadyStateHypothesisVersion" );
		
	    queryUpdateEmitter.emit(FindSteadyStateHypothesisVersionQuery.class,
	                            query -> query.getFilter().getSteadyStateHypothesisVersionId().equals(entity.getSteadyStateHypothesisVersionId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllSteadyStateHypothesisVersion
	 * 
	 * @param		entity	SteadyStateHypothesisVersion
	 */
	protected void emitFindAllSteadyStateHypothesisVersion( SteadyStateHypothesisVersion entity ) {
		LOGGER.info("handling emitFindAllSteadyStateHypothesisVersion" );
		
	    queryUpdateEmitter.emit(FindAllSteadyStateHypothesisVersionQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(SteadyStateHypothesisVersionProjector.class.getName());

}
