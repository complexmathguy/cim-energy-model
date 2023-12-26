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
 * Projector for PFVArType1IEEEVArController as outlined for the CQRS pattern.  All event handling and query handling related to PFVArType1IEEEVArController are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArType1IEEEVArControllerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArType1IEEEVArController")
@Component("pFVArType1IEEEVArController-projector")
public class PFVArType1IEEEVArControllerProjector extends PFVArType1IEEEVArControllerEntityProjector {
		
	// core constructor
	public PFVArType1IEEEVArControllerProjector(PFVArType1IEEEVArControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArType1IEEEVArControllerEvent
     */
    @EventHandler( payloadType=CreatePFVArType1IEEEVArControllerEvent.class )
    public void handle( CreatePFVArType1IEEEVArControllerEvent event) {
	    LOGGER.info("handling CreatePFVArType1IEEEVArControllerEvent - " + event );
	    PFVArType1IEEEVArController entity = new PFVArType1IEEEVArController();
        entity.setPFVArType1IEEEVArControllerId( event.getPFVArType1IEEEVArControllerId() );
        entity.setTvarc( event.getTvarc() );
        entity.setVvar( event.getVvar() );
        entity.setVvarcbw( event.getVvarcbw() );
        entity.setVvarref( event.getVvarref() );
        entity.setVvtmax( event.getVvtmax() );
        entity.setVvtmin( event.getVvtmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEVArController( entity );
    }

    /*
     * @param	event UpdatePFVArType1IEEEVArControllerEvent
     */
    @EventHandler( payloadType=UpdatePFVArType1IEEEVArControllerEvent.class )
    public void handle( UpdatePFVArType1IEEEVArControllerEvent event) {
    	LOGGER.info("handling UpdatePFVArType1IEEEVArControllerEvent - " + event );
    	
	    PFVArType1IEEEVArController entity = new PFVArType1IEEEVArController();
        entity.setPFVArType1IEEEVArControllerId( event.getPFVArType1IEEEVArControllerId() );
        entity.setTvarc( event.getTvarc() );
        entity.setVvar( event.getVvar() );
        entity.setVvarcbw( event.getVvarcbw() );
        entity.setVvarref( event.getVvarref() );
        entity.setVvtmax( event.getVvtmax() );
        entity.setVvtmin( event.getVvtmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArType1IEEEVArController( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEVArController( entity );        
    }
    
    /*
     * @param	event DeletePFVArType1IEEEVArControllerEvent
     */
    @EventHandler( payloadType=DeletePFVArType1IEEEVArControllerEvent.class )
    public void handle( DeletePFVArType1IEEEVArControllerEvent event) {
    	LOGGER.info("handling DeletePFVArType1IEEEVArControllerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArType1IEEEVArController entity = delete( event.getPFVArType1IEEEVArControllerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEVArController( entity );

    }    




    /**
     * Method to retrieve the PFVArType1IEEEVArController via an PFVArType1IEEEVArControllerPrimaryKey.
     * @param 	id Long
     * @return 	PFVArType1IEEEVArController
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArType1IEEEVArController handle( FindPFVArType1IEEEVArControllerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArType1IEEEVArControllerId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArType1IEEEVArControllers
     *
     * @param	query	FindAllPFVArType1IEEEVArControllerQuery 
     * @return 	List<PFVArType1IEEEVArController> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArType1IEEEVArController> handle( FindAllPFVArType1IEEEVArControllerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArType1IEEEVArController, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArType1IEEEVArController
	 */
	protected void emitFindPFVArType1IEEEVArController( PFVArType1IEEEVArController entity ) {
		LOGGER.info("handling emitFindPFVArType1IEEEVArController" );
		
	    queryUpdateEmitter.emit(FindPFVArType1IEEEVArControllerQuery.class,
	                            query -> query.getFilter().getPFVArType1IEEEVArControllerId().equals(entity.getPFVArType1IEEEVArControllerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArType1IEEEVArController
	 * 
	 * @param		entity	PFVArType1IEEEVArController
	 */
	protected void emitFindAllPFVArType1IEEEVArController( PFVArType1IEEEVArController entity ) {
		LOGGER.info("handling emitFindAllPFVArType1IEEEVArController" );
		
	    queryUpdateEmitter.emit(FindAllPFVArType1IEEEVArControllerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEVArControllerProjector.class.getName());

}
