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
 * Projector for PFVArControllerType2Dynamics as outlined for the CQRS pattern.  All event handling and query handling related to PFVArControllerType2Dynamics are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArControllerType2DynamicsAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArControllerType2Dynamics")
@Component("pFVArControllerType2Dynamics-projector")
public class PFVArControllerType2DynamicsProjector extends PFVArControllerType2DynamicsEntityProjector {
		
	// core constructor
	public PFVArControllerType2DynamicsProjector(PFVArControllerType2DynamicsRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArControllerType2DynamicsEvent
     */
    @EventHandler( payloadType=CreatePFVArControllerType2DynamicsEvent.class )
    public void handle( CreatePFVArControllerType2DynamicsEvent event) {
	    LOGGER.info("handling CreatePFVArControllerType2DynamicsEvent - " + event );
	    PFVArControllerType2Dynamics entity = new PFVArControllerType2Dynamics();
        entity.setPFVArControllerType2DynamicsId( event.getPFVArControllerType2DynamicsId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2Dynamics( entity );
    }

    /*
     * @param	event UpdatePFVArControllerType2DynamicsEvent
     */
    @EventHandler( payloadType=UpdatePFVArControllerType2DynamicsEvent.class )
    public void handle( UpdatePFVArControllerType2DynamicsEvent event) {
    	LOGGER.info("handling UpdatePFVArControllerType2DynamicsEvent - " + event );
    	
	    PFVArControllerType2Dynamics entity = new PFVArControllerType2Dynamics();
        entity.setPFVArControllerType2DynamicsId( event.getPFVArControllerType2DynamicsId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArControllerType2Dynamics( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2Dynamics( entity );        
    }
    
    /*
     * @param	event DeletePFVArControllerType2DynamicsEvent
     */
    @EventHandler( payloadType=DeletePFVArControllerType2DynamicsEvent.class )
    public void handle( DeletePFVArControllerType2DynamicsEvent event) {
    	LOGGER.info("handling DeletePFVArControllerType2DynamicsEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArControllerType2Dynamics entity = delete( event.getPFVArControllerType2DynamicsId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArControllerType2Dynamics( entity );

    }    




    /**
     * Method to retrieve the PFVArControllerType2Dynamics via an PFVArControllerType2DynamicsPrimaryKey.
     * @param 	id Long
     * @return 	PFVArControllerType2Dynamics
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArControllerType2Dynamics handle( FindPFVArControllerType2DynamicsQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArControllerType2DynamicsId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArControllerType2Dynamicss
     *
     * @param	query	FindAllPFVArControllerType2DynamicsQuery 
     * @return 	List<PFVArControllerType2Dynamics> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArControllerType2Dynamics> handle( FindAllPFVArControllerType2DynamicsQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArControllerType2Dynamics, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArControllerType2Dynamics
	 */
	protected void emitFindPFVArControllerType2Dynamics( PFVArControllerType2Dynamics entity ) {
		LOGGER.info("handling emitFindPFVArControllerType2Dynamics" );
		
	    queryUpdateEmitter.emit(FindPFVArControllerType2DynamicsQuery.class,
	                            query -> query.getFilter().getPFVArControllerType2DynamicsId().equals(entity.getPFVArControllerType2DynamicsId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArControllerType2Dynamics
	 * 
	 * @param		entity	PFVArControllerType2Dynamics
	 */
	protected void emitFindAllPFVArControllerType2Dynamics( PFVArControllerType2Dynamics entity ) {
		LOGGER.info("handling emitFindAllPFVArControllerType2Dynamics" );
		
	    queryUpdateEmitter.emit(FindAllPFVArControllerType2DynamicsQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArControllerType2DynamicsProjector.class.getName());

}
