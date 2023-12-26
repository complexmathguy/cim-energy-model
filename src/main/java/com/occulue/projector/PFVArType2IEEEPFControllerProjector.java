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
 * Projector for PFVArType2IEEEPFController as outlined for the CQRS pattern.  All event handling and query handling related to PFVArType2IEEEPFController are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArType2IEEEPFControllerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArType2IEEEPFController")
@Component("pFVArType2IEEEPFController-projector")
public class PFVArType2IEEEPFControllerProjector extends PFVArType2IEEEPFControllerEntityProjector {
		
	// core constructor
	public PFVArType2IEEEPFControllerProjector(PFVArType2IEEEPFControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArType2IEEEPFControllerEvent
     */
    @EventHandler( payloadType=CreatePFVArType2IEEEPFControllerEvent.class )
    public void handle( CreatePFVArType2IEEEPFControllerEvent event) {
	    LOGGER.info("handling CreatePFVArType2IEEEPFControllerEvent - " + event );
	    PFVArType2IEEEPFController entity = new PFVArType2IEEEPFController();
        entity.setPFVArType2IEEEPFControllerId( event.getPFVArType2IEEEPFControllerId() );
        entity.setExlon( event.getExlon() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setPfref( event.getPfref() );
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
        emitFindAllPFVArType2IEEEPFController( entity );
    }

    /*
     * @param	event UpdatePFVArType2IEEEPFControllerEvent
     */
    @EventHandler( payloadType=UpdatePFVArType2IEEEPFControllerEvent.class )
    public void handle( UpdatePFVArType2IEEEPFControllerEvent event) {
    	LOGGER.info("handling UpdatePFVArType2IEEEPFControllerEvent - " + event );
    	
	    PFVArType2IEEEPFController entity = new PFVArType2IEEEPFController();
        entity.setPFVArType2IEEEPFControllerId( event.getPFVArType2IEEEPFControllerId() );
        entity.setExlon( event.getExlon() );
        entity.setKi( event.getKi() );
        entity.setKp( event.getKp() );
        entity.setPfref( event.getPfref() );
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
        emitFindPFVArType2IEEEPFController( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2IEEEPFController( entity );        
    }
    
    /*
     * @param	event DeletePFVArType2IEEEPFControllerEvent
     */
    @EventHandler( payloadType=DeletePFVArType2IEEEPFControllerEvent.class )
    public void handle( DeletePFVArType2IEEEPFControllerEvent event) {
    	LOGGER.info("handling DeletePFVArType2IEEEPFControllerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArType2IEEEPFController entity = delete( event.getPFVArType2IEEEPFControllerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType2IEEEPFController( entity );

    }    




    /**
     * Method to retrieve the PFVArType2IEEEPFController via an PFVArType2IEEEPFControllerPrimaryKey.
     * @param 	id Long
     * @return 	PFVArType2IEEEPFController
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArType2IEEEPFController handle( FindPFVArType2IEEEPFControllerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArType2IEEEPFControllerId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArType2IEEEPFControllers
     *
     * @param	query	FindAllPFVArType2IEEEPFControllerQuery 
     * @return 	List<PFVArType2IEEEPFController> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArType2IEEEPFController> handle( FindAllPFVArType2IEEEPFControllerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArType2IEEEPFController, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArType2IEEEPFController
	 */
	protected void emitFindPFVArType2IEEEPFController( PFVArType2IEEEPFController entity ) {
		LOGGER.info("handling emitFindPFVArType2IEEEPFController" );
		
	    queryUpdateEmitter.emit(FindPFVArType2IEEEPFControllerQuery.class,
	                            query -> query.getFilter().getPFVArType2IEEEPFControllerId().equals(entity.getPFVArType2IEEEPFControllerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArType2IEEEPFController
	 * 
	 * @param		entity	PFVArType2IEEEPFController
	 */
	protected void emitFindAllPFVArType2IEEEPFController( PFVArType2IEEEPFController entity ) {
		LOGGER.info("handling emitFindAllPFVArType2IEEEPFController" );
		
	    queryUpdateEmitter.emit(FindAllPFVArType2IEEEPFControllerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArType2IEEEPFControllerProjector.class.getName());

}
