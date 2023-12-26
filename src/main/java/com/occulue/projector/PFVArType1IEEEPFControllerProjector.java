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
 * Projector for PFVArType1IEEEPFController as outlined for the CQRS pattern.  All event handling and query handling related to PFVArType1IEEEPFController are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PFVArType1IEEEPFControllerAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("pFVArType1IEEEPFController")
@Component("pFVArType1IEEEPFController-projector")
public class PFVArType1IEEEPFControllerProjector extends PFVArType1IEEEPFControllerEntityProjector {
		
	// core constructor
	public PFVArType1IEEEPFControllerProjector(PFVArType1IEEEPFControllerRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePFVArType1IEEEPFControllerEvent
     */
    @EventHandler( payloadType=CreatePFVArType1IEEEPFControllerEvent.class )
    public void handle( CreatePFVArType1IEEEPFControllerEvent event) {
	    LOGGER.info("handling CreatePFVArType1IEEEPFControllerEvent - " + event );
	    PFVArType1IEEEPFController entity = new PFVArType1IEEEPFController();
        entity.setPFVArType1IEEEPFControllerId( event.getPFVArType1IEEEPFControllerId() );
        entity.setOvex( event.getOvex() );
        entity.setTpfc( event.getTpfc() );
        entity.setVitmin( event.getVitmin() );
        entity.setVpf( event.getVpf() );
        entity.setVpfcbw( event.getVpfcbw() );
        entity.setVpfref( event.getVpfref() );
        entity.setVvtmax( event.getVvtmax() );
        entity.setVvtmin( event.getVvtmin() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEPFController( entity );
    }

    /*
     * @param	event UpdatePFVArType1IEEEPFControllerEvent
     */
    @EventHandler( payloadType=UpdatePFVArType1IEEEPFControllerEvent.class )
    public void handle( UpdatePFVArType1IEEEPFControllerEvent event) {
    	LOGGER.info("handling UpdatePFVArType1IEEEPFControllerEvent - " + event );
    	
	    PFVArType1IEEEPFController entity = new PFVArType1IEEEPFController();
        entity.setPFVArType1IEEEPFControllerId( event.getPFVArType1IEEEPFControllerId() );
        entity.setOvex( event.getOvex() );
        entity.setTpfc( event.getTpfc() );
        entity.setVitmin( event.getVitmin() );
        entity.setVpf( event.getVpf() );
        entity.setVpfcbw( event.getVpfcbw() );
        entity.setVpfref( event.getVpfref() );
        entity.setVvtmax( event.getVvtmax() );
        entity.setVvtmin( event.getVvtmin() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPFVArType1IEEEPFController( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEPFController( entity );        
    }
    
    /*
     * @param	event DeletePFVArType1IEEEPFControllerEvent
     */
    @EventHandler( payloadType=DeletePFVArType1IEEEPFControllerEvent.class )
    public void handle( DeletePFVArType1IEEEPFControllerEvent event) {
    	LOGGER.info("handling DeletePFVArType1IEEEPFControllerEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PFVArType1IEEEPFController entity = delete( event.getPFVArType1IEEEPFControllerId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPFVArType1IEEEPFController( entity );

    }    




    /**
     * Method to retrieve the PFVArType1IEEEPFController via an PFVArType1IEEEPFControllerPrimaryKey.
     * @param 	id Long
     * @return 	PFVArType1IEEEPFController
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PFVArType1IEEEPFController handle( FindPFVArType1IEEEPFControllerQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPFVArType1IEEEPFControllerId() );
    }
    
    /**
     * Method to retrieve a collection of all PFVArType1IEEEPFControllers
     *
     * @param	query	FindAllPFVArType1IEEEPFControllerQuery 
     * @return 	List<PFVArType1IEEEPFController> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PFVArType1IEEEPFController> handle( FindAllPFVArType1IEEEPFControllerQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPFVArType1IEEEPFController, 
	 * but only if the id matches
	 * 
	 * @param		entity	PFVArType1IEEEPFController
	 */
	protected void emitFindPFVArType1IEEEPFController( PFVArType1IEEEPFController entity ) {
		LOGGER.info("handling emitFindPFVArType1IEEEPFController" );
		
	    queryUpdateEmitter.emit(FindPFVArType1IEEEPFControllerQuery.class,
	                            query -> query.getFilter().getPFVArType1IEEEPFControllerId().equals(entity.getPFVArType1IEEEPFControllerId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPFVArType1IEEEPFController
	 * 
	 * @param		entity	PFVArType1IEEEPFController
	 */
	protected void emitFindAllPFVArType1IEEEPFController( PFVArType1IEEEPFController entity ) {
		LOGGER.info("handling emitFindAllPFVArType1IEEEPFController" );
		
	    queryUpdateEmitter.emit(FindAllPFVArType1IEEEPFControllerQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PFVArType1IEEEPFControllerProjector.class.getName());

}
