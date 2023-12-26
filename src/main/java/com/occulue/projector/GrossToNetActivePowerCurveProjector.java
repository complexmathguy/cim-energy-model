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
 * Projector for GrossToNetActivePowerCurve as outlined for the CQRS pattern.  All event handling and query handling related to GrossToNetActivePowerCurve are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by GrossToNetActivePowerCurveAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("grossToNetActivePowerCurve")
@Component("grossToNetActivePowerCurve-projector")
public class GrossToNetActivePowerCurveProjector extends GrossToNetActivePowerCurveEntityProjector {
		
	// core constructor
	public GrossToNetActivePowerCurveProjector(GrossToNetActivePowerCurveRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateGrossToNetActivePowerCurveEvent
     */
    @EventHandler( payloadType=CreateGrossToNetActivePowerCurveEvent.class )
    public void handle( CreateGrossToNetActivePowerCurveEvent event) {
	    LOGGER.info("handling CreateGrossToNetActivePowerCurveEvent - " + event );
	    GrossToNetActivePowerCurve entity = new GrossToNetActivePowerCurve();
        entity.setGrossToNetActivePowerCurveId( event.getGrossToNetActivePowerCurveId() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGrossToNetActivePowerCurve( entity );
    }

    /*
     * @param	event UpdateGrossToNetActivePowerCurveEvent
     */
    @EventHandler( payloadType=UpdateGrossToNetActivePowerCurveEvent.class )
    public void handle( UpdateGrossToNetActivePowerCurveEvent event) {
    	LOGGER.info("handling UpdateGrossToNetActivePowerCurveEvent - " + event );
    	
	    GrossToNetActivePowerCurve entity = new GrossToNetActivePowerCurve();
        entity.setGrossToNetActivePowerCurveId( event.getGrossToNetActivePowerCurveId() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindGrossToNetActivePowerCurve( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGrossToNetActivePowerCurve( entity );        
    }
    
    /*
     * @param	event DeleteGrossToNetActivePowerCurveEvent
     */
    @EventHandler( payloadType=DeleteGrossToNetActivePowerCurveEvent.class )
    public void handle( DeleteGrossToNetActivePowerCurveEvent event) {
    	LOGGER.info("handling DeleteGrossToNetActivePowerCurveEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	GrossToNetActivePowerCurve entity = delete( event.getGrossToNetActivePowerCurveId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllGrossToNetActivePowerCurve( entity );

    }    




    /**
     * Method to retrieve the GrossToNetActivePowerCurve via an GrossToNetActivePowerCurvePrimaryKey.
     * @param 	id Long
     * @return 	GrossToNetActivePowerCurve
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public GrossToNetActivePowerCurve handle( FindGrossToNetActivePowerCurveQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getGrossToNetActivePowerCurveId() );
    }
    
    /**
     * Method to retrieve a collection of all GrossToNetActivePowerCurves
     *
     * @param	query	FindAllGrossToNetActivePowerCurveQuery 
     * @return 	List<GrossToNetActivePowerCurve> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<GrossToNetActivePowerCurve> handle( FindAllGrossToNetActivePowerCurveQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindGrossToNetActivePowerCurve, 
	 * but only if the id matches
	 * 
	 * @param		entity	GrossToNetActivePowerCurve
	 */
	protected void emitFindGrossToNetActivePowerCurve( GrossToNetActivePowerCurve entity ) {
		LOGGER.info("handling emitFindGrossToNetActivePowerCurve" );
		
	    queryUpdateEmitter.emit(FindGrossToNetActivePowerCurveQuery.class,
	                            query -> query.getFilter().getGrossToNetActivePowerCurveId().equals(entity.getGrossToNetActivePowerCurveId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllGrossToNetActivePowerCurve
	 * 
	 * @param		entity	GrossToNetActivePowerCurve
	 */
	protected void emitFindAllGrossToNetActivePowerCurve( GrossToNetActivePowerCurve entity ) {
		LOGGER.info("handling emitFindAllGrossToNetActivePowerCurve" );
		
	    queryUpdateEmitter.emit(FindAllGrossToNetActivePowerCurveQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(GrossToNetActivePowerCurveProjector.class.getName());

}
