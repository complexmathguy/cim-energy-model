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
 * Projector for PetersenCoil as outlined for the CQRS pattern.  All event handling and query handling related to PetersenCoil are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by PetersenCoilAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("petersenCoil")
@Component("petersenCoil-projector")
public class PetersenCoilProjector extends PetersenCoilEntityProjector {
		
	// core constructor
	public PetersenCoilProjector(PetersenCoilRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreatePetersenCoilEvent
     */
    @EventHandler( payloadType=CreatePetersenCoilEvent.class )
    public void handle( CreatePetersenCoilEvent event) {
	    LOGGER.info("handling CreatePetersenCoilEvent - " + event );
	    PetersenCoil entity = new PetersenCoil();
        entity.setPetersenCoilId( event.getPetersenCoilId() );
        entity.setMode( event.getMode() );
        entity.setNominalU( event.getNominalU() );
        entity.setOffsetCurrent( event.getOffsetCurrent() );
        entity.setPositionCurrent( event.getPositionCurrent() );
        entity.setXGroundMax( event.getXGroundMax() );
        entity.setXGroundMin( event.getXGroundMin() );
        entity.setXGroundNominal( event.getXGroundNominal() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPetersenCoil( entity );
    }

    /*
     * @param	event UpdatePetersenCoilEvent
     */
    @EventHandler( payloadType=UpdatePetersenCoilEvent.class )
    public void handle( UpdatePetersenCoilEvent event) {
    	LOGGER.info("handling UpdatePetersenCoilEvent - " + event );
    	
	    PetersenCoil entity = new PetersenCoil();
        entity.setPetersenCoilId( event.getPetersenCoilId() );
        entity.setMode( event.getMode() );
        entity.setNominalU( event.getNominalU() );
        entity.setOffsetCurrent( event.getOffsetCurrent() );
        entity.setPositionCurrent( event.getPositionCurrent() );
        entity.setXGroundMax( event.getXGroundMax() );
        entity.setXGroundMin( event.getXGroundMin() );
        entity.setXGroundNominal( event.getXGroundNominal() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindPetersenCoil( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPetersenCoil( entity );        
    }
    
    /*
     * @param	event DeletePetersenCoilEvent
     */
    @EventHandler( payloadType=DeletePetersenCoilEvent.class )
    public void handle( DeletePetersenCoilEvent event) {
    	LOGGER.info("handling DeletePetersenCoilEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	PetersenCoil entity = delete( event.getPetersenCoilId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllPetersenCoil( entity );

    }    




    /**
     * Method to retrieve the PetersenCoil via an PetersenCoilPrimaryKey.
     * @param 	id Long
     * @return 	PetersenCoil
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public PetersenCoil handle( FindPetersenCoilQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getPetersenCoilId() );
    }
    
    /**
     * Method to retrieve a collection of all PetersenCoils
     *
     * @param	query	FindAllPetersenCoilQuery 
     * @return 	List<PetersenCoil> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<PetersenCoil> handle( FindAllPetersenCoilQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindPetersenCoil, 
	 * but only if the id matches
	 * 
	 * @param		entity	PetersenCoil
	 */
	protected void emitFindPetersenCoil( PetersenCoil entity ) {
		LOGGER.info("handling emitFindPetersenCoil" );
		
	    queryUpdateEmitter.emit(FindPetersenCoilQuery.class,
	                            query -> query.getFilter().getPetersenCoilId().equals(entity.getPetersenCoilId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllPetersenCoil
	 * 
	 * @param		entity	PetersenCoil
	 */
	protected void emitFindAllPetersenCoil( PetersenCoil entity ) {
		LOGGER.info("handling emitFindAllPetersenCoil" );
		
	    queryUpdateEmitter.emit(FindAllPetersenCoilQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(PetersenCoilProjector.class.getName());

}
