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
 * Projector for PFVArControllerType2UserDefined as outlined for the CQRS pattern.  All event handling and query handling related to PFVArControllerType2UserDefined are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArControllerType2UserDefinedAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArControllerType2UserDefined")
@Component("pFVArControllerType2UserDefined-projector")
public class PFVArControllerType2UserDefinedProjector extends PFVArControllerType2UserDefinedEntityProjector {
		
	// core constructor
	public PFVArControllerType2UserDefinedProjector(PFVArControllerType2UserDefinedRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArControllerType2UserDefinedEvent
     */
    @EventHandler( payloadType=CreatePFVArControllerType2UserDefinedEvent.class )
    public void handle( CreatePFVArControllerType2UserDefinedEvent event) {
	    LOGGER.info("handling CreatePFVArControllerType2UserDefinedEvent - " + event );
	    PFVArControllerType2UserDefined entity = new PFVArControllerType2UserDefined();
        entity.setPFVArControllerType2UserDefinedId( event.getPFVArControllerType2UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2UserDefined( entity );
    }

    /*
     * @param	event UpdatePFVArControllerType2UserDefinedEvent
     */
    @EventHandler( payloadType=UpdatePFVArControllerType2UserDefinedEvent.class )
    public void handle( UpdatePFVArControllerType2UserDefinedEvent event) {
    	LOGGER.info("handling UpdatePFVArControllerType2UserDefinedEvent - " + event );
    	
	    PFVArControllerType2UserDefined entity = new PFVArControllerType2UserDefined();
        entity.setPFVArControllerType2UserDefinedId( event.getPFVArControllerType2UserDefinedId() );
        entity.setProprietary( event.getProprietary() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArControllerType2UserDefined( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2UserDefined( entity );        
    }
    
    /*
     * @param	event DeletePFVArControllerType2UserDefinedEvent
     */
    @EventHandler( payloadType=DeletePFVArControllerType2UserDefinedEvent.class )
    public void handle( DeletePFVArControllerType2UserDefinedEvent event) {
    	LOGGER.info("handling DeletePFVArControllerType2UserDefinedEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArControllerType2UserDefined entity = delete( event.getPFVArControllerType2UserDefinedId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2UserDefined( entity );

    }    




    /**
     * Method to retrieve the PFVArControllerType2UserDefined via an PFVArControllerType2UserDefinedPrimaryKey.
     * @param 	id Long
     * @return 	PFVArControllerType2UserDefined
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArControllerType2UserDefined handle( FindPFVArControllerType2UserDefinedQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArControllerType2UserDefinedId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArControllerType2UserDefineds
     *
     * @param	query	FindAllPFVArControllerType2UserDefinedQuery 
     * @return 	List<PFVArControllerType2UserDefined> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArControllerType2UserDefined> handle( FindAllPFVArControllerType2UserDefinedQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArControllerType2UserDefined, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArControllerType2UserDefined
	 */
	protected void emitFindPFVArControllerType2UserDefined( PFVArControllerType2UserDefined entity ) {
		LOGGER.info("handling emitFindPFVArControllerType2UserDefined" );
		
	    queryUpdateEmitter.emit(FindPFVArControllerType2UserDefinedQuery.class,
	                            query -> query.getFilter().getPFVArControllerType2UserDefinedId().equals(entity.getPFVArControllerType2UserDefinedId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArControllerType2UserDefined
	 * 
	 * @param		entity	PFVArControllerType2UserDefined
	 */
	protected void emitFindAllPFVArControllerType2UserDefined( PFVArControllerType2UserDefined entity ) {
		LOGGER.info("handling emitFindAllPFVArControllerType2UserDefined" );
		
	    queryUpdateEmitter.emit(FindAllPFVArControllerType2UserDefinedQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType2UserDefinedProjector.class.getName());

}
