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
 * Projector for PFVArControllerType1Dynamics as outlined for the CQRS pattern.  All event handling and query handling related to PFVArControllerType1Dynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArControllerType1DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArControllerType1Dynamics")
@Component("pFVArControllerType1Dynamics-projector")
public class PFVArControllerType1DynamicsProjector extends PFVArControllerType1DynamicsEntityProjector {
		
	// core constructor
	public PFVArControllerType1DynamicsProjector(PFVArControllerType1DynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArControllerType1DynamicsEvent
     */
    @EventHandler( payloadType=CreatePFVArControllerType1DynamicsEvent.class )
    public void handle( CreatePFVArControllerType1DynamicsEvent event) {
	    LOGGER.info("handling CreatePFVArControllerType1DynamicsEvent - " + event );
	    PFVArControllerType1Dynamics entity = new PFVArControllerType1Dynamics();
        entity.setPFVArControllerType1DynamicsId( event.getPFVArControllerType1DynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType1Dynamics( entity );
    }

    /*
     * @param	event UpdatePFVArControllerType1DynamicsEvent
     */
    @EventHandler( payloadType=UpdatePFVArControllerType1DynamicsEvent.class )
    public void handle( UpdatePFVArControllerType1DynamicsEvent event) {
    	LOGGER.info("handling UpdatePFVArControllerType1DynamicsEvent - " + event );
    	
	    PFVArControllerType1Dynamics entity = new PFVArControllerType1Dynamics();
        entity.setPFVArControllerType1DynamicsId( event.getPFVArControllerType1DynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArControllerType1Dynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType1Dynamics( entity );        
    }
    
    /*
     * @param	event DeletePFVArControllerType1DynamicsEvent
     */
    @EventHandler( payloadType=DeletePFVArControllerType1DynamicsEvent.class )
    public void handle( DeletePFVArControllerType1DynamicsEvent event) {
    	LOGGER.info("handling DeletePFVArControllerType1DynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArControllerType1Dynamics entity = delete( event.getPFVArControllerType1DynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType1Dynamics( entity );

    }    




    /**
     * Method to retrieve the PFVArControllerType1Dynamics via an PFVArControllerType1DynamicsPrimaryKey.
     * @param 	id Long
     * @return 	PFVArControllerType1Dynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArControllerType1Dynamics handle( FindPFVArControllerType1DynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArControllerType1DynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArControllerType1Dynamicss
     *
     * @param	query	FindAllPFVArControllerType1DynamicsQuery 
     * @return 	List<PFVArControllerType1Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArControllerType1Dynamics> handle( FindAllPFVArControllerType1DynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArControllerType1Dynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArControllerType1Dynamics
	 */
	protected void emitFindPFVArControllerType1Dynamics( PFVArControllerType1Dynamics entity ) {
		LOGGER.info("handling emitFindPFVArControllerType1Dynamics" );
		
	    queryUpdateEmitter.emit(FindPFVArControllerType1DynamicsQuery.class,
	                            query -> query.getFilter().getPFVArControllerType1DynamicsId().equals(entity.getPFVArControllerType1DynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArControllerType1Dynamics
	 * 
	 * @param		entity	PFVArControllerType1Dynamics
	 */
	protected void emitFindAllPFVArControllerType1Dynamics( PFVArControllerType1Dynamics entity ) {
		LOGGER.info("handling emitFindAllPFVArControllerType1Dynamics" );
		
	    queryUpdateEmitter.emit(FindAllPFVArControllerType1DynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType1DynamicsProjector.class.getName());

}
