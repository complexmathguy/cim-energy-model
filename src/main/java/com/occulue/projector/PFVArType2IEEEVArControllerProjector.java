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
 * Projector for PFVArType2IEEEVArController as outlined for the CQRS pattern.  All event handling and query handling related to PFVArType2IEEEVArController are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArType2IEEEVArControllerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArType2IEEEVArController")
@Component("pFVArType2IEEEVArController-projector")
public class PFVArType2IEEEVArControllerProjector extends PFVArType2IEEEVArControllerEntityProjector {
		
	// core constructor
	public PFVArType2IEEEVArControllerProjector(PFVArType2IEEEVArControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArType2IEEEVArControllerEvent
     */
    @EventHandler( payloadType=CreatePFVArType2IEEEVArControllerEvent.class )
    public void handle( CreatePFVArType2IEEEVArControllerEvent event) {
	    LOGGER.info("handling CreatePFVArType2IEEEVArControllerEvent - " + event );
	    PFVArType2IEEEVArController entity = new PFVArType2IEEEVArController();
        entity.setPFVArType2IEEEVArControllerId( event.getPFVArType2IEEEVArControllerId() );
        entity.setExlon( event.getExlon() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setQref( event.getQref() );
        entity.setVclmt( event.getVclmt() );
        entity.setVref( event.getVref() );
        entity.setVs( event.getVs() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2IEEEVArController( entity );
    }

    /*
     * @param	event UpdatePFVArType2IEEEVArControllerEvent
     */
    @EventHandler( payloadType=UpdatePFVArType2IEEEVArControllerEvent.class )
    public void handle( UpdatePFVArType2IEEEVArControllerEvent event) {
    	LOGGER.info("handling UpdatePFVArType2IEEEVArControllerEvent - " + event );
    	
	    PFVArType2IEEEVArController entity = new PFVArType2IEEEVArController();
        entity.setPFVArType2IEEEVArControllerId( event.getPFVArType2IEEEVArControllerId() );
        entity.setExlon( event.getExlon() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setQref( event.getQref() );
        entity.setVclmt( event.getVclmt() );
        entity.setVref( event.getVref() );
        entity.setVs( event.getVs() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArType2IEEEVArController( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2IEEEVArController( entity );        
    }
    
    /*
     * @param	event DeletePFVArType2IEEEVArControllerEvent
     */
    @EventHandler( payloadType=DeletePFVArType2IEEEVArControllerEvent.class )
    public void handle( DeletePFVArType2IEEEVArControllerEvent event) {
    	LOGGER.info("handling DeletePFVArType2IEEEVArControllerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArType2IEEEVArController entity = delete( event.getPFVArType2IEEEVArControllerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2IEEEVArController( entity );

    }    




    /**
     * Method to retrieve the PFVArType2IEEEVArController via an PFVArType2IEEEVArControllerPrimaryKey.
     * @param 	id Long
     * @return 	PFVArType2IEEEVArController
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArType2IEEEVArController handle( FindPFVArType2IEEEVArControllerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArType2IEEEVArControllerId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2IEEEVArControllers
     *
     * @param	query	FindAllPFVArType2IEEEVArControllerQuery 
     * @return 	List<PFVArType2IEEEVArController> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArType2IEEEVArController> handle( FindAllPFVArType2IEEEVArControllerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArType2IEEEVArController, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArType2IEEEVArController
	 */
	protected void emitFindPFVArType2IEEEVArController( PFVArType2IEEEVArController entity ) {
		LOGGER.info("handling emitFindPFVArType2IEEEVArController" );
		
	    queryUpdateEmitter.emit(FindPFVArType2IEEEVArControllerQuery.class,
	                            query -> query.getFilter().getPFVArType2IEEEVArControllerId().equals(entity.getPFVArType2IEEEVArControllerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArType2IEEEVArController
	 * 
	 * @param		entity	PFVArType2IEEEVArController
	 */
	protected void emitFindAllPFVArType2IEEEVArController( PFVArType2IEEEVArController entity ) {
		LOGGER.info("handling emitFindAllPFVArType2IEEEVArController" );
		
	    queryUpdateEmitter.emit(FindAllPFVArType2IEEEVArControllerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEVArControllerProjector.class.getName());

}
