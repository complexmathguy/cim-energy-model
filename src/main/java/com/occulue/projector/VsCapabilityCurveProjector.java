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
 * Projector for VsCapabilityCurve as outlined for the CQRS pattern.  All event handling and query handling related to VsCapabilityCurve are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by VsCapabilityCurveAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("vsCapabilityCurve")
@Component("vsCapabilityCurve-projector")
public class VsCapabilityCurveProjector extends VsCapabilityCurveEntityProjector {
		
	// core constructor
	public VsCapabilityCurveProjector(VsCapabilityCurveRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateVsCapabilityCurveEvent
     */
    @EventHandler( payloadType=CreateVsCapabilityCurveEvent.class )
    public void handle( CreateVsCapabilityCurveEvent event) {
	    LOGGER.info("handling CreateVsCapabilityCurveEvent - " + event );
	    VsCapabilityCurve entity = new VsCapabilityCurve();
        entity.setVsCapabilityCurveId( event.getVsCapabilityCurveId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsCapabilityCurve( entity );
    }

    /*
     * @param	event UpdateVsCapabilityCurveEvent
     */
    @EventHandler( payloadType=UpdateVsCapabilityCurveEvent.class )
    public void handle( UpdateVsCapabilityCurveEvent event) {
    	LOGGER.info("handling UpdateVsCapabilityCurveEvent - " + event );
    	
	    VsCapabilityCurve entity = new VsCapabilityCurve();
        entity.setVsCapabilityCurveId( event.getVsCapabilityCurveId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindVsCapabilityCurve( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsCapabilityCurve( entity );        
    }
    
    /*
     * @param	event DeleteVsCapabilityCurveEvent
     */
    @EventHandler( payloadType=DeleteVsCapabilityCurveEvent.class )
    public void handle( DeleteVsCapabilityCurveEvent event) {
    	LOGGER.info("handling DeleteVsCapabilityCurveEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	VsCapabilityCurve entity = delete( event.getVsCapabilityCurveId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllVsCapabilityCurve( entity );

    }    




    /**
     * Method to retrieve the VsCapabilityCurve via an VsCapabilityCurvePrimaryKey.
     * @param 	id Long
     * @return 	VsCapabilityCurve
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public VsCapabilityCurve handle( FindVsCapabilityCurveQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getVsCapabilityCurveId() );
    }
    
    /**
     * Method to retrieve a collection of all VsCapabilityCurves
     *
     * @param	query	FindAllVsCapabilityCurveQuery 
     * @return 	List<VsCapabilityCurve> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<VsCapabilityCurve> handle( FindAllVsCapabilityCurveQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindVsCapabilityCurve, 
	 * but only if the id matches
	 * 
	 * @param		entity	VsCapabilityCurve
	 */
	protected void emitFindVsCapabilityCurve( VsCapabilityCurve entity ) {
		LOGGER.info("handling emitFindVsCapabilityCurve" );
		
	    queryUpdateEmitter.emit(FindVsCapabilityCurveQuery.class,
	                            query -> query.getFilter().getVsCapabilityCurveId().equals(entity.getVsCapabilityCurveId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllVsCapabilityCurve
	 * 
	 * @param		entity	VsCapabilityCurve
	 */
	protected void emitFindAllVsCapabilityCurve( VsCapabilityCurve entity ) {
		LOGGER.info("handling emitFindAllVsCapabilityCurve" );
		
	    queryUpdateEmitter.emit(FindAllVsCapabilityCurveQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(VsCapabilityCurveProjector.class.getName());

}
