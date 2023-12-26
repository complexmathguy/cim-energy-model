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
 * Projector for Curve as outlined for the CQRS pattern.  All event handling and query handling related to Curve are invoked here
 * and dispersed as an event to be handled elsewhere.
 * 
 * Commands are handled by CurveAggregate
 * 
 * @author your_name_here
 *
 */
//@ProcessingGroup("curve")
@Component("curve-projector")
public class CurveProjector extends CurveEntityProjector {
		
	// core constructor
	public CurveProjector(CurveRepository repository, QueryUpdateEmitter queryUpdateEmitter ) {
        super(repository);
        this.queryUpdateEmitter = queryUpdateEmitter;
    }	

	/*
     * @param	event CreateCurveEvent
     */
    @EventHandler( payloadType=CreateCurveEvent.class )
    public void handle( CreateCurveEvent event) {
	    LOGGER.info("handling CreateCurveEvent - " + event );
	    Curve entity = new Curve();
        entity.setCurveId( event.getCurveId() );
        entity.setCurveStyle( event.getCurveStyle() );
        entity.setXUnit( event.getXUnit() );
        entity.setY1Unit( event.getY1Unit() );
        entity.setY2Unit( event.getY2Unit() );
	    
    	// ------------------------------------------
    	// persist a new one
    	// ------------------------------------------ 
	    create(entity);
        
        // ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurve( entity );
    }

    /*
     * @param	event UpdateCurveEvent
     */
    @EventHandler( payloadType=UpdateCurveEvent.class )
    public void handle( UpdateCurveEvent event) {
    	LOGGER.info("handling UpdateCurveEvent - " + event );
    	
	    Curve entity = new Curve();
        entity.setCurveId( event.getCurveId() );
        entity.setCurveStyle( event.getCurveStyle() );
        entity.setXUnit( event.getXUnit() );
        entity.setY1Unit( event.getY1Unit() );
        entity.setY2Unit( event.getY2Unit() );
 
    	// ------------------------------------------
    	// save with an existing instance
    	// ------------------------------------------ 
		update(entity);

    	// ------------------------------------------
    	// emit to subscribers that find one
    	// ------------------------------------------    	
        emitFindCurve( entity );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurve( entity );        
    }
    
    /*
     * @param	event DeleteCurveEvent
     */
    @EventHandler( payloadType=DeleteCurveEvent.class )
    public void handle( DeleteCurveEvent event) {
    	LOGGER.info("handling DeleteCurveEvent - " + event );
    	
    	// ------------------------------------------
    	// delete delegation
    	// ------------------------------------------
    	Curve entity = delete( event.getCurveId() );

    	// ------------------------------------------
    	// emit to subscribers that find all
    	// ------------------------------------------    	
        emitFindAllCurve( entity );

    }    




    /**
     * Method to retrieve the Curve via an CurvePrimaryKey.
     * @param 	id Long
     * @return 	Curve
     * @exception ProcessingException - Thrown if processing any related problems
     * @exception IllegalArgumentException 
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public Curve handle( FindCurveQuery query ) 
    throws ProcessingException, IllegalArgumentException {
    	return find( query.getFilter().getCurveId() );
    }
    
    /**
     * Method to retrieve a collection of all Curves
     *
     * @param	query	FindAllCurveQuery 
     * @return 	List<Curve> 
     * @exception ProcessingException Thrown if any problems
     */
    @SuppressWarnings("unused")
    @QueryHandler
    public List<Curve> handle( FindAllCurveQuery query ) throws ProcessingException {
    	return findAll( query );
    }


	/**
	 * emit to subscription queries of type FindCurve, 
	 * but only if the id matches
	 * 
	 * @param		entity	Curve
	 */
	protected void emitFindCurve( Curve entity ) {
		LOGGER.info("handling emitFindCurve" );
		
	    queryUpdateEmitter.emit(FindCurveQuery.class,
	                            query -> query.getFilter().getCurveId().equals(entity.getCurveId()),
	                            entity);
	}
	
	/**
	 * unconditionally emit to subscription queries of type FindAllCurve
	 * 
	 * @param		entity	Curve
	 */
	protected void emitFindAllCurve( Curve entity ) {
		LOGGER.info("handling emitFindAllCurve" );
		
	    queryUpdateEmitter.emit(FindAllCurveQuery.class,
	                            query -> true,
	                            entity);
	}


	//--------------------------------------------------
    // attributes
    // --------------------------------------------------
	@Autowired
	private final QueryUpdateEmitter queryUpdateEmitter;
    private static final Logger LOGGER 	= Logger.getLogger(CurveProjector.class.getName());

}
